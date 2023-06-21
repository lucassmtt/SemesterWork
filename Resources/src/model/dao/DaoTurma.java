package model.dao;

import model.entities.Turma;

import java.util.List;

public interface DaoTurma
{
    void insere(Turma obj);
    void atualiza(Turma obj);
    void deletaPorId(Integer id);
    Turma buscaPorId(Integer id);
    List<Turma> findAll();
}