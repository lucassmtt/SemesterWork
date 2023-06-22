package model.entities;

import java.io.Serializable;

public class Aula implements Serializable {
    public int idAula;
    public String nomeAula;
    public Sala sala;
    public Turma turma;
    public String diaSemana;

    public Aula() {
    }

    public Aula(String diaSemana, String nomeAula)
    {
        this.diaSemana = diaSemana;
        this.nomeAula = nomeAula;
    }

    public Aula(String nomeAula, String diaSemana, Sala sala, Turma turma)
    {
        this.nomeAula = nomeAula;
        this.diaSemana = diaSemana;
        this.sala = sala;
        this.turma = turma;
    }

    public Aula(String diaSemana, String nomeAula, Sala sala)
    {
        this.nomeAula = nomeAula;
        this.diaSemana = diaSemana;
        this.sala = sala;
    }

    public Aula(String diaSemana, String nomeAula, Turma turma)
    {
        this.nomeAula = nomeAula;
        this.diaSemana = diaSemana;
        this.turma = turma;
    }

    public Object se_existir_a_sala_retorna_id_ou_null(){
        if (sala == null){
            return null;
        }
        else {
            return sala.getId_Sala();
        }
    }

    public Object se_existir_a_turma_retorna_id_ou_null(){
        if (sala == null){
            return null;
        }
        else {
            return turma.getId_Turma();
        }
    }

    public Object se_existir_a_dia_semana_retorna_dia_ou_null(){
        if (diaSemana == null){
            return null;
        }
        else {
            return getDiaSemana();
        }
    }

    public Object se_existir_nome_retorna_nome_ou_null(){
        if (nomeAula == null){
            return null;
        }
        else {
            return getNomeAula();
        }
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
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
