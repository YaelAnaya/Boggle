package boggle.yael.uabc;
import java.util.HashSet;

/* Esta clase modela a un jugador, el cual tiene un HashSet donde se guardan
 * las palabras que va encontrando, y gracias al mismo no pueden repetirse.
 * El jugador también cuenta con un puntaje que se le da a conocer al final
 * del juego */
public class Jugador {
    private HashSet<String> palabrasEncontradas;
    private int puntajeDelJugador;

    /* Constructor del jugador donde creamos el HashSet que contendrá
        las palabras encontradas */
    public Jugador() {
        palabrasEncontradas = new HashSet<>();
    }
    //Getter
    public HashSet<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    /* Este método nos sirve para guardar la palabra introducidas.*/
    public boolean coleccionarPalabras(String palabra){
        return palabrasEncontradas.add(palabra);
    }

    /* Sacamos el puntaje al final del juego para darselo a conocer al jugador
     * donde una palabra de 5 letras vale 5 puntos, y una palabra con más, vale
     * 10 puntos. Además que, se agregan puntos según el numero de palabras que
     * el jugador haya encontrado.*/

    public int calcularPuntosPorPalabra(){
        puntajeDelJugador = 0;
        for (String palabra : palabrasEncontradas){
            if (palabra.length() == 5) {
                puntajeDelJugador += 5;
                System.out.println(palabra + "\tPuntos obtenidos = 5");
            }
            else if (palabra.length() > 5) {
                puntajeDelJugador += 10;
                System.out.println(palabra + "\tPuntos obtenidos = 10");
            }
            else if (palabra.length() < 5) {
                puntajeDelJugador += 3;
                System.out.println(palabra + "\tPuntos obtenidos = 3");
            }
        }

        System.out.println("Puntos por palabras encontradas = " + palabrasEncontradas.size() * 2);
        return puntajeDelJugador += palabrasEncontradas.size() * 2;
    }
}
