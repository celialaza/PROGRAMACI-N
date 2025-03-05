import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre y saldo inicial para crear la cuenta
        System.out.print("Introduce el nombre del titular de la cuenta: ");
        String nombre = scanner.nextLine();

        double saldoInicial = 0.0;
        Cuenta cuenta = null;
        boolean saldoValido = false;
        while (!saldoValido) {
            try {
                System.out.print("Introduce el saldo inicial de la cuenta: ");
                saldoInicial = Double.parseDouble(scanner.nextLine());

                // Crear la cuenta con el saldo introducido
                cuenta = new Cuenta(nombre, saldoInicial);  // Aquí se lanza SaldoInvalidoException si el saldo es negativo
                System.out.println("Cuenta creada correctamente.");
                System.out.println("Saldo inicial: " + cuenta.getSaldo());
                saldoValido = true; // Salir del bucle si el saldo es válido
            } catch (SaldoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: El saldo debe ser un número válido.");
            }
        }

        // Menú de operaciones
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de operaciones:");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // Realizar un depósito
                    try {
                        System.out.print("Introduce la cantidad a depositar: ");
                        double cantidadDepositar = Double.parseDouble(scanner.nextLine());
                        cuenta.depositar(cantidadDepositar);
                        System.out.println("Saldo después del depósito: " + cuenta.getSaldo());
                    } catch (CantidadInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: La cantidad debe ser un número válido.");
                    }
                    break;
                case 2:
                    // Realizar un retiro
                    try {
                        System.out.print("Introduce la cantidad a retirar: ");
                        double cantidadRetirar = Double.parseDouble(scanner.nextLine());
                        cuenta.retirar(cantidadRetirar);
                        System.out.println("Saldo después del retiro: " + cuenta.getSaldo());
                    } catch (FondosInsuficientesException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: La cantidad debe ser un número válido.");
                    }
                    break;
                case 3:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }

        scanner.close(); // Cerrar el scanner al final
    }
}
