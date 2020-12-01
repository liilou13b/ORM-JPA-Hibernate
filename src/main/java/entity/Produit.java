package entity;

import javax.persistence.*;

/**
 * @author AliBouchatba
 *
 *   class Produit representer Entité Produit dans la BD
 */
@Entity
@Table(name = "Produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private Long reference;
    @Column(nullable = false)
    private String designation;
    private  Double prix;
    private  Integer quantite;


    public Produit( String designation, Double prix, Integer quantite) {

        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Produit() {
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + reference +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
