import { Card, CardContent } from "@/components/ui/card"
import { BookOpen, Code, Trophy, Heart } from "lucide-react"

const features = [
  {
    icon: BookOpen,
    title: "Качественное образование",
    description: "Углублённое изучение предметов с акцентом на IT-технологии и инновационные методы обучения.",
  },
  {
    icon: Code,
    title: "IT-направленность",
    description: "Современные компьютерные классы, программирование и информатика с начальных классов.",
  },
  {
    icon: Trophy,
    title: "Олимпиадные успехи",
    description: "Ежегодные победы на городских, областных и республиканских олимпиадах по всем предметам.",
  },
  {
    icon: Heart,
    title: "Развитие личности",
    description: "Творческие кружки, спортивные секции, театральная студия и школа будущего первоклассника.",
  },
]

export function AboutSection() {
  return (
    <section id="about" className="bg-muted/30 py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="grid grid-cols-1 gap-12 lg:grid-cols-2">
          <div>
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              О нашем лицее
            </h2>
            <p className="mt-4 text-lg leading-relaxed text-muted-foreground">
              КГУ «Первый городской общеобразовательный IT-лицей» — это современное образовательное учреждение 
              с богатой 35-летней историей. Мы гордимся нашими традициями и стремимся к инновациям.
            </p>
            <p className="mt-4 text-muted-foreground">
              Наш лицей — это не просто школа, это большая дружная семья, где каждый ученик может 
              раскрыть свой потенциал, развить таланты и получить качественное образование для успешного будущего.
            </p>
            
            <div className="mt-8 grid grid-cols-2 gap-4">
              <div className="rounded-xl border border-border bg-card p-4">
                <p className="text-2xl font-bold text-primary">1991</p>
                <p className="text-sm text-muted-foreground">Год основания</p>
              </div>
              <div className="rounded-xl border border-border bg-card p-4">
                <p className="text-2xl font-bold text-primary">IT</p>
                <p className="text-sm text-muted-foreground">Специализация</p>
              </div>
            </div>
          </div>
          
          <div className="grid grid-cols-1 gap-4 sm:grid-cols-2">
            {features.map((feature, index) => (
              <Card key={index} className="group transition-all hover:shadow-lg hover:-translate-y-1">
                <CardContent className="p-6">
                  <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-primary/10 transition-colors group-hover:bg-primary/20">
                    <feature.icon className="h-6 w-6 text-primary" />
                  </div>
                  <h3 className="mt-4 font-semibold text-foreground">
                    {feature.title}
                  </h3>
                  <p className="mt-2 text-sm text-muted-foreground">
                    {feature.description}
                  </p>
                </CardContent>
              </Card>
            ))}
          </div>
        </div>
      </div>
    </section>
  )
}
