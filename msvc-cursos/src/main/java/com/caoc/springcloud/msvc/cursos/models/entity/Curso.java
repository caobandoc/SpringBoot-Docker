package com.caoc.springcloud.msvc.cursos.models.entity;

import com.caoc.springcloud.msvc.cursos.models.Usuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoUsuario> cursoUsuario;

    @Transient
    private List<Usuario> usuarios;

    public Curso() {
        cursoUsuario = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void addCursoUsuario(CursoUsuario cursoUsuario) {
        this.cursoUsuario.add(cursoUsuario);
    }

    public void removeCursoUsuario(CursoUsuario cursoUsuario) {
        this.cursoUsuario.remove(cursoUsuario);
    }
}
