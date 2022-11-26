package vidovic.recycleview;

import java.util.Date;
import java.util.List;

public class Odgovor {
    private String kljuc;
    private Date vrijeme;
    private Boolean greska;
    private List<Osoba> osobe;

    public Odgovor() {
    }

    public Odgovor(String kljuc, Date vrijeme, Boolean greska, List<Osoba> osobe) {
        this.kljuc = kljuc;
        this.vrijeme = vrijeme;
        this.greska = greska;
        this.osobe = osobe;
    }

    public String getKljuc() {
        return kljuc;
    }

    public void setKljuc(String kljuc) {
        this.kljuc = kljuc;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Boolean getGreska() {
        return greska;
    }

    public void setGreska(Boolean greska) {
        this.greska = greska;
    }

    public List<Osoba> getOsobe() {
        return osobe;
    }

    public void setOsobe(List<Osoba> osobe) {
        this.osobe = osobe;
    }
}
