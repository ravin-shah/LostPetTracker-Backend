package com.ravinshah.petApp.pet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,updatable = false)
    private Long id;

    @Column(updatable = false)
    private String name;

    private boolean isLost = false;

    public Pet(String name) {
        this.name = name;
    }
}