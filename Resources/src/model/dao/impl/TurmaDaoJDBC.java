package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.TurmaDao;
import model.entities.Curso;
import model.entities.Sala;
import model.entities.Turma;
import model.tools.Exibir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TurmaDaoJDBC implements TurmaDao
{
    private Connection connection = null;

    public TurmaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserirTurma(Turma turma)
    {
        if (connection != null){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO faculdade.turma (nomeTurma, ID_curso)" +
                        " VALUES (?, ?, ?);"
                        , Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, turma.getNomeTurma());
                preparedStatement.setObject(2, turma.se_existir_o_curso_retorna_id_ou_null());

                int linhas_afetadas = 0;

                linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        turma.setId_Turma(ID);
                    }
                    System.out.println("Inserção de turma no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir turma! ");
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
    public void apagarTurmaPorId(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.turma WHERE ID_turma = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Turma apagado com sucesso...");
                }
                else {
                    System.out.println("Deleção incompleta...");
                }
            }
            catch (Exception e)
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
    public void atualizarTurma(Turma turma)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.turma " +
                        "SET nomeTurma = ?, ID_curso = ? " +
                        "WHERE ID_turma = ?;";

                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, turma.se_existir_o_nome_retorna_nome_ou_null());
                preparedStatement.setObject(2, turma.se_existir_o_curso_retorna_id_ou_null());
                preparedStatement.setObject(3, turma.getId_Turma());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Turma atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar turma...");
                }

            } catch (Exception e) {
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
    public void buscarTurmaPorId(Integer ID)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.turma where ID_turma = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();


                if (resultSet.next()){
                    System.out.println("______________________________");
                    Object curso = resultSet.getObject(3);
                    System.out.println("ID turma: " + resultSet.getInt(1));
                    System.out.println("Nome da turma: " + resultSet.getString(2));
                    if (curso == null){
                        System.out.println("Curso: sem curso anexado\n" );
                    }
                }
                else {
                    System.out.println("Nenhum registro encontrado...");
                }

            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
                DB.fechaResultSet(resultSet);
            }
        }
        else {
            System.out.println("Impossível buscar dado com a conexão nula...");
        }
    }

    @Override
    public Turma buscarTurmaPorIdTransformaEmObjTurma(Integer Id)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.turma where ID_turma = ?;"
                );
                preparedStatement.setInt(1, Id);
                resultSet = preparedStatement.executeQuery();


                if (resultSet.next()){
                    int id_turma = resultSet.getInt(1);
                    String nome_turma = resultSet.getString(2);
                    Turma turma = new Turma();
                    Curso curso = null;

                    if (resultSet.getObject(3) != null){
                        curso = DaoFactory.criaCursoDao().buscarCursoPorIdTransformarEmObj((Integer) resultSet.getObject(3));
                    }

                    turma.setCurso(curso);
                    return turma;
                }
                DB.fechaResultSet(resultSet);
                return null;
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
    public void buscarTodasTurmas()
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.turma;"
                );
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    System.out.println("______________________________");
                    Object curso_id = resultSet.getObject(3);
                    System.out.println("ID turma: " + resultSet.getInt(1));
                    System.out.println("Nome da turma: " + resultSet.getString(2));
                    if (curso_id == null){
                        System.out.println("Curso: sem curso anexado\n" );
                    }
                    else{
                        System.out.println(DaoFactory.criaCursoDao().buscarCursoPorIdTransformarEmObj((Integer) curso_id));
                    }

                    Exibir.espera_em_ms(500);
                }
                DB.fechaResultSet(resultSet);
            }
            catch (Exception e){
                throw new DbException(e.getMessage());
            }
        }

        else {
            System.out.println("Impossível buscar dados com a conexão nula...");
        }
    }

    
}
