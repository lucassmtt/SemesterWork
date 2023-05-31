package model.ferramentas;

import model.auth.Valida;
import model.entities.*;
import model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 Classe utilizada para cadastrar objetos...
 */
public class Cadastrar
{
    /**
     * <p>
     * Monta as informações que precisamos para cadastrar o Aluno ou o Professor.
     * </p>
     * @param SCANNER O Scanner usado para ler as informações.
     * @return A lista de Strings com as informações de pessoas.
     * @since 1.0
     */
    public static List<String> info_pessoas(Scanner SCANNER)
    {
        String nome = multiplica("a", 50);
        String cpf_usuario_sem_formatacao = multiplica("a", 11);
        String endereco = multiplica("a",40);
        String email = multiplica("a", 60);
        String celular = multiplica("a", 12);
        while (
                   (nome.length() > 49)
//                || (cpf_usuario_sem_formatacao.length() != 18)
                || (endereco.length() > 39)
                || (email.length() > 59)
                || (celular.length() != 11)
              )
        {
            System.out.print("Nome: ");
            nome = SCANNER.nextLine();
            if (nome.length() >= 50){
                System.out.println("Por favor digite o nome corretamente!");
                continue;
            }

//            System.out.print("CPF: ");
//            cpf_usuario_sem_formatacao = SCANNER.next();
            ArrayList<Integer> cpf_formatado = new ArrayList<Integer>();
            Valida.cpf(cpf_usuario_sem_formatacao, SCANNER);


//            SCANNER.nextLine();
//            if (cpf.length() != 18){
//                System.out.println("Por favor digite corretamente o cpf (111.222.333.444-55) ");
//                continue;
//            }




            System.out.println("Endereço: ");
            endereco = SCANNER.nextLine();
            if (endereco.length() >= 40){
                System.out.println("Digite o endereço corretamente!");
                continue;
            }

            System.out.print("Email: ");
            SCANNER.next();
            if (email.length() >= 60){
                System.out.println("Por favor digite o email corretamente!");
                continue;
            }

            System.out.print("Celular: ");
            SCANNER.next();
            if (celular.length() != 11){
                System.out.println("Por favor digite o seu celular corretamente!");
                continue;
            }
        }
        return Arrays.asList(cpf_usuario_sem_formatacao, nome, endereco, email, celular);
    }

