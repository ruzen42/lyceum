package com.jvmd.lyceum_backend.controller.web;

import com.jvmd.lyceum_backend.model.*;
import com.jvmd.lyceum_backend.payload.AdmissionApplicationRequest;
import com.jvmd.lyceum_backend.payload.SiteStatsResponse;
import com.jvmd.lyceum_backend.repository.*;
import com.jvmd.lyceum_backend.service.AdmissionService;
import com.jvmd.lyceum_backend.service.ClassroomService;
import com.jvmd.lyceum_backend.service.MuseumExhibitService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final NewsRepository newsRepository;
    private final AchievementRepository achievementRepository;
    private final StudentPortfolioRepository portfolioRepository;
    private final VacancyRepository vacancyRepository;
    private final AdmissionService admissionService;
    private final ClassroomService classroomService;
    private final MuseumExhibitService museumExhibitService;

    private void addUser(Model model, User user) {
        if (user != null) {
            model.addAttribute("currentUser", user.getUsername());
            model.addAttribute("userRoles", user.getRoles());
        }
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        List<News> allNews = newsRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("recentNews", allNews.stream().limit(6).toList());
        List<Achievement> allAch = achievementRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("recentAchievements", allAch.stream().limit(6).toList());
        model.addAttribute("stats", SiteStatsResponse.builder()
                .newsCount(newsRepository.count())
                .achievementsCount(achievementRepository.count())
                .portfolioCount(portfolioRepository.count())
                .applicationsCount(0L)
                .build());
        return "index";
    }

    @GetMapping("/news")
    public String news(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("newsList", newsRepository.findAllByOrderByCreatedAtDesc());
        return "news";
    }

    @GetMapping("/achievements")
    public String achievements(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("achievements", achievementRepository.findAllByOrderByCreatedAtDesc());
        return "achievements";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("portfolios", portfolioRepository.findAllByOrderByCreatedAtDesc());
        return "portfolio";
    }

    @GetMapping("/vacancies")
    public String vacancies(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("vacancies", vacancyRepository.findAllByActiveTrueOrderByCreatedAtDesc());
        return "vacancies";
    }

    @GetMapping("/admission")
    public String admissionForm(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        return "admission";
    }

    @PostMapping("/admission")
    public String submitAdmission(@ModelAttribute AdmissionApplicationRequest request,
                                  RedirectAttributes redirectAttributes) {
        try {
            admissionService.apply(request);
            redirectAttributes.addFlashAttribute("success",
                    "Ваша заявка успешно отправлена! Мы свяжемся с вами в ближайшее время.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при отправке заявки: " + e.getMessage());
        }
        return "redirect:/admission";
    }

    @GetMapping("/museum")
    public String museum(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("exhibits", museumExhibitService.getAll());
        return "museum/list";
    }

    @GetMapping("/museum/{id}")
    public String museumDetail(@PathVariable Long id, Model model,
                               @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("exhibit", museumExhibitService.getById(id));
        return "museum/detail";
    }

    @GetMapping("/classrooms")
    public String classrooms(Model model, @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("classrooms", classroomService.getAll());
        return "classrooms/list";
    }

    @GetMapping("/classrooms/{id}")
    public String classroomDetail(@PathVariable Long id, Model model,
                                  @AuthenticationPrincipal User user) {
        addUser(model, user);
        model.addAttribute("classroom", classroomService.getById(id));
        return "classrooms/detail";
    }
}
