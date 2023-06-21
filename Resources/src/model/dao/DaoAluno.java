package model.dao;

import model.entities.Aluno;

import java.util.List;

public interface DaoAluno
{
    // Interface que estabelece os contratos a serem implementados

    void insere(Aluno obj);
    void atualiza(Aluno obj);
    void deletaPorId(Integer id);
    Aluno buscaPorId(Integer id);
    List<Aluno> findAll();
}
