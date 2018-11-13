package entity;

import exceptions.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Facade implements FacadeInterface {

    private EntityManagerFactory factory;
    
    public Facade(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Facade() {
    }
    
    private static final Facade instance = new Facade();
    
    
    public static Facade getInstance(){
        return instance;
    }
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory factory) 
    {
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() 
    {
        return factory.createEntityManager();
    }
    
    public User createUser(User user) 
    {
        EntityManager manager = getEntityManager();
        System.out.println("Before try");
        try
        {
            System.out.println("In try");
            manager.getTransaction().begin();
            manager.persist(user);
            System.out.println("After persist " + user);
            manager.getTransaction().commit();
            return user;
        }
        finally
        {
            manager.close();
        }
    }
    
    public User findUser(int id) {
        EntityManager manager = getEntityManager();
        
        User u = null;
        
        try
        {
            manager.getTransaction().begin();
            u = manager.find(User.class, id);
            manager.getTransaction().commit();
            return u;
        }
        finally
        {
            manager.close();
        }
    }
    
    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager manager = factory.createEntityManager();
        User user;
        try {
            user = manager.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            manager.close();
        }
        return user;
    }
    
}
