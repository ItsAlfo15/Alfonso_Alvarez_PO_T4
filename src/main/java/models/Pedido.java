package models;

import java.time.LocalDate;

import static models.Usuarios.cliente1;
import static models.Usuarios.cliente2;

public class Pedido {

    // Atributos
    private static int contador = 0;
    private Cliente cliente;
    private String codigo;
    private String estado;
    private LocalDate fechaPedido;
    private LocalDate fechaPedidoEstimada;
    private String comentario;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;


    // Constructor
    public Pedido() {
        contador++;
        this.codigo = asignaCodigoAleatorio();
        this.estado = "Recibido";
        this.fechaPedido = LocalDate.now();
        this.fechaPedidoEstimada = getFechaPedidoEstimada();
    }

    // Getters y Setters.
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pedido.contador = contador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaPedidoEstimada() {
        return getFechaPedido().plusDays(5);
    }

    public void setFechaPedidoEstimada(LocalDate fechaPedidoEstimada) {
        this.fechaPedidoEstimada = fechaPedidoEstimada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    // Otros metodos

    // Metodo que devuelve un codigo entre 1 y 100000
    private int generaCodigoAleatorio() {
        return (int) (Math.random() * 100000 + 1);
    }

    // Metodo que comprueba si el codigo generado ya esta asignado a otro pedido
    private boolean esCodigoUnico(String codigo) {
        if (cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equals(codigo)) return false;
        if (cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equals(codigo)) return false;
        if (cliente2 != null) {
            if (cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equals(codigo)) return false;
            if (cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equals(codigo)) return false;
        }
        return true;
    }

    // Metodo qye devuelve el vodigo generado validado
    public String asignaCodigoAleatorio() {
        String codigo;
        do {
            codigo = String.valueOf(generaCodigoAleatorio());
        } while (!esCodigoUnico(codigo));
        return codigo;
    }

    // Metodo que asigna un producto dependiendo de los huecos que existan
    public boolean agregaProducto(Producto producto) {
        if (producto1 == null) {
            producto1 = producto;
            return true;
        } else if (producto2 == null) {
            producto2 = producto;
            return true;
        } else if (producto3 == null) {
            producto3 = producto;
            return true;
        }
        return false;
    }

    // Metodo que calcula el precio total del pedido
    public float sumaPrecioTotal() {
        return producto1.sumaPrecio() + ((producto2 == null) ? 0 : producto2.sumaPrecio() + ((producto3 == null) ? 0 : producto2.sumaPrecio()));
    }

    // Metodo que cuenta la cantidad de productos de un pedido
    public int cuentaProductos() {
        int cont = 0;
        if (producto1 != null) cont++;
        if (producto2 != null) cont++;
        if (producto3 != null) cont++;

        return cont;
    }

    // toString
    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", fechaPedidoEstimada=" + fechaPedidoEstimada +
                ", comentario='" + comentario + '\'' +
                ", producto1=" + producto1 +
                ", producto2=" + producto2 +
                ", producto3=" + producto3 +
                '}';
    }
}
