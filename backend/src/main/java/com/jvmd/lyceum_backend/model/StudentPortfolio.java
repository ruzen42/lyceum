package com.jvmd.lyceum_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_portfolios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, name = "student_name")
    private String studentName;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String bio;

    @Column(name = "image_url")
    private String imageUrl;

    @ElementCollection
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "portfolio_skills", joinColumns = @JoinColumn(name = "portfolio_id"))
    @Column(name = "skill")
    private List<String> skills;

    @ElementCollection
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "portfolio_achievements", joinColumns = @JoinColumn(name = "portfolio_id"))
    @Column(name = "achievement")
    private List<String> achievements;

    @Column(name = "created_at", nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
