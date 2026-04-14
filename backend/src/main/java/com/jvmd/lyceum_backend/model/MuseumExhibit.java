package com.jvmd.lyceum_backend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "museum_exhibits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MuseumExhibit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String htmlContent;

    @ElementCollection
    @CollectionTable(name = "exhibit_image_urls", joinColumns = @JoinColumn(name = "exhibit_id"))
    @Column(name = "image_url", length = 1024)
    @Builder.Default
    private List<String> imageUrls = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "exhibit_related",
            joinColumns = @JoinColumn(name = "exhibit_id"),
            inverseJoinColumns = @JoinColumn(name = "related_exhibit_id")
    )
    @JsonIgnoreProperties("relatedExhibits")
    @Builder.Default
    private List<MuseumExhibit> relatedExhibits = new ArrayList<>();
}
