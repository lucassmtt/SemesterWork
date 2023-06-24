package application.testes;

import model.dao.AulaDao;
import model.dao.DaoFactory;
import model.dao.SalaDao;
import model.entities.Aula;
import model.entities.Sala;

public class test_SalaDao
{
    public static void main(String[] args)
    {
        System.out.println("1 Teste - Inserção");
        SalaDao salaDao = DaoFactory.criaSalaDao();
        Sala sala = new Sala("Sala A201", "Bloco B", 10);
        salaDao.inserirSala(sala);

        System.out.println("2 Teste - Apagar sala Por ID");
        salaDao.apagarSalaPorID(2);

        System.out.println("3 Teste - Atualizar sala");
        sala.setId_Sala(1);
        sala.setNomeSala("Sala A202");
        salaDao.atualizarSala(sala);

        System.out.println("4 Teste - Buscar aula por ID");
        salaDao.buscarSalaPorId(1);

        System.out.println("5 Teste - Buscar todas aulas");
        salaDao.buscarTodasSalas();
    }
}
