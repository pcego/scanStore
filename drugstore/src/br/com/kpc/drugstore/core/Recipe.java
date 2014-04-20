/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pcego
 */
@Entity()
@Table(name = "recipes")
public class Recipe implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Recipe(){
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeId")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dt_recipe;
    
    public Date getDt_recipe() {
        return dt_recipe;
    }

    public void setDt_recipe(Date dt_recipe) {
        this.dt_recipe = dt_recipe;
    }
    
    @Column
    private String recipe_image;    
       
    @Column(nullable = false)
    private boolean recipe_type;

    public boolean isRecipe_type() {
        return recipe_type;
    }

    public void setRecipe_type(boolean recipe_type) {
        this.recipe_type = recipe_type;
    }
            
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "clientId")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    @OneToMany(mappedBy = "recipe")
    private List<Ticket> ticket;
            
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.drugstore.core.Recipe[ id=" + id + " ]";
    }
    
}
