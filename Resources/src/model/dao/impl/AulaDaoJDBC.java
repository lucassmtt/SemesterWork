package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.AulaDao;
import model.entities.Aula;

import javax.print.attribute.standard.JobKOctets;
import java.sql.*;

public class AulaDaoJDBC implements AulaDao
{
    private Connection connection = null;

    public AulaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserirAula(Aula aula)
    {
        if (connection != null){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                String sql = "INSERT INTO faculdade.aula (ID_sala, ID_turma, dia_semana, nome_aula) " +
                        "VALUES (?, ?, ?, ?);";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setObject(1, aula.se_existir_a_sala_retorna_id_ou_null());
                preparedStatement.setObject(2, aula.se_existir_a_turma_retorna_id_ou_null());
                preparedStatement.setObject(3, aula.se_existir_a_dia_semana_retorna_dia_ou_null());
                preparedStatement.setObject(4, aula.se_existir_nome_retorna_nome_ou_null());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        aula.setIdAula(ID);
                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção da aula no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir aula! ");
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
    public void apagarAulaPorId(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.aula WHERE ID_aula = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Aula apagada com sucesso...");
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
    public void atualizarAula(Aula aula)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.aula " +
                        "SET ID_sala = ?, ID_turma = ?, dia_semana = ?, nome_aula = ? " +
                        "WHERE ID_aula = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setObject(1, aula.se_existir_a_sala_retorna_id_ou_null());
                preparedStatement.setObject(2, aula.se_existir_a_turma_retorna_id_ou_null());
                preparedStatement.setObject(3, aula.se_existir_a_dia_semana_retorna_dia_ou_null());
                preparedStatement.setObject(4, aula.se_existir_nome_retorna_nome_ou_null());
                preparedStatement.setInt(5, aula.getIdAula());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Aula atualizada com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar aula...");
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
    public void buscarAulaPorId(Integer ID)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.aula where ID_aula = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    System.out.println("_____________________________");
                    System.out.println("ID Aula: " + resultSet.getInt(1));
                    Object ID_sala = resultSet.getObject(2);
                    Object ID_turma = resultSet.getObject(3);
                    Object dia_semana = resultSet.getObject(4);
                    Object nome_aula = resultSet.getObject(5);
                    if (ID_sala == null){
                        System.out.println("Não existe nenhuma sala anexada a aula...");
                    }
                    else {
                        System.out.println("ID sala anexado a aula: " + ID_sala);
                    }

                    if (ID_turma == null){
                        System.out.println("Não existe nenhuma turma anexada a aula...");
                    }
                    else {
                        System.out.println("ID turma anexado a aula: " + ID_turma);
                    }

                    if (dia_semana == null){
                        System.out.println("Não existe nenhum dia anexado a aula...");
                    }
                    else {
                        System.out.println("Dia da semana: " + dia_semana);
                    }

                    if (nome_aula == null){
                        System.out.println("Não existe nenhum nome anexada a aula...");
                    }
                    else {
                        System.out.println("Nome da aula: " + nome_aula);
                    }
                    DB.fechaResultSet(resultSet);
                }
                else {
                    System.out.println("Nenhum registro encontrado...");
                }

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
    public void buscarTodosAulas()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.aula;"
                );
                resultSet = preparedStatement.executeQuery();
                Object ID_sala, ID_turma, dia_semana, nome_aula;
                while (resultSet.next()){
                    System.out.println("_____________________________");
                    System.out.println("ID Aula: " + resultSet.getInt(1));
                    ID_sala = resultSet.getObject(2);
                    ID_turma = resultSet.getObject(3);
                    dia_semana = resultSet.getObject(4);
                    nome_aula = resultSet.getObject(5);
                    if (ID_sala == null){
                        System.out.println("Não existe nenhuma sala anexada a aula...");
                    }
                    else {
                        System.out.println("ID sala anexado a aula: " + ID_sala);
                    }

                    if (ID_turma == null){
                        System.out.println("Não existe nenhuma turma anexada a aula...");
                    }
                    else {
                        System.out.println("ID turma anexado a aula: " + ID_turma);
                    }

                    if (dia_semana == null){
                        System.out.println("Não existe nenhum dia anexado a aula...");
                    }
                    else {
                        System.out.println("Dia da semana: " + dia_semana);
                    }

                    if (nome_aula == null){
                        System.out.println("Não existe nenhum nome anexada a aula...");
                    }
                    else {
                        System.out.println("Nome da aula: " + nome_aula);
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
