package com.jvmd.lyceum_backend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "newss")
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


}
