package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;

import java.sql.*;
import java.util.Scanner;

public class AlunoDaoJDBC implements AlunoDao
{
    private Connection connection = null;

    public AlunoDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserirAluno(Aluno aluno)
    {
        if (connection != null){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO faculdade.aluno (nome, endereco, celular, email, cpf, ID_curso)" +
                        " VALUES (?, ?, ?, ?, ?, ?);"
                        , Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getEndereco());
                preparedStatement.setString(3, aluno.getCelular());
                preparedStatement.setString(4, aluno.getEmail());
                preparedStatement.setString(5, aluno.getCpf());
                int linhas_afetadas = 0;

                preparedStatement.setObject(6, aluno.se_existir_o_curso_retorna_id_ou_null());

                linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        aluno.setId_Matricula(ID);
                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção de aluno no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir aluno! ");
                }
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível inserir dados com a conexão nula...");
        }
    }

    @Override
    public void apagarAlunoPorId(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.aluno WHERE ID_matricula = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Aluno apagado com sucesso...");
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
    public void atualizarAluno(Aluno aluno)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.aluno " +
                        "SET nome = ?, endereco = ?, celular = ?, email = ?, cpf = ?,  ID_curso = ? " +
                        "WHERE ID_matricula = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, aluno.getNome());
                preparedStatement.setString(2, aluno.getEndereco());
                preparedStatement.setString(3, aluno.getCelular());
                preparedStatement.setString(4, aluno.getEmail());
                preparedStatement.setString(5, aluno.getCpf());
                preparedStatement.setObject(6, aluno.se_existir_o_curso_retorna_id_ou_null());
                preparedStatement.setInt(7, aluno.getId_Matricula());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Aluno atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar aluno...");
                }

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível atualizar dados com a conexão nula...");
        }
    }

    @Override
    public void buscarAlunoPorId(Integer ID)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.aluno where ID_matricula = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
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
                else {
                    System.out.println("Nenhum registro encontrado...");
                }
                DB.fechaResultSet(resultSet);

            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível buscar dado com a conexão nula...");
        }
    }

    @Override
    public void buscarTodosAlunos()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.aluno;"
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
                DB.fechaResultSet(resultSet);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível buscar dados com a conexão nula...");
        }
    }
}