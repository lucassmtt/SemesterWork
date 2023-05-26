//package application;
//
//import model.entities.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class REFATORANDOCADASTURMA {
//
//    public static void cadastrarTurma(List<Sala> lista_de_salas, List<Curso> listaDeCursos, Scanner entrada){
//
//        System.out.println("Cadastrar turma: ");
//        System.out.print("Nome da turma: ");
//        String nomeTurma = entrada.nextLine();
//        ArrayList<DiaSemana> diaComAula = new ArrayList<>();
//        while (true)
//        {
//            DiaSemana cronograma = null;
//            exibirDiaSemana();
//            int resp = entrada.nextInt();
//            switch (resp) {
//                case 1 -> diaComAula.add(DiaSemana.SEGUNDA);
//                case 3    -> diaComAula.add(DiaSemana.TERCA);
//                case 4 -> diaComAula.add(DiaSemana.QUARTA);
//                case 5 -> diaComAula.add(DiaSemana.QUINTA);
//                case 6 -> diaComAula.add(DiaSemana.SEXTA);
//                default -> System.out.println("Por favor digite uma resposta válida...");
//            }
//            System.out.println("Anexar turma a mais um dia da semana? (S/N) ");
//            String cadastroMais = entrada.next().substring(0, 1).toUpperCase();
//            if (cadastroMais.equals("N")){
//                System.out.println("Nome da turma: " + nomeTurma);
//                System.out.println("Dias escolhidos: ");
//                for (DiaSemana diaSemana : diaComAula){
//                    System.out.println(diaSemana);
//                }
//                System.out.println("Informações corretas? (S/N) ");
//                String resposta = entrada.next().substring(0, 1).toUpperCase();
//                if (resposta.equals("S")) {
//                    Turma turma = new Turma(nomeTurma, diaComAula);
//                }
//                else {
//                    System.out.println("Operação cancelada...");
//                }
//                break;
//            }
//        }
//
//    }
//
//
//}
