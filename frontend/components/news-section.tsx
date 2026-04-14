"use client"

import { useState } from "react"
import { Calendar, ChevronRight, Eye } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"

const newsItems = [
  {
    id: 1,
    date: "26.01.2026",
    views: 59,
    title: "Лицейские звездочки-2026",
    excerpt: "17 января в рамках празднования Дня рождения лицея, традиционно прошел Юбилейный Марафон талантов «Лицейские звездочки-2026». В 4-ех номинациях представили младшие лицеисты 1-2 классов и воспитанники Школы будущего первоклассника свои таланты.",
    category: "Мероприятия",
  },
  {
    id: 2,
    date: "21.01.2026",
    views: 33,
    title: "Общешкольное родительское собрание",
    excerpt: "21 января в лицее прошло общешкольное родительское собрание. На собрании присутствовал прокурор отдела прокуратуры города Петропавловска Багитжанов М.А., который осветил тему «Профилактика правонарушений среди несовершеннолетних».",
    category: "Собрания",
  },
  {
    id: 3,
    date: "20.01.2026",
    views: 82,
    title: "День рождения лицея — 35 лет!",
    excerpt: "Сегодня 19 января в лицее состоялась праздничная линейка, посвящённая главному событию года — 35-летию лицея. Лицеисты исполнили гимн лицея, в котором ещё раз прославили свой лицей — «храм мудрости, чести и знаний».",
    category: "Праздники",
  },
  {
    id: 4,
    date: "20.01.2026",
    views: 10,
    title: "Дебаты: Нужно ли наказывать детей с 14 лет?",
    excerpt: "В рамках месячника «Закон и порядок» прошли дебаты на тему ответственности несовершеннолетних. Участники обсудили позиции «За» и «Против», пришли к выводу о важности соразмерного воспитательного подхода.",
    category: "Образование",
  },
  {
    id: 5,
    date: "19.01.2026",
    views: 54,
    title: "С днём рождения, родной лицей!",
    excerpt: "19 января состоялась праздничная линейка, посвящённая Дню рождения лицея. Были вручены грамоты и благодарности лицеистам, показавшим высокие результаты в учёбе, олимпиадах и конкурсах.",
    category: "Праздники",
  },
  {
    id: 6,
    date: "19.01.2026",
    views: 25,
    title: "Город мастеров",
    excerpt: "В рамках празднования Дня рождения лицея прошло мероприятие «Город мастеров». Учащиеся путешествовали по интеллектуальным и спортивным станциям, выполняя задания на логику, смекалку и командное взаимодействие.",
    category: "Мероприятия",
  },
]

const categories = ["Все", "Мероприятия", "Праздники", "Собрания", "Образование"]

export function NewsSection() {
  const [activeCategory, setActiveCategory] = useState("Все")
  
  const filteredNews = activeCategory === "Все" 
    ? newsItems 
    : newsItems.filter(item => item.category === activeCategory)

  return (
    <section id="news" className="bg-background py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10 flex flex-col items-start justify-between gap-4 sm:flex-row sm:items-center">
          <div>
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              Новости лицея
            </h2>
            <p className="mt-2 text-muted-foreground">
              Актуальные события и мероприятия
            </p>
          </div>
          
          <div className="flex flex-wrap gap-2">
            {categories.map((category) => (
              <Button
                key={category}
                variant={activeCategory === category ? "default" : "outline"}
                size="sm"
                onClick={() => setActiveCategory(category)}
              >
                {category}
              </Button>
            ))}
          </div>
        </div>
        
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2 lg:grid-cols-3">
          {filteredNews.map((item) => (
            <Card key={item.id} className="group cursor-pointer transition-all hover:shadow-lg hover:-translate-y-1">
              <CardHeader className="pb-3">
                <div className="flex items-center justify-between text-xs text-muted-foreground">
                  <span className="inline-flex items-center gap-1 rounded-full bg-primary/10 px-2 py-1 font-medium text-primary">
                    {item.category}
                  </span>
                  <div className="flex items-center gap-3">
                    <span className="inline-flex items-center gap-1">
                      <Calendar className="h-3 w-3" />
                      {item.date}
                    </span>
                    <span className="inline-flex items-center gap-1">
                      <Eye className="h-3 w-3" />
                      {item.views}
                    </span>
                  </div>
                </div>
                <CardTitle className="mt-3 text-lg leading-tight group-hover:text-primary transition-colors">
                  {item.title}
                </CardTitle>
              </CardHeader>
              <CardContent>
                <CardDescription className="line-clamp-3">
                  {item.excerpt}
                </CardDescription>
                <div className="mt-4 inline-flex items-center text-sm font-medium text-primary">
                  Читать далее
                  <ChevronRight className="ml-1 h-4 w-4 transition-transform group-hover:translate-x-1" />
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
        
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
