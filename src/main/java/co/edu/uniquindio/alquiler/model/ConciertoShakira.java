package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.ClaseBoleto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConciertoShakira {

    private static ConciertoShakira conciertoShakira;

    private ColaPrioridad<Solicitud> colaConcierto=new ColaPrioridad<>();

    public static ConciertoShakira getInstance(){
        if(conciertoShakira == null){
            conciertoShakira = new ConciertoShakira();
        }

        return conciertoShakira;
    }

    /** Metodo que otorga una prioridad distinta al nodo, dependiendo de su clase
     *
     * @param clase el tipo de boleto que adquiere el cliente
     * @return la prioridad del objeto
     */
    public int transformarPrioridad(ClaseBoleto clase) {
        int prioridad=0;
        if(clase.equals(ClaseBoleto.VIP))
        {
            prioridad=3;
        }
        else if(clase.equals(ClaseBoleto.MedioVIP))
        {
            prioridad=2;
        }
        else if(clase.equals(ClaseBoleto.Obrera))
        {
            prioridad=1;
        }
        return prioridad;
    }

}
