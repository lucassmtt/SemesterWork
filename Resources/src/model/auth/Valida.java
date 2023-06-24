package model.auth;

import model.tools.Exibir;

import java.util.ArrayList;
import java.util.Scanner;


public class Valida {
    static Scanner SCANNER = new Scanner(System.in);

    public static String cpf() {
        int contador_de_vezes_na_funcao = 0;
        String cpf, resp;
        ArrayList<Integer> cpf_lista = new ArrayList<Integer>();
        ArrayList<Integer> lista_a = new ArrayList<Integer>();
        ArrayList<Integer> lista_b = new ArrayList<Integer>();

        while (true) {
            if (contador_de_vezes_na_funcao >= 1) {
                resp = Exibir.exibicao("Gostaria de cancelar a operação? ").toUpperCase().substring(0, 1);
                if (resp.equals("S")) {
                    return "";
                }
            }
            System.out.println("Por favor digite o cpf (111.222.333-45): ");
            System.out.print(": ");
            cpf = SCANNER.next();
            SCANNER.nextLine();
            if (cpf.length() != 14) {
                System.out.println("Por favor digite um corretamente o CPF.");
                contador_de_vezes_na_funcao += 1;
                continue;
            }
            int cont = 0;
            int j = 1;
            for (int x = 0; x < 14; x++, j++) {

                String valor = cpf.substring(x, j);
                Integer valor_em_inteiro = 0;

                if (x == 3 || x == 7 || x == 11) {
                    cont -= 1;
                    if (!valor.equals(".") && !valor.equals("-")) {
                        contador_de_vezes_na_funcao += 1;
                        continue;
                    }
                    if ((x == 3 || x == 7) && !valor.equals(".")) {
                        contador_de_vezes_na_funcao += 1;
                        continue;
                    }
                    if ((x == 11) && !valor.equals("-")) {
                        contador_de_vezes_na_funcao += 1;
                        continue;
                    }

                }
                if (valor.equals(".") || valor.equals("-")) {
                    contador_de_vezes_na_funcao += 1;
                    continue;
                }
                if (!valor.equals(".") && !valor.equals("-")) {
                    valor_em_inteiro = Integer.parseInt(valor);
                    cpf_lista.add(valor_em_inteiro);
                }
            }

            cont = 0;

            int num = 0;
            for (int x = 0; x < 9; x++) {
                num = cpf_lista.get(x);
                lista_a.add(num);
            }
            for (int x = 0; x < 10; x++) {
                num = cpf_lista.get(x);
                lista_b.add(num);
            }

            cont = 10;
            int resultado = 0;
            for (int item : lista_a) {
                resultado += item * cont;
                cont -= 1;
            }
            int digito_1 = (resultado * 10) % 11;

            if (digito_1 >= 9) {
                digito_1 = 0;
            }

            int cont_2 = 11;
            resultado = 0;
            for (int item : lista_b) {
                resultado += cont_2 * item;
                cont_2 -= 1;
            }

            int digito_2 = (resultado * 10) % 11;
            if (digito_2 >= 9) {
                digito_2 = 0;
            }
            int primeiro_digito = Integer.parseInt(cpf.substring(12, 13));
            int segundo_digito = Integer.parseInt(cpf.substring(13, 14));

            if (primeiro_digito == digito_1 && segundo_digito == digito_2) {
                System.out.println("CPF correto...");
                return cpf;
            } else {
                System.out.println("CPF informado não é válido. \nPor favor registre um cpf anexado a Secretaria Especial da Receita Federal do Brasil. ");
                contador_de_vezes_na_funcao += 1;
                cpf_lista.clear();
                lista_a.clear();
                lista_b.clear();
            }
        }
    }

    public static String nome() {
        int contador_de_vezes_na_funcao = 0;
        String resp;
        while (true) {
            if (contador_de_vezes_na_funcao >= 1) {
                resp = Exibir.exibicao("Gostaria de cancelar a operação? ").toUpperCase().substring(0, 1);
                if (resp.equals("S")) {
                    return "";
                }
            }
            System.out.print("Digite o nome inteiro: ");
            String nome = SCANNER.nextLine();
            if (nome.length() > 100) {
                contador_de_vezes_na_funcao += 1;
                System.out.println("Falhou 1");
                continue;
            }
            if (nome.length() < 5) {
                contador_de_vezes_na_funcao += 1;
                System.out.println("Falhou 2");
                continue;
            }

            System.out.println("Nome correto? " + nome + " (S/N) ");
            System.out.print(": ");
            resp = SCANNER.next().substring(0, 1).toUpperCase();
            SCANNER.nextLine();
            if (resp.equals("S")) {
                return nome;
            }
        }
    }

