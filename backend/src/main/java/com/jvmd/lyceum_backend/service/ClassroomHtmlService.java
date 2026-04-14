package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomHtmlService {

    private final OllamaChatModel chatModel;

    @Value("${ollama.model:qwen2.5}")
    private String model;

    public String generateClassroomHtml(String title, List<Material> materials) {
        String prompt = buildPrompt(title, materials);

        ChatResponse response = chatModel.call(new Prompt(
                List.of(new UserMessage(prompt)),
                OllamaChatOptions.builder()
                        .model(model)
                        .build()
        ));

        return stripCodeFences(response.getResult().getOutput().getText());
    }

    private String stripCodeFences(String text) {
        if (text == null) return "";
        String stripped = text.strip();
        if (stripped.startsWith("```")) {
            int firstNewline = stripped.indexOf('\n');
            if (firstNewline != -1) stripped = stripped.substring(firstNewline + 1);
            if (stripped.endsWith("```")) stripped = stripped.substring(0, stripped.lastIndexOf("```"));
        }
        return stripped.strip();
    }

    private String buildPrompt(String title, List<Material> materials) {
        StringBuilder sb = new StringBuilder();
        sb.append("You are a strict HTML formatter. Your ONLY job is to wrap the provided data in clean HTML.\n");
        sb.append("Rules:\n");
        sb.append("- DO NOT invent, add, or assume ANY information not explicitly provided below.\n");
        sb.append("- DO NOT write descriptions, summaries, or any text that is not in the source data.\n");
        sb.append("- Use only inline CSS styles.\n");
        sb.append("- Output ONLY raw HTML starting with <section> — no explanation, no markdown, no code blocks.\n\n");

        sb.append("Classroom title: ").append(title).append("\n\n");

        if (materials == null || materials.isEmpty()) {
            sb.append("Materials: none\n\n");
        } else {
            sb.append("Materials (render each as a card with its exact title, description and file links):\n");
            for (Material m : materials) {
                sb.append("  - Title: ").append(m.getTitle()).append("\n");
                if (m.getDescription() != null && !m.getDescription().isBlank()) {
                    sb.append("    Description: ").append(m.getDescription()).append("\n");
                }
                if (!m.getFileUrls().isEmpty()) {
                    sb.append("    Files:\n");
                    for (String url : m.getFileUrls()) {
                        sb.append("      * ").append(url).append("\n");
                    }
                }
                sb.append("    Author: ").append(m.getAuthor().getUsername()).append("\n");
                sb.append("    Date: ").append(m.getCreatedAt().toLocalDate()).append("\n\n");
            }
        }

        sb.append("HTML requirements:\n");
        sb.append("- <h1> for the classroom title\n");
        sb.append("- Each material in its own <article> card\n");
        sb.append("- File links as <a href=\"URL\" download> showing only the filename\n");
        sb.append("- Clean school/education color scheme (white background, blue accents)\n");
        sb.append("- Show author username and date on each card\n");

        return sb.toString();
    }
}
