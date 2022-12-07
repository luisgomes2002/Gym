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

public class ListaClientesController implements Initializable 
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Cliente, Integer> ID;

    @FXML
    private TableColumn<Cliente, String> Nome;
    
    @FXML
    private TableColumn<Cliente, Integer> Cpf;

    @FXML
    private TableColumn<Cliente, String> Email;

    @FXML
    private TableColumn<Cliente, String> Endereco;
    
    @FXML
    private TableColumn<Cliente, String> Nacionalidade;

    @FXML
    private TableColumn<Cliente, String> Nascimento;
    
    @FXML
    private TableColumn<Cliente, String> Sexo;

    @FXML
    private TableColumn<Cliente, Integer> Telefone;

    @FXML
    private TableColumn<Cliente, String> Treino;

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
    
    @FXML
    private Button bntEditarCliente;
    
    @FXML
    private TextField emailEdit;

    @FXML
    private TextField enderecoEdit;
    
    @FXML
    private TextField telEdit;
    
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

    public void showCliente()
    {
    	ObservableList<Cliente> list = getClienteList();
    	
    	ID.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
    	Nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
    	Telefone.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("tel"));
    	Nascimento.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nascimento"));//converter para integer para testar
    	Email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
    	Endereco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
    	Cpf.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("cpf"));
    	Sexo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("sexo"));
    	Nacionalidade.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nacionalidade"));
    	Treino.setCellValueFactory(new PropertyValueFactory<Cliente, String>("treino"));
    	
    	tableViewClientes.setItems(list);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {   	
    	showCliente();
    }
    
	private void executeQuery(String query)//para poder deletar
    {
		Connection c = getConnection();
		Statement st;
		try
		{
			st = c.createStatement();
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    @FXML
    void excluirCliente(ActionEvent event)
    {
    	String query = "DELETE FROM cliente WHERE id = " + barraDePesquisa.getText() + "";
    	executeQuery(query);
    	showCliente();
    }
    
    @FXML
    void editarCliente(ActionEvent event)
    {
    	/*String query = "UPDATE cliente SET telefone = " + telEdit.getText() + "WHERE id = " + nomeEdit.getText() + "";
    	executeQuery(query);
    	showCliente();*/
    	try
    	{
    		Driver driver = new Driver();
    		DriverManager.registerDriver(driver);
    		
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdatabase", "root", "");
    		
    		PreparedStatement stmt = c.prepareStatement("UPDATE gymdatabase.cliente SET telefone = ?, email = ?, endereco = ? WHERE id = ?");
    		
    		stmt.setString(1, telEdit.getText());//番号　do krl
    		stmt.setString(2, emailEdit.getText());
    		stmt.setString(3, enderecoEdit.getText());
    		stmt.setString(4, idEdit.getText());
    		
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

			telEdit.setText("");
            emailEdit.setText("");
            enderecoEdit.setText("");
            idEdit.setText("");
    		
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    /*@FXML
    void mouseClicked(MouseEvent event)
    {
    	Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
    	System.out.println("id" + cliente.getId());
    	System.out.println("nome" + cliente.getNome());
    }*/
    
	@FXML
    void pesquisarCliente(ActionEvent event)
    {
    	
    }


    @FXML
    void swichToGymApp(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("interface/GymApp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,  984, 566);
        stage.setScene(scene);
        stage.show();
    }

}

