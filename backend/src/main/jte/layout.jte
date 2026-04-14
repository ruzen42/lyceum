@import gg.jte.Content
@import com.jvmd.lyceum_backend.model.Role
@import java.util.Set

@param String title
@param Content content
@param String currentUser = null
@param Set<Role> userRoles = null
@param String activePage = ""

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title} — Лицей №1</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<header class="site-header">
    <div class="header-inner">
        <a href="/" class="site-logo">Лицей <span>№1</span></a>
        <nav class="site-nav">
            <a href="/" class="${activePage.equals("home") ? "active" : ""}">Главная</a>
            <a href="/news" class="${activePage.equals("news") ? "active" : ""}">Новости</a>
            <a href="/achievements" class="${activePage.equals("achievements") ? "active" : ""}">Достижения</a>
            <a href="/portfolio" class="${activePage.equals("portfolio") ? "active" : ""}">Портфолио</a>
            <a href="/vacancies" class="${activePage.equals("vacancies") ? "active" : ""}">Вакансии</a>
            <a href="/museum" class="${activePage.equals("museum") ? "active" : ""}">Музей</a>
            <a href="/classrooms" class="${activePage.equals("classrooms") ? "active" : ""}">Кабинеты</a>
            <a href="/admission" class="${activePage.equals("admission") ? "active" : ""}">Поступление</a>
        </nav>
        <div class="header-actions">
            @if(currentUser != null)
                @if(userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER)))
                    <a href="/admin" class="btn btn-accent btn-sm">Панель</a>
                @endif
                <form method="post" action="/logout" style="margin:0">
                    <button type="submit" class="btn btn-outline-white btn-sm">${currentUser}</button>
                </form>
            @else
                <a href="/login" class="btn btn-outline-white btn-sm">Войти</a>
            @endif
            <button class="menu-toggle" onclick="document.getElementById('mobileNav').classList.toggle('open')">☰</button>
        </div>
    </div>
    <nav class="mobile-nav" id="mobileNav">
        <a href="/">Главная</a>
        <a href="/news">Новости</a>
        <a href="/achievements">Достижения</a>
        <a href="/portfolio">Портфолио</a>
        <a href="/vacancies">Вакансии</a>
        <a href="/museum">Музей</a>
        <a href="/classrooms">Кабинеты</a>
        <a href="/admission">Поступление</a>
        @if(currentUser != null)
            @if(userRoles != null && (userRoles.contains(Role.ROLE_ADMIN) || userRoles.contains(Role.ROLE_TEACHER)))
                <a href="/admin">Панель управления</a>
            @endif
        @else
            <a href="/login">Войти</a>
        @endif
    </nav>
</header>

<main class="main-content">
    ${content}
</main>

<footer class="site-footer">
    <div class="container">
        <div class="footer-grid">
            <div class="footer-col">
                <h4>Лицей №1</h4>
                <p>Качественное образование для будущих лидеров</p>
            </div>
            <div class="footer-col">
                <h4>Разделы</h4>
                <a href="/news">Новости</a>
                <a href="/achievements">Достижения</a>
                <a href="/museum">Школьный музей</a>
                <a href="/classrooms">Учебные кабинеты</a>
            </div>
            <div class="footer-col">
                <h4>Информация</h4>
                <a href="/vacancies">Вакансии</a>
                <a href="/admission">Поступление</a>
                <a href="/portfolio">Портфолио</a>
            </div>
            <div class="footer-col">
                <h4>Контакты</h4>
                <p>г. Москва, ул. Школьная, 1</p>
                <p>+7 (495) 000-00-00</p>
                <p>lyceum@school.ru</p>
            </div>
        </div>
        <div class="footer-bottom">
            <span>© 2025 Лицей №1. Все права защищены.</span>
            <span>Образование. Наука. Будущее.</span>
        </div>
    </div>
</footer>

</body>
</html>
