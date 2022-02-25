package Opiniones.datos;

public class Opiniones {
    private Usuarios usuario;
    private String comentario;
    private int estrellas;

    public Opiniones(Usuarios usuario, String comentario, int estrellas) {
        this.usuario = usuario;
        this.comentario = comentario;
        if(estrellas >= 0 && estrellas <= 5){
            this.estrellas=estrellas;
        }
        else{
            System.out.println("Estrellas incorrectas.");
            this.estrellas=0;
        }
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return usuario.getLogin()+"\n"
                + comentario +"\n"
                +estrellas+"/5";
    }
}
