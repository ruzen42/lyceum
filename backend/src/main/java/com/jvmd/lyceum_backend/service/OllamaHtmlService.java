package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.MuseumExhibit;
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
public class OllamaHtmlService {

    private final OllamaChatModel chatModel;

    @Value("${ollama.model:qwen2.5}")
    private String model;

    public String generateExhibitHtml(
            String title,
            String description,
            List<String> imageUrls,
            List<MuseumExhibit> relatedExhibits
    ) {
        String prompt = buildPrompt(title, description, imageUrls, relatedExhibits);

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

    private String buildPrompt(
            String title,
            String description,
            List<String> imageUrls,
            List<MuseumExhibit> relatedExhibits
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("You are an HTML layout generator for a museum website. ");
        sb.append("Generate a beautiful, semantic, self-contained HTML SECTION (not a full page) for a museum exhibit. ");
        sb.append("Use only inline CSS styles. Include a responsive image gallery and navigation links to related exhibits. ");
        sb.append("Output ONLY the raw HTML — no explanation, no markdown code blocks, just HTML.\n\n");

        sb.append("Title: ").append(title).append("\n");
        sb.append("Description: ").append(description).append("\n\n");

        if (!imageUrls.isEmpty()) {
            sb.append("Images (embed each as <img src=\"URL\" style=\"max-width:100%;\">):\n");
            for (String url : imageUrls) {
                sb.append("  - ").append(url).append("\n");
            }
            sb.append("\n");
        }

        if (!relatedExhibits.isEmpty()) {
            sb.append("Related exhibits (create a navigation section with <a href=\"/api/museum-exhibit/{id}/html\"> links):\n");
            for (MuseumExhibit related : relatedExhibits) {
                sb.append("  - ID: ").append(related.getId())
                        .append(", Title: ").append(related.getTitle()).append("\n");
            }
            sb.append("\n");
        }

        sb.append("Requirements:\n");
        sb.append("- Display all images in a responsive grid gallery\n");
        sb.append("- Show the title as <h1> and description as <p>\n");
        sb.append("- If there are related exhibits, add a 'Related Exhibits' section with clickable cards linking to /api/museum-exhibit/{id}/html\n");
        sb.append("- Use a museum-appropriate dark/elegant color scheme\n");
        sb.append("- Output only the HTML section, starting with <section> or <article>\n");

        return sb.toString();
    }
}
