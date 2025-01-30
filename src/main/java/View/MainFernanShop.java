package View;

import models.Admin;
import models.Usuarios;
import utils.Menus;
import utils.Utils;
import java.util.Scanner;

import static models.Usuarios.*;

public class MainFernanShop {
    private static final Scanner S = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        // Definicion de variables
        int op;

        String correo, contrasenia;

        Usuarios usuarios = new Usuarios();

        // MOCK para pruebas
        usuarios.MOCK();

        // Menu principal
        do {
            op = -1;
            System.out.print("""
                    ╔════════════════════════════════╗
                    ║         ¡¡BIENVENIDO!!         ║
                    ╠════════════════════════════════╣
                    ║ 1.- Iniciar sesión             ║
                    ║ 2.- Regístrate                 ║
                    ╚════════════════════════════════╝
                    Introduce la opción deseada:\s""");
            try {
               op = Integer.parseInt(S.nextLine());
               if (op != 1 && op != 2) {
                   System.out.println("Error, introduce un número válido.");
                   Utils.pulsaParaContinuar();
                   Utils.limpiaPantalla();
               }

            } catch (NumberFormatException e) {
                System.out.println("Error, introduce un número válido.");
                Utils.pulsaParaContinuar();
                Utils.limpiaPantalla();
            }
                switch (op) {
                    case 1: // Iniciar sesion
                        Utils.limpiaPantalla();
                        System.out.print("""
                            ╔════════════════════════════════════════════╗
                            ║              INICIO DE SESIÓN              ║
                            ╚════════════════════════════════════════════╝
                             * Introduce tu correo:\s""");
                        correo = S.nextLine();
                        System.out.print(" * Introduce la contraseña: ");
                        contrasenia = S.nextLine();
                        Utils.limpiaPantalla();
                        if (!usuarios.login(correo, contrasenia)) System.out.println("Error, correo y/o contraseña incorrectos.\n");
                        else {
                            verificaUsuario(correo, contrasenia);
                        }
                        break;
                    case 2: // Registro para usuario
                        Utils.limpiaPantalla();
                        if (!usuarios.hayHuecoCliente()) System.out.println("Lo sentimos, no tenemos espacio para más registros.");
                        else {
                            Menus.menuRegistro();
                            System.out.println("Su registro se ha completado exitosamente. Inicia sesión a continuación.");
                            Utils.pulsaParaContinuar();
                            Utils.limpiaPantalla();
                        }
                        break;
                    default:
                }
        } while (true);
    } // FIN DEL MAIN

    // FUNCIONES

    // Funcion que asigna un menu dependiendo del correo y la contraseña y valida el correo del cliente
    public static void verificaUsuario(String correo, String contrasenia) throws InterruptedException {
        Admin admin = new Admin();

        if (admin.getCorreo().equals(correo) && admin.getContrasenia().equals(contrasenia)) {
            Menus.menuAdministrador();
        } else if (cliente1 != null && cliente1.getCorreo().equals(correo) && cliente1.getContrasenia().equals(contrasenia)) {
            if (cliente1.isValidado()) Menus.menuCliente(cliente1);
            else {
                // Envio un correo con el token de verificacion y lo compruebo
                System.out.println("Su correo aún no está validado");
                String tokenGenerado = Utils.enviaToken(cliente1);
                System.out.print("Introduce el token que se te ha enviado por correo: ");
                String tokenIntroducido = S.nextLine();
                cliente1.setValidado(Utils.compruebaToken(tokenGenerado, tokenIntroducido));
                if (cliente1.isValidado()) System.out.println("Su correo ha sido validado correctamente, inicie sesión a continuación");
                else System.out.println("Error, token introducido incorrecto");
                Utils.pulsaParaContinuar();
                Utils.limpiaPantalla();
            }
        } else if (cliente2 != null && cliente2.getCorreo().equals(correo) && cliente2.getContrasenia().equals(contrasenia)) {
            if (cliente2.isValidado()) Menus.menuCliente(cliente2);
            else {
                // Envio un correo con el token de verificacion y lo compruebo
                System.out.println("Su correo aún no está validado");
                String tokenGenerado = Utils.enviaToken(cliente2);
                System.out.print("Introduce el token que se te ha enviado por correo: ");
                String tokenIntroducido = S.nextLine();
                cliente2.setValidado(Utils.compruebaToken(tokenGenerado, tokenIntroducido));
                if (cliente2.isValidado()) System.out.println("Su correo ha sido validado correctamente, inicie sesión a continuación");
                else System.out.println("Error, token introducido incorrecto");
                Utils.pulsaParaContinuar();
                Utils.limpiaPantalla();
            }
        } else if (trabajador1 != null && trabajador1.getCorreo().equals(correo) && trabajador1.getContrasenia().equals(contrasenia)) {
            Menus.menuTrabajador(trabajador1);
        } else if (trabajador2 != null && trabajador2.getCorreo().equals(correo) && trabajador2.getContrasenia().equals(contrasenia)) {
            Menus.menuTrabajador(trabajador2);
        } else if (trabajador3 != null && trabajador3.getCorreo().equals(correo) && trabajador3.getContrasenia().equals(contrasenia)) {
            Menus.menuTrabajador(trabajador3);
        }
    }
}