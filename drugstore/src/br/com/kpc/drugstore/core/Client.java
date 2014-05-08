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
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    public Client() {

    }

    public Client(String cpf, String name, String street) {

        this.cpf = cpf;
        this.name = name;
        this.adress_street = street;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "clientId")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 200)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 25)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(length = 25, nullable = false)
    private String cellPhone_1;

    public String getCellPhone_1() {
        return cellPhone_1;
    }

    public void setCellPhone_1(String cellPhone_1) {
        this.cellPhone_1 = cellPhone_1;
    }

    @Column()
    private String cellPhone_2;

    public String getCellPhone_2() {
        return cellPhone_2;
    }

    public void setCellPhone_2(String cellPhone_2) {
        this.cellPhone_2 = cellPhone_2;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_nasc;

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    @Column(unique = true, length = 15)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column()
    private String rg;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Column(length = 200)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dt_cad;

    public Date getDt_cad() {
        return dt_cad;
    }

    public void setDt_cad(Date dt_cad) {
        this.dt_cad = dt_cad;
    }

    @Column(length = 150)
    private String adress_street;

    public String getAdress_street() {
        return adress_street;
    }

    public void setAdress_street(String adress_street) {
        this.adress_street = adress_street;
    }

    @Column(length = 150)
    private String adress_neighborhood;

    public String getAdress_neighborhood() {
        return adress_neighborhood;
    }

    public void setAdress_neighborhood(String adress_neighborhood) {
        this.adress_neighborhood = adress_neighborhood;
    }

    @Column(length = 150, nullable = false)
    private String adress_city;

    public String getAdress_city() {
        return adress_city;
    }

    public void setAdress_city(String adress_city) {
        this.adress_city = adress_city;
    }

    @Column(length = 3, nullable = false)
    private String end_stat;

    public String getEnd_stat() {
        return end_stat;
    }

    public void setEnd_stat(String end_stat) {
        this.end_stat = end_stat;
    }

    @Column()
    private int adress_number;

    public int getAdress_number() {
        return adress_number;
    }

    public void setAdress_number(int adress_number) {
        this.adress_number = adress_number;
    }

    @Column(length = 100)
    private String adress_complement;

    public String getAdress_complement() {
        return adress_complement;
    }

    public void setAdress_complement(String adress_complement) {
        this.adress_complement = adress_complement;
    }

    @Column(nullable = false, length = 10)
    private String adress_postalCode;

    public String getAdress_postalCode() {
        return adress_postalCode;
    }

    public void setAdress_postalCode(String adress_postalCode) {
        this.adress_postalCode = adress_postalCode;
    }

    @Column(nullable = false)
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column()
    private String rg_image;

    public String getRg_image() {
        return rg_image;
    }

    public void setRg_image(String rg_image) {
        this.rg_image = rg_image;
    }

    @Column()
    private String cpf_image;

    public String getCpf_image() {
        return cpf_image;
    }

    public void setCpf_image(String cpf_image) {
        this.cpf_image = cpf_image;
    }

    @Column()
    private String nasc_certificate;

    public String getNasc_certificate() {
        return nasc_certificate;
    }

    public void setNasc_certificate(String nasc_certificate) {
        this.nasc_certificate = nasc_certificate;
    }

    @Column()
    private String other_document;

    public String getOther_document() {
        return other_document;
    }

    public void setOther_document(String other_document) {
        this.other_document = other_document;
    }

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, referencedColumnName = "companyId")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Recipe> recipe;

    @Column()
    private String marital_status;

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    @Column()
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.drugstore.core.Client[ id=" + id + " ]";
    }

}
