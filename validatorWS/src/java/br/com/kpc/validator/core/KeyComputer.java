/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.core;

import java.io.Serializable;
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

/**
 *
 * @author Dino
 */
@Entity
@Table(name = "keys_Computers")
public class KeyComputer implements Serializable {

    private static final long serialVersionUID = 1L;

    public KeyComputer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codKey", nullable = false)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false, referencedColumnName = "codComputer")
    private Computer computer;

    @Column(nullable = false, unique = true, length = 128)
    private String computerKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerKey() {
        return computerKey;
    }

    public void setComputerKey(String computerKey) {
        this.computerKey = computerKey;
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
        if (!(object instanceof KeyComputer)) {
            return false;
        }
        KeyComputer other = (KeyComputer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.validator.core.Key[ id=" + id + " ]";
    }

}
