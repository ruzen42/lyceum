import axios from "axios"

export const API_BASE = "http://localhost:8080"

export const apiClient = axios.create({
  baseURL: API_BASE,
})

apiClient.interceptors.request.use((config) => {
  if (typeof window !== "undefined") {
    const stored = localStorage.getItem("lyceum_user")
    if (stored) {
      try {
        const token = JSON.parse(stored).token
        if (token) {
          config.headers.Authorization = `Bearer ${token}`
        }
      } catch {
        // ignore
      }
    }
  }
  return config
})

apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    const message =
      error.response?.data?.detail ||
      error.response?.data?.message ||
      error.message ||
      "Request failed"
    return Promise.reject(new Error(message))
  }
)

export function getHtmlUrl(type: "museum-exhibit" | "classroom", id: number): string {
  return `${API_BASE}/api/${type}/${id}/html`
}

export async function fetchHtml(type: "museum-exhibit" | "classroom", id: number): Promise<string> {
  const res = await apiClient.get<string>(`/api/${type}/${id}/html`, {
    headers: { Accept: "text/html" },
    responseType: "text",
  })
  return res.data
}
