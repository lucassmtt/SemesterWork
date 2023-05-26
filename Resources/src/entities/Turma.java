package entities;

public class Turma {
    // Declarando todos os atributos da classe "Turma"
    public String diaSemana;
    public String horario;

    // Construtor simples da classe "Turma"
    public Turma(){}

    // Construtor com todos os campos da classe "Turma"
    public Turma(String diaSemana, String horario) {
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    // Getter e Setters da classe

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    // to String da classe
    @Override
    public String toString() {
        return "Turma{" +
                "diaSemana='" + diaSemana + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
