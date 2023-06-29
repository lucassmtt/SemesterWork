package model.tools;

import java.util.ArrayList;
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


    public static ArrayList<String> diaDaSemana()
    {
        Scanner SCANNER = new Scanner(System.in);
        ArrayList<String> dias_de_aula = new ArrayList<>();

        while (true){
            System.out.printf("""
                \n0 = Cancelar operação
                1 = Segunda
                2 = Terça
                3 = Quarta
                4 = Quinta
                5 = Sexta
                6 = Deixar dias cadastrados
                
                (Por favor, adicione um dia por vez)
                
                """);
            if (dias_de_aula.size() == 0){
                System.out.println("Dias cadastrados: Nenhum dia cadastrado." + "\n");
            }
            System.out.print("Resposta: ");
            int resp = SCANNER.nextInt();
            if (resp > 6 || resp < 0){
                SCANNER.close();
                continue;
            }
            switch (resp){
                case 0 -> {
                    SCANNER.close();
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
                case 6 -> {
                    if (dias_de_aula.size() == 0){
                        System.out.println("Por favor adicione algum dia para ter aula...");
                        continue;
                    }
                    else {
                        SCANNER.close();
                        return dias_de_aula;
                    }
                }
            }
            System.out.println("Dias escolhidos " + dias_de_aula);
            System.out.print("São apenas estes dias? (S/N) ");
            String resp_ = SCANNER.next().substring(0,1).toUpperCase();
            if (resp_.equals("S")) {
                SCANNER.close();
                return dias_de_aula;
            }
            if (dias_de_aula.size() > 5) {
                dias_de_aula.clear();
                System.out.println("Por favor adicione corretamente os dias da semana. (RECOMEÇANDO ANOTAÇÕES DOS DIAS)");
                break;
            }
        }
        SCANNER.close();
        return null;
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
        Scanner SCANNER = new Scanner(System.in);
        System.out.print(msg + "(S/N): ");
        String resp = SCANNER.next();
        return resp;
    }
}