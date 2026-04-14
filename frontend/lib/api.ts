const API_URL = process.env.NEXT_PUBLIC_API_URL || "http://localhost:8080"

export interface NewsItem {
  id: number
  title: string
  content: string
  imageUrl?: string
  category?: string
  createdAt: string
  user?: { username: string; email: string }
}

export interface Achievement {
  id: number
  title: string
  description: string
  category: string
  studentName: string
  year: number
  place: string
  level: string
  createdAt: string
}

export interface StudentPortfolio {
  id: number
  studentName: string
  grade: string
  bio: string
  imageUrl?: string
  skills: string[]
  achievements: string[]
  createdAt: string
}

async function apiFetch<T>(path: string, options?: RequestInit): Promise<T> {
  const res = await fetch(`${API_URL}${path}`, {
    headers: { "Content-Type": "application/json", ...options?.headers },
    ...options,
  })
  if (!res.ok) throw new Error(`API error ${res.status}: ${path}`)
  return res.json()
}

export const api = {
  news: {
    getAll: () => apiFetch<NewsItem[]>("/api/news/get-all"),
  },
  achievements: {
    getAll: () => apiFetch<Achievement[]>("/api/achievements/get-all"),
  },
  portfolio: {
    getAll: () => apiFetch<StudentPortfolio[]>("/api/portfolio/get-all"),
  },
}
