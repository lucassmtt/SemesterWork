package model.entities;

import java.io.Serializable;

public class Aula implements Serializable {
    public int idAula;
    public Sala sala;
    public Turma turma;
    public String diaSemana;

    public Aula() {
    }

    public Aula(int idAula, String diaSemana)
    {
        this.idAula = idAula;
        this.diaSemana = diaSemana;
    }

    public Aula(int idAula, Sala sala, Turma turma, String diaSemana)
    {
        this.idAula = idAula;
        this.sala = sala;
        this.turma = turma;
        this.diaSemana = diaSemana;
    }

    public Aula(int idAula, Sala sala, String diaSemana)
    {
        this.idAula = idAula;
        this.sala = sala;
        this.diaSemana = diaSemana;
    }

    public Aula(int idAula, Turma turma, String diaSemana)
    {
        this.idAula = idAula;
        this.turma = turma;
        this.diaSemana = diaSemana;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "idAula=" + idAula +
                ", sala=" + sala +
                ", turma=" + turma +
                ", diaSemana='" + diaSemana + '\'' +
                '}';
    }
}
