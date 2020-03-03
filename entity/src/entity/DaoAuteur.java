package entity;



import javax.persistence.*;
import java.util.List;

public class DaoAuteur {
	private EntityManager mgr;

    public DaoAuteur()
    {
        EntityManagerFactory usine = Persistence.createEntityManagerFactory("entity",null);
        mgr= usine.createEntityManager();

    }

    public List<Auteur> selectAll()
    {
        TypedQuery<Auteur> requete = mgr.createQuery("SELECT g FROM Auteur g ORDER BY g.num ",Auteur.class);
        List<Auteur> liste = requete.getResultList();
        return liste;
    }

    public void aujoute(Auteur auteur)
    {
        mgr.getTransaction().begin();
        mgr.persist(auteur);
        mgr.getTransaction().commit();
    }

    public void delete(Auteur auteur)
    {
        mgr.getTransaction().begin();
        mgr.remove(auteur);
        mgr.getTransaction().commit();
    }
    
    public void update(Auteur auteur)
    {
    	mgr.getTransaction().begin();
    	mgr.refresh(auteur);
    	mgr.getTransaction().commit();
    }


}
