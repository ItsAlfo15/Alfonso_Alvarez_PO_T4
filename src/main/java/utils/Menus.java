package utils;

import models.*;
import java.time.LocalDate;
import java.util.Scanner;
import static data.ProductosData.*;
import static models.Usuarios.*;

public class Menus {
    private static final Scanner S = new Scanner(System.in);
    static Usuarios usuarios = new Usuarios();

    // Menu para el cliente
    public static void menuCliente(Cliente cliente) throws InterruptedException {
        Utils.limpiaPantalla();
        int op;

        do {
            op = -1;
            System.out.printf("""
                    ╔═════════════════════════════════════════════╗
                    ║                  FERNANSHOP                 ║
                    ╠═════════════════════════════════════════════╣
                    ║ BIENVENIDO, %-31s ║
                    ╠═════════════════════════════════════════════╣
                    ║ 1.- Consultar el catálogo de productos      ║
                    ║ 2.- Realizar un pedido                      ║
                    ║ 3.- Ver mis pedidos realizados              ║
                    ║ 4.- Ver mis datos personales                ║
                    ║ 5.- Modificar mis datos personales          ║
                    ║ 6.- Cerrar sesión                           ║
                    ╚═════════════════════════════════════════════╝
                    Introduce la opción deseada:\s""",
                    cliente.getNombre());
            try {
                op = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número válido.");
                Utils.pulsaParaContinuar();
                Utils.limpiaPantalla();
            }

            switch (op) {
                case 1: // Consultar el catálogo de productos
                    Utils.limpiaPantalla();
                    System.out.println("""
                    ╔════════════════════════════════════════════════════════════════════╗
                    ║                        CATÁLOGO DE PRODUCTOS                       ║
                    ╚════════════════════════════════════════════════════════════════════╝
                    """);
                    System.out.println(producto1.pintaProducto());
                    System.out.println(producto2.pintaProducto());
                    System.out.println(producto3.pintaProducto());
                    System.out.println(producto4.pintaProducto());
                    System.out.println(producto5.pintaProducto());
                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case 2: // Realizar un pedido
                    int opPedido;
                    if (producto1.getCantidad() <= 0 && producto2.getCantidad() <= 0 && producto3.getCantidad() <= 0 && producto4.getCantidad() <= 0 && producto5.getCantidad() <= 0)
                        System.out.println("No hay stock de ningún producto en este momento.");
                    else {
                        Utils.limpiaPantalla();
                        int cont = 0, cantidad;
                        boolean pedido = false;
                        String respuesta = "";
                        if (!cliente.hayHuecoPedido()) System.out.println("Lo sentimos, no se pueden realizar más de dos pedidos simultáneos");
                        else {
                            Pedido pedidoTemp = new Pedido();
                            do {

                                cont++;
                                System.out.println("""
                                        ╔═════════════════════════════════════════════════════════════╗╔═════════╗
                                        ║ PRODUCTOS                                                      PRECIO
                                        ╚═════════════════════════════════════════════════════════════╝╚═════════╝
                                        """);
                                System.out.println("1.-\n" + producto1.pintaProductoPedido());
                                System.out.println("2.-\n" + producto2.pintaProductoPedido());
                                System.out.println("3.-\n" + producto3.pintaProductoPedido());
                                System.out.println("4.-\n" + producto4.pintaProductoPedido());
                                System.out.println("5.-\n" + producto5.pintaProductoPedido());

                                // Implemento los try catch para evitar que el programa se cierre
                                do {
                                    opPedido = -1;
                                    try {
                                        System.out.print("Introduce la opción deseada: ");
                                        opPedido = Integer.parseInt(S.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error, introduce un número válido.");
                                        System.out.println();
                                    }
                                } while (opPedido < 1 ||opPedido > 5);

                                do {
                                    cantidad = -1;
                                    try {
                                        System.out.print("Introduce la cantidad a comprar: ");
                                        cantidad = Integer.parseInt(S.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error, introduce un número válido.");
                                        System.out.println();
                                    }
                                    if (cantidad <= 0) System.out.println("Error, cantidad introducida incorrectamente.");
                                } while (cantidad <= 0);

                                switch (opPedido) {
                                    case 1: // Producto 1
                                        pedido = false;
                                        if (producto1.getCantidad() <= 0) System.out.println("Error, no hay stock de este producto.");
                                        else if (cantidad > producto1.getCantidad())
                                            System.out.println("No se puede realizar la venta ya que la cantidad introducida supera el stock actual");
                                        else {
                                            pedido = true;
                                            producto1.restacantidad(cantidad);
                                            Producto productoTemp = new Producto(producto1.getNombre(), producto1.getPrecio(), cantidad);
                                            pedidoTemp.agregaProducto(productoTemp);
                                        }
                                        break;
                                    case 2: // Producto 2
                                        pedido = false;
                                        if (producto2.getCantidad() <= 0) System.out.println("Error, no hay stock de este producto.");
                                        else if (cantidad > producto2.getCantidad())
                                            System.out.println("No se puede realizar la venta ya que la cantidad introducida supera el stock actual");
                                        else {
                                            pedido = true;
                                            producto2.restacantidad(cantidad);
                                            Producto productoTemp = new Producto(producto2.getNombre(), producto2.getPrecio(), cantidad);
                                            pedidoTemp.agregaProducto(productoTemp);
                                        }
                                        break;
                                    case 3: // Producto 3
                                        pedido = false;
                                        if (producto3.getCantidad() <= 0) System.out.println("Error, no hay stock de este producto.");
                                        else if (cantidad > producto3.getCantidad())
                                            System.out.println("No se puede realizar la venta ya que la cantidad introducida supera el stock actual");
                                        else {
                                            pedido = true;
                                            producto3.restacantidad(cantidad);
                                            Producto productoTemp = new Producto(producto3.getNombre(), producto3.getPrecio(), cantidad);
                                            pedidoTemp.agregaProducto(productoTemp);
                                        }
                                        break;
                                    case 4: // Producto 4
                                        pedido = false;
                                        if (producto4.getCantidad() <= 0) System.out.println("Error, no hay stock de este producto.");
                                        else if (cantidad > producto4.getCantidad())
                                            System.out.println("No se puede realizar la venta ya que la cantidad introducida supera el stock actual");
                                        else {
                                            pedido = true;
                                            producto4.restacantidad(cantidad);
                                            Producto productoTemp = new Producto(producto4.getNombre(), producto4.getPrecio(), cantidad);
                                            pedidoTemp.agregaProducto(productoTemp);
                                        }
                                        break;
                                    case 5: // Producto 5
                                        pedido = false;
                                        if (producto5.getCantidad() <= 0) System.out.println("Error, no hay stock de este producto.");
                                        else if (cantidad > producto5.getCantidad())
                                            System.out.println("No se puede realizar la venta ya que la cantidad introducida supera el stock actual");
                                        else {
                                            pedido = true;
                                            producto5.restacantidad(cantidad);
                                            Producto productoTemp = new Producto(producto5.getNombre(), producto5.getPrecio(), cantidad);
                                            pedidoTemp.agregaProducto(productoTemp);
                                        }
                                        break;
                                    default:
                                        System.out.println("Error, introduce una opción del catálogo.");
                                }

                                if (pedido) {
                                    if (cont != 3) {
                                        do {
                                            System.out.print("¿Quieres añadir otro producto al carrito? (S/N): ");
                                            respuesta = S.nextLine();
                                            if (!respuesta.equals("S") && !respuesta.equals("N"))
                                                System.out.println("Error, introduce (S/N)");
                                        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
                                        Utils.limpiaPantalla();
                                    }
                                }

                            } while (cont <= 2 && respuesta.equalsIgnoreCase("S"));

                            System.out.println("Su pedido se ha realizado correctamente");

                            cliente.agregaPedido(pedidoTemp);
                        }
                    }

                    break;
                case 3: // Ver mis pedidos realizados
                    Utils.limpiaPantalla();
                    if (cliente.getPedido1() == null) System.out.println("Pedido no realizado");
                    else {
                        System.out.println(cliente.pintaPedidoParaCliente(cliente.getPedido1()));
                        if (cliente.getPedido2() == null) System.out.println(" ");
                        else System.out.println(cliente.pintaPedidoParaCliente(cliente.getPedido2()));
                    }
                    Utils.pulsaParaContinuar();
                    break;
                case 4: // Ver mis datos personales
                    Utils.limpiaPantalla();
                    System.out.println(cliente.pintaDatosCliente());
                    Utils.pulsaParaContinuar();
                    break;
                case 5: // Modificar mis datos personales
                    Utils.limpiaPantalla();
                    System.out.println("Introduce tu contraseña para acceder.");
                    String contrasenia = S.nextLine(), nombre, apellido, correo, clave, provincia, localidad, direccion;
                    int telefono;
                    boolean telefonoVerificado = false;

                    if (!cliente.verificaContrasenia(contrasenia)) System.out.println("La contraseña introducida no es corecta.");
                    else {
                        do {
                            do {
                                op = -1;
                                System.out.print("""
                                    ╔══════════════════════════════════════════╗
                                    ║              MENÚ DE OPCIONES            ║
                                    ╠══════════════════════════════════════════╣
                                    ║ 1.- Nombre.                              ║
                                    ║ 2.- 1er Apellido.                        ║
                                    ║ 3.- Teléfono.                            ║
                                    ║ 4.- Correo.                              ║
                                    ║ 5.- Contraseña.                          ║
                                    ║ 6.- Provincia.                           ║
                                    ║ 7.- Localidad.                           ║
                                    ║ 8.- Dirección.                           ║
                                    ║ 9.- SALIR.                               ║
                                    ╚══════════════════════════════════════════╝
                                    Selecciona el apartado que quieras modificar:\s""");
                                try {
                                    op = Integer.parseInt(S.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Error, introduce un número válido.");
                                    System.out.println();
                                }
                            } while (op < 1 || op > 9);

                            switch (op) {
                                case 1: // Cambiar nombre
                                    do {
                                        System.out.print("* Introduce tu nuevo nombre: ");
                                        nombre = S.nextLine();
                                        if (nombre.isEmpty()) System.out.println("Debes introducir un nombre");
                                    } while (nombre.isEmpty());
                                    cliente.setNombre(nombre);
                                    System.out.println("Su nombre se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 2: // Cambiar apellido
                                    do {
                                        System.out.print("* Introduce tu nuevo apellido: ");
                                        apellido = S.nextLine();
                                        if (apellido.isEmpty()) System.out.println("Debes introducir un apellido");
                                    } while (apellido.isEmpty());
                                    cliente.setApellido1(apellido);
                                    System.out.println("Su apellido se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 3: // Cambiar telefono
                                    do {
                                        telefono = 0;
                                        try {
                                            do {
                                                System.out.print("* Introduce tu teléfono: ");
                                                telefono = Integer.parseInt(S.nextLine());
                                                if (!usuarios.verificaTelefono(telefono)) System.out.println("Error, debes introducir un número de teléfono válido");
                                                else telefonoVerificado = true;
                                            } while (!telefonoVerificado);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Error, introduce un teléfono válido.");
                                            System.out.println();
                                        }
                                    } while (telefono == 0);
                                    cliente.setTelefono(telefono);
                                    System.out.println("Su teléfono se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 4: // Cambiar correo
                                    String correoPrimario = cliente.getCorreo();
                                    do {
                                        System.out.print("* Introduce tu correo: ");
                                        correo = S.nextLine();
                                        if (correo.isEmpty()) System.out.println("Debes introducir un correo");
                                        else if (!Utils.validaCorreo(correo)) System.out.println("Error, debes introducir un correo válido.");
                                        if (!usuarios.correoValido(correo)) System.out.println("Error, el correo introducido ya está en uso.");
                                    } while (correo.isEmpty() || !Utils.validaCorreo(correo) || !usuarios.correoValido(correo));
                                    cliente.setCorreo(correo);

                                    System.out.println("A continuación deberás validar el correo.");
                                    String tokenGenerado = Utils.enviaToken(cliente);
                                    System.out.print("Introduce el token que se te ha enviado por correo para validarlo: ");
                                    String tokenIntroducido = S.nextLine();
                                    cliente.setValidado(Utils.compruebaToken(tokenGenerado, tokenIntroducido));
                                    if (cliente.isValidado()) System.out.println("Su correo ha sido validado correctamente");
                                    else {
                                        System.out.println("Error, token introducido incorrecto, no se ha podido realizar su cambio de correo.");
                                        cliente.setCorreo(correoPrimario);
                                    }
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 5: // Cambiar contraseña
                                    do {
                                        System.out.print("* Introduce una nueva contraseña: ");
                                        clave = S.nextLine();
                                        if (clave.isEmpty()) System.out.println("Debes introducir una contraseña");
                                        else if (!usuarios.mideContrasenia(clave)) System.out.println("Error, la contraseña debe tener como mínimo 4 caracteres");
                                    } while (clave.isEmpty() || !usuarios.mideContrasenia(clave));
                                    cliente.setContrasenia(clave);
                                    System.out.println("Su contraseña se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 6: // Cambiar provincia
                                    do {
                                        System.out.print("* Introduce tu nueva provincia: ");
                                        provincia = S.nextLine();
                                        if (provincia.isEmpty()) System.out.println("Debes introducir una provincia");
                                    } while (provincia.isEmpty());
                                    cliente.setProvincia(provincia);
                                    System.out.println("Su provincia se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 7: // Cambiar localidad
                                    do {
                                        System.out.print("* Introduce tu nueva localidad: ");
                                        localidad = S.nextLine();
                                        if (localidad.isEmpty()) System.out.println("Debes introducir una localidad");
                                    } while (localidad.isEmpty());
                                    cliente.setLocalidad(localidad);
                                    System.out.println("Su localidad se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 8: // Cambiar direccion
                                    do {
                                        System.out.print("* Introduce tu nueva direccion: ");
                                        direccion = S.nextLine();
                                        if (direccion.isEmpty()) System.out.println("Debes introducir una direccion");
                                    } while (direccion.isEmpty());
                                    cliente.setDireccion(direccion);
                                    System.out.println("Su dirección se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 9: // Salir
                                    Utils.saliendo();
                                    Utils.limpiaPantalla();
                                    break;
                                default:
                                    System.out.println("ERROR. Seleccione uno de los apartados a modificar.");
                            }
                        } while (op != 9);
                    }
                    break;
                case 6: // Cerrar sesion
                    Utils.limpiaPantalla();
                    Utils.saliendo();
                    Utils.limpiaPantalla();
                    break;
                default:
            }
        } while (op != 6);
    }

    // Menu para el trabajador
    public static void menuTrabajador(Trabajador trabajador) throws InterruptedException {
        Utils.limpiaPantalla();

        var s = new Scanner(System.in);
        int op;

        do {
            do {
                op = -1;
                System.out.printf("""
                ╔═══════════════════════════════════════════════╗
                ║                  FERNANSHOP                   ║
                ╠═══════════════════════════════════════════════╣
                ║ Bienvenido, %-32s  ║
                ║ Tienes %d pedidos que gestionar.               ║
                ╠═══════════════════════════════════════════════╣
                ║ 1.- Consultar los pedidos que tengo asignados ║
                ║ 2.- Modificar el estado de un pedido          ║
                ║ 3.- Consultar el catálogo de productos        ║
                ║ 4.- Modificar un producto del catálogo        ║
                ║ 5.- Ver mi perfil                             ║
                ║ 6.- Modificar mis datos personales            ║
                ║ 7.- Cerrar sesión                             ║
                ╚═══════════════════════════════════════════════╝
                Introduce la opción deseada:\s""",
                        trabajador.getNombre(), trabajador.sumaPedidosAsignados());
                try {
                    op = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, introduce un número válido.");
                    System.out.println();
                }
            } while (op < 1 || op > 7);


            switch (op) {
                case 1: // Consultar los pedidos que tengo asignados
                    Utils.limpiaPantalla();
                    if (trabajador.getPedidoAsignado1() == null) {
                        System.out.println("No hay pedidos asignados");
                    } else {
                        System.out.println(trabajador.pintaPedidoAsignado(trabajador.getPedidoAsignado1()));
                    }

                    if (trabajador.getPedidoAsignado2() == null) {
                        if (trabajador.getPedidoAsignado1() != null) {
                            System.out.println("No hay más pedidos asignados");
                        }
                    } else {
                        System.out.println(trabajador.pintaPedidoAsignado(trabajador.getPedidoAsignado2()));
                    }
                    break;
                case 2: // Modificar el estado de un pedido
                    Utils.limpiaPantalla();
                    String opcion;
                    boolean cambiado;
                    try {
                        if (cliente1 == null && cliente2 == null) System.out.println("No hay clientes registrados");
                        else {
                            if (cliente1.getPedido1() == null && cliente1.getPedido2() == null && cliente2.getPedido1() == null && cliente2.getPedido2() == null)
                                System.out.println("No se ha realizado ningún pedido");
                            else {
                                cambiado = false;
                                do {
                                    if (trabajador.getPedidoAsignado1() != null)
                                        System.out.println(trabajador.pintaPedidoAsignado(trabajador.getPedidoAsignado1()));

                                    if (trabajador.getPedidoAsignado2() != null)
                                        System.out.println(trabajador.pintaPedidoAsignado(trabajador.getPedidoAsignado2()));

                                    System.out.print("Introduce el código del pedido al que le quieres cambiar el estado: ");
                                    opcion = s.nextLine();

                                    if (!cambiaEstado(opcion)) {
                                        System.out.println("Error, hubo un problema con la búsqueda del pedido.");
                                        Utils.pulsaParaContinuar();
                                        Utils.limpiaPantalla();
                                    } else {
                                        Pedido pedidoTemporal = usuarios.seleccionaPedido(opcion);
                                        Cliente clienteTemporal = usuarios.seleccionaCliente(pedidoTemporal);
                                        System.out.println("Estado cambiado correctamente.");
                                        Utils.enviaMensajeGmailCambioEstadoPedido(clienteTemporal, pedidoTemporal);
                                        cambiado = true;
                                    }
                                } while (!cambiado);
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("No hay clientes registrados.");
                    }

                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case 3: // Consultar el catálogo de productos
                    Utils.limpiaPantalla();
                    System.out.println("======== CATÁLOGO DE PRODUCTOS ========\n");
                    System.out.println("1.-\n" + producto1.pintaProducto());
                    System.out.println("2.-\n" + producto2.pintaProducto());
                    System.out.println("3.-\n" + producto3.pintaProducto());
                    System.out.println("4.-\n" + producto4.pintaProducto());
                    System.out.println("5.-\n" + producto5.pintaProducto());
                    System.out.println();
                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case 4: // Modificar un producto del catálogo
                    Utils.limpiaPantalla();
                    int opStock, cantidad = 0;
                    do {
                        opStock = -1;
                        Utils.limpiaPantalla();
                        System.out.println("1.- El señor de los anillos (Trilogía), de J. R. R. Tolkien. Cantidad en stock: " + producto1.getCantidad());
                        System.out.println("2.- Harry Potter y la piedra filosofal (Harry Potter 1) de J. K. Rowling. Cantidad en stock: " + producto2.getCantidad());
                        System.out.println("3.- En busca del tiempo perdido, de Marcel Proust. Cantidad en stock: " + producto3.getCantidad());
                        System.out.println("4.- Paquete de 12 marcapáginas. Cantidad en stock: " + producto4.getCantidad());
                        System.out.println("5.- Paquete Folios A4 80gr, 100 unidades. Cantidad en stock: " + producto5.getCantidad());
                        System.out.println("6.- Salir.");
                        try {
                            System.out.print("Introduce la opción deseada: ");
                            opStock = Integer.parseInt(s.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Error, introduce un número válido.");
                            System.out.println();
                        }

                        if (opStock >= 1 && opStock <= 5) {
                            do {
                                cantidad = -1;
                                try {
                                    do {
                                        System.out.print("Introduce la cantidad deseada para aumentar el stock: ");
                                        cantidad = Integer.parseInt(s.nextLine());
                                        if (cantidad <= 0) System.out.println("Error, debes introducir un valor superior a 0.");
                                    } while (cantidad <= 0);
                                } catch (NumberFormatException e) {
                                    System.out.println("Error, introduce un número válido.");
                                    System.out.println();
                                }
                            } while (cantidad <= 0);
                        }

                        switch (opStock) {
                            case 1: // Sumar stock a producto 1
                                producto1.sumaCantidad(cantidad);
                                break;
                            case 2: // Sumar stock a producto 2
                                producto2.sumaCantidad(cantidad);
                                break;
                            case 3: // Sumar stock a producto 3
                                producto3.sumaCantidad(cantidad);
                                break;
                            case 4: // Sumar stock a producto 4
                                producto4.sumaCantidad(cantidad);
                                break;
                            case 5: // Sumar stock a producto 5
                                producto5.sumaCantidad(cantidad);
                                break;
                            case 6: // Salir
                                Utils.saliendo();
                                Utils.limpiaPantalla();
                                break;
                            default:
                                System.out.println("Error, introduce un dato de la lista de productos.");
                        }
                        if (opStock != 6) System.out.println("La cantidad se ha añadido correctamente.");
                    } while (opStock != 6);

                    break;
                case 5: // Ver mi perfil
                    Utils.limpiaPantalla();
                    System.out.println(trabajador.pintaDatosTrabajador());
                    Utils.pulsaParaContinuar();
                    break;
                case 6: // Modificar mis datos personales
                    Utils.limpiaPantalla();
                    System.out.println("Introduce tu contraseña para acceder.");
                    String contrasenia = s.nextLine();
                    if (!trabajador.verificaContrasenia(contrasenia)) System.out.println("La contraseña introducida no es correcta.");
                    else {
                        do {

                            System.out.print("""
                        1.- Nombre.
                        2.- Correo.
                        3.- Contraseña.
                        4.- SALIR.
                        
                        Seleccione el apartado que quieras modificar:\s""");
                            op = Integer.parseInt(s.nextLine());

                            switch (op) {
                                case 1: // Cambiar nombre trabajador
                                    System.out.print("Introduce tu nuevo nombre: ");
                                    String nombre = s.nextLine();
                                    trabajador.setNombre(nombre);
                                    System.out.println("Su nombre se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 2: // Cambiar correo trabajador
                                    System.out.print("Introduce tu nuevo correo: ");
                                    String correo = s.nextLine();
                                    trabajador.setCorreo(correo);
                                    System.out.println("Su correo se ha cambiado correctamente.");
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 3: // Cambiar contraseña trabajador
                                    System.out.print("Introduce tu nueva contraseña: ");
                                    String clave = s.nextLine();
                                    if (!usuarios.mideContrasenia(clave))
                                        System.out.println("La longitud de la contraseña debe ser mayor o igual a 4");
                                    else {
                                        trabajador.setContrasenia(clave);
                                        System.out.println("Su contraseña se ha cambiado correctamente.");
                                    }
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 4: // Salir
                                    Utils.saliendo();
                                    Utils.limpiaPantalla();
                                    break;
                                default:
                                    System.out.println("ERROR. Seleccione uno de los apartados a modificar.");
                            }
                        } while (op != 4);
                    }
                    break;
                case 7: // Cerrar sesion
                    Utils.limpiaPantalla();
                    Utils.saliendo();
                    Utils.limpiaPantalla();
                    break;
                default:

            }
        } while (op != 7);
    }

    // Menu para el administrador
    public static void menuAdministrador() throws InterruptedException {
        Utils.limpiaPantalla();

        var s = new Scanner(System.in);
        int op;
        String opCodigo = "-1", opcion;

        do {
            op = -1;
            System.out.printf("""
                ╔════════════════════════════════════════════════╗
                ║                    FERNANSHOP                  ║
                ╠════════════════════════════════════════════════╣
                ║ Bienvenido ADMIN.                              ║
                ║ Tienes %d pedidos por asignar.                  ║
                ╠════════════════════════════════════════════════╣
                ║ 1.- Asignar un pedido a un trabajador          ║
                ║ 2.- Modificar el estado de un pedido           ║
                ║ 3.- Dar de alta un trabajador                  ║
                ║ 4.- Ver todos los pedidos                      ║
                ║ 5.- Ver todos los clientes                     ║
                ║ 6.- Ver todos los trabajadores                 ║
                ║ 7.- Cerrar sesión                              ║
                ╚════════════════════════════════════════════════╝
                Introduce la opción deseada:\s""", usuarios.sumaPedidosAdmin());
            try {
                op = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número válido.");
                System.out.println();
            }

            switch (op) {
                case 1: // Asinar un pedido a un trabajador
                    boolean hayPedido = false;
                    Utils.limpiaPantalla();
                    int opTrabajador;
                    if (trabajador1 == null && trabajador2 == null && trabajador3 == null) {
                        System.out.println("No hay trabajadores dados de alta");
                    } else {
                        if (cliente1 == null) System.out.println("No hay clientes registrados");
                        else {
                            try {
                                if (cliente1.getPedido1() != null || cliente1.getPedido2() != null
                                        || cliente2 != null && cliente2.getPedido1() != null
                                        || cliente2 != null && cliente2.getPedido2() != null) hayPedido = true;
                            } catch (NullPointerException e) {
                                System.out.println("No se ha realizado ningún pedido todavía");
                            }
                            if (cliente1.getPedido1() == null) System.out.println("El cliente " + cliente1.getNombre() + " no ha realizado ningún pedido.");
                            else {
                                System.out.println("- " + cliente1.getPedido1().getCodigo() + ", " + cliente1.getNombre() +
                                        ", " + cliente1.getApellido1() + ", " + "(" + cliente1.getLocalidad() + ")" + " - " +
                                        cliente1.getPedido1().cuentaProductos() + " productos" + " - " +
                                        cliente1.getPedido1().sumaPrecioTotal() + " Euros.");
                            }
                            if (cliente1.getPedido2() == null) System.out.println(" ");
                            else {
                                System.out.println("- " + cliente1.getPedido2().getCodigo() + ", " + cliente1.getNombre() +
                                        ", " + cliente1.getApellido1() + ", " + "(" + cliente1.getLocalidad() + ")" + " - " +
                                        cliente1.getPedido2().cuentaProductos() + " productos" + " - " +
                                        cliente1.getPedido2().sumaPrecioTotal() + " Euros.");
                            }

                            if (cliente2 == null) System.out.println(" ");
                            else {
                                if (cliente2.getPedido1() == null) System.out.println("El cliente " + cliente2.getNombre() + " no ha realizado ningún pedido.");
                                else {
                                    System.out.println("- " + cliente2.getPedido1().getCodigo() + ", " + cliente2.getNombre() +
                                            ", " + cliente2.getApellido1() + ", " + "(" + cliente2.getLocalidad() + ")" + " - " +
                                            cliente2.getPedido1().cuentaProductos() + " productos" + " - " +
                                            cliente2.getPedido1().sumaPrecioTotal() + " Euros.");
                                }
                                if (cliente2.getPedido2() == null) System.out.println(" ");
                                else {
                                    System.out.println("- " + cliente2.getPedido2().getCodigo() + ", " + cliente2.getNombre() +
                                            ", " + cliente2.getApellido1() + ", " + "(" + cliente2.getLocalidad() + ")" + " - " +
                                            cliente2.getPedido2().cuentaProductos() + " productos" + " - " +
                                            cliente2.getPedido2().sumaPrecioTotal() + " Euros.");
                                }
                            }
                        }
                    }

                    // Miro si algun trabajador ha realizado un pedido
                    if (hayPedido) {

                        do {
                            try {
                                do {
                                    opCodigo = "1";
                                    System.out.print("Seleccione el código del pedido que quiere asignar: ");
                                    opCodigo = s.nextLine();
                                } while (!opCodigo.equals(cliente1.getPedido1().getCodigo()) && !opCodigo.equals(cliente1.getPedido2().getCodigo())
                                        && !opCodigo.equals(cliente2.getPedido1().getCodigo()) && !opCodigo.equals(cliente2.getPedido2().getCodigo()));
                            } catch (NullPointerException e) {
                                System.out.println("Error, introduce un código válido.");
                                System.out.println();
                            }
                        } while (opCodigo.equals("-1"));

                        usuarios.seleccionaPedido(opCodigo);

                        // Comparo el codigo introducido con los codigos de los pedidos
                        if (usuarios.seleccionaPedido(opCodigo) == null) System.out.println("El código introducido no coincide con ningún pedido.");
                        else {
                            System.out.println("=== Asignación del pedido " + usuarios.seleccionaPedido(opCodigo).getCodigo() + " ===");

                            if (trabajador1 == null) System.out.println("No hay trabajadores");
                            else System.out.println("1.- Nombre: " + trabajador1.getNombre() + " - " + trabajador1.sumaPedidosAsignados() + " pedidos en proceso.");

                            if (trabajador2 == null) System.out.println(" ");
                            else System.out.println("2.- Nombre: " + trabajador2.getNombre() + " - " + trabajador2.sumaPedidosAsignados() + " pedidos en proceso.");

                            if (trabajador3 == null) System.out.println(" ");
                            else System.out.println("3.- Nombre: " + trabajador3.getNombre() + " - " + trabajador3.sumaPedidosAsignados() + " pedidos en proceso.");

                            do {
                                opTrabajador = -1;
                                try {
                                    System.out.print("Seleccione el trabajador: ");
                                    opTrabajador = Integer.parseInt(s.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Error, introduce un número válido.");
                                    System.out.println();
                                }
                            } while (opTrabajador < 1 ||opTrabajador > 3);

                            switch (opTrabajador) {
                                case 1:
                                    if (trabajador1 != null) {
                                        trabajador1.asignaPedido(usuarios.seleccionaPedido(opCodigo));
                                        Utils.enviaMensajeGmail(trabajador1.getCorreo(), "Nuevo pedido asignado", Utils.contenidoPedidoAsignado(trabajador1, usuarios.seleccionaPedido(opCodigo)));
                                        Utils.enviaMensajeTelegram(trabajador1);
                                    }
                                    else System.out.println(" ");
                                    break;
                                case 2:
                                    if (trabajador2 != null) {
                                        trabajador2.asignaPedido(usuarios.seleccionaPedido(opCodigo));
                                        Utils.enviaMensajeGmail(trabajador2.getCorreo(), "Nuevo pedido asignado", Utils.contenidoPedidoAsignado(trabajador2, usuarios.seleccionaPedido(opCodigo)));
                                        Utils.enviaMensajeTelegram(trabajador2);
                                    }
                                    else System.out.println(" ");
                                    break;
                                case 3:
                                    if (trabajador3 != null) {
                                        trabajador3.asignaPedido(usuarios.seleccionaPedido(opCodigo));
                                        Utils.enviaMensajeGmail(trabajador3.getCorreo(), "Nuevo pedido asignado", Utils.contenidoPedidoAsignado(trabajador3, usuarios.seleccionaPedido(opCodigo)));
                                        Utils.enviaMensajeTelegram(trabajador3);
                                    }
                                    else System.out.println(" ");
                                    break;
                                default:
                                System.out.println("Error, introduce una opción válida.");
                            }
                            System.out.println("Pedido asignado correctamente");
                        }
                    }
                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();

                    break;
                case 2: // Modificar el estado de un pedido
                    Utils.limpiaPantalla();
                    boolean cambiado;
                    if (cliente1 == null) System.out.println("No hay clientes registrados");
                    else if (cliente1.getPedido1() != null || cliente1.getPedido2() != null) {
                        do {
                            cambiado = false;
                            Utils.limpiaPantalla();
                            if (cliente1.getPedido1() != null) System.out.println(cliente1.pintaPedidoParaAdmin(cliente1.getPedido1()));

                            if (cliente1.getPedido2() != null) System.out.println(cliente1.pintaPedidoParaAdmin(cliente1.getPedido2()));

                            if (cliente2 != null && cliente2.getPedido1() != null) System.out.println(cliente2.pintaPedidoParaAdmin(cliente2.getPedido1()));

                            if (cliente2 != null && cliente2.getPedido2() == null) System.out.println(cliente2.pintaPedidoParaAdmin(cliente2.getPedido2()));
                            System.out.print("Introduce el código del pedido al que le quieres cambiar el estado: ");
                            opcion = s.nextLine();

                            if (!cambiaEstado(opcion)) {
                                System.out.println("Error, hubo un problema con la búsqueda del pedido.");
                                Utils.pulsaParaContinuar();
                                Utils.limpiaPantalla();
                            } else {
                                Pedido pedidoTemporal = usuarios.seleccionaPedido(opcion);
                                Cliente clienteTemporal = usuarios.seleccionaCliente(pedidoTemporal);
                                System.out.println("Estado cambiado correctamente.");
                                Utils.enviaMensajeGmailCambioEstadoPedido(clienteTemporal, pedidoTemporal);
                                cambiado = true;
                            }
                        } while (!cambiado);
                    } else System.out.println("No hay pedidos realizados");
                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case 3: // Dar de alta un trabajador
                    Utils.limpiaPantalla();
                    boolean correoValidado = false;
                    String nombre, correo, contrasenia;
                    if (!usuarios.hayHuecoTrabajador()) System.out.println("Lo sentimos, no quedan plazas para más trabajadores.");
                    else {
                        do {
                            System.out.print("Introduce el nombre del trabajador: ");
                            nombre = s.nextLine();
                            if (nombre.isEmpty()) System.out.println("Debes introducir un nombre");
                        } while (nombre.isEmpty());
                        do {
                            System.out.print("Introduce el correo del trabajador: ");
                            correo = s.nextLine();
                            if (correo.isEmpty()) System.out.println("Debes introducir un correo");
                            if (!Utils.validaCorreo(correo)) {
                                System.out.println("Error, introduce un correo válido");
                            } else correoValidado = true;
                        } while (correo.isEmpty() || !correoValidado);
                       do {
                           System.out.print("Introduce la contraseña del trabajador: ");
                           contrasenia = s.nextLine();
                           if (contrasenia.isEmpty()) System.out.println("Debes introducir una contraseña");
                       } while (contrasenia.isEmpty());

                        Trabajador trabajadorTemp = new Trabajador(nombre, correo, contrasenia);

                        usuarios.darAltaTrabajador(trabajadorTemp);

                        Utils.pulsaParaContinuar();
                    }
                    break;
                case 4: // Ver todos los pedidos
                    Utils.limpiaPantalla();
                    if (cliente1 == null && cliente2 == null) System.out.println("No hay clientes registrados");
                    else {
                        if (cliente1.getPedido1() == null) System.out.println(" ");
                        else System.out.println(cliente1.pintaPedidoParaAdmin(cliente1.getPedido1()));

                        if (cliente1.getPedido2() == null) System.out.println(" ");
                        else System.out.println(cliente1.pintaPedidoParaAdmin(cliente1.getPedido2()));

                        if (cliente2 != null) {
                            if (cliente2.getPedido1() == null) System.out.println(" ");
                            else System.out.println(cliente2.pintaPedidoParaAdmin(cliente2.getPedido1()));

                            if (cliente2.getPedido2() == null) System.out.println(" ");
                            else System.out.println(cliente2.pintaPedidoParaAdmin(cliente2.getPedido2()));
                        }
                    }
                    Utils.pulsaParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case 5: // Ver todos los clientes
                    Utils.limpiaPantalla();
                    if (cliente1 == null && cliente2 == null) {
                        System.out.println("No hay clientes registrados.");
                        Utils.pulsaParaContinuar();
                    }
                    else {
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║                  CLIENTES                  ║");
                        System.out.println("╚════════════════════════════════════════════╝\n");
                        System.out.println(cliente1 == null ? " " : cliente1.pintaClienteAdmin());
                        System.out.println(cliente2 == null ? " " : cliente2.pintaClienteAdmin());
                        Utils.pulsaParaContinuar();
                    }
                    break;
                case 6: // Ver todos los trabajadores
                    Utils.limpiaPantalla();
                    if (trabajador1 == null && trabajador2 == null && trabajador3 == null) {
                        System.out.println("Todavía no hay trabajadores registrados.");
                        Utils.pulsaParaContinuar();
                    }
                    else {
                        System.out.println("╔══════════════════════════════════════════════╗");
                        System.out.println("║                 TRABAJADORES                 ║");
                        System.out.println("╚══════════════════════════════════════════════╝");
                        System.out.println(trabajador1 == null ? " " : trabajador1.pintaTrabajadorAdmin(trabajador1));
                        System.out.println(trabajador2 == null ? " " : trabajador2.pintaTrabajadorAdmin(trabajador2));
                        System.out.println(trabajador3 == null ? " " : trabajador3.pintaTrabajadorAdmin(trabajador3));
                        Utils.pulsaParaContinuar();
                    }
                    break;
                case 7: // Cerrar sesion
                    Utils.limpiaPantalla();
                    Utils.saliendo();
                    Utils.limpiaPantalla();
                    break;
                default:

            }
        } while (op != 7);
    }

    private static boolean cambiaEstado(String opcion) {
        if (cliente1 != null && actualizaPedido(opcion)) {
            return true;
        }
        return cliente2 != null && actualizaPedido(opcion);
    }

    // Metodo que permite cambiar el estado de un pedido
    private static boolean actualizaPedido(String opcion) {
            if (cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equals(opcion)) {
                cambiaEstadoPedido(cliente1.getPedido1());
                menuCambiaDatos(cliente1.getPedido1());
                return true;
            }
            if (cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equals(opcion)) {
                cambiaEstadoPedido(cliente1.getPedido2());
                menuCambiaDatos(cliente1.getPedido2());
                return true;
            }
            if (cliente2 != null) {
                if (cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equals(opcion)) {
                    cambiaEstadoPedido(cliente2.getPedido1());
                    menuCambiaDatos(cliente2.getPedido1());
                    return true;
                }
                if (cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equals(opcion)) {
                    cambiaEstadoPedido(cliente2.getPedido2());
                    menuCambiaDatos(cliente2.getPedido2());
                    return true;
                }
            }
            return false;
    }

    // Menu de registro
    public static void menuRegistro() {
        Utils.limpiaPantalla();

        var s = new Scanner(System.in);
        String nombre, apellido1, correo, contrasenia, provincia, localidad, direccion;
        int telefono;
        boolean telefonoVerificado = false;

        System.out.print("""
                ╔═════════════════════════════════════════════╗
                ║             REGISTRO DE USUARIO             ║
                ╚═════════════════════════════════════════════╝""");

        do {
            System.out.print("\n* Introduce tu nombre: ");
            nombre = s.nextLine();
            if (nombre.isEmpty()) System.out.println("Debes introducir un nombre");
        } while (nombre.isEmpty());

        do {
            System.out.print("* Introduce tu primer apellido: ");
            apellido1 = s.nextLine();
            if (apellido1.isEmpty()) System.out.println("Debes introducir un apellido");
        } while (apellido1.isEmpty());

        telefono = 0;
            do {
                try {
                    System.out.print("* Introduce tu teléfono: ");
                    telefono = Integer.parseInt(s.nextLine());
                    if (!usuarios.verificaTelefono(telefono)) System.out.println("Error, debes introducir un número de teléfono válido");
                    else telefonoVerificado = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error, introduce un teléfono válido.");
                    System.out.println();
                }
            } while (!telefonoVerificado);

        do {
            System.out.print("* Introduce tu correo: ");
            correo = s.nextLine();
            if (correo.isEmpty()) System.out.println("Debes introducir un correo");
            else if (!Utils.validaCorreo(correo)) System.out.println("Error, debes introducir un correo válido");
            if (!usuarios.correoValido(correo)) System.out.println("Error, el correo introducido ya está en uso.");
        } while (correo.isEmpty() || !Utils.validaCorreo(correo) || !usuarios.correoValido(correo));

        do {
            System.out.print("* Introduce una contraseña: ");
            contrasenia = s.nextLine();
            if (contrasenia.isEmpty()) System.out.println("Debes introducir una contraseña");
            else if (!usuarios.mideContrasenia(contrasenia)) System.out.println("Error, la contraseña debe tener como mínimo 4 caracteres");
        } while (contrasenia.isEmpty() || !usuarios.mideContrasenia(contrasenia));

        do {
            System.out.print("* Introduce tu provincia: ");
            provincia = s.nextLine();
            if (provincia.isEmpty()) System.out.println("Debes introducir tu provincia");
        } while (provincia.isEmpty());

        do {
            System.out.print("* Introduce tu localidad: ");
            localidad = s.nextLine();
            if (localidad.isEmpty()) System.out.println("Debes introducir tu localidad");
        } while (localidad.isEmpty());

        do {
            System.out.print("* Introduce tu direccion: ");
            direccion = s.nextLine();
            if (direccion.isEmpty()) System.out.println("Debes introducir tu direccion");
        } while (direccion.isEmpty());

        // Creo el cliente temporal una vez validados los datos
        Cliente clienteTemp = new Cliente(nombre, apellido1, telefono, correo, contrasenia,
                    provincia, localidad, direccion);

        usuarios.registraCliente(clienteTemp);

        Utils.pulsaParaContinuar();
        Utils.limpiaPantalla();
    }

    // Menu de cambio de estado de pedido
    public static void cambiaEstadoPedido(Pedido pedido) {
        var s = new Scanner(System.in);
        int opEstado;
            do {
                opEstado = -1;
                System.out.print("""
                Nuevo estado:
                1.- Recibido.
                2.- En preparación.
                3.- Retrasado.
                4.- Cancelado.
                5.- Enviado
                Seleccione el nuevo estado:\s""");
            try {
                opEstado = Integer.parseInt(s.nextLine());
                if (opEstado < 1 || opEstado > 5) System.out.println("Error, introduce un número válido.");
            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número válido.");
                System.out.println();
            }
        } while (opEstado < 1 || opEstado > 5);

        switch (opEstado) {
            case 1:
                pedido.setEstado("Recibido");
                break;
            case 2:
                pedido.setEstado("En preparación");
                break;
            case 3:
                pedido.setEstado("Retrasado");
                break;
            case 4:
                pedido.setEstado("Cancelado");
                break;
            case 5:
                pedido.setEstado("Enviado");
                break;
        }
    }

    // Menu de cambio de comentario y fecha
    public static void menuCambiaDatos(Pedido pedido) {

        var s = new Scanner(System.in);

        System.out.print("Quieres agregar un comentario? (S/N): ");
        String respuesta = s.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Introduce el nuevo comentario: ");
            String comentario = s.nextLine();
            pedido.setComentario(comentario);
        }

        System.out.print("Quieres cambiar la fecha del pedido? (S/N): ");
        respuesta = s.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            LocalDate fecha;
            do {
                System.out.print("Introduce la nueva fecha en este formato (yyyy-mm-dd): ");
                fecha = LocalDate.parse(s.nextLine());
                if (fecha.isBefore(pedido.getFechaPedido())) System.out.println("Debes introducir una fecha posterior a la fecha inicial");
                else pedido.setFechaPedido(fecha);
            } while (fecha.isBefore(pedido.getFechaPedido()));
        }
    }
}