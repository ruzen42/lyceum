"use client"

import { createContext, useContext, useEffect, useState, type ReactNode } from "react"
import { type AuthResponse } from "@/lib/api"

interface AuthContextValue {
  token: string | null
  username: string | null
  roles: string[]
  isAdmin: boolean
  isTeacher: boolean
  login: (res: AuthResponse) => void
  logout: () => void
}

const AuthContext = createContext<AuthContextValue>({
  token: null,
  username: null,
  roles: [],
  isAdmin: false,
  isTeacher: false,
  login: () => {},
  logout: () => {},
})

export function AuthProvider({ children }: { children: ReactNode }) {
  const [token, setToken] = useState<string | null>(null)
  const [username, setUsername] = useState<string | null>(null)
  const [roles, setRoles] = useState<string[]>([])

  useEffect(() => {
    const stored = localStorage.getItem("lyceum_token")
    const storedUser = localStorage.getItem("lyceum_username")
    const storedRoles = localStorage.getItem("lyceum_roles")
    if (stored) setToken(stored)
    if (storedUser) setUsername(storedUser)
    if (storedRoles) setRoles(JSON.parse(storedRoles))
  }, [])

  function login(res: AuthResponse) {
    localStorage.setItem("lyceum_token", res.token)
    localStorage.setItem("lyceum_username", res.username)
    localStorage.setItem("lyceum_roles", JSON.stringify(res.roles))
    setToken(res.token)
    setUsername(res.username)
    setRoles(res.roles)
  }

  function logout() {
    localStorage.removeItem("lyceum_token")
    localStorage.removeItem("lyceum_username")
    localStorage.removeItem("lyceum_roles")
    setToken(null)
    setUsername(null)
    setRoles([])
  }

  return (
    <AuthContext.Provider
      value={{
        token,
        username,
        roles,
        isAdmin: roles.includes("ROLE_ADMIN") || roles.includes("ADMIN"),
        isTeacher: roles.includes("ROLE_TEACHER") || roles.includes("TEACHER"),
        login,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth() {
  return useContext(AuthContext)
}
