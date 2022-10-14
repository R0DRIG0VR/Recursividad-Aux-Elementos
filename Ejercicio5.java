public class Ejercicio5 {
    public static int contarRombos(int n){
        //iniciamos la variable respuesta.
        int res;
        /*Al ser un ejercicio de fractales el caso base sera cuando n sea igual a 1
        * ya que en cada llamada recursiva iremos restando 1 a n, y el resultado de este caso base
        * seria 0 ya que en el ejemplo que se nos da en el planteamiento del ejercicio no hay ningun
        * rombo.*/
        if (n == 1){
            res = 0;
        } else {
            /*En este caso la formula para obtener la cantidad de rombos en el triangulo seria
            * el resultado de una llamada recursiva pasandole como parametro n-1 y sumarle a ese resultado
            * 3 elevado a la potencia de n-1*/
            res = contarRombos(n-1) + (int) Math.pow(3,n-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(contarRombos(5));
    }
}
