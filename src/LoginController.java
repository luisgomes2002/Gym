import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import Class.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField login;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    void loginButton(ActionEvent event) throws IOException
    {
        logar(event);
    }

    private void logar(ActionEvent event) throws IOException
    {
        try
        { 
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(login.getText());
            usuario.setSenhaUsuario(password.getText());

            String query = "SELECT * FROM usuario where nome_usuario = ? and senha_usuario = ?";

            PreparedStatement stmt = c.prepareStatement(query);   

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());

            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {   
                root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 984, 566);
                stage.setScene(scene);
                stage.show();

                //Stage stage = (Stage) loginButton.getScene().getWindow();
                //stage.close();
                System.out.println("ta tudo blz man");
            }
            else
            {
                System.out.println("Senha ou login errado otario");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erro na conexao com o banco de dados");
        }  


        try
        { 
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(login.getText());
            usuario.setSenhaUsuario(password.getText());

            String query = "SELECT * FROM usuariofunci where nome_usuario = ? and senha_usuario = ?";

            PreparedStatement stmt = c.prepareStatement(query);   

            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());

            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {   
                root = FXMLLoader.load(getClass().getResource("interface/GymAppFuncionarios.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 984, 566);
                stage.setScene(scene);
                stage.show();

                //Stage stage = (Stage) loginButton.getScene().getWindow();
                //stage.close();
                System.out.println("ta tudo blz man");
            }
            else
            {
                System.out.println("Senha ou login errado otario");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erro na conexao com o banco de dados");
        }     
    }

    }