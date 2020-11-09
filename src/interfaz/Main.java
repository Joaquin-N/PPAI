package interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
        primaryStage.setTitle("Finalizar Preparación de Pedido");
        primaryStage.setScene(new Scene(root));
        
        mostrarPantalla("movil.fxml",70, 150);
        mostrarPantalla("monitor.fxml",1400, 250);


//        Parent root = FXMLLoader.load(getClass().getResource("monitor.fxml"));
//        primaryStage.setTitle("Pedidos Listos Para Servir");
//        primaryStage.setScene(new Scene(root, 480, 380));

//        Parent root = FXMLLoader.load(getClass().getResource("movil.fxml"));
//        primaryStage.setTitle("Pedidos Listos Para Servir");
//        primaryStage.setScene(new Scene(root, 350, 560));

        primaryStage.show();
    }

    private void mostrarPantalla(String fxml, double x, double y)
    {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Pedidos Listos Para Servir");
            stage.setX(x);
            stage.setY(y);
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
