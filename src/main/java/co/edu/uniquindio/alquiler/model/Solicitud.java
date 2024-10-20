package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.ClaseBoleto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud implements Serializable {

    private String nombre;
    private String identificacion;
    private ClaseBoleto clase;

}
