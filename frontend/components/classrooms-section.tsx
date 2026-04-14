"use client"

import { BookOpen, FileText, User, Loader2, Paperclip } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { api, type Classroom } from "@/lib/api"
import { useApiData } from "@/hooks/use-api-data"

const FALLBACK: Classroom[] = []

function formatDate(iso: string) {
  return new Date(iso).toLocaleDateString("ru-RU", { day: "2-digit", month: "2-digit", year: "numeric" })
}

export function ClassroomsSection() {
  const { data: classrooms, loading } = useApiData(api.classroom.getAll, FALLBACK)

  if (!loading && classrooms.length === 0) return null

  return (
    <section id="classrooms" className="bg-background py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10">
          <div className="inline-flex items-center gap-2 rounded-full border border-primary/20 bg-primary/5 px-4 py-1.5 text-sm font-medium text-primary mb-4">
            <BookOpen className="h-4 w-4" />
            <span>Учебные материалы</span>
          </div>
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Классы и материалы
          </h2>
          <p className="mt-2 text-muted-foreground">Учебные классы и ресурсы лицея</p>
        </div>

        {loading ? (
          <div className="flex items-center justify-center py-16">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : (
          <div className="grid grid-cols-1 gap-6 lg:grid-cols-2">
            {classrooms.map((classroom) => (
              <Card key={classroom.id} className="group transition-all hover:shadow-lg">
                <CardHeader className="pb-3">
                  <div className="flex items-center gap-3">
                    <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-primary/10">
                      <BookOpen className="h-5 w-5 text-primary" />
                    </div>
                    <div>
                      <CardTitle className="text-lg group-hover:text-primary transition-colors">
                        {classroom.title}
                      </CardTitle>
                      <p className="text-xs text-muted-foreground">
                        {classroom.materials.length} материал{
                          classroom.materials.length === 1 ? "" :
                          classroom.materials.length < 5 ? "а" : "ов"
                        }
                      </p>
                    </div>
                  </div>
                </CardHeader>

                {classroom.materials.length > 0 && (
                  <CardContent className="space-y-3">
                    {classroom.materials.slice(0, 3).map((mat) => (
                      <div key={mat.id} className="rounded-lg border bg-muted/30 p-3">
                        <div className="flex items-start justify-between gap-2">
                          <div className="flex items-center gap-2 min-w-0">
                            <FileText className="h-4 w-4 shrink-0 text-muted-foreground" />
                            <span className="text-sm font-medium truncate">{mat.title}</span>
                          </div>
                          {mat.fileUrls && mat.fileUrls.length > 0 && (
                            <Badge variant="secondary" className="shrink-0 text-xs">
                              <Paperclip className="h-3 w-3 mr-1" />
                              {mat.fileUrls.length}
                            </Badge>
                          )}
                        </div>
                        {mat.description && (
                          <p className="mt-1 text-xs text-muted-foreground line-clamp-2">{mat.description}</p>
                        )}
                        <div className="mt-2 flex items-center gap-3 text-xs text-muted-foreground">
                          {mat.author && (
                            <span className="flex items-center gap-1">
                              <User className="h-3 w-3" />
                              {mat.author.username}
                            </span>
                          )}
                          <span>{formatDate(mat.createdAt)}</span>
                        </div>
                      </div>
                    ))}

                    {classroom.materials.length > 3 && (
                      <p className="text-xs text-muted-foreground text-center pt-1">
                        и ещё {classroom.materials.length - 3} материал{
                          (classroom.materials.length - 3) === 1 ? "" :
                          (classroom.materials.length - 3) < 5 ? "а" : "ов"
                        }
                      </p>
                    )}
                  </CardContent>
                )}
              </Card>
            ))}
          </div>
        )}
      </div>
    </section>
  )
}
