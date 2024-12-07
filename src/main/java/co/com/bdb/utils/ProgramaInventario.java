package co.com.bdb.utils;

import co.com.bdb.inventario.Inventario;
import co.com.bdb.inventario.Producto;

import java.util.List;

public class ProgramaInventario {

    /**
     * Ejecuta el programa de inventario, gestionando el flujo principal del inventario de productos.
     */
    public void ejecutarInventario() {
        Utils utils = new Utils();

        // Carga el inventario desde el archivo especificado y lo muestra
        Inventario inventario = new Inventario(utils.cargarInventario(Constantes.PATH_INVENTARIO));
        inventario.mostrarInventario(null);

        MenuFlujos menuFlujos = new MenuFlujos();

        // Bucle principal del menú
        while (!menuFlujos.getMenuPpal().equalsIgnoreCase(Constantes.OCHO)) {
            menuFlujos.menuPrincipal();
            switch (menuFlujos.getMenuPpal()) {
                case "1":
                    // Agregar Producto
                    if (inventario.agregarProducto(menuFlujos.leerProducto(true))) {
                        menuFlujos.leerLine();
                    }
                    break;
                case "2":
                    // Actualizar Producto
                    // Solicita al usuario que ingrese el ID del producto que desea actualizar
                    utils.imprimirMensaje("Ingrese el ID del producto que desea actualizar:");

                    // Busca el producto en el inventario utilizando el ID proporcionado
                    List<Producto> p = inventario.buscarProducto(menuFlujos.leerLine());

                    // Si no se encuentra el producto, muestra un mensaje de error
                    if (p.isEmpty()) {
                        utils.imprimirMensaje("Producto no encontrado");
                        break;
                    } else {
                        // Si se encuentra el producto, muestra la información del primer producto encontrado
                        utils.imprimirMensaje("Producto encontrado: " + p.getFirst().toString());
                    }

                    // Obtiene el primer producto de la lista de resultados de búsqueda
                    Producto producto = p.getFirst();

                    // Lee los nuevos datos del producto desde la entrada estándar
                    Producto productoActualizado = menuFlujos.leerProducto(false);

                    // Si los datos del producto son ingresados sin error, actualiza el producto en el inventario
                    if (productoActualizado != null) {
                        productoActualizado.setId(producto.getId());
                        inventario.actualizarProducto(productoActualizado);
                        menuFlujos.leerLine();
                    }
                    break;
                case "3":
                    // Eliminar Producto
                    utils.imprimirMensaje("Ingrese el ID del producto a eliminar:");
                    inventario.eliminarProducto(menuFlujos.leerLine());
                    break;
                case "4":
                    // Buscar Producto por Categoría
                    utils.imprimirMensaje("Ingrese la categoria del producto:");
                    inventario.mostrarInventario(inventario.buscarProducto(menuFlujos.leerLine()));
                    break;
                case "5":
                    // Generar Reporte de Inventario
                    double reporteInventario = inventario.reporteInventario();
                    List<Producto> inv = inventario.getProductos();
                    utils.guardarInventario(inv, Constantes.PATH_INVENTARIO_REP, "Total Inventario: " + reporteInventario);
                    utils.imprimirMensaje("Reporte generado en: " + Constantes.PATH_INVENTARIO_REP);
                    break;
                case "6":
                    // Calcular Cantidad de Productos por Categoría
                    inventario.cantidadProductosPorCategoria();
                    break;
                case "7":
                    // Mostrar Producto más Caro
                    inventario.productoMasCaro();
                    break;
                case "8":
                    // Salir del Programa
                    break;
                default:
                    utils.imprimirMensaje("Opción no válida");
                    break;
            }
            // Guardar el inventario actualizado después de cada operación
            utils.guardarInventario(inventario.getProductos(), Constantes.PATH_INVENTARIO, "");
        }
        // Guardar el inventario al salir del programa
        utils.imprimirMensaje("Saliendo del programa inventario");
    }
}