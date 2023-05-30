package model.auth;

import model.entities.DiaSemana;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;


public class Valida {
    public static ArrayList<Integer> cpf(String cpf, Scanner SCANNER){
        ArrayList<Integer> cpf_lista = new ArrayList<Integer>();
        ArrayList<Integer> lista_a = new ArrayList<Integer>();
        ArrayList<Integer> lista_b = new ArrayList<Integer>();

        System.out.println("Por favor digite o cpf (111.222.333-45): ");
        while (true)

        {
            System.out.print(": ");
            cpf = SCANNER.next();
            if (cpf.length() != 14){
                System.out.println("Por favor digite um corretamente o CPF.");
                continue;
            }
            int cont = 0;
            int j = 1;
            for (int x = 0; x < 14; x++, j++) {

                String valor = cpf.substring(x, j);
                Integer valor_em_inteiro = 0;

                if (x == 3 || x == 7 || x == 11){
                    cont -= 1;
                    if (!valor.equals(".") && !valor.equals("-")){
                        continue;
                    }
                    if ((x == 3 || x == 7) && !valor.equals(".")){
                        continue;
                    }
                    if ((x == 11) && !valor.equals("-")){
                        continue;
                    }

                }
                if (valor.equals(".") || valor.equals("-")){
                    continue;
                }
                if (!valor.equals(".") && !valor.equals("-")){
                    valor_em_inteiro = Integer.parseInt(valor);
                    cpf_lista.add(valor_em_inteiro);
                }
            }

            for (int num : cpf_lista){
                System.out.print(num);
            }


            cont = 0;

            int num = 0;
            for (int x = 0; x < 9; x++){
                num = cpf_lista.get(x);
                lista_a.add(num);
            }
            for (int x = 0; x < 10; x++){
                num = cpf_lista.get(x);
                lista_b.add(num);
            }

            cont = 10;
            int resultado = 0;
            for (int item : lista_a){
                resultado += item * cont;
                cont -= 1;
            }
            int digito_1 = (resultado * 10) % 11;

            if (digito_1 <= 9){
                digito_1 = digito_1;
            }
            else {
                digito_1 = 0;
            }

            int cont_2 = 11;
            resultado = 0;
            for (int item : lista_b){
                resultado += cont_2 * item;
                cont_2 -= 1;
            }

            int digito_2 = (resultado * 10) % 11;
            if (digito_2 <= 9){
                digito_2 = digito_2;
            }
            else {
                digito_2 = 0;
            }
            int primeiro_digito = cpf_lista.get(9);
            int segundo_digito = cpf_lista.get(10);

            if (primeiro_digito == digito_1 && segundo_digito == digito_2){
                System.out.println("CPF correto...");
                return cpf_lista;
            }
            else {
                System.out.println("CPF informado não é válido. Por favor registre um cpf anexado a Secretaria Especial da Receita Federal do Brasil. ");
                cpf_lista.clear();
                continue;
            }
        }
    }
}
