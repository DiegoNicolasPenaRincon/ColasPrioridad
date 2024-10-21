package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.enums.ClaseBoleto;
import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.model.ConciertoShakira;
import co.edu.uniquindio.alquiler.model.Solicitud;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lombok.extern.java.Log;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

@Log
public class InicioController {

    @FXML
    private Label tituloShakiraLbl;
    @FXML
    private Label nombreLbl;
    @FXML
    private Label cedulaLbl;
    @FXML
    private Label claseLbl;
    @FXML
    private ComboBox<ClaseBoleto> claseComBox;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField cedulaText;
    @FXML
    private Button comprarButton;
    @FXML
    private TableView<Solicitud> tablaCompradores;
    @FXML
    private TableColumn<Solicitud,String> nombreColumn;
    @FXML
    private TableColumn<Solicitud,String> cedulaColumn;
    @FXML
    private TableColumn<Solicitud,String> columnClase;
    @FXML
    private AnchorPane panelFormulario;
    @FXML
    private Button btnInicioRegCli;
    @FXML
    private Button btnInicioRegVeh;
    @FXML
    private Button btnInicioRegAlq;
    @FXML
    private Button btnCambiarIdioma;
    @FXML
    public Button btnClientes;
    @FXML
    private ObservableList<Solicitud> solicitudes;

    private ConciertoShakira conciertoShakira = ConciertoShakira.getInstance();

    private Collection<Solicitud> colaCasteada;


    public void initialize() {
        Collection<Solicitud> colaCasteada=conciertoShakira.getColaConcierto().toCollection();
        solicitudes= FXCollections.observableList((List<Solicitud>) colaCasteada);
        this.claseComBox.getItems().setAll(ClaseBoleto.values());


        nombreColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()) );
        cedulaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getIdentificacion() ));
        columnClase.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getClase()) ) );


    }

    /**
     * Hay que tener en cuenta la cola de prioridad se ordena sola, por ende, cuando se agreguen elementos a la cola, se organizaran tambien en la tabla
     * @param actionEvent
     */

    public void comprarBoleto(ActionEvent actionEvent) {
        try
        {
            String nombre=nombreText.getText();
            String cedula=cedulaText.getText();
            ClaseBoleto claseBoleto = claseComBox.getValue();

            if(nombre.isEmpty()||cedula.isEmpty()||claseBoleto==null)
            {
                throw new AtributoVacioException("Ni el nombre, ni la cedula ni la clase del boleto puede estar vacia");
            }
            else
            {
                Solicitud solicitud=new Solicitud(nombre,cedula,claseBoleto);
                int prioridad=conciertoShakira.transformarPrioridad(claseBoleto);
                conciertoShakira.getColaConcierto().encolar(solicitud,prioridad);
                colaCasteada=conciertoShakira.getColaConcierto().toCollection();
                solicitudes=FXCollections.observableList((List<Solicitud>) colaCasteada);
                this.tablaCompradores.setItems(solicitudes);
            }
            conciertoShakira.getColaConcierto().imprimir();

        }
        catch(AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
