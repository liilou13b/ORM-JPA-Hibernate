package Dao;

import entity.Produit;

import javax.persistence.*;
import java.util.List;

/**
 * @author  AliBouchatba
 *
 */
public class ProduitDao implements IProduitDao {

    /* Entity Manager Pour gérer les entites */
    private EntityManager entityManager;

    public ProduitDao() {


        /* creation de l'objet Entity Manager  Utilisation Class JPAUtil */
        this.entityManager=JPAUtil.getEntityManager();
    }

    @Override
    public Boolean save(Produit p) {
        boolean succ=false;
        //********** Creation d'une Transaction */
        EntityTransaction transaction = this.entityManager.getTransaction();


        try {

                  //Demarer la Transaction
                transaction.begin();

                this.entityManager.persist(p);  // Traitement

                /* valider la Transaction*/
                transaction.commit();
                succ=true;

        }catch (TransactionRequiredException e) {
            transaction.rollback();
            e.printStackTrace();
            return succ;
        }
        return  succ;
    }
    @Override
    public List<Produit> findAll() {
        /* Creer une Query apartir de EntityMager  utilisation Du Langage HQL( Relation Entre Les class) */
        // Hibernate traduit le HQL en SQL -> Garantir Portabile par rapport au SGBD
        Query query=this.entityManager.createQuery("select p from entity.Produit p");
        return query.getResultList();
    }
    @Override
    public List<Produit> findByDesignation(String mc) {
        Query query= this.entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter("x","%"+mc+"%");
        return query.getResultList();
    }
    @Override
    public Produit findById(Long ref) {
       Produit produit = this.entityManager.find(Produit.class,ref);
       return produit;
    }
    @Override
    public Boolean update(Produit p) {
        Boolean succ=false;
        EntityTransaction transaction =this.entityManager.getTransaction();



        try {
                transaction.begin();

                this.entityManager.merge(p);

                transaction.commit();
                succ=true;

        }
        catch (Exception e) {

            e.printStackTrace();
            transaction.rollback();
            return succ;
        }
        return succ;
    }
    @Override
    public Boolean delete(Long ref) {
        boolean succ=false;
        EntityTransaction transaction = this.entityManager.getTransaction();
       Produit p = this.findById(ref);
       if (p!=null) {
           try {
               transaction.begin();

               this.entityManager.remove(p);

               transaction.commit();
               succ=true;
           }
           catch (Exception e){
               e.printStackTrace();
               transaction.rollback();
               return succ;
           }

       }
       return succ;


    }
}
