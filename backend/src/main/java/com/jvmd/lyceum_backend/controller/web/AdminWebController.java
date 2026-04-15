package com.jvmd.lyceum_backend.controller.web;

import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.payload.AchievementCreateRequest;
import com.jvmd.lyceum_backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class AdminWebController {

    private final NewsService newsService;
    private final AchievementService achievementService;
    private final StudentPortfolioService portfolioService;
    private final MuseumExhibitService museumExhibitService;
    private final ClassroomService classroomService;
    private final VacancyService vacancyService;
    private final AdmissionService admissionService;
    private final UserService userService;

    @GetMapping
    public String dashboard(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("currentUser", user.getUsername());
        model.addAttribute("userRoles", user.getRoles());

        boolean isAdmin = user.getRoles().contains(Role.ROLE_ADMIN);
        boolean isTeacher = isAdmin || user.getRoles().contains(Role.ROLE_TEACHER);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isTeacher", isTeacher);

        if (isAdmin) {
            model.addAttribute("applications", admissionService.getAll());
            model.addAttribute("users", userService.findAll());
        }

        return "admin/dashboard";
    }

    @PostMapping("/news")
    @PreAuthorize("hasRole('TEACHER')")
    public String createNews(@RequestParam String title,
                             @RequestParam String content,
                             @RequestParam(required = false) MultipartFile image,
                             @AuthenticationPrincipal User user,
                             RedirectAttributes redirectAttributes) {
        try {
            newsService.saveWithImage(title, content, image, user);
            redirectAttributes.addFlashAttribute("success", "Новость успешно опубликована!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/achievements")
    @PreAuthorize("hasRole('TEACHER')")
    public String createAchievement(@RequestParam String title,
                                    @RequestParam String description,
                                    @RequestParam String category,
                                    @RequestParam String studentName,
                                    @RequestParam int year,
                                    @RequestParam String place,
                                    @RequestParam String level,
                                    RedirectAttributes redirectAttributes) {
        try {
            AchievementCreateRequest req = new AchievementCreateRequest();
            req.setTitle(title);
            req.setDescription(description);
            req.setCategory(category);
            req.setStudentName(studentName);
            req.setYear(year);
            req.setPlace(place);
            req.setLevel(level);
            achievementService.create(req);
            redirectAttributes.addFlashAttribute("success", "Достижение успешно добавлено!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/portfolio")
    @PreAuthorize("hasRole('TEACHER')")
    public String createPortfolio(@RequestParam String studentName,
                                  @RequestParam String grade,
                                  @RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
        try {
            portfolioService.create(studentName, grade, file);
            redirectAttributes.addFlashAttribute("success", "Портфолио успешно добавлено!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/museum")
    @PreAuthorize("hasRole('TEACHER')")
    public String createExhibit(@RequestParam String title,
                                @RequestParam String description,
                                @RequestParam(required = false) List<MultipartFile> images,
                                RedirectAttributes redirectAttributes) {
        try {
            museumExhibitService.create(title, description, images, List.of());
            redirectAttributes.addFlashAttribute("success", "Экспонат успешно добавлен!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/materials")
    @PreAuthorize("hasRole('TEACHER')")
    public String addMaterial(@RequestParam Long classroomId,
                              @RequestParam String title,
                              @RequestParam(required = false) String description,
                              @RequestParam(required = false) List<MultipartFile> files,
                              @AuthenticationPrincipal User user,
                              RedirectAttributes redirectAttributes) {
        try {
            classroomService.addMaterial(classroomId, title, description, files, user);
            redirectAttributes.addFlashAttribute("success", "Материал успешно добавлен!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/vacancies")
    @PreAuthorize("hasRole('ADMIN')")
    public String createVacancy(@RequestParam String title,
                                @RequestParam(required = false) String description,
                                RedirectAttributes redirectAttributes) {
        try {
            vacancyService.create(title, description);
            redirectAttributes.addFlashAttribute("success", "Вакансия успешно добавлена!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/vacancies/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteVacancy(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            vacancyService.delete(id);
            redirectAttributes.addFlashAttribute("success", "Вакансия закрыта!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/classrooms")
    @PreAuthorize("hasRole('ADMIN')")
    public String createClassroom(@RequestParam String title, RedirectAttributes redirectAttributes) {
        try {
            classroomService.create(title);
            redirectAttributes.addFlashAttribute("success", "Кабинет успешно создан!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String createUser(@RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String role,
                             RedirectAttributes redirectAttributes) {
        try {
            Set<Role> roles = Set.of(Role.valueOf("ROLE_" + role.toUpperCase()));
            userService.createUser(username, email, password, roles);
            redirectAttributes.addFlashAttribute("success", "Аккаунт «" + username + "» успешно создан!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "redirect:/admin";
    }
}
