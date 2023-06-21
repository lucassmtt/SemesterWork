package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.TurmaDao;
import model.entities.Sala;
import model.entities.Turma;

import java.sql.*;
import java.util.*;

public class TurmaDaoJDBC implements TurmaDao
{
    private Connection connection = null;

    public TurmaDaoJDBC(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void insere(Turma obj)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try{
                String sql = "INSERT INTO database.turma (NomeTurma) VALUES (?) ";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, obj.getNomeTurma());

                int rows_affected = preparedStatement.executeUpdate();

                if (rows_affected > 0){
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int id = resultSet.getInt(1);
                        obj.setCodigo_turma(id);
                        System.out.println("A inserção da turma foi concluida com sucesso!");
                    }
                }
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        else {
            System.out.println("Não podemos inserir um dado com a conexão nula...");
        }
    }

    @Override
    public void atualiza(Turma obj)
    {
        Scanner scanner = new Scanner(System.in);
        int resp = 0;
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            int id = obj.getCodigo_turma();

            try {
                System.out.println("Você quer atualizar quais campos da turma? ");
                System.out.println("1 = Atualizar nome da turma + Codigo da Sala " +
                        "2 = Atualizar nome da turma");
                while (resp != 1 || resp != 2) {
                    System.out.print(": ");
                    resp = scanner.nextInt();

                    if (resp == 1) {
                        String sql = "UPDATE database.turma " +
                                "SET NomeTurma = ? CodigoSala = ? WHERE CodigoTurma = ? ";
                        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        preparedStatement.setString(1, obj.getNomeTurma());
                        preparedStatement.setInt(2, obj.getSala().getCodigo());
                        preparedStatement.setInt(3, id);
                        preparedStatement.executeUpdate();

                        int linhasAfetadas = preparedStatement.executeUpdate();
                        if (linhasAfetadas > 0) {
                            System.out.println("Atualização feita com sucesso...");
                        }
                    }
                    if (resp == 2) {
                        String sql = "UPDATE database.turma " +
                                "SET NomeTurma = ? CodigoSala = 0 WHERE CodigoTurma = ? ";
                        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        preparedStatement.setString(1, obj.getNomeTurma());
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();

                        int linhasAfetadas = preparedStatement.executeUpdate();
                        if (linhasAfetadas > 0) {
                            System.out.println("Atualização feita com sucesso...");
                        }
                    }
                }
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            finally {
                DB.fechaStatement(preparedStatement);
            }
        }

    }

    @Override
    public void deletaPorId(Integer id)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM database.turma WHERE CodigoTurma = ? ";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, id);
                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Deleção feita com sucesso...");
                }
                else {
                    System.out.println("Deleção mal sucedida, verifique o codigo da turma informada...");
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
            System.out.println("Impossível realizar operações com a conexão nula...");
        }

    }

    @Override
    public Turma buscaPorId(Integer id)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String sql = "SELECT t.* FROM `database`.turma t where CodigoTurma = ? LIMIT 501";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    if (resultSet.getInt("CodigoSala") == 0){
                        Turma turma = new Turma(
                                resultSet.getInt("CodigoTurma"),
                                resultSet.getString("NomeTurma")
                        );
                        return turma;
                    }
                    Turma turma = new Turma(
                            resultSet.getInt("CodigoTurma"),
                            resultSet.getString("NomeTurma"),
                            resultSet.getInt("CodigoSala")
                    );
                    return turma;
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
            System.out.println("Não podemos realizar operação com conexão nula...");
        }
        return null;
    }

    @Override
    public void buscaTodos()
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                preparedStatement = connection.prepareStatement(
                        "SELECT t.* FROM `database`.turma t LIMIT 501"
                );
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    System.out.println(resultSet.getInt("CodigoTurma") + " - " +
                            resultSet.getString("NomeTurma") + " - " +
                            resultSet.getInt("CodigoSala")
                    );
                }
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        else {
            System.out.println("Impossível realizar operação no banco de dados com a conexão nula...");
        }
    }
}
