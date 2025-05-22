package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
    
    // Configurações de conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/conexao";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    public static void main(String[] args) {
        Connection conexao = null;

        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");
            
            // Estabelecer a conexão
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados PostgreSQL realizada com sucesso!");
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado. Verifique se adicionou o JAR corretamente.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            e.printStackTrace();
        } finally {
            // Fechar a conexão
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão encerrada.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
