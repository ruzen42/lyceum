"use client"

import { useEffect, useState } from "react"
import { ArrowRight, Newspaper, Trophy, Users } from "lucide-react"
import { Button } from "@/components/ui/button"
import { api, type SiteStats } from "@/lib/api"

export function Hero() {
  const [stats, setStats] = useState<SiteStats | null>(null)

  useEffect(() => {
    api.stats.get().then(setStats).catch(() => {})
  }, [])

  return (
    <section className="relative overflow-hidden bg-gradient-to-b from-primary/5 to-background py-16 sm:py-24 lg:py-32">
      <div className="absolute inset-0 -z-10">
        <div className="absolute left-1/2 top-0 h-[500px] w-[500px] -translate-x-1/2 rounded-full bg-primary/5 blur-3xl" />
      </div>

      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mx-auto max-w-3xl text-center">
          <div className="mb-6 inline-flex items-center gap-2 rounded-full border border-primary/20 bg-primary/5 px-4 py-1.5 text-sm font-medium text-primary">
            <Trophy className="h-4 w-4" />
            <span>35 лет создаём будущее</span>
          </div>

          <h1 className="text-balance text-4xl font-bold tracking-tight text-foreground sm:text-5xl lg:text-6xl">
            Первый городской{" "}
            <span className="bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
              IT-лицей
            </span>
          </h1>

          <p className="mt-6 text-pretty text-lg leading-relaxed text-muted-foreground sm:text-xl">
            Государственное общеобразовательное учреждение города Петропавловска,
            Северо-Казахстанской области. Инновационное образование для лидеров будущего.
          </p>

          <div className="mt-10 flex flex-col items-center justify-center gap-4 sm:flex-row">
            <Button
              size="lg"
              className="w-full sm:w-auto"
              onClick={() => document.getElementById("admission")?.scrollIntoView({ behavior: "smooth" })}
            >
              Записаться на собеседование
              <ArrowRight className="ml-2 h-4 w-4" />
            </Button>
            <Button
              variant="outline"
              size="lg"
              className="w-full sm:w-auto"
              onClick={() => document.getElementById("about")?.scrollIntoView({ behavior: "smooth" })}
            >
              Узнать больше
            </Button>
          </div>
        </div>

        <div className="mt-16 grid grid-cols-1 gap-6 sm:grid-cols-3">
          <div className="rounded-2xl border border-border bg-card p-6 text-center shadow-sm">
            <div className="mx-auto mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-primary/10">
              <Trophy className="h-6 w-6 text-primary" />
            </div>
            <h3 className="text-2xl font-bold text-foreground">35</h3>
            <p className="mt-1 text-sm text-muted-foreground">Лет успешной работы</p>
          </div>

          <div className="rounded-2xl border border-border bg-card p-6 text-center shadow-sm">
            <div className="mx-auto mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-accent/10">
              <Trophy className="h-6 w-6 text-accent" />
            </div>
            <h3 className="text-2xl font-bold text-foreground">
              {stats ? stats.achievementsCount : "—"}
            </h3>
            <p className="mt-1 text-sm text-muted-foreground">Олимпиадных побед</p>
          </div>

          <div className="rounded-2xl border border-border bg-card p-6 text-center shadow-sm">
            <div className="mx-auto mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-primary/10">
              <Newspaper className="h-6 w-6 text-primary" />
            </div>
            <h3 className="text-2xl font-bold text-foreground">
              {stats ? stats.newsCount : "—"}
            </h3>
            <p className="mt-1 text-sm text-muted-foreground">Новостей опубликовано</p>
          </div>
        </div>
      </div>
    </section>
  )
}
