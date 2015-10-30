package prog3.jdbc.Metzgerei;

/**
 * Created by MichaelDick and Philipp Ratz on 29/10/15.
 */
public class Wurst {

    private int plu;

    private String bezeichnung;

    private double kilopreis;

    private double kilobestand;

    //Constructors

    public Wurst() {
    }

    public Wurst(String bezeichnung, double kilopreis, double kilobestand) {
        this.bezeichnung = bezeichnung;
        this.kilopreis = kilopreis;
        this.kilobestand = kilobestand;
    }

    public Wurst(int plu, String bezeichnung, double kilopreis, double kilobestand) {
        this.plu = plu;
        this.bezeichnung = bezeichnung;
        this.kilopreis = kilopreis;
        this.kilobestand = kilobestand;
    }

    //Getter and Setter


    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getKilopreis() {
        return kilopreis;
    }

    public void setKilopreis(double kilopreis) {
        this.kilopreis = kilopreis;
    }

    public double getKilobestand() {
        return kilobestand;
    }

    public void setKilobestand(double kilobestand) {
        this.kilobestand = kilobestand;
    }

    @Override
    public String toString() {
        return "Wurst{" +
                "plu=" + plu +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", kilopreis=" + kilopreis +
                ", kilobestand=" + kilobestand +
                '}';
    }
}
