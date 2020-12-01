import Dao.IProduitDao;
import Dao.ProduitDao;
import entity.Produit;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * Tester Les Fonctionalité de La classe ProduitDao
         */

       IProduitDao iProduitDao= new ProduitDao();

        Produit p1=new Produit("HP Compac",5_000d,50);
        Produit p2=new Produit("toshiba",8_000d,40);
        Produit p3=new Produit("HP paviilon",4_000d,10);
        Produit p4=new Produit("Asus",5_000d,30);

        Produit p = new Produit("Toshiba",5_000d,30);

        //******* Enregistrer des Produits
        iProduitDao.save(p1);
        iProduitDao.save(p2);
        iProduitDao.save(p3);
        iProduitDao.save(p4);
        iProduitDao.save(p);

        p.setDesignation("Test");

        //******* Modification des Produits
        System.out.println("consulter Produit anvant la modification du Produit");
        System.out.println(iProduitDao.findById(p.getReference()));

       if(iProduitDao.update(p)) System.out.println("bien Modifier");
        System.out.println("consulter Produit apres la modification du produit");
        System.out.println(iProduitDao.findById(p.getReference()));

        System.out.println("Suppersion ");
        System.out.println("Bien supprimer"+iProduitDao.delete(p.getReference()));
        System.out.println("Ref Exsit Pas "+iProduitDao.delete(99L));

        //****** La liste des Produits
        List<Produit> list =  new ArrayList<>(iProduitDao.findAll());
        list.forEach(System.out::println);

        //****** La Liste des Produits avec Designation Contains "HP"
       List<Produit> produits= new ArrayList<>(iProduitDao.findByDesignation("HP"));
        produits.forEach(System.out::println);


    }
}
