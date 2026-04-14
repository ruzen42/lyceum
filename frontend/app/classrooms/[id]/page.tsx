"use client"

import { useState, useEffect, use } from "react"
import Link from "next/link"
import { ArrowLeft, RefreshCw, Plus, Trash2, Download, User, Calendar, FileText } from "lucide-react"
import { toast } from "sonner"
import { useAuth } from "@/lib/auth-context"
import { apiClient, fetchHtml } from "@/lib/api"
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
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog"

interface MaterialAuthor {
  username: string
  email: string
}

interface Material {
  id: number
  title: string
  description: string
  fileUrls?: string[]
  author: MaterialAuthor
  createdAt: string
}

interface Classroom {
  id: number
  title: string
  materials?: Material[]
}

export default function ClassroomDetailPage({
  params,
}: {
  params: Promise<{ id: string }>
}) {
  const { id } = use(params)
  const { hasRole } = useAuth()
  const [classroom, setClassroom] = useState<Classroom | null>(null)
  const [htmlContent, setHtmlContent] = useState<string>("")
  const [isLoading, setIsLoading] = useState(true)
  const [isRegenerating, setIsRegenerating] = useState(false)
  const [isDialogOpen, setIsDialogOpen] = useState(false)
  const [isSubmitting, setIsSubmitting] = useState(false)
  const [deletingMaterialId, setDeletingMaterialId] = useState<number | null>(null)

  const [title, setTitle] = useState("")
  const [description, setDescription] = useState("")
  const [files, setFiles] = useState<FileList | null>(null)

  const canAddMaterial = hasRole("TEACHER")
  const canRegenerate = hasRole("ADMIN")
  const canDelete = hasRole("TEACHER")

  const fetchClassroom = async () => {
    try {
      const { data } = await apiClient.get<Classroom>(`/api/classroom/${id}`)
      setClassroom(data)
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to fetch classroom")
    } finally {
      setIsLoading(false)
    }
  }

  const loadHtml = async () => {
    try {
      const html = await fetchHtml("classroom", Number(id))
      setHtmlContent(html)
    } catch {
      // HTML not ready yet
    }
  }

  useEffect(() => {
    fetchClassroom()
    loadHtml()
  }, [id])

  const handleRegenerate = async () => {
    setIsRegenerating(true)
    try {
      await apiClient.post(`/api/classroom/${id}/regenerate-html`)
      toast.success("HTML regenerated successfully!")
      await loadHtml()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to regenerate HTML")
    } finally {
      setIsRegenerating(false)
    }
  }

  const handleAddMaterial = async (e: React.FormEvent) => {
    e.preventDefault()
    setIsSubmitting(true)
    try {
      const formData = new FormData()
      formData.append("title", title)
      formData.append("description", description)
      if (files) {
        Array.from(files).forEach((file) => {
          formData.append("files", file)
        })
      }
      await apiClient.post(`/api/classroom/${id}/material`, formData)
      toast.success("Material added successfully!")
      setIsDialogOpen(false)
      setTitle("")
      setDescription("")
      setFiles(null)
      fetchClassroom()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to add material")
    } finally {
      setIsSubmitting(false)
    }
  }

  const handleDeleteMaterial = async (materialId: number) => {
    setDeletingMaterialId(materialId)
    try {
      await apiClient.delete(`/api/classroom/material/${materialId}`)
      toast.success("Material deleted successfully!")
      fetchClassroom()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to delete material")
    } finally {
      setDeletingMaterialId(null)
    }
  }

  const formatDate = (dateStr: string) => {
    return new Date(dateStr).toLocaleDateString("ru-RU", {
      year: "numeric",
      month: "long",
      day: "numeric",
    })
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

  if (!classroom) {
    return (
      <AppShell>
        <div className="text-center py-12">
          <p className="text-muted-foreground">Classroom not found.</p>
          <Link href="/classrooms">
            <Button variant="outline" className="mt-4">
              <ArrowLeft className="size-4" />
              Back to Classrooms
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
          <Link href="/classrooms">
            <Button variant="outline" size="icon">
              <ArrowLeft className="size-4" />
            </Button>
          </Link>
          <div className="flex-1">
            <h1 className="text-3xl font-bold text-foreground">{classroom.title}</h1>
          </div>
          <div className="flex gap-2">
            {canAddMaterial && (
              <Dialog open={isDialogOpen} onOpenChange={setIsDialogOpen}>
                <DialogTrigger asChild>
                  <Button variant="outline">
                    <Plus className="size-4" />
                    Add Material
                  </Button>
                </DialogTrigger>
                <DialogContent>
                  <DialogHeader>
                    <DialogTitle>Add Material</DialogTitle>
                    <DialogDescription>Upload new material for this classroom.</DialogDescription>
                  </DialogHeader>
                  <form onSubmit={handleAddMaterial} className="space-y-4">
                    <div className="space-y-2">
                      <Label htmlFor="mat-title">Title</Label>
                      <Input
                        id="mat-title"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        placeholder="Enter material title"
                        required
                      />
                    </div>
                    <div className="space-y-2">
                      <Label htmlFor="mat-description">Description</Label>
                      <Textarea
                        id="mat-description"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        placeholder="Describe the material..."
                        rows={3}
                        required
                      />
                    </div>
                    <div className="space-y-2">
                      <Label htmlFor="mat-files">Files</Label>
                      <Input
                        id="mat-files"
                        type="file"
                        multiple
                        onChange={(e) => setFiles(e.target.files)}
                      />
                    </div>
                    <DialogFooter>
                      <Button type="submit" disabled={isSubmitting}>
                        {isSubmitting ? <Spinner className="size-4" /> : "Add Material"}
                      </Button>
                    </DialogFooter>
                  </form>
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

        {/* HTML Preview */}
        {htmlContent && (
          <Card className="border-primary/20 shadow-md">
            <CardHeader>
              <CardTitle>Classroom Preview</CardTitle>
            </CardHeader>
            <CardContent>
              <div className="h-96 w-full">
                <iframe
                  srcDoc={htmlContent}
                  className="w-full h-full border rounded-lg"
                  title={`${classroom.title} HTML`}
                  sandbox="allow-same-origin"
                />
              </div>
            </CardContent>
          </Card>
        )}

        {/* Materials */}
        <div className="space-y-4">
          <h2 className="text-xl font-semibold text-foreground">Materials</h2>
          {!classroom.materials || classroom.materials.length === 0 ? (
            <Card className="border-primary/20">
              <CardContent className="py-8 text-center">
                <p className="text-muted-foreground">No materials yet.</p>
              </CardContent>
            </Card>
          ) : (
            <div className="grid gap-4">
              {classroom.materials.map((material) => (
                <Card key={material.id} className="border-primary/20 shadow-md">
                  <CardHeader>
                    <div className="flex items-start justify-between">
                      <div>
                        <CardTitle className="flex items-center gap-2">
                          <FileText className="size-5 text-primary" />
                          {material.title}
                        </CardTitle>
                        <CardDescription className="flex items-center gap-4 mt-2">
                          <span className="flex items-center gap-1">
                            <User className="size-3" />
                            {material.author.username}
                          </span>
                          <span className="flex items-center gap-1">
                            <Calendar className="size-3" />
                            {formatDate(material.createdAt)}
                          </span>
                        </CardDescription>
                      </div>
                      {canDelete && (
                        <AlertDialog>
                          <AlertDialogTrigger asChild>
                            <Button
                              variant="ghost"
                              size="icon"
                              className="text-destructive hover:text-destructive hover:bg-destructive/10"
                            >
                              {deletingMaterialId === material.id ? (
                                <Spinner className="size-4" />
                              ) : (
                                <Trash2 className="size-4" />
                              )}
                            </Button>
                          </AlertDialogTrigger>
                          <AlertDialogContent>
                            <AlertDialogHeader>
                              <AlertDialogTitle>Delete Material</AlertDialogTitle>
                              <AlertDialogDescription>
                                Are you sure you want to delete this material? This action cannot be
                                undone.
                              </AlertDialogDescription>
                            </AlertDialogHeader>
                            <AlertDialogFooter>
                              <AlertDialogCancel>Cancel</AlertDialogCancel>
                              <AlertDialogAction
                                onClick={() => handleDeleteMaterial(material.id)}
                                className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
                              >
                                Delete
                              </AlertDialogAction>
                            </AlertDialogFooter>
                          </AlertDialogContent>
                        </AlertDialog>
                      )}
                    </div>
                  </CardHeader>
                  <CardContent>
                    <p className="text-sm text-muted-foreground mb-4">{material.description}</p>
                    {material.fileUrls && material.fileUrls.length > 0 && (
                      <div className="flex flex-wrap gap-2">
                        {material.fileUrls.map((file, index) => {
                          const fileName = file.split("/").pop() || `File ${index + 1}`
                          return (
                            <a
                              key={index}
                              href={file}
                              download
                              className="inline-flex items-center gap-1 px-3 py-1.5 text-sm bg-secondary text-secondary-foreground rounded-md hover:bg-secondary/80 transition-colors"
                            >
                              <Download className="size-3" />
                              {fileName}
                            </a>
                          )
                        })}
                      </div>
                    )}
                  </CardContent>
                </Card>
              ))}
            </div>
          )}
        </div>
      </div>
    </AppShell>
  )
}
