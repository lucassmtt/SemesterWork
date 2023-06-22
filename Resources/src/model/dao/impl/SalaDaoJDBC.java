package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SalaDao;
import model.entities.Sala;

import java.sql.*;
import java.util.Scanner;

public class SalaDaoJDBC implements SalaDao
{
    private Connection connection = null;

    public SalaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserirSala(Sala sala)
    {
        if (connection != null){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO faculdade.sala ()" +
                        " VALUES ();"
                        , Statement.RETURN_GENERATED_KEYS);

                int linhas_afetadas = 0;

                linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        sala.(ID);
                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção de sala no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir sala! ");
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
    public void apagarSalaPorId(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.sala WHERE ID_sala = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Sala apagado com sucesso...");
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
            System.out.println("Impossível apagar sala com a conexão nula...");
        }
    }

    @Override
    public void atualizarSala(Sala sala)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.sala " +
                        "SET  " +
                        "WHERE ID_sala = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Sala atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar sala...");
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
                        "SELECT * FROM faculdade.sala where ID_sala = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();

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
    public void buscarTodosCursos()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.curso;"
                );
                resultSet = preparedStatement.executeQuery();

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
