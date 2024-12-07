package co.com.bdb.utils;

import co.com.bdb.inventario.Producto;

import java.util.Scanner;

/**
 * Clase que maneja los flujos del menú de inventario.
 */
public class MenuFlujos {

    private final Scanner scanner = new Scanner(System.in);
    private final Utils utils = new Utils();

    private String menuPpal = "";

    /**
     * Muestra el menú principal y captura la opción seleccionada por el usuario.
     *
     * @return La opción seleccionada por el usuario.
     */
    public String menuPrincipal() {
        utils.imprimirMensaje("Menu Inventario, seleccione una opcion");
        utils.imprimirMensaje("1. Agregar Producto");
        utils.imprimirMensaje("2. Actualizar Producto");
        utils.imprimirMensaje("3. Eliminar Producto");
        utils.imprimirMensaje("4. Buscar por categoría");
        utils.imprimirMensaje("5. Generar Reporte");
        utils.imprimirMensaje("6. Cantidad de productos por categoria");
        utils.imprimirMensaje("7. Producto más caro");
        utils.imprimirMensaje("8. Salir");
        menuPpal = scanner.nextLine();
        return menuPpal;
    }

    /**
     * Lee los datos de un producto desde la entrada estándar.
     *
     * @param isNew Indica si el producto es nuevo o se está actualizando.
     * @return El producto leído o null si hubo un error.
     */
    public Producto leerProducto(boolean isNew) {
        try {
            String id = "";
            if (isNew) {
                utils.imprimirMensaje("Agregar Producto");
                utils.imprimirMensaje("Ingrese el ID del producto:");
                id = scanner.nextLine();
            } else {
                utils.imprimirMensaje("Actualizar Producto");
            }
            utils.imprimirMensaje("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();

            utils.imprimirMensaje("Ingrese la categoria del producto:");
            String categoria = scanner.nextLine();

            utils.imprimirMensaje("Ingrese el precio del producto:");
            String preciot = scanner.nextLine().replace(",", ".");
            double precio = Double.parseDouble(preciot);

            utils.imprimirMensaje("Ingrese la cantidad del producto:");
            int cantidad = scanner.nextInt();

            Producto producto = new Producto();
            producto.setId(id);
            producto.setNombreProducto(nombre);
            producto.setCategoria(categoria);
            producto.setPrecio(precio);
            producto.setCantidadDisponible(cantidad);

            return producto;
        } catch (Exception e) {
            utils.imprimirMensaje("Error al ingresar los datos del producto, intente nuevamente");
        }
        return null;
    }

    /**
     * Obtiene la opción seleccionada en el menú principal.
     *
     * @return La opción seleccionada en el menú principal.
     */
    public String getMenuPpal() {
        return menuPpal;
    }


    /**
     * Lee una línea de entrada desde la entrada estándar.
     *
     * @return La línea leída.
     */
    public String leerLine() {
        return scanner.nextLine();
    }
}