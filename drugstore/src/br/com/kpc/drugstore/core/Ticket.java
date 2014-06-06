/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pcego
 */
@Entity()
@Table(name = "tickets")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ticket() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dt_shop;

    public Date getDt_shop() {
        return dt_shop;
    }

    public void setDt_shop(Date dt_shop) {
        this.dt_shop = dt_shop;
    }

    @Column(nullable = false)
    private String auth_number;

    public String getAuth_number() {
        return auth_number;
    }

    public void setAuth_number(String auth_number) {
        this.auth_number = auth_number;
    }

    @Column(nullable = false)
    private String ticket_number;

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
    }

    @Column()
    private String ticket_image;

    public String getTicket_image() {
        return ticket_image;
    }

    public void setTicket_image(String ticket_image) {
        this.ticket_image = ticket_image;
    }
    
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "recipeId", nullable = false)
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.drugstore.core.Ticket[ id=" + id + " ]";
    }

}
