//package model.dao.impl;
//
//import db.DB;
//import db.DbException;
//import model.dao.CursoDao;
//import model.entities.Curso;
//
//public class CursoDaoJDBC implements CursoDao
//{
//    private Connection connection = null;
//
//    public CursoDaoJDBC(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public void inserirCurso(Curso curso)
//    {
//        if (connection != null){
//            PreparedStatement preparedStatement = null;
//            ResultSet resultSet = null;
//            try{
//                preparedStatement = connection.prepareStatement(
//                  ""//SQL
//                        , Statement.RETURN_GENERATED_KEYS)
//
//                int linhas_afetadas = 0;
//
//                linhas_afetadas = preparedStatement.executeUpdate();
//
//                if (linhas_afetadas > 0) {
//                    resultSet = preparedStatement.getGeneratedKeys();
//                    if (resultSet.next()){
//                        int ID = resultSet.getInt(1);
//
//                    }
//                    DB.fechaResultSet(resultSet);
//                    System.out.println("Inserção do curso no banco de dados feita com sucesso...");
//                }
//                else {
//                    System.out.println("Impossível inserir curso! ");
//                }
//            }
//            catch (Exception e){
//                throw new DbException(e.getMessage());
//            }
//            finally {
//                DB.fechaStatement(preparedStatement);
//            }
//        }
//        else {
//            System.out.println("Impossível inserir dados com a conexão nula...");
//        }
//    }
//
//    @Override
//    public void apagarCursoPorId(Integer ID)
//    {
//        if (connection != null)
//        {
//            PreparedStatement preparedStatement = null;
//
//            try {
//                String sql = "DELETE FROM faculdade.curso WHERE ID_curso = ?;";
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setInt(1, ID);
//
//                int rows_affect = preparedStatement.executeUpdate();
//
//                if (rows_affect > 0) {
//                    System.out.println("Curso apagado com sucesso...");
//                }
//                else {
//                    System.out.println("Deleção incompleta...");
//                }
//            }
//            catch (SQLException e)
//            {
//                throw new DbException(e.getMessage());
//            }
//            finally {
//                DB.fechaStatement(preparedStatement);
//            }
//        }
//        else {
//            System.out.println("Impossível apagar dados com a conexão nula...");
//        }
//    }
//
//    @Override
//    public void atualizarCurso(Curso curso)
//    {
//        if (connection != null)
//        {
//            PreparedStatement preparedStatement = null;
//            try{
//                String sql = "UPDATE faculdade.curso " +
//                        "" +
//                        "WHERE ID_curso = ?;";
//                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//                int linhas_afetadas = preparedStatement.executeUpdate();
//
//                if (linhas_afetadas > 0){
//                    System.out.println("Curso atualizado com sucesso...");
//                }
//                else {
//                    System.out.println("Impossível atualizar curso...");
//                }
//
//            } catch (SQLException e) {
//                throw new DbException(e.getMessage());
//            }
//            finally {
//                DB.fechaStatement(preparedStatement);
//            }
//        }
//        else {
//            System.out.println("Impossível atualizar dados com a conexão nula...");
//        }
//    }
//
//    @Override
//    public void buscarCursoPorId(Integer ID)
//    {
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        if (connection != null)
//        {
//            try {
//                preparedStatement = connection.prepareStatement(
//                        "SELECT * FROM faculdade.curso where ID_curso = ?;"
//                );
//                preparedStatement.setInt(1, ID);
//                resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()){
//                    System.out.println(
//                );
//
//                }
//                else {
//                    System.out.println("Nenhum registro encontrado...");
//                }
//                DB.fechaResultSet(resultSet);
//
//            }
//            catch (SQLException e){
//                throw new DbException(e.getMessage());
//            }
//            finally {
//                DB.fechaStatement(preparedStatement);
//            }
//        }
//        else {
//            System.out.println("Impossível buscar dado com a conexão nula...");
//        }
//    }
//
//    @Override
//    public void buscarTodosCursos()
//    {
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        if (connection != null)
//        {
//            try {
//                preparedStatement = connection.prepareStatement(
//                        "SELECT * FROM faculdade.curso;"
//                );
//                resultSet = preparedStatement.executeQuery();
//
//                while (resultSet.next()){
//                    System.out.println("_______________________________");
//                    System.out.println(
//                    );
//
//                }
//                DB.fechaResultSet(resultSet);
//            }
//            catch (SQLException e){
//                throw new DbException(e.getMessage());
//            }
//            finally {
//                DB.fechaStatement(preparedStatement);
//            }
//        }
//        else {
//            System.out.println("Impossível buscar dados com a conexão nula...");
//        }
//    }
//}