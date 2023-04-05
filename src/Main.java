// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        //primer string
        String a = "{123(123)123}";
        //Imprime en consola si existe un balance de signos con el primer string
        System.out.println("R = " + balanceado(a));

        //Segundo string
        String b = "([{})";
        //Imprime en consola si existe un balance de signos con el segundo string
        System.out.println("R = " + balanceado(b));
    }

    //Funcion que verificara si existe un balance de signos : devolvera un boolean
    public static boolean balanceado(String cadena){
        //Se crea una pila
        Stack<Character> pila = new Stack<Character>();

        //Recorre el string que recibe como parametro
        for(int i = 0; i < cadena.length(); i++){
            //Guarda un caracter
            char simbolo = cadena.charAt(i);

            //Comprueba si existe un simbolo de apertura
            if(simbolo == '[' || simbolo == '(' || simbolo == '{'){
                //agrega a la pila el simbolo
                pila.push(simbolo);
            }//En el caso de que haya un simbolo de apertura comprueba si existe un simbolo de cierre
            else if(simbolo == ')' || simbolo == ']' || simbolo == '}'){
                //Si la pila esta vacia retorna falso, ya que debe existir algo en la pila con lo que se pueda comparar el simbolo de cierre
                if(pila.isEmpty()){
                    return false;
                }

                //Guarda el simbolo de apertura que se encuentra en la pila y ademas lo remueve
                char sApertura = pila.pop();
                //Comprueba de que el simbolo (cierre) que se esta inspeccionando no sea igual al de apertura; porque si esto es asi retornara falso
                if((simbolo == ')' && sApertura != '(') ||  (simbolo == ']' && sApertura != '[') || (simbolo == '}' && sApertura != '{')){
                    return false;
                }
            }
        }
        //Retorna un boolean depende de si la pila esta vacia o contiene algo.
        return pila.isEmpty();
    }

}