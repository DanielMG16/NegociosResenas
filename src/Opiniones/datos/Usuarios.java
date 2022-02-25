package Opiniones.datos;

public class Usuarios {
    private String login;
    private String contraseña;

    public Usuarios(String login, String contraseña) {
        this.login = login;
        this.contraseña = contraseña;
    }

    public String getLogin() {
        return login;
    }

    public String getContraseña() {
        return contraseña;
    }
}
