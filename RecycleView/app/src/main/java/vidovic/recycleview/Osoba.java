package vidovic.recycleview;

import java.io.Serializable;

public class Osoba implements Serializable {

    private int id;
    private String spol = "";
    private String ime;
    private String prezime;
    private String urlSlika;

    public Osoba() {
    }

    public Osoba(String ime, String prezime, String spol) {
        this.ime = ime;
        this.prezime = prezime;
        this.spol = spol;
    }

    public Osoba(int id, String ime, String prezime, String urlSlika) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.urlSlika = urlSlika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlSlika() {
        return urlSlika;
    }

    public void setUrlSlika(String urlSlika) {
        this.urlSlika = urlSlika;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
