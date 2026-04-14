"use client"

import { Landmark, ImageOff, Loader2 } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { api, type MuseumExhibit } from "@/lib/api"
import { useApiData } from "@/hooks/use-api-data"

const FALLBACK: MuseumExhibit[] = []

export function MuseumSection() {
  const { data: exhibits, loading } = useApiData(api.museum.getAll, FALLBACK)

  if (!loading && exhibits.length === 0) return null

  return (
    <section id="museum" className="bg-muted/30 py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="mb-10">
          <div className="inline-flex items-center gap-2 rounded-full border border-primary/20 bg-primary/5 px-4 py-1.5 text-sm font-medium text-primary mb-4">
            <Landmark className="h-4 w-4" />
            <span>Школьный музей</span>
          </div>
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Музейные экспонаты
          </h2>
          <p className="mt-2 text-muted-foreground">История и достижения нашего лицея</p>
        </div>

        {loading ? (
          <div className="flex items-center justify-center py-16">
            <Loader2 className="h-8 w-8 animate-spin text-primary" />
          </div>
        ) : (
          <div className="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3">
            {exhibits.map((exhibit) => (
              <Card
                key={exhibit.id}
                className="group overflow-hidden transition-all hover:shadow-lg hover:-translate-y-1"
              >
                <div className="relative h-48 overflow-hidden bg-muted">
                  {exhibit.imageUrls && exhibit.imageUrls.length > 0 ? (
                    <img
                      src={exhibit.imageUrls[0]}
                      alt={exhibit.title}
                      className="h-full w-full object-cover transition-transform group-hover:scale-105"
                    />
                  ) : (
                    <div className="flex h-full w-full items-center justify-center">
                      <ImageOff className="h-10 w-10 text-muted-foreground/40" />
                    </div>
                  )}
                  {exhibit.imageUrls && exhibit.imageUrls.length > 1 && (
                    <span className="absolute bottom-2 right-2 rounded-full bg-black/60 px-2 py-0.5 text-xs text-white">
                      +{exhibit.imageUrls.length - 1} фото
                    </span>
                  )}
                </div>

                <CardHeader className="pb-2">
                  <CardTitle className="text-base leading-tight group-hover:text-primary transition-colors">
                    {exhibit.title}
                  </CardTitle>
                </CardHeader>

                <CardContent>
                  <p className="text-sm text-muted-foreground line-clamp-3">{exhibit.description}</p>

                  {exhibit.relatedExhibits && exhibit.relatedExhibits.length > 0 && (
                    <div className="mt-3 flex flex-wrap gap-1">
                      {exhibit.relatedExhibits.slice(0, 2).map((r) => (
                        <span
                          key={r.id}
                          className="inline-flex items-center rounded-full bg-primary/10 px-2 py-0.5 text-xs text-primary"
                        >
                          {r.title}
                        </span>
                      ))}
                    </div>
                  )}
                </CardContent>
              </Card>
            ))}
          </div>
        )}
      </div>
    </section>
  )
}
