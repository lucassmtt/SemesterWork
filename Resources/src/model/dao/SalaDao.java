package model.dao;

import model.entities.Sala;

public interface SalaDao
{
    void inserirSala(Sala sala);
    void apagarSala(Sala sala);
    void atualizarSala(Sala sala);
    void buscarSalaPorId(Integer Id);
    void buscarTodasTurmas();
}