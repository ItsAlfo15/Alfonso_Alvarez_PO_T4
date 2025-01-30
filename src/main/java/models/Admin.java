package models;

public class Admin {

    // Atributos
    private String correo;
    private String contrasenia;

    // Constructor
    public Admin() {
        correo = "admin@gmail.com";
        contrasenia = "12345";
    }

    // Getters y Setters
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

}