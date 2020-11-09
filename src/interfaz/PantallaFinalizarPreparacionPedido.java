package interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import logica.DetalleDePedido;

import javax.swing.*;

public class PantallaFinalizarPreparacionPedido
{
    @FXML
    private ComboBox<String> cboOrdenar;

    @FXML
    private TableColumn<DetalleDePedido, String> colProducto;
    @FXML
    private TableColumn<DetalleDePedido, String> colMenu;
    @FXML
    private TableColumn<DetalleDePedido, Integer> colCantidad;
    @FXML
    private TableColumn<DetalleDePedido, Integer> colMesa;
    @FXML
    private TableColumn<DetalleDePedido, String> colSeccion;
    @FXML
    private TableColumn<DetalleDePedido, String> colTiempo;
    @FXML
    private TableColumn colCheck;

    @FXML
    private TableView tvPedidos;
    @FXML
    private Pane pnlPrincipal;

    public void initialize()
    {
        String[] metodos = new String[]{ "Tiempo de espera", "Sección", "Mesa", "Mozo"};
        cboOrdenar.getItems().addAll(metodos);
        cboOrdenar.setValue("Tiempo de espera");
        recargar();
    }

    public void recargar()
    {
        DetalleDePedido[] dets = DetalleDePedido.generarDetalles();

        colProducto.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, String>("producto"));
        colMenu.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, String>("menu"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("cantidad"));
        colMesa.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, Integer>("mesa"));
        colSeccion.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, String>("seccion"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<DetalleDePedido, String>("tiempo"));

        colCheck.setCellFactory(p->new CheckBoxTableCell<>());

        tvPedidos.getItems().clear();
        tvPedidos.getItems().addAll(dets);
    }

    public void btnFinalizar_onClick(ActionEvent actionEvent)
    {
        Object[] options = {"Aceptar", "Cancelar"};

        int option = JOptionPane.showOptionDialog(null,
                "¿Desea confirmar la finalización de los pedidos?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (option==0)
        {

        }
    }
}
