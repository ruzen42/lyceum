"use client"

import { User, GraduationCap, Code2, Loader2, ChevronRight } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import { api, type StudentPortfolio } from "@/lib/api"
import { useApiData } from "@/hooks/use-api-data"

const FALLBACK: StudentPortfolio[] = [
  {
    id: 1,
    studentName: "Айдар Сейткали",
    grade: "11А",
    bio: "Победитель республиканской олимпиады по информатике. Разрабатываю мобильные приложения и участвую в хакатонах.",
    skills: ["Python", "Kotlin", "SQL", "Алгоритмы"],
    achievements: ["1 место — Олимпиада по информатике (Респ.)", "Призёр NIS Digital Hackathon"],
    createdAt: "2025-09-01T00:00:00",
  },
  {
    id: 2,
    studentName: "Дина Нурланова",
    grade: "10Б",
    bio: "Увлекаюсь математикой и программированием. Призёр международных олимпиад, изучаю машинное обучение.",
    skills: ["C++", "Python", "Machine Learning", "Математика"],
    achievements: ["2 место — Международная олимпиада по математике", "1 место — Олимпиада по физике (Обл.)"],
    createdAt: "2025-09-01T00:00:00",
  },
  {
    id: 3,
    studentName: "Команда «ByteCode»",
    grade: "10–11 кл.",
    bio: "Команда разработчиков, победившая на хакатоне NIS Digital с проектом умного города. Специализируемся на Full-Stack разработке.",
    skills: ["React", "Spring Boot", "PostgreSQL", "Docker"],
    achievements: ["1 место — Хакатон NIS Digital", "Финалисты чемпионата по робототехнике WRO"],
    createdAt: "2025-10-15T00:00:00",
  },
  {
    id: 4,
    studentName: "Малика Ахметова",
    grade: "9В",
    bio: "Юный исследователь и изобретатель. Мой проект «Умная теплица» занял 1 место на городском конкурсе «Зерде».",
    skills: ["Arduino", "IoT", "3D-печать", "Биология"],
    achievements: ["1 место — Конкурс «Зерде» (Умная теплица)", "Призёр олимпиады по биологии"],
    createdAt: "2026-01-15T00:00:00",
  },
]

const AVATAR_COLORS = [
  "bg-blue-500/10 text-blue-600",
  "bg-purple-500/10 text-purple-600",
  "bg-emerald-500/10 text-emerald-600",
  "bg-orange-500/10 text-orange-600",
]

function avatarColor(name: string): string {
  const hash = name.split("").reduce((h, c) => h + c.charCodeAt(0), 0)
  return AVATAR_COLORS[hash % AVATAR_COLORS.length]
}

function formatGrade(grade: string): string {
  return grade.endsWith("кл.") ? grade : `${grade} класс`
}

export function PortfolioSection() {
  const { data: portfolios, loading } = useApiData(api.portfolio.getAll, FALLBACK)

  return (
    <section id="portfolio" className="bg-background py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10">
          <div className="inline-flex items-center gap-2 rounded-full border border-primary/20 bg-primary/5 px-4 py-1.5 text-sm font-medium text-primary mb-4">
            <GraduationCap className="h-4 w-4" />
            <span>Наши ученики</span>
          </div>
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Портфолио учеников
          </h2>
          <p className="mt-2 text-muted-foreground">
            Достижения, навыки и проекты лицеистов
          </p>
        </div>

        {loading ? (
          <div className="flex items-center justify-center py-16">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : (
          <div className="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-4">
            {portfolios.map((p) => (
              <Card
                key={p.id}
                className="group flex flex-col transition-all hover:shadow-lg hover:-translate-y-1"
              >
                <CardHeader className="pb-3">
                  <div className="flex items-center gap-3 mb-2">
                    {p.imageUrl ? (
                      <img
                        src={p.imageUrl}
                        alt={p.studentName}
                        className="h-12 w-12 rounded-full object-cover"
                      />
                    ) : (
                      <div
                        className={`flex h-12 w-12 shrink-0 items-center justify-center rounded-full ${avatarColor(p.studentName)}`}
                      >
                        <User className="h-6 w-6" />
                      </div>
                    )}
                    <div>
                      <CardTitle className="text-base leading-tight">{p.studentName}</CardTitle>
                      <p className="text-xs text-muted-foreground">{formatGrade(p.grade)}</p>
                    </div>
                  </div>
                  <p className="text-sm text-muted-foreground line-clamp-3">{p.bio}</p>
                </CardHeader>

                <CardContent className="flex flex-col gap-3 flex-1">
                  <div>
                    <p className="mb-1.5 flex items-center gap-1.5 text-xs font-semibold uppercase tracking-wide text-muted-foreground">
                      <Code2 className="h-3.5 w-3.5" />
                      Навыки
                    </p>
                    <div className="flex flex-wrap gap-1">
                      {p.skills.map((skill) => (
                        <Badge key={skill} variant="secondary" className="text-xs">
                          {skill}
                        </Badge>
                      ))}
                    </div>
                  </div>

                  <div className="mt-auto">
                    <p className="mb-1.5 text-xs font-semibold uppercase tracking-wide text-muted-foreground">
                      Достижения
                    </p>
                    <ul className="space-y-1">
                      {p.achievements.slice(0, 2).map((a) => (
                        <li key={a} className="text-xs text-muted-foreground flex gap-1.5">
                          <span className="mt-0.5 h-1.5 w-1.5 shrink-0 rounded-full bg-primary/60" />
                          {a}
                        </li>
                      ))}
                    </ul>
                  </div>
                </CardContent>
              </Card>
            ))}
          </div>
        )}

        <div className="mt-10 text-center">
          <Button variant="outline" size="lg">
            Все портфолио
            <ChevronRight className="ml-2 h-4 w-4" />
          </Button>
        </div>
      </div>
    </section>
  )
}
