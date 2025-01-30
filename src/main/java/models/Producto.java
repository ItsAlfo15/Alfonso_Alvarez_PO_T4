package models;


public class Producto {

    // Atributos
    private String nombre;
    private float precio;
    private int cantidad;

    // Constructor
    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo que suma el stock de un producto
    public void sumaCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    // Metodo que resta el stock de un producto al hacer un pedido
    public void restacantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    // Metodo que multiplica el predio por la cantidad del producto
    public float sumaPrecio() {
        return precio * cantidad;
    }

    // Menu que pinta el producto
    public String pintaProducto() {
        return """
        ╔════════════════════════════════════════════════════════════════════╗
        ║                              PRODUCTO                              ║
        ╠════════════════════════════════════════════════════════════════════╣
        ║ Nombre:   %s
        ║ Precio:   %.2f Euros
        ║ Cantidad: %s
        ╚════════════════════════════════════════════════════════════════════╝
        """.formatted(
                nombre,precio,(cantidad <= 0) ? "Agotado" : cantidad
        );
    }

    // Metodo que pinta el catalogo para realizar un pedido
    public String pintaProductoPedido() {
        return """
                ╔═════════════════════════════════════════════════════════════╗╔═════════╗
                ║ %-62s %.2fE
                ╚═════════════════════════════════════════════════════════════╝╚═════════╝
                """.formatted(nombre, precio);
    }

    // toString
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
