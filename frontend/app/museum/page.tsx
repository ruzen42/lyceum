"use client"

import { useState, useEffect } from "react"
import Link from "next/link"
import { Plus } from "lucide-react"
import { toast } from "sonner"
import { useAuth } from "@/lib/auth-context"
import { apiClient } from "@/lib/api"
import { AppShell } from "@/components/app-shell"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "@/components/ui/textarea"
import { Spinner } from "@/components/ui/spinner"

interface Exhibit {
  id: number
  title: string
  description: string
  imageUrls?: string[]
  relatedExhibits?: { id: number; title: string }[]
}

export default function MuseumPage() {
  const { hasRole } = useAuth()
  const [exhibits, setExhibits] = useState<Exhibit[]>([])
  const [isLoading, setIsLoading] = useState(true)
  const [isDialogOpen, setIsDialogOpen] = useState(false)
  const [isSubmitting, setIsSubmitting] = useState(false)

  const [title, setTitle] = useState("")
  const [description, setDescription] = useState("")
  const [images, setImages] = useState<FileList | null>(null)
  const [selectedRelated, setSelectedRelated] = useState<number[]>([])

  const canCreate = hasRole("TEACHER")

  const fetchExhibits = async () => {
    try {
      const { data } = await apiClient.get<Exhibit[]>("/api/museum-exhibit/get-all")
      setExhibits(data)
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to fetch exhibits")
    } finally {
      setIsLoading(false)
    }
  }

  useEffect(() => {
    fetchExhibits()
  }, [])

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setIsSubmitting(true)
    try {
      const formData = new FormData()
      formData.append("title", title)
      formData.append("description", description)
      if (images) {
        Array.from(images).forEach((file) => {
          formData.append("images", file)
        })
      }
      if (selectedRelated.length > 0) {
        selectedRelated.forEach((id) => {
          formData.append("relatedExhibitIds", id.toString())
        })
      }
      await apiClient.post("/api/museum-exhibit/create", formData)
      toast.success("Exhibit created successfully!")
      setIsDialogOpen(false)
      setTitle("")
      setDescription("")
      setImages(null)
      setSelectedRelated([])
      fetchExhibits()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to create exhibit")
    } finally {
      setIsSubmitting(false)
    }
  }

  const toggleRelated = (id: number) => {
    setSelectedRelated((prev) =>
      prev.includes(id) ? prev.filter((i) => i !== id) : [...prev, id]
    )
  }

  return (
    <AppShell>
      <div className="space-y-6">
        <div className="flex items-center justify-between">
          <div>
            <h1 className="text-3xl font-bold text-foreground">Museum</h1>
            <p className="text-muted-foreground mt-1">Explore our school museum exhibits</p>
          </div>
          {canCreate && (
            <Dialog open={isDialogOpen} onOpenChange={setIsDialogOpen}>
              <DialogTrigger asChild>
                <Button>
                  <Plus className="size-4" />
                  Create Exhibit
                </Button>
              </DialogTrigger>
              <DialogContent className="max-w-lg max-h-[90vh] overflow-y-auto">
                <DialogHeader>
                  <DialogTitle>Create Exhibit</DialogTitle>
                  <DialogDescription>Add a new exhibit to the museum.</DialogDescription>
                </DialogHeader>
                <form onSubmit={handleSubmit} className="space-y-4">
                  <div className="space-y-2">
                    <Label htmlFor="title">Title</Label>
                    <Input
                      id="title"
                      value={title}
                      onChange={(e) => setTitle(e.target.value)}
                      placeholder="Enter exhibit title"
                      required
                    />
                  </div>
                  <div className="space-y-2">
                    <Label htmlFor="description">Description</Label>
                    <Textarea
                      id="description"
                      value={description}
                      onChange={(e) => setDescription(e.target.value)}
                      placeholder="Describe the exhibit..."
                      rows={4}
                      required
                    />
                  </div>
                  <div className="space-y-2">
                    <Label htmlFor="images">Images</Label>
                    <Input
                      id="images"
                      type="file"
                      accept="image/*"
                      multiple
                      onChange={(e) => setImages(e.target.files)}
                    />
                  </div>
                  {exhibits.length > 0 && (
                    <div className="space-y-2">
                      <Label>Related Exhibits</Label>
                      <div className="flex flex-wrap gap-2 max-h-32 overflow-y-auto p-2 border rounded-md">
                        {exhibits.map((exhibit) => (
                          <button
                            key={exhibit.id}
                            type="button"
                            onClick={() => toggleRelated(exhibit.id)}
                            className={`px-3 py-1 text-sm rounded-full transition-colors ${
                              selectedRelated.includes(exhibit.id)
                                ? "bg-primary text-primary-foreground"
                                : "bg-secondary text-secondary-foreground hover:bg-secondary/80"
                            }`}
                          >
                            {exhibit.title}
                          </button>
                        ))}
                      </div>
                    </div>
                  )}
                  <DialogFooter>
                    <Button type="submit" disabled={isSubmitting}>
                      {isSubmitting ? <Spinner className="size-4" /> : "Create"}
                    </Button>
                  </DialogFooter>
                </form>
              </DialogContent>
            </Dialog>
          )}
        </div>

        {isLoading ? (
          <div className="flex justify-center py-12">
            <Spinner className="size-8 text-primary" />
          </div>
        ) : exhibits.length === 0 ? (
          <Card className="border-primary/20">
            <CardContent className="py-12 text-center">
              <p className="text-muted-foreground">No exhibits yet.</p>
            </CardContent>
          </Card>
        ) : (
          <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            {exhibits.map((exhibit) => (
              <Link key={exhibit.id} href={`/museum/${exhibit.id}`}>
                <Card className="border-primary/20 shadow-md overflow-hidden hover:shadow-lg transition-shadow cursor-pointer h-full">
                  {exhibit.imageUrls && exhibit.imageUrls[0] && (
                    <div className="aspect-square overflow-hidden">
                      <img
                        src={exhibit.imageUrls[0]}
                        alt={exhibit.title}
                        className="w-full h-full object-cover"
                      />
                    </div>
                  )}
                  <CardHeader>
                    <CardTitle className="line-clamp-1">{exhibit.title}</CardTitle>
                  </CardHeader>
                  <CardContent>
                    <CardDescription className="line-clamp-2">
                      {exhibit.description}
                    </CardDescription>
                  </CardContent>
                </Card>
              </Link>
            ))}
          </div>
        )}
      </div>
    </AppShell>
  )
}
