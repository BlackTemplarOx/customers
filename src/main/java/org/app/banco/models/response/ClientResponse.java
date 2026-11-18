package org.app.banco.models.response;

public class ClientResponse {

    private String name;
    private String paternalLastname;
    private String maternalLastname;
    private String curp;
    private String rfc;
    private String nss;

    public ClientResponse(){}

    public ClientResponse(String name, String paternalLastname, String maternalLastname, String curp, String rfc, String nss){
        this.name = name;
        this.paternalLastname = paternalLastname;
        this.maternalLastname = maternalLastname;
        this.curp = curp;
        this.rfc = rfc;
        this.nss = nss;
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
}
