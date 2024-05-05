import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("**********Bienvenido al Sistema de Conversión de CasHua**********");
        String menu = """
                *** Digite el número en el menú de la operación que desea realizar: ***
                1 - Convertir
                9 - Salir
                """;
        Scanner lectura = new Scanner(System.in);

int opcionMenu = 0;

            System.out.println(menu);
        ConsultaMoneda consulta = new ConsultaMoneda();

while (opcionMenu !=9){
    opcionMenu = lectura.nextInt();
    if (opcionMenu==9) {
        System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios.");
    }else if (opcionMenu==1) {

        System.out.println("Escriba el tipo de cambio que desea convertir:\nARS - Peso argentino\nBOB - Boliviano boliviano\nBRL - Real brasileño\nCLP - Peso chileno\nCLP - Peso chileno\nUSD - Dólar estadounidense\nEUR - Euro\nPEN - Sol Peruano ");
        String valorDeMoneda3 = String.valueOf(lectura.nextLine());
            String valorDeMoneda = String.valueOf(lectura.nextLine());
            System.out.println("ahora el tipo de moneda destino: ");
            String valorDeMoneda2 = String.valueOf(lectura.nextLine());
            System.out.println("Escriba el monto: ");
            double monto = Double.parseDouble(lectura.nextLine());

            try {
                Moneda tipoCambio = consulta.buscaMoneda(valorDeMoneda, valorDeMoneda2, monto);

                System.out.println("el resultado de tu conversion es " + tipoCambio);


                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(tipoCambio);
                System.out.println(menu);
            } catch (NumberFormatException e) {
                System.out.println("tipo de cambio no encontrado " + e.getMessage());
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la app");
            }
    }
        }
        }
}


