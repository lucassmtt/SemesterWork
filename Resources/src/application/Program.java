package application;

import entities.*;

import java.util.*;

public class Program {
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        List<Aluno> lista_de_alunos = new ArrayList<>();
        List<Sala> lista_de_salas = new ArrayList<>();
        List<Curso> lista_de_cursos = new ArrayList<>();
        List<Curso> lista_de_turmas = new ArrayList<>();
        List<Professor> lista_de_professores = new ArrayList<>();
        int resposta = 1;

        while (resposta != 0){
            System.out.println("_______________________");
            System.out.println("""
                DIGITE UM NÚMERO PARA:
                
                0 = SAIR
                1 = CADASTRAR ALUNO
                2 = CADASTRAR SALA
                3 = CADASTRAR CURSO
                4 = CADASTRAR TURMA
                5 = CADASTRAR PROFESSOR""");
            System.out.print("Resposta: ");
            resposta = entrada.nextInt();

            switch (resposta)
            {
                case 0:
                    System.out.println("Saindo...");
                    break;

                case 1:
                    System.out.println("Cadastrar novo aluno");
                    System.out.println("Por favor envie os dados do aluno para ser cadastrado...");

                    List<String> dados = cadastrarPessoa();
                    String cpf = dados.get(0);
                    String nome = dados.get(1);
                    String endereco = dados.get(2);
                    String email = dados.get(3);
                    String celular = dados.get(4);

                    System.out.print("Digite o número da matricula: ");
                    int numero_matricula = entrada.nextInt();

                    Aluno aluno = new Aluno(cpf, nome, endereco, email, celular, numero_matricula);
                    lista_de_alunos.add(aluno);

                    System.out.println("Lista de alunos: ");
                    for (Aluno aluno_ : lista_de_alunos){
                        System.out.println(aluno_);
                    }
                    break;

                case 2:
                    System.out.println("Cadastrar nova sala");
                    System.out.print("Digite o nome da sala: ");
                    String nome_sala = entrada.next();

                    System.out.print("Digite o local: ");
                    String local_sala = entrada.next();

                    System.out.print("Digite a capacidade total da sala: ");
                    int capacidadeTotalDaSala = entrada.nextInt();

                    Sala novaSala = new Sala(nome_sala, local_sala, capacidadeTotalDaSala);

                    lista_de_salas.add(novaSala);
                    System.out.println("Lista de salas: ");

                    for (Sala sala_ : lista_de_salas){
                        System.out.println(sala_);
                    }
                    break;

                case 3:
                    System.out.println("Cadastrar novo curso");

                    System.out.print("Digite o código do curso: ");
                    int codigo_curso = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("DIgite o nome do curso: ");
                    String nome_curso = entrada.nextLine();

                    System.out.print("Digite a carga horária do curso: ");
                    int carga_horaria = entrada.nextInt();

                    System.out.print("Digite uma descrição para o curso: ");
                    String descricao = entrada.nextLine();

                    Curso curso = new Curso(codigo_curso, nome_curso, carga_horaria, descricao);
                    lista_de_cursos.add(curso);

                    System.out.println("Lista de cursos: ");
                    for (Curso curso_ : lista_de_cursos){
                        System.out.println(curso_);
                    }
                    break;

                case 4:
                    System.out.println("Cadastrar nova turma");
                    System.out.print("Digite o dia da semana que terá aula nessa turma: ");
                    System.out.println("""
                            1 = Segunda
                            2 = Terça
                            3 = Quarta
                            4 = Quinta
                            5 = Sexta
                            
                            (Se já estiver alocada uma turma na sala no dia enviado, será desconsiderado)
                            :
                            """);
                    int opcaoDiaSemana = entrada.nextInt();
                    DiaSemana diaSemana = DiaSemana.valueOf()[opcaoDiaSemana - 1];
                    System.out.println(diaSemana);

                    System.out.print("Defina em qual sala será lecionada: ");
                    System.out.println("Salas existentes: ");
                    for (Sala sala : lista_de_salas){
                        System.out.println(sala);
                    }


                    break;

                case 5:
                    System.out.println("Cadastrar novo professor");
                    List<String> dados_professor = cadastrarPessoa();
                    String cpf_professor = dados_professor.get(0);
                    String nome_professor = dados_professor.get(1);
                    String endereco_professor = dados_professor.get(2);
                    String email_professor = dados_professor.get(3);
                    String celular_professor = dados_professor.get(4);
                    System.out.print("Digite o código do funcionário: ");
                    int codigo_funcionario = entrada.nextInt();

                    Professor professor = new Professor(
                            cpf_professor,
                            nome_professor,
                            endereco_professor,
                            email_professor,
                            celular_professor,
                            codigo_funcionario
                    );
                    lista_de_professores.add(professor);

                    System.out.println("Lista de professores: ");
                    for (Professor professor_ : lista_de_professores){
                        System.out.println(professor_);
                    }
                    break;

                default:
                    System.out.println("Por favor, envie um valor válido...");
                    break;
            }
        }
    }

    public static List<String> cadastrarPessoa()
    {
        Scanner entrada = new Scanner(System.in);
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

        return Arrays.asList(_CPF, nome, endereco, email, celular);
    }
}
