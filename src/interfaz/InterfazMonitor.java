package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import logica.DetalleDePedido;

public class InterfazMonitor
{
    @FXML
    private TableColumn<DetalleDePedido, Integer> colCantidad;
    @FXML
    private TableColumn<DetalleDePedido, Integer> colMesa;
    @FXML
    private TableColumn colCheck;

    @FXML
    private TableView tvPedidos;



    public void initialize()
    {
        DetalleDePedido[] dets = DetalleDePedido.generarDetalles3();

        colCantidad.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("cantidad"));
        colMesa.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("mesa"));


        colCheck.setCellFactory(p->new CheckBoxTableCell<>());

        tvPedidos.getItems().clear();
        tvPedidos.getItems().addAll(dets);
    }
}
