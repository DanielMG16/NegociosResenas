package Opiniones.datos;

public class Restaurante extends Negocio implements Comparable<Negocio>{
    private String tipocomida;


    public Restaurante(String nombre, String ubicacion, String tipocomida, Opiniones[] opiniones) {
        super(nombre, ubicacion, opiniones);
        this.tipocomida=tipocomida;
    }

    public String getTipocomida() {
        return tipocomida;
    }

    public void setTipocomida(String tipocomida) {
        this.tipocomida = tipocomida;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+tipocomida+"\n"+
                "Media de estrellas: "+opinionesMedia();
    }

    @Override
    public int compareTo(Negocio o) {
        if(this.opinionesMedia()> o.opinionesMedia())
            return 1;
        else if(this.opinionesMedia()< o.opinionesMedia())
            return -1;
        else
            return 0;
    }
}
