package application;

import model.entities.*;
import model.ferramentas.Cadastrar;
import model.ferramentas.Exibir;

import java.util.*;

public class Program_2
{
    public static final Scanner SCANNER;
    public static final int tempoEspera = 500;

    static { SCANNER = new Scanner(System.in); }

    public static List<Aluno> lista_de_alunos;
    public static List<Sala> lista_de_salas;
    public static List<Curso> lista_de_cursos;
    public static List<Turma> lista_de_turmas;
    public static List<Professor> lista_de_professores;

    static { lista_de_alunos = new ArrayList<>(); }

    static { lista_de_salas = new ArrayList<>(); }

    static { lista_de_cursos = new ArrayList<>(); }

    static { lista_de_turmas = new ArrayList<>(); }

    static { lista_de_professores = new ArrayList<>(); }


    public static void main(String[] args)
    {
        int resposta;
        boolean continuar = true;

        while (continuar)
        {
            try
            {
                Exibir.menu();
                resposta = SCANNER.nextInt();
                SCANNER.nextLine();
                String resp;
                switch (resposta) {
                    case 0 -> {
                        System.out.println("Saindo...");
                        continuar = false;
                    }
                    case 1 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.aluno(lista_de_alunos, SCANNER);
                        resp = Exibir.exibicao("Mostrar listas de alunos?", SCANNER);
                        if (resp.equals("S")) {
                            Exibir.listaDeAlunos(lista_de_alunos);
                            Exibir.espera_em_ms(1500);
                            System.out.println("\n");
                        }
                        resp = Exibir.exibicao("Adicionar aluno a alguma sala?", SCANNER);
                        if (resp.equals("S")){

                        }
                    }
                    case 2 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.sala(lista_de_salas, SCANNER);
                        resp = Exibir.exibicao("Mostrar lista de salas?", SCANNER);
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            Exibir.listaDeSalas(lista_de_salas);
                            Exibir.espera_em_ms(1500);
                        }
                    }
                    case 3 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.curso(lista_de_cursos, SCANNER);
                        resp = Exibir.exibicao("Mostrar lista de cursos?", SCANNER);
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            Exibir.listaDeCursos(lista_de_cursos);
                            Exibir.espera_em_ms(1500);
                        }
                    }
                    case 4 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.turma(lista_de_salas, lista_de_cursos, lista_de_turmas, SCANNER);
                        resp = Exibir.exibicao("Mostrar lista de salas?", SCANNER);
                        System.out.println("\n");
                        System.out.println(resp);
                    }
//                    if (resp.equals("S")){}
                    case 5 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.professor(lista_de_professores, SCANNER);
                        resp = Exibir.exibicao("Mostrar lista de professores?", SCANNER);
                        if (resp.equals("S")) {
                            Exibir.listaDeProfessores(lista_de_professores);
                        }
                    }
                    case 6 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Exibir.listaDeAlunos(lista_de_alunos);
                    }
                    case 7 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Exibir.listaDeSalas(lista_de_salas);
                    }
                    case 8 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Exibir.listaDeCursos(lista_de_cursos);
                    }
                    case 9 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Exibir.listaDeTurmas(lista_de_turmas);
                    }
                    case 10 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Exibir.listaDeProfessores(lista_de_professores);
                    }
                    case 11 -> {
                        break;
                    }
                    case 12 -> {
//                        adicionarTurmaSala();
                    }
                    case 13 ->{

                    }
                    default -> System.out.println("Por favor, envie um valor válido...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de inserir o tipo correto para cada dado!!!");
                Exibir.espera_em_ms(1000);
                SCANNER.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Erro: Entrada não encontrada. Certifique-se de inserir todas as informações necessárias!!!");
                SCANNER.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado. Por favor tente mais tarde");
                e.printStackTrace();
                continuar = false;
            }
        }
        SCANNER.close();
    }
}