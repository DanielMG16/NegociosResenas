package Opiniones.principales;

import java.util.Arrays;
import java.util.Scanner;

import Opiniones.datos.*;

public class Gestion {
    private Negocio[] negocios;
    private Usuarios[] usuarios;

    public void inicializar(){

        Opiniones[] opiniones= new Opiniones[2];

        usuarios= new Usuarios[10];
        usuarios[0]= new Usuarios("Daniel", "1234");
        usuarios[1]= new Usuarios("U1", "1234");
        usuarios[2]= new Usuarios("U2", "4321");
        usuarios[3]= new Usuarios("U3", "4321");
        usuarios[4]= new Usuarios("U4", "123456");
        usuarios[5]= new Usuarios("U5", "654321");
        usuarios[6]= new Usuarios("U6", "654321");
        usuarios[7]= new Usuarios("U7", "123456");
        usuarios[8]= new Usuarios("U8", "123123");
        usuarios[9]= new Usuarios("U9", "123123");

        opiniones[0]= new Opiniones(usuarios[0],
                "comentario1", 5);
        opiniones[1]= new Opiniones(usuarios[1],
                "c2", 4);

        negocios= new Negocio[6];
        negocios[0]= new Garaje("Garaje1",
                "Madrid", (float)7.8, opiniones);
        negocios[1]= new Garaje("Garaje2",
                "Barcelona", (float)9.8, opiniones);
        negocios[2]= new Peluquero("Pelu1",
                "Alicante", true, opiniones);
        negocios[3]= new Peluquero("Pelu2",
                "Valencia", false, opiniones);
        negocios[4]= new Restaurante("Restaurante1",
                "Granada", "Italiana", opiniones);
        negocios[5]= new Restaurante("Restaurante2",
                "Sevilla", "Carne", opiniones);

    }

    public Usuarios iniciarSesion(String login, String contraseña){

        for(int i=0; i< usuarios.length; i++)
        {
            if(usuarios[i].getLogin().equals(login) &&
                    usuarios[i].getContraseña().equals(contraseña)){
                return usuarios[i];
            }
        }

        return null;
    }

    public void misReseñas(Usuarios usu){
        boolean encontrado= false;

        for(int i=0; i< negocios.length; i++)
        {
            for(int j=0; j<negocios[i].getOpiniones().length; j++)
            {
               if(negocios[i].getOpiniones()[j].getUsuario().getLogin().equals(usu.getLogin())){
                   System.out.println(negocios[i].getOpiniones()[j]);
                   encontrado= true;
               }
            }
        }

        if(!encontrado)
        {
            System.out.println("No tienes reseñas");
        }
    }

    public void listaNegocios()
    {
        Arrays.sort(negocios);
        for(int i=0; i< negocios.length; i++)
        {
            System.out.println(negocios[i]);
        }
    }

    public void negociosMejorCalificados(String tipo){
        Arrays.sort(negocios);
        switch (tipo){
            case "RESTAURANTE":
                for(int i=0; i< negocios.length; i++){
                    if(negocios[i].getClass().equals(Restaurante.class))
                    {
                        System.out.println(negocios[i]);
                    }
                }
                break;
            case "GARAJE":
                for(int i=0; i< negocios.length; i++){
                    if(negocios[i].getClass().equals(Garaje.class))
                    {
                        System.out.println(negocios[i]);
                    }
                }
                break;
            case "PELUQUERIA":
                for(int i=0; i< negocios.length; i++){
                    if(negocios[i].getClass().equals(Peluquero.class))
                    {
                        System.out.println(negocios[i]);
                    }
                }
                break;
            default:
                System.out.println("Ese tipo no existe");
        }
    }

    public void tieneComentario(Negocio negocio, Usuarios usu)
    {
        for(int i=0; i<negocio.getOpiniones().length; i++)
        {
            if(negocio.getOpiniones()[i].getUsuario()== usu)
            {
                ChainReview(negocio.getOpiniones()[i]);
            }
        }

    }

    public void ChainReview(Opiniones opinion)
    {
        Scanner sc = new Scanner(System.in);
        int rating;
        String comentario;

        System.out.println("Escribe el nuevo comentario");
        comentario= sc.nextLine();

        System.out.println("Esribe el nuevo rating");
        rating=sc.nextInt();

        opinion.setComentario(comentario);
        opinion.setEstrellas(rating);
    }

    public Negocio BuscarNegocio(String nombre)
    {
        for(int i=0; i< negocios.length;i++)
        {
            if(nombre.toUpperCase().equals(negocios[i].getNombre().toUpperCase()))
            {
                return negocios[i];
            }
        }

        return null;
    }
}
