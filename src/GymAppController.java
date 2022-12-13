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
import javafx.stage.Stage;
import javafx.scene.Node;

public class GymAppController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginbnt;

    @FXML
    private PasswordField passwordKey;

    @FXML
    private Button loginbnt2;

    @FXML
    private PasswordField passwordKey2;


    public void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraClien(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/CadrastroCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void casdastraFunci(ActionEvent event) throws IOException
    {
        //loginButton(event);
        root = FXMLLoader.load(getClass().getResource("interface/CadastroFuncionario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException 
    {
        try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            
            Usuario usuario = new Usuario();
            usuario.setSenhaUsuario(passwordKey.getText());

            String query = "SELECT * FROM usuario where senha_usuario = ?";

            PreparedStatement stmt = c.prepareStatement(query);   

            stmt.setString(1, usuario.getSenhaUsuario());

            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                root = FXMLLoader.load(getClass().getResource("interface/ListaFuncionarios.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 1280, 720);
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

    @FXML
    void listClient(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/ListaClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listFunc(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/Senha.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 370, 200);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listTreino(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/ListaDeTreino.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sair(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 720, 490);
        stage.setScene(scene);
        stage.show();
    }
}