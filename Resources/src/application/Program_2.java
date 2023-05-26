package application;

import model.entities.*;

import java.util.*;

public class Program_2 {
    public static final Scanner SCANNER;
    public static final int tempoEspera = 500;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static List<Aluno> lista_de_alunos;
    public static List<Sala> lista_de_salas;
    public static List<Curso> lista_de_cursos;
    public static List<Professor> lista_de_professores;

    static {lista_de_alunos = new ArrayList<>();}

    static {lista_de_salas = new ArrayList<>();}

    static {lista_de_cursos = new ArrayList<>();}

    static {lista_de_professores = new ArrayList<>();}

    public static void main(String[] args) {
        int resposta;
        boolean continuar = true;

        while (continuar) {
            try {
                exibirMenu();
                resposta = SCANNER.nextInt();
                SCANNER.nextLine();
                String resp;
                switch (resposta) {
                    case 0 -> {
                        System.out.println("Saindo...");
                        continuar = false;
                    }
                    case 1 -> {
                        wait(tempoEspera);
                        cadastrarAluno(lista_de_alunos, SCANNER);
                        resp = exibicao("Mostrar listas de alunos?", SCANNER);
                        if (resp.equals("S")) {
                            exibirListaAlunos(lista_de_alunos);
                            wait(1500);
                            System.out.println("\n");
                        }
                    }
                    case 2 -> {
                        wait(tempoEspera);
                        cadastrarSala(lista_de_salas, SCANNER);
                        resp = exibicao("Mostrar lista de salas?", SCANNER);
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            exibirListaSalas(lista_de_salas);
                            wait(1500);
                        }
                    }
                    case 3 -> {
                        wait(tempoEspera);
                        cadastrarCurso(lista_de_cursos, SCANNER);
                        resp = exibicao("Mostrar lista de cursos?", SCANNER);
                        if (resp.equals("S")) {
                            System.out.println("\n");
                            exibirListaCursos(lista_de_cursos);
                            wait(1500);
                        }
                    }
                    case 4 -> {
                        wait(tempoEspera);
                        cadastrarTurma(lista_de_salas, lista_de_cursos, SCANNER);
                        resp = exibicao("Mostrar lista de salas?", SCANNER);
                        System.out.println("\n");
                        System.out.println(resp);
                    }
//                    if (resp.equals("S")){}
                    case 5 -> {
                        wait(tempoEspera);
                        cadastrarProfessor(SCANNER, lista_de_professores);
                        resp = exibicao("Mostrar lista de professores?", SCANNER);
                        if (resp.equals("S")) {
                            exibirListaProfessores(lista_de_professores);
                        }
                    }
                    case 6 -> { wait(tempoEspera); exibirListaAlunos(lista_de_alunos); }
                    case 7 -> { wait(tempoEspera); exibirListaSalas(lista_de_salas); }
                    case 8 -> { wait(tempoEspera); exibirListaCursos(lista_de_cursos); }
                    case 9 -> { wait(tempoEspera);
                        continue;
                    }
                    case 10 -> {wait(tempoEspera); exibirListaProfessores(lista_de_professores); }
                    default -> System.out.println("Por favor, envie um valor válido...");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Erro: Entrada válida. Certifique-se de inserir o tipo correto para cada dado!!!");
                wait(1000);
                SCANNER.nextLine();
            }

            catch (NoSuchElementException e){
                System.out.println("Erro: Entrada não encontrada. Certifique-se de inserir todas as informações necessárias!!!");
                SCANNER.nextLine();
            }

            catch (Exception e){
                System.out.println("Ocorreu um erro inesperado. Por favor tente mais tarde");
                e.printStackTrace();
                continuar = false;
            }


        }
        SCANNER.close();
    }

    public static void exibirMenu() {
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

    public static void exibirDiaSemana(){
        separador();
        System.out.println("Cadastrar nova turma:");
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

    public static void separador(){
        System.out.println("_______________________\n");
    }

    public static String exibicao(String msg, Scanner entrada) {
        System.out.print(msg + "(S/N): ");
        return entrada.next().substring(0, 1).toUpperCase();
    }

    public static void cadastrarAluno(List<Aluno> lista_de_alunos, Scanner entrada) {
        separador();
        System.out.println("Cadastrar novo aluno:");
        System.out.println("Por favor envie os dados do aluno para ser cadastrado...");

        List<String> dados = cadastrarPessoa(entrada);
        String cpf = dados.get(0);
        String nome = dados.get(1);
        String endereco = dados.get(2);
        String email = dados.get(3);
        String celular = dados.get(4);

        System.out.print("Digite o número da matricula: ");
        int numero_matricula = entrada.nextInt();
        separador();
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Email: " + email);
        System.out.println("Celular: " + celular);
        System.out.println("CONFIRMAR DADOS? (S/N) ");
        String resp = entrada.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Aluno aluno = new Aluno(cpf, nome, endereco, email, celular, numero_matricula);
            lista_de_alunos.add(aluno);
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    public static void exibirListaAlunos(List<Aluno> lista_de_alunos) {
        System.out.println("Lista de alunos: ");
        for (Aluno aluno : lista_de_alunos) {
            wait(400);
            System.out.println("INFORMAÇÕES ALUNO: \n");
            System.out.println();
            System.out.println("\tNome: " + aluno.nome);
            System.out.println("\tCPF: " + aluno.cpf);
            System.out.println("\tEndereço: " + aluno.endereco);
            System.out.println("\tCelular: " + aluno.celular);
            System.out.println("\tNúmero da Matrícula: " + aluno.matricula);
            System.out.println();
            wait(1500);
        }
        if (lista_de_alunos.size() == 0){
            System.out.println("LISTA DE ALUNOS VAZIA!");
        }
    }

    public static void cadastrarSala(List<Sala> lista_de_salas, Scanner entrada) {
        separador();
        System.out.println("Cadastrar nova sala:");
        System.out.print("Digite o nome da sala: ");
        String nome_sala = entrada.nextLine();

        System.out.print("Digite o local: ");
        String local_sala = entrada.nextLine();

        System.out.print("Digite a capacidade total da sala: ");
        int capacidadeTotalDaSala = entrada.nextInt();
        System.out.print("Digite o código da sala: ");
        int codigoSala = entrada.nextInt();
        separador();
        System.out.println("Nome: " + nome_sala);
        System.out.println("Local: " + local_sala);
        System.out.println("Capacidade: " + capacidadeTotalDaSala);
        System.out.println("Código: " + codigoSala);

        System.out.println("Informações correta? (S/N) ");
        System.out.print("Resposta: ");
        String resp = entrada.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Sala novaSala = new Sala(codigoSala, nome_sala, local_sala, capacidadeTotalDaSala);
            lista_de_salas.add(novaSala);
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    public static void exibirListaSalas(List<Sala> lista_de_salas) {
        System.out.println("Lista de salas: ");
        for (Sala sala : lista_de_salas) {
            System.out.println(sala);
            wait(1600);
        }
    }

    public static void cadastrarCurso(List<Curso> lista_de_cursos, Scanner SCANNER) {
        separador();
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
        separador();
        System.out.println("Código do curso: " + codigo_curso);
        System.out.println("Nome do curso: " + nome_curso);
        System.out.println("Carga horária do curso: " + carga_horaria);
        System.out.println("Descrição do curso " + descricao);
        System.out.println("Informações corretas? (S/N)");
        String resp = SCANNER.next().substring(0, 1).toUpperCase();
        if (resp.equals("S")){
            Curso curso = new Curso(codigo_curso, nome_curso, carga_horaria, descricao);
            lista_de_cursos.add(curso);
        }
        else {
            System.out.println("Operação cancelada...");
        }
    }

    public static void exibirListaCursos(List<Curso> lista_de_cursos) {
        System.out.println("Lista de cursos: ");
        for (Curso curso : lista_de_cursos) {
            System.out.println(curso);
            wait(1600);
        }
    }

    public static void cadastrarTurma(List<Sala> lista_de_salas, List<Curso> lista_de_cursos, Scanner entrada)
    {
        System.out.println("Cadastrar turma: ");
        System.out.print("Nome da turma: ");
        int numeroTurma = entrada.nextInt();
        Turma turma = new Turma();
        System.out.println("""
                    1 = Criar uma nova sala
                    2 = Anexar as disponíveis?
                    """);
        wait(1000);
        while (true)
        {
            int resposta_de_anexo_ou_criacao = entrada.nextInt();
            if (resposta_de_anexo_ou_criacao == 1){
                cadastrarSala(lista_de_salas, entrada);
            }
            else if (resposta_de_anexo_ou_criacao == 2){
                System.out.println("Salas disponíveis: (se o valor estiver vazio é porque não existe nenhuma sala criada)");
                exibirListaSalas(lista_de_salas);
            }
            else {
                System.out.println("Por favor digite uma opção válida...");
                continue;
            }
            DiaSemana cronograma = null;
            exibirDiaSemana();
            int resp = entrada.nextInt();
            switch (resp) {
                case 1 -> turma.adicionar_dia(DiaSemana.SEGUNDA, resp);
                case 2 -> turma.adicionar_dia(DiaSemana.TERCA, resp);
                case 3 -> turma.adicionar_dia(DiaSemana.QUARTA, resp);
                case 4 -> turma.adicionar_dia(DiaSemana.QUINTA, resp);
                case 5 -> turma.adicionar_dia(DiaSemana.SEXTA, resp);
                default -> System.out.println("Por favor digite uma resposta válida...");
            }

            System.out.println("Anexar turma a mais um dia da semana? (S/N) ");
            String cadastroMais = entrada.next().substring(0, 1).toUpperCase();
            if (cadastroMais.equals("N")){
                break;
            }
        }

    }

    public static void cadastrarProfessor(Scanner entrada, List<Professor> lista_de_professores) {
        separador();
        System.out.println("Cadastrar novo professor: ");

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
        System.out.println("Lista de professores: ");
        for (Professor professor : lista_de_professores){
            System.out.println(professor);
            wait(1600);
        }
    }

    public static List<String> cadastrarPessoa(Scanner SCANNER) {
        System.out.print("Nome: ");
        String nome = SCANNER.nextLine();

        System.out.print("CPF: ");
        String _CPF = SCANNER.next();

        System.out.print("Endereço: ");
        SCANNER.nextLine();
        String endereco = SCANNER.nextLine();

        System.out.print("Email: ");
        String email = SCANNER.next();

        System.out.print("Celular: ");
        String celular = SCANNER.next();

        return Arrays.asList(_CPF, nome, endereco, email, celular);
    }

    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}