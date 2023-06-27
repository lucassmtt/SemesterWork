package model.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Aula implements Serializable {
    public int idAula;
    public String nomeAula;
    public Sala sala;
    public Turma turma;
    public Set<String> diaSemana = new HashSet<>();

    public Aula() {
    }

    public Aula(String diaSemana, String nomeAula)
    {
        this.diaSemana.add(diaSemana);
        this.nomeAula = nomeAula;
    }

    public Aula(String nomeAula, String diaSemana, Sala sala, Turma turma)
    {
        this.nomeAula = nomeAula;
        this.sala = sala;
        this.turma = turma;
        this.diaSemana.add(diaSemana);
    }

    public Aula(String diaSemana, String nomeAula, Sala sala)
    {
        this.nomeAula = nomeAula;
        this.diaSemana.add(diaSemana);
        this.sala = sala;
    }

    public Aula(String diaSemana, String nomeAula, Turma turma)
    {
        this.nomeAula = nomeAula;
        this.diaSemana.add(diaSemana);
        this.turma = turma;
    }

    public Object se_existir_a_sala_retorna_id_ou_null(){
        if (sala == null){
            return null;
        }
        else {
            try {
                return sala.getId_Sala();
            }
            catch (Exception e){
                return null;
            }
        }
    }

    public Object se_existir_a_turma_retorna_id_ou_null(){
        if (sala == null){
            return null;
        }
        else {
            try{
                return turma.getId_Turma();
            }
            catch (Exception e){
                return null;
            }
        }
    }

    public Object se_existir_a_dia_semana_retorna_dia_ou_null(){
        if (diaSemana == null){
            return null;
        }
        else {
            try {
                return getDiaSemanaToJson();
            }
            catch (Exception e){
                return null;
            }
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
        StringBuilder diaEmString = new StringBuilder();
        for (String dia : this.diaSemana){
            diaEmString.append(' ').append(dia);
        }
        return diaEmString.toString();
    }

    public String getDiaSemanaToJson()
    {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        boolean primeiro = true;

        for (String valor : diaSemana){
            if (!primeiro){
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\"").append(valor).append("\"");
            primeiro = false;
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public void setDiaSemana(String diaSemana) {
        if (this.diaSemana != null){
            if (this.diaSemana.contains(diaSemana))
            {
                System.out.println("Infelizmente não podemos adicionar dois dias iguais...");
            }
            else {
                this.diaSemana.add(diaSemana);
            }
        }
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
