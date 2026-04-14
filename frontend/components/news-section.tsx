"use client"

import { useState, useEffect } from "react"
import { Calendar, ChevronRight, Eye, Loader2 } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { api, type NewsItem } from "@/lib/api"

const FALLBACK_NEWS: NewsItem[] = [
  {
    id: 1,
    createdAt: "2026-01-26T00:00:00",
    title: "Лицейские звездочки-2026",
    content: "17 января в рамках празднования Дня рождения лицея, традиционно прошел Юбилейный Марафон талантов «Лицейские звездочки-2026». В 4-ех номинациях представили младшие лицеисты 1-2 классов и воспитанники Школы будущего первоклассника свои таланты.",
    category: "Мероприятия",
  },
  {
    id: 2,
    createdAt: "2026-01-21T00:00:00",
    title: "Общешкольное родительское собрание",
    content: "21 января в лицее прошло общешкольное родительское собрание. На собрании присутствовал прокурор отдела прокуратуры города Петропавловска Багитжанов М.А., который осветил тему «Профилактика правонарушений среди несовершеннолетних».",
    category: "Собрания",
  },
  {
    id: 3,
    createdAt: "2026-01-20T00:00:00",
    title: "День рождения лицея — 35 лет!",
    content: "Сегодня 19 января в лицее состоялась праздничная линейка, посвящённая главному событию года — 35-летию лицея. Лицеисты исполнили гимн лицея, в котором ещё раз прославили свой лицей — «храм мудрости, чести и знаний».",
    category: "Праздники",
  },
  {
    id: 4,
    createdAt: "2026-01-20T00:00:00",
    title: "Дебаты: Нужно ли наказывать детей с 14 лет?",
    content: "В рамках месячника «Закон и порядок» прошли дебаты на тему ответственности несовершеннолетних. Участники обсудили позиции «За» и «Против».",
    category: "Образование",
  },
  {
    id: 5,
    createdAt: "2026-01-19T00:00:00",
    title: "С днём рождения, родной лицей!",
    content: "19 января состоялась праздничная линейка, посвящённая Дню рождения лицея. Были вручены грамоты и благодарности лицеистам.",
    category: "Праздники",
  },
  {
    id: 6,
    createdAt: "2026-01-19T00:00:00",
    title: "Город мастеров",
    content: "В рамках празднования Дня рождения лицея прошло мероприятие «Город мастеров». Учащиеся путешествовали по интеллектуальным и спортивным станциям.",
    category: "Мероприятия",
  },
]

const ALL_CATEGORIES = ["Все", "Мероприятия", "Праздники", "Собрания", "Образование"]

function formatDate(iso: string) {
  const d = new Date(iso)
  return d.toLocaleDateString("ru-RU", { day: "2-digit", month: "2-digit", year: "numeric" })
}

export function NewsSection() {
  const [activeCategory, setActiveCategory] = useState("Все")
  const [news, setNews] = useState<NewsItem[]>(FALLBACK_NEWS)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    api.news
      .getAll()
      .then((data) => {
        if (data && data.length > 0) setNews(data)
      })
      .catch(() => {
        // fallback data already set
      })
      .finally(() => setLoading(false))
  }, [])

  const filteredNews =
    activeCategory === "Все"
      ? news
      : news.filter((item) => item.category === activeCategory)

  return (
    <section id="news" className="bg-background py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10 flex flex-col items-start justify-between gap-4 sm:flex-row sm:items-center">
          <div>
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              Новости лицея
            </h2>
            <p className="mt-2 text-muted-foreground">Актуальные события и мероприятия</p>
          </div>

          <div className="flex flex-wrap gap-2">
            {ALL_CATEGORIES.map((cat) => (
              <Button
                key={cat}
                variant={activeCategory === cat ? "default" : "outline"}
                size="sm"
                onClick={() => setActiveCategory(cat)}
              >
                {cat}
              </Button>
            ))}
          </div>
        </div>

        {loading ? (
          <div className="flex items-center justify-center py-16">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : (
          <div className="grid grid-cols-1 gap-6 md:grid-cols-2 lg:grid-cols-3">
            {filteredNews.map((item) => (
              <Card
                key={item.id}
                className="group cursor-pointer transition-all hover:shadow-lg hover:-translate-y-1"
              >
                {item.imageUrl && (
                  <div className="overflow-hidden rounded-t-lg">
                    <img
                      src={item.imageUrl}
                      alt={item.title}
                      className="h-40 w-full object-cover transition-transform group-hover:scale-105"
                    />
                  </div>
                )}
                <CardHeader className="pb-3">
                  <div className="flex items-center justify-between text-xs text-muted-foreground">
                    <span className="inline-flex items-center gap-1 rounded-full bg-primary/10 px-2 py-1 font-medium text-primary">
                      {item.category || "Новости"}
                    </span>
                    <span className="inline-flex items-center gap-1">
                      <Calendar className="h-3 w-3" />
                      {formatDate(item.createdAt)}
                    </span>
                  </div>
                  <CardTitle className="mt-3 text-lg leading-tight group-hover:text-primary transition-colors">
                    {item.title}
                  </CardTitle>
                </CardHeader>
                <CardContent>
                  <CardDescription className="line-clamp-3">{item.content}</CardDescription>
                  <div className="mt-4 inline-flex items-center text-sm font-medium text-primary">
                    Читать далее
                    <ChevronRight className="ml-1 h-4 w-4 transition-transform group-hover:translate-x-1" />
                  </div>
                </CardContent>
              </Card>
            ))}
          </div>
        )}

        <div className="mt-10 text-center">
          <Button variant="outline" size="lg">
            Показать все новости
            <ChevronRight className="ml-2 h-4 w-4" />
          </Button>
        </div>
      </div>
    </section>
  )
}
