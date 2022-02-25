package Opiniones.datos;

public class Garaje extends Negocio implements Comparable<Negocio>{
    private float precio;

    public Garaje(String nombre, String ubicacion, float precio, Opiniones[] opiniones) {
        super(nombre, ubicacion, opiniones);
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+precio+" eur/h"+"\n"+
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
