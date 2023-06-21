package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Curso implements Serializable {
    // Declarando todos os atributos da classe "Curso"
    public Integer Id_Curso;
    public String nomeCurso;
    public int cargaHoraria;
    public String descricao;

    // Construtor simples da classse
    public Curso() {
    }

    // Construtor com todos os campos da classe
    public Curso(Integer Id_Curso, String nomeCurso, int cargaHoraria, String descricao) {
        this.Id_Curso = Id_Curso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }


    // Getters e Setters da classe
    public int getId_Curso() {
        return Id_Curso;
    }

    public void setId_Curso(int Id_Curso) {
        this.Id_Curso = Id_Curso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void adicionarDiaSemana(DiaSemana dia) {
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria && Objects.equals(Id_Curso, curso.Id_Curso) && Objects.equals(nomeCurso, curso.nomeCurso) && Objects.equals(descricao, curso.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Curso, nomeCurso, cargaHoraria, descricao);
    }

    //to String da classe
    @Override
    public String toString() {
        return "código do curso: " + Id_Curso +
                ", nome do curso: " + nomeCurso +
                ", carga horária: " + cargaHoraria +
                ", descricao: " + descricao + ".";
    }
}
