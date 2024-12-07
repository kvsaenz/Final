package co.com.bdb.utils;

import co.com.bdb.inventario.Producto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Utils {


    public void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * guardar lista de productos en un archivo txt donde cada campo es separado por ;
     */

    public void guardarInventario(List<Producto>  productos, String path, String msgFinal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            // se recorre la lista de productos y se escribe en el archivo
            for (Producto producto : productos) {
                writer.write(producto.getId() + ";" +
                        producto.getNombreProducto() + ";" +
                        producto.getCategoria() + ";" +
                        producto.getPrecio() + ";" +
                        producto.getCantidadDisponible());
                writer.newLine();
            }
            // cuando llega un mensaje final, se escribe en el archivo al final
            if (!msgFinal.isEmpty()) {
                writer.write(msgFinal);
            }
        } catch (IOException e) {
            imprimirMensaje(e.getMessage());
        }
    }

    /**
     * cargar lista de productos desde un archivo txt donde cada campo es separado por ;
     */

    public List<Producto> cargarInventario(String path) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            // se lee cada linea del archivo y se crea un producto con los campos separados por ;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 5) {
                    Producto producto = new Producto();
                    producto.setId(fields[0]);
                    producto.setNombreProducto(fields[1]);
                    producto.setCategoria(fields[2]);
                    producto.setPrecio(Double.parseDouble(fields[3]));
                    producto.setCantidadDisponible(Integer.parseInt(fields[4]));
                    productos.add(producto);
                }
            }
        } catch (IOException e) {
            imprimirMensaje(e.getMessage());
        }
        return productos;
    }
}
