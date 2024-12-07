package co.com.bdb.inventario;

import co.com.bdb.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Clase que representa el inventario de productos.
 */
public class Inventario {

    // Lista de productos
    private final List<Producto> productos;

    private final Utils utils = new Utils();

    /**
     * Constructor de la clase Inventario.
     *
     * @param productos Lista de productos inicial.
     */
    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene la lista de productos.
     *
     * @return Lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Agregar Producto: Permite añadir un nuevo producto al inventario (archivo).
     *
     * @param paramProducto Producto a agregar.
     * @return true si el producto fue agregado, false en caso contrario.
     */
    public boolean agregarProducto(Producto paramProducto) {
        if (paramProducto != null) {
            this.productos.add(paramProducto);
            utils.imprimirMensaje("Producto agregado");
            return true;
        }
        return false;
    }

    /**
     * Actualizar Producto: Permite actualizar un producto existente en el inventario.
     *
     * @param paramProducto Producto con la información actualizada.
     */
    public void actualizarProducto(Producto paramProducto) {
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId().equals(paramProducto.getId())) {
                this.productos.set(i, paramProducto);
                utils.imprimirMensaje("Producto actualizado");
                break;
            }
        }
    }

    /**
     * Eliminar Producto: Permite eliminar un producto del inventario.
     *
     * @param idProducto ID del producto a eliminar.
     */
    public void eliminarProducto(String idProducto) {
        boolean productoEncontrado = false;
        Iterator<Producto> iterator = this.productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getId().equals(idProducto)) {
                iterator.remove();
                productoEncontrado = true;
                break;
            }
        }
        if (productoEncontrado) {
            utils.imprimirMensaje("Producto eliminado");
        } else {
            utils.imprimirMensaje("Producto no encontrado");
        }
    }

    /**
     * Buscar Producto por Categoría, Nombre e ID del Producto: Filtra y muestra los productos de una categoría específica.
     *
     * @param paramBusqueda Criterio de búsqueda.
     * @return Lista de productos que coinciden con el criterio de búsqueda.
     */
    public List<Producto> buscarProducto(String paramBusqueda) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : this.productos) {
            if (producto.getId().equals(paramBusqueda) ||
                    producto.getCategoria().contains(paramBusqueda) ||
                    producto.getNombreProducto().contains(paramBusqueda)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    /**
     * Buscar Producto por Categoría, Nombre e ID del Producto: Filtra y muestra los productos de una categoría específica.
     */
    public void productoMasCaro() {
        if (this.productos.isEmpty()) {
            utils.imprimirMensaje("No hay productos en el inventario");
            return;
        }

        Producto productoMasCaro = this.productos.get(0);
        for (Producto producto : this.productos) {
            if (producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        utils.imprimirMensaje("Producto mas caro: " + productoMasCaro.toString());
    }

    /**
     * Calcular Cantidad de Productos: Permite conocer la cantidad de productos por categoría.
     */
    public void cantidadProductosPorCategoria() {
        if (this.productos.isEmpty()) {
            utils.imprimirMensaje("No hay productos en el inventario");
            return;
        }

        Map<String, Integer> categoriaCantidadMap = new HashMap<>();
        for (Producto producto : this.productos) {
            categoriaCantidadMap.put(
                    producto.getCategoria(),
                    categoriaCantidadMap.getOrDefault(producto.getCategoria(), 0) + producto.getCantidadDisponible()
            );
        }

        for (Map.Entry<String, Integer> entry : categoriaCantidadMap.entrySet()) {
            utils.imprimirMensaje("Categoria: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }

    /**
     * Muestra el inventario de productos.
     *
     * @param productList Lista de productos a mostrar. Si es null o está vacía, se muestra la lista completa del inventario.
     */
    public void mostrarInventario(List<Producto> productList) {
        if (productList == null || productList.isEmpty()) {
            productList = this.productos;
        }
        if (productList.isEmpty()) {
            utils.imprimirMensaje("No hay productos en el inventario");
            return;
        }
        for (Producto producto : productList) {
            utils.imprimirMensaje(producto.toString());
        }
    }

    /**
     * Reporte de Inventario: Genera un archivo de texto (reporte_inventario.txt) con un resumen del inventario,
     * incluyendo el valor total del inventario (suma de precios * cantidades).
     *
     * @return Valor total del inventario.
     */
    public double reporteInventario() {
        if (this.productos.isEmpty()) {
            utils.imprimirMensaje("No hay productos en el inventario");
            return 0;
        }
        double valorTotalInventario = 0;
        for (Producto producto : this.productos) {
            valorTotalInventario = valorTotalInventario + (producto.getPrecio() * producto.getCantidadDisponible());
        }
        return valorTotalInventario;
    }
}