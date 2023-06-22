package model.dao.impl;

import model.dao.TurmaDao;
import model.entities.Turma;

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
                        "INSERT INTO faculdade.turma ()" +
                        " VALUES (?, ?, ?, ?, ?, ?);"
                        , Statement.RETURN_GENERATED_KEYS);

                int linhas_afetadas = 0;

                linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0) {
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()){
                        int ID = resultSet.getInt(1);
                        turma.setId_Matricula(ID);
                    }
                    DB.fechaResultSet(resultSet);
                    System.out.println("Inserção de turma no banco de dados feita com sucesso...");
                }
                else {
                    System.out.println("Impossível inserir turma! ");
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
    public void atualizarTurma(Turma turma)
    {
        if (connection != null)
        {
            PreparedStatement preparedStatement = null;
            try{
                String sql = "UPDATE faculdade.turma " +
                        "SET  " +
                        "WHERE ID_turma = ?;";


                int linhas_afetadas = preparedStatement.executeUpdate();

                if (linhas_afetadas > 0){
                    System.out.println("Turma atualizado com sucesso...");
                }
                else {
                    System.out.println("Impossível atualizar turma...");
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
                );


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
    public void buscarTodosTurmas()
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
