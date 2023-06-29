package application;

import db.DB;
import model.dao.*;
import model.entities.*;
//import model.tools.Cadastrar;
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
                        DB.fechaConexao();
                    }
                    case 1 -> {
                        Exibir.espera_em_ms(tempoEspera);

                        Aluno aluno = Cadastrar.aluno();
                        System.out.println();
                        Curso curso = null;
                        if (aluno == null){
                            break;
                        }
                        resp = Exibir.exibicao("Deseja anexar o aluno a algum curso?").substring(0,1).toUpperCase();
                        if (resp.equals("S")){
                            Curso curso_apoio = Cadastrar.curso();
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
                        Sala sala = Cadastrar.sala();
                        if (sala == null){
                            break;
                        }
                        salaDao.inserirSala(sala);
                        resp = Exibir.exibicao("Mostrar lista de salas?");
                        salaDao = DaoFactory.criaSalaDao();
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            salaDao.buscarTodasSalas();
                            Exibir.espera_em_ms(1500);
                        }
                    }

                    case 3 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Curso curso = Cadastrar.curso();
                        if (curso == null) {
                            break;
                        }
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
                        Turma turma = Cadastrar.turma();
                        if (turma == null) {
                            break;
                        }
                        turmaDao.inserirTurma(turma);
                        resp = Exibir.exibicao("Mostrar lista de turmas?");
                        if (resp.equals("S")){
                            turmaDao.buscarTodasTurmas();
                        }
                    }

                    case 5 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Professor professor = Cadastrar.professor();
                        if (professor == null) {
                            break;
                        }
                        professorDao.inserirProfessor(professor);
                        resp = Exibir.exibicao("Mostrar lista de professores?");
                        if (resp.equals("S"))
                        {
                            professorDao.buscarTodosOsProfessores();
                        }
                    }

                    case 6 -> {
                        Exibir.espera_em_ms(tempoEspera);
                        Aula aula = Cadastrar.aula(SCANNER);
                        if (aula == null){
                            break;
                        }
                        DaoFactory.criaAulaDao().inserirAula(aula);
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
                        int id_aluno = -1;
                        int cont = 0;
                        int res = 0;

                        while (alunoDao.buscarAlunoPorIdTransformaEmAluno(id_aluno) == null){
                            if (cont == 0){
                                System.out.println("Escolha o aluno para ser adicionado a algum curso: ");
                            }
                            if (cont > 0){
                                System.out.println("""
                                        ID do aluno não encontrado, por favor digite um ID que conste no banco de dados...
                                        
                                        0 = Cancelar operação e voltar ao menu
                                        1 = Continuar
                                        1..Infinito = Continuar
                                        """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            System.out.println("_______________________________");
                            alunoDao.buscarTodosAlunos();
                            System.out.print("ID ESCOLHIDO: ");
                            id_aluno = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        int id_curso = -1;
                        cont = 0;
                        res = 0;
                        while (cursoDao.buscarCursoPorIdTransformarEmObj(id_curso) == null){
                            if (cont == 0){
                                System.out.println("Escolha o ID do curso que o aluno será adicionado:");
                            }
                            if (cont > 0){
                                System.out.println("""
                                    ID do curso não encontrado, por favor digite um ID que conste no banco de dados...
                                    
                                    0 = Cancelar operação e voltar ao menu
                                    1 = Continuar
                                    1..Infinito = Continuar
                                    """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            cursoDao.buscarTodosCursos();
                            System.out.println("______________________________");
                            System.out.print("ID ESCOLHIDO: ");
                            id_curso = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);
                        Aluno aluno = alunoDao.buscarAlunoPorIdTransformaEmAluno(id_aluno);

                        if (aluno.getCurso() == null){
                            aluno.setCurso(curso);
                            aluno.setId_Matricula(id_aluno);
                            alunoDao.atualizarAluno(aluno);
                        }
                        else {
                            while (true){
                                System.out.println("Tem certeza que deseja trocar o aluno de curso? (S/N) ");
                                System.out.print("Resposta: ");
                                String resp_ = SCANNER.next().substring(0,1).toUpperCase();
                                if (resp_.equals("N")){
                                    break;
                                }
                                if (resp_.equals("S")){
                                    aluno.setCurso(curso);
                                    aluno.setId_Matricula(id_aluno);
                                    alunoDao.atualizarAluno(aluno);
                                    break;
                                }
                                else {
                                    System.out.println("Por favor digite uma resposta válida...");
                                }
                            }
                        }
                    }
                    case 13 -> {
                        System.out.println("Adicionar turma a curso: ");

                        int id_turma = -1;
                        int cont = 0;
                        int res = 0;

                        while (turmaDao.buscarTurmaPorIdTransformaEmObjTurma(id_turma) == null) {
                            if (cont == 0){
                                System.out.println("Escolha a turma que será adicionada ao curso: ");
                            }
                            if (cont > 0){
                                System.out.println("""
                                        ID da turma não encontrado, por favor digite um ID que conste no banco de dados...
                                        
                                        0 = Cancelar operação e voltar ao menu
                                        1 = Continuar
                                        1..Infinito = Continuar
                                        """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            turmaDao.buscarTodasTurmas();
                            System.out.print("ID ESCOLHIDO: ");
                            id_turma = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        int id_curso = -1;
                        cont = 0;
                        res = 0;
                        while (cursoDao.buscarCursoPorIdTransformarEmObj(id_curso) == null) {
                            if (cont == 0){
                                System.out.println("Escolha o ID do curso que a turma será alocada: ");
                            }
                            if (cont > 0){
                                System.out.println("""
                                        ID do curso não encontrado, por favor digite um ID que conste no banco de dados...
                                        
                                        0 = Cancelar operação e voltar ao menu
                                        1 = Continuar
                                        1..Infinito = Continuar
                                        """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            cursoDao.buscarTodosCursos();
                            System.out.println("______________________________");
                            System.out.print("ID ESCOLHIDO: ");
                            id_curso = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        Turma turma = turmaDao.buscarTurmaPorIdTransformaEmObjTurma(id_turma);
                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);

                        if (turma.getCurso() == null){
                            turma.setCurso(curso);
                            turma.setId_Turma(id_turma);
                            turmaDao.atualizarTurma(turma);
                        }

                        else {
                            while (true){
                                System.out.println("Tem certeza que deseja trocar a turma de curso? (S/N) ");
                                System.out.print("Resposta: ");
                                String resp_ = SCANNER.next().substring(0,1).toUpperCase();
                                if (resp_.equals("N")){
                                    break;
                                }
                                if (resp_.equals("S")){
                                    turma.setCurso(curso);
                                    turma.setId_Turma(id_turma);
                                    turmaDao.atualizarTurma(turma);
                                    break;
                                }
                                else {
                                    System.out.println("Por favor digite uma resposta válida...");
                                }
                            }
                        }

                    }
                    case 14 -> {
                        int id_professor = -1;
                        int cont = 0;
                        int res = 0;

                        System.out.println("Adicionar professor a curso: ");

                        while (professorDao.buscarProfessorPorIdTransformarEmObjProfessor(id_professor) == null) {
                            if (cont == 0){
                                System.out.println("Escolha o professor que será anexado ao curso: ");
                            }
                            if (cont > 0){
                                System.out.println("""
                                        ID do professor não encontrado, por favor digite um ID que conste no banco de dados...
                                        
                                        0 = Cancelar operação e voltar ao menu
                                        1 = Continuar
                                        1..Infinito = Continuar
                                        """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            professorDao.buscarTodosOsProfessores();
                            System.out.print("ID ESCOLHIDO: ");
                            id_professor = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        cont = 0;
                        res = 0;
                        int id_curso = -1;

                        while (cursoDao.buscarCursoPorIdTransformarEmObj(id_curso) == null) {
                            if (cont == 0){
                                System.out.println("Escolha o curso que será anexado ao professor: ");
                            }
                            if (cont > 0){
                                System.out.println("""
                                        ID do curso não encontrado, por favor digite um ID que conste no banco de dados...
                                        
                                        0 = Cancelar operação e voltar ao menu
                                        1 = Continuar
                                        1..Infinito = Continuar
                                        """);
                                System.out.print(": ");
                                res = SCANNER.nextInt();
                                if (res == 0){
                                    System.out.println("Cancelando operação...");
                                    break;
                                }
                            }
                            cursoDao.buscarTodosCursos();
                            System.out.print("ID ESCOLHIDO: ");
                            id_curso = SCANNER.nextInt();
                            cont += 1;
                            res = 1;
                        }
                        if (res == 0){
                            continue;
                        }

                        Professor professor = professorDao.buscarProfessorPorIdTransformarEmObjProfessor(id_professor);
                        Curso curso = cursoDao.buscarCursoPorIdTransformarEmObj(id_curso);

                        if (professor.getCurso() == null){
                            professor.setCurso(curso);
                            professor.setId_Professor(id_professor);
                            professorDao.atualizarProfessor(professor);
                        }
                        else {
                            while (true){
                                System.out.println("Tem certeza que deseja trocar o curso que o professor lesiona? (S/N) ");
                                System.out.print("Resposta: ");
                                String resp_ = SCANNER.next().substring(0,1).toUpperCase();
                                if (resp_.equals("N")){
                                    break;
                                }
                                if (resp_.equals("S")){
                                    professor.setCurso(curso);
                                    professor.setId_Professor(id_professor);
                                    professorDao.atualizarProfessor(professor);
                                    break;
                                }
                                else {
                                    System.out.println("Por favor digite uma resposta válida...");
                                }
                            }
                        }
                    }
                    case 15 -> {
                        System.out.println("Adicionar aula a sala: ");
                        System.out.print("Escolha da sala que a aula será anexada: ");
                        salaDao.buscarTodasSalas();
                        System.out.print("ID ESCOLHIDO: ");
                        int id_sala = SCANNER.nextInt();
                        System.out.println("Escolha a aula que será anexada a sala");
                        aulaDao.buscarTodasAulas();
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