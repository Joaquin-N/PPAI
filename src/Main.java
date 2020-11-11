import interfaz.IObserverPedidoListo;
import interfaz.PantallaFinalizarPreparacionPedido;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logica.GestorFinalizarPreparacionPedido;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GestorFinalizarPreparacionPedido gestor = new GestorFinalizarPreparacionPedido();
        GeneradorDatos generadorDatos = new GeneradorDatos();
        IObserverPedidoListo observerController;

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("interfaz/principal.fxml"));

        Parent root = loader.load();

        PantallaFinalizarPreparacionPedido controller = loader.getController();
        gestor.setPantalla(controller);
        gestor.setListaEstados(generadorDatos.generarEstados());
        gestor.setListaDetallesPedidos(generadorDatos.generarDetallesPedido());

        controller.setGestor(gestor);

        primaryStage.setTitle("Finalizar Preparación de Pedido");
        primaryStage.setScene(new Scene(root));
        
        observerController = mostrarPantalla("interfaz/movil.fxml",70, 150);
        gestor.setObservadorMovil(observerController);

        observerController = mostrarPantalla("interfaz/monitor.fxml",1400, 250);
        gestor.setObservadorMonitor(observerController);

        primaryStage.show();
    }

    private IObserverPedidoListo mostrarPantalla(String fxml, double x, double y)
    {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
            Parent root = loader.load();
            IObserverPedidoListo controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Pedidos Listos Para Servir");
            stage.setX(x);
            stage.setY(y);
            stage.setScene(new Scene(root));
            stage.show();

            return controller;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
