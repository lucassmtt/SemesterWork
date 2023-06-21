package db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DB
{
    // Declara conexão nula para usarmos na classe
    private static Connection connection = null;

    // Carrega propriedades do banco de dados
    public static Properties carregaPropriedades()
    {
        try(FileInputStream fileInputStream = new FileInputStream(
                "/home/lucas-motta/Documents/GitHub/SemesterWork/ContainerConfig/.env"))
        {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (Exception e){
            throw new DbException(e.getMessage());
        }
    }

    // Estabelece conexão com o banco de dados
    public static Connection pegaConexao()
    {
        if (connection != null)
        {
            try {
                Properties properties = carregaPropriedades();
                connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
                return connection;
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return null;
    }

    // Fecha conexão
    public static void fechaConexao()
    {
        if (connection != null)
        {
            try{
                connection.close();
                System.out.println("Close connection success...");
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    // Fecha o Statement
    public static void fechaStatement(Statement statement)
    {
        if (statement != null){
            try {
                statement.close();
                System.out.println("Closed statement");
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    // Fecha o resultSet
    public static void fechaResultSet(ResultSet resultSet)
    {
        if (resultSet != null){
            try{
                resultSet.close();
                System.out.println("Result set closed...");
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
