"use client"

import { useState } from "react"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle } from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "@/components/ui/textarea"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"
import { Phone, CalendarCheck, Users, CheckCircle2, FileText, Loader2, ExternalLink } from "lucide-react"
import { api, type AdmissionApplicationRequest, type Vacancy } from "@/lib/api"
import { useApiData } from "@/hooks/use-api-data"

const FALLBACK_VACANCIES: Vacancy[] = [
  { id: 1, title: "Заместитель директора по учебной работе", active: true, createdAt: "" },
  { id: 2, title: "Учитель биологии", active: true, createdAt: "" },
  { id: 3, title: "Учитель начальных классов", active: true, createdAt: "" },
  { id: 4, title: "Социальный педагог", active: true, createdAt: "" },
  { id: 5, title: "Педагог-психолог", active: true, createdAt: "" },
  { id: 6, title: "Учитель художественного труда", active: true, createdAt: "" },
]

const admissionOptions = [
  {
    value: "1_CLASS" as const,
    title: "1 класс",
    description: "Запись на вступительное диагностическое собеседование",
    phone: "500-716, 467-046",
    icon: Users,
    status: "Запись открыта",
  },
  {
    value: "PRESCHOOL" as const,
    title: "Предшкольный класс",
    description: "Подготовка к школе для будущих первоклассников",
    phone: "46-70-46",
    icon: CalendarCheck,
    status: "Идёт набор",
  },
]

const EMPTY_FORM: AdmissionApplicationRequest = {
  parentName: "",
  childName: "",
  childAge: 6,
  phone: "",
  email: "",
  classType: "1_CLASS",
  message: "",
}

export function AdmissionSection() {
  const [dialogOpen, setDialogOpen] = useState(false)
  const [form, setForm] = useState<AdmissionApplicationRequest>(EMPTY_FORM)
  const [submitting, setSubmitting] = useState(false)
  const [submitted, setSubmitted] = useState(false)
  const [error, setError] = useState<string | null>(null)

  const { data: vacancies } = useApiData(api.vacancies.getAll, FALLBACK_VACANCIES)

  function openDialog(classType: "1_CLASS" | "PRESCHOOL") {
    setForm({ ...EMPTY_FORM, classType })
    setSubmitted(false)
    setError(null)
    setDialogOpen(true)
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault()
    setSubmitting(true)
    setError(null)
    try {
      await api.admission.apply(form)
      setSubmitted(true)
    } catch {
      setError("Не удалось отправить заявку. Попробуйте позже или позвоните нам.")
    } finally {
      setSubmitting(false)
    }
  }

  return (
    <section id="admission" className="bg-muted/50 py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="text-center">
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Поступление в лицей
          </h2>
          <p className="mt-2 text-muted-foreground">
            Информация для родителей и будущих лицеистов
          </p>
        </div>

        <div className="mt-12 grid grid-cols-1 gap-6 lg:grid-cols-2">
          {admissionOptions.map((item) => (
            <Card key={item.value} className="relative overflow-hidden">
              <div className="absolute right-0 top-0 h-32 w-32 -translate-y-8 translate-x-8 rounded-full bg-primary/5" />
              <CardHeader>
                <div className="flex items-start justify-between">
                  <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-primary/10">
                    <item.icon className="h-6 w-6 text-primary" />
                  </div>
                  <span className="inline-flex items-center gap-1 text-sm font-medium text-green-600">
                    <CheckCircle2 className="h-4 w-4" />
                    {item.status}
                  </span>
                </div>
                <CardTitle className="mt-4 text-xl">{item.title}</CardTitle>
                <CardDescription className="text-base">{item.description}</CardDescription>
              </CardHeader>
              <CardContent>
                <div className="flex items-center gap-2 text-sm text-muted-foreground">
                  <Phone className="h-4 w-4" />
                  <span>Справки по телефону: {item.phone}</span>
                </div>
                <Button className="mt-4 w-full" onClick={() => openDialog(item.value)}>
                  Записаться
                </Button>
              </CardContent>
            </Card>
          ))}
        </div>

        <Card className="mt-8">
          <CardHeader>
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-accent/10">
                <FileText className="h-5 w-5 text-accent" />
              </div>
              <div>
                <CardTitle>Вакансии</CardTitle>
                <CardDescription>
                  КГУ «Первый городской общеобразовательный IT-лицей» объявляет конкурс
                </CardDescription>
              </div>
            </div>
          </CardHeader>
          <CardContent>
            {vacancies.length === 0 ? (
              <p className="text-sm text-muted-foreground">Открытых вакансий нет</p>
            ) : (
              <div className="grid grid-cols-1 gap-2 sm:grid-cols-2 md:grid-cols-3">
                {vacancies.map((v) => (
                  <div key={v.id} className="flex items-center gap-2 rounded-lg bg-muted/50 px-3 py-2 text-sm">
                    <CheckCircle2 className="h-4 w-4 shrink-0 text-accent" />
                    <span>{v.title}</span>
                  </div>
                ))}
              </div>
            )}
            <div className="mt-6 flex flex-col gap-3 sm:flex-row sm:items-center sm:justify-between">
              <p className="text-sm text-muted-foreground">
                Документы принимаются на сайте hr-nobd.edu.kz
              </p>
              <Button variant="outline" asChild>
                <a href="https://hr-nobd.edu.kz" target="_blank" rel="noopener noreferrer">
                  Подать заявку
                  <ExternalLink className="ml-2 h-3.5 w-3.5" />
                </a>
              </Button>
            </div>
          </CardContent>
        </Card>
      </div>

      <Dialog open={dialogOpen} onOpenChange={setDialogOpen}>
        <DialogContent className="max-w-lg">
          <DialogHeader>
            <DialogTitle>Запись на собеседование</DialogTitle>
            <DialogDescription>
              Заполните форму — мы свяжемся с вами для подтверждения даты.
            </DialogDescription>
          </DialogHeader>

          {submitted ? (
            <div className="flex flex-col items-center gap-3 py-6 text-center">
              <div className="flex h-14 w-14 items-center justify-center rounded-full bg-green-500/10">
                <CheckCircle2 className="h-7 w-7 text-green-600" />
              </div>
              <p className="text-lg font-semibold">Заявка отправлена!</p>
              <p className="text-sm text-muted-foreground">
                Мы получили вашу заявку и свяжемся с вами в ближайшее время.
              </p>
              <Button className="mt-2" onClick={() => setDialogOpen(false)}>
                Закрыть
              </Button>
            </div>
          ) : (
            <form onSubmit={handleSubmit} className="space-y-4">
              <div className="grid grid-cols-2 gap-4">
                <div className="space-y-1.5">
                  <Label htmlFor="parentName">ФИО родителя *</Label>
                  <Input
                    id="parentName"
                    value={form.parentName}
                    onChange={(e) => setForm({ ...form, parentName: e.target.value })}
                    required
                    placeholder="Иванова Анна"
                  />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="childName">ФИО ребёнка *</Label>
                  <Input
                    id="childName"
                    value={form.childName}
                    onChange={(e) => setForm({ ...form, childName: e.target.value })}
                    required
                    placeholder="Иванов Дмитрий"
                  />
                </div>
              </div>

              <div className="grid grid-cols-2 gap-4">
                <div className="space-y-1.5">
                  <Label htmlFor="childAge">Возраст ребёнка *</Label>
                  <Input
                    id="childAge"
                    type="number"
                    min={4}
                    max={18}
                    value={form.childAge}
                    onChange={(e) => setForm({ ...form, childAge: parseInt(e.target.value) || 6 })}
                    required
                  />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="classType">Тип записи *</Label>
                  <Select
                    value={form.classType}
                    onValueChange={(v) => setForm({ ...form, classType: v as "1_CLASS" | "PRESCHOOL" })}
                  >
                    <SelectTrigger id="classType">
                      <SelectValue />
                    </SelectTrigger>
                    <SelectContent>
                      <SelectItem value="1_CLASS">1 класс</SelectItem>
                      <SelectItem value="PRESCHOOL">Предшкольный класс</SelectItem>
                    </SelectContent>
                  </Select>
                </div>
              </div>

              <div className="space-y-1.5">
                <Label htmlFor="phone">Телефон *</Label>
                <Input
                  id="phone"
                  type="tel"
                  value={form.phone}
                  onChange={(e) => setForm({ ...form, phone: e.target.value })}
                  required
                  placeholder="+7 (777) 000-00-00"
                />
              </div>

              <div className="space-y-1.5">
                <Label htmlFor="email">Email</Label>
                <Input
                  id="email"
                  type="email"
                  value={form.email}
                  onChange={(e) => setForm({ ...form, email: e.target.value })}
                  placeholder="example@mail.ru"
                />
              </div>

              <div className="space-y-1.5">
                <Label htmlFor="message">Дополнительно</Label>
                <Textarea
                  id="message"
                  value={form.message}
                  onChange={(e) => setForm({ ...form, message: e.target.value })}
                  placeholder="Вопросы или пожелания..."
                  rows={3}
                />
              </div>

              {error && <p className="text-sm text-destructive">{error}</p>}

              <div className="flex justify-end gap-3 pt-2">
                <Button type="button" variant="outline" onClick={() => setDialogOpen(false)}>
                  Отмена
                </Button>
                <Button type="submit" disabled={submitting}>
                  {submitting && <Loader2 className="mr-2 h-4 w-4 animate-spin" />}
                  Отправить заявку
                </Button>
              </div>
            </form>
          )}
        </DialogContent>
      </Dialog>
    </section>
  )
}
