"use client"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { BookOpen, Search, Download, Star, FileText, Video } from "lucide-react"
import { useState } from "react"

interface LibrarySectionProps {
  onNavigate?: (section: string) => void
}

export function LibrarySection({ onNavigate }: LibrarySectionProps) {
  const [searchQuery, setSearchQuery] = useState("")

  const categories = [
    { id: "textbooks", name: "Учебники", count: 234, icon: BookOpen },
    { id: "methodology", name: "Методические материалы", count: 156, icon: FileText },
    { id: "magazines", name: "Журналы", count: 89, icon: FileText },
    { id: "video", name: "Видео материалы", count: 67, icon: Video },
  ]

  const libraryItems = [
    {
      id: 1,
      title: "Сборник задач по математике",
      author: "Коллектив авторов",
      category: "Учебники",
      description: "Полный сборник задач по математике с решениями",
      size: "15.4 MB",
      rating: 4.8,
      downloads: 1234,
      date: "01.03.2024",
    },
    {
      id: 2,
      title: "Лицейские новости 2024",
      author: "Редакция лицея",
      category: "Журналы",
      description: "Ежемесячный журнал о жизни лицея",
      size: "8.2 MB",
      rating: 4.6,
      downloads: 567,
      date: "15.03.2024",
    },
    {
      id: 3,
      title: "Видеоуроки по физике",
      author: "Преподаватели физики",
      category: "Видео материалы",
      description: "Полный курс видеоуроков по физике",
      size: "2.3 GB",
      rating: 4.9,
      downloads: 890,
      date: "10.03.2024",
    }
  ]

  const filteredItems = libraryItems.filter(item => 
    item.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
    item.author.toLowerCase().includes(searchQuery.toLowerCase())
  )

  return (
    <div className="w-full max-w-7xl mx-auto px-4 py-8">
      {/* Header */}
      <div className="text-center mb-12">
        <h1 className="text-5xl font-bold mb-4 bg-gradient-to-r from-primary via-primary/80 to-primary/60 bg-clip-text text-transparent">
          Библиотека Лицея
        </h1>
        <p className="text-muted-foreground text-lg max-w-3xl mx-auto">
          Цифровая библиотека с учебными материалами и ресурсами для учащихся и преподавателей.
        </p>
      </div>

      {/* Categories */}
      <div className="mb-8">
        <h2 className="text-2xl font-bold mb-4">Категории ресурсов</h2>
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          {categories.map((category) => {
            const Icon = category.icon
            return (
              <Card key={category.id} className="text-center">
                <CardContent className="p-4">
                  <div className="flex justify-center mb-2">
                    <div className="p-2 rounded-lg bg-primary/10">
                      <Icon className="h-6 w-6 text-primary" />
                    </div>
                  </div>
                  <CardTitle className="text-sm mb-1">{category.name}</CardTitle>
                  <Badge variant="secondary">{category.count}</Badge>
                </CardContent>
              </Card>
            )
          })}
        </div>
      </div>

      {/* Search */}
      <div className="mb-8">
        <div className="relative max-w-md">
          <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 h-4 w-4 text-muted-foreground" />
          <Input
            placeholder="Поиск в библиотеке..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            className="pl-10"
          />
        </div>
      </div>

      {/* Library Items */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {filteredItems.map((item) => (
          <Card key={item.id}>
            <CardHeader>
              <div className="flex items-center justify-between mb-2">
                <Badge variant="secondary">{item.category}</Badge>
                <div className="flex items-center gap-1">
                  <Star className="h-3 w-3 text-yellow-500 fill-yellow-500" />
                  <span className="text-sm font-medium">{item.rating}</span>
                </div>
              </div>
              
              <CardTitle className="text-lg mb-1">{item.title}</CardTitle>
              <p className="text-muted-foreground text-sm mb-2">{item.author}</p>
              <p className="text-muted-foreground text-sm mb-3">{item.description}</p>
              
              <div className="flex items-center justify-between text-xs text-muted-foreground mb-3">
                <span>{item.size}</span>
                <span>{item.date}</span>
              </div>
              
              <Button className="w-full">
                <Download className="h-4 w-4 mr-2" />
                Скачать
              </Button>
            </CardHeader>
          </Card>
        ))}
      </div>

      {/* Empty State */}
      {filteredItems.length === 0 && (
        <Card className="py-20">
          <CardContent className="flex flex-col items-center gap-4">
            <BookOpen className="h-16 w-16 text-muted-foreground" />
            <h3 className="text-xl font-semibold">Материалы не найдены</h3>
            <p className="text-muted-foreground text-center max-w-md">
              Попробуйте изменить параметры поиска
            </p>
          </CardContent>
        </Card>
      )}
    </div>
  )
}
