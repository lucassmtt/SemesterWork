package model.dao;

import model.entities.Curso;

public interface CursoDao
{
    void inserirCurso(Curso curso);
    void apagarCurso(Curso curso);
    void atualizarCurso(Curso curso);
    void buscarCursoPorId(Integer Id);
    void buscarTodosCursos();
}