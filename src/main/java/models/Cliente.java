package models;

public class Cliente {

    // Atributos
    private boolean validado = false;
    private String nombre;
    private String apellido1;
    private int telefono;
    private String correo;
    private String contrasenia;
    private String provincia;
    private String localidad;
    private String direccion;
    private Pedido pedido1;
    private Pedido pedido2;

    // Constructor
    public Cliente(String nombre, String apellido1, int telefono, String correo, String contrasenia,
                   String provincia, String localidad, String direccion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    public Cliente(boolean validado, String nombre, String apellido1, int telefono, String correo, String contrasenia, String provincia, String localidad, String direccion) {
        this.validado = validado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    // Constructor copia
    public Cliente(Cliente cliente) {
        this.nombre = cliente.nombre;
        this.apellido1 = cliente.apellido1;
        this.telefono = cliente.telefono;
        this.correo = cliente.correo;
        this.contrasenia = cliente.contrasenia;
        this.provincia = cliente.provincia;
        this.localidad = cliente.localidad;
        this.direccion = cliente.direccion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
    // Otros metodos

    // Metodo que asigna un pedido a un espacio vacio
    public boolean agregaPedido(Pedido pedido) {
        if (pedido1 == null) {
            pedido1 = pedido;
            return true;
        } else if (pedido2 == null){
            pedido2 = pedido;
            return true;
        }
        return false;
    }

    // toString
    @Override
    public String toString() {

        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", provincia='" + provincia + '\'' +
                ", localidad='" + localidad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    // Menu que pinta los datos del cliente
    public String pintaDatosCliente() {
        return """
           ╔════════════════════════════════════════════╗
           ║             TUS DATOS PERSONALES           ║
           ╠════════════════════════════════════════════╣
           ║ Nombre:          %-25s ║
           ║ 1er Apellido:    %-25s ║
           ║ Teléfono:        %-25s ║
           ║ Correo:          %-25s ║
           ║ Contraseña:      %-25s ║
           ║ Provincia:       %-25s ║
           ║ Localidad:       %-25s ║
           ║ Dirección:       %-25s ║
           ╚════════════════════════════════════════════╝
           """.formatted(nombre,apellido1,telefono,correo,pintaContrasenia(),provincia,localidad,direccion);
    }


    // Metodo que pinta la contraseña con "*" segun su longitud
    private String pintaContrasenia() {
        String salida = "";
        for (int i = 0; i < contrasenia.length(); i++) {
            salida = salida.concat("*");
        }
        return salida;
    }

    // Metodo que comprara la contraseña introducida con la del objeto
    public boolean verificaContrasenia(String clave) {
        return this.contrasenia.equals(clave);
    }


    // Metodo que mide la longitud de la contraseña
    public boolean mideContrasenia(String contrasenia) {
        return contrasenia.length() >= 4;
    }



    // Menu que pinta el cliente para el administrador
    public String pintaClienteAdmin() {
        return """
        ╔════════════════════════════════════════════╗
        ║              DATOS DEL CLIENTE             ║
        ╠════════════════════════════════════════════╣
        ║ Nombre:          %-25s ║
        ║ 1er Apellido:    %-25s ║
        ║ Teléfono:        %-25s ║
        ║ Correo:          %-25s ║
        ║ Contraseña:      %-25s ║
        ║ Provincia:       %-25s ║
        ║ Localidad:       %-25s ║
        ║ Dirección:       %-25s ║
        ╚════════════════════════════════════════════╝
        """.formatted(nombre,apellido1,telefono,correo,pintaContrasenia(),provincia,localidad,direccion);
    }

    // Metodo que verifica si hay hueco para un nuevo pedido
    public boolean hayHuecoPedido() {
        return pedido1 == null || pedido2 == null;
    }

    // Menu que pinta el pedido para el cliente
    public String pintaPedidoParaCliente(Pedido pedido) {
        if (pedido == null) {
            return "El pedido no existe.";
        }

        String detalles = "======================\n" +
                "       TU PEDIDO      \n" +
                "======================\n" +
                "Código del Pedido: " + pedido.getCodigo() + "\n" +
                "Estado: " + pedido.getEstado() + "\n" +
                "Comentario: " + (pedido.getComentario() == null ? "Sin comentario" : pedido.getComentario()) + "\n" +
                "Fecha del Pedido: " + pedido.getFechaPedido() + "\n" +
                "Fecha de Entrega Estimada: " + pedido.getFechaPedidoEstimada() + "\n" +
                "----------------------\n" +
                "       PRODUCTOS      \n" +
                "----------------------\n";

        // Producto 1
        if (pedido.getProducto1() != null) {
            detalles += "Producto: " + pedido.getProducto1().getNombre() + "\n" +
                    "Precio: " + String.format("%.2f", pedido.getProducto1().getPrecio()) + " Euros\n" +
                    "Cantidad: " + pedido.getProducto1().getCantidad() + "\n";
        }

        // Producto 2
        if (pedido.getProducto2() != null) {
            detalles += "----------------------\n";
            detalles += "Producto: " + pedido.getProducto2().getNombre() + "\n" +
                    "Precio: " + String.format("%.2f", pedido.getProducto2().getPrecio()) + " Euros\n" +
                    "Cantidad: " + pedido.getProducto2().getCantidad() + "\n";
        }

        // Producto 3
        if (pedido.getProducto3() != null) {
            detalles += "----------------------\n";
            detalles += "Producto: " + pedido.getProducto3().getNombre() + "\n" +
                    "Precio: " + String.format("%.2f", pedido.getProducto3().getPrecio()) + " Euros\n" +
                    "Cantidad: " + pedido.getProducto3().getCantidad() + "\n";
        }

        detalles += "======================\n";
        detalles += "TOTAL: " + String.format("%.2f", pedido.sumaPrecioTotal()) + " Euros\n";
        detalles += "======================\n";

        return detalles;
    }

    // Menu que pinta el pedido para el admninistrador
    public String pintaPedidoParaAdmin(Pedido pedido) {
        if (pedido != null) {
            return "Pedido: " + pedido.getCodigo() + "\n" +
                    "Estado: " + pedido.getEstado() + "\n" +
                    "Cliente: " + getNombre() + " " + getApellido1() + "\n" +
                    "Dirección: " + getDireccion() + "\n" +
                    "Localidad: " + getLocalidad() + "\n" +
                    "Provincia: " + getProvincia() + "\n" +
                    "Teléfono: " + getTelefono() + "\n" +
                    "Correo: " + getCorreo() + "\n" +
                    "Fecha del pedido: " + pedido.getFechaPedido() + "\n" +
                    "Fecha de entrega estimada: " + pedido.getFechaPedidoEstimada() + "\n" +
                    "Comentario: " + ((pedido.getComentario() == null) ? "Sin comentario." : pedido.getComentario()) + "\n" +
                    "Producto: " + pedido.getProducto1().getNombre() + "\n" +
                    "Precio: " + pedido.getProducto1().getPrecio() + " Euros" + "\n" +
                    "Cantidad: " + pedido.getProducto1().getCantidad() + "\n" +
                    ((pedido.getProducto2() == null ) ? " "
                            : "Producto : " + pedido.getProducto2().getNombre() + "\n" +
                            "Precio: " + pedido.getProducto2().getPrecio() + " Euros" + "\n" +
                            "Cantidad: " + pedido.getProducto2().getCantidad() + "\n" +
                            ((pedido.getProducto3() == null) ? " "
                                    : "Producto : " + pedido.getProducto3().getNombre() + "\n" +
                                    "Precio: " + pedido.getProducto3().getPrecio() + " Euros" +"\n" +
                                    "Cantidad: " + pedido.getProducto3().getCantidad() + "\n")) +
                    "\nTOTAL: " + String.format("%.2f", pedido.sumaPrecioTotal()) + " Euros.\n";
        }
        return " ";
    }
}