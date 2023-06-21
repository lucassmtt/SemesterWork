package model.dao.impl;

import model.dao.SalaDao;
import model.entities.Sala;

import java.sql.Connection;
import java.util.List;

public class SalaDaoJDBC implements SalaDao
{
    private Connection connection = null;
    public SalaDaoJDBC(Connection connection)
    {
        this.connection = connection;
    }
    @Override
    public void insere(Sala obj) {

    }

    @Override
    public void atualiza(Sala obj) {

    }

    @Override
    public void deletaPorId(Integer id) {

    }

    @Override
    public Sala buscaPorId(Integer id) {
        return null;
    }

    @Override
    public List<Sala> buscaTodos() {
        return null;
    }
}
