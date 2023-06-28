package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SalaDao;
import model.entities.Sala;
import model.tools.Exibir;

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
                        "INSERT INTO faculdade.sala (nomeSala, local, capacidade)" +
                        " VALUES (?, ?, ?);"
                        , Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, sala.getNomeSala());
                preparedStatement.setString(2, sala.getLocalSala());
                preparedStatement.setInt(3, sala.getCapacidadeSala());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        sala.setId_Sala(ID);
                    }
                    System.out.println("Inserção de sala no banco de dados feita com sucesso...");
                    DB.fechaResultSet(resultSet);
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
    public void apagarSalaPorID(Integer ID)
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
                        "SET nomeSala = ?, local = ?, capacidade = ? " +
                        "WHERE ID_sala = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, sala.getNomeSala());
                preparedStatement.setString(2, sala.getLocalSala());
                preparedStatement.setInt(3, sala.getCapacidadeSala());
                preparedStatement.setInt(4, sala.getId_Sala());

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
    public void buscarSalaPorId(Integer ID)
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

                if (resultSet.next()){
                    System.out.println("ID Sala: " + resultSet.getInt(1) + "\n" +
                            "Nome sala: " + resultSet.getString(2) + "\n" +
                            "Local: " + resultSet.getString(3) + "\n" +
                            "Capacidade:  " + resultSet.getInt(4)
                    );
                }

                else {
                    System.out.println("Nenhum registro encontrado...");
                }
                DB.fechaResultSet(resultSet);
                }

            catch (Exception e){
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
    public Sala buscarSalaPorIdTransformarEmOBjSala(Integer Id)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.sala where ID_sala = ?;"
                );
                preparedStatement.setInt(1, Id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    Sala sala = new Sala();
                    sala.setNomeSala(resultSet.getString(2));
                    sala.setCapacidadeSala(resultSet.getInt(4));
                    sala.setLocalSala(resultSet.getString(3));
                    sala.setId_Sala(resultSet.getInt(1) );
                    return sala;
                }

                else {
                    System.out.println("Nenhum registro encontrado...");
                }
                DB.fechaResultSet(resultSet);
            }

            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }

        else {
            System.out.println("Impossível buscar dado com a conexão nula...");
        }
        return null;
    }

    @Override
    public void buscarTodasSalas()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.sala;"
                );
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    System.out.println("______________________________________");
                    System.out.println("ID Sala: " + resultSet.getInt(1) + "\n" +
                            "Nome sala: " + resultSet.getString(2) + "\n" +
                            "Local: " + resultSet.getString(3) + "\n" +
                            "Capacidade:  " + resultSet.getObject(4)
                    );
                    Exibir.espera_em_ms(500);
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
