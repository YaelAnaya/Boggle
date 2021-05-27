package boggle.yael.uabc;
import java.util.Scanner;

/*En esta clase, se realizan las prácticas del funcionamiento
* de nuestro juego Boggle.*/
public class BogglePlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra; //guarda las palabras que indroduce el usuario
        //creamos objetos de bogglebox y jugador
        BoggleBox boggleBox;
        Jugador jugador = new Jugador();

        //mostramos los titulos
        System.out.println("\t BIENVENIDO A BOGGLE\n" +
                "\t[Español]\t[Ingles]");
        //seleccion de idioma
        System.out.print("Selección de idioma: ");
        String idioma = scanner.next().toUpperCase();
        //Este ciclo se ejecuta, si se ingresa un idioma invalido
        while (!idioma.equals("ESPANOL") && !idioma.equals("INGLES")){
            scanner.nextLine();
            System.out.print("Idioma invalido, introduzca alguno de las opciones: ");
            idioma = scanner.next();
        }
        //inicia el juego
        System.out.println();
        //creamos el tablero
        boggleBox = new BoggleBox(idioma);
        boggleBox.mostrarBoggleBox(); //se muestra
        //mensaje cons instruccion para finalizar
        System.out.println("Para terminar el juego, introduzca 'fin' ");
        //ciclo do while, que ingresa palabras
        do {
            System.out.print("Ingrese una palabra: ");
            palabra = scanner.next().toUpperCase();
            //si la palabra, concuerda con la creada
            if (boggleBox.comprobarPalabra(palabra))
                //se guarda en la coleccion del jugador
                jugador.coleccionarPalabras(palabra);
            //si no fue creada, no se guarda y vuelve a preguntar
            else
                System.out.println("Palabra no valida");
        }while (!palabra.equals("FIN"));
        //termina el ciclo he imprime los resultados del juego
        System.out.println("[Puntaje Final]");
        System.out.println("\nEl puntaje fue: " + jugador.calcularPuntosPorPalabra());
    }
}
