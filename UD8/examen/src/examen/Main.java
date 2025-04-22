package examen;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /*Scanner sc = new Scanner(System.in);
        System.out.println("--- Agregar examen.Producto ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        String precio = sc.nextLine();
        System.out.print("Categoría: ");
        String correo = sc.nextLine();
        agregarProducto(new Producto(nombre, precio, correo));
    }
        private static void agregarProducto(Producto p) {

                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(new FileWriter("productos.txt", true));
                    pw.println(p.getNombre() + "," + p.getPrecio() + "," + p.getCategoria());
                    System.out.println("examen.Producto agregado correctamente!");
                } catch (FileNotFoundException e) {
                    System.out.println("No se encuentra el archivo");
                } catch (IOException e) {
                    System.out.println("Error al escribir en el archivo");

                } finally {
                    if (pw != null)
                        pw.close();
                }}}*/

        SwingUtilities.invokeLater(() -> {
            Lector l = new Lector();
            l.setVisible(true);
        });

    }}



