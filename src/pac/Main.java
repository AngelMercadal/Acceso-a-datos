package pac;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) { 
		
		 //llamamos al archivo de configuracion con los datos de conexión e iniciamos sesión
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
		Session session=factory.openSession();
		
			
	try {	
		
		//introducimos los datos de cada módulo para llamar al procedimiento que los  insertan en la BBDD
		
		insertarModulo("Programacion B","M03B",session);
		insertarModulo("Acceso a Datos","M06",session);
		insertarModulo("Desarrollo de aplicaciones moviles","M08",session);
		insertarModulo("Servicios y procesos","M09",session);
		
		//introducimos como parámetros los datos del profesor en su procedimiento 
		
		insertarProfesor("Alvaro","Hombre",session);
		
		

	       
			
	        // vamos a insertar el alumno con los siguientes datos : Juan, Espaniola, 26, Hombre, Modulos (1,2,3,4)
	   
		
		        Set<Modulo> modulos = new HashSet<>();     //creamos un set de modulos
		
	            List<Modulo>listmodulos=session.createQuery("from Modulo mo where mo.id IN (1,2,3,4)").getResultList();  //hacemos una consulta para recuperar los modulos ya insertados en la BBDD con las ids correspondientes
	         
	  			for (Modulo modulo:listmodulos) {modulos.add(modulo);}    //añadimos cada modulo recuperado en la lista en el set creado
	  			
	  			Alumno alumno=new Alumno("Juan","Espaniola",26,"Hombre",modulos);         //inicializamos el objeto alumno
	  			
	  			insertarAlumno(alumno,session);   // procedimiento para insertar el alumno en la BDD 
				
	  			
	  		// vamos a insertar el alumno con los siguientes datos : Pedro, Andorrana, 21, Hombre, Modulos (1,2,4)
	  			
	  			
	  			
	  			Set<Modulo> modulos2 = new HashSet<>();
	  			
	  			List<Modulo>listmodulos2=session.createQuery("from Modulo mo where mo.id IN (1,2,4)").getResultList();
		         
		  		for (Modulo modulo:listmodulos2) {modulos2.add(modulo);}
					
		  		Alumno alumno2=new Alumno("Pedro","Andorrana",21,"Hombre",modulos2);
		  			
		  		insertarAlumno(alumno2,session);
		  			
		  			
			
	  		// vamos a insertar el alumno con los siguientes datos : Marta, Espaniola, 19, Mujer, Modulos (3,4)
		  			
		  			
		  			
		  		Set<Modulo> modulos3 = new HashSet<>();
		  			
		  		List<Modulo>listmodulos3=session.createQuery("from Modulo mo where mo.id IN (3,4)").getResultList();
			         
			    for (Modulo modulo:listmodulos3) {modulos3.add(modulo);}
						
			  	Alumno alumno3=new Alumno("Marta","Espaniola",19,"Mujer",modulos3);
			
			  	insertarAlumno(alumno3,session);
			  			
			  			
			  			
			  			
			  			
			  			
	  		// vamos a insertar el alumno con los siguientes datos : Carla, Francesa, 35, Mujer, Modulos (2,3,4)
			  			
			  		
			  			
			  	Set<Modulo> modulos4 = new HashSet<>();
			  			
			  	List<Modulo>listmodulos4=session.createQuery("from Modulo mo where mo.id IN (2,3,4)").getResultList();
				        
				for (Modulo modulo:listmodulos4) {modulos4.add(modulo);}
							
				Alumno alumno4=new Alumno("Carla","Francesa",35,"Mujer",modulos4);
			
				insertarAlumno(alumno4,session);
			
			
			
		
			
	  }finally{
						
			session.close();   //cerramos las conexiones
			factory.close();
		}}
		
		
		
	
	
	
	
	
		public static void insertarModulo(String nombre,String codigo,Session session) {
		
		  
		 try {
		
	      	Modulo modulo=new Modulo(nombre,codigo);        //inicializamos el modulo
			
			session.beginTransaction();                     //iniciamos transacción    
			
			session.save(modulo);                      //guardamos el objeto en la BBDD
			
			session.getTransaction().commit();         //hacemos commit
			
			System.out.println("Insert into modulo, nombre: "+nombre+", codigo: "+codigo);    // mensaje por pantalla
						
			
			
		}catch (Exception e) {

			System.out.println("Problema al insertar un modulo");

			}}
			
		

		
		
	

		public static void insertarProfesor(String nombre,String sexo,Session session) {
		
			
		 try {
			
			Profesor profesor=new Profesor(nombre,sexo);            //usamos mismo procedimiento que para módulo
			
			session.beginTransaction();
			
			session.save(profesor);
			
			session.getTransaction().commit();
			
			System.out.println("Insert into profesor, nombre: "+nombre+", sexo: "+sexo);
						
			
			
			
		 }catch (Exception e) {

				System.out.println("Problema al insertar un profesor");

				}}
	
		
		
		
		
		
			
		public static void insertarAlumno(Alumno alumno,Session session) {
		
			
		
		try {
			
			
			
			session.beginTransaction();      //realizamos un procedimiento parecido a los anteriores pero al inicializar el objeto alumno fuera del procedimiento usamos setters para conseguir los atributos
			
			session.save(alumno);
			
			session.getTransaction().commit();
			
			System.out.println("Insert into alumno, nombre: "+alumno.getNombre()+",nacionalidad: "+alumno.getNacionalidad()+",edad: "+alumno.getEdad()+",sexo: "+alumno.getSexo()+",modulos: "+(alumno.getModulos()).size());
						
			
			
			
	    }catch (Exception e) {

			System.out.println("Problema al insertar un alumno");
			
			}}

		
		
	}




