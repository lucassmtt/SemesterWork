package model.dao;

import model.entities.Professor;

import java.util.List;

public interface ProfessorDao
{
    // Interface que estabelece os contratos a serem implementados

    void insere(Professor obj);
    void atualiza(Professor obj);
    void deletaPorId(Integer id);
    Professor buscaPorId(Integer id);
    List<Professor> buscaTodos();
}
