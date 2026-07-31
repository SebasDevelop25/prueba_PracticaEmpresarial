import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAO();
        int opcion;

        try {
            productoDAO.inicializar();
        } catch (Exception e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
            return;
        }

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(sc.nextLine());  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Ingrese el stock del producto: ");
                    int stock = Integer.parseInt(sc.nextLine());
                    sc.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese la categoría del producto: ");
                    String categoria = sc.nextLine();

                    Producto nuevoProducto = new Producto(nombre, precio, stock, categoria);
                    try {
                        productoDAO.crear(nuevoProducto);
                        System.out.println("Producto creado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error al crear el producto: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        for (Producto p : productoDAO.listar()) {
                            System.out.println(p);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar los productos: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int idBusqueda = Integer.parseInt(sc.nextLine());
                    try {
                        Producto producto = productoDAO.buscarPorId(idBusqueda);
                        if (producto != null) {
                            System.out.println(producto);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar el producto: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idActualizacion = Integer.parseInt(sc.nextLine());
                    try {
                        Producto productoExistente = productoDAO.buscarPorId(idActualizacion);
                        if (productoExistente != null) {
                            System.out.print("Ingrese el nuevo nombre del producto: ");
                            String nuevoNombre = sc.nextLine();
                            System.out.print("Ingrese el nuevo precio del producto: ");
                            double nuevoPrecio = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese el nuevo stock del producto: ");
                            int nuevoStock = Integer.parseInt(sc.nextLine());
                            System.out.print("Ingrese la nueva categoría del producto: ");
                            String nuevaCategoria = sc.nextLine();

                            Producto productoActualizado = new Producto(idActualizacion, nuevoNombre, nuevoPrecio, nuevoStock, nuevaCategoria);
                            if (productoDAO.actualizar(productoActualizado)) {
                                System.out.println("Producto actualizado exitosamente.");
                            } else {
                                System.out.println("Error al actualizar el producto.");
                            }
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al actualizar el producto: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminacion = Integer.parseInt(sc.nextLine());
                    try {
                        if (productoDAO.eliminar(idEliminacion)) {
                            System.out.println("Producto eliminado exitosamente.");
                        } else {
                            System.out.println("Error al eliminar el producto.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al eliminar el producto: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    } 
}
