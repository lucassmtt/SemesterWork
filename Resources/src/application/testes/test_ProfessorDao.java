package application.testes;

import model.dao.DaoFactory;
import model.dao.ProfessorDao;
import model.entities.Professor;

public class test_ProfessorDao
{
    public static void main(String[] args)
    {
        System.out.println("1 Test - Inserção");
        ProfessorDao professorDao = DaoFactory.criaProfessorDao();
        Professor professor = new Professor("000.322.4224-32", "Jose Peçanha",
                "Rua dos Riachos 230", "pecanha@gmail.com", "4799999999");
        professorDao.inserirProfessor(professor);

        System.out.println("2 Test - Apagar Professor Por ID");
        professorDao.apagarProfessorPorId(2);

        System.out.println("3 Test - Atualizar Professor");
        professor.setEmail("pecanha@hotmail.com");
        professor.setId_Professor(4);
        professorDao.atualizarProfessor(professor);

        System.out.println("4 Test - Buscar Professor por ID");
        professorDao.buscarProfessorPorId(8);

        System.out.println("5 Test - Buscar Professor por ID");
        professorDao.buscarTodosOsProfessores();

    }
}
