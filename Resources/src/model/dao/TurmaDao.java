package model.dao;

import model.entities.Turma;

import java.util.List;

public interface TurmaDao
{
    // Interface que estabelece os contratos a serem implementados

    void insere(Turma obj);
    void atualiza(Turma obj);
    void deletaPorId(Integer id);
    Turma buscaPorId(Integer id);
    void buscaTodos();
}