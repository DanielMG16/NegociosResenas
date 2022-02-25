package Opiniones.datos;

public class Peluquero extends Negocio implements Comparable<Negocio>{
    private boolean unisex;


    public Peluquero(String nombre, String ubicacion, boolean unisex, Opiniones[] opiniones) {
        super(nombre, ubicacion, opiniones);
        this.unisex=unisex;
    }

    public boolean isUnisex() {
        return unisex;
    }

    public void setUnisex(boolean unisex) {
        this.unisex = unisex;
    }

    @Override
    public String toString() {
        if(unisex)
        {
            return super.toString()+"- unisex"+"\n"+
                    "Media de estrellas: "+opinionesMedia();
        }
        else{
            return super.toString()+"- No unisex"+"\n"+
                    "Media de estrellas: "+opinionesMedia();
        }
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
