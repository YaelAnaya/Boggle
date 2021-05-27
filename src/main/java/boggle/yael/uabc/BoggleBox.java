package boggle.yael.uabc;
import java.util.*;

/*La clase BoggleBox modela la caja de dados que se le mostrará al jugador */
public class BoggleBox {
    private Random random; //Este objeto random nos ayuda''a a revolver los dados
    private DadoBoggle [][] box; //Este será nuestro tablero / caja
    private ArrayList<String> palabrasGeneradas; //Lista de palabras, que se generan y puede ingresar el usuario

    /*Creamos el constructor que recibe el idoma, que selecciona la combinacion de caras del dado*/
    public BoggleBox(String idioma) {

        box = new DadoBoggle[5][5]; //creamos la matriz
        palabrasGeneradas = new ArrayList<>(); //creamos nuestro arratList
        random = new Random();//creamos el objeto random
        crearBoggleBox(idioma); //Creamos una caja, según el idioma
        revolverBox(); //Llamamos al método y la revolvemos
        buscarPalabras(); //Mandamos llamar al método de busqueda para tener las palabras listas
    }
    //Getter
    public ArrayList<String> getPalabrasGeneradas() {
        return palabrasGeneradas;
    }

    /*En este método creamos nuestro dados, dependiendo el idioma (ESPAÑOL - INGLES)*/
    public void crearBoggleBox(String idioma){
        //En esta matriz, se guardan las combinaciones para el Español
        String[][] versionEspañol = {{"QBZJXl","TOUOTO","OVCRGR","AAAFSR","AUMEEO"},
                                     {"EHLRDO","NHDTHO","LHNROD","ADAISR","UIFASR"},
                                     {"TELPCI","SSNSEU","RIYPRH","DORDLN","CCÑNST"},
                                     {"TTOTEM","SCTIEP","EANDNN","MNNEAG","UOTOÑN"},
                                     {"AEAEEH","YIFPSR","EEEEMA","ITATIE","ETILAC"}};
        //En esta matriz, se guardan las combinaciones para el Ingles
        String[][] versionIngles = {{"QBZJXK","TOUOTO","OVWRGR","AAAFSR","AUMEEG"},
                                    {"HHLRDO","NHDTHO","LHNROD","AFAISR","YIFASR"},
                                    {"TELPCI","SSNSEU","RIYPRH","DORDLN","CCWNST"},
                                    {"TTOTEM","SCTIEP","EANDNN","MNNEAG","UOTOWN"},
                                    {"AEAEEE","YIFPSR","EEEEMA","ITITIE","ETILIC"}};

        String caraAuxiliar = "";
        //Con estos ciclos llenamos la caja con los dados
        for (int fila = 0; fila < 5; fila++){
            for (int columna = 0; columna < 5; columna++){
                //Condicion que llena con combinaciones para el idioma ingles, si es verdadera
                if(idioma.equals("ESPANOL")){
                    caraAuxiliar = versionEspañol[fila][columna];
                }
                //Condicion que llena con combinaciones para el idioma español, si es verdadera
                else if(idioma.equals("INGLES")){
                    caraAuxiliar = versionIngles[fila][columna];
                }
                box[fila][columna] = new DadoBoggle(caraAuxiliar);
            }

        }
    }

    /*Revuelve los dados dentro del Boggle Box para cambiar su posición.*/
    public void revolverBox(){
        int filaAleatoria, columnaAleatoria;
        DadoBoggle dadoAuxiliar;

        for (int fila = 0; fila < 5; fila ++){
            for (int columna = 0; columna < 5; columna ++){
                filaAleatoria = random.nextInt(5);
                columnaAleatoria = random.nextInt(5);

                dadoAuxiliar = box[fila][columna];
                box[fila][columna] = box[filaAleatoria][columnaAleatoria];
                box[filaAleatoria][columnaAleatoria] = dadoAuxiliar;
            }
        }
    }

    /*Muestra en consola nuestro BoggleBox*/
    public void mostrarBoggleBox(){
        for (int fila = 0; fila < 5; fila++){
            for (int columna = 0; columna < 5; columna++){
                System.out.print("\t" + box[fila][columna] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    /*Este método invierte la palabra que se le de. */
    public String invertirPalabra(String palabra) {
        StringBuilder palabraInvertida = new StringBuilder();
        for (int index = palabra.length() - 1; index >= 0; index--) {
            palabraInvertida.append(palabra.charAt(index));
        }
        return palabraInvertida.toString();
    }

    /* Con este método buscamos las palabras que se puedan formar con las caras
     * de los dados que hayan quedado "arriba" de esta forma podremos comparar
     * las String introducidas por el usuario con las disponibles.*/
    public ArrayList<String> buscarPalabras(){
        //Buscamos palabras horizontales
        for (int fila = 0; fila < 5; fila++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int columna = 0; columna < 5; columna++) {
                stringBuffer = stringBuffer.append(box[fila][columna].getCaraActual());
                //condicionamos, para agregar palabras de 3 letras o mas
                if(stringBuffer.toString().length() >= 2){
                    //agregamos la palabra horizontal
                    palabrasGeneradas.add(stringBuffer.toString());
                    //agregamos la palabra invertida
                    palabrasGeneradas.add(invertirPalabra(stringBuffer.toString()));
                }
            }
        }

        //Buscamos palabras horizontales
        for (int fila = 0; fila < 5; fila++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int columna = 0; columna < 5; columna++) {
                stringBuffer = stringBuffer.append(box[columna][fila].getCaraActual());
                //condicionamos, para agregar palabras de 3 letras o mas
                if(stringBuffer.toString().length() >= 2){
                    //agregamos la palabra vertical
                    palabrasGeneradas.add(stringBuffer.toString());
                    //agregamos la palabra invertida
                    palabrasGeneradas.add(invertirPalabra(stringBuffer.toString()));
                }
            }
        }

        return palabrasGeneradas;
    }

    /*Para comparar la palabra del usuario con las contenidas en el ArrayList*/
    public boolean comprobarPalabra(String palabra){
        return palabrasGeneradas.contains(palabra);
    }

}
