@import com.jvmd.lyceum_backend.model.StudentPortfolio
@import com.jvmd.lyceum_backend.model.Role
@import java.util.List
@import java.util.Set

@param List<StudentPortfolio> portfolios
@param String currentUser = null
@param Set<Role> userRoles = null

@template.layout(
    title = "Портфолио",
    activePage = "portfolio",
    currentUser = currentUser,
    userRoles = userRoles,
    content = @`
        <div class="page-header bellota-bold">
            <div class="container">
                <h1 class="bellota-bold">Портфолио студентов</h1>
                <p>Знакомьтесь с нашими талантливыми учениками</p>
            </div>
        </div>

        <section class="section">
            <div class="container">
                @if(portfolios.isEmpty())
                    <div class="empty-state">
                        <div class="empty-state-icon">👨‍🎓</div>
                        <p>Портфолио пока нет</p>
                    </div>
                @else
                    <div class="grid grid-2">
                        @for(StudentPortfolio p : portfolios)
                            <div class="card">
                                <div class="card-body">
                                    <div class="portfolio-card">
                                        <div class="portfolio-avatar-placeholder">👤</div>
                                        <div style="flex:1">
                                            <h3 class="card-title bellota-bold" style="margin-bottom:0.2rem">${p.getStudentName()}</h3>
                                            <span class="badge badge-secondary">${p.getGrade()}</span>
                                        </div>
                                    </div>

                                    @if(p.getFileUrl() != null)
                                        <div style="margin-top:1rem">
                                            <a href="${p.getFileUrl()}" target="_blank"
                                               class="btn btn-outline btn-sm"
                                               style="display:inline-flex;align-items:center;gap:0.4rem">
                                                <span>📄</span> Скачать портфолио
                                            </a>
                                        </div>
                                    @endif

                                    <div class="card-meta" style="margin-top:1rem">
                                        <span style="font-size:0.78rem">Добавлено: ${p.getCreatedAt().toLocalDate().toString()}</span>
                                    </div>
                                </div>
                            </div>
                        @endfor
                    </div>
                @endif
            </div>
        </section>
    `
)
