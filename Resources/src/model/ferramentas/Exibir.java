package model.ferramentas;

import model.entities.*;

import java.util.List;
import java.util.Scanner;

import static application.Program_2.lista_de_salas;
public class Exibir
{
    public static void menu()
    {
        separador();
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
             11 = ADICIONAR ALUNO A TURMA
             12 = ADICIONAR TURMA A SALA
             13 = ADICIONAR PROFESSOR A TURMA
            """);
        System.out.print("Resposta: ");
    }


    public static void diaDaSemana()
    {
        System.out.println("Digite o dia da semana que terá aula nessa turma: ");
        System.out.println();
        System.out.println("""
                0 = Cancelar operação
                1 = Segunda
                2 = Terça
                3 = Quarta
                4 = Quinta
                5 = Sexta
                            
                (Se já estiver alocada uma turma na sala no dia enviado, será desconsiderado)
                (Adicionar apenas um valor por vez)
                
                """);
        System.out.print("Resposta: ");
    }


    public static void listaDeAlunos(List<Aluno> lista_de_alunos)
    {
        System.out.println("Lista de alunos: ");
        for (Aluno aluno : lista_de_alunos) {
            espera_em_ms(400);
            System.out.println("INFORMAÇÕES ALUNO: \n");
            System.out.println();
            System.out.println("\tNome: " + aluno.nome);
            System.out.println("\tCPF: " + aluno.cpf);
            System.out.println("\tEndereço: " + aluno.endereco);
            System.out.println("\tCelular: " + aluno.celular);
            System.out.println("\tNúmero da Matrícula: " + aluno.matricula);
            System.out.println();
            espera_em_ms(1500);
        }
        if (lista_de_alunos.size() == 0){
            System.out.println("LISTA DE ALUNOS VAZIA!");
        }
    }


    public static void listaDeSalas(List<Sala> lista_de_salas)
    {
        System.out.println("Lista de salas: ");
        for (Sala sala : lista_de_salas) {
            System.out.println(sala);
            espera_em_ms(1600);
        }
    }


    public static void listaDeCursos(List<Curso> lista_de_cursos)
    {
        System.out.println("Lista de cursos: ");
        for (Curso curso : lista_de_cursos) {
            System.out.println(curso);
            espera_em_ms(1600);
        }
    }


    public static void listaDeTurmas(List<Turma> lista_de_turmas)
    {
        System.out.println("Lista de turmas: ");
        for (Turma turma : lista_de_turmas){
            System.out.println(turma);
        }
    }


    public static void adicionarTurmaSala(List<Turma> lista_de_turmas, Scanner SCANNER)
    {
        listaDeTurmas(lista_de_turmas);
        System.out.println("""
                Adicionar turmas existentes = 1
                Criar nova turma = 2
                """);
        int resp = SCANNER.nextInt();
        SCANNER.nextLine();
        if (resp == 1) {
            System.out.println("Digite o código da turma que você quer adicionar a sala");
        }
        listaDeSalas(lista_de_salas);
    }


    public static void listaDeProfessores(List<Professor> lista_de_professores)
    {
        System.out.println("Lista de professores: ");
        for (Professor professor : lista_de_professores){
            System.out.println(professor);
            espera_em_ms(1600);
        }
    }


    public static void espera_em_ms(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    public static void separador()
    {
        System.out.println("_______________________\n");
    }


    public static String exibicao(String msg, Scanner SCANNER)
    {
        System.out.print(msg + "(S/N): ");
        return SCANNER.next().substring(0, 1).toUpperCase();
    }
}