package model.dao.impl;

import model.dao.ProfessorDao;
import model.entities.Professor;

import java.sql.Connection;
import java.util.List;

public class ProfessorDaoJDBC implements ProfessorDao
{
    private Connection connection = null;
    public ProfessorDaoJDBC(Connection connection)
    {
        this.connection = connection;
    }
    @Override
    public void insere(Professor obj) {

    }

    @Override
    public void atualiza(Professor obj) {

    }

    @Override
    public void deletaPorId(Integer id) {

    }

    @Override
    public Professor buscaPorId(Integer id) {
        return null;
    }

    @Override
    public List<Professor> buscaTodos() {
        return null;
    }
}
