package application.testes;

import model.dao.CursoDao;
import model.dao.DaoFactory;
import model.entities.Curso;

public class teste_CursoDao
{
    public static void main(String[] args)
    {
        System.out.println("Teste 1 Inserção do curso no BD");
        Curso curso = new Curso("Curso de direito", 10, "Curso de autonomia profissional blablabla");
        CursoDao cursoDao = DaoFactory.criaCursoDao();
        cursoDao.inserirCurso(curso);

        System.out.println("Teste 2 Apagar com base no ID no BD");
//        cursoDao.apagarCursoPorID(1);

        System.out.println("Teste 3 Atualizar curso");
        curso.setNomeCurso("Curso de direito constitucional");
        curso.setId_Curso(2);
        cursoDao.atualizarCurso(curso);

        System.out.println("Teste 4 Procura curso por ID ");
        cursoDao.buscarCursoPorId(3);

        System.out.println("Teste 5 Procura todas os cursos");
        cursoDao.buscarTodosCursos();
    }
}
