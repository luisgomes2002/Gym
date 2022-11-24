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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListaClientesController extends Dao implements Initializable 
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Cliente, Integer> ID;

    @FXML
    private TableColumn<Cliente, String> Nome;

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TextField barraDePesquisa;

    @FXML
    private Button bntDeExcluir;

    @FXML
    private Button bntDePesquisa;

    @FXML
    private Button btnVoltar;

    
    public Connection getConnection()
    {
    	Connection c;
    	try
		{
			Driver driver =  new Driver();
			DriverManager.registerDriver(driver);
			
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
    			cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getInt("tel"), rs.getInt("nascimento"), rs.getString("email"), rs.getString("endereco"), rs.getInt("cpf"), rs.getString("sexo"), rs.getString("nacionalidade"), rs.getString("treino"));
    			clienteList.add(cliente);
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return clienteList;
    }

    public void showCliente()
    {
    	ObservableList<Cliente> list = getClienteList();
    	
    	ID.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
    	Nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {   	
    	ObservableList<Cliente> list = getClienteList();
    	
    	ID.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
    	Nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
    	buscarUsuarios();
    }
    
    @FXML
    void excluirCliente(ActionEvent event)
    {
    	
    }
    
    @FXML
    void pesquisarCliente(ActionEvent event)
    {
    	try
        {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
            PreparedStatement stmt = c.prepareStatement("UPDATE gymdatabase.cliente SET endereco = ?, email = ?, telefone = ?,tipoDeTreino = ? WHERE id = ?");
            
            
        
        }
        catch(SQLException ex)
        {
            System.out.println("Erro na conexao com o banco de dados");
        }
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

