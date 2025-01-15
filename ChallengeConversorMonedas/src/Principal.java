import java.awt.geom.Arc2D;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        try {
            // Obtener tasas de cambio desde la API
            TasaDeCambio tasas = consulta.buscaTasaDeCambio("USD");
            ConversorMoneda conversor = new ConversorMoneda(tasas.conversion_rates());

            // Menú de opciones
            boolean continuar = true;
            double resultado;
            Double cantidadIngresada;
            int opcion=0;


            while (continuar) {
                System.out.println("*****************************************");
                System.out.println("Bienvenido al Conversor de Moneda aplicando POO");
                System.out.println("1) Peso Argentino a Dólar");
                System.out.println("2) Dólar a Peso Argentino");
                System.out.println("3) Dólar a Real brasileño");
                System.out.println("4) Real brasileño  a Dolar");
                System.out.println("5) Dólar a Peso colombiano");
                System.out.println("6) Peso Colombiano a Dolar");
                System.out.println("7) Salir");
                System.out.println("Elija una opción válida:");
                System.out.println("*****************************************");

                //validamos la opcion
                if(scanner.hasNextInt()){
                    opcion=scanner.nextInt();
                    continuar=true;
                }else{
                    System.out.println("Entrada invalida ...");
                    scanner.next();
                }



                switch (opcion) {
                    case 1:
                        // Peso Argentino a Dólar
                        cantidadIngresada=pedirDatos("Argentinos");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("ARS", "USD", cantidadIngresada);
                            System.out.printf("El monto %.2f ARS equivale a %.2f USD.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }
                        break;

                    case 2:
                        // Dólar a Peso Argentino
                        cantidadIngresada=pedirDatos("Dolares");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("USD", "ARS", cantidadIngresada);
                            System.out.printf("El monto %.2f USD equivale a %.2f ARS.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }

                        break;

                    case 3:
                        // Dólar a Real brasileño
                        cantidadIngresada=pedirDatos("Dolares");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("USD", "BRL", cantidadIngresada);
                            System.out.printf("El monto %.2f USD equivale a %.2f BRL.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }
                        break;

                    case 4:
                        // Real brasileño a Dólar
                        cantidadIngresada=pedirDatos("Reales Brasileños");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("BRL", "USD", cantidadIngresada);
                            System.out.printf("El monto %.2f BRL equivale a %.2f USD.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }
                        break;

                    case 5:
                        // Dólar a Peso colombiano
                        cantidadIngresada=pedirDatos("Dolares");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("USD", "COP", cantidadIngresada);
                            System.out.printf("El monto %.2f USD equivale a %.2f COP.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }
                        break;

                    case 6:
                        // Peso Colombiano a Dólar
                        cantidadIngresada=pedirDatos("Pesos Colombianos");
                        if(cantidadIngresada !=null){
                            resultado = conversor.convertir("COP", "USD", cantidadIngresada);
                            System.out.printf("El monto %.2f COP equivale a %.2f USD.\n", cantidadIngresada, resultado);
                        }else{
                            System.out.println("Por favor intenta nuevamente...");
                        }
                        break;

                    case 7:
                        // Salir
                        continuar = false;
                        System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static Double pedirDatos(String cadena){

        Scanner scanner= new Scanner(System.in);
        System.out.print("Ingrese la cantidad en " +cadena+":");
        //validamos la opcion
        if(scanner.hasNextDouble()){

            return scanner.nextDouble();
        }else{
            System.out.println("Entrada invalida ingrese un dato valido , debe de ser un numero ... ");
            scanner.next();
            return null;
        }

    }
}
