package interfaz;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.util.ArrayList;
import java.util.List;

public class InterfazMonitor implements IObserverPedidoListo
{
    @FXML
    private TableColumn<Integer, Number> colCantidad;
    @FXML
    private TableColumn<Integer, Number>  colMesa;
    @FXML
    private TableColumn colCheck;

    @FXML
    private TableView<Integer> tvPedidos;

    private int pisoAsociado = 1;

    private List<Integer> nroMesas = new ArrayList<>();
    private List<Integer> cantProductos = new ArrayList<>();

    public void initialize()
    {
        colCantidad.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(cantProductos.get(rowIndex));

        });
        colMesa.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(nroMesas.get(rowIndex));
        });
        colCheck.setCellFactory(p->new CheckBoxTableCell<>());
    }

    @Override
    public void actualizar(int mesa, int cantProductos)
    {
        insertarMesa(mesa, cantProductos);
    }

    private void insertarMesa(int mesa, int cantProductos)
    {
        int index = nroMesas.indexOf(mesa);
        if(index == -1)
        {
            nroMesas.add(mesa);
            this.cantProductos.add(cantProductos);
            tvPedidos.getItems().add(nroMesas.size() - 1);
        }
        else
        {
            int cantActual = this.cantProductos.get(index);
            this.cantProductos.set(index, cantActual + cantProductos);
            tvPedidos.getItems().set(index, index);
        }
    }
}
