package model.dao;

import model.entities.Sala;

import java.util.List;

public interface DaoSala
{
    void insere(Sala obj);
    void atualiza(Sala obj);
    void deletaPorId(Integer id);
    Sala buscaPorId(Integer id);
    List<Sala> findAll();
}
