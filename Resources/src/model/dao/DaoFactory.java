package model.dao;

import db.DB;
import model.dao.impl.*;

public class DaoFactory {
    public static AlunoDao criaAlunoDao() {
        return new AlunoDaoJDBC(DB.pegaConexao());
    }

    public static AulaDao criaAulaDao(){
        return new AulaDaoJDBC(DB.pegaConexao());
    }

    public static CursoDao criaCursoDao() {
        return new CursoDaoJDBC(DB.pegaConexao());
    }

    public static ProfessorDao criaProfessorDao() {
        return new ProfessorDaoJDBC(DB.pegaConexao());
    }

//    public static SalaDao criaSalaDao() {
//        return new SalaDaoJDBC(DB.pegaConexao());
//    }

    public static TurmaDao criaTurmaDao(){return new TurmaDaoJDBC(DB.pegaConexao());}
}
