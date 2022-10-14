import java.util.ArrayList;

public class Ejercicio3 {

    /*Hacemos una llamada a un metodo sobrecargado en el cual le pasaremos como parametro extra un arrayList de tipo
    * interger que ayudara a la logica de validacion de los digitos*/
    public static int eliminarOcurrencias(int num){
        return eliminarOcurrencias(num,new ArrayList<Integer>());
    }

    public static int eliminarOcurrencias(int num,ArrayList<Integer> usados){
        //iniciamos la variable respuesta.
        int res = 0;
        //Obtenemos el ultimo digito del numero introducido.
        int ultimoDigito = num%10;

        /*Nuestro caso base sera cuando la cantidad de digitos del numero sea igual a 1 ya que en cada llamada recursiva
        * iremos pasando el numero menos el ultimo digito*/
        if ((int) (Math.log10(num) + 1) == 1){
            /*Caso de que se cumpla la condicion validaremos si nuestro arrayList no contiene el digito*/
            if (!usados.contains(num)){
                /*Si se cumple la condicion significa que ese digito aun no fue añadido por lo que procedemos a
                * retornar el mismo numero multiplicado por 10 elevado al tamaño del arrayList ya que de esta forma
                * mantendremos el orden secuencial de los digitos (en el caso base por el hecho de ser caso base ya no es
                * necesario añadir el digito al arrayList ya que no hay mas digitos para validar)*/
                res = num * (int) Math.pow(10,usados.size());
            }
        } else if (!usados.contains(ultimoDigito)){
            /*Validamos si nuestro arrayList no contiene el ultimo digito del numero introducido, si se cumple la condicion
            * procedemos a añadir el digito al arrayList, luego hacemos una llamada recursiva donde le pasaremos el numero
            * menos el utlimo digito y el arrayList con el digito añadido, el metodo nos retornara un numero entero el cual
            * le sumaremos al ultimo digito por 10 elevado al index que este mismo ocupa en el arrayList haciendose esto
            * para mantener el orden secuencial de los digitos*/
            usados.add(ultimoDigito);
            res = eliminarOcurrencias(num/10,usados) + ultimoDigito * (int) Math.pow(10,usados.indexOf(ultimoDigito));
        } else {
            /*Caso de que las anteriores condicionales no se cumplan significa que no llegamos al caso base o el ultimo
            * digito obtenido se encuentra en el arrayList de numeros usados por lo que tendremos que seguir buscando digitos
            * validos asi que se hace la llamada recursiva menos el ultimo digito y con el arrayList actual de digitos usados*/
            res = eliminarOcurrencias(num/10,usados);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(eliminarOcurrencias(2356342));
    }
}
