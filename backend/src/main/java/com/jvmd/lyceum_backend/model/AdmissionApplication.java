package com.jvmd.lyceum_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "admission_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdmissionApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, name = "parent_name")
    private String parentName;

    @Column(nullable = false, name = "child_name")
    private String childName;

    @Column(nullable = false, name = "child_age")
    private int childAge;

    @Column(nullable = false)
    private String phone;

    @Column
    private String email;

    /** "1_CLASS" или "PRESCHOOL" */
    @Column(nullable = false, name = "class_type")
    private String classType;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(name = "created_at", nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum ApplicationStatus {
        PENDING, REVIEWED, REJECTED
    }
}
