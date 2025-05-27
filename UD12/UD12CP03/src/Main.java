import model.Producto;
import model.ProductoAlimenticio;
import model.ProductoElectronico;
import model.ProductoHigiene;
import model.dao.AccesoBD;
import model.dao.ProductoDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 10;
        ProductoDAO dao = new ProductoDAO();
        Set<Producto> productos = dao.getProductos();
        do {
            try {
                System.out.println("GESTIÓN DE INVENTARIO");
                System.out.println("=====================");
                System.out.println("1. Añadir un nuevo producto al inventario");
                System.out.println("2. Eliminar un producto por su código");
                System.out.println("3. Buscar un producto por su código");
                System.out.println("4. Listar todos los productos disponibles");
                System.out.println("5. Filtrar productos por precio mínimo y máximo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Tipo (alimenticio,electronico,higiene): ");
                        String tipo = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine());
                        String extra ="";
                        Producto producto=null;
                        switch (tipo.toLowerCase()) {
                            case "alimenticio" -> {
                                System.out.print("Fecha de caducidad (dd/MM/yyyy): ");
                                extra = sc.nextLine();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate fechaCaducidad = LocalDate.parse(extra, dtf);
                                Date fecha = Date.valueOf(fechaCaducidad);
                                producto = new ProductoAlimenticio(codigo, nombre, tipo, precio, fecha);
                            }
                            case "electronico" -> {
                                System.out.print("Meses de garantía: ");
                                extra = sc.nextLine();
                                int garantia = Integer.parseInt(extra);
                                producto = new ProductoElectronico(codigo, nombre, tipo, precio, garantia);
                            }
                            case "higiene" -> {
                                System.out.print("Desinfectante (true/false): ");
                                extra = sc.nextLine();
                                boolean desinfectante = Boolean.parseBoolean(extra);
                                producto = new ProductoHigiene(codigo, nombre, tipo, precio, desinfectante);
                            }
                            default -> System.out.println("El tipo de producto no existe");
                        }

                        if (dao.insertarProducto(producto)>0) {
                            System.out.println("El producto se ha guardado correctamente");
                            productos.add(producto);
                        }else
                            System.out.println("El producto no se ha guardado");
                    }
                    case 2 -> {
                    }
                    case 3 -> {
                        System.out.print("Buscar producto por código:");
                        String codigo = sc.nextLine();
                        for (Producto producto : productos) {
                            if (producto.getCodigo().equals(codigo)) {
                                System.out.println(producto);
                            }
                        }
                    }
                    case 4 -> {
                        for(Producto producto : productos) {
                            System.out.println(producto);
                        }
                    }
                    case 5 -> {
                        System.out.print("Precio mínimo: ");
                        double precioMin = Double.parseDouble(sc.nextLine());
                        System.out.print("Precio máximo: ");
                        double precioMax = Double.parseDouble(sc.nextLine());
                        for (Producto producto : productos) {
                            if (producto.getPrecio()>=precioMin && producto.getPrecio()<=precioMax) {
                                System.out.println(producto);
                            }
                        }
                    }
                    case 0 -> {
                    }
                    default -> System.out.println("Opción no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir una opción válida");
            }
        } while (opcion != 0);


        sc.close();
    }
}
