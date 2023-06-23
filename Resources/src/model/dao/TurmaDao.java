package model.dao;

import model.entities.Turma;

public interface TurmaDao
{
    void inserirTurma(Turma turma);
    void apagarTurmaPorId(Integer ID);
    void atualizarTurma(Turma turma);
    void buscarTurmaPorId(Integer Id);
    void buscarTodasTurmas();
}