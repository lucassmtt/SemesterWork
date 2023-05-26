package model.entities;

import java.util.ArrayList;

public class Turma {
    // Declarando todos os atributos da classe "Turma"
    public Sala sala;
    public String nomeTurma;
    public int codigo_turma;
    public ArrayList<Aluno> alunos_da_turma;

    public ArrayList<DiaSemana> dia_aula;

    // Construtor simples da classe "Turma"
    public Turma(){}

    // Construtor com todos os campos da classe "Turma"
    public Turma(String nomeTurma, int codigo_turma, ArrayList<DiaSemana> lista_de_dias_de_aula) {
        this.nomeTurma = nomeTurma;
        this.dia_aula = lista_de_dias_de_aula;
        this.codigo_turma = codigo_turma;
    }

    public void adicionar_dia(DiaSemana diaSemana){
        dia_aula.add(diaSemana);
    }

    public void remover_dia(DiaSemana diaSemana){
        dia_aula.remove(diaSemana);
    }
    public void adicionar_aluno_a_turma(Aluno aluno){
        alunos_da_turma.add(aluno);
    }

    public int tamanho_da_turma(){
        return alunos_da_turma.size();
    }

//    public void adicionar_aula_a_dia(int indexdia){
//        switch (dia_aula.get(indexdia)){
//            case SEGUNDA -> {
//                dia_aula.get(indexdia)
//            }
//            case TERCA -> {}
//            case QUARTA -> {}
//            case QUINTA -> {}
//            case SEXTA -> {}
//        }
//
//
//        if (dia_aula.get(indexdia) == DiaSemana.SEGUNDA){
//
//        }
//    }

//    public void adicionarTurmaSala(Turma turma){
//    }
//    public void adicionarMaisDias(){
//        if (diasComprometidos.size() == 5){
//
//        }
//    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String diaDeAula(ArrayList<DiaSemana> dia_aula){
        ArrayList<String> dias = new ArrayList<>();
        System.out.println("Dias da semana que tem aula: ");
        for (DiaSemana dia : dia_aula){
            String dia_em_string = dia.toString();
            dias.add(dia_em_string);
        }
        return dias.toString();
    }

    // to String da classe

    @Override
    public String toString() {
        return  "Nome da turma: " + nomeTurma +
                ", código da turma: " + codigo_turma +
                ", alunos da turma: " + alunos_da_turma +
                ", dias de aula: " + diaDeAula(dia_aula);
    }
}
