package model.dao;

import model.entities.Aula;

public interface AulaDao
{
    void inserirAula(Aula aula);
    void apagarAulaPorId(Integer ID);
    void atualizarAula(Aula aula);
    void buscarAulaPorId(Integer ID);
    void buscarTodosAulas();
}
