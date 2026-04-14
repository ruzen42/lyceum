"use client"

import { useEffect, useState, useCallback } from "react"
import { useRouter } from "next/navigation"
import Link from "next/link"
import {
  Loader2, Plus, Trash2, GraduationCap, LogOut, RefreshCw,
  Newspaper, Trophy, User, Briefcase, Landmark, BookOpen, FileText, Paperclip,
} from "lucide-react"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "@/components/ui/textarea"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Badge } from "@/components/ui/badge"
import {
  api,
  type NewsItem, type Achievement, type StudentPortfolio,
  type Vacancy, type AdmissionApplication, type MuseumExhibit, type Classroom,
  type AchievementCreateRequest,
} from "@/lib/api"
import { useAuth } from "@/contexts/auth-context"

// ─── Helpers ─────────────────────────────────────────────────────────────────

function formatDate(iso: string) {
  if (!iso) return "—"
  return new Date(iso).toLocaleDateString("ru-RU", { day: "2-digit", month: "2-digit", year: "numeric" })
}

function SectionLoader() {
  return (
    <div className="flex items-center justify-center py-12">
      <Loader2 className="h-6 w-6 animate-spin text-primary" />
    </div>
  )
}

function EmptyState({ text }: { text: string }) {
  return <p className="py-8 text-center text-sm text-muted-foreground">{text}</p>
}

// ─── News Tab ─────────────────────────────────────────────────────────────────

function NewsTab() {
  const [news, setNews] = useState<NewsItem[]>([])
  const [loading, setLoading] = useState(true)
  const [title, setTitle] = useState("")
  const [content, setContent] = useState("")
  const [category, setCategory] = useState("")
  const [image, setImage] = useState<File | null>(null)
  const [submitting, setSubmitting] = useState(false)
  const [error, setError] = useState<string | null>(null)

  const loadNews = useCallback(() => {
    setLoading(true)
    api.news.getAll()
      .then(setNews)
      .catch(() => {})
      .finally(() => setLoading(false))
  }, [])

  useEffect(() => { loadNews() }, [loadNews])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const fd = new FormData()
      fd.append("title", title)
      fd.append("content", content)
      if (category) fd.append("category", category)
      if (image) fd.append("image", image)
      const created = await api.news.create(fd)
      setNews((prev) => [created, ...prev])
      setTitle(""); setContent(""); setCategory(""); setImage(null)
    } catch {
      setError("Не удалось создать новость")
    } finally {
      setSubmitting(false)
    }
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новая новость</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="space-y-3">
            <div className="grid grid-cols-2 gap-3">
              <div className="space-y-1.5">
                <Label>Заголовок *</Label>
                <Input value={title} onChange={(e) => setTitle(e.target.value)} required placeholder="Заголовок новости" />
              </div>
              <div className="space-y-1.5">
                <Label>Категория</Label>
                <Input value={category} onChange={(e) => setCategory(e.target.value)} placeholder="Мероприятия" />
              </div>
            </div>
            <div className="space-y-1.5">
              <Label>Содержание *</Label>
              <Textarea value={content} onChange={(e) => setContent(e.target.value)} required rows={3} placeholder="Текст новости..." />
            </div>
            <div className="space-y-1.5">
              <Label>Изображение</Label>
              <Input type="file" accept="image/*" onChange={(e) => setImage(e.target.files?.[0] ?? null)} />
            </div>
            {error && <p className="text-sm text-destructive">{error}</p>}
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Добавить
            </Button>
          </form>
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : news.length === 0 ? <EmptyState text="Новостей нет" /> : (
        <div className="space-y-3">
          {news.map((item) => (
            <div key={item.id} className="flex items-start gap-3 rounded-lg border bg-card p-3">
              {item.imageUrl && (
                <img src={item.imageUrl} alt={item.title} className="h-14 w-14 rounded-md object-cover shrink-0" />
              )}
              <div className="min-w-0 flex-1">
                <div className="flex items-center gap-2">
                  <span className="font-medium text-sm truncate">{item.title}</span>
                  {item.category && <Badge variant="secondary" className="text-xs shrink-0">{item.category}</Badge>}
                </div>
                <p className="text-xs text-muted-foreground mt-0.5 line-clamp-2">{item.content}</p>
                <p className="text-xs text-muted-foreground mt-1">{formatDate(item.createdAt)}</p>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

// ─── Achievements Tab ─────────────────────────────────────────────────────────

function AchievementsTab() {
  const [items, setItems] = useState<Achievement[]>([])
  const [loading, setLoading] = useState(true)
  const [form, setForm] = useState<AchievementCreateRequest>({
    title: "", description: "", category: "", studentName: "", year: new Date().getFullYear(), place: "", level: "",
  })
  const [submitting, setSubmitting] = useState(false)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    api.achievements.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const created = await api.achievements.create(form)
      setItems((prev) => [created, ...prev])
      setForm({ title: "", description: "", category: "", studentName: "", year: new Date().getFullYear(), place: "", level: "" })
    } catch {
      setError("Не удалось добавить достижение")
    } finally {
      setSubmitting(false)
    }
  }

  const set = (k: keyof AchievementCreateRequest) => (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) =>
    setForm((prev) => ({ ...prev, [k]: k === "year" ? parseInt(e.target.value) || 0 : e.target.value }))

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новое достижение</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="space-y-3">
            <div className="grid grid-cols-2 gap-3">
              <div className="space-y-1.5">
                <Label>Заголовок *</Label>
                <Input value={form.title} onChange={set("title")} required placeholder="Олимпиада по математике" />
              </div>
              <div className="space-y-1.5">
                <Label>Ученик *</Label>
                <Input value={form.studentName} onChange={set("studentName")} required placeholder="Айдар Сейткали" />
              </div>
            </div>
            <div className="grid grid-cols-3 gap-3">
              <div className="space-y-1.5">
                <Label>Категория</Label>
                <Input value={form.category} onChange={set("category")} placeholder="Математика" />
              </div>
              <div className="space-y-1.5">
                <Label>Место</Label>
                <Input value={form.place} onChange={set("place")} placeholder="1 место" />
              </div>
              <div className="space-y-1.5">
                <Label>Год</Label>
                <Input type="number" value={form.year} onChange={set("year")} />
              </div>
            </div>
            <div className="space-y-1.5">
              <Label>Уровень</Label>
              <Input value={form.level} onChange={set("level")} placeholder="Республиканский / Международный / Городской" />
            </div>
            <div className="space-y-1.5">
              <Label>Описание</Label>
              <Textarea value={form.description} onChange={set("description")} rows={2} placeholder="Подробности..." />
            </div>
            {error && <p className="text-sm text-destructive">{error}</p>}
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Добавить
            </Button>
          </form>
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Достижений нет" /> : (
        <div className="space-y-2">
          {items.map((item) => (
            <div key={item.id} className="flex items-center gap-3 rounded-lg border bg-card px-4 py-3">
              <Trophy className="h-5 w-5 shrink-0 text-yellow-500" />
              <div className="min-w-0 flex-1">
                <p className="text-sm font-medium truncate">{item.title}</p>
                <p className="text-xs text-muted-foreground">{item.studentName} · {item.place} · {item.year}</p>
              </div>
              {item.level && <Badge variant="outline" className="text-xs shrink-0">{item.level}</Badge>}
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

// ─── Portfolio Tab ─────────────────────────────────────────────────────────────

function PortfolioTab() {
  const [items, setItems] = useState<StudentPortfolio[]>([])
  const [loading, setLoading] = useState(true)
  const [studentName, setStudentName] = useState("")
  const [grade, setGrade] = useState("")
  const [bio, setBio] = useState("")
  const [skillsRaw, setSkillsRaw] = useState("")
  const [achievementsRaw, setAchievementsRaw] = useState("")
  const [image, setImage] = useState<File | null>(null)
  const [submitting, setSubmitting] = useState(false)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    api.portfolio.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const fd = new FormData()
      fd.append("studentName", studentName)
      fd.append("grade", grade)
      fd.append("bio", bio)
      skillsRaw.split(",").map((s) => s.trim()).filter(Boolean).forEach((s) => fd.append("skills", s))
      achievementsRaw.split("\n").map((s) => s.trim()).filter(Boolean).forEach((a) => fd.append("achievements", a))
      if (image) fd.append("image", image)
      const created = await api.portfolio.create(fd)
      setItems((prev) => [created, ...prev])
      setStudentName(""); setGrade(""); setBio(""); setSkillsRaw(""); setAchievementsRaw(""); setImage(null)
    } catch {
      setError("Не удалось добавить портфолио")
    } finally {
      setSubmitting(false)
    }
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новое портфолио</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="space-y-3">
            <div className="grid grid-cols-2 gap-3">
              <div className="space-y-1.5">
                <Label>ФИО ученика *</Label>
                <Input value={studentName} onChange={(e) => setStudentName(e.target.value)} required placeholder="Айдар Сейткали" />
              </div>
              <div className="space-y-1.5">
                <Label>Класс *</Label>
                <Input value={grade} onChange={(e) => setGrade(e.target.value)} required placeholder="11А" />
              </div>
            </div>
            <div className="space-y-1.5">
              <Label>О себе *</Label>
              <Textarea value={bio} onChange={(e) => setBio(e.target.value)} required rows={2} placeholder="Краткая биография..." />
            </div>
            <div className="space-y-1.5">
              <Label>Навыки (через запятую)</Label>
              <Input value={skillsRaw} onChange={(e) => setSkillsRaw(e.target.value)} placeholder="Python, SQL, Алгоритмы" />
            </div>
            <div className="space-y-1.5">
              <Label>Достижения (каждое с новой строки)</Label>
              <Textarea value={achievementsRaw} onChange={(e) => setAchievementsRaw(e.target.value)} rows={3} placeholder={"1 место — Олимпиада\nПризёр хакатона"} />
            </div>
            <div className="space-y-1.5">
              <Label>Фото</Label>
              <Input type="file" accept="image/*" onChange={(e) => setImage(e.target.files?.[0] ?? null)} />
            </div>
            {error && <p className="text-sm text-destructive">{error}</p>}
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Добавить
            </Button>
          </form>
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Портфолио нет" /> : (
        <div className="grid grid-cols-1 gap-3 sm:grid-cols-2">
          {items.map((p) => (
            <div key={p.id} className="flex items-start gap-3 rounded-lg border bg-card p-3">
              {p.imageUrl ? (
                <img src={p.imageUrl} alt={p.studentName} className="h-12 w-12 rounded-full object-cover shrink-0" />
              ) : (
                <div className="flex h-12 w-12 shrink-0 items-center justify-center rounded-full bg-muted">
                  <User className="h-5 w-5 text-muted-foreground" />
                </div>
              )}
              <div className="min-w-0">
                <p className="text-sm font-medium">{p.studentName}</p>
                <p className="text-xs text-muted-foreground">{p.grade} класс</p>
                <div className="mt-1 flex flex-wrap gap-1">
                  {p.skills.slice(0, 3).map((s) => (
                    <Badge key={s} variant="secondary" className="text-xs">{s}</Badge>
                  ))}
                </div>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

// ─── Vacancies Tab ────────────────────────────────────────────────────────────

function VacanciesTab() {
  const [items, setItems] = useState<Vacancy[]>([])
  const [loading, setLoading] = useState(true)
  const [title, setTitle] = useState("")
  const [description, setDescription] = useState("")
  const [submitting, setSubmitting] = useState(false)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    api.vacancies.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const created = await api.vacancies.create(title, description)
      setItems((prev) => [created, ...prev])
      setTitle(""); setDescription("")
    } catch {
      setError("Не удалось добавить вакансию")
    } finally {
      setSubmitting(false)
    }
  }

  async function handleDelete(id: number) {
    try {
      await api.vacancies.delete(id)
      setItems((prev) => prev.filter((v) => v.id !== id))
    } catch {}
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новая вакансия</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="space-y-3">
            <div className="space-y-1.5">
              <Label>Должность *</Label>
              <Input value={title} onChange={(e) => setTitle(e.target.value)} required placeholder="Учитель математики" />
            </div>
            <div className="space-y-1.5">
              <Label>Описание</Label>
              <Textarea value={description} onChange={(e) => setDescription(e.target.value)} rows={2} placeholder="Требования и условия..." />
            </div>
            {error && <p className="text-sm text-destructive">{error}</p>}
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Добавить
            </Button>
          </form>
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Вакансий нет" /> : (
        <div className="space-y-2">
          {items.map((v) => (
            <div key={v.id} className="flex items-center gap-3 rounded-lg border bg-card px-4 py-3">
              <Briefcase className="h-4 w-4 shrink-0 text-muted-foreground" />
              <div className="min-w-0 flex-1">
                <p className="text-sm font-medium truncate">{v.title}</p>
                {v.description && <p className="text-xs text-muted-foreground line-clamp-1">{v.description}</p>}
              </div>
              <Button variant="ghost" size="icon" className="shrink-0 h-8 w-8 text-destructive hover:text-destructive" onClick={() => handleDelete(v.id)}>
                <Trash2 className="h-4 w-4" />
              </Button>
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

// ─── Museum Tab ───────────────────────────────────────────────────────────────

function MuseumTab() {
  const [items, setItems] = useState<MuseumExhibit[]>([])
  const [loading, setLoading] = useState(true)
  const [title, setTitle] = useState("")
  const [description, setDescription] = useState("")
  const [images, setImages] = useState<FileList | null>(null)
  const [submitting, setSubmitting] = useState(false)
  const [regenerating, setRegenerating] = useState<number | null>(null)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    api.museum.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const fd = new FormData()
      fd.append("title", title)
      fd.append("description", description)
      if (images) Array.from(images).forEach((f) => fd.append("images", f))
      const created = await api.museum.create(fd)
      setItems((prev) => [created, ...prev])
      setTitle(""); setDescription(""); setImages(null)
    } catch {
      setError("Не удалось добавить экспонат")
    } finally {
      setSubmitting(false)
    }
  }

  async function handleRegenerate(id: number) {
    setRegenerating(id)
    try {
      const updated = await api.museum.regenerateHtml(id)
      setItems((prev) => prev.map((x) => x.id === id ? updated : x))
    } catch {}
    finally { setRegenerating(null) }
  }

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новый экспонат</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="space-y-3">
            <div className="space-y-1.5">
              <Label>Название *</Label>
              <Input value={title} onChange={(e) => setTitle(e.target.value)} required placeholder="Первый компьютер лицея" />
            </div>
            <div className="space-y-1.5">
              <Label>Описание *</Label>
              <Textarea value={description} onChange={(e) => setDescription(e.target.value)} required rows={3} placeholder="История экспоната..." />
            </div>
            <div className="space-y-1.5">
              <Label>Изображения</Label>
              <Input type="file" accept="image/*" multiple onChange={(e) => setImages(e.target.files)} />
            </div>
            {error && <p className="text-sm text-destructive">{error}</p>}
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Добавить
            </Button>
          </form>
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Экспонатов нет" /> : (
        <div className="space-y-3">
          {items.map((item) => (
            <div key={item.id} className="flex items-start gap-3 rounded-lg border bg-card p-3">
              {item.imageUrls?.[0] ? (
                <img src={item.imageUrls[0]} alt={item.title} className="h-16 w-16 rounded-md object-cover shrink-0" />
              ) : (
                <div className="flex h-16 w-16 shrink-0 items-center justify-center rounded-md bg-muted">
                  <Landmark className="h-6 w-6 text-muted-foreground" />
                </div>
              )}
              <div className="min-w-0 flex-1">
                <p className="text-sm font-medium">{item.title}</p>
                <p className="text-xs text-muted-foreground line-clamp-2 mt-0.5">{item.description}</p>
                {item.imageUrls?.length > 1 && (
                  <p className="text-xs text-muted-foreground mt-0.5">{item.imageUrls.length} фото</p>
                )}
              </div>
              <Button
                variant="outline"
                size="sm"
                className="shrink-0"
                onClick={() => handleRegenerate(item.id)}
                disabled={regenerating === item.id}
              >
                {regenerating === item.id ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <RefreshCw className="h-3.5 w-3.5" />}
                <span className="ml-1.5 hidden sm:inline">AI</span>
              </Button>
            </div>
          ))}
        </div>
      )}
    </div>
  )
}

// ─── Classrooms Tab ───────────────────────────────────────────────────────────

function ClassroomsTab() {
  const [items, setItems] = useState<Classroom[]>([])
  const [loading, setLoading] = useState(true)
  const [title, setTitle] = useState("")
  const [submitting, setSubmitting] = useState(false)
  const [error, setError] = useState<string | null>(null)
  const [selectedClassroom, setSelectedClassroom] = useState<number | null>(null)
  const [matTitle, setMatTitle] = useState("")
  const [matDesc, setMatDesc] = useState("")
  const [matFiles, setMatFiles] = useState<FileList | null>(null)
  const [matSubmitting, setMatSubmitting] = useState(false)
  const [regenerating, setRegenerating] = useState<number | null>(null)

  useEffect(() => {
    api.classroom.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  async function handleCreate(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      const created = await api.classroom.create(title)
      setItems((prev) => [created, ...prev])
      setTitle("")
    } catch {
      setError("Не удалось создать класс")
    } finally {
      setSubmitting(false)
    }
  }

  async function handleAddMaterial(e: React.FormEvent) {
    e.preventDefault()
    if (!selectedClassroom) return
    setMatSubmitting(true)
    try {
      const fd = new FormData()
      fd.append("title", matTitle)
      if (matDesc) fd.append("description", matDesc)
      if (matFiles) Array.from(matFiles).forEach((f) => fd.append("files", f))
      const material = await api.classroom.addMaterial(selectedClassroom, fd)
      setItems((prev) => prev.map((c) => c.id === selectedClassroom
        ? { ...c, materials: [...c.materials, material] }
        : c
      ))
      setMatTitle(""); setMatDesc(""); setMatFiles(null)
    } catch {}
    finally { setMatSubmitting(false) }
  }

  async function handleDeleteMaterial(classroomId: number, materialId: number) {
    try {
      await api.classroom.deleteMaterial(materialId)
      setItems((prev) => prev.map((c) => c.id === classroomId
        ? { ...c, materials: c.materials.filter((m) => m.id !== materialId) }
        : c
      ))
    } catch {}
  }

  async function handleRegenerate(id: number) {
    setRegenerating(id)
    try {
      const updated = await api.classroom.regenerateHtml(id)
      setItems((prev) => prev.map((c) => c.id === id ? updated : c))
    } catch {}
    finally { setRegenerating(null) }
  }

  const active = items.find((c) => c.id === selectedClassroom)

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader><CardTitle className="text-base">Новый класс</CardTitle></CardHeader>
        <CardContent>
          <form onSubmit={handleCreate} className="flex gap-3">
            <Input
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
              placeholder="Название класса"
              className="flex-1"
            />
            <Button type="submit" disabled={submitting} size="sm">
              {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
              <Plus className="mr-1.5 h-4 w-4" />
              Создать
            </Button>
          </form>
          {error && <p className="mt-2 text-sm text-destructive">{error}</p>}
        </CardContent>
      </Card>

      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Классов нет" /> : (
        <div className="grid grid-cols-1 gap-4 lg:grid-cols-2">
          <div className="space-y-2">
            {items.map((c) => (
              <div
                key={c.id}
                className={`cursor-pointer rounded-lg border p-3 transition-colors ${selectedClassroom === c.id ? "border-primary bg-primary/5" : "bg-card hover:bg-muted/50"}`}
                onClick={() => setSelectedClassroom(c.id === selectedClassroom ? null : c.id)}
              >
                <div className="flex items-center justify-between">
                  <div className="flex items-center gap-2">
                    <BookOpen className="h-4 w-4 text-primary" />
                    <span className="text-sm font-medium">{c.title}</span>
                  </div>
                  <div className="flex items-center gap-2">
                    <Badge variant="secondary" className="text-xs">{c.materials.length} матер.</Badge>
                    <Button
                      variant="ghost"
                      size="icon"
                      className="h-7 w-7"
                      onClick={(e) => { e.stopPropagation(); handleRegenerate(c.id) }}
                      disabled={regenerating === c.id}
                    >
                      {regenerating === c.id ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <RefreshCw className="h-3.5 w-3.5" />}
                    </Button>
                  </div>
                </div>
              </div>
            ))}
          </div>

          {active && (
            <div className="space-y-3">
              <p className="text-sm font-semibold text-muted-foreground">Материалы: {active.title}</p>

              <form onSubmit={handleAddMaterial} className="space-y-2 rounded-lg border bg-card p-3">
                <Input value={matTitle} onChange={(e) => setMatTitle(e.target.value)} required placeholder="Название материала" />
                <Input value={matDesc} onChange={(e) => setMatDesc(e.target.value)} placeholder="Описание (необязательно)" />
                <Input type="file" multiple onChange={(e) => setMatFiles(e.target.files)} />
                <Button type="submit" size="sm" disabled={matSubmitting}>
                  {matSubmitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
                  <Plus className="mr-1.5 h-4 w-4" />
                  Добавить материал
                </Button>
              </form>

              {active.materials.length === 0 ? (
                <EmptyState text="Материалов нет" />
              ) : (
                <div className="space-y-2">
                  {active.materials.map((mat) => (
                    <div key={mat.id} className="flex items-start gap-2 rounded-lg border bg-card p-3">
                      <FileText className="h-4 w-4 shrink-0 mt-0.5 text-muted-foreground" />
                      <div className="min-w-0 flex-1">
                        <p className="text-sm font-medium">{mat.title}</p>
                        {mat.description && <p className="text-xs text-muted-foreground line-clamp-1">{mat.description}</p>}
                        {mat.fileUrls?.length > 0 && (
                          <p className="text-xs text-muted-foreground mt-0.5 flex items-center gap-1">
                            <Paperclip className="h-3 w-3" />{mat.fileUrls.length} файл(а)
                          </p>
                        )}
                      </div>
                      <Button
                        variant="ghost"
                        size="icon"
                        className="h-7 w-7 text-destructive hover:text-destructive shrink-0"
                        onClick={() => handleDeleteMaterial(active.id, mat.id)}
                      >
                        <Trash2 className="h-3.5 w-3.5" />
                      </Button>
                    </div>
                  ))}
                </div>
              )}
            </div>
          )}
        </div>
      )}
    </div>
  )
}

// ─── Admissions Tab ───────────────────────────────────────────────────────────

function AdmissionsTab() {
  const [items, setItems] = useState<AdmissionApplication[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    api.admission.getAll().then(setItems).catch(() => {}).finally(() => setLoading(false))
  }, [])

  const statusLabel: Record<AdmissionApplication["status"], string> = {
    PENDING: "На рассмотрении",
    REVIEWED: "Рассмотрена",
    REJECTED: "Отклонена",
  }
  const statusColor: Record<AdmissionApplication["status"], string> = {
    PENDING: "bg-yellow-500/10 text-yellow-700",
    REVIEWED: "bg-green-500/10 text-green-700",
    REJECTED: "bg-red-500/10 text-red-700",
  }

  return (
    <div className="space-y-3">
      {loading ? <SectionLoader /> : items.length === 0 ? <EmptyState text="Заявок нет" /> : (
        items.map((app) => (
          <div key={app.id} className="rounded-lg border bg-card p-4">
            <div className="flex items-start justify-between gap-3">
              <div>
                <p className="text-sm font-medium">{app.childName}</p>
                <p className="text-xs text-muted-foreground">Родитель: {app.parentName} · {app.childAge} лет</p>
                <p className="text-xs text-muted-foreground mt-0.5">
                  {app.classType === "1_CLASS" ? "1 класс" : "Предшкольный"} · {app.phone}
                  {app.email && ` · ${app.email}`}
                </p>
                {app.message && <p className="mt-1.5 text-xs text-muted-foreground italic line-clamp-2">{app.message}</p>}
              </div>
              <div className="flex flex-col items-end gap-1.5 shrink-0">
                <span className={`rounded-full px-2 py-0.5 text-xs font-medium ${statusColor[app.status]}`}>
                  {statusLabel[app.status]}
                </span>
                <span className="text-xs text-muted-foreground">{formatDate(app.createdAt)}</span>
              </div>
            </div>
          </div>
        ))
      )}
    </div>
  )
}

// ─── Page ─────────────────────────────────────────────────────────────────────

export default function AdminPage() {
  const router = useRouter()
  const { username, isAdmin, isTeacher, logout } = useAuth()
  const [checked, setChecked] = useState(false)

  useEffect(() => {
    const token = localStorage.getItem("lyceum_token")
    if (!token) {
      router.replace("/")
    } else {
      setChecked(true)
    }
  }, [router])

  if (!checked) {
    return (
      <div className="flex min-h-screen items-center justify-center">
        <Loader2 className="h-8 w-8 animate-spin text-primary" />
      </div>
    )
  }

  return (
    <div className="min-h-screen bg-muted/30">
      <header className="sticky top-0 z-50 border-b border-border/50 bg-background/95 backdrop-blur">
        <div className="mx-auto flex h-14 max-w-6xl items-center justify-between px-4 sm:px-6">
          <div className="flex items-center gap-3">
            <Link href="/" className="flex h-8 w-8 items-center justify-center rounded-lg bg-primary">
              <GraduationCap className="h-5 w-5 text-primary-foreground" />
            </Link>
            <span className="font-semibold">Панель управления</span>
          </div>
          <div className="flex items-center gap-3">
            <span className="text-sm text-muted-foreground hidden sm:block">{username}</span>
            <Button variant="ghost" size="sm" onClick={() => { logout(); router.push("/") }}>
              <LogOut className="h-4 w-4" />
              <span className="ml-1.5 hidden sm:inline">Выйти</span>
            </Button>
          </div>
        </div>
      </header>

      <main className="mx-auto max-w-6xl px-4 py-8 sm:px-6">
        <Tabs defaultValue="news">
          <TabsList className="mb-6 flex-wrap h-auto gap-1">
            <TabsTrigger value="news" className="gap-1.5">
              <Newspaper className="h-4 w-4" />Новости
            </TabsTrigger>
            <TabsTrigger value="achievements" className="gap-1.5">
              <Trophy className="h-4 w-4" />Достижения
            </TabsTrigger>
            <TabsTrigger value="portfolio" className="gap-1.5">
              <User className="h-4 w-4" />Портфолио
            </TabsTrigger>
            <TabsTrigger value="vacancies" className="gap-1.5">
              <Briefcase className="h-4 w-4" />Вакансии
            </TabsTrigger>
            <TabsTrigger value="museum" className="gap-1.5">
              <Landmark className="h-4 w-4" />Музей
            </TabsTrigger>
            {isAdmin && (
              <TabsTrigger value="classrooms" className="gap-1.5">
                <BookOpen className="h-4 w-4" />Классы
              </TabsTrigger>
            )}
            {isAdmin && (
              <TabsTrigger value="admissions" className="gap-1.5">
                <FileText className="h-4 w-4" />Заявки
              </TabsTrigger>
            )}
          </TabsList>

          <TabsContent value="news"><NewsTab /></TabsContent>
          <TabsContent value="achievements"><AchievementsTab /></TabsContent>
          <TabsContent value="portfolio"><PortfolioTab /></TabsContent>
          <TabsContent value="vacancies"><VacanciesTab /></TabsContent>
          <TabsContent value="museum"><MuseumTab /></TabsContent>
          {isAdmin && <TabsContent value="classrooms"><ClassroomsTab /></TabsContent>}
          {isAdmin && <TabsContent value="admissions"><AdmissionsTab /></TabsContent>}
        </Tabs>
      </main>
    </div>
  )
}
