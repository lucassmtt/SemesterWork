package model.tools;

import model.entities.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exibir {
    public static void menu() {
        separador();
        System.out.println("""
                DIGITE UM NÚMERO PARA:

                 0 = SAIR
                 1 = CADASTRAR ALUNO
                 2 = CADASTRAR SALA
                 3 = CADASTRAR CURSO
                 4 = CADASTRAR TURMA
                 5 = CADASTRAR PROFESSOR
                 6 = CADASTRAR AULA
                 7 = MOSTRAR ALUNOS
                 8 = MOSTRAR SALAS
                 9 = MOSTRAR CURSOS
                 10 = MOSTRAR TURMAS
                 11 = MOSTRAR PROFESSORES
                 12 = ADICIONAR ALUNO A CURSO
                 13 = ADICIONAR TURMA A CURSO
                 14 = ADICIONAR PROFESSOR A CURSO
                 15 = ADICIONAR AULA A SALA
                 16 = ADICIONAR TURMA A SALA
                """);
        System.out.print("Resposta: ");
    }


    public static ArrayList<String> diaDaSemana(Scanner SCANNER)
    {
        ArrayList<String> dias_de_aula = new ArrayList<>();

        while (true){
            System.out.println("""
                \n0 = Cancelar operação
                1 = Segunda
                2 = Terça
                3 = Quarta
                4 = Quinta
                5 = Sexta
                
                (Por favor, adicione um dia por vez)
                
                """);
            System.out.print("Resposta: ");
            int resp = SCANNER.nextInt();
            if (resp > 5 || resp < 0){
                continue;
            }
            switch (resp){
                case 0 -> {
                    return null;
                }
                case 1 -> {
                    if (dias_de_aula.contains("Segunda")){
                        System.out.println("Impossível inserir valores iguais...");
                        Exibir.espera_em_ms(500);
                        continue;
                    }
                    dias_de_aula.add("Segunda");

                }
                case 2 -> {
                    if (dias_de_aula.contains("Terça")){
                        System.out.println("Impossível inserir valores iguais...");
                        Exibir.espera_em_ms(500);
                        continue;
                    }
                    dias_de_aula.add("Terça");

                }
                case 3 -> {
                    if (dias_de_aula.contains("Quarta")){
                        System.out.println("Impossível inserir valores iguais...");
                        Exibir.espera_em_ms(500);
                        continue;
                    }
                    dias_de_aula.add("Quarta");
                }
                case 4 -> {
                    if (dias_de_aula.contains("Quinta")){
                        System.out.println("Impossível inserir valores iguais...");
                        Exibir.espera_em_ms(500);
                        continue;
                    }
                    dias_de_aula.add("Quinta");
                }
                case 5 -> {
                    if (dias_de_aula.contains("Sexta")){
                        System.out.println("Impossível inserir valores iguais...");
                        Exibir.espera_em_ms(500);
                        continue;
                    }
                    dias_de_aula.add("Sexta");
                }
            }
            System.out.println("Dias escolhidos " + dias_de_aula);
            System.out.print("São apenas estes dias? (S/N) ");
            String resp_ = SCANNER.next().substring(0,1).toUpperCase();
            if (resp_.equals("S")) {
                return dias_de_aula;
            }
            if (dias_de_aula.size() > 5) {
                dias_de_aula.clear();
                System.out.println("Por favor adicione corretamente os dias da semana. (RECOMEÇANDO ANOTAÇÕES DOS DIAS)");
                break;
            }
        }
        return null;
    }


//    public static void listaDeAlunos(List<Aluno> lista_de_alunos) {
//        System.out.println("Lista de alunos: ");
//        for (Aluno aluno : lista_de_alunos) {
//            espera_em_ms(400);
//            System.out.println("INFORMAÇÕES ALUNO: \n");
//            System.out.println();
//            System.out.println("\tNome: " + aluno.nome);
//            System.out.println("\tCPF: " + aluno.cpf);
//            System.out.println("\tEndereço: " + aluno.endereco);
//            System.out.println("\tCelular: " + aluno.celular);
//            System.out.println("\tNúmero da Matrícula: " + aluno.matricula);
//            System.out.println();
//            espera_em_ms(1500);
//        }
//        if (lista_de_alunos.size() == 0) {
//            System.out.println("LISTA DE ALUNOS VAZIA!");
//        }
//    }


    public static void listaDeSalas(List<Sala> lista_de_salas) {
        System.out.println("Lista de salas: ");
        for (Sala sala : lista_de_salas) {
            System.out.println(sala);
            espera_em_ms(1600);
        }
    }


    public static void listaDeCursos(List<Curso> lista_de_cursos) {
        System.out.println("Lista de cursos: ");
        for (Curso curso : lista_de_cursos) {
            System.out.println(curso);
            espera_em_ms(1600);
        }
    }


    public static void listaDeTurmas(List<Turma> lista_de_turmas) {
        System.out.println("Lista de turmas: ");
        for (Turma turma : lista_de_turmas) {
            System.out.println(turma);
        }
    }


//    public static void adicionarTurmaSala(List<Turma> lista_de_turmas, Scanner SCANNER) {
//        listaDeTurmas(lista_de_turmas);
//        System.out.println("""
//                Adicionar turmas existentes = 1
//                Criar nova turma = 2
//                """);
//        int resp = SCANNER.nextInt();
//        SCANNER.nextLine();
//        if (resp == 1) {
//            System.out.println("Digite o código da turma que você quer adicionar a sala");
//        }
//        listaDeSalas(lista_de_salas);
//    }


    public static void listaDeProfessores(List<Professor> lista_de_professores) {
        System.out.println("Lista de professores: ");
        for (Professor professor : lista_de_professores) {
            System.out.println(professor);
            espera_em_ms(1600);
        }
    }


    public static void espera_em_ms(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void separador() {
        System.out.println("_______________________\n");
    }


    public static String exibicao(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg + "(S/N): ");
        String retorno = scanner.next().substring(0, 1).toUpperCase();
        return retorno;
    }
}