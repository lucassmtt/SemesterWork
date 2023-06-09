package model.tools;

import model.auth.Valida;
import model.dao.*;
import model.entities.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe utilizada para cadastrar objetos...
 */
public class Cadastrar {
    static Scanner SCANNER = new Scanner(System.in);

    /**
     * <p>
     * Monta as informações que precisamos para cadastrar o Aluno ou o Professor.
     * </p>
     *
     * @return A lista de Strings com as informações de pessoas.
     * @since 1.0
     */
    public static List<String> info_pessoas() {
        List<String> lista_com_conteudo_ou_vazia = new ArrayList<>();
        try {
            while (true) {
                String cpf_validado = Valida.cpf();
                if (cpf_validado.length() == 0) {
                    return lista_com_conteudo_ou_vazia;
                }

                String nome = Valida.nome();
                if (nome.length() == 0) {
                    return lista_com_conteudo_ou_vazia;
                }

                String endereco = Valida.endereco();
                if (endereco.length() == 0) {
                    return lista_com_conteudo_ou_vazia;
                }

                String email = Valida.email();
                if (email.length() == 0) {
                    return lista_com_conteudo_ou_vazia;
                }

                String celular = Valida.celular();
                if (celular.length() == 0) {
                    return lista_com_conteudo_ou_vazia;
                }
                lista_com_conteudo_ou_vazia.addAll(List.of(cpf_validado, nome, endereco, email, celular));
                return lista_com_conteudo_ou_vazia;
            }
        } catch (Exception e) {
            System.out.println("Saindo...");
        }
        return lista_com_conteudo_ou_vazia;
    }

