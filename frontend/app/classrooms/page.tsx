"use client"

import { useState, useEffect } from "react"
import Link from "next/link"
import { Plus, School } from "lucide-react"
import { toast } from "sonner"
import { useAuth } from "@/lib/auth-context"
import { apiClient } from "@/lib/api"
import { AppShell } from "@/components/app-shell"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
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
import { Spinner } from "@/components/ui/spinner"

interface Classroom {
  id: number
  title: string
}

export default function ClassroomsPage() {
  const { hasRole } = useAuth()
  const [classrooms, setClassrooms] = useState<Classroom[]>([])
  const [isLoading, setIsLoading] = useState(true)
  const [isDialogOpen, setIsDialogOpen] = useState(false)
  const [isSubmitting, setIsSubmitting] = useState(false)
  const [title, setTitle] = useState("")

  const canCreate = hasRole("ADMIN")

  const fetchClassrooms = async () => {
    try {
      const { data } = await apiClient.get<Classroom[]>("/api/classroom/get-all")
      setClassrooms(data)
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to fetch classrooms")
    } finally {
      setIsLoading(false)
    }
  }

  useEffect(() => {
    fetchClassrooms()
  }, [])

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setIsSubmitting(true)
    try {
      await apiClient.post(`/api/classroom/create`, null, {
        params: { title },
      })
      toast.success("Classroom created successfully!")
      setIsDialogOpen(false)
      setTitle("")
      fetchClassrooms()
    } catch (error) {
      toast.error(error instanceof Error ? error.message : "Failed to create classroom")
    } finally {
      setIsSubmitting(false)
    }
  }

  return (
    <AppShell>
      <div className="space-y-6">
        <div className="flex items-center justify-between">
          <div>
            <h1 className="text-3xl font-bold text-foreground">Classrooms</h1>
            <p className="text-muted-foreground mt-1">Browse and manage classrooms</p>
          </div>
          {canCreate && (
            <Dialog open={isDialogOpen} onOpenChange={setIsDialogOpen}>
              <DialogTrigger asChild>
                <Button>
                  <Plus className="size-4" />
                  Create Classroom
                </Button>
              </DialogTrigger>
              <DialogContent>
                <DialogHeader>
                  <DialogTitle>Create Classroom</DialogTitle>
                  <DialogDescription>Add a new classroom to the platform.</DialogDescription>
                </DialogHeader>
                <form onSubmit={handleSubmit} className="space-y-4">
                  <div className="space-y-2">
                    <Label htmlFor="title">Title</Label>
                    <Input
                      id="title"
                      value={title}
                      onChange={(e) => setTitle(e.target.value)}
                      placeholder="Enter classroom title"
                      required
                    />
                  </div>
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
        ) : classrooms.length === 0 ? (
          <Card className="border-primary/20">
            <CardContent className="py-12 text-center">
              <p className="text-muted-foreground">No classrooms yet.</p>
            </CardContent>
          </Card>
        ) : (
          <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            {classrooms.map((classroom) => (
              <Link key={classroom.id} href={`/classrooms/${classroom.id}`}>
                <Card className="border-primary/20 shadow-md hover:shadow-lg transition-shadow cursor-pointer h-full">
                  <CardHeader>
                    <div className="flex items-center gap-3">
                      <div className="p-2 bg-primary/10 rounded-lg">
                        <School className="size-6 text-primary" />
                      </div>
                      <CardTitle className="line-clamp-2">{classroom.title}</CardTitle>
                    </div>
                  </CardHeader>
                  <CardContent>
                    <p className="text-sm text-muted-foreground">
                      Click to view classroom details and materials
                    </p>
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
