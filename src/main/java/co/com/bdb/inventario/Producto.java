package co.com.bdb.inventario;

/**
 * Representa un producto en el inventario.
 */
public class Producto {

    private String idProducto;
    private String nombreProducto;
    private String categoria;
    private double precio;
    private int cantidadDisponible;

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Construye un nuevo Producto con los detalles especificados.
     *
     * @param idProducto         el ID del producto
     * @param nombreProducto     el nombre del producto
     * @param categoria          la categoría del producto
     * @param precio             el precio del producto
     * @param cantidadDisponible la cantidad disponible del producto
     */
    public Producto(String idProducto, String nombreProducto, String categoria, double precio, int cantidadDisponible) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return el ID del producto
     */
    public String getId() {
        return idProducto;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id el nuevo ID del producto
     */
    public void setId(String id) {
        this.idProducto = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombreProducto el nuevo nombre del producto
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return la categoría del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria la nueva categoría del producto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio el nuevo precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return la cantidad disponible
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidadDisponible la nueva cantidad disponible
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return una representación en cadena del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + idProducto + '\'' +
                ", nombre='" + nombreProducto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidadDisponible +
                '}';
    }
}