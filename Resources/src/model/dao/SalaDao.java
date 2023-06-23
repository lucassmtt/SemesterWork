package model.dao;

import model.entities.Sala;

public interface SalaDao
{
    void inserirSala(Sala sala);
    void apagarSalaPorID(Integer ID);
    void atualizarSala(Sala sala);
    void buscarSalaPorId(Integer Id);
    void buscarTodasSalas();
}