package application;

import model.dao.*;
import model.entities.*;
import model.tools.Cadastrar;
import model.tools.Exibir;

import java.util.*;

public class Program {
    public static final int tempoEspera = 500;

    public static void main(String[] args)
    {
        Scanner SCANNER = new Scanner(System.in);
        int resposta;
        boolean continuar = true;
        AlunoDao alunoDao = DaoFactory.criaAlunoDao();
        TurmaDao turmaDao = DaoFactory.criaTurmaDao();
        SalaDao salaDao = DaoFactory.criaSalaDao();
        AulaDao aulaDao = DaoFactory.criaAulaDao();
        ProfessorDao professorDao = DaoFactory.criaProfessorDao();
        CursoDao cursoDao = DaoFactory.criaCursoDao();


        while (continuar) {
            try {
                Exibir.menu();
                resposta = SCANNER.nextInt();
                SCANNER.nextLine();
                String resp = null;
                switch (resposta) {
                    case 0 -> {
                        System.out.println("Saindo...");
                        continuar = false;
                    }
                    case 1 -> {
                        Exibir.espera_em_ms(tempoEspera);

                        Aluno aluno = Cadastrar.aluno(SCANNER);
                        System.out.println();
                        Curso curso = null;
                        if (aluno == null){
                            break;
                        }
                        resp = Exibir.exibicao("Deseja anexar o aluno a algum curso?").substring(0,1).toUpperCase();
                        if (resp.equals("S")){
                            Curso curso_apoio = Cadastrar.curso(SCANNER);
                            cursoDao.inserirCurso(curso_apoio);
                            aluno.setCurso(curso_apoio);
                        }
                        alunoDao.inserirAluno(aluno);

                        resp = Exibir.exibicao("Mostrar listas de alunos?");
                        if (resp.equals("S")) {
                            alunoDao = DaoFactory.criaAlunoDao();
                            alunoDao.buscarTodosAlunos();
                            Exibir.espera_em_ms(1500);
                            System.out.println("\n");
                        }
                    }
                    case 2 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Cadastrar.sala(SCANNER);
                        resp = Exibir.exibicao("Mostrar lista de salas?");
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            salaDao = DaoFactory.criaSalaDao();
                            salaDao.buscarTodasSalas();
                            Exibir.espera_em_ms(1500);
                        }
                    }
                    case 3 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Curso curso = Cadastrar.curso(SCANNER);
                        cursoDao.inserirCurso(curso);
                        resp = Exibir.exibicao("Mostrar lista de cursos?");
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            cursoDao.buscarTodosCursos();
                            Exibir.espera_em_ms(1500);
                        }
                    }
                    case 4 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Turma turma = Cadastrar.turma(SCANNER);
                        turmaDao.inserirTurma(turma);
                        resp = Exibir.exibicao("Mostrar lista de salas?");
                        if (resp.equals("S")){
                            turmaDao.buscarTodasTurmas();
                        }
                    }
                    case 6 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Aula aula = Cadastrar.aula(SCANNER);
                    }
                    case 5 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Professor professor = Cadastrar.professor( SCANNER);
                        professorDao.inserirProfessor(professor);
                        resp = Exibir.exibicao("Mostrar lista de professores?");
                        if (resp.equals("S"))
                        {
                            professorDao.buscarTodosOsProfessores();
                        }
                    }
                    case 7 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        alunoDao.buscarTodosAlunos();
                    }
                    case 8 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        salaDao.buscarTodasSalas();
                    }
                    case 9 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        cursoDao.buscarTodosCursos();
                    }
                    case 10 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        turmaDao.buscarTodasTurmas();
                    }
                    case 11 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        professorDao.buscarTodosOsProfessores();
                    }
                    case 12 -> {
                        System.out.println("Adicionar aluno a curso: ");
                        System.out.println("Escolha o ID do curso que o aluno será adicionado: ");
                        cursoDao.buscarTodosCursos();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_curso = SCANNER.nextInt();
                        System.out.println("Escolha o aluno que será adicionado ao curso: ");
                        alunoDao.buscarTodosAlunos();
                        int id_aluno = SCANNER.nextInt();

                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);
                        Aluno aluno = alunoDao.buscarAlunoPorIdTransformaEmAluno(id_aluno);

                        aluno.setCurso(curso);
                        aluno.setId_Matricula(id_aluno);
                        alunoDao.atualizarAluno(aluno);
                    }
                    case 13 -> {
                        System.out.println("Adicionar turma a curso: ");
                        System.out.println("Escolha o ID do curso que a turma será alocada: ");
                        cursoDao.buscarTodosCursos();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_curso = SCANNER.nextInt();
                        System.out.println("Escolha a turma que será adicionada ao curso: ");
                        turmaDao.buscarTodasTurmas();
                        int id_turma = SCANNER.nextInt();

                        Turma turma = turmaDao.buscarTurmaPorIdTransformaEmObjTurma(id_turma);
                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);

                        turma.setCurso(curso);
                        turma.setId_Turma(id_turma);
                        turmaDao.atualizarTurma(turma);
                    }
                    case 14 -> {
                        System.out.println("Adicionar professor a curso: ");
                        System.out.println("Escolha o ID do curso que o professor sera anexado: ");
                        cursoDao.buscarTodosCursos();
                        System.out.println("ID ESCOLHIDO: ");
                        int id_curso = SCANNER.nextInt();
                        System.out.println("Escolha a professor que será anexado ao curso: ");
                        professorDao.buscarTodosOsProfessores();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_professor = SCANNER.nextInt();

                        Professor professor = professorDao.buscarProfessorPorIdTransformarEmObjProfessor(id_professor);
                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);

                        professor.setCurso(curso);
                        professor.setId_Professor(id_professor);
                        professorDao.atualizarProfessor(professor);
                    }
                    case 15 -> {
                        System.out.println("Adicionar aula a sala: ");
                        System.out.print("Escolha da sala que a aula será anexada: ");
                        salaDao.buscarTodasSalas();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_sala = SCANNER.nextInt();
                        System.out.println("Escolha a aula que será anexada a sala");
                        aulaDao.buscarTodosAulas();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_aula = SCANNER.nextInt();

                        Sala sala = salaDao.buscarSalaPorIdTransformarEmOBjSala(id_sala);
                        Aula aula = aulaDao.buscarAulaPorIdTransformarEmObjAula(id_aula);

                        aula.setSala(sala);
                        aula.setIdAula(id_aula);
                        aulaDao.atualizarAula(aula);
                    }
                    case 16 -> {
                        System.out.println("Adicionar turma a sala: ");
                        System.out.println("Escolha a turma que será adicionada a sala: ");
                        turmaDao.buscarTodasTurmas();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_turma = SCANNER.nextInt();
                        System.out.println("Escolha a sala que será anexada a turma: ");
                        turmaDao.buscarTodasTurmas();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_aula = SCANNER.nextInt();

                        Turma turma = turmaDao.buscarTurmaPorIdTransformaEmObjTurma(id_turma);
                        Aula aula = aulaDao.buscarAulaPorIdTransformarEmObjAula(id_aula);
                        System.out.println(turma);
                        System.out.println(aula);
                        aula.setTurma(turma);
                        aula.setIdAula(id_aula);
                        aulaDao.atualizarAula(aula);
                    }
                    case 17 -> {
                        Sala sala = DaoFactory.criaSalaDao().buscarSalaPorIdTransformarEmOBjSala(10);
                        System.out.println(sala);
                    }
                    case 18 -> {
                        Set<String> diaSemana = new HashSet<>();
                        diaSemana.add("Segunda");
                        diaSemana.add("Terça");
                        diaSemana.add("Quarta");
                        System.out.println(diaSemana);
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