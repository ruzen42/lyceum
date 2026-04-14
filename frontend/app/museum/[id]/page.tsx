"use client"

import { useState, useEffect, use } from "react"
import Link from "next/link"
import { ArrowLeft, RefreshCw, ExternalLink } from "lucide-react"
import { toast } from "sonner"
import { useAuth } from "@/lib/auth-context"
import { apiClient, fetchHtml } from "@/lib/api"
import { AppShell } from "@/components/app-shell"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Spinner } from "@/components/ui/spinner"

interface RelatedExhibit {
  id: number
  title: string
  imageUrls?: string[]
}

interface Exhibit {
  id: number
  title: string
  description: string
  imageUrls?: string[]
  relatedExhibits?: RelatedExhibit[]
}

export default function ExhibitDetailPage({
  params,
}: {
  params: Promise<{ id: string }>
}) {
  const { id } = use(params)
  const { hasRole } = useAuth()
  const [exhibit, setExhibit] = useState<Exhibit | null>(null)
  const [htmlContent, setHtmlContent] = useState<string>("")
  const [isLoading, setIsLoading] = useState(true)
  const [isRegenerating, setIsRegenerating] = useState(false)
  const [isHtmlDialogOpen, setIsHtmlDialogOpen] = useState(false)

  const canRegenerate = hasRole("TEACHER")

  const fetchExhibit = async () => {
    try {
      const { data } = await apiClient.get<Exhibit>(`/api/museum-exhibit/${id}`)
      setExhibit(data)
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to fetch exhibit")
    } finally {
      setIsLoading(false)
    }
  }

  const loadHtml = async () => {
    try {
      const html = await fetchHtml("museum-exhibit", Number(id))
      setHtmlContent(html)
    } catch {
      // HTML not ready yet
    }
  }

  useEffect(() => {
    fetchExhibit()
    loadHtml()
  }, [id])

  const handleRegenerate = async () => {
    setIsRegenerating(true)
    try {
      await apiClient.post(`/api/museum-exhibit/${id}/regenerate-html`)
      toast.success("HTML regenerated successfully!")
      await loadHtml()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to regenerate HTML")
    } finally {
      setIsRegenerating(false)
    }
  }

  if (isLoading) {
    return (
      <AppShell>
        <div className="flex justify-center py-12">
          <Spinner className="size-8 text-primary" />
        </div>
      </AppShell>
    )
  }

  if (!exhibit) {
    return (
      <AppShell>
        <div className="text-center py-12">
          <p className="text-muted-foreground">Exhibit not found.</p>
          <Link href="/museum">
            <Button variant="outline" className="mt-4">
              <ArrowLeft className="size-4" />
              Back to Museum
            </Button>
          </Link>
        </div>
      </AppShell>
    )
  }

  return (
    <AppShell>
      <div className="space-y-6">
        <div className="flex items-center gap-4">
          <Link href="/museum">
            <Button variant="outline" size="icon">
              <ArrowLeft className="size-4" />
            </Button>
          </Link>
          <div className="flex-1">
            <h1 className="text-3xl font-bold text-foreground">{exhibit.title}</h1>
          </div>
          <div className="flex gap-2">
            {htmlContent && (
              <Dialog open={isHtmlDialogOpen} onOpenChange={setIsHtmlDialogOpen}>
                <DialogTrigger asChild>
                  <Button variant="outline">
                    <ExternalLink className="size-4" />
                    View HTML
                  </Button>
                </DialogTrigger>
                <DialogContent className="max-w-4xl max-h-[90vh]">
                  <DialogHeader>
                    <DialogTitle>{exhibit.title} - HTML View</DialogTitle>
                  </DialogHeader>
                  <div className="h-[70vh] w-full">
                    <iframe
                      srcDoc={htmlContent}
                      className="w-full h-full border rounded-lg"
                      title={`${exhibit.title} HTML`}
                      sandbox="allow-same-origin"
                    />
                  </div>
                </DialogContent>
              </Dialog>
            )}
            {canRegenerate && (
              <Button onClick={handleRegenerate} disabled={isRegenerating}>
                {isRegenerating ? (
                  <Spinner className="size-4" />
                ) : (
                  <RefreshCw className="size-4" />
                )}
                Regenerate HTML
              </Button>
            )}
          </div>
        </div>

        <Card className="border-primary/20 shadow-md">
          <CardContent className="py-6">
            <p className="text-foreground whitespace-pre-wrap">{exhibit.description}</p>
          </CardContent>
        </Card>

        {exhibit.imageUrls && exhibit.imageUrls.length > 0 && (
          <div className="space-y-4">
            <h2 className="text-xl font-semibold text-foreground">Images</h2>
            <div className="grid gap-4 sm:grid-cols-2 lg:grid-cols-3">
              {exhibit.imageUrls.map((image, index) => (
                <div key={index} className="aspect-square rounded-lg overflow-hidden border border-primary/20 shadow-md">
                  <img
                    src={image}
                    alt={`${exhibit.title} - Image ${index + 1}`}
                    className="w-full h-full object-cover"
                  />
                </div>
              ))}
            </div>
          </div>
        )}

        {exhibit.relatedExhibits && exhibit.relatedExhibits.length > 0 && (
          <div className="space-y-4">
            <h2 className="text-xl font-semibold text-foreground">Related Exhibits</h2>
            <div className="grid gap-4 sm:grid-cols-2 lg:grid-cols-4">
              {exhibit.relatedExhibits.map((related) => (
                <Link key={related.id} href={`/museum/${related.id}`}>
                  <Card className="border-primary/20 shadow-md hover:shadow-lg transition-shadow cursor-pointer">
                    {related.imageUrls && related.imageUrls[0] && (
                      <div className="aspect-video overflow-hidden">
                        <img
                          src={related.imageUrls[0]}
                          alt={related.title}
                          className="w-full h-full object-cover"
                        />
                      </div>
                    )}
                    <CardHeader>
                      <CardTitle className="text-sm line-clamp-1">{related.title}</CardTitle>
                    </CardHeader>
                  </Card>
                </Link>
              ))}
            </div>
          </div>
        )}
      </div>
    </AppShell>
  )
}
