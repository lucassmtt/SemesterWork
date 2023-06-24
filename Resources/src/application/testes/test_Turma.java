package application.testes;

import model.dao.DaoFactory;
import model.dao.TurmaDao;
import model.entities.Turma;

public class test_Turma
{
    public static void main(String[] args)
    {
        System.out.println("Teste 1 Inserção turma no BD");
        Turma turma = new Turma("Turma de direito");
        TurmaDao turmaDao = DaoFactory.criaTurmaDao();
        turmaDao.inserirTurma(turma);

        System.out.println("Teste 2 Apagar com base no ID no BD");
        turmaDao.apagarTurmaPorId(4);

        System.out.println("Teste 3 Atualizar turma");
        turma.setNomeTurma("Turma de adm");
        turma.setId_Turma(3);
        turmaDao.atualizarTurma(turma);

        System.out.println("Teste 4 Procura turma por ID ");
        turmaDao.buscarTurmaPorId(3);

        System.out.println("Teste 5 Procura todas as turmas");
        turmaDao.buscarTodasTurmas();
    }
}
