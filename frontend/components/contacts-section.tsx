import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Phone, MapPin, Shield, HeartHandshake, AlertTriangle, Info } from "lucide-react"

const helpLines = [
  {
    title: "Департамент по защите прав детей СКО",
    phones: ["+7 (7152) 46-06-54", "+7 (7152) 46-58-61"],
    address: "г. Петропавловск, ул. Абая, 29, 3 этаж",
    icon: Shield,
  },
  {
    title: "Экстренная психологическая помощь",
    phones: ["8-800-080-8150"],
    description: "Для детей и подростков",
    icon: HeartHandshake,
  },
  {
    title: "Комитет по охране прав детей МОН РК",
    phones: ["+7 (7172) 74-25-28"],
    icon: Info,
  },
  {
    title: "Телефон доверия",
    phones: ["+7 (7152) 46-13-60"],
    description: "Профилактика насилия и жестокого обращения",
    icon: AlertTriangle,
  },
]

export function ContactsSection() {
  return (
    <section id="contacts" className="bg-background py-16 sm:py-24">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="grid grid-cols-1 gap-12 lg:grid-cols-2">
          <div>
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              Контакты
            </h2>
            <p className="mt-2 text-muted-foreground">
              Свяжитесь с нами любым удобным способом
            </p>
            
            <div className="mt-8 space-y-6">
              <div className="flex items-start gap-4">
                <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-lg bg-primary/10">
                  <MapPin className="h-5 w-5 text-primary" />
                </div>
                <div>
                  <h3 className="font-semibold text-foreground">Адрес</h3>
                  <p className="mt-1 text-muted-foreground">
                    150000, Республика Казахстан,<br />
                    Северо-Казахстанская область,<br />
                    г. Петропавловск
                  </p>
                </div>
              </div>
              
              <div className="flex items-start gap-4">
                <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-lg bg-primary/10">
                  <Phone className="h-5 w-5 text-primary" />
                </div>
                <div>
                  <h3 className="font-semibold text-foreground">Телефоны</h3>
                  <div className="mt-1 space-y-1">
                    <p className="text-muted-foreground">
                      <a href="tel:+77152467046" className="hover:text-primary transition-colors">
                        +7 (7152) 46-70-46
                      </a>
                      <span className="ml-2 text-sm">(приёмная)</span>
                    </p>
                    <p className="text-muted-foreground">
                      <a href="tel:+77152500716" className="hover:text-primary transition-colors">
                        +7 (7152) 500-716
                      </a>
                      <span className="ml-2 text-sm">(запись в 1 класс)</span>
                    </p>
                  </div>
                </div>
              </div>
            </div>
            
            <div className="mt-10 rounded-2xl border border-border bg-card p-6">
              <h3 className="font-semibold text-foreground">Единый номер Call-center</h3>
              <p className="mt-1 text-sm text-muted-foreground">
                Уполномоченного по правам ребёнка
              </p>
              <p className="mt-3 text-3xl font-bold text-primary">111</p>
              <p className="mt-2 text-sm text-muted-foreground">
                Министерство образования и науки Республики Казахстан
              </p>
            </div>
          </div>
          
          <div>
            <h3 className="text-xl font-semibold text-foreground">
              Полезные контакты
            </h3>
            <p className="mt-1 text-sm text-muted-foreground">
              Службы помощи и защиты прав детей
            </p>
            
            <div className="mt-6 grid grid-cols-1 gap-4">
              {helpLines.map((line, index) => (
                <Card key={index} className="transition-shadow hover:shadow-md">
                  <CardHeader className="pb-2">
                    <div className="flex items-start gap-3">
                      <div className="flex h-9 w-9 shrink-0 items-center justify-center rounded-lg bg-accent/10">
                        <line.icon className="h-4 w-4 text-accent" />
                      </div>
                      <div>
                        <CardTitle className="text-sm font-medium">
                          {line.title}
                        </CardTitle>
                        {line.description && (
                          <CardDescription className="text-xs">
                            {line.description}
                          </CardDescription>
                        )}
                      </div>
                    </div>
                  </CardHeader>
                  <CardContent className="pt-0">
                    <div className="ml-12 space-y-1">
                      {line.phones.map((phone, phoneIndex) => (
                        <a
                          key={phoneIndex}
                          href={`tel:${phone.replace(/[^+\d]/g, "")}`}
                          className="block text-sm font-medium text-primary hover:underline"
                        >
                          {phone}
                        </a>
                      ))}
                      {line.address && (
                        <p className="text-xs text-muted-foreground">{line.address}</p>
                      )}
                    </div>
                  </CardContent>
                </Card>
              ))}
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}
