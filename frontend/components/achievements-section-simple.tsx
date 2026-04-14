"use client"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import { Progress } from "@/components/ui/progress"
import { Trophy, Brain, Heart, Star, Users, Calendar, MapPin } from "lucide-react"

interface AchievementsSectionProps {
  onNavigate?: (section: string) => void
}

export function AchievementsSection({ onNavigate }: AchievementsSectionProps) {
  const achievementCategories = [
    {
      id: "academic",
      title: "Академические достижения",
      description: "Олимпиады, конкурсы, научные проекты",
      icon: Brain,
      stats: { total: 156, thisYear: 23, growth: 15 }
    },
    {
      id: "sports",
      title: "Спортивные победы",
      description: "Соревнования, чемпионаты, рекорды",
      icon: Trophy,
      stats: { total: 89, thisYear: 12, growth: 8 }
    },
    {
      id: "creative",
      title: "Творческие конкурсы",
      description: "Искусство, музыка, литература",
      icon: Star,
      stats: { total: 67, thisYear: 15, growth: 25 }
    },
    {
      id: "social",
      title: "Социальные проекты",
      description: "Волонтерство, общественная деятельность",
      icon: Heart,
      stats: { total: 45, thisYear: 8, growth: 12 }
    }
  ]

  const recentAchievements = [
    {
      id: 1,
      title: "Гран-при Республиканской олимпиады по математике",
      category: "Академические",
      date: "15.03.2024",
      participants: ["Иван Петров", "Мария Сидорова"],
      place: "г. Астана",
      award: "Золотая медаль"
    },
    {
      id: 2,
      title: "Чемпионы города по баскетболу",
      category: "Спортивные",
      date: "10.03.2024",
      participants: ["Команда 'Лицеисты'"],
      place: "г. Алматы",
      award: "Кубок чемпиона"
    }
  ]

  return (
    <div className="w-full max-w-7xl mx-auto px-4 py-8">
      {/* Header */}
      <div className="text-center mb-12">
        <h1 className="text-5xl font-bold mb-4 bg-gradient-to-r from-primary via-primary/80 to-primary/60 bg-clip-text text-transparent">
          Достижения Лицея
        </h1>
        <p className="text-muted-foreground text-lg max-w-3xl mx-auto">
          Наши ученики и педагоги постоянно достигают новых высот в учебе, спорте, 
          творчестве и научной деятельности.
        </p>
      </div>

      {/* Statistics Overview */}
      <div className="grid grid-cols-1 md:grid-cols-4 gap-6 mb-12">
        {achievementCategories.map((category) => {
          const Icon = category.icon
          return (
            <Card key={category.id}>
              <CardContent className="p-6">
                <div className="flex items-center justify-between mb-4">
                  <div className="p-3 rounded-xl bg-primary/10">
                    <Icon className="h-8 w-8 text-primary" />
                  </div>
                  <div className="text-right">
                    <div className="text-2xl font-bold">{category.stats.total}</div>
                    <div className="text-xs text-muted-foreground">Всего достижений</div>
                  </div>
                </div>
                
                <h3 className="font-semibold mb-1">{category.title}</h3>
                <p className="text-muted-foreground text-sm mb-3">{category.description}</p>
                
                <div className="space-y-2">
                  <div className="flex justify-between text-sm">
                    <span>За этот год:</span>
                    <span className="font-medium">{category.stats.thisYear}</span>
                  </div>
                  <div className="flex justify-between text-sm">
                    <span>Рост:</span>
                    <span className="font-medium text-green-600">+{category.stats.growth}%</span>
                  </div>
                  <Progress value={category.stats.growth} className="mt-2" />
                </div>
              </CardContent>
            </Card>
          )
        })}
      </div>

      {/* Recent Achievements */}
      <div className="mb-12">
        <div className="flex items-center justify-between mb-6">
          <h2 className="text-3xl font-bold">Последние достижения</h2>
          <Button variant="outline">Все достижения</Button>
        </div>
        
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          {recentAchievements.map((achievement) => (
            <Card key={achievement.id}>
              <CardHeader>
                <div className="flex items-center justify-between mb-2">
                  <Badge variant="secondary">{achievement.category}</Badge>
                  <Badge variant="outline">{achievement.award}</Badge>
                </div>
                
                <CardTitle className="text-xl mb-2">{achievement.title}</CardTitle>
                
                <div className="space-y-2 text-sm text-muted-foreground mb-3">
                  <div className="flex items-center gap-2">
                    <Calendar className="h-4 w-4" />
                    <span>{achievement.date}</span>
                  </div>
                  <div className="flex items-center gap-2">
                    <MapPin className="h-4 w-4" />
                    <span>{achievement.place}</span>
                  </div>
                </div>
                
                <div className="flex flex-wrap gap-1 mb-3">
                  {achievement.participants.map((participant, index) => (
                    <Badge key={index} variant="outline" className="text-xs">
                      {participant}
                    </Badge>
                  ))}
                </div>
                
                <Button variant="ghost" size="sm" className="w-full">
                  Подробнее
                </Button>
              </CardHeader>
            </Card>
          ))}
        </div>
      </div>
    </div>
  )
}
