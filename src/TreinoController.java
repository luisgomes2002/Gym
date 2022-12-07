import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.mysql.cj.jdbc.Driver;
import Class.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class TreinoController implements Initializable 
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Cliente, String> Peso;

    @FXML
    private TableColumn<Cliente, String> Altura;

    @FXML
    private TableColumn<Cliente, String> Foco;

    @FXML
    private TableColumn<Cliente, Integer> ID;

    @FXML
    private TableColumn<Cliente, String> IMC;

    @FXML
    private TableColumn<Cliente, String> Nome;

    @FXML
    private TableColumn<Cliente, String> Treino;

    @FXML
    private TableView<Cliente> tableViewTreino;

    @FXML
    private TextField alturaEdit;

    @FXML
    private Button bntEditarTreino;

    @FXML
    private Button bntVoltar;

    @FXML
    private TextField focoEdit;

    @FXML
    private TextField pesoEdit;

    @FXML
    private TextField treinoEdit;

    @FXML
    private TextField idEdit;

    
    public Connection getConnection()
    {
    	Connection c;
    	try
		{
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
        return c;		
		}
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Cliente> getClienteList()
    {
		ObservableList<Cliente> clienteList = FXCollections.observableArrayList();
    	Connection c = getConnection();
    	String query = "SELECT * FROM cliente";
    	Statement stmt;
    	ResultSet rs;
    	
    	try
    	{
    		stmt = c.createStatement();
    		rs = stmt.executeQuery(query);   
    		Cliente cliente;
    		
    		while(rs.next())
    		{
    			cliente = new Cliente(rs.getInt("id"), 
					rs.getString("nome"),
					rs.getInt("telefone"), 
					rs.getString("nascimento"), 
					rs.getString("email"), 
					rs.getString("endereco"),
					rs.getInt("cpf"),
					rs.getString("sexo"), 
					rs.getString("nascionalidade"), 
					rs.getString("tipoDeTreino"),
                    rs.getString("peso"), 
                    rs.getString("altura"),
                    rs.getString("foco"), 
                    rs.getString("imc"));
    			
    			clienteList.add(cliente);
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return clienteList;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        showCliente();
    }

    public void showCliente()
    {
        ObservableList<Cliente> list = getClienteList();

        ID.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        Treino.setCellValueFactory(new PropertyValueFactory<Cliente, String>("treino"));
        Peso.setCellValueFactory(new PropertyValueFactory<Cliente, String>("peso"));
        Altura.setCellValueFactory(new PropertyValueFactory<Cliente, String>("altura"));
        Foco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("foco"));
        IMC.setCellValueFactory(new PropertyValueFactory<Cliente, String>("imc"));

        tableViewTreino.setItems(list);
    }

    @FXML
    void editarTreino(ActionEvent event)
    {
        try
    	{
    		Driver driver = new Driver();
    		DriverManager.registerDriver(driver);
    		
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
    		
    		PreparedStatement stmt = c.prepareStatement("UPDATE gymdatabase.cliente SET peso = ?, altura = ?, foco = ?, tipoDeTreino = ? WHERE id = ?");
    		
    		stmt.setString(1, pesoEdit.getText());//番号　do krl
    		stmt.setString(2, alturaEdit.getText());
            stmt.setString(3, focoEdit.getText());
    		stmt.setString(4, treinoEdit.getText());
    		stmt.setString(5, idEdit.getText());
    		
            

    		int rowsAffected = stmt.executeUpdate();
    		
    		if(rowsAffected > 0)
    		{
    			System.out.println("Mudou");
    		}
    		else
    		{
    			System.out.println("AAAAAAAAAAA");
    		}
    		
    		showCliente();

            pesoEdit.setText("");
            alturaEdit.setText("");
            treinoEdit.setText("");
            focoEdit.setText("");
            idEdit.setText("");
    		
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
            System.out.println("ERRO EM EDITAR TREINO");
    	}
    }

    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();    
    }
}