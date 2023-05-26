package model.entities;

import java.util.ArrayList;

public class Turma {
    // Declarando todos os atributos da classe "Turma"
    public Sala sala;
    public ArrayList<Aluno> alunos_da_turma;

    public ArrayList<DiaSemana> dia_aula;

    // Construtor simples da classe "Turma"
    public Turma(){}

    // Construtor com todos os campos da classe "Turma"
    public Turma(DiaSemana diaSemana) {
        dia_aula.add(diaSemana);
    }

    public void adicionar_dia(DiaSemana diaSemana, int dia_em_formato_numero){
        dia_aula.set(dia_em_formato_numero, diaSemana);
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

    // to String da classe

}
