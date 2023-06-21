package model.dao;

import model.entities.Sala;

import java.util.List;

public interface SalaDao
{
    // Interface que estabelece os contratos a serem implementados

    void insere(Sala obj);
    void atualiza(Sala obj);
    void deletaPorId(Integer id);
    Sala buscaPorId(Integer id);
    List<Sala> buscaTodos();
}
