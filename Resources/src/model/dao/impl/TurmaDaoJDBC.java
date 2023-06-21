//package model.dao.impl;
//
//import db.DbException;
//import model.dao.TurmaDao;
//import model.entities.Turma;
//
//import java.sql.*;
//
//public class TurmaDaoJDBC implements TurmaDao
//{
//    Connection connection = null;
//
//    public TurmaDaoJDBC(Connection connection)
//    {
//        this.connection = connection;
//    }
//
//    @Override
//    public void inserirTurma(Turma turma)
//    {
//        if (connection != null)
//        {
//            PreparedStatement preparedStatement = null;
//            ResultSet resultSet = null;
//            try {
//                String sql = "INSERT INTO turma (nomeTurma, Id_Sala, Id_Curso) VALUES (?, ?, ?);";
//                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//                preparedStatement.setString(1, turma.getNomeTurma());
//                preparedStatement.setInt(2, turma.getSala);
//                int linhas_afetadas = preparedStatement.executeUpdate();
//                if (linhas_afetadas > 0){
//                    resultSet =
//                    System.out.println("Inserção feita com sucesso...");
//                }
//                else {
//                    System.out.println("Impossível inserir, tente novamente...");
//                }
//            }
//            catch (SQLException e)
//            {
//                throw new DbException(e.getMessage());
//            }
//        }
//        else {
//            System.out.println("Não podemos realizar operações com a conexão nula!");
//        }
//
//    }
//
//    @Override
//    public void apagarTurma(Turma turma) {
//
//    }
//
//    @Override
//    public void atualizarTurma(Turma turma) {
//
//    }
//
//    @Override
//    public void buscarTurmaPorId(Integer Id) {
//
//    }
//
//    @Override
//    public void buscarTodasTurmas() {
//
//    }
//}