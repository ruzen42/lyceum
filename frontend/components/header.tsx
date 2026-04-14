"use client"

import { useState } from "react"
import Link from "next/link"
import { Menu, X, GraduationCap, Phone } from "lucide-react"
import { Button } from "@/components/ui/button"

const navLinks = [
  { href: "#about", label: "О лицее" },
  { href: "#news", label: "Новости" },
  { href: "#records", label: "Победы" },
  { href: "#portfolio", label: "Портфолио" },
  { href: "#admission", label: "Поступление" },
  { href: "#contacts", label: "Контакты" },
]

export function Header() {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false)

  return (
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

        <nav className="hidden items-center gap-6 md:flex">
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

        <div className="flex items-center gap-3">
          <a
            href="tel:+77152467046"
            className="hidden items-center gap-2 text-sm font-medium text-muted-foreground transition-colors hover:text-foreground lg:flex"
          >
            <Phone className="h-4 w-4" />
            <span>46-70-46</span>
          </a>
          <Button size="sm" className="hidden sm:inline-flex">
            Записаться
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
            <Button className="mt-2 w-full">Записаться</Button>
          </nav>
        </div>
      )}
    </header>
  )
}
