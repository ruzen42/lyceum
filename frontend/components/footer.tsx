import Link from "next/link"
import { GraduationCap, Phone, MapPin, Mail } from "lucide-react"

const aboutLinks = [
  { label: "О лицее", href: "#about" },
  { label: "Новости", href: "#news" },
  { label: "Победы", href: "#records" },
  { label: "Портфолио учеников", href: "#portfolio" },
]

const parentLinks = [
  { label: "Поступление", href: "#admission" },
  { label: "Контакты", href: "#contacts" },
]

export function Footer() {
  return (
    <footer className="border-t border-border bg-card">
      <div className="mx-auto max-w-7xl px-4 py-12 sm:px-6 lg:px-8">
        <div className="grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-4">

          {/* Brand */}
          <div className="lg:col-span-2">
            <Link href="/" className="flex items-center gap-2">
              <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-primary">
                <GraduationCap className="h-6 w-6 text-primary-foreground" />
              </div>
              <div>
                <span className="text-lg font-bold text-foreground">Первый IT-лицей</span>
                <p className="text-xs text-muted-foreground">г. Петропавловск</p>
              </div>
            </Link>
            <p className="mt-4 max-w-xs text-sm text-muted-foreground">
              КГУ «Первый городской общеобразовательный IT-лицей» —
              образовательное учреждение с 35-летней историей.
            </p>
            <div className="mt-4 space-y-2 text-sm text-muted-foreground">
              <a href="tel:+77152467046" className="flex items-center gap-2 hover:text-foreground transition-colors">
                <Phone className="h-3.5 w-3.5" />
                +7 (7152) 46-70-46
              </a>
              <a href="mailto:admin@flyceum.ru" className="flex items-center gap-2 hover:text-foreground transition-colors">
                <Mail className="h-3.5 w-3.5" />
                admin@flyceum.ru
              </a>
              <p className="flex items-center gap-2">
                <MapPin className="h-3.5 w-3.5 shrink-0" />
                г. Петропавловск, ул. Ж.Жабаева, 196
              </p>
            </div>
          </div>

          {/* About */}
          <div>
            <h3 className="text-sm font-semibold text-foreground">О лицее</h3>
            <ul className="mt-4 space-y-2">
              {aboutLinks.map((link) => (
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

          {/* Parents */}
          <div>
            <h3 className="text-sm font-semibold text-foreground">Родителям</h3>
            <ul className="mt-4 space-y-2">
              {parentLinks.map((link) => (
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
              © 1991–2026 Первый городской общеобразовательный IT-лицей
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
