@import com.jvmd.lyceum_backend.model.Role
@import com.jvmd.lyceum_backend.model.StudentPortfolio
@import java.util.Set

@param String currentUser
@param Set<Role> userRoles
@param StudentPortfolio portfolio = null
@param String success = null
@param String error = null

@template.layout(
    title = "Моё портфолио",
    activePage = "portfolio",
    currentUser = currentUser,
    userRoles = userRoles,
    content = @`
        <div class="container" style="max-width:680px;margin:2rem auto;padding:0 1rem">
            <h1 class="bellota-bold" style="font-size:1.75rem;font-weight:800;color:var(--primary);margin-bottom:0.25rem">Моё портфолио</h1>
            <p style="color:var(--text-muted);margin-bottom:1.5rem">Загрузи файл портфолио в формате .docx — он будет доступен на публичной странице</p>

            @if(success != null)
                <div class="alert alert-success">✓ ${success}</div>
            @endif
            @if(error != null)
                <div class="alert alert-danger">✗ ${error}</div>
            @endif

            <div class="card" style="padding:2rem">
                <form method="post" action="/student/portfolio" enctype="multipart/form-data">

                    <div class="form-row">
                        <div class="form-group">
                            <label>Полное имя *</label>
                            <input type="text" name="studentName" class="form-control" required
                                   placeholder="Иванов Иван Иванович"
                                   value="${portfolio != null ? portfolio.getStudentName() : ""}">
                        </div>
                        <div class="form-group">
                            <label>Класс *</label>
                            <input type="text" name="grade" class="form-control" required
                                   placeholder="11А"
                                   value="${portfolio != null ? portfolio.getGrade() : ""}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Файл портфолио (.docx) ${portfolio != null && portfolio.getFileUrl() != null ? "" : "*"}</label>
                        @if(portfolio != null && portfolio.getFileUrl() != null)
                            <div style="display:flex;align-items:center;gap:0.75rem;margin-bottom:0.5rem;padding:0.6rem 0.875rem;background:var(--bg-alt);border-radius:var(--radius);border:1px solid var(--border)">
                                <span style="font-size:1.25rem">📄</span>
                                <a href="${portfolio.getFileUrl()}" target="_blank" style="font-size:0.875rem;color:var(--primary);font-weight:600">Текущий файл</a>
                                <span style="font-size:0.78rem;color:var(--text-muted);margin-left:auto">загрузи новый чтобы заменить</span>
                            </div>
                        @endif
                        @if(portfolio == null || portfolio.getFileUrl() == null)
                        <input type="file" name="file" class="form-control" accept=".docx" required>
                        @else
                        <input type="file" name="file" class="form-control" accept=".docx">
                        @endif
                        <div class="form-hint">Только файлы в формате .docx</div>
                    </div>

                    <div style="display:flex;gap:1rem;align-items:center;margin-top:0.5rem">
                        <button type="submit" class="btn btn-primary">
                            ${portfolio != null ? "Сохранить изменения" : "Загрузить портфолио"}
                        </button>
                        @if(portfolio != null)
                            <a href="/portfolio" class="btn btn-outline" style="font-size:0.875rem">Посмотреть на сайте →</a>
                        @endif
                    </div>
                </form>
            </div>
        </div>
    `
)
