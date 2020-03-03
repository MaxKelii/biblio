package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoLivre {

	private EntityManager mgr;

    public DaoLivre()
    {
        EntityManagerFactory usine = Persistence.createEntityManagerFactory("entity",null);
        mgr= usine.createEntityManager();
    }

    public List<Livre> selectAll()
    {
        TypedQuery<Livre> requete = mgr.createQuery("SELECT t FROM 	Livre t ORDER BY t.num",Livre.class);
        List<Livre>liste = requete.getResultList();
        return liste;
    }

    public void ajouter(Livre livre)
    {
        mgr.getTransaction().begin();
        mgr.persist(livre);
        mgr.getTransaction().commit();
    }

    public void delete(Livre livre )
    {
    	int id =livre.getNum();
    	mgr.getTransaction().begin();
    	Livre livretoremove=mgr.find(Livre.class, id);
    	mgr.remove(livretoremove);
    	mgr.getTransaction().commit();
    }

}
