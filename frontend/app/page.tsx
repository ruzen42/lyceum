import { Header } from "@/components/header"
import { Hero } from "@/components/hero"
import { AboutSection } from "@/components/about-section"
import { NewsSection } from "@/components/news-section"
import { RecordsSection } from "@/components/records-section"
import { PortfolioSection } from "@/components/portfolio-section"
import { MuseumSection } from "@/components/museum-section"
import { ClassroomsSection } from "@/components/classrooms-section"
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
        <RecordsSection />
        <PortfolioSection />
        <MuseumSection />
        <ClassroomsSection />
        <AdmissionSection />
        <ContactsSection />
      </main>
      <Footer />
    </div>
  )
}
