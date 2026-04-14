"use client"

import { useState } from "react"
import Link from "next/link"
import { usePathname } from "next/navigation"
import { Newspaper, Landmark, School, LogOut, GraduationCap, Menu, X } from "lucide-react"
import { cn } from "@/lib/utils"
import { useAuth } from "@/lib/auth-context"
import { Button } from "@/components/ui/button"

const navItems = [
  { href: "/news", label: "News", icon: Newspaper },
  { href: "/museum", label: "Museum", icon: Landmark },
  { href: "/classrooms", label: "Classrooms", icon: School },
]

export function AppSidebar() {
  const pathname = usePathname()
  const { logout } = useAuth()
  const [isMobileOpen, setIsMobileOpen] = useState(false)

  const sidebarContent = (
    <>
      <div className="flex items-center gap-3 px-6 py-5 border-b border-sidebar-border">
        <GraduationCap className="size-8" />
        <span className="text-xl font-bold">Lyceum</span>
      </div>

      <nav className="flex-1 px-4 py-6">
        <ul className="space-y-2">
          {navItems.map((item) => {
            const isActive = pathname.startsWith(item.href)
            return (
              <li key={item.href}>
                <Link
                  href={item.href}
                  onClick={() => setIsMobileOpen(false)}
                  className={cn(
                    "flex items-center gap-3 px-4 py-3 rounded-lg transition-colors",
                    isActive
                      ? "bg-sidebar-accent text-sidebar-accent-foreground"
                      : "hover:bg-sidebar-accent/50"
                  )}
                >
                  <item.icon className="size-5" />
                  <span className="font-medium">{item.label}</span>
                </Link>
              </li>
            )
          })}
        </ul>
      </nav>

      <div className="px-4 py-4 border-t border-sidebar-border">
        <Button
          variant="ghost"
          className="w-full justify-start gap-3 text-sidebar-foreground hover:bg-sidebar-accent/50 hover:text-sidebar-foreground"
          onClick={() => {
            logout()
            setIsMobileOpen(false)
          }}
        >
          <LogOut className="size-5" />
          <span className="font-medium">Logout</span>
        </Button>
      </div>
    </>
  )

  return (
    <>
      {/* Mobile menu button */}
      <button
        onClick={() => setIsMobileOpen(!isMobileOpen)}
        className="fixed top-4 left-4 z-50 p-2 bg-primary text-primary-foreground rounded-lg shadow-lg md:hidden"
        aria-label="Toggle menu"
      >
        {isMobileOpen ? <X className="size-6" /> : <Menu className="size-6" />}
      </button>

      {/* Mobile overlay */}
      {isMobileOpen && (
        <div
          className="fixed inset-0 bg-black/50 z-40 md:hidden"
          onClick={() => setIsMobileOpen(false)}
        />
      )}

      {/* Mobile sidebar */}
      <aside
        className={cn(
          "fixed left-0 top-0 z-40 h-screen w-64 bg-sidebar text-sidebar-foreground flex flex-col shadow-lg transform transition-transform duration-200 ease-in-out md:hidden",
          isMobileOpen ? "translate-x-0" : "-translate-x-full"
        )}
      >
        {sidebarContent}
      </aside>

      {/* Desktop sidebar */}
      <aside className="hidden md:flex fixed left-0 top-0 z-40 h-screen w-64 bg-sidebar text-sidebar-foreground flex-col shadow-lg">
        {sidebarContent}
      </aside>
    </>
  )
}
