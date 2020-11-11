package interfaz;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class InterfazDispositivoMovil implements IObserverPedidoListo
{
    @FXML
    private TableColumn<Integer, Number> colCantidad;
    @FXML
    private TableColumn<Integer, Number> colMesa;
    @FXML
    private TableColumn colCheck;

    @FXML
    private TableView<Integer> tvPedidos;
    @FXML
    private ImageView ivCampana;

    private List<Integer> nroMesas = new ArrayList<>();
    private List<Integer> cantProductos = new ArrayList<>();

    LocalTime ultimoAviso;

    public void initialize()
    {
        File file = new File("src/resources/campana.png");
        Image image = new Image(file.toURI().toString());
        ivCampana.setImage(image);
        ivCampana.setVisible(false);

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
        emitirAviso();
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

    private void emitirAviso()
    {
        LocalTime horaActual = LocalTime.now();
        if(ultimoAviso == null || ChronoUnit.SECONDS.between(ultimoAviso, horaActual) > 2)
        {
            ultimoAviso = horaActual;
            ivCampana.setVisible(true);
            String musicFile = "src/resources/bip_sonoro.mp3";
            Media bipSound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer player = new MediaPlayer(bipSound);
            player.play();
        }
    }
}
