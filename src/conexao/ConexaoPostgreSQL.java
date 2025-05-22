package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
    
    // Configura��es de conex�o
    private static final String URL = "jdbc:postgresql://localhost:5432/conexao";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    public static void main(String[] args) {
        Connection conexao = null;

        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");
            
            // Estabelecer a conex�o
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            if (conexao != null) {
                System.out.println("Conex�o com o banco de dados PostgreSQL realizada com sucesso!");
            } else {
                System.out.println("Falha na conex�o com o banco de dados.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC n�o encontrado. Verifique se adicionou o JAR corretamente.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            e.printStackTrace();
        } finally {
            // Fechar a conex�o
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conex�o encerrada.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
