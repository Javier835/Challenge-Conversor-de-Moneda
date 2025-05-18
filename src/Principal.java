import com.google.gson.JsonObject;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //variable para capturar respuestas de los usuarios
        Scanner lector = new Scanner(System.in);

        //variables para capturar la selección del usuario y el valor a convertir
        int userSelectedOption = 0;
        int userValueConverter = 0;

        //variable para capturar el resultado de la conversión
        double resultado = 0;

        //variables para almacenar el tipo de divisa origen y destino para cada conversión
        String divisaOrigen = "";
        String divisaDestino = "";

        //bucle para repetir el menú hasta que el usuario seleccione la opción 7
        while(userSelectedOption != 7){
            //menú que se muestra al usuario
            System.out.println("*******************************************************************");
            System.out.println("Sean bienvenidos al conversor de monedas");

            System.out.println("1) Dólar =>> Peso Dominicano");
            System.out.println("2) Peso Dominicano =>> Dólar");
            System.out.println("3) Dólar =>> Peso Argentino");
            System.out.println("4) Peso Argentino =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida");
            System.out.println("*******************************************************************");

            //capturar la selección del usuario
            userSelectedOption = lector.nextInt();

            if(userSelectedOption >= 1 && userSelectedOption <= 7){

                //switch case para evaluar la conversión que corresponda según la opción seleccionada por el usuario
                switch (userSelectedOption){
                    case 1:
                        divisaOrigen = "USD";
                        divisaDestino = "DOP";
                        break;
                    case 2:
                        divisaOrigen = "DOP";
                        divisaDestino = "USD";
                        break;
                    case 3:
                        divisaOrigen = "USD";
                        divisaDestino = "ARS";
                        break;
                    case 4:
                        divisaOrigen = "ARS";
                        divisaDestino = "USD";
                        break;
                    case 5:
                        divisaOrigen = "USD";
                        divisaDestino = "COP";
                        break;
                    case 6:
                        divisaOrigen = "COP";
                        divisaDestino = "USD";
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar nuestro conversor de monedas");
                        break;
                    default:
                        System.out.println("Ingrese un valor valido");
                        break;
                }

                //comprobar si el usuario no haya seleccionado la opción 7 para salir
                if (userSelectedOption != 7){
                    System.out.println("Ingrese el valor que desea convertir:"); //mensaje que pide al usuario insertar el valor a convertir
                    userValueConverter = lector.nextInt(); //capturando el valor digitado por el usuario

                    resultado = userValueConverter * convertirMonedas(divisaOrigen,divisaDestino); //calculando el resultado multiplicando el valor a convertir por el resultado de la función convertir monedas
                    System.out.println("El valor de "+userValueConverter+" "+divisaOrigen+" corresponde al valor final de: "+resultado+" "+divisaDestino); //Respuesta al usuario con los datos de conversión
                }

            }
        }
    }

    //metodo para realizar la conversión de monedas
    public static double convertirMonedas (String divisaOrigen, String divisaDestino){
        try {
            Webservice ws = new Webservice();
            JsonObject json = ws.consultar(divisaOrigen);

            JsonObject rates = json.getAsJsonObject("conversion_rates");
            return rates.get(divisaDestino).getAsDouble();

        } catch (Exception e) {
            System.out.println("Ha ocurrido el siguiente error: "+ e.getMessage());
        }
        return 0;
    }
}
