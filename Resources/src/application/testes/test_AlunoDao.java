package application.testes;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class test_AlunoDao {
    public static void main(String[] args) {
        System.out.println("-- 1 TEST -- INSERIR ");
        Aluno aluno = new Aluno("022.561.809-56", "Lucas Gabriel Motta",
                "Rua das cegonhas 229", "motta@gmail.com", "4799999999");

        Aluno aluno_2 = new Aluno("022.561.809-56", "Lucas Gabriel Motta",
                "Rua das cegonhas 229", "motta@gmail.com", "4799999999");

        AlunoDao alunoDao = DaoFactory.criaAlunoDao();
        alunoDao.inserirAluno(aluno);
        alunoDao.inserirAluno(aluno_2);
        System.out.println("Aluno inserido com sucesso");


        System.out.println("-- 2 TEST -- APAGAR ALUNO COM BASE NO ID ");
        alunoDao.apagarAlunoPorId(1);

        System.out.println("-- 3 TEST -- ATUALIZAR ALUNO ");
        Aluno alunoParaAtualizar = aluno;
        alunoParaAtualizar.setId_Matricula(3);
        alunoParaAtualizar.setEmail("motttttttttta@gmail.com");
        alunoDao.atualizarAluno(alunoParaAtualizar);

        System.out.println("-- 4 TEST -- PROCURA ALUNO POR ID ");
        alunoDao.buscarAlunoPorId(5);

        System.out.println("-- 5 TEST -- PROCURA TODOS OS ALUNOS");
        alunoDao.buscarTodosAlunos();

    }

}
