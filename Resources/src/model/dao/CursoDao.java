package model.dao;

import model.entities.Curso;

public interface CursoDao
{
    void inserirCurso(Curso curso);
    void apagarCursoPorID(Integer ID);
    void atualizarCurso(Curso curso);
    void buscarCursoPorId(Integer Id);
    Curso buscarCursoPorIdTransformarEmObj(Integer Id);
    void buscarTodosCursos();
}