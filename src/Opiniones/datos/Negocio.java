package Opiniones.datos;

public abstract class Negocio implements Comparable<Negocio>{
    private String nombre;
    private String ubicacion;
    private Opiniones[] opiniones;

    public Negocio(String nombre, String ubicacion, Opiniones[] opiniones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.opiniones= new Opiniones[opiniones.length];
        this.opiniones=opiniones;
    }

    public float opinionesMedia()
    {
        float aux=0;

        for(int i=0; i<opiniones.length;i++){
            aux+=opiniones[i].getEstrellas();
        }

        return aux/opiniones.length;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Opiniones[] getOpiniones() {
        return opiniones;
    }

    @Override
    public int compareTo(Negocio o) {
        if(this.nombre.compareTo(o.nombre) < 0)
            return -1;
        else if(this.nombre.compareTo(o.nombre) > 0)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return nombre+" "+"("+ubicacion+")";
    }


}
