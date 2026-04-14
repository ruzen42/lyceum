"use client"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import { History, Users, Trophy, Video, Star, Heart, MessageCircle } from "lucide-react"

interface MuseumSectionProps {
  onNavigate?: (section: string) => void
}

export function MuseumSection({ onNavigate }: MuseumSectionProps) {
  const museumCategories = [
    {
      id: "memories",
      title: "Воспоминания лицеистов",
      description: "Истории и воспоминания выпускников",
      icon: Heart,
      count: 156
    },
    {
      id: "history",
      title: "Немного истории",
      description: "История создания и развития лицея",
      icon: History,
      count: 89
    },
    {
      id: "graduates",
      title: "Выпускные классы",
      description: "Фотографии и информация о выпусках",
      icon: Users,
      count: 234
    },
    {
      id: "life",
      title: "Лицейская жизнь",
      description: "Повседневная жизнь и события лицея",
      icon: Star,
      count: 312
    },
    {
      id: "tv",
      title: "Лицейское TV",
      description: "Видео материалы и трансляции",
      icon: Video,
      count: 67
    },
    {
      id: "records",
      title: "Книга рекордов и побед",
      description: "Достижения и рекорды лицея",
      icon: Trophy,
      count: 145
    }
  ]

  const featuredStories = [
    {
      id: 1,
      title: "Первый выпуск лицея",
      excerpt: "История о первом выпуске лицея 1998 года",
      author: "Мария Иванова",
      date: "15.03.2024",
      category: "Выпускные классы",
      likes: 45,
      comments: 12
    },
    {
      id: 2,
      title: "Победа на Республиканской олимпиаде",
      excerpt: "Как наши ученики завоевали первые места",
      author: "Александр Петров",
      date: "10.03.2024",
      category: "Наша гордость",
      likes: 67,
      comments: 23
    }
  ]

  return (
    <div className="w-full max-w-7xl mx-auto px-4 py-8">
      {/* Header */}
      <div className="text-center mb-12">
        <h1 className="text-5xl font-bold mb-4 bg-gradient-to-r from-primary via-primary/80 to-primary/60 bg-clip-text text-transparent">
          Музей Лицея
        </h1>
        <p className="text-muted-foreground text-lg max-w-3xl mx-auto">
          Хранилище истории, традиций и достижений нашего лицея.
        </p>
      </div>

      {/* Categories Grid */}
      <div className="mb-12">
        <h2 className="text-3xl font-bold mb-6">Разделы музея</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {museumCategories.map((category) => {
            const Icon = category.icon
            return (
              <Card 
                key={category.id}
                className="cursor-pointer hover:shadow-lg transition-shadow"
                onClick={() => onNavigate?.(category.id)}
              >
                <CardHeader>
                  <div className="flex items-center justify-between w-full">
                    <div className="flex items-center gap-3">
                      <div className="p-2 rounded-lg bg-primary/10">
                        <Icon className="h-6 w-6 text-primary" />
                      </div>
                      <div>
                        <CardTitle className="text-lg">{category.title}</CardTitle>
                        <p className="text-muted-foreground text-sm">{category.description}</p>
                      </div>
                    </div>
                    <Badge variant="secondary">
                      {category.count}
                    </Badge>
                  </div>
                </CardHeader>
              </Card>
            )
          })}
        </div>
      </div>

      {/* Featured Stories */}
      <div className="mb-12">
        <h2 className="text-3xl font-bold mb-6">Избранные истории</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          {featuredStories.map((story) => (
            <Card key={story.id}>
              <CardHeader>
                <div className="flex items-center justify-between mb-2">
                  <Badge variant="outline">
                    {story.category}
                  </Badge>
                  <div className="flex gap-2 text-muted-foreground text-sm">
                    <span className="flex items-center gap-1">
                      <Heart className="h-3 w-3" />
                      {story.likes}
                    </span>
                    <span className="flex items-center gap-1">
                      <MessageCircle className="h-3 w-3" />
                      {story.comments}
                    </span>
                  </div>
                </div>
                
                <CardTitle className="text-xl mb-2">{story.title}</CardTitle>
                <p className="text-muted-foreground text-sm mb-3">
                  {story.excerpt}
                </p>
                
                <div className="flex items-center justify-between">
                  <span className="text-muted-foreground text-sm">{story.author}</span>
                  <span className="text-muted-foreground text-xs">{story.date}</span>
                </div>
              </CardHeader>
            </Card>
          ))}
        </div>
      </div>

      {/* Call to Action */}
      <div className="text-center">
        <Card className="bg-gradient-to-r from-primary/10 to-primary/5 border-1 border-primary/20">
          <CardContent className="py-8">
            <h3 className="text-2xl font-bold mb-4">Хотите поделиться историей?</h3>
            <p className="text-muted-foreground mb-6 max-w-2xl mx-auto">
              Если у вас есть воспоминания, фотографии или документы о жизни лицея, 
              поделитесь ими с нами.
            </p>
            <Button className="font-medium">
              Добавить историю в музей
            </Button>
          </CardContent>
        </Card>
      </div>
    </div>
  )
}
