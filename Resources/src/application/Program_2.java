package application;

import entities.*;

import java.util.*;

public class Program_2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Aluno> lista_de_alunos = new ArrayList<>();
        List<Sala> lista_de_salas = new ArrayList<>();
        List<Curso> lista_de_cursos = new ArrayList<>();
        List<Professor> lista_de_professores = new ArrayList<>();

        int resposta = 1;
        boolean continuar = true;

        while (continuar) {
            try {
                exibirMenu();
                resposta = entrada.nextInt();
                String resp = "";
                switch (resposta) {
                    case 0:
                        System.out.println("Saindo...");
                        continuar = false;
                        break;

                    case 1:
                        cadastrarAluno(lista_de_alunos, entrada);
                        resp = exibicao("Mostrar listas de alunos?", entrada);
                        if (resp.equals("S")){exibirListaAlunos(lista_de_alunos);}
                        break;

                    case 2:
                        cadastrarSala(lista_de_salas, entrada);
                        resp = exibicao("Mostrar lista de salas?", entrada);
                        if (resp.equals("A")){exibirListaSalas(lista_de_salas);}
                        break;

                    case 3:
                        cadastrarCurso(lista_de_cursos, entrada);
                        resp = exibicao("Mostrar lista de cursos?", entrada);
                        if (resp.equals("S")){exibirListaCursos(lista_de_cursos);}
                        break;

                    case 4:
                        cadastrarTurma(lista_de_salas, lista_de_cursos, entrada);
                        resp = exibicao("Mostrar lista de salas?", entrada);
//                    if (resp.equals("S")){}
                        break;

                    case 5:
                        cadastrarProfessor(entrada, lista_de_professores);
                        resp = exibicao("Mostrar lista de professores?", entrada);
                        if (resp.equals("S")){
                            exibirListaProfessores(lista_de_professores);}
                        break;

                    case 6:
                        exibirListaAlunos(lista_de_alunos);
                        break;

                    case 7:
                        exibirListaSalas(lista_de_salas);
                        break;

                    case 8:
                        exibirListaCursos(lista_de_cursos);
                        break;

                    case 9:
                        continue;

                    case 10:
                        exibirListaProfessores(lista_de_professores);
                        break;

                    default:
                        System.out.println("Por favor, envie um valor válido...");
                        break;
            }
            }
            catch (InputMismatchException e){
                System.out.println("Erro: Entrada válida. Certifique-se de inserir o tipo correto para cada dado!!!");
                entrada.nextLine();
            }

            catch (NoSuchElementException e){
                System.out.println("Erro: Entrada não encontrada. Certifique-se de inserir todas as informações necessárias!!!");
                entrada.nextLine();
            }

            catch (Exception e){
                System.out.println("Ocorreu um erro inesperado. Por favor tente mais tarde");
                e.printStackTrace();
                continuar = false;
            }


        }
    }

    public static void exibirMenu() {
        System.out.println("_______________________\n");
        System.out.println("""
            DIGITE UM NÚMERO PARA:
            
             0 = SAIR
             1 = CADASTRAR ALUNO
             2 = CADASTRAR SALA
             3 = CADASTRAR CURSO
             4 = CADASTRAR TURMA
             5 = CADASTRAR PROFESSOR
             6 = MOSTRAR ALUNOS
             7 = MOSTRAR SALAS
             8 = MOSTRAR CURSOS
             9 = MOSTRAR TURMAS
             10 = MOSTRAR PROFESSORES
            """);
        System.out.print("Resposta: ");
    }

    public static String exibicao(String msg, Scanner entrada) {
        System.out.print(msg + "(S/N): ");
        return entrada.next().substring(0, 1).toUpperCase();
    }

    public static void cadastrarAluno(List<Aluno> lista_de_alunos, Scanner entrada) {
        System.out.println("Cadastrar novo aluno");
        System.out.println("Por favor envie os dados do aluno para ser cadastrado...");

        List<String> dados = cadastrarPessoa(entrada);
        String cpf = dados.get(0);
        String nome = dados.get(1);
        String endereco = dados.get(2);
        String email = dados.get(3);
        String celular = dados.get(4);

        System.out.print("Digite o número da matricula: ");
        int numero_matricula = entrada.nextInt();

        Aluno aluno = new Aluno(cpf, nome, endereco, email, celular, numero_matricula);
        lista_de_alunos.add(aluno);
    }

    public static void exibirListaAlunos(List<Aluno> lista_de_alunos) {
        System.out.println("Lista de alunos: ");
        for (Aluno aluno : lista_de_alunos) {
            System.out.println(aluno);
        }
    }

    public static void cadastrarSala(List<Sala> lista_de_salas, Scanner entrada) {
        System.out.println("Cadastrar nova sala");
        System.out.print("Digite o nome da sala: ");
        String nome_sala = entrada.next();

        System.out.print("Digite o local: ");
        String local_sala = entrada.next();

        System.out.print("Digite a capacidade total da sala: ");
        int capacidadeTotalDaSala = entrada.nextInt();

        Sala novaSala = new Sala(nome_sala, local_sala, capacidadeTotalDaSala);
        lista_de_salas.add(novaSala);
    }

    public static void exibirListaSalas(List<Sala> lista_de_salas) {
        System.out.println("Lista de salas: ");
        for (Sala sala : lista_de_salas) {
            System.out.println(sala);
        }
    }

    public static void cadastrarCurso(List<Curso> lista_de_cursos, Scanner entrada) {
        System.out.println("Cadastrar novo curso");

        System.out.print("Digite o código do curso: ");
        int codigo_curso = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o nome do curso: ");
        String nome_curso = entrada.nextLine();

        System.out.print("Digite a carga horária do curso: ");
        int carga_horaria = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite uma descrição para o curso: ");
        String descricao = entrada.nextLine();

        Curso curso = new Curso(codigo_curso, nome_curso, carga_horaria, descricao);
        lista_de_cursos.add(curso);
    }

    public static void exibirListaCursos(List<Curso> lista_de_cursos) {
        System.out.println("Lista de cursos: ");
        for (Curso curso : lista_de_cursos) {
            System.out.println(curso);
        }
    }

    public static void cadastrarTurma(List<Sala> lista_de_salas, List<Curso> lista_de_cursos, Scanner entrada) {
        System.out.println("Cadastrar nova turma");

        System.out.print("Digite o dia da semana que terá aula nessa turma: ");
        System.out.println("""
                1 = Segunda
                2 = Terça
                3 = Quarta
                4 = Quinta
                5 = Sexta
                            
                (Se já estiver alocada uma turma na sala no dia enviado, será desconsiderado)
                """);
        int opcaoDiaSemana = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Salas existentes: ");
        exibirListaSalas(lista_de_salas);
        System.out.print("Defina em qual sala será lecionada: ");
        int opcaoSala = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Cursos existentes: ");
        exibirListaCursos(lista_de_cursos);
        System.out.print("Defina qual curso será ministrado: ");
        int opcaoCurso = entrada.nextInt();
        entrada.nextLine();

        Sala sala = lista_de_salas.get(opcaoSala - 1);
        Curso curso = lista_de_cursos.get(opcaoCurso - 1);
        DiaSemana diaSemana = DiaSemana.values()[opcaoDiaSemana - 1];

    }

    public static void cadastrarProfessor(Scanner entrada, List<Professor> lista_de_professores) {
        System.out.println("Cadastrar novo professor");

        List<String> dados = cadastrarPessoa(entrada);
        String cpf = dados.get(0);
        String nome = dados.get(1);
        String endereco = dados.get(2);
        String email = dados.get(3);
        String celular = dados.get(4);
        int codigo_funcionario = entrada.nextInt();

        Professor professor = new Professor(
                cpf,
                nome,
                endereco,
                email,
                celular,
                codigo_funcionario
        );
        lista_de_professores.add(professor);
    }

    public static void exibirListaProfessores(List<Professor> lista_de_professores){
        for (Professor professor : lista_de_professores){
            System.out.println(professor);
        }
    }

    public static List<String> cadastrarPessoa(Scanner entrada) {
        System.out.print("Nome: ");
        String nome = entrada.next();

        System.out.print("CPF: ");
        String _CPF = entrada.next();

        System.out.print("Endereço: ");
        String endereco = entrada.next();

        System.out.print("Email: ");
        String email = entrada.next();

        System.out.print("Celular: ");
        String celular = entrada.next();

        List<String> dados = Arrays.asList(_CPF, nome, endereco, email, celular);

        return dados;
    }
}