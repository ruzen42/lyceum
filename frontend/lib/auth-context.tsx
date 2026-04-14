"use client"

import { createContext, useContext, useState, useEffect, ReactNode } from "react"
import { apiClient } from "./api"

export type Role = "ADMIN" | "TEACHER" | "STUDENT" | "USER"

interface User {
  username: string
  email: string
  roles: Role[]
  token: string
}

interface AuthContextType {
  user: User | null
  login: (username: string, password: string) => Promise<void>
  register: (username: string, password: string, email: string) => Promise<void>
  logout: () => void
  hasRole: (requiredRole: Role) => boolean
  isLoading: boolean
}

const roleHierarchy: Record<Role, number> = {
  ADMIN: 4,
  TEACHER: 3,
  STUDENT: 2,
  USER: 1,
}

const AuthContext = createContext<AuthContextType | undefined>(undefined)

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<User | null>(null)
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    const stored = localStorage.getItem("lyceum_user")
    if (stored) {
      try {
        setUser(JSON.parse(stored))
      } catch {
        localStorage.removeItem("lyceum_user")
      }
    }
    setIsLoading(false)
  }, [])

  const login = async (username: string, password: string) => {
    const { data } = await apiClient.post("/api/auth/login", { username, password })
    const userData: User = {
      username: data.username,
      email: data.email,
      roles: data.roles,
      token: data.token,
    }
    localStorage.setItem("lyceum_user", JSON.stringify(userData))
    setUser(userData)
  }

  const register = async (username: string, password: string, email: string) => {
    const { data } = await apiClient.post("/api/auth/register", { username, password, email })
    const userData: User = {
      username: data.username,
      email: data.email,
      roles: data.roles,
      token: data.token,
    }
    localStorage.setItem("lyceum_user", JSON.stringify(userData))
    setUser(userData)
  }

  const logout = () => {
    localStorage.removeItem("lyceum_user")
    setUser(null)
  }

  const hasRole = (requiredRole: Role) => {
    if (!user) return false
    const requiredLevel = roleHierarchy[requiredRole]
    return user.roles.some((role) => roleHierarchy[role] >= requiredLevel)
  }

  return (
    <AuthContext.Provider value={{ user, login, register, logout, hasRole, isLoading }}>
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth() {
  const context = useContext(AuthContext)
  if (!context) {
    throw new Error("useAuth must be used within an AuthProvider")
  }
  return context
}
