import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.cj.jdbc.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListaFuncionarioController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private Button bntDeExcluir;

    @FXML
    private Button bntDePesquisa;

    @FXML
    private Button btnVoltar;

    @FXML
    void excluirCliente(ActionEvent event)
    {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");

            PreparedStatement stmt = c.prepareStatement("SELECT * FROM gymdatabase.funcionario");

            ResultSet rs = stmt.executeQuery();  

            while(rs.next())
            {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Nascimento: " + rs.getString("nascimento"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Endereco: " + rs.getString("endereco"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Sexo: " + rs.getString("sexo"));
                System.out.println("Nascionalidade: " + rs.getString("nacionalidade"));
                System.out.println("Cargo: " + rs.getString("cargo"));
                System.out.println("Salario: " + rs.getString("salario"));
            }

            stmt.close();
            c.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Erro na conexao com o banco de dados");
        }
        
    }

    @FXML
    void pesquisarFuncionario(ActionEvent event)
    {
        
    }

    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 984, 566);
        stage.setScene(scene);
        stage.show();
    }

    

}
