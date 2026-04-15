package com.jvmd.lyceum_backend.controller.web;

import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.service.StudentPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasRole('STUDENT')")
@RequiredArgsConstructor
public class StudentWebController {

    private final StudentPortfolioService portfolioService;

    @GetMapping("/portfolio")
    public String portfolioPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("currentUser", user.getUsername());
        model.addAttribute("userRoles", user.getRoles());
        portfolioService.findByUser(user).ifPresent(p -> model.addAttribute("portfolio", p));
        return "student/portfolio";
    }

    @PostMapping("/portfolio")
    public String savePortfolio(@RequestParam String studentName,
                                @RequestParam String grade,
                                @RequestParam(value = "file", required = false) MultipartFile file,
                                @AuthenticationPrincipal User user,
                                RedirectAttributes redirectAttributes) {
        try {
            portfolioService.createOrUpdateForStudent(user, studentName, grade, file);
            redirectAttributes.addFlashAttribute("success", "Портфолио сохранено!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/student/portfolio";
    }
}
