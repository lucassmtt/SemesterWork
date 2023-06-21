package model.dao.impl;

import model.dao.AlunoDao;
import model.entities.Aluno;

import java.sql.Connection;
import java.util.List;

public class AlunoDaoJDBC implements AlunoDao
{
    private Connection connection = null;
    public AlunoDaoJDBC(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void insere(Aluno obj) {

    }

    @Override
    public void atualiza(Aluno obj) {

    }

    @Override
    public void deletaPorId(Integer id) {

    }

    @Override
    public Aluno buscaPorId(Integer id) {
        return null;
    }

    @Override
    public List<Aluno> buscaTodos() {
        return null;
    }
}
