"use client"

import { useAuth } from "@/lib/auth-context"
import { Badge } from "@/components/ui/badge"

export function TopBar() {
  const { user } = useAuth()

  if (!user) return null

  return (
    <header className="fixed top-0 left-0 md:left-64 right-0 z-30 h-16 bg-card border-b border-border flex items-center justify-end px-6 pl-16 md:pl-6 shadow-sm">
      <div className="flex items-center gap-3">
        <span className="text-sm font-medium text-foreground hidden sm:block">{user.username}</span>
        <div className="flex gap-1">
          {user.roles.map((role) => (
            <Badge
              key={role}
              variant="secondary"
              className="bg-primary/10 text-primary border-primary/20"
            >
              {role}
            </Badge>
          ))}
        </div>
      </div>
    </header>
  )
}
