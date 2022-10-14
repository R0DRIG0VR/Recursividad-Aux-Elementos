public class Ejercicio1 {

    public static int sumaDigitos(int num){
        //iniciamos la variable respuesta
        int res;
        /*Validamos si la cantidad de digitos como parametro es igual a 1 el cual seria nuestro caso base
        * ya que para esta resolucion iremos quitando el ultimo digito en cada llamada recursiva hasta que solo quede un
        * digito, donde retornaremos el mismo digito*/
        if ((int) (Math.log10(num) + 1) == 1){
            res = num;
        } else {
            /*Caso contrario hacemos la llamada recursiva pasandole el numero menos el ultimo digito
            * y un vez obtenido el resultado lo que hacemos es sumarle con el ultimo digito que le quitamos*/
            res = sumaDigitos(num/10) + num % 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumaDigitos(123));
    }
}
