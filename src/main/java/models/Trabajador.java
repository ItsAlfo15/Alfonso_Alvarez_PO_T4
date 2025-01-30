package models;

public class Trabajador {

    // Atributos
    private String nombre;
    private String correo;
    private String contrasenia;
    private Pedido pedidoAsignado1;
    private Pedido pedidoAsignado2;

    // Constructor
    public Trabajador(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    // Contructor copia
    public Trabajador(Trabajador trabajador) {
        this.nombre = trabajador.nombre;
        this.correo = trabajador.correo;
        this.contrasenia = trabajador.contrasenia;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Pedido getPedidoAsignado1() {
        return pedidoAsignado1;
    }

    public void setPedidoAsignado1(Pedido pedidoAsignado1) {
        this.pedidoAsignado1 = pedidoAsignado1;
    }

    public Pedido getPedidoAsignado2() {
        return pedidoAsignado2;
    }

    public void setPedidoAsignado2(Pedido pedidoAsignado2) {
        this.pedidoAsignado2 = pedidoAsignado2;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Otros metodos
    private String pintaContraseniaTrabajador() {
        String salida = "";
        for (int i = 0; i < contrasenia.length(); i++) {
            salida = salida.concat("*");
        }
        return salida;
    }

    // Metodo que comprara la contraseña introducida con la del objeto
    public boolean verificaContrasenia(String contrasenia) {
        return this.contrasenia.equals(contrasenia);
    }



    // Menu que pinta los datos del trabajador
    public String pintaDatosTrabajador() {
        return """
        ╔═════════════════════════════════════════════════════╗
        ║           DATOS PERSONALES DEL TRABAJADOR           ║
        ╠═════════════════════════════════════════════════════╣
        ║ Nombre:       %s
        ║ Correo:       %s
        ║ Contraseña:   %s
        ╚═════════════════════════════════════════════════════╝
        """.formatted(nombre,correo,pintaContraseniaTrabajador());
    }

    // Menu que pinta los datos del trabajador para el admin
    public String pintaTrabajadorAdmin(Trabajador trabajador) {
        return """
        ╔══════════════════════════════════════════════╗
        ║             DATOS DEL TRABAJADOR             ║
        ╠══════════════════════════════════════════════╣
        ║ Nombre:       %s
        ║ Correo:       %s
        ║ Contraseña:   %s
        ╚══════════════════════════════════════════════╝
         * Pedido 1: %s
         * Pedido 2: %s
        
        """.formatted(nombre,correo,pintaContraseniaTrabajador(),
                (pedidoAsignado1 == null) ? "Sin asignar." : trabajador.getPedidoAsignado1().getCodigo(),
                (pedidoAsignado2 == null) ? "Sin asignar." : trabajador.getPedidoAsignado2().getCodigo());
    }

    // Metodo que asigna un pedido
    public void asignaPedido(Pedido pedido) {
        if (pedidoAsignado1 == null) {
            pedidoAsignado1 = pedido;
        } else if (pedidoAsignado2 == null) {
            pedidoAsignado2 = pedido;
        }
    }

    // Metodo que suma los pedidos asignados
    public int sumaPedidosAsignados() {
        int cont = 0;
        if (getPedidoAsignado1() != null) cont++;
        if (getPedidoAsignado2() != null) cont++;
        return cont;
    }

    // toString
    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    // Metodo que pinta los pedidos asignados del trabajador
    public String pintaPedidoAsignado(Pedido pedido) {
        if (pedido == null) {
            return "El pedido no existe.";
        }

        String salida = "=== Pedido " + pedido.getCodigo() + " ===\n" +
                "Estado: " + pedido.getEstado() + "\n" +
                "Fecha del pedido: " + pedido.getFechaPedido() + "\n" +
                "Fecha de entrega estimada: " + pedido.getFechaPedidoEstimada() + "\n" +
                "Comentario: " + (pedido.getComentario() == null ? "Sin comentario" : pedido.getComentario()) + "\n" +
                "Detalles del pedido:\n";

        double precioTotal = 0;

        // Producto 1
        if (pedido.getProducto1() != null) {
            salida += " - " + pedido.getProducto1().getNombre() +
                    ", " + pedido.getProducto1().getCantidad() +
                    ", (" + pedido.getProducto1().getPrecio() + ") por unidad.\n";
            precioTotal += pedido.getProducto1().getCantidad() * pedido.getProducto1().getPrecio();
        }

        // Producto 2
        if (pedido.getProducto2() != null) {
            salida += " - " + pedido.getProducto2().getNombre() +
                    ", " + pedido.getProducto2().getCantidad() +
                    ", (" + pedido.getProducto2().getPrecio() + ") por unidad.\n";
            precioTotal += pedido.getProducto2().getCantidad() * pedido.getProducto2().getPrecio();
        }

        // Producto 3
        if (pedido.getProducto3() != null) {
            salida += " - " + pedido.getProducto3().getNombre() +
                    ", " + pedido.getProducto3().getCantidad() +
                    ", (" + pedido.getProducto3().getPrecio() + ") por unidad.\n";
            precioTotal += pedido.getProducto3().getCantidad() * pedido.getProducto3().getPrecio();
        }

        // Precio total
        salida += "Precio total: " + String.format("%.2f", precioTotal) + " €\n";

        return salida;
    }
}
