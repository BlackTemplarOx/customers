package org.app.banco.models.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientRequest {

    @NotBlank(message = "The name is required.")
    private String name;

    @NotBlank(message = "The paternal lastname is required.")
    private String paternalLastname;

    @NotBlank(message = "The maternal lastname is required.")
    private String maternalLastname;

    @Size(max = 18, min = 18, message = "The CURP not is valid.")
    @NotBlank(message = "The curp is required.")
    private String curp;

    @Size(max = 14, min = 12, message = "The RFC is not valid.")
    @NotBlank(message = "The RFC is required.")
    private String rfc;

    @Size(max = 14, min = 11, message = "The NSS is not valid.")
    @NotBlank(message = "The NSS is required.")
    private String nss;

    public ClientRequest(){}

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
}
