package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
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
                "4. Comprobar número alumnos\n" +
                "5. Mostrar todo\n" +
                "6. Salir");

        switch (scanner.nextInt()){
            case 1:
                Alumno alumno = new Alumno();

                mostrarAlumnos(em);

                System.out.println("Introduce el DNI del alumno");
                alumno.setDni(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Introduce el Nombre del alumno");
                alumno.setNombre(scanner.nextLine());
                System.out.println("Introduce el ID de la clase del alumno:");
                alumno.setClaseId(scanner.nextInt());
                scanner.nextLine();

                em.getTransaction().begin();
                em.persist(alumno);
                em.getTransaction().commit();
                em.close();
                break;
            case 2:
                Clase clase = new Clase();

                mostrarClases(em);
                System.out.println("Introduce el ID de la clase");
                clase.setId(scanner.nextInt());
                System.out.println("Introduce el Instituto");
                clase.setInstitutoId(scanner.nextInt());
                System.out.println("Introduce el numero de alumnos");
                clase.setnAlumnos(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Introduce el nombre de la clase");
                clase.setNombre(scanner.nextLine());
                System.out.println("Introduce la rama");
                clase.setRama(scanner.nextLine());


                em.getTransaction().begin();
                em.persist(clase);
                em.getTransaction().commit();
                em.close();
                break;
            case 3:
                Instituto instituto = new Instituto();

                mostrarInstitutos(em);

                instituto.setId(2);
                instituto.setNAlumnos(1);
                instituto.setNombre("Institut Puig Castellar");


                em.getTransaction().begin();
                em.persist(instituto);
                em.getTransaction().commit();
                em.close();
            case 4:
                break;
            case 5:
                mostrarAlumnos(em);
                mostrarClases(em);
                mostrarInstitutos(em);
                break;
            case 6:
                System.out.println("Adiós");
                break;
            default:
                System.out.println("No existe esa opción");
                break;
        }

    }

    public static void mostrarAlumnos(EntityManager em){
        System.out.println("Alumnos:");
        TypedQuery<Alumno> query1 = em.createQuery("SELECT i FROM Alumno i", Alumno.class);
        List<Alumno> results1 = query1.getResultList();
        results1.forEach(System.out::println);
    }
    public static void mostrarClases(EntityManager em){
        System.out.println("Clases:");
        TypedQuery<Clase> query1 = em.createQuery("SELECT i FROM Clase i", Clase.class);
        List<Clase> results1 = query1.getResultList();
        results1.forEach(System.out::println);
    }
    public static void mostrarInstitutos(EntityManager em){
        System.out.println("Institutos:");
        TypedQuery<Instituto> query1 = em.createQuery("SELECT i FROM Instituto i", Instituto.class);
        List<Instituto> results1 = query1.getResultList();
        results1.forEach(System.out::println);
    }

}
