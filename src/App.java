import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("GymApp.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setTitle("Gym");           
            primaryStage.setScene(scene);
            primaryStage.show();    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    
    }
    
    public static void main(String[] args)
    {
        launch(args);
    } 
}