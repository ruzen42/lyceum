"use client"

import { useEffect, useState } from "react"
import { Trophy, Medal, Star, Globe, MapPin, Loader2 } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { api, type Achievement } from "@/lib/api"

const LEVEL_COLORS: Record<string, string> = {
  Международный: "bg-yellow-500/10 text-yellow-600 border-yellow-500/20",
  Республиканский: "bg-purple-500/10 text-purple-600 border-purple-500/20",
  Областной: "bg-blue-500/10 text-blue-600 border-blue-500/20",
  Городской: "bg-green-500/10 text-green-600 border-green-500/20",
}

const FALLBACK: Achievement[] = [
  {
    id: 1,
    title: "Олимпиада по информатике",
    description: "Победа на республиканской олимпиаде по информатике среди учащихся 9–11 классов",
    category: "IT",
    studentName: "Айдар Сейткали",
    year: 2025,
    place: "1 место",
    level: "Республиканский",
    createdAt: "2025-04-01T00:00:00",
  },
  {
    id: 2,
    title: "Олимпиада по математике",
    description: "Призёр международной олимпиады по математике среди школьников СНГ",
    category: "Математика",
    studentName: "Дина Нурланова",
    year: 2025,
    place: "2 место",
    level: "Международный",
    createdAt: "2025-03-15T00:00:00",
  },
  {
    id: 3,
    title: "Хакатон NIS Digital",
    description: "Победители хакатона по разработке мобильных приложений для умного города",
    category: "IT",
    studentName: "Команда «ByteCode»",
    year: 2025,
    place: "1 место",
    level: "Республиканский",
    createdAt: "2025-02-20T00:00:00",
  },
  {
    id: 4,
    title: "Олимпиада по физике",
    description: "Победа на областной олимпиаде по физике",
    category: "Наука",
    studentName: "Арман Жумабеков",
    year: 2026,
    place: "1 место",
    level: "Областной",
    createdAt: "2026-01-10T00:00:00",
  },
  {
    id: 5,
    title: "Конкурс проектов «Зерде»",
    description: "Проект «Умная теплица» занял 1 место на городском конкурсе научных проектов",
    category: "Наука",
    studentName: "Малика Ахметова",
    year: 2026,
    place: "1 место",
    level: "Городской",
    createdAt: "2026-02-01T00:00:00",
  },
  {
    id: 6,
    title: "Чемпионат по робототехнике",
    description: "Команда лицея стала чемпионом республиканского первенства по робототехнике WRO",
    category: "Робототехника",
    studentName: "Команда «RoboLyceum»",
    year: 2025,
    place: "1 место",
    level: "Республиканский",
    createdAt: "2025-11-15T00:00:00",
  },
]

const PLACE_ICON: Record<string, typeof Trophy> = {
  "1 место": Trophy,
  "2 место": Medal,
  "3 место": Star,
}

export function RecordsSection() {
  const [achievements, setAchievements] = useState<Achievement[]>(FALLBACK)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    api.achievements
      .getAll()
      .then((data) => {
        if (data && data.length > 0) setAchievements(data)
      })
      .catch(() => {})
      .finally(() => setLoading(false))
  }, [])

  const grouped = achievements.reduce<Record<string, Achievement[]>>((acc, a) => {
    acc[a.category] = acc[a.category] || []
    acc[a.category].push(a)
    return acc
  }, {})

  return (
    <section id="records" className="bg-muted/30 py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10">
          <div className="inline-flex items-center gap-2 rounded-full border border-primary/20 bg-primary/5 px-4 py-1.5 text-sm font-medium text-primary mb-4">
            <Trophy className="h-4 w-4" />
            <span>Гордость лицея</span>
          </div>
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Рекорды и победы
          </h2>
          <p className="mt-2 text-muted-foreground">
            Достижения наших учеников на олимпиадах, хакатонах и конкурсах
          </p>
        </div>

        {loading ? (
          <div className="flex items-center justify-center py-16">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : (
          <div className="space-y-10">
            {Object.entries(grouped).map(([category, items]) => (
              <div key={category}>
                <h3 className="mb-4 text-xl font-semibold text-foreground border-l-4 border-primary pl-3">
                  {category}
                </h3>
                <div className="grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-3">
                  {items.map((item) => {
                    const Icon = PLACE_ICON[item.place] || Star
                    const levelClass = LEVEL_COLORS[item.level] || "bg-muted text-muted-foreground"
                    return (
                      <Card
                        key={item.id}
                        className="group transition-all hover:shadow-lg hover:-translate-y-1"
                      >
                        <CardHeader className="pb-2">
                          <div className="flex items-start justify-between gap-2">
                            <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-xl bg-primary/10">
                              <Icon className="h-5 w-5 text-primary" />
                            </div>
                            <span
                              className={`inline-flex items-center rounded-full border px-2 py-0.5 text-xs font-medium ${levelClass}`}
                            >
                              {item.level}
                            </span>
                          </div>
                          <CardTitle className="mt-2 text-base leading-tight">
                            {item.title}
                          </CardTitle>
                        </CardHeader>
                        <CardContent className="space-y-2">
                          <p className="text-sm text-muted-foreground">{item.description}</p>
                          <div className="flex items-center justify-between text-sm">
                            <span className="font-medium text-foreground">{item.studentName}</span>
                            <span className="text-muted-foreground">{item.year}</span>
                          </div>
                          <div className="inline-flex items-center gap-1 rounded-full bg-yellow-500/10 px-2 py-0.5 text-xs font-semibold text-yellow-700">
                            <Trophy className="h-3 w-3" />
                            {item.place}
                          </div>
                        </CardContent>
                      </Card>
                    )
                  })}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </section>
  )
}
