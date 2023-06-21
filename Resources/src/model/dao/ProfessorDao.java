package model.dao;

import model.entities.Professor;

public interface ProfessorDao
{
    void inserirProfessor(Professor professor);
    void apagarProfessor(Professor professor);
    void atualizarProfessor(Professor professor);
    void buscarProfessorPorId(Integer Id);
    void buscarTodosOsProfessores();
}