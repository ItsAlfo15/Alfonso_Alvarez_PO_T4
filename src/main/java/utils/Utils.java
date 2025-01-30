package utils;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.Cliente;
import models.Pedido;
import models.Trabajador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jakarta.mail.Transport.send;

public class Utils {

    public static void pulsaParaContinuar() {
        var s = new Scanner(System.in);
        System.out.print("Pulsa 'Enter' para continuar...");
        s.nextLine();
    }

    public static void limpiaPantalla() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void saliendo() throws InterruptedException {
        System.out.print("Saliendo");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(700);
            System.out.print(".");
        }
    }

    // Metodo que genera un token aleatorio
    public static String generaTokenAleatorio() {
        final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String token = "";
        for (int i = 0; i < 8; i++) {
            switch ((int) (Math.random() * 2)) {
                case 0:
                    token += ((int) (Math.random() * 10));
                    break;
                case 1:
                    token += LETRAS.charAt((int) (Math.random() * 26));
                    break;
                default:
                    break;
            }
        }
        return token;
    }

    // Metodo que envia un mensaje a telegram
    public static boolean enviaMensajeTelegram(Trabajador trabajador) {
        String direccion; // URL ed la API de mi bot en mi conversacion
        String fijo = "https://api.telegram.org/bot7932520971:AAHWztv_slC3pu-vvwX8acWHRZVXd6L3aVM/sendMessage?chat_id=7252309129&text=";
        String mensaje = pintaMensajeTelegram(trabajador);
        // Codificar el mensaje para evitar caracteres ilegales en la URL
        direccion = fijo + URLEncoder.encode(mensaje, StandardCharsets.UTF_8);
        boolean dev = false;
        try {
            URL url = new URL(direccion);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev;
    }

    // Metodo que envia un mensaje de telegram para un trabajador
    public static String pintaMensajeTelegram(Trabajador trabajador) {
        String nombre = trabajador.getNombre().toUpperCase();
        return  "╔══════════════════════════════════════════════╗\n" +
                "║                       NUEVO PEDIDO RECIBIDO                   \n" +
                "╠══════════════════════════════════════════════╣\n" +
                "║  " + nombre + " se te ha asignado un nuevo pedido.               \n" +
                "║  Comprueba tu correo para consultar los detalles \n" +
                "╚══════════════════════════════════════════════╝";
    }

    // Funcion que envia un token al correo del cliente
    public static String enviaToken(Cliente cliente) {
        String token = Utils.generaTokenAleatorio();
        String contenido = Utils.generaCorreoRegistro(token, cliente.getNombre(), cliente.getApellido1());
        Utils.enviaMensajeGmail(cliente.getCorreo(), "Gracias por registrarte en FernanShop", contenido);
        return token;
    }

    // Funcion que comprueba si el token generado es igual que el token introducido por teclado
    public static boolean compruebaToken(String token, String tokenIntroducido) {
        return token.equals(tokenIntroducido);
    }

    // Declaro vaiables para el siguiente metodo
    private static final String host = "smtp.gmail.com";
    private static final String user = "alfonso.alvarez.2202@gmail.com";
    private static final String pass = "zeps syuz tnwr tqro";

    // Metodo que envia un correo electronico
    public static void enviaMensajeGmail(String destino, String asunto, String mensaje) {

        // Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Obtenemos la sesión de nuestro servidor de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            // Creamos un mensaje de nuestro correo por defecto
            Message message = new MimeMessage(session);

            // En el mensaje establecemos el receptor
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));

            // Establecemos el asunto
            message.setSubject(asunto);

            // Añadimos el contenido del mensaje
            message.setContent(mensaje, "text/html; charset=utf-8");

            // Intentamos mandar el mensaje
            send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo que valida un correo
    public static Boolean validaCorreo (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String generaCorreoRegistro(String token, String nombre, String apellido1) {
        return  "<!DOCTYPE html>"
                + "<html lang=\"es\">"
                + "<head>"
                + "  <meta charset=\"UTF-8\">"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "  <title>FernanShop</title>"
                + "  <style>"
                + "    body {"
                + "        font-family: Arial, sans-serif;"
                + "        color: #e2dede;"
                + "        margin: 0;"
                + "        padding: 0;"
                + "        background-color: #f4f4f4;"
                + "    }"
                + "    .email-container {"
                + "        max-width: 600px;"
                + "        margin: 20px auto;"
                + "        background-color: rgb(0, 34, 54);"
                + "        border-radius: 8px;"
                + "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);"
                + "        overflow: hidden;"
                + "        color: #e2dede;"
                + "    }"
                + "    .header {"
                + "        background-color: rgb(0, 22, 56);"
                + "        color: #e2dede;"
                + "        text-align: center;"
                + "        padding: 20px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .header h1 {"
                + "        margin: 0;"
                + "        font-size: 24px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .content {"
                + "        background-image: linear-gradient(rgb(0, 49, 122), 20%, rgb(0, 22, 56));"
                + "        font-size: 16px;"
                + "        padding: 20px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .content p {"
                + "        margin: 10px 0;"
                + "        line-height: 1.6;"
                + "        color: #e2dede;"
                + "    }"
                + "    .cta {"
                + "        text-align: center;"
                + "        margin: 20px 0;"
                + "        color: #e2dede;"
                + "    }"
                + "    .cta h2 {"
                + "        color: #e2e0e0;"
                + "        margin: auto;"
                + "        padding: 8px;"
                + "        width: 150px;"
                + "        border-radius: 15px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .cta p {"
                + "        text-decoration: underline;"
                + "        color: #e2dede;"
                + "    }"
                + "    .footer {"
                + "        background-color: #858585;"
                + "        text-align: center;"
                + "        color: #c7c5c5;"
                + "        font-size: 14px;"
                + "        padding: 10px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .contact {"
                + "        text-align: center;"
                + "        display: inline;"
                + "        font-size: 14px;"
                + "        color: #e2dede;"
                + "    }"
                + "    .mensaje {"
                + "        font-size: 16px;"
                + "        padding-top: 10px;"
                + "        text-align: center;"
                + "        color: #e2dede;"
                + "    }"
                + "  </style>"
                + "</head>"
                + "<body>"
                + "  <div class=\"email-container\">"
                + "    <div class=\"header\">"
                + "      <h1>¡Bienvenido a Papelería FernanShop!</h1>"
                + "    </div>"
                + "    <div class=\"content\">"
                + "      <p>Hola <b>" + nombre + " " + apellido1 + "</b>.</p>"
                + "      <p>Gracias por registrarte en nuestra tienda. Estamos encantados de tenerte como parte de nuestra comunidad.</p>"
                + "      <div class=\"cta\">"
                + "        <p>Para verificar tu correo introduce el token dado a continuación:</p>"
                + "        <h2><b>" + token + "</b></h2>"
                + "      </div>"
                + "      <div class=\"contact\">"
                + "        <p>Si tienes alguna pregunta, no dudes en responder a este correo: <b>fernanshopF3@gmail.com</b></p>"
                + "        <div class=\"mensaje\">"
                + "            <p>¡Tambien puedes contactarnos a través de nuestra página web!</p>"
                + "        </div>"
                + "      </div>"
                + "    </div>"
                + "    <div class=\"footer\">"
                + "      <p>&copy; 2025 Papelería FernanShop. Todos los derechos reservados.</p>"
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";

    }

    public static String contenidoPedidoAsignado(Trabajador trabajador, Pedido pedido) {
        String comentario = (pedido.getComentario() != null ? pedido.getComentario() : "Sin comentarios");
        String salida = "<!DOCTYPE html>"
                + "<html lang=\"es\">"
                + "<head>"
                + "  <meta charset=\"UTF-8\">"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "  <title>FernanShop</title>"
                + "  <style>"
                + "    body {"
                + "        font-family: Arial, sans-serif;"
                + "        color: #e2dede !important;"
                + "        margin: 0;"
                + "        padding: 0;"
                + "        background-color: #f4f4f4;"
                + "    }"
                + "    .email-container {"
                + "        max-width: 600px;"
                + "        margin: 20px auto;"
                + "        background-color: rgb(0, 34, 54);"
                + "        border-radius: 8px;"
                + "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);"
                + "        overflow: hidden;"
                + "    }"
                + "    .header {"
                + "        background-color: rgb(0, 22, 56);"
                + "        text-align: center;"
                + "        padding: 20px;"
                + "    }"
                + "    .header h1 {"
                + "        margin: 0;"
                + "        font-size: 24px;"
                + "    }"
                + "    .content {"
                + "        background-image: linear-gradient(rgb(0, 49, 122), 20%, rgb(0, 22, 56));"
                + "        font-size: 16px;"
                + "        padding: 20px;"
                + "    }"
                + "    .content p {"
                + "        margin: 10px 0;"
                + "        line-height: 1.6;"
                + "    }"
                + "    .footer {"
                + "        background-color: #858585;"
                + "        text-align: center;"
                + "        font-size: 14px;"
                + "        padding: 10px;"
                + "        color: #c7c5c5;"
                + "    }"
                + "  </style>"
                + "</head>"
                + "<body>"
                + "  <div class=\"email-container\">"
                + "    <div class=\"header\"><h1>¡Se te ha asignado un nuevo pedido!</h1></div>"
                + "    <div class=\"content\">"
                + "      <h2>Hola <b>" + trabajador.getNombre() + "</b>.</h2>"
                + "      <h3>Aquí tienes los datos de tu nuevo pedido asignado:</h3>"
                + "      <div class=\"pedido-details\">"
                + "        <p><b>Código:</b> " + pedido.getCodigo() + "</p>"
                + "        <p><b>Estado:</b> " + pedido.getEstado() + "</p>"
                + "        <p><b>Fecha de Pedido:</b> " + pedido.getFechaPedido() + "</p>"
                + "        <p><b>Fecha Estimada de Entrega:</b> " + pedido.getFechaPedidoEstimada() + "</p>"
                + "        <p><b>Comentario: </b> " + comentario + "</p>"
                + "      </div>"
                + "      <h2>Detalles del Producto 1</h2>"
                + "      <div class=\"producto-details\">"
                + "        <p><b>Nombre:</b> " + pedido.getProducto1().getNombre() + "</p>"
                + "        <p><b>Precio:</b> " + pedido.getProducto1().getPrecio() + "</p>"
                + "        <p><b>Cantidad:</b> " + pedido.getProducto1().getCantidad() + "</p>"
                + "      </div>";

        if (pedido.getProducto2() != null) {
            salida += "      <h2>Detalles del Producto 2</h2>"
                    + "      <div class=\"producto-details\">"
                    + "        <p><b>Nombre:</b> " + pedido.getProducto2().getNombre() + "</p>"
                    + "        <p><b>Precio:</b> " + pedido.getProducto2().getPrecio() + "</p>"
                    + "        <p><b>Cantidad:</b> " + pedido.getProducto2().getCantidad() + "</p>"
                    + "      </div>";
        }

        if (pedido.getProducto3() != null) {
            salida += "      <h2>Detalles del Producto 3</h2>"
                    + "      <div class=\"producto-details\">"
                    + "        <p><b>Nombre:</b> " + pedido.getProducto3().getNombre() + "</p>"
                    + "        <p><b>Precio:</b> " + pedido.getProducto3().getPrecio() + "</p>"
                    + "        <p><b>Cantidad:</b> " + pedido.getProducto3().getCantidad() + "</p>"
                    + "      </div>";
        }

        salida += "      <div class=\"footer\">"
                + "        <p>Si tienes alguna pregunta, no dudes en responder a este correo: <b>fernanshopF3@gmail.com</b></p>"
                + "        <p>&copy; 2025 Papelería FernanShop. Todos los derechos reservados.</p>"
                + "      </div>"
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";

        return salida;
    }

    public static void enviaMensajeGmailCambioEstadoPedido(Cliente cliente, Pedido pedido) {
        enviaMensajeGmail(cliente.getCorreo(), "Su pedido ha sido modificado", contenidoPedidoModificado(cliente, pedido));
    }

    private static String contenidoPedidoModificado(Cliente cliente, Pedido pedido) {
        String comentario = (pedido.getComentario() != null ? pedido.getComentario() : "Sin comentarios");
        String salida = "<!DOCTYPE html>"
                + "<html lang=\"es\">"
                + "<head>"
                + "  <meta charset=\"UTF-8\">"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "  <title>FernanShop</title>"
                + "  <style>"
                + "    body {"
                + "        font-family: Arial, sans-serif;"
                + "        color: #e2dede !important;"
                + "        margin: 0;"
                + "        padding: 0;"
                + "        background-color: #f4f4f4;"
                + "    }"
                + "    .email-container {"
                + "        max-width: 600px;"
                + "        margin: 20px auto;"
                + "        background-color: rgb(0, 34, 54);"
                + "        border-radius: 8px;"
                + "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);"
                + "        overflow: hidden;"
                + "    }"
                + "    .header {"
                + "        background-color: rgb(0, 22, 56);"
                + "        text-align: center;"
                + "        padding: 20px;"
                + "    }"
                + "    .header h1 {"
                + "        margin: 0;"
                + "        font-size: 24px;"
                + "    }"
                + "    .content {"
                + "        background-image: linear-gradient(rgb(0, 49, 122), 20%, rgb(0, 22, 56));"
                + "        font-size: 16px;"
                + "        padding: 20px;"
                + "    }"
                + "    .content p {"
                + "        margin: 10px 0;"
                + "        line-height: 1.6;"
                + "    }"
                + "    .footer {"
                + "        background-color: #858585;"
                + "        text-align: center;"
                + "        font-size: 14px;"
                + "        padding: 10px;"
                + "        color: #c7c5c5;"
                + "    }"
                + "  </style>"
                + "</head>"
                + "<body>"
                + "  <div class=\"email-container\">"
                + "    <div class=\"header\"><h1>Su pedido ha sido modificado</h1></div>"
                + "    <div class=\"content\">"
                + "      <h2>Hola <b>" + cliente.getNombre() + "</b>.</h2>"
                + "      <h2>Aquí tienes los datos del pedido</h2>"
                + "      <div class=\"pedido-details\">"
                + "        <p><b>Código:</b> " + pedido.getCodigo() + "</p>"
                + "        <p><b>Estado:</b> " + pedido.getEstado() + "</p>"
                + "        <p><b>Fecha de Pedido:</b> " + pedido.getFechaPedido() + "</p>"
                + "        <p><b>Fecha Estimada de Entrega:</b> " + pedido.getFechaPedidoEstimada() + "</p>"
                + "        <p><b>Comentario: </b> " + comentario + "</p>"
                + "      </div>"
                + "      <h2>Detalles del Producto 1</h2>"
                + "      <div class=\"producto-details\">"
                + "        <p><b>Nombre:</b> " + pedido.getProducto1().getNombre() + "</p>"
                + "        <p><b>Precio:</b> " + pedido.getProducto1().getPrecio() + "</p>"
                + "        <p><b>Cantidad:</b> " + pedido.getProducto1().getCantidad() + "</p>"
                + "      </div>";

        if (pedido.getProducto2() != null) {
            salida += "      <h2>Detalles del Producto 2</h2>"
                    + "      <div class=\"producto-details\">"
                    + "        <p><b>Nombre:</b> " + pedido.getProducto2().getNombre() + "</p>"
                    + "        <p><b>Precio:</b> " + pedido.getProducto2().getPrecio() + "</p>"
                    + "        <p><b>Cantidad:</b> " + pedido.getProducto2().getCantidad() + "</p>"
                    + "      </div>";
        }

        if (pedido.getProducto3() != null) {
            salida += "      <h2>Detalles del Producto 3</h2>"
                    + "      <div class=\"producto-details\">"
                    + "        <p><b>Nombre:</b> " + pedido.getProducto3().getNombre() + "</p>"
                    + "        <p><b>Precio:</b> " + pedido.getProducto3().getPrecio() + "</p>"
                    + "        <p><b>Cantidad:</b> " + pedido.getProducto3().getCantidad() + "</p>"
                    + "      </div>";
        }

        salida += "      <div class=\"footer\">"
                + "        <p>Si tienes alguna pregunta, no dudes en responder a este correo: <b>fernanshopF3@gmail.com</b></p>"
                + "        <p>&copy; 2025 Papelería FernanShop. Todos los derechos reservados.</p>"
                + "      </div>"
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";

        return salida;
    }
}


