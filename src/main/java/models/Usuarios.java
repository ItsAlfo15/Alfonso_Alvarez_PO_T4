package models;

public class Usuarios {

    // Atributos
    private final Admin admin = new Admin();
    public static Cliente cliente1;
    public static Cliente cliente2;
    public static Trabajador trabajador1;
    public static Trabajador trabajador2;
    public static Trabajador trabajador3;

    // MOCK
    public void MOCK() {
        // TODO Cliente validado
        cliente1 = new Cliente(true,"Alfonso", "Alvarez", 987654321, "alfo.15.play@gmail.com", "1234", "Ejemplo 1", "Ejemplo 2", "Ejemplo 3");
        // TODO Cliente sin validar
        // cliente2 = new Cliente("Antonio", "Perez", 123456789, "alvarezoca15@gmail.com", "4321", "Ejemplo 1", "Ejemplo 2", "Ejemplo 3");
        trabajador1 = new Trabajador("Roberto", "alfonso.alvarez.1509@fernando3martos.com", "5678");
        // trabajador2 = new Trabajador("Carlos", "alfo.15.play@gmail.com", "4567");
        // trabajador3 = new Trabajador("Maria", "alfonso.alvarez.1509@fernando3martos.com", "9876");
    }


    // Metodo que verifica si hay hueco para un nuevo cliente
    public boolean hayHuecoCliente() {
        return cliente1 == null || cliente2 == null;
    }

    // Este metodo inserta los datos recogidos en uno de los clientes siempre y cuando haya hueco disponible
    public void registraCliente(Cliente cliente) {
        if (!hayHuecoCliente()) return;
        if (cliente1 == null) {
            cliente1 = new Cliente(cliente);
            return;
        }
        cliente2 = new Cliente(cliente);
    }

    // Metodo que verifica si hay hueco para un nuevo trabajador
    public boolean hayHuecoTrabajador() {
        return trabajador1 == null || trabajador2 == null || trabajador3 == null;
    }

    // Metodo que selcciona un hueco para un trabajador
    public void darAltaTrabajador(Trabajador trabajador) {
        if (!hayHuecoTrabajador()) return;
        if (trabajador1 == null) {
            trabajador1 = new Trabajador(trabajador);
            return;
        }
        if (trabajador2 == null) {
            trabajador2 = new Trabajador(trabajador);
            return;
        }
        if (trabajador3 == null) {
            trabajador3 = new Trabajador(trabajador);
        }
    }

        // Metodo que mide la longitud del numero de telefono
    public boolean verificaTelefono(int telefono) {
        return telefono <= 999999999 && telefono >= 100000000;
    }

    // Metodo que verifica que la contraseña tenga una longitud de 4 caracteres como minimo
    public boolean mideContrasenia(String contrasenia) {
        return contrasenia.length() >= 4;
    }

    // Metodo que verifica si la contraseña coincide con el correo
    public boolean login(String correo, String contrasenia) {
        if (admin.getCorreo().equals(correo) && admin.getContrasenia().equals(contrasenia)) {
            return true;
        } else if (cliente1 != null && cliente1.getCorreo().equals(correo) && cliente1.getContrasenia().equals(contrasenia)) {
            return true;
        } else if (cliente2 != null && cliente2.getCorreo().equals(correo) && cliente2.getContrasenia().equals(contrasenia)) {
            return true;
        } else if (trabajador1 != null && trabajador1.getCorreo().equals(correo) && trabajador1.getContrasenia().equals(contrasenia)) {
            return true;
        } else if (trabajador2 != null && trabajador2.getCorreo().equals(correo) && trabajador2.getContrasenia().equals(contrasenia)) {
            return true;
        } else if (trabajador3 != null && trabajador3.getCorreo().equals(correo) && trabajador3.getContrasenia().equals(contrasenia)) {
            return true;
        }
        return false;
    }

    // Metodo que permite elegir un pedido segun su codigo
    public Pedido seleccionaPedido(String opCodigo) {
        if (cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equals(opCodigo))
            return cliente1.getPedido1();
        else if (cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equals(opCodigo))
            return cliente1.getPedido2();
        else if (cliente2 != null) {
        if (cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equals(opCodigo))
            return cliente2.getPedido1();
        else if (cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equals(opCodigo))
                return cliente2.getPedido2();
        }
        return null;
    }

    // Metodo que cuenta los pedidos que tiene el administrador asignados
    public int sumaPedidosAdmin() {
        int cont = 0;

        if (cliente1 != null && cliente1.getPedido1() != null) cont++;
        if (cliente1 != null && cliente1.getPedido2() != null) cont++;
        if (cliente2 != null && cliente2.getPedido1() != null) cont++;
        if (cliente2 != null && cliente2.getPedido2() != null) cont++;

        return cont;
    }

    // Metodo que verifica que un correo sea valido
    public boolean correoValido(String correo) {
        if (cliente1 == null) return true;
        if (cliente1.getCorreo().equals(correo)) return false;
        if (cliente2 != null && cliente2.getCorreo().equals(correo)) return false;
        return true;
    }

    // Metodo que selecciona un cliente basandose en el codigo del pedido
    public Cliente seleccionaCliente(Pedido pedidoTemporal) {
        if (cliente1 != null) {
            if (cliente1.getPedido1() != null && cliente1.getPedido1() == pedidoTemporal) return cliente1;
            if (cliente1.getPedido2() != null && cliente1.getPedido2() == pedidoTemporal) return cliente1;
        }
        if (cliente2 != null) {
            if (cliente2.getPedido1() != null && cliente2.getPedido1() == pedidoTemporal) return cliente2;
            if (cliente2.getPedido2() != null && cliente2.getPedido2() == pedidoTemporal) return cliente2;
        }
        return null;
    }
}
