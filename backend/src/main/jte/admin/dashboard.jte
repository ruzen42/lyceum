@import com.jvmd.lyceum_backend.model.AdmissionApplication
@import com.jvmd.lyceum_backend.model.Role
@import com.jvmd.lyceum_backend.model.User
@import java.util.List
@import java.util.Set

@param String currentUser
@param Set<Role> userRoles
@param List<AdmissionApplication> applications = null
@param List<User> users = null
@param String success = null
@param String error = null
@param boolean isAdmin = false
@param boolean isTeacher = false

@template.layout(
    title = "Панель управления",
    activePage = "",
    currentUser = currentUser,
    userRoles = userRoles,
    content = @`
        <div class="admin-layout">
            <aside class="admin-sidebar">
                <h3 class="bellota-bold">Контент</h3>
                @if(isTeacher)
                    <a href="#news" onclick="showTab('news',this);return false"><span class="material-icons">article</span> Новости</a>
                    <a href="#achievements" onclick="showTab('achievements',this);return false"><span class="material-icons">emoji_events</span> Достижения</a>
                    <a href="#portfolio" onclick="showTab('portfolio',this);return false"><span class="material-icons">person</span> Портфолио</a>
                    <a href="#museum" onclick="showTab('museum',this);return false"><span class="material-icons">museum</span> Музей</a>
                    <a href="#materials" onclick="showTab('materials',this);return false"><span class="material-icons">description</span> Материалы</a>
                @endif
                @if(isAdmin)
                    <h3 class="bellota-bold">Управление</h3>
                    <a href="#vacancies" onclick="showTab('vacancies',this);return false"><span class="material-icons">work</span> Вакансии</a>
                    <a href="#classrooms" onclick="showTab('classrooms',this);return false"><span class="material-icons">menu_book</span> Кабинеты</a>
                    <a href="#admissions" onclick="showTab('admissions',this);return false"><span class="material-icons">assignment</span> Заявки</a>
                    <a href="#users" onclick="showTab('users',this);return false"><span class="material-icons">group</span> Пользователи</a>
                @endif
            </aside>

            <div class="admin-main">
                <div style="display:flex;align-items:center;justify-content:space-between;margin-bottom:1.5rem">
                    <h1 class="bellota-bold" style="font-size:1.5rem;font-weight:800;color:var(--primary)">Панель управления</h1>
                    <div>
                        <span style="font-size:0.875rem;color:var(--text-muted)">
                            ${currentUser}
                            @if(isAdmin)
                                · <span class="badge badge-danger">Администратор</span>
                            @elseif(isTeacher)
                                · <span class="badge badge-secondary">Учитель</span>
                            @endif
                        </span>
                    </div>
                </div>

                @if(success != null)
                    <div class="alert alert-success">✓ ${success}</div>
                @endif
                @if(error != null)
                    <div class="alert alert-danger">✗ ${error}</div>
                @endif

                @if(isTeacher)
                    <div class="admin-section" id="tab-news">
                        <h2 class="bellota-bold"><span class="material-icons">article</span> Добавить новость</h2>
                        <form method="post" action="/admin/news" enctype="multipart/form-data">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Заголовок *</label>
                                    <input type="text" name="title" class="form-control" required placeholder="Заголовок новости">
                                </div>
                                <div class="form-group">
                                    <label>Изображение</label>
                                    <input type="file" name="image" class="form-control" accept="image/*">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Содержание *</label>
                                <textarea name="content" class="form-control" rows="5" required placeholder="Текст новости..."></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">Опубликовать новость</button>
                        </form>
                    </div>

                    <div class="admin-section" id="tab-achievements" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">emoji_events</span> Добавить достижение</h2>
                        <form method="post" action="/admin/achievements">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Название *</label>
                                    <input type="text" name="title" class="form-control" required placeholder="Название достижения">
                                </div>
                                <div class="form-group">
                                    <label>Имя ученика *</label>
                                    <input type="text" name="studentName" class="form-control" required placeholder="Иванов Иван">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Описание *</label>
                                <textarea name="description" class="form-control" rows="3" required placeholder="Описание достижения"></textarea>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Категория *</label>
                                    <input type="text" name="category" class="form-control" required placeholder="Математика, Физика...">
                                </div>
                                <div class="form-group">
                                    <label>Год *</label>
                                    <input type="number" name="year" class="form-control" required placeholder="2025" min="2000" max="2100">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Место проведения *</label>
                                    <input type="text" name="place" class="form-control" required placeholder="Москва, МГУ...">
                                </div>
                                <div class="form-group">
                                    <label>Уровень / Место *</label>
                                    <input type="text" name="level" class="form-control" required placeholder="1 место, Золото...">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Добавить достижение</button>
                        </form>
                    </div>

                    <%-- ─── ПОРТФОЛИО ─── --%>
                    <div class="admin-section" id="tab-portfolio" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">person</span> Добавить портфолио</h2>
                        <form method="post" action="/admin/portfolio" enctype="multipart/form-data">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Имя студента *</label>
                                    <input type="text" name="studentName" class="form-control" required placeholder="Иванов Иван">
                                </div>
                                <div class="form-group">
                                    <label>Класс *</label>
                                    <input type="text" name="grade" class="form-control" required placeholder="11А">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Файл портфолио (.docx) *</label>
                                <input type="file" name="file" class="form-control" accept=".docx" required>
                                <div class="form-hint">Только файлы в формате .docx</div>
                            </div>
                            <button type="submit" class="btn btn-primary">Добавить портфолио</button>
                        </form>
                    </div>

                    <%-- ─── МУЗЕЙ ─── --%>
                    <div class="admin-section" id="tab-museum" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">museum</span> Добавить экспонат</h2>
                        <form method="post" action="/admin/museum" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Название *</label>
                                <input type="text" name="title" class="form-control" required placeholder="Название экспоната">
                            </div>
                            <div class="form-group">
                                <label>Описание *</label>
                                <textarea name="description" class="form-control" rows="4" required placeholder="Описание экспоната..."></textarea>
                            </div>
                            <div class="form-group">
                                <label>Фотографии</label>
                                <input type="file" name="images" class="form-control" accept="image/*" multiple>
                                <div class="form-hint">Можно выбрать несколько файлов</div>
                            </div>
                            <button type="submit" class="btn btn-primary">Добавить экспонат</button>
                        </form>
                    </div>

                    <%-- ─── МАТЕРИАЛЫ ─── --%>
                    <div class="admin-section" id="tab-materials" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">description</span> Добавить материал в кабинет</h2>
                        <form method="post" action="/admin/materials" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>ID кабинета *</label>
                                <input type="number" name="classroomId" class="form-control" required placeholder="Введите ID кабинета">
                                <div class="form-hint">
                                    Найдите ID кабинета на <a href="/classrooms">странице кабинетов</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Название материала *</label>
                                <input type="text" name="title" class="form-control" required placeholder="Название материала">
                            </div>
                            <div class="form-group">
                                <label>Описание</label>
                                <textarea name="description" class="form-control" rows="3" placeholder="Описание материала..."></textarea>
                            </div>
                            <div class="form-group">
                                <label>Файлы</label>
                                <input type="file" name="files" class="form-control" multiple>
                                <div class="form-hint">Можно выбрать несколько файлов</div>
                            </div>
                            <button type="submit" class="btn btn-primary">Добавить материал</button>
                        </form>
                    </div>
                @endif

                @if(isAdmin)
                    <div class="admin-section" id="tab-vacancies" style="${isTeacher ? "display:none" : ""}">
                        <h2 class="bellota-bold"><span class="material-icons">work</span> Управление вакансиями</h2>
                        <form method="post" action="/admin/vacancies" style="margin-bottom:1.5rem">
                            <div class="form-group">
                                <label>Название вакансии *</label>
                                <input type="text" name="title" class="form-control" required placeholder="Учитель математики">
                            </div>
                            <div class="form-group">
                                <label>Описание</label>
                                <textarea name="description" class="form-control" rows="3" placeholder="Требования и условия..."></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">Добавить вакансию</button>
                        </form>
                    </div>

                    <div class="admin-section" id="tab-classrooms" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">menu_book</span> Создать кабинет</h2>
                        <form method="post" action="/admin/classrooms">
                            <div class="form-group">
                                <label>Название кабинета *</label>
                                <input type="text" name="title" class="form-control" required placeholder="Кабинет математики №24">
                            </div>
                            <button type="submit" class="btn btn-primary">Создать кабинет</button>
                        </form>
                    </div>

                    <%-- ─── ЗАЯВКИ ─── --%>
                    <div class="admin-section" id="tab-admissions" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">assignment</span> Заявки на поступление</h2>
                        @if(applications == null || applications.isEmpty())
                            <div class="empty-state" style="padding:1.5rem 0">
                                <div class="empty-state-icon"><span class="material-icons" style="font-size:3rem">assignment</span></div>
                                <p>Заявок пока нет</p>
                            </div>
                        @else
                            <div class="table-wrap">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Родитель</th>
                                            <th>Ребёнок</th>
                                            <th>Возраст</th>
                                            <th>Класс</th>
                                            <th>Телефон</th>
                                            <th>Статус</th>
                                            <th>Дата</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        @for(AdmissionApplication app : applications)
                                            <tr>
                                                <td>
                                                    <strong>${app.getParentName()}</strong>
                                                    @if(app.getEmail() != null)
                                                        <br><small style="color:var(--text-muted)">${app.getEmail()}</small>
                                                    @endif
                                                </td>
                                                <td>${app.getChildName()}</td>
                                                <td>${app.getChildAge()}</td>
                                                <td>${app.getClassType().equals("1_CLASS") ? "1 класс" : "Дошкольная"}</td>
                                                <td>${app.getPhone()}</td>
                                                <td>
                                                    <span class="badge ${app.getStatus() == AdmissionApplication.ApplicationStatus.PENDING ? "status-pending" : app.getStatus() == AdmissionApplication.ApplicationStatus.REVIEWED ? "status-reviewed" : "status-rejected"}">
                                                        ${app.getStatus() == AdmissionApplication.ApplicationStatus.PENDING ? "Ожидает" : app.getStatus() == AdmissionApplication.ApplicationStatus.REVIEWED ? "Рассмотрено" : "Отклонено"}
                                                    </span>
                                                </td>
                                                <td style="font-size:0.8rem">${app.getCreatedAt().toLocalDate().toString()}</td>
                                            </tr>
                                        @endfor
                                    </tbody>
                                </table>
                            </div>
                        @endif
                    </div>

                    <%-- ─── ПОЛЬЗОВАТЕЛИ ─── --%>
                    <div class="admin-section" id="tab-users" style="display:none">
                        <h2 class="bellota-bold"><span class="material-icons">group</span> Создать аккаунт</h2>
                        <form method="post" action="/admin/users" style="margin-bottom:2rem">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Имя пользователя *</label>
                                    <input type="text" name="username" class="form-control" required placeholder="ivanov_ivan">
                                </div>
                                <div class="form-group">
                                    <label>Email *</label>
                                    <input type="email" name="email" class="form-control" required placeholder="ivan@lyceum.kz">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Пароль *</label>
                                    <input type="password" name="password" class="form-control" required placeholder="Минимум 6 символов" minlength="6">
                                </div>
                                <div class="form-group">
                                    <label>Роль *</label>
                                    <select name="role" class="form-control" required>
                                        <option value="STUDENT">Ученик</option>
                                        <option value="TEACHER">Учитель</option>
                                        <option value="ADMIN">Администратор</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Создать аккаунт</button>
                        </form>

                        <h3 class="bellota-bold" style="font-size:1rem;margin-bottom:1rem">Все пользователи</h3>
                        @if(users == null || users.isEmpty())
                            <div class="empty-state" style="padding:1rem 0">
                                <p style="color:var(--text-muted)">Пользователей пока нет</p>
                            </div>
                        @else
                            <div class="table-wrap">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Имя пользователя</th>
                                            <th>Email</th>
                                            <th>Роли</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        @for(User u : users)
                                            <tr>
                                                <td><strong>${u.getUsername()}</strong></td>
                                                <td style="color:var(--text-muted)">${u.getEmail()}</td>
                                                <td>
                                                    @for(Role r : u.getRoles())
                                                        <span class="badge ${r == Role.ROLE_ADMIN ? "badge-danger" : r == Role.ROLE_TEACHER ? "badge-secondary" : r == Role.ROLE_STUDENT ? "badge-primary" : ""}">
                                                            ${r == Role.ROLE_ADMIN ? "Админ" : r == Role.ROLE_TEACHER ? "Учитель" : r == Role.ROLE_STUDENT ? "Ученик" : "Пользователь"}
                                                        </span>
                                                    @endfor
                                                </td>
                                            </tr>
                                        @endfor
                                    </tbody>
                                </table>
                            </div>
                        @endif
                    </div>
                @endif
            </div>
        </div>

        <style>
            .admin-sidebar a { display: flex; align-items: center; gap: 0.5rem; }
            .admin-sidebar a .material-icons { font-size: 1.1rem; }
            .admin-section h2 .material-icons { font-size: 1.2rem; vertical-align: middle; margin-right: 0.25rem; }
        </style>

        <script>
        function showTab(tabName, link) {
            document.querySelectorAll('[id^="tab-"]').forEach(el => el.style.display = 'none');
            const tab = document.getElementById('tab-' + tabName);
            if (tab) tab.style.display = 'block';
            document.querySelectorAll('.admin-sidebar a').forEach(a => a.classList.remove('active'));
            if (link) link.classList.add('active');
        }
        const firstLink = document.querySelector('.admin-sidebar a');
        if (firstLink) firstLink.classList.add('active');
        </script>
    `
)
