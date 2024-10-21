package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.enums.ClaseBoleto;
import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.model.ConciertoShakira;
import co.edu.uniquindio.alquiler.model.Solicitud;
import co.edu.uniquindio.alquiler.utils.Idiomas;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lombok.extern.java.Log;

import java.awt.event.ActionEvent;
import java.net.URL;
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
    private TableColumn<Solicitud,ClaseBoleto> columnClase;
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

    public ConciertoShakira conciertoShakira = ConciertoShakira.getInstance();


    public void initialize() {
        solicitudes= (ObservableList<Solicitud>) conciertoShakira.getColaConcierto();

        this.nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.cedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.columnClase.setCellValueFactory(new PropertyValueFactory<>("clase"));
    }

    @FXML
    public void comprarBoleto(ActionEvent event) {
        try
        {
            String nombre=nombreText.getText();
            String cedula=cedulaText.getText();
            ClaseBoleto claseBoleto = ClaseBoleto.valueOf(cedula);

            if(nombre.isEmpty()||cedula.isEmpty()||claseBoleto==null)
            {
                throw new AtributoVacioException("Ni el nombre, ni la cedula ni la clase del boleto puede estar vacia");
            }

        }
        catch(AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alertra");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

}
