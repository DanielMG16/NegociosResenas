package Opiniones.principales;
import Opiniones.datos.Negocio;
import Opiniones.datos.Usuarios;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int opcion=0;
        Usuarios usu;
        Gestion gestion= new Gestion();
        String entrada, tipo, nombreNegocio;
        Negocio negocio;
        String[] partes;

        gestion.inicializar();
        /*
        Se tiene que escribir los dos en la misma linea separadas
        por un espacio, ya que uso un split ahi.
        */
        do {
            System.out.println("Dime el usuario y la contraseña: ");
            entrada=sc.nextLine();

            partes=entrada.split(" ");

            usu=gestion.iniciarSesion(partes[0], partes[1]);
        }while(gestion.iniciarSesion(partes[0], partes[1])==null);

        System.out.flush();
        do {

            System.out.println("1. Mis reseñas.");
            System.out.println("2. Lista de Negocios.");
            System.out.println("3. Negocios mejor calificados.");
            System.out.println("4. Editar mi reseña.");
            System.out.println("5. Salir.");
            System.out.println("Elige una opción:");
            opcion= sc.nextInt();

            switch (opcion)
            {
                case 1:
                    gestion.misReseñas(usu);
                    break;
                case 2:
                    gestion.listaNegocios();
                    break;
                case 3:
                    System.out.println("Que tipo de negocio buscas: ");
                    sc.nextLine();
                    tipo= sc.nextLine();
                    gestion.negociosMejorCalificados(tipo.toUpperCase());
                    break;
                case 4:
                    gestion.listaNegocios();
                    sc.nextLine();
                    System.out.println("Dime el nombre del negocio que buscas: ");
                    nombreNegocio= sc.nextLine();
                    negocio= gestion.BuscarNegocio(nombreNegocio);
                    if(negocio != null)
                    {
                        gestion.tieneComentario(negocio , usu);
                    }
                    else
                    {
                        System.out.println("negocio no encontrado");
                    }
                    break;
                case 5:
                    System.out.println("Has salido.");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        }while(opcion != 5);
    }
}
