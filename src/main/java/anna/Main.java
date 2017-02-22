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

	
	public static void main(String[] args) {
	
		Shoe shoe = new Shoe("White", 34);
		System.out.println(save(shoe));
		Shoe blue = new Shoe("Blue", 35);
		System.out.println(save(blue));

	}

}
