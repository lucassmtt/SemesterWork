package model.entities;

import db.DbException;

import java.io.Serializable;
import java.util.Objects;

public class Turma implements Serializable
{
    public Integer Id_Turma;
    public String nomeTurma;

    public Curso curso;

    public Turma(){};

    public Turma(String nomeTurma)
    {
        this.nomeTurma = nomeTurma;
    }

    public Turma(String nomeTurma, Curso curso)
    {
        this.nomeTurma = nomeTurma;
        this.curso = curso;
    }


    public Object se_existir_o_curso_retorna_id_ou_null(){
        if (curso != null){
            try{
                return curso.getId_Curso();
            }
            catch (Exception e){
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Object se_existir_o_nome_retorna_nome_ou_null(){
        if (nomeTurma == null){
            return null;
        }
        else {
            return getNomeTurma();
        }
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
        return Objects.equals(Id_Turma, turma.Id_Turma) && Objects.equals(nomeTurma, turma.nomeTurma) && Objects.equals(curso, turma.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Turma, nomeTurma, curso);
    }

    @Override
    public String toString() {
        return "Turma ID: " + getId_Turma() + "\n" +
                "Nome da turma: " + getNomeTurma() + "\n" +
                "Curso: " + getCurso();
    }
}