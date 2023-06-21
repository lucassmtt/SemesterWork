package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Turma implements Serializable
{
    public Integer Id_Turma;
    public String nomeTurma;
    public Sala sala;
    public Curso curso;

    public Turma(){};

    public Turma(Integer id_Turma, String nomeTurma)
    {
        Id_Turma = id_Turma;
        this.nomeTurma = nomeTurma;
    }

    public Turma(Integer id_Turma, String nomeTurma, Sala sala)
    {
        Id_Turma = id_Turma;
        this.nomeTurma = nomeTurma;
        this.sala = sala;
    }

    public Turma(Integer id_Turma, String nomeTurma, Curso curso)
    {
        Id_Turma = id_Turma;
        this.nomeTurma = nomeTurma;
        this.curso = curso;
    }

    public Turma(Integer id_Turma, String nomeTurma, Sala sala, Curso curso)
    {
        Id_Turma = id_Turma;
        this.nomeTurma = nomeTurma;
        this.sala = sala;
        this.curso = curso;
    }

    public Integer getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(Integer id_Turma) {
        Id_Turma = id_Turma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(Id_Turma, turma.Id_Turma) && Objects.equals(nomeTurma, turma.nomeTurma) && Objects.equals(sala, turma.sala) && Objects.equals(curso, turma.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Turma, nomeTurma, sala, curso);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "Id_Turma=" + Id_Turma +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", sala=" + sala +
                ", curso=" + curso +
                '}';
    }
}