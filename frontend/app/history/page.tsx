"use client"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Calendar, Users, Award, BookOpen } from "lucide-react"

export default function HistoryPage() {
  const timelineEvents = [
    {
      year: "1998",
      title: "Основание лицея",
      description: "Первый лицей открыт для талантливых детей Казахстана",
      type: "milestone"
    },
    {
      year: "2003",
      title: "Первый выпуск",
      description: "Выпуск первых лицеистов, которые поступили в лучшие вузы страны",
      type: "achievement"
    },
    {
      year: "2018",
      title: "20-летний юбилей",
      description: "Торжественное празднование 20-летия лицея",
      type: "milestone"
    },
    {
      year: "2023",
      title: "25-летний юбилей",
      description: "Четверть века образовательных достижений",
      type: "milestone"
    }
  ]

  const milestones = [
    {
      icon: Users,
      title: "Более 1000 выпускников",
      description: "Наши выпускники учатся в ведущих вузах мира"
    },
    {
      icon: Award,
      title: "Сотни наград",
      description: "Победы в республиканских и международных олимпиадах"
    },
    {
      icon: BookOpen,
      title: "Инновационные программы",
      description: "Современные методики обучения и исследования"
    }
  ]

  return (
    <div className="min-h-screen bg-background">
      <div className="w-full max-w-7xl mx-auto px-4 py-8">
        {/* Header */}
        <div className="text-center mb-12">
          <h1 className="text-5xl font-bold mb-4 bg-gradient-to-r from-primary via-primary/80 to-primary/60 bg-clip-text text-transparent">
            История Лицея
          </h1>
          <p className="text-default-600 text-lg max-w-3xl mx-auto">
            25 лет образовательного превосходства, инноваций и достижений. 
            История нашего лицея - это история успеха тысяч учеников.
          </p>
        </div>

        {/* Timeline */}
        <div className="mb-12">
          <h2 className="text-3xl font-bold mb-6">Ключевые события</h2>
          <div className="relative">
            <div className="absolute left-8 top-0 bottom-0 w-0.5 bg-primary/20"></div>
            <div className="space-y-8">
              {timelineEvents.map((event, index) => (
                <div key={index} className="relative flex items-center gap-6">
                  <div className={`w-16 h-16 rounded-full flex items-center justify-center z-10 ${
                    event.type === 'milestone' ? 'bg-primary text-primary-foreground' : 'bg-success text-success-foreground'
                  }`}>
                    <Calendar className="h-6 w-6" />
                  </div>
                  <Card className="flex-1">
                    <CardHeader>
                      <div className="flex items-center justify-between">
                        <CardTitle className="text-2xl">{event.title}</CardTitle>
                        <Badge variant={event.type === 'milestone' ? 'default' : 'secondary'}>
                          {event.year}
                        </Badge>
                      </div>
                    </CardHeader>
                    <CardContent>
                      <p className="text-default-600">{event.description}</p>
                    </CardContent>
                  </Card>
                </div>
              ))}
            </div>
          </div>
        </div>

        {/* Milestones */}
        <div className="mb-12">
          <h2 className="text-3xl font-bold mb-6">Наши достижения</h2>
          <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
            {milestones.map((milestone, index) => {
              const Icon = milestone.icon
              return (
                <Card key={index}>
                  <CardHeader>
                    <div className="flex items-center gap-3">
                      <div className="p-2 rounded-lg bg-primary/10">
                        <Icon className="h-6 w-6 text-primary" />
                      </div>
                      <CardTitle className="text-lg">{milestone.title}</CardTitle>
                    </div>
                  </CardHeader>
                  <CardContent>
                    <p className="text-default-600">{milestone.description}</p>
                  </CardContent>
                </Card>
              )
            })}
          </div>
        </div>

        {/* Call to Action */}
        <div className="text-center">
          <Card className="bg-gradient-to-r from-primary/10 to-primary/5 border-1 border-primary/20">
            <CardContent className="py-8">
              <h3 className="text-2xl font-bold mb-4">Станьте частью истории</h3>
              <p className="text-default-600 mb-6 max-w-2xl mx-auto">
                Каждый ученик, учитель и родитель вносит свой вклад в историю лицея. 
                Вместе мы создаем будущее образования в Казахстане.
              </p>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  )
}
