package com.mycompany.objectdbdemo;

import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Alumno;

public class principal {

    public static EntityManagerFactory emf;
    
    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("ejerciciouno.odb");
        var em = emf.createEntityManager();
int opcion= 5;
        while (opcion!=6) {
			imprimirMenu();
			opcion = leerNumero();
			switch (opcion) {
			case 1:
				limpiarPantalla();
                                
                                System.out.println("********* 1.- insertarAlumno() ********************");
				System.out.println("Nombre");
				String nombre= leerPalabra();
				System.out.println("Telefono");
				String telefono=leerPalabra();
				System.out.println("Email");
				String email=leerPalabra();
                                System.out.println("Nota AD");
				Double notaAD=leerDouble();
                                
                                System.out.println("Nota DI");
				Double notaDI=leerDouble();
                                
				
                                
                                Alumno a = new Alumno();
                                a.setNombre(nombre);
                                a.setTelefono(telefono);
                                a.setEmail(email);
                                a.setAd(notaAD);
                                a.setDi(notaDI);
                                
                                insertarAlumno(a);

				System.out.println("");
				System.out.println("Alumno añadido");
		        System.out.println("");
				pressEnter();
				limpiarPantalla();
				break;
				
			case 2:
				System.out.println("********* 2.- listarTodo() ********************");				
                                listarTodo();
				pressEnter();
				limpiarPantalla();
				break;
				
			case 3:
				System.out.println("********* 3.- listarSuspensos() ********************");
				listarSuspensos();
                                pressEnter();
				limpiarPantalla();
				break;
      			case 4:
				System.out.println("********* 4.- notaMedia() ********************");
				notaMedia();
                                pressEnter();
				limpiarPantalla();
				break;
       			case 5:
				System.out.println("********* 5.- ratioAprobados() ********************");
				porcentajeAprobados();
                                pressEnter();
				limpiarPantalla();
				break;
                        case 6:
              			System.out.println("Fin del Programa");
				break;
                        default:
				System.out.println("Opcion Incorrecta");
				pressEnter();
		            
			}

			}

//        Alumno a1 = new Alumno();
//        a1.setNombre("Jorge");
//        a1.setTelefono("123456");
//        a1.setEmail("jorge@gmail.com");
//        a1.setAd(5.0);
//        a1.setDi(4.0);
//        
//        Alumno a2 = new Alumno();
//        a2.setNombre("Maria");
//        a2.setTelefono("22333");
//        a2.setEmail("maria@gmail.com");
//        a2.setAd(6.0);
//        a2.setDi(8.0);
//        
//        Alumno a3 = new Alumno();
//        a3.setNombre("Juan");
//        a3.setTelefono("1444422");
//        a3.setEmail("juan@gmail.com");
//        a3.setAd(9.0);
//        a3.setDi(9.0);
//        
//        Alumno a4 = new Alumno();
//        a4.setNombre("Ana");
//        a4.setTelefono("155555");
//        a4.setEmail("ana@gmail.com");
//        a4.setAd(2.0);
//        a4.setDi(3.0);
//        
//        Alumno a5 = new Alumno();
//        a5.setNombre("Jose Luis");
//        a5.setTelefono("224444");
//        a5.setEmail("josel@gmail.com");
//        a5.setAd(3.0);
//        a5.setDi(6.0);
     
        
        
        em = emf.createEntityManager();
        TypedQuery<Long> q = em.createQuery("select a.id from Alumno a order by a.id desc", Long.class);
        var resultado = q.getResultList().get(0);
        em.close();

        System.out.println(resultado); 
        
        listarTodo();
       
    }
    
        public static void imprimirMenu() {
		System.out.println("**************************************************");
		System.out.println("**** Aplicacion CRUD Alumnos ****");
		System.out.println("**************************************************");
		System.out.println("********* 1.- insertarAlumno ***********************");
		System.out.println("********* 2.- listarTodo ********************");
		System.out.println("********* 3.- listarSuspensos *****");
		System.out.println("********* 4.- notaMedia *****");
		System.out.println("********* 5.- ratioAprobados **********");
		System.out.println("********* 6.- Salir ******************************");
		System.out.println("**************************************************");
		System.out.print("Introduce una opción: ");
	}

    public static int leerNumero() {
		Scanner sc = new Scanner(System.in);
		int numero=sc.nextInt();
		String Quitar_retorno=sc.nextLine();
		return numero; 
	}
    public static Double leerDouble() {
		Scanner sc = new Scanner(System.in);
		Double numero=sc.nextDouble();
		String Quitar_retorno=sc.nextLine();
		return numero; 
	}


    
    
    
	public static void limpiarPantalla() {
		//Rellena el contenido. No modifiques la cabecera.
		for(int i=0;i<60;i++) {
			System.out.println("");
		}
	}
	
	public static String leerPalabra() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static void pressEnter()
	{ 
		System.out.println("Presiona Enter para continuar.");
		try
		{
			System.in.read();
		}  
		catch(Exception e)
		{}  
	}
    
    
    
    
     public static void listarTodo()
	{ 
        EntityManager em=emf.createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select alu from Alumno alu",Alumno.class);
        for( Alumno alu : q.getResultList()){
            System.out.println(alu.toNombreNotas());
 //           System.out.println(alu);
        }
        em.close();
	}

    private static void insertarAlumno(Alumno alu) {
        var em = emf.createEntityManager();
                            em=emf.createEntityManager();
                            em.getTransaction().begin();
                            em.persist(alu);
                            em.getTransaction().commit();
                            em.close();
    }
    
         public static void listarSuspensos()
	{ 
        EntityManager em=emf.createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select alu from Alumno alu where alu.ad<5 or alu.di<5",Alumno.class);
        for( Alumno alu : q.getResultList()){
            System.out.println(alu.toNombreNotas());
 //           System.out.println(alu);
        }
        em.close();
	}
         
        public static void notaMedia(){ 
        EntityManager em=emf.createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select alu from Alumno alu",Alumno.class);
        int cont=0;
        Double mediaAd=0.0;
        Double mediaDi=0.0;
        for( Alumno alu : q.getResultList()){
            cont++;
            mediaAd=mediaAd+alu.getAd();
            mediaDi=mediaDi+alu.getDi();
 //          System.out.println(alu.toNombreNotas());
 //           System.out.println(alu);
        }
        em.close();
        System.out.println("Media AD= "+(mediaAd=(mediaAd/cont)));
        System.out.println("Media DI"+(mediaDi=(mediaDi/cont)));
        
	}
        
        public static void porcentajeAprobados()
	{ 
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(alu) FROM Alumno alu");
        long total = (Long)query.getSingleResult();
        Query query2 = em.createQuery("SELECT COUNT(alu) FROM Alumno alu where alu.ad<5 or alu.di<5");
        long sus = (Long)query2.getSingleResult();
        em.close();
        long aprobados=total-sus;
        System.out.println("Porcentaje de aprobados: ");
        System.out.println("Total alumnos: "+total);
        System.out.println("Total aprobados: "+sus);
        double ratio=((aprobados*100)/(total));
        System.out.println(ratio+"%");
	}
    
}
