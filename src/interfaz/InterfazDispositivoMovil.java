package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logica.DetalleDePedido;

public class InterfazDispositivoMovil
{
    @FXML
    private TableColumn<DetalleDePedido, Integer> colCantidad;
    @FXML
    private TableColumn<DetalleDePedido, Integer> colMesa;
    @FXML
    private TableColumn colCheck;

    @FXML
    private TableView tvPedidos;
    @FXML
    private ImageView ivCampana;



    public void initialize()
    {
        DetalleDePedido[] dets = DetalleDePedido.generarDetalles2();

        colCantidad.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("cantidad"));
        colMesa.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("mesa"));


        colCheck.setCellFactory(p->new CheckBoxTableCell<>());

        tvPedidos.getItems().clear();
        tvPedidos.getItems().addAll(dets);
        ivCampana.setImage(new Image(getClass().getResourceAsStream("campana.png")));

    }
}
