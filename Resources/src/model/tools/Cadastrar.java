package model.tools;

import application.Program;
import model.auth.Valida;
import model.dao.*;
import model.dao.impl.AulaDaoJDBC;
import model.entities.*;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe utilizada para cadastrar objetos...
 */
public class Cadastrar {
    /**
     * <p>
     * Monta as informações que precisamos para cadastrar o Aluno ou o Professor.
     * </p>
     *
     * @param SCANNER O Scanner usado para ler as informações.
     * @return A lista de Strings com as informações de pessoas.
     * @since 1.0
     */
    public static List<String> info_pessoas(Scanner SCANNER) {
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
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static Aluno aluno(Scanner SCANNER) {
        Exibir.separador();
        System.out.println("-Cadastrar novo aluno-");

        List<String> dados = info_pessoas(SCANNER);
        if (dados.size() == 0) {
            System.out.println("Operação cancelada.");
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
                Aluno aluno = new Aluno(
                        dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4)
                );
                return aluno;
            } else {
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
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static Sala sala(Scanner SCANNER) {
        Exibir.separador();
        System.out.println("-Cadastrar nova sala-");
        System.out.print("Digite o nome da sala: ");
        String nome_sala = SCANNER.next();
        SCANNER.nextLine();

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
            Sala novaSala = new Sala(nome_sala, local_sala, capacidadeTotalDaSala);
            return novaSala;
        } else {
            System.out.println("Operação cancelada...");
        }
        return null;
    }

    /**
     * <p>
     * Cria um objeto curso caso o usuário confirme a operação.
     * </p>
     *
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static Curso curso(Scanner SCANNER) {
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
            return curso;
        } else {
            System.out.println("Operação cancelada...");
        }
        return null;
    }

    /**
     * <p>
     * Cria um objeto turma caso o usuário confirme a operação.
     * </p>
     *
     * @param SCANNER O Scanner usado para ler as informações.
     * @return a lista de Strings com as informações de pessoas
     * @since 1.0
     */
    public static Turma turma(Scanner SCANNER) {
        System.out.println("-Cadastrar nova turma-");
        while (true) {
            try {
                System.out.print("Digite o nome da turma: ");
                String nome_turma = SCANNER.nextLine();
                Sala sala = new Sala();
                Curso curso = new Curso();

                System.out.print("\nAdicionar uma sala? (S/N) ");
                String resposta = SCANNER.next().substring(0, 1).toUpperCase();
                if (resposta.equals("S")) {
                    Sala sala_a = sala(SCANNER);
                    sala = sala_a;
                    DaoFactory.criaSalaDao().inserirSala(sala);
                }

                System.out.print("\nAdicionar uma curso? (S/N) ");
                resposta = SCANNER.next().substring(0, 1).toUpperCase();
                if (resposta.equals("S")) {
                    Curso curso1 = curso(SCANNER);
                    curso = curso1;
                    DaoFactory.criaCursoDao().inserirCurso(curso);
                }

                Turma turma = new Turma(nome_turma, sala, curso);
                return turma;
            } catch (InputMismatchException e) {
                System.out.println("Digite corretamente os dados!");
                return null;
            }

        }

    }

    /**
     * <p>
     * Pega as informações de info_pessoas adiciona o código do funcionário e cria um
     * objeto Professor caso o usuário confirme a operação.
     * </p>
     *
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static Professor professor(Scanner SCANNER) {
        Exibir.separador();
        System.out.println("-Cadastrar novo professor-");

        List<String> dados = info_pessoas(SCANNER);
        if (dados.size() == 0) {
            System.out.println("Operação cancelada...");
        }

        return new Professor(
                dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4)
        );
    }

    public static Aula aula(Scanner SCANNER) {
        Exibir.separador();
        System.out.println("-Cadastrar nova aula-");
        while (true) {
            System.out.print("Qual é o nome da aula: ");
            String nome_aula = SCANNER.nextLine();
            System.out.println("Em qual sala terá aula? \n\n--Selecione o ID da sala-- \n");
            DaoFactory.criaSalaDao().buscarTodasSalas();
            System.out.print("ID: ");
            int id_sala = SCANNER.nextInt();

            Sala sala = DaoFactory.criaSalaDao().buscarSalaPorIdTransformarEmOBjSala(id_sala);
            if (sala == null) {
                System.out.println("Sala inexistente... Por favor tente novamente");
                System.out.print("Gostaria de cancelar a operação? (S/N) : ");
                String resp = SCANNER.next().substring(0, 1).toUpperCase();
                if (resp.equals("S")) {
                    return null;
                } else {
                    continue;
                }
            } else {
                ArrayList<String> dias_de_aula = new ArrayList<>();
                System.out.print("Em qual dia da semana terá aula: ");
                while (true) {
                    Exibir.diaDaSemana();
                    String dia_semana = SCANNER.next();
                    dias_de_aula.add(dia_semana);
                    System.out.print("São apenas estes dias? (S/N) ");
                    String resp = SCANNER.next().substring(0, 1).toUpperCase();
                    if (resp.equals("S")) {
                        break;
                    }
                    if (dias_de_aula.size() >= 5) {
                        break;
                    }
                }
                boolean controle = true;
                System.out.println(dias_de_aula.get(1));
                for (int x = 0; x < dias_de_aula.size(); x++) {
                    if (DaoFactory.criaAulaDao().verSeTemSalaCadastradaAulaEmQueDia(id_sala, dias_de_aula.get(x))) {
                        controle = false;
                    }
                }
                if (!controle) {
                    System.out.println("Impossível cadastrar aula neste(s) dia, sala já está sendo ocupada...");
                    System.out.print("Gostaria de cancelar a operação? (S/N) : ");
                    String resp = SCANNER.next().substring(0, 1).toUpperCase();
                    if (resp.equals("S")) {
                        return null;
                    } else {
                        continue;
                    }
                }

                System.out.println("Qual turma terá aula de " + nome_aula + "?");
                System.out.println("\n--Selecione o ID da turma--");
                DaoFactory.criaTurmaDao().buscarTodasTurmas();
                System.out.print("ID: ");
                Integer id_turma = SCANNER.nextInt();

                for (int x = 0; x < dias_de_aula.size(); x++) {
                    if (DaoFactory.criaAulaDao().verSeTemTurmaCadastradaAulaEmQueDia(id_turma, dias_de_aula.get(x))) {
                        controle = false;
                    }
                }

                if (!controle) {
                    System.out.println("Uma turma não pode ter mais de uma aula por dia...");
                    System.out.print("Gostaria de cancelar a operação? (S/N) : ");
                    String resp = SCANNER.next().substring(0, 1).toUpperCase();
                    if (resp.equals("S")) {
                        return null;
                    } else {
                        continue;
                    }
                }

                Turma turma = DaoFactory.criaTurmaDao().buscarTurmaPorIdTransformaEmObjTurma(id_turma);
                if (turma == null) {
                    System.out.println("Turma inexistente...");
                    System.out.print("Gostaria de cancelar a operação? (S/N) : ");
                    String resp = SCANNER.next().substring(0, 1).toUpperCase();
                    if (resp.equals("S")) {
                        return null;
                    } else {
                        System.out.println("Tente cadastrar outra turma...");
                    }
                } else {
                    Aula aula = new Aula();
                    aula.setSala(sala);
                    aula.setTurma(turma);
                    aula.setNomeAula(nome_aula);
                    for (int x = 0; x < dias_de_aula.size(); x++) {
                        aula.setDiaSemana(dias_de_aula.get(x));
                    }
                    DaoFactory.criaAulaDao().inserirAula(aula);
                    break;
                }
            }
        }
    }

    private static String multiplica(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}