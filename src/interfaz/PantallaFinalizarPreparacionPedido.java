package interfaz;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import logica.GestorFinalizarPreparacionPedido;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PantallaFinalizarPreparacionPedido
{
    @FXML
    private ComboBox<String> cboOrdenar;

    @FXML
    private TableView<Integer> tvPedidos;

    @FXML
    private TableColumn<Integer, String> colItem;
    @FXML
    private TableColumn<Integer, String> colCantidad;
    @FXML
    private TableColumn<Integer, String> colMesa;
    @FXML
    private TableColumn<Integer, String> colTiempo;
    @FXML
    private TableColumn<Integer, Boolean> colCheck;

    @FXML
    private Label lblSeleccion;

    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnFinalizar;
    @FXML
    private Button btnOpcion;

    public List<String[]> listaDetallesEnPreparacion;
    public List<BooleanProperty> listaDetallesAServir;
    String[] metodosOrd = new String[]{ "Tiempo de espera", "Mesa"};

    private GestorFinalizarPreparacionPedido gestor;

    public void setGestor(GestorFinalizarPreparacionPedido gestor)
    {
        this.gestor = gestor;
    }

    // abrirVentana()
    public void initialize()
    {
        tvPedidos.setDisable(true);
        btnCancelar.setDisable(true);
        btnFinalizar.setDisable(true);
        cboOrdenar.setDisable(true);

        colItem.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(listaDetallesEnPreparacion.get(rowIndex)[0]);
        });
        colCantidad.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(listaDetallesEnPreparacion.get(rowIndex)[1]);
        });
        colMesa.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(listaDetallesEnPreparacion.get(rowIndex)[2]);
        });
        colTiempo.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(listaDetallesEnPreparacion.get(rowIndex)[3]);
        });
        colCheck.setCellFactory(column -> new CheckBoxTableCell<>());
        colCheck.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            BooleanProperty property = listaDetallesAServir.get(rowIndex);
            property.addListener((observable, oldValue, newValue) -> property.setValue(newValue));
            return property;
        });

        colCheck.setEditable(true);
        tvPedidos.setEditable(true);

        cboOrdenar.getItems().addAll(metodosOrd);
        cboOrdenar.setValue(metodosOrd[0]);
    }

//    private void func()
//    {
//        DetalleDePedido[] d = DetalleDePedido.generarDetalles3();
//        for(DetalleDePedido det : d)
//        {
//            mostrarDatosDetallePedidoEnPreparacion(det);
//        }
//
//    }

    public void tomarOpcionFinalizarPedido(ActionEvent event)
    {
        listaDetallesEnPreparacion = new ArrayList<>();
        listaDetallesAServir = new ArrayList<>();
        tvPedidos.getItems().clear();

        habilitarVentana();
        gestor.finalizarPedido(cboOrdenar.getValue());
    }

    private void habilitarVentana()
    {
        tvPedidos.setDisable(false);
        btnCancelar.setDisable(false);
        btnFinalizar.setDisable(false);
        cboOrdenar.setDisable(false);
        btnOpcion.setDisable(true);
    }


    public void mostrarDatosDetallePedidoEnPreparacion(String[] datos)
    {
        listaDetallesEnPreparacion.add(datos);
        listaDetallesAServir.add(new SimpleBooleanProperty(false));
        tvPedidos.getItems().add(listaDetallesEnPreparacion.size() - 1);
    }

    public void solicitarSeleccionDeUnoVariosDetalles()
    {
        lblSeleccion.setText("Seleccione los pedidos a finalizar");
    }

    public void tomarSeleccionDeDetalle(ActionEvent actionEvent)
    {
        for (int i = 0; i < listaDetallesEnPreparacion.size(); i++)
            if(listaDetallesAServir.get(i).getValue())
                gestor.detallePedidoSeleccionado(i);

        gestor.detallePedidoSeleccionado(-1);
    }

    public void solicitarConfirmacionElaboracionProducto()
    {
        Object[] options = {"Aceptar", "Cancelar"};
        int option = JOptionPane.showOptionDialog(null,
                "¿Desea confirmar la finalización de los pedidos?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (option==0)
        {
            tomarConfirmarElaboracion();
        }
    }

    public void tomarConfirmarElaboracion()
    {
        gestor.confirmarElaboracion();

        // Elimina los detalles de la grilla
        List<String[]> temp1 = new ArrayList<>();
        List<BooleanProperty> temp2 = new ArrayList<>();
        tvPedidos.getItems().clear();
        for (int i = 0; i < listaDetallesEnPreparacion.size(); i++)
        {
            if (!listaDetallesAServir.get(i).getValue())
            {
                temp1.add(listaDetallesEnPreparacion.get(i));
                temp2.add(new SimpleBooleanProperty(false));
                tvPedidos.getItems().add(i);
            }
        }
        listaDetallesEnPreparacion = temp1;
        listaDetallesAServir = temp2;
    }

    public void cancelar(ActionEvent actionEvent)
    {
        tvPedidos.setDisable(true);
        btnCancelar.setDisable(true);
        btnFinalizar.setDisable(true);
        cboOrdenar.setDisable(true);
        btnOpcion.setDisable(false);

        tvPedidos.getItems().clear();
    }
}
