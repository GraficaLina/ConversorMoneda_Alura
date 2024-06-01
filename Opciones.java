import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Opciones {

    private static final String divisaDisponibles = """
                COP ---> Peso Colombiano
                MXN ---> Peso mexicano
                ARS ---> Peso Argentino
                BRL ---> Real Brasileño
                USD ---> Dólar Estadounidense
                EUR ---> Euro""";

    public void menuInicio(){
        System.out.println("****________*****");
        System.out.println("A continuación digíte la opción que desea realizar: \n");
        String menuPrincipal = """
                1. Realizar una conversión
                2. Consultar historial de conversiones
                3. Salir""";
        System.out.println(menuPrincipal);
    }

    public static int opcionUsuario(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("*****************");
        return lectura.nextInt();
    }
    public static void divisasDisponibles(String monedaBase){
        System.out.println("****________*****");
        System.out.println("Seleccione la denominacion " +
                ""+ monedaBase+": \n" );
        System.out.println(divisaDisponibles);
        System.out.println("****________*****");
    }
    public static String leerOpcionMoneda(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!divisaDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opción digitada no está disponible");
            System.out.println("Elija una opción válida");
            System.out.println("****________*****");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public static Double usuarioCantidadMoneda(){
        System.out.println("****________*****");
        System.out.println("Seleccione la cantidad que desea cambiar: \n");
        System.out.println("****________*****");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("****________*****");
            System.out.println("La cantidad digitada no es un número válido");
            System.out.println("Ingrese una cantidad válida");
            System.out.println("****________*****");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public static Double cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal){
        Double resultado = cantidadCambiar * tasaDeConversion;
        System.out.println("****________*****");
        System.out.println(cantidadCambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public static void imprimirConversiones(ArrayList<Conversiones> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se han realizado conversiones.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversiones conversion = listaDeConversiones.get(i);
                System.out.println("Conversión " + (i + 1) + ":");
                System.out.println("Moneda origen: " + conversion.getMonedaBase());
                System.out.println("Moneda objetivo: " + conversion.getMonedaOjetivo());
                System.out.println("Cantidad a cambiar: " + conversion.getCantidadParaCambiar());
                System.out.println("Cantidad obtenida: " + conversion.getCantidadCambiada());
                System.out.println("Fecha y hora: " + formatDateTime(conversion.getCambios()));
                System.out.println("-----------------------------------------");
            }
        }
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }


}
