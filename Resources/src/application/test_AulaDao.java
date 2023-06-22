package application;

import model.dao.AulaDao;
import model.dao.DaoFactory;
import model.dao.impl.AulaDaoJDBC;
import model.entities.Aula;

public class test_AulaDao
{
    public static void main(String[] args)
    {
        System.out.println("Test 1 - Inserção de Aula no BD");
        AulaDao aulaDao = DaoFactory.criaAulaDao();
        Aula aula = new Aula();
        aula.setDiaSemana("Segunda");
        aula.setNomeAula("Educação Financeira");
        aulaDao.inserirAula(aula);

        System.out.println("Test 2 - Apagar aula por ID");
        aulaDao.apagarAulaPorId(1);

        System.out.println("Test 3 - Atualizar aula");
        aula.setIdAula(2);
        aula.setNomeAula("Educação financeira aplicada");
        aulaDao.atualizarAula(aula);

        System.out.println("Test 4 - Buscar aula por ID");
        aulaDao.buscarAulaPorId(3);

        System.out.println("Test 5 - Buscar todas as aulas por ID");
        aulaDao.buscarTodosAulas();
    }
}