    /**
     * <p>
     * Pega as informações do info_pessoas, adiciona um número de matrícula
     * e cria um objeto Aluno caso o usuário confirme a operação.
     * </p>
     * @param lista_de_alunos Lista de alunos que o objeto será adicionado.
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static void aluno(List<Aluno> lista_de_alunos, Scanner SCANNER)
    {
        Exibir.separador();
        System.out.println("Cadastrar novo aluno:");
        System.out.println("Por favor envie os dados do aluno para ser cadastrado...");

        List<String> dados = info_pessoas(SCANNER);

        System.out.print("Digite o número da matricula: ");
        int numero_matricula = SCANNER.nextInt();
        Exibir.separador();
        System.out.println("CPF: " + dados.get(0));
        System.out.println("Nome: " + dados.get(1));
        System.out.println("Endereço: " + dados.get(2));
        System.out.println("Email: " + dados.get(3));
        System.out.println("Celular: " + dados.get(4));
        System.out.println("CONFIRMAR DADOS? (S/N) ");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Aluno aluno = new Aluno(
                    dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4), numero_matricula
            );
            lista_de_alunos.add(aluno);
            System.out.println("Aluno adicionado!");
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    /**
     * <p>
     * Cria um objeto sala caso o usuário confirme a operação.
     * </p>
     * @param lista_de_salas A lista de salas que o objeto será adicionado caso confirme criação.
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static void sala(List<Sala> lista_de_salas, Scanner SCANNER)
    {
        Exibir.separador();
        System.out.println("Cadastrar nova sala:");
        System.out.print("Digite o nome da sala: ");
        String nome_sala = SCANNER.nextLine();

        System.out.print("Digite o local: ");
        String local_sala = SCANNER.nextLine();

        System.out.print("Digite a capacidade total da sala: ");
        int capacidadeTotalDaSala = SCANNER.nextInt();
        System.out.print("Digite o código da sala: ");
        int codigoSala = SCANNER.nextInt();
        Exibir.separador();
        System.out.println("Nome: " + nome_sala);
        System.out.println("Local: " + local_sala);
        System.out.println("Capacidade: " + capacidadeTotalDaSala);
        System.out.println("Código: " + codigoSala);

        System.out.println("Informações correta? (S/N) ");
        System.out.print("Resposta: ");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Sala novaSala = new Sala(codigoSala, nome_sala, local_sala, capacidadeTotalDaSala);
            lista_de_salas.add(novaSala);
            System.out.println("Sala adicionada com sucesso!");
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    /**
     * <p>
     * Cria um objeto curso caso o usuário confirme a operação.
     * </p>
     * @param lista_de_cursos Lista de cursos a qual o objeto será adicionado.
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static void curso(List<Curso> lista_de_cursos, Scanner SCANNER)
    {
        Exibir.separador();
        System.out.println("Cadastrar novo curso:");

        System.out.print("Digite o código do curso: ");
        int codigo_curso = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.print("Digite o nome do curso: ");
        String nome_curso = SCANNER.nextLine();

        System.out.print("Digite a carga horária do curso: ");
        int carga_horaria = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.print("Digite uma descrição para o curso: ");
        String descricao = SCANNER.nextLine();
        Exibir.separador();
        System.out.println("Código do curso: " + codigo_curso);
        System.out.println("Nome do curso: " + nome_curso);
        System.out.println("Carga horária do curso: " + carga_horaria);
        System.out.println("Descrição do curso " + descricao);
        System.out.println("Informações corretas? (S/N)");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Curso curso = new Curso(codigo_curso, nome_curso, carga_horaria, descricao);
            lista_de_cursos.add(curso);
            System.out.println("Curso adicionado com sucesso!");
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    /**
     * <p>
     * Cria um objeto turma caso o usuário confirme a operação.
     * </p>
     * @param lista_de_salas O Scanner usado para ler as informações.
     * @param lista_de_cursos O Scanner usado para ler as informações.
     * @param lista_de_turmas O Scanner usado para ler as informações.
     * @param SCANNER O Scanner usado para ler as informações.
     * @return a lista de Strings com as informações de pessoas
     * @since 1.0
     */
    public static void turma(List<Sala> lista_de_salas, List<Curso> lista_de_cursos, List<Turma> lista_de_turmas, Scanner SCANNER)
    {
        System.out.println("Cadastrar turma: ");
        System.out.print("Nome da turma: ");
        String nomeTurma = SCANNER.nextLine();
        int codigo_turma = SCANNER.nextInt();
        SCANNER.nextLine();
        ArrayList<DiaSemana> diaComAula = new ArrayList<>();
        while (true)
        {
            DiaSemana cronograma = null;
            Exibir.diaDaSemana();
            int resp = SCANNER.nextInt();
            switch (resp) {
                case 1 -> diaComAula.add(DiaSemana.SEGUNDA);
                case 3 -> diaComAula.add(DiaSemana.TERCA);
                case 4 -> diaComAula.add(DiaSemana.QUARTA);
                case 5 -> diaComAula.add(DiaSemana.QUINTA);
                case 6 -> diaComAula.add(DiaSemana.SEXTA);
                default -> System.out.println("Por favor digite uma resposta válida...");
            }
            System.out.println("Anexar turma a mais um dia da semana? (S/N) ");
            String cadastroMais = SCANNER.next().substring(0, 1).toUpperCase();
            if (cadastroMais.equals("N")){
                System.out.println("Nome da turma: " + nomeTurma);
                System.out.println("Dias escolhidos: ");
                for (DiaSemana diaSemana : diaComAula){
                    System.out.println(diaSemana);
                }
                System.out.println("Informações corretas? (S/N) ");
                String resposta = SCANNER.next().substring(0, 1).toUpperCase();
                if (resposta.equals("S")) {
                    Turma turma = new Turma(nomeTurma, codigo_turma, diaComAula);
                    lista_de_turmas.add(turma);
                    System.out.println("Turma adicionada com sucesso!");
                }
                else {
                    System.out.println("Operação cancelada...");
                }
                break;
            }
        }
        System.out.println("Gostaria de adicionar esta turma a uma sala? (S/N) ");
        String resp = SCANNER.next();
        if (resp.equals("S")){
            System.out.println("Adicionando");
        }
        else {
            System.out.println("Encerrando criação de turma...");
        }
    }

    /**
     * <p>
     * Pega as informações de info_pessoas adiciona o código do funcionário e cria um
     * objeto Professor caso o usuário confirme a operação.
     * </p>
     * @param lista_de_professores Lista de professores a qual o objeto será adicionado.
     * @param SCANNER O Scanner usado para ler as informações.
     * @return Sem retorno.
     * @since 1.0
     */
    public static void professor(List<Professor> lista_de_professores, Scanner SCANNER) {
        Exibir.separador();
        System.out.println("Cadastrar novo professor: ");

        List<String> dados = info_pessoas(SCANNER);
        int codigo_funcionario = SCANNER.nextInt();

        Professor professor = new Professor(
                dados.get(0), dados.get(1), dados.get(2), dados.get(3), dados.get(4), codigo_funcionario
        );
        lista_de_professores.add(professor);
        System.out.println("Professor adicionado com sucesso!");
    }
    private static String multiplica(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}