package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.ProfessorDao;
import model.entities.Professor;

import java.sql.*;

public class ProfessorDaoJDBC implements ProfessorDao
{
    public Connection connection = null;

    public ProfessorDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void inserirProfessor(Professor professor)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO faculdade.professor (nome, endereco, celular, email, cpf, ID_curso) " +
                              "VALUES (?, ?, ?, ?, ?, ?) "
                        , Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, professor.getNome());
                preparedStatement.setString(2, professor.getEndereco());
                preparedStatement.setString(3, professor.getCelular());
                preparedStatement.setString(4, professor.getEmail());
                preparedStatement.setString(5, professor.getCpf());
                preparedStatement.setObject(6, professor.se_existir_o_curso_retorna_id_ou_null());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        professor.setId_Professor(ID);
                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção de professor no banco de dados feita com sucesso...");
                }
                else {
                    throw new DbException("Unexpected error! No rows affect!");
                }
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }

    }

    @Override
    public void apagarProfessorPorId(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.professor WHERE ID_professor = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Professor apagado com sucesso...");
                }
                else {
                    System.out.println("Deleção incompleta...");
                }
            }
            catch (SQLException e)
            {
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível apagar dados com a conexão nula...");
        }

    }

    @Override
    public void atualizarProfessor(Professor professor)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.professor " +
                        "SET nome = ?, endereco = ?, celular = ?, email = ?, cpf = ?,  ID_curso = ? " +
                        "WHERE ID_professor = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, professor.getNome());
                preparedStatement.setString(2, professor.getEndereco());
                preparedStatement.setString(3, professor.getCelular());
                preparedStatement.setString(4, professor.getEmail());
                preparedStatement.setString(5, professor.getCpf());
                preparedStatement.setObject(6, professor.se_existir_o_curso_retorna_id_ou_null());
                preparedStatement.setInt(7, professor.getId_Professor());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Professor atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar professor...");
                }

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }

    }

    @Override
    public void buscarProfessorPorId(Integer ID)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.professor where ID_professor = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("_______________________________");
                    System.out.println(
                            "Matricula: " + resultSet.getInt(1) + "\n" +
                            "Nome: " + resultSet.getString(2) + "\n" +
                            "Endereço: " + resultSet.getString(3) + "\n" +
                            "Celular: " + resultSet.getString(4) + "\n" +
                            "Email: " + resultSet.getString(5) + "\n" +
                            "Cpf: " + resultSet.getString(6)
                    );
                    if (resultSet.getObject(7) == null) {
                        System.out.println("Curso: Nenhum curso matriculado");
                    } else {
                        System.out.println("Curso ID: " + resultSet.getInt(7));
                    }

                } else {
                    System.out.println("Nenhum registro encontrado...");
                }

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            } finally {
                DB.fechaStatement(preparedStatement);
                DB.fechaResultSet(resultSet);
            }
        }
    }

    @Override
    public void buscarTodosOsProfessores()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.professor;"
                );
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    System.out.println("_______________________________");
                    System.out.println(
                            "Matricula: " + resultSet.getInt(1) + "\n" +
                                    "Nome: " + resultSet.getString(2) + "\n" +
                                    "Endereço: " + resultSet.getString(3) + "\n" +
                                    "Celular: " + resultSet.getString(4) + "\n" +
                                    "Email: " + resultSet.getString(5) + "\n" +
                                    "Cpf: " + resultSet.getString(6)
                    );
                    if (resultSet.getObject(7) == null){
                        System.out.println("Curso: Nenhum curso matriculado");
                    }
                    else{
                        System.out.println("Curso ID: " + resultSet.getInt(7));
                    }
                }
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
                DB.fechaResultSet(resultSet);
            }
        }
        else{
            System.out.println("Impossível realizar operações com a conexão nula.");
        }

    }
}