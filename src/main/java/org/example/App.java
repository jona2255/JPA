package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("damPersistence");
        EntityManager em = emf.createEntityManager();
        // read the existing entries and write to console
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Añadir Alumno\n" +
                "2. Añadir Clase\n" +
                "3. Añadir Instituto\n" +
                "4. Comprobar número alumnos");

        switch (scanner.nextInt()){
            case 1:
                Alumno alumno = new Alumno();
                System.out.println("Introduce el DNI del alumno");

                alumno.setDni(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Introduce el Nombre del alumno");
                alumno.setNombre(scanner.nextLine());

                System.out.println("Introduce el ID de la clase del alumno:");
                // Falta mostrar los id de las clases

                int i = 0;
                boolean fin = true;
                while (fin){
                    try {
                        Clase mClase = em.find(Clase.class, i);
                        i++;
                        System.out.println(mClase);
                    } catch (NullPointerException e){
                        fin = false;
                    }

                }
                alumno.setClaseId(scanner.nextInt());
                scanner.nextLine();
                em.getTransaction().begin();
                em.persist(alumno);
                em.getTransaction().commit();
                em.close();
                break;
            case 2:
                Clase clase = new Clase();
                clase.setId(2);
                clase.setInstitutoId(1);
                clase.setnAlumnos(1);
                clase.setNombre("1n-DAM");
                clase.setRama("DAM");


                em.getTransaction().begin();
                em.persist(clase);
                em.getTransaction().commit();
                em.close();
                break;
            case 3:
                Instituto instituto = new Instituto();
                instituto.setId(2);
                instituto.setNAlumnos(1);
                instituto.setNombre("Institut Puig Castellar");


                em.getTransaction().begin();
                em.persist(instituto);
                em.getTransaction().commit();
                em.close();
            case 4:
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }



        Clase clase = new Clase();
        clase.setId(2);
        clase.setInstitutoId(1);
        clase.setnAlumnos(1);
        clase.setNombre("1n-DAM");
        clase.setRama("DAM");

        Alumno alumno = new Alumno();
        alumno.setDni(22345678);
        alumno.setNombre("andres");
        alumno.setClaseId(3);

        em.getTransaction().begin();
        em.persist(instituto);
        em.persist(clase);
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }
}
