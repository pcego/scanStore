/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pcego
 */
@Entity()
@Table(name = "companys")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    public Company() {

    }

    public Company(Long id, String company_name, String cnpj) {
        this.id = id;
        this.company_name = company_name;
        this.cnpj = cnpj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyId", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 200, nullable = false)
    private String company_name;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @Column(length = 200, nullable = false)
    private String fantasy;

    public String getFantasy() {
        return fantasy;
    }

    public void setFantasy(String fantasy) {
        this.fantasy = fantasy;
    }

    @Column(length = 20, nullable = false, unique = true)
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(length = 20, nullable = false)
    private String insc_stat;

    public String getInsc_stat() {
        return insc_stat;
    }

    public void setInsc_stat(String insc_stat) {
        this.insc_stat = insc_stat;
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
    private String cell_phone1;

    public String getCell_phone1() {
        return cell_phone1;
    }

    public void setCell_phone1(String cell_phone1) {
        this.cell_phone1 = cell_phone1;
    }

    @Column(length = 25)
    private String cell_phone2;

    public String getCell_phone2() {
        return cell_phone2;
    }

    public void setCell_phone2(String cell_phone2) {
        this.cell_phone2 = cell_phone2;
    }

    @Column(length = 100)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, length = 128)
    private String System_key;

    public String getSystem_key() {
        return System_key;
    }

    public void setSystem_key(String System_key) {
        this.System_key = System_key;
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

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Client> client;

    public void addClient(Client cli) {
        client.add(cli);
    }

    public List<Client> getClient() {
        return client;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.kpc.drugstore.core.Company[ id=" + id + " ]";
    }
}