    public static String endereco() {
        String endereco, resp;
        int contador_de_vezes_na_funcao = 0;
        while (true) {
            if (contador_de_vezes_na_funcao >= 1) {
                resp = Exibir.exibicao("Gostaria de cancelar a operação? ").toUpperCase().substring(0, 1);
                if (resp.equals("S")) {
                    return "";
                }
            }
            System.out.print("Digite o endereço: ");
            endereco = SCANNER.nextLine();
            if (endereco.length() < 4) {
                System.out.println("Por favor digite o endereço inteiro!");
                contador_de_vezes_na_funcao += 1;
                continue;
            }
            if (endereco.length() > 250) {
                System.out.println("Comprimento de endereço muito grande, por favor digite corretamente!!!");
                contador_de_vezes_na_funcao += 1;
                continue;
            }
            System.out.println("Endereço correto? (S/N) " + endereco);
            System.out.print(": ");
            resp = SCANNER.next().substring(0, 1).toUpperCase();
            SCANNER.nextLine();
            if (resp.equals("S")) {
                return endereco;
            }
        }
    }

    public static String email() {
        String email, resp;
        int contador_de_vezes_na_funcao = 0;
        while (true) {
            if (contador_de_vezes_na_funcao >= 1) {
                resp = Exibir.exibicao("Gostaria de cancelar a operação? ").toUpperCase().substring(0, 1);
                if (resp.equals("S")) {
                    return "";
                }
            }
            System.out.print("Digite seu email: ");
            email = SCANNER.nextLine();
            if (email.length() < 5) {
                System.out.println("Por favor adicione um email maior (Segurança é importante) ");
                contador_de_vezes_na_funcao += 1;
                continue;
            }
            if (email.length() > 250) {
                System.out.println("Comprimento de email muito grande, por favor digite um email menor!!!");
                contador_de_vezes_na_funcao += 1;
                continue;
            }
            int j = 0;
            int k = 1;
            int cont = 0;

            for (; j <= email.length(); j++, k++) {
                if (email.substring(j, k).equals("@")) {
                    cont += 1;
                }
                if (j + 1 == email.length()) {
                    break;
                }
            }
            if (cont != 1) {
                System.out.println("Por favor digite corretamente, um email não pode conter nenhuma ou mais de uma @!!!");
                contador_de_vezes_na_funcao += 1;
                continue;
            }

            return email;

        }
    }

    public static String celular() {
        String celular, resp;
        int contador_de_vezes_na_funcao = 0;
        while (true) {
            if (contador_de_vezes_na_funcao >= 1) {
                resp = Exibir.exibicao("Gostaria de cancelar a operação? ").toUpperCase().substring(0, 1);
                if (resp.equals("S")) {
                    return "";
                }
            }
            System.out.print("Digite seu telefone celular: ");
            celular = SCANNER.next();

            if (celular.length() != 11) {
                continue;
            }
            if (
                    celular.equals("00000000000") || celular.equals("11111111111") || celular.equals("22222222222") ||
                            celular.equals("33333333333") || celular.equals("44444444444") || celular.equals("55555555555") ||
                            celular.equals("66666666666") || celular.equals("77777777777") || celular.equals("88888888888") ||
                            celular.equals("99999999999")
            ) {
                System.out.println("Por favor não digite uma sequência como número...");
                continue;
            }

            int j = 0;
            int k = 1;
            int cont = 0;

            for (; j < celular.length(); j++, k++) {
                try {
                    int num = Integer.parseInt(celular.substring(j, k));
                } catch (Exception e) {
                    cont += 1;
                }
            }
            if (cont > 0) {
                System.out.println("Por favor não envia letras...");
                continue;
            }
            return celular;
        }
    }
}
