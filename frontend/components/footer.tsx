import Link from "next/link"
import { GraduationCap } from "lucide-react"

const footerLinks = {
  about: [
    { label: "О лицее", href: "#about" },
    { label: "История", href: "#" },
    { label: "Педагоги", href: "#" },
    { label: "Достижения", href: "#" },
  ],
  students: [
    { label: "Расписание", href: "#" },
    { label: "Дистанционное обучение", href: "#" },
    { label: "Школьная форма", href: "#" },
    { label: "Мероприятия", href: "#" },
  ],
  parents: [
    { label: "Поступление", href: "#admission" },
    { label: "Документы", href: "#" },
    { label: "Контакты", href: "#contacts" },
    { label: "Вакансии", href: "#" },
  ],
}

export function Footer() {
  return (
    <footer className="border-t border-border bg-card">
      <div className="mx-auto max-w-7xl px-4 py-12 sm:px-6 lg:px-8">
        <div className="grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-4">
          <div>
            <Link href="/" className="flex items-center gap-2">
              <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-primary">
                <GraduationCap className="h-6 w-6 text-primary-foreground" />
              </div>
              <div>
                <span className="text-lg font-bold text-foreground">Первый IT-лицей</span>
                <p className="text-xs text-muted-foreground">г. Петропавловск</p>
              </div>
            </Link>
            <p className="mt-4 text-sm text-muted-foreground">
              КГУ «Первый городской общеобразовательный IT-лицей» — 
              образовательное учреждение с 35-летней историей.
            </p>
          </div>
          
          <div>
            <h3 className="text-sm font-semibold text-foreground">О лицее</h3>
            <ul className="mt-4 space-y-2">
              {footerLinks.about.map((link) => (
                <li key={link.label}>
                  <Link 
                    href={link.href}
                    className="text-sm text-muted-foreground transition-colors hover:text-foreground"
                  >
                    {link.label}
                  </Link>
                </li>
              ))}
            </ul>
          </div>
          
          <div>
            <h3 className="text-sm font-semibold text-foreground">Ученикам</h3>
            <ul className="mt-4 space-y-2">
              {footerLinks.students.map((link) => (
                <li key={link.label}>
                  <Link 
                    href={link.href}
                    className="text-sm text-muted-foreground transition-colors hover:text-foreground"
                  >
                    {link.label}
                  </Link>
                </li>
              ))}
            </ul>
          </div>
          
          <div>
            <h3 className="text-sm font-semibold text-foreground">Родителям</h3>
            <ul className="mt-4 space-y-2">
              {footerLinks.parents.map((link) => (
                <li key={link.label}>
                  <Link 
                    href={link.href}
                    className="text-sm text-muted-foreground transition-colors hover:text-foreground"
                  >
                    {link.label}
                  </Link>
                </li>
              ))}
            </ul>
          </div>
        </div>
        
        <div className="mt-12 border-t border-border pt-8">
          <div className="flex flex-col items-center justify-between gap-4 sm:flex-row">
            <p className="text-sm text-muted-foreground">
              © 1996–2026 Первый городской общеобразовательный IT-лицей
            </p>
            <p className="text-sm text-muted-foreground">
              Республика Казахстан, Северо-Казахстанская область
            </p>
          </div>
        </div>
      </div>
    </footer>
  )
}
