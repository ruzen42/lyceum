import { Header } from "@/components/header"
import { Hero } from "@/components/hero"
import { AboutSection } from "@/components/about-section"
import { NewsSection } from "@/components/news-section"
import { AdmissionSection } from "@/components/admission-section"
import { ContactsSection } from "@/components/contacts-section"
import { Footer } from "@/components/footer"

export default function Home() {
  return (
    <div className="flex min-h-screen flex-col">
      <Header />
      <main className="flex-1">
        <Hero />
        <AboutSection />
        <NewsSection />
        <AdmissionSection />
        <ContactsSection />
      </main>
      <Footer />
    </div>
  )
}
