package model.dao;

import model.entities.Turma;

public interface TurmaDao
{
    void inserirTurma(Turma turma);
    void apagarTurma(Turma turma);
    void atualizarTurma(Turma turma);
    void buscarTurmaPorId(Integer Id);
    void buscarTodasTurmas();
}