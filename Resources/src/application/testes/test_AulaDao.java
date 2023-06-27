package application.testes;

import model.dao.AulaDao;
import model.dao.DaoFactory;
import model.entities.Aula;
import model.entities.Turma;

public class test_AulaDao
{
    public static void main(String[] args)
    {
        System.out.println("Test 1 - Inserção de Aula no BD");
        AulaDao aulaDao = DaoFactory.criaAulaDao();
        Aula aula = new Aula();
        aula.setTurma(new Turma("Turma de adm"));
        aula.setDiaSemana("Segunda");
        aula.setNomeAula("Educação Financeira");
        aula.setDiaSemana("Terça");
        aula.setDiaSemana("Terça");
        aulaDao.inserirAula(aula);

        System.out.println("Test 2 - Apagar aula por ID");
        aulaDao.apagarAulaPorId(1);

        System.out.println("Test 3 - Atualizar aula");
        aula.setIdAula(2);
        aula.setNomeAula("Educação financeira aplicada");
        aulaDao.atualizarAula(aula);

        System.out.println("Test 4 - Buscar aula por ID");
        aulaDao.buscarAulaPorId(3);

        System.out.println("Test 5 - Buscar todas as aulas");
        aulaDao.buscarTodosAulas();
    }
}
