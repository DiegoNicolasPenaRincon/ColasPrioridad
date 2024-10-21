package co.edu.uniquindio.alquiler.model;

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

}
