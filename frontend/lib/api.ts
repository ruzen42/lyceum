const API_URL = process.env.NEXT_PUBLIC_API_URL || "http://localhost:8080"

// ─── Auth ────────────────────────────────────────────────────────────────────

export interface AuthResponse {
  token: string
  username: string
  email: string
  roles: string[]
}

export interface LoginRequest {
  username: string
  password: string
}

export interface RegisterRequest {
  username: string
  email: string
  password: string
}

// ─── News ────────────────────────────────────────────────────────────────────

export interface NewsItem {
  id: number
  title: string
  content: string
  imageUrl?: string
  category?: string
  createdAt: string
  user?: { username: string; email: string }
}

// ─── Achievements ─────────────────────────────────────────────────────────────

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

export interface AchievementCreateRequest {
  title: string
  description: string
  category: string
  studentName: string
  year: number
  place: string
  level: string
}

// ─── Portfolio ────────────────────────────────────────────────────────────────

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

// ─── Vacancy ──────────────────────────────────────────────────────────────────

export interface Vacancy {
  id: number
  title: string
  description?: string
  active: boolean
  createdAt: string
}

// ─── Stats ────────────────────────────────────────────────────────────────────

export interface SiteStats {
  newsCount: number
  achievementsCount: number
  portfolioCount: number
  applicationsCount: number
}

// ─── Admission ────────────────────────────────────────────────────────────────

export interface AdmissionApplicationRequest {
  parentName: string
  childName: string
  childAge: number
  phone: string
  email?: string
  classType: "1_CLASS" | "PRESCHOOL"
  message?: string
}

export interface AdmissionApplication {
  id: number
  parentName: string
  childName: string
  childAge: number
  phone: string
  email?: string
  classType: "1_CLASS" | "PRESCHOOL"
  message?: string
  status: "PENDING" | "REVIEWED" | "REJECTED"
  createdAt: string
}

// ─── Museum Exhibit ───────────────────────────────────────────────────────────

export interface MuseumExhibit {
  id: number
  title: string
  description: string
  htmlContent?: string
  imageUrls: string[]
  relatedExhibits?: MuseumExhibit[]
}

// ─── Classroom ────────────────────────────────────────────────────────────────

export interface Material {
  id: number
  title: string
  description?: string
  fileUrls: string[]
  author?: { username: string; email: string }
  createdAt: string
}

export interface Classroom {
  id: number
  title: string
  htmlContent?: string
  materials: Material[]
}

// ─── Fetch helpers ────────────────────────────────────────────────────────────

function getToken(): string | null {
  if (typeof window === "undefined") return null
  return localStorage.getItem("lyceum_token")
}

async function apiFetch<T>(path: string, options?: RequestInit): Promise<T> {
  const token = getToken()
  const headers: Record<string, string> = {
    "Content-Type": "application/json",
    ...(options?.headers as Record<string, string>),
  }
  if (token) headers["Authorization"] = `Bearer ${token}`

  const res = await fetch(`${API_URL}${path}`, { ...options, headers })
  if (!res.ok) throw new Error(`API error ${res.status}: ${path}`)
  if (res.status === 204 || res.headers.get("content-length") === "0") return undefined as T
  return res.json()
}

async function apiFetchMultipart<T>(path: string, formData: FormData): Promise<T> {
  const token = getToken()
  const headers: Record<string, string> = {}
  if (token) headers["Authorization"] = `Bearer ${token}`

  const res = await fetch(`${API_URL}${path}`, {
    method: "POST",
    headers,
    body: formData,
  })
  if (!res.ok) throw new Error(`API error ${res.status}: ${path}`)
  return res.json()
}

// ─── API ──────────────────────────────────────────────────────────────────────

export const api = {
  auth: {
    login: (data: LoginRequest) =>
      apiFetch<AuthResponse>("/api/auth/login", { method: "POST", body: JSON.stringify(data) }),
    register: (data: RegisterRequest) =>
      apiFetch<AuthResponse>("/api/auth/register", { method: "POST", body: JSON.stringify(data) }),
  },

  news: {
    getAll: () => apiFetch<NewsItem[]>("/api/news/get-all"),
    create: (formData: FormData) => apiFetchMultipart<NewsItem>("/api/news/new", formData),
  },

  achievements: {
    getAll: () => apiFetch<Achievement[]>("/api/achievements/get-all"),
    create: (data: AchievementCreateRequest) =>
      apiFetch<Achievement>("/api/achievements/new", { method: "POST", body: JSON.stringify(data) }),
  },

  portfolio: {
    getAll: () => apiFetch<StudentPortfolio[]>("/api/portfolio/get-all"),
    create: (formData: FormData) => apiFetchMultipart<StudentPortfolio>("/api/portfolio/new", formData),
  },

  vacancies: {
    getAll: () => apiFetch<Vacancy[]>("/api/vacancies/get-all"),
    create: (title: string, description: string) =>
      apiFetch<Vacancy>(`/api/vacancies/new?title=${encodeURIComponent(title)}&description=${encodeURIComponent(description)}`, { method: "POST" }),
    delete: (id: number) =>
      apiFetch<void>(`/api/vacancies/${id}`, { method: "DELETE" }),
  },

  stats: {
    get: () => apiFetch<SiteStats>("/api/stats"),
  },

  admission: {
    apply: (data: AdmissionApplicationRequest) =>
      apiFetch<{ id: number }>("/api/admission/apply", { method: "POST", body: JSON.stringify(data) }),
    getAll: () => apiFetch<AdmissionApplication[]>("/api/admission/get-all"),
  },

  museum: {
    getAll: () => apiFetch<MuseumExhibit[]>("/api/museum-exhibit/get-all"),
    getById: (id: number) => apiFetch<MuseumExhibit>(`/api/museum-exhibit/${id}`),
    getHtml: (id: number) => apiFetch<string>(`/api/museum-exhibit/${id}/html`),
    create: (formData: FormData) => apiFetchMultipart<MuseumExhibit>("/api/museum-exhibit/create", formData),
    regenerateHtml: (id: number) =>
      apiFetch<MuseumExhibit>(`/api/museum-exhibit/${id}/regenerate-html`, { method: "POST" }),
  },

  classroom: {
    getAll: () => apiFetch<Classroom[]>("/api/classroom/get-all"),
    getById: (id: number) => apiFetch<Classroom>(`/api/classroom/${id}`),
    getHtml: (id: number) => apiFetch<string>(`/api/classroom/${id}/html`),
    create: (title: string) =>
      apiFetch<Classroom>(`/api/classroom/create?title=${encodeURIComponent(title)}`, { method: "POST" }),
    addMaterial: (id: number, formData: FormData) =>
      apiFetchMultipart<Material>(`/api/classroom/${id}/material`, formData),
    deleteMaterial: (materialId: number) =>
      apiFetch<void>(`/api/classroom/material/${materialId}`, { method: "DELETE" }),
    regenerateHtml: (id: number) =>
      apiFetch<Classroom>(`/api/classroom/${id}/regenerate-html`, { method: "POST" }),
  },
}
