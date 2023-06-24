package model.dao;

import model.entities.Professor;

public interface ProfessorDao
{
    void inserirProfessor(Professor professor);
    void apagarProfessorPorId(Integer ID);
    void atualizarProfessor(Professor professor);
    void buscarProfessorPorId(Integer ID);
    Professor buscarProfessorPorIdTransformarEmObjProfessor(Integer ID);
    void buscarTodosOsProfessores();
}