package boggle.yael.uabc;
/*Esta clase modela un dado alfabetico,
y hereda de la clase Dado*/
public class DadoBoggle extends Dado{
    private String letrasDeLaCara; //Aquí se guardan las caras del dado

    /*Recibe una cadena de letras que serán asignadas 
    a las diferentes caras del dado*/
    public DadoBoggle(String carasDelDadoBoggle) {
        super();
        letrasDeLaCara = carasDelDadoBoggle;
    }

    @Override
    public String toString() {
        return letrasDeLaCara.substring(valor, valor + 1);
    }
    /* Getters y Setters*/
        public String getCaraActual() {
        return letrasDeLaCara.substring(valor, valor + 1);
    }

}
