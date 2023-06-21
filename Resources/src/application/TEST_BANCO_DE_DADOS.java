package application;

import model.dao.DaoFactory;
import model.dao.TurmaDao;
import model.dao.impl.TurmaDaoJDBC;
import model.entities.Turma;

public class TEST_BANCO_DE_DADOS
{
    public static void main(String[] args)
    {
//        System.out.println("TEST DE INSERÇÃO DE TURMA NO BANCO DE DADOS");
        TurmaDao turmaDao = DaoFactory.criaTurmaDao();
//        Turma turma = new Turma("Sei lá");
//        turmaDao.insere(turma);

//        System.out.println("TEST DE ATUALIZAÇÃO DE TURMA NO BANCO DE DADOS");
        Turma turma = new Turma("Direito");
//        turma.setCodigo_turma(2);
//        turmaDao.atualiza(turma);

        System.out.println("TEST DE DELEÇÃO DE TURMA NO BANCO DE DADOS");
        turmaDao.deletaPorId(3);
        turmaDao.deletaPorId(4);

        System.out.println("TEST DE BUSCA POR ID");
        Turma turma_busca = turmaDao.buscaPorId(2);
        System.out.println(turma_busca);


        System.out.println("TEST DE BUSCAR TODOS");
        turmaDao.buscaTodos();

    }
}
