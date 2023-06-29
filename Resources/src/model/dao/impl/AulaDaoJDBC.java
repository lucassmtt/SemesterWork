package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.AulaDao;
import model.entities.Aula;
import model.entities.Sala;
import model.entities.Turma;
import model.tools.Exibir;

import java.sql.*;
import java.util.ArrayList;

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
                String sql = "INSERT INTO faculdade.aula (nome_aula, ID_sala, ID_turma, dia_semana) " +
                        "VALUES (?, ?, ?, ?);";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setObject(1, aula.se_existir_nome_retorna_nome_ou_null());
                preparedStatement.setObject(2, aula.se_existir_a_sala_retorna_id_ou_null());
                preparedStatement.setObject(3, aula.se_existir_a_turma_retorna_id_ou_null());
                preparedStatement.setObject(4, aula.se_existir_a_dia_semana_retorna_dia_ou_null());

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
                        "SET nome_aula = ?, ID_sala = ?, ID_turma = ?, dia_semana = ?" +
                        "WHERE ID_aula = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setObject(1, aula.se_existir_nome_retorna_nome_ou_null());
                preparedStatement.setObject(2, aula.se_existir_a_sala_retorna_id_ou_null());
                preparedStatement.setObject(3, aula.se_existir_a_turma_retorna_id_ou_null());
                preparedStatement.setObject(4, aula.se_existir_a_dia_semana_retorna_dia_ou_null());
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

                if (resultSet.next()) {
                    System.out.println("_____________________________");
                    System.out.println("ID Aula: " + resultSet.getInt(1));
                    Object nome_aula = resultSet.getObject(2);
                    Object ID_sala = resultSet.getObject(3);
                    Object ID_turma = resultSet.getObject(4);
                    Object dia_semana = resultSet.getObject(5);

                    if (nome_aula == null) {
                        System.out.println("Não existe nenhum nome para esta sala...");
                    } else {
                        System.out.println("Nome aula: " + nome_aula);
                    }

                    if (ID_sala == null) {
                        System.out.println("Não existe nenhuma sala anexada a aula...");
                    } else {
                        System.out.println("ID sala: " + ID_sala);
                    }

                    if (ID_turma == null) {
                        System.out.println("Não existe nenhuma turma anexada a sala...");
                    }
                    else {
                        System.out.println("ID turma: " + ID_turma);
                    }

                    if (dia_semana == null) {
                        System.out.println("A aula não está anexada a nenhum dia da semana...");
                    } else {
                        System.out.println("Dias de aula: " + dia_semana);
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
    public Aula buscarAulaPorIdTransformarEmObjAula(Integer ID)
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
                    Object nome_aula = resultSet.getObject(2);
                    Object ID_sala = resultSet.getObject(3);
                    Object ID_turma = resultSet.getObject(4);
                    Object dia_semana = resultSet.getObject(5);

                    Aula aula = new Aula();

                    if (nome_aula == null){
                        aula.setNomeAula(null);
                    }
                    else {
                        aula.setNomeAula((String) nome_aula);
                    }

                    if (ID_sala == null){
                        aula.setSala(null);
                    }
                    else {
                        Sala sala = new Sala();
                        sala.setId_Sala((Integer) ID_sala);
                        aula.setSala(sala);
                    }

                    if (ID_turma == null){
                        aula.setTurma(null);
                    }
                    else {
                        Turma turma = new Turma();
                        turma.setId_Turma((Integer) ID_turma);
                        aula.setTurma(turma);
                    }

                    if (dia_semana == null){
                        aula.setDiaSemana(null);
                    }
                    else {
                        aula.setDiaSemana((String) dia_semana);
                    }
                }
                else {
                    return null;
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
        return null;
    }

    @Override
    public void buscarTodasAulas()
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

                    System.out.println("______________________________________");
                    System.out.println("ID Aula: " + resultSet.getInt(1));
                    nome_aula = resultSet.getObject(2);
                    ID_sala = resultSet.getObject(3);
                    ID_turma = resultSet.getObject(4);
                    dia_semana = resultSet.getObject(5);

                    if (nome_aula == null) {
                        System.out.println("Não existe nenhum nome para esta sala...");
                    } else {
                        System.out.println("Nome aula: " + nome_aula);
                    }

                    if (ID_sala == null) {
                        System.out.println("Não existe nenhuma sala anexada a aula...");
                    } else {
                        System.out.println("ID sala: " + ID_sala);
                    }

                    if (ID_turma == null) {
                        System.out.println("Não existe nenhuma turma anexada a sala...");
                    }
                    else {
                        System.out.println("ID turma: " + ID_turma);
                    }

                    if (dia_semana == null) {
                        System.out.println("A aula não está anexada a nenhum dia da semana...");
                    } else {
                        System.out.println("Dias de aula: " + dia_semana);
                    }
                    Exibir.espera_em_ms(500);
                }
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaResultSet(resultSet);
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Impossível buscar dados com a conexão nula...");
        }

    }

    @Override
    public boolean verSeTemAulaEmDiaEspecifico(Integer ID_aula, String diaSemana)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM faculdade.aula WHERE ID_aula = ?");
                preparedStatement.setInt(1, ID_aula);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next())
                {
                    String dia_semana = resultSet.getString(5);
                    return dia_semana.contains(diaSemana);
                }
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaResultSet(resultSet);
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Não podemos consultar o banco de dados com uma conexão nula...");
        }
        return false;
    }

    @Override
    public boolean verSeTemSalaCadastradaAulaEmQueDia(Integer ID_sala, String diaSemana)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM faculdade.aula WHERE ID_sala = ?");
                preparedStatement.setInt(1, ID_sala);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    String dia_semana = resultSet.getString(5);
                    if (dia_semana.contains(diaSemana)){
                        return true;
                    }
                }
                return false;
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaResultSet(resultSet);
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Não podemos consultar o banco de dados com uma conexão nula...");
        }
        return true;
    }

    @Override
    public boolean verSeTemTurmaCadastradaEmUmDiaEspecifico(Integer ID_turma, String diaSemana)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM faculdade.aula WHERE ID_turma = ?");
                preparedStatement.setInt(1, ID_turma);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    String dia = resultSet.getString(5);
                    if (dia.contains(diaSemana)){
                        return true;
                    }
                }
                return false;
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaResultSet(resultSet);
                DB.fechaStatement(preparedStatement);
            }
        }
        else {
            System.out.println("Não podemos consultar o banco de dados com uma conexão nula...");
        }
        return true;
    }
}
