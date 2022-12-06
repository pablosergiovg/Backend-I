package com.example.clase33s.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="profesores")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String titulo;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Jugador> estudiantes = new HashSet<>();

    public Set<Jugador> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Jugador> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