    /**
     * <p>
     * Pega as informações do info_pessoas, adiciona um número de matrícula
     * e cria um objeto Aluno caso o usuário confirme a operação.
     * </p>
     *
     * @return Sem retorno.
     * @since 1.0
     */
    public static Aluno aluno()
    {
        Exibir.separador();
        System.out.println("-Cadastrar novo aluno-");

        List<String> dados = info_pessoas();
        if (dados.size() == 0) {
            System.out.println("Operação cancelada.");
            SCANNER.close();
            return null;
        } else {
            Exibir.separador();
            System.out.println("CPF: " + dados.get(0));
            System.out.println("Nome: " + dados.get(1));
            System.out.println("Endereço: " + dados.get(2));
            System.out.println("Email: " + dados.get(3));
            System.out.println("Celular: " + dados.get(4));
            System.out.println("CONFIRMAR DADOS? (S/N) ");
            String resp = SCANNER.next().substring(0, 1).toUpperCase();
            if (resp.equals("S")) {
                SCANNER.close();
                return new Aluno(
                        dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4)
                );
            } else {
                SCANNER.close();
                System.out.println("Operação cancelada...");
                return null;
            }
        }
    }

    /**
     * <p>
     * Cria um objeto sala caso o usuário confirme a operação.
     * </p>
     *
     * @return Sem retorno.
     * @since 1.0
     */
    public static Sala sala()
    {
        Exibir.separador();
        System.out.println("-Cadastrar nova sala-");
        System.out.print("Digite o nome da sala: ");
        String nome_sala = SCANNER.nextLine();
//        SCANNER.nextLine();

        System.out.print("Digite o local: ");
        String local_sala = SCANNER.nextLine();

        System.out.print("Digite a capacidade total da sala: ");
        int capacidadeTotalDaSala = SCANNER.nextInt();

        Exibir.separador();
        System.out.println("Nome: " + nome_sala);
        System.out.println("Local: " + local_sala);
        System.out.println("Capacidade: " + capacidadeTotalDaSala);

        System.out.println("Informações correta? (S/N) ");
        System.out.print("Resposta: ");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")) {
            SCANNER.close();
            return new Sala(nome_sala, local_sala, capacidadeTotalDaSala);
        } else {
            System.out.println("Operação cancelada...");
        }
        SCANNER.close();
        return null;
    }

    /**
     * <p>
     * Cria um objeto curso caso o usuário confirme a operação.
     * </p>
     *
     * @return Sem retorno.
     * @since 1.0
     */
    public static Curso curso()
    {
        Exibir.separador();
        System.out.println("-Cadastrar novo curso-");

        System.out.print("Digite o nome do curso: ");
        SCANNER.next();
        String nome_curso = SCANNER.nextLine();

        System.out.print("Digite a carga horária do curso: ");
        int carga_horaria = SCANNER.nextInt();

        System.out.print("Digite uma descrição para o curso: ");
        SCANNER.next();
        String descricao = SCANNER.nextLine();
        Exibir.separador();
        System.out.println("Nome do curso: " + nome_curso);
        System.out.println("Carga horária do curso: " + carga_horaria);
        System.out.println("Descrição do curso: " + descricao);
        System.out.println("Informações corretas? (S/N)");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")) {
            Curso curso = new Curso();
            curso.setNomeCurso(nome_curso);
            curso.setDescricao(descricao);
            curso.setCargaHoraria(carga_horaria);
            SCANNER.close();
            return curso;
        } else {
            System.out.println("Operação cancelada...");
        }
        SCANNER.close();
        return null;
    }

    /**
     * <p>
     * Cria um objeto turma caso o usuário confirme a operação.
     * </p>
     *
     * @return a lista de Strings com as informações de pessoas
     * @since 1.0
     */
    public static Turma turma()
    {
        System.out.println("-Cadastrar nova turma-");
        while (true) try {
            System.out.print("Digite o nome da turma: ");
            String nome_turma = SCANNER.nextLine();
            Turma turma = new Turma();
            turma.setNomeTurma(nome_turma);

            Sala sala = null;
            Curso curso = null;

            System.out.print("\nAdicionar uma sala? (S/N) ");
            String resposta = SCANNER.next().substring(0, 1).toUpperCase();
            if (resposta.equals("S")) {
                int resp = -1;
                boolean continar = true;
                while (continar){
                    System.out.println("Sair = 0\n" +
                            "Criar sala = 1\n" +
                            "Adicionar em salas existentes = 2"  );
                    System.out.print(": ");
                    resp = SCANNER.nextInt();
                    SCANNER.nextLine();
                    switch (resp)
                    {
                        case 0:
                            break;

                        case 1:
                            sala = sala();
                            DaoFactory.criaSalaDao().inserirSala(sala);
                            continar = false;
                            break;

                        case 2:
                            System.out.println("--Escolha um ID da sala--");
                            DaoFactory.criaSalaDao().buscarTodasSalas();
                            System.out.println("______________________________________");
                            System.out.print("ID ESCOLHIDO: ");
                            int id = SCANNER.nextInt();
                            Sala sala_ = DaoFactory.criaSalaDao().buscarSalaPorIdTransformarEmOBjSala(id);
                            if (sala_ != null){
                                continar = false;
                                break;
                            }
                            else {
                                System.out.println("Sala inexistente, por favor, tente novamente...");
                            }
                    }
                }
            }

            System.out.print("\nAdicionar um curso? (S/N) ");
            resposta = SCANNER.next().substring(0, 1).toUpperCase();
            if (resposta.equals("S")) {
                int resp = 0;
                boolean continuar = true;
                while (continuar) {
                    System.out.println("0 = Sair\n" +
                            "1 = Criar curso\n" +
                            "2 = Adicionar a um curso existente");
                    System.out.print(": ");
                    resp = SCANNER.nextInt();
                    switch (resp)
                    {
                        case 0:
                            continuar = false;
                            break;

                        case 1:
                            curso = curso();
                            DaoFactory.criaCursoDao().inserirCurso(curso);
                            turma.setCurso(curso);
                            continuar = false;
                            break;

                        case 2:
                            System.out.println("--Escolha um ID de curso--");
                            DaoFactory.criaCursoDao().buscarTodosCursos();
                            System.out.println("______________________________________");
                            System.out.print("ID ESCOLHIDO: ");
                            int id = SCANNER.nextInt();
                            curso = DaoFactory.criaCursoDao().buscarCursoPorIdTransformarEmObj(id);
                            if (curso != null){
                                turma.setCurso(curso);
                                continuar = false;
                                break;
                            }
                            else {
                                System.out.println("Curso inexistente, por favor, tente novamente...");
                            }
                    }
                }
                SCANNER.close();
            }
            SCANNER.close();
            return turma;
        } catch (InputMismatchException e) {
            System.out.println("Digite corretamente os dados!");
            SCANNER.close();
            return null;
        }

    }

    /**
     * <p>
     * Pega as informações de info_pessoas adiciona o código do funcionário e cria um
     * objeto Professor caso o usuário confirme a operação.
     * </p>
     *
     * @return Sem retorno.
     * @since 1.0
     */
    public static Professor professor() {
        Exibir.separador();
        System.out.println("-Cadastrar novo professor-");

        List<String> dados = info_pessoas();
        if (dados.size() == 0) {
            System.out.println("Operação cancelada...");
            return null;
        }

        return new Professor(
                dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4)
        );
    }
}