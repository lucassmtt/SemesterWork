package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.CursoDao;
import model.entities.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CursoDaoJDBC implements CursoDao
{
    private Connection connection = null;

    public CursoDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserirCurso(Curso curso)
    {
        if (connection != null){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(
                  "INSERT INTO faculdade.curso (nomeCurso, cargaHoraria, descricao) " +
                          "VALUES (?, ?, ?) "
                        , Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, curso.getNomeCurso());
                preparedStatement.setInt(2, curso.getCargaHoraria());
                preparedStatement.setString(3, curso.getDescricao());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        curso.setId_Curso(ID);

                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção do curso no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir curso! ");
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
    public void apagarCursoPorID(Integer ID)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM faculdade.curso WHERE ID_curso = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, ID);

                int rows_affect = preparedStatement.executeUpdate();

                if (rows_affect > 0) {
                    System.out.println("Curso apagado com sucesso...");
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
    public void atualizarCurso(Curso curso)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.curso " +
                        "SET nomeCurso = ?, cargaHoraria = ?, descricao = ? " +
                        "WHERE ID_curso = ?;";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, curso.getNomeCurso());
                preparedStatement.setInt(2, curso.getCargaHoraria());
                preparedStatement.setString(3, curso.getDescricao());
                preparedStatement.setInt(4, curso.getId_Curso());

                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Curso atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar curso...");
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
    public void buscarCursoPorId(Integer ID)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.curso where ID_curso = ?;"
                );
                preparedStatement.setInt(1, ID);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    System.out.println("______________________________");
                    System.out.println("ID Curso: " + resultSet.getInt(1) + "\n" +
                            "Nome do curso: " + resultSet.getString(2) + "\n" +
                            "Carga horária: " + resultSet.getInt(3) + "\n" +
                            "Descrição: " + resultSet.getString(4));

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
    public Curso buscarCursoPorIdTransformarEmObj(Integer Id)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null)
        {
            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT * FROM faculdade.curso where ID_curso = ?;"
                );
                preparedStatement.setInt(1, Id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    Curso curso = new Curso();
                    curso.setId_Curso(resultSet.getInt(1));
                    curso.setCargaHoraria(resultSet.getInt(3));
                    curso.setDescricao(resultSet.getString(4));
                    curso.setNomeCurso(resultSet.getString(2));
                    return curso;
                }
                else {
                    System.out.println("Nenhum registro encontrado...");
                    return null;
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
            System.out.println("Impossível buscar dado com a conexão nula...");
        }
        return null;
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

                while (resultSet.next()){
                    System.out.println("______________________________");
                    System.out.println("ID Curso: " + resultSet.getInt(1) + "\n" +
                            "Nome do curso: " + resultSet.getString(2) + "\n" +
                            "Carga horária: " + resultSet.getInt(3) + "\n" +
                            "Descrição: " + resultSet.getString(4));
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
            System.out.println("Impossível buscar dados com a conexão nula...");
        }
    }
}
