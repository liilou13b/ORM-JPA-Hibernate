package Dao;

import java.util.List;

/**
 * @author AliBouchatba
 * Interface IDao Interface generique (Centralisé nous contrat
 *                       des methode classique qui permet de gerer les entités
 *
 */

public interface IDao<T,I> {

    /**
     *
     * @param t     l'obejt de  l'entité T (table T) à enregister
     *  @return    true cas succès
     *            false échec
     */
    Boolean save(T t);

    /**
     *
     * @return  La liste des objets de l'entité T  (table T)
     */
    List<T> findAll();

    /**
     *
     * @param id  ID  de l'entité T (table T)
     * @return  objet de entité T cas succès
     *          null cas échec
     */
    T findById(I id);

    /**
     *
     * @param t objet de l'entité (table T )à modifier
     * @return true cas succès
     *         false cas échec
     */
    Boolean update(T t);

    /**
     *
     * @param id  de l'entité T  modifier
     * @return true cas succès
     *         false cas échec
     */
    Boolean delete(I id);

}
