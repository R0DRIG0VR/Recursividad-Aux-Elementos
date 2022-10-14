public class Ejercicio4 {

    /*Hacemos una llamada a un metodo sobrecargado en el cual le pasaremos 2 parametros extras de tipo entero que serviran
    * para ir navegando en ambos strings*/
    public static boolean buscarPalabra(String sec1,String sec2){
        return buscarPalabra(sec1,sec2,0,0);
    }

    private static boolean buscarPalabra(String sec1,String sec2,int posSec1,int posSec2){
        //iniciamos la variable respuesta.
        boolean res;

        /*En esta ocacion se podria llegar a decir que tenemos 2 casos bases, la primera donde si la posicion de la secuencia
        * 2 es igual al tamaño de la misma secuencia significa que terminamos de analizar el string y que ya no quedan mas
        * carateres por analizar por lo que la secuencia 2 al ser la palabra que estamos buscando significaria que se pudo
        * encontrar la palabra dentro de la secuencia 1 por lo que la respuesta seria verdadero */
        if (posSec2 == sec2.length()){
            res = true;
        } else if (posSec1 == sec1.length()) {
            /*Tenemos el segundo caso base donde si la posicion de la secuencia 1 es igual al tamaño de la misma secuencia
            * significa que ya habriamos recorrido toda la secuencia 1 y que ya no queda mas por analizar y teniendo en cuenta
            * que la secuencia 1 es el string donde tenemos que buscar la palabra de la secuencia 2 al ya no haber mas por
            * analizar significa que no se pudo encontrar la palabra (ya que aun quedarian caracteres en la secuencias 2 por
            * analizar) por lo que la respuesta seria un falso*/
            res = false;
        } else {
            /*Iniciamos 2 variables auxiliares de tipo entero que recibiran el mismo valor que la posicion de la secuencia
            * 1 y 2*/
            int auxPosSec2 = posSec2;
            int auxPosSec1 = posSec1;

            /*Obtenemos los caracteres actuales en base a las posiciones tanto de la secuencia 1 como de la 2*/
            char charSec1 = sec1.charAt(posSec1);
            char charSec2 = sec2.charAt(posSec2);

            /*Hacemos la comparacion de los caracteres obtenidos*/
            if (charSec2 == charSec1){
                /*Caso de que ambos caracteres sean iguales significaria que ya encontramos un caracter de la palabra de
                * la secuencia 2 dentro de un caracter de la secuencia 1 por lo que para las posiciones de la siguiente
                * llamada recursiva avanzariamos en 1 en ambas secuencias para seguir comparando*/
                auxPosSec2 ++;
                auxPosSec1 ++;
            }else{
                /*En el caso de que ambos caracteres no sean iguales se procede a seguir buscando en la secuencia 1
                * por lo que solamente actualizamos la posicion 1 sumandole 1 para pasar al siguiente caracter y mantenemos
                * la posicion de la secuencia 2*/
                auxPosSec1 ++;
            }
            //Realizamos la llamada recursiva con los parametros obtenidos
            res = buscarPalabra(sec1,sec2,auxPosSec1,auxPosSec2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(buscarPalabra("Hasta ahora, nada prendió, la tierra es muy infértil. Hay muchas clases","alma"));
    }
}