import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio2 {
    /*Definimos el metodo haciendo una llamada a un metodo sobrecargado en el cual le pasaremos los mismos parametros
    * agregandole 2 parametros de tipo entero que fungen como posiciones en el texto por lo que como parametros iniciales
    * le pasaremos el tamaño del texto -1 como posicion inicial y el tamaño del texto como posicion final ya que con estas
    * posiciones haremos como un tipo visualizador de palabras iniciando desde el final*/
    public static ArrayList<String> listaLimpia(String texto, String[] listaProhibida){
        return listaLimpia(texto,listaProhibida,new ArrayList<String>(),texto.length()-1,texto.length());
    }

    private static ArrayList<String> listaLimpia(String texto, String[] listaProhibida, ArrayList<String> listaLimpia, int auxPosIni, int auxPosFin){
        //iniciamos la variable respuesta
        ArrayList<String> res;
        /*Nuestro caso base sera que cuando la posicion inicial de nuestro visualizador sea igual a 0 significa que ya
        * llegamos al primer char del string y no hay mas por recorrer entonces retornamos la palabra que se obtuvo hasta
        * esta posicion usando un substring, una vez se obtenga la palabra validamos si esta palabra se encuentra dentro
        * de la lista de palabras prohibidas, en el caso de que no este se procede a añadirlo al arrayList.*/
        if (auxPosIni == 0){
            String substring = texto.substring(auxPosIni,auxPosFin);
            if (!Arrays.asList(listaProhibida).contains(substring)){
                listaLimpia.add(substring);
            }
            res = listaLimpia;
        } else if (texto.charAt(auxPosIni) == ' '){
            /*Se valida si el caracter en el texto ubicado en la posicion inicial es igual a un caracter vacio
            * (el caracter vacio se lo toma como un separador de palabras), si la condicion se cumple significa que hasta
            * esa posicion se formo una palabra entonces procedemos a obtener esa palabra con un substring sumandole 1 a
            * la posicion inicial ya que asi no tomaremos en cuenta el carater vacio al formar el substring, una vez
            * obtenida la palabra hacemos una llamada recursiva (donde actualizaremos los datos de las posiciones entendiendo
            * que como ya encontramos una palabra al llamar al metodo en el apartado de posicion final pasaria a ser la posicion
            * inicial y la posicion inicial pasaria a ser la misma posicion inicial decrementado en 2 para que de esta
            * forma no tomemos en cuenta el caracter vacio y podamos comenzar a analizar la nueva palabra) para obtener como
            * respuesta un arrayList de tipo String al cual nuevamente dependiendo de la condicional de si es que la palabra
            * obtenida no se encuentra en la lista de palabras prohibidas se añade esa palabra al arrayList que lo obtuvimos
            * de la llamada recursiva.*/
            String substring = texto.substring(auxPosIni+1,auxPosFin);
            listaLimpia(texto,listaProhibida,listaLimpia,auxPosIni-2,auxPosIni);
            if (!Arrays.asList(listaProhibida).contains(substring)){
                listaLimpia.add(substring);
            }
            res = listaLimpia;
        }else {
            /*Caso de que las anteriores condicionales no se cumplan significa que aun no se obtuvo una palabra por lo que
            * tendremos que seguir decrementando el valor de la posicion inicial hasta que alguna de las condiciones anteriores
            * se cumpla, por lo que hacemos una llamada recursiva con los mismos parametros solo que la posicion inicial la
            * decrementamos en 1.*/
            res=listaLimpia(texto,listaProhibida,listaLimpia,auxPosIni-1,auxPosFin);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] listaProhibida = {"mata","fuerte"};
        System.out.println(listaLimpia("lo que no me mata me hace mas fuerte",listaProhibida));
    }
}
