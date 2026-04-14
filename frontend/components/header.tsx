"use client"

import { useState } from "react"
import Link from "next/link"
import { Menu, X, GraduationCap, Phone, LogIn, LogOut, LayoutDashboard } from "lucide-react"
import { Button } from "@/components/ui/button"
import { LoginModal } from "@/components/login-modal"
import { useAuth } from "@/contexts/auth-context"

const navLinks = [
  { href: "#about", label: "О лицее" },
  { href: "#news", label: "Новости" },
  { href: "#records", label: "Победы" },
  { href: "#portfolio", label: "Портфолио" },
  { href: "#museum", label: "Музей" },
  { href: "#classrooms", label: "Классы" },
  { href: "#admission", label: "Поступление" },
  { href: "#contacts", label: "Контакты" },
]

export function Header() {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false)
  const [loginOpen, setLoginOpen] = useState(false)
  const { username, isAdmin, isTeacher, logout } = useAuth()

  return (
    <>
      <header className="sticky top-0 z-50 w-full border-b border-border/50 bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
        <div className="mx-auto flex h-16 max-w-7xl items-center justify-between px-4 sm:px-6 lg:px-8">
          <Link href="/" className="flex items-center gap-2">
            <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-primary">
              <GraduationCap className="h-6 w-6 text-primary-foreground" />
            </div>
            <div className="hidden sm:block">
              <span className="text-lg font-bold text-foreground">Первый IT-лицей</span>
              <p className="text-xs text-muted-foreground">г. Петропавловск</p>
            </div>
          </Link>

          <nav className="hidden items-center gap-5 md:flex">
            {navLinks.map((link) => (
              <Link
                key={link.href}
                href={link.href}
                className="text-sm font-medium text-muted-foreground transition-colors hover:text-foreground"
              >
                {link.label}
              </Link>
            ))}
          </nav>

          <div className="flex items-center gap-2">
            <a
              href="tel:+77152467046"
              className="hidden items-center gap-2 text-sm font-medium text-muted-foreground transition-colors hover:text-foreground lg:flex"
            >
              <Phone className="h-4 w-4" />
              <span>46-70-46</span>
            </a>

            {username ? (
              <div className="hidden sm:flex items-center gap-2">
                <span className="text-sm text-muted-foreground">{username}</span>
                {(isAdmin || isTeacher) && (
                  <Button variant="outline" size="sm" asChild>
                    <Link href="/admin">
                      <LayoutDashboard className="mr-1.5 h-4 w-4" />
                      Панель
                    </Link>
                  </Button>
                )}
                <Button variant="ghost" size="sm" onClick={logout}>
                  <LogOut className="h-4 w-4" />
                </Button>
              </div>
            ) : (
              <Button variant="outline" size="sm" className="hidden sm:inline-flex" onClick={() => setLoginOpen(true)}>
                <LogIn className="mr-1.5 h-4 w-4" />
                Войти
              </Button>
            )}

            <Button size="sm" className="hidden sm:inline-flex" asChild>
              <Link href="#admission">Записаться</Link>
            </Button>

            <Button
              variant="ghost"
              size="icon"
              className="md:hidden"
              onClick={() => setMobileMenuOpen(!mobileMenuOpen)}
              aria-label={mobileMenuOpen ? "Закрыть меню" : "Открыть меню"}
            >
              {mobileMenuOpen ? <X className="h-5 w-5" /> : <Menu className="h-5 w-5" />}
            </Button>
          </div>
        </div>

        {mobileMenuOpen && (
          <div className="border-t border-border md:hidden">
            <nav className="flex flex-col gap-1 p-4">
              {navLinks.map((link) => (
                <Link
                  key={link.href}
                  href={link.href}
                  className="rounded-lg px-3 py-2 text-sm font-medium text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
                  onClick={() => setMobileMenuOpen(false)}
                >
                  {link.label}
                </Link>
              ))}
              {username ? (
                <>
                  {(isAdmin || isTeacher) && (
                    <Link
                      href="/admin"
                      className="rounded-lg px-3 py-2 text-sm font-medium text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
                      onClick={() => setMobileMenuOpen(false)}
                    >
                      Панель управления
                    </Link>
                  )}
                  <Button variant="outline" className="mt-2 w-full" onClick={() => { logout(); setMobileMenuOpen(false) }}>
                    <LogOut className="mr-2 h-4 w-4" />
                    Выйти ({username})
                  </Button>
                </>
              ) : (
                <Button variant="outline" className="mt-2 w-full" onClick={() => { setLoginOpen(true); setMobileMenuOpen(false) }}>
                  <LogIn className="mr-2 h-4 w-4" />
                  Войти
                </Button>
              )}
              <Button className="mt-2 w-full" asChild>
                <Link href="#admission" onClick={() => setMobileMenuOpen(false)}>Записаться</Link>
              </Button>
            </nav>
          </div>
        )}
      </header>

      <LoginModal open={loginOpen} onOpenChange={setLoginOpen} />
    </>
  )
}
