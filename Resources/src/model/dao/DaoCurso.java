package model.dao;

import model.entities.Curso;

import java.util.List;

public interface DaoCurso
{
    void insere(Curso obj);
    void atualiza(Curso obj);
    void deletaPorId(Integer id);
    Curso buscaPorId(Integer id);
    List<Curso> findAll();
}
