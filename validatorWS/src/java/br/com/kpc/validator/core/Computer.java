/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.core;

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
 * @author pcego
 */
@Entity
@Table(name = "computers")
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;

    public Computer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codComputer")
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateInstalation;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateExpire;

    @Column(nullable = false)
    private boolean ctrPay;

    @Column(nullable = false, unique = true)
    private String hdNumber;

    @Column(nullable = false, unique = true)
    private String mBoardNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false, referencedColumnName = "codClient")
    private ClientKpc client;

    @OneToMany(mappedBy = "computer", fetch = FetchType.EAGER)
    private List<KeyComputer> key;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateInstalation() {
        return dateInstalation;
    }

    public void setDateInstalation(Date dateInstalation) {
        this.dateInstalation = dateInstalation;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public boolean isCtrPay() {
        return ctrPay;
    }

    public void setCtrPay(boolean ctrPay) {
        this.ctrPay = ctrPay;
    }

    public String getHdNumber() {
        return hdNumber;
    }

    public void setHdNumber(String hdNumber) {
        this.hdNumber = hdNumber;
    }

    public String getmBoardNumber() {
        return mBoardNumber;
    }

    public void setmBoardNumber(String mBoardNumber) {
        this.mBoardNumber = mBoardNumber;
    }

    public ClientKpc getClient() {
        return client;
    }

    public void setClient(ClientKpc client) {
        this.client = client;
    }

    public List<KeyComputer> getKey() {
        return key;
    }

    public void setKeyId(List<KeyComputer> key) {
        this.key = key;
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
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.validator.core.Computer[ id=" + id + " ]";
    }

}
