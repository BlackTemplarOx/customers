package org.app.banco.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    private String name;

    @Column(name = "paternal_lastname")
    private String paternalLastname;

    @Column(name = "maternal_lastname")
    private String maternalLastname;

    @Column(unique = true)
    private String curp;

    @Column(unique = true)
    private String rfc;

    @Column(unique = true)
    private String nss;

    @Column(name = "is_avaible")
    private Boolean isAvaible;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Phone> phones;

    public Client(){}

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaternalLastname() {
        return paternalLastname;
    }

    public void setPaternalLastname(String paternalLastname) {
        this.paternalLastname = paternalLastname;
    }

    public String getMaternalLastname() {
        return maternalLastname;
    }

    public void setMaternalLastname(String maternalLastname) {
        this.maternalLastname = maternalLastname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Boolean getAvaible() {
        return isAvaible;
    }

    public void setAvaible(Boolean avaible) {
        isAvaible = avaible;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
