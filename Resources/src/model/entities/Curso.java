package model.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Curso {
    // Declarando todos os atributos da classe "Curso"
    public int codigoCurso;
    public String nomeCurso;
    public int cargaHoraria;
    public String descricao;
    public Set<DiaSemana> diaSemana;

    public ArrayList<Aluno> listaAlunoNoCurso;

    // Construtor simples da classse
    public Curso(){}

    // Construtor com todos os campos da classe
    public Curso(int codigoCurso, String nomeCurso, int cargaHoraria, String descricao) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.diaSemana = new HashSet<>();
    }

    public void adicionarAlunosAoCurso(Aluno aluno)
    {
        listaAlunoNoCurso.add(aluno);
    }

    public void removerAlunoDoCurso(Aluno aluno)
    {
        listaAlunoNoCurso.remove(aluno);
    }
    // Getters e Setters da classe
    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
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

    public void adicionarDiaSemana(DiaSemana dia){
        diaSemana.add(dia);
    }

    public void removerDiaSemana(DiaSemana dia){
        diaSemana.remove(dia);
    }

    public Set<DiaSemana> getDiasSemana(){
        return diaSemana;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //to String da classe
    @Override
    public String toString() {
        return  "código do curso: " + codigoCurso +
                ", nome do curso: " + nomeCurso +
                ", carga horária: " + cargaHoraria +
                ", descricao: " + descricao + ".";
    }
}
