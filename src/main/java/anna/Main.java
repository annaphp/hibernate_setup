package anna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import anna.model.Shoe;

public class Main {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	public static long save(Shoe shoe){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		long id = (Long) s.save(shoe);
		s.getTransaction().commit();
		s.close();	
		return id;
	}
	
	
	  public static void update(Shoe shoe) {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.update(shoe);
	        session.getTransaction().commit();
	        session.close();
	}
	
     public static Shoe findShoeById(long id) {
        Session session = sessionFactory.openSession();
        Shoe shoe = session.get(Shoe.class,id);
        session.close();
        return shoe;
}
	
	public static void main(String[] args) {
	
		Shoe shoe = new Shoe("White", 34);
	    long id = (long)save(shoe);
	    System.out.println(id);
	    Shoe sh = findShoeById(id);
	    System.out.println(sh);
	    sh.setColor("pink");
	    update(sh);
	    Shoe afterUpdate = findShoeById(id);
	    System.out.println(afterUpdate);
		

		
	 
		

	}

}
