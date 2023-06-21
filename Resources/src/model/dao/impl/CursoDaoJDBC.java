package model.dao.impl;

import model.dao.CursoDao;
import model.entities.Curso;

import java.sql.Connection;
import java.util.List;

public class CursoDaoJDBC implements CursoDao
{
    private Connection connection = null;
    public CursoDaoJDBC(Connection connection)
    {
        this.connection = connection;
    }
    @Override
    public void insere(Curso obj) {

    }

    @Override
    public void atualiza(Curso obj) {

    }

    @Override
    public void deletaPorId(Integer id) {

    }

    @Override
    public Curso buscaPorId(Integer id) {
        return null;
    }

    @Override
    public List<Curso> buscaTodos() {
        return null;
    }
}
