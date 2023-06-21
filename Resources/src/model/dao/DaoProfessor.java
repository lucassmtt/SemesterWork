package model.dao;

import model.entities.Professor;

import java.util.List;

public interface DaoProfessor
{
    void insere(Professor obj);
    void atualiza(Professor obj);
    void deletaPorId(Integer id);
    Professor buscaPorId(Integer id);
    List<Professor> findAll();
}
