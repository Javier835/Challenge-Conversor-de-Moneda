import com.google.gson.JsonObject;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);



        int userSelectedOption = 0;
        int userValueConverter = 0;

        while(userSelectedOption != 7){
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

            userSelectedOption = lector.nextInt();

            double resultado = 0;

            switch (userSelectedOption){
                case 1:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("USD","DOP");
                    System.out.println("El valor de "+userValueConverter+" USD "+"corresponde al valor final de: "+resultado+" DOP");
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("DOP","USD");
                    System.out.println("El valor de "+userValueConverter+" DOP "+"corresponde al valor final de: "+resultado+" USD");
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("USD","ARS");
                    System.out.println("El valor de "+userValueConverter+" USD "+"corresponde al valor final de: "+resultado+" ARS");
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("ARS","USD");
                    System.out.println("El valor de "+userValueConverter+" ARS"+"corresponde al valor final de: "+resultado+" USD");
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("USD","COP");
                    System.out.println("El valor de "+userValueConverter+" USD "+"corresponde al valor final de: "+resultado+" COP");
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir:");
                    userValueConverter = lector.nextInt();
                    resultado = userValueConverter * convertirMonedas("COP","USD");
                    System.out.println("El valor de "+userValueConverter+" COP "+"corresponde al valor final de: "+resultado+" USD");
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro conversor de monedas");
                    break;
                default:
                    System.out.println("Ingrese un valor valido");
                    break;
            }
        }
    }

    public static double convertirMonedas (String divisaOrigen, String divisaDestino){
        try {
            Webservice ws = new Webservice();
            JsonObject json = ws.consultar(divisaOrigen);

            JsonObject rates = json.getAsJsonObject("conversion_rates");
            return rates.get(divisaDestino).getAsDouble();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
