package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class JPAUtil aparti en Creer EntittyManagerFactory
 *
 */
public class JPAUtil {
    //
    private static final EntityManagerFactory emFactory;
    //
    static {
        /* creation de l'objet Entity Manger Factory */
        emFactory = Persistence.createEntityManagerFactory("upBD");
    }

    /**
     *
     * @return  EntitityManger Creer  par emFactory
     */
    public static EntityManager getEntityManager(){
        /* creation de l'objet Entity Manager */
        return emFactory.createEntityManager();
    }
    public static void close(){
        emFactory.close();
    }
}
