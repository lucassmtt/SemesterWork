package model.dao;

import model.entities.Aluno;

public interface AlunoDao
{
    void inserirAluno(Aluno aluno);
    void apagarAlunoPorId(Integer Id);

    void atualizarAluno(Aluno aluno);
    void buscarAlunoPorId(Integer id);
    Aluno buscarAlunoPorIdTransformaEmAluno(Integer id);
    void buscarTodosAlunos();
}