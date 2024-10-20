package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.enums.ClaseBoleto;
import co.edu.uniquindio.alquiler.model.Solicitud;
import co.edu.uniquindio.alquiler.utils.Idiomas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lombok.extern.java.Log;

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
    private TableColumn nombreColumn;
    @FXML
    private TableColumn cedulaColumn;
    @FXML
    private TableColumn columnClase;
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


}
