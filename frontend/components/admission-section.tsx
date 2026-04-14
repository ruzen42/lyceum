import { Button } from "@/components/ui/button"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Phone, FileText, CalendarCheck, Users, CheckCircle2 } from "lucide-react"

const admissionInfo = [
  {
    title: "1 класс",
    description: "Запись на вступительное диагностическое собеседование",
    phone: "500-716, 467-046",
    icon: Users,
    status: "Запись открыта",
    statusColor: "text-accent",
  },
  {
    title: "Предшкольный класс",
    description: "Подготовка к школе для будущих первоклассников",
    phone: "46-70-46",
    icon: CalendarCheck,
    status: "Идёт набор",
    statusColor: "text-accent",
  },
]

const vacancies = [
  "Заместитель директора по учебной работе",
  "Учитель биологии",
  "Учитель начальных классов",
  "Социальный педагог",
  "Педагог-психолог",
  "Учитель художественного труда",
]

export function AdmissionSection() {
  return (
    <section id="admission" className="bg-muted/50 py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="text-center">
          <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
            Поступление в лицей
          </h2>
          <p className="mt-2 text-muted-foreground">
            Информация для родителей и будущих лицеистов
          </p>
        </div>
        
        <div className="mt-12 grid grid-cols-1 gap-6 lg:grid-cols-2">
          {admissionInfo.map((item, index) => (
            <Card key={index} className="relative overflow-hidden">
              <div className="absolute right-0 top-0 h-32 w-32 -translate-y-8 translate-x-8 rounded-full bg-primary/5" />
              <CardHeader>
                <div className="flex items-start justify-between">
                  <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-primary/10">
                    <item.icon className="h-6 w-6 text-primary" />
                  </div>
                  <span className={`inline-flex items-center gap-1 text-sm font-medium ${item.statusColor}`}>
                    <CheckCircle2 className="h-4 w-4" />
                    {item.status}
                  </span>
                </div>
                <CardTitle className="mt-4 text-xl">{item.title}</CardTitle>
                <CardDescription className="text-base">
                  {item.description}
                </CardDescription>
              </CardHeader>
              <CardContent>
                <div className="flex items-center gap-2 text-sm text-muted-foreground">
                  <Phone className="h-4 w-4" />
                  <span>Справки по телефону: {item.phone}</span>
                </div>
                <Button className="mt-4 w-full">
                  Записаться
                </Button>
              </CardContent>
            </Card>
          ))}
        </div>
        
        <Card className="mt-8">
          <CardHeader>
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-accent/10">
                <FileText className="h-5 w-5 text-accent" />
              </div>
              <div>
                <CardTitle>Вакансии</CardTitle>
                <CardDescription>
                  КГУ «Первый городской общеобразовательный IT-лицей» объявляет конкурс
                </CardDescription>
              </div>
            </div>
          </CardHeader>
          <CardContent>
            <div className="grid grid-cols-1 gap-2 sm:grid-cols-2 md:grid-cols-3">
              {vacancies.map((vacancy, index) => (
                <div 
                  key={index}
                  className="flex items-center gap-2 rounded-lg bg-muted/50 px-3 py-2 text-sm"
                >
                  <CheckCircle2 className="h-4 w-4 text-accent" />
                  <span>{vacancy}</span>
                </div>
              ))}
            </div>
            <div className="mt-6 flex flex-col gap-3 sm:flex-row sm:items-center sm:justify-between">
              <p className="text-sm text-muted-foreground">
                Документы принимаются на сайте hr-nobd.edu.kz
              </p>
              <Button variant="outline">
                Подать заявку
              </Button>
            </div>
          </CardContent>
        </Card>
      </div>
    </section>
  )
}
