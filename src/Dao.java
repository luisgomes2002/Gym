import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class Dao 
{
	//CRUD - Create Read Updade Delete
	//READ
	public static void buscarUsuarios()
	{
		//Java DataBase Connection (JDBC)
		try
		{
			Driver driver =  new Driver();
			DriverManager.registerDriver(driver);
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
			
			PreparedStatement stmt = c.prepareStatement("SELECT * FROM gymdatabase.cliente");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//id = rs.getInt("id");
				//String nome = rs.getString("nome");
				
				System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Nascimento: " + rs.getString("nascimento"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Endereco: " + rs.getString("endereco"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Sexo: " + rs.getString("sexo"));
                System.out.println("Nascionalidade: " + rs.getString("nascionalidade"));
                System.out.println("Treino: " + rs.getString("tipoDeTreino"));
                System.out.println("");
                
			}
			
			stmt.close();
			c.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void inserirUsuario()
	{
		 try
	        {
	            Driver driver = new Driver();
	            DriverManager.registerDriver(driver);

	            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
	            PreparedStatement stmt = c.prepareStatement("INSERT INTO gymdatabase.cliente (nome, nascimento, cpf, endereco, email, telefone, sexo, nascionalidade, tipoDeTreino) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
	            
	            
	        
	        }
	        catch(SQLException ex)
	        {
	            System.out.println("Erro na conexao com o banco de dados");
	        }
	}
	
	public static void atualizarUsuario()
	{
		try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            PreparedStatement stmt = c.prepareStatement("UPDATE gymdatabase.cliente SET endereco = ?, email = ?, telefone = ?,tipoDeTreino = ? WHERE cfp = ?");
            
            
        
        }
        catch(SQLException ex)
        {
            System.out.println("Erro na conexao com o banco de dados");
        }
	}
}
