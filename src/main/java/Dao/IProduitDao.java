package Dao;

import entity.Produit;

import java.util.List;

/**
 * @author AliBouchatba
 *  Inetrface IProduitDao extends de l'interface IDaoGénerique
 *                          pour hérité tout les methode classique qui permet de  gérer
 *                          L'entitte T Produit
 */
public interface IProduitDao extends IDao<Produit,Long>{

    //******** Les Methode suplementaire
    /**
     *
     * @param   designation Mot clé de designation
     * @return    list des produits
     */
    public List<Produit> findByDesignation(String designation);

}
