package prog3.jdbc.Metzgerei;

/**
 * Created by MichaelDick on 29/10/15.
 */
public class Wurst {

    private int plu;

    private String articleName;

    private double stockKg;

    private double pricePerKg;

    //Constructors


    public Wurst() {
    }

    public Wurst(String articleName, double stockKg, double pricePerKg) {
        this.articleName = articleName;
        this.stockKg = stockKg;
        this.pricePerKg = pricePerKg;
    }

    public Wurst(int plu, String articleName, double stockKg, double pricePerKg) {
        this.plu = plu;
        this.articleName = articleName;
        this.stockKg = stockKg;
        this.pricePerKg = pricePerKg;
    }

    //Getter and Setter


    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public double getStockKg() {
        return stockKg;
    }

    public void setStockKg(double stockKg) {
        this.stockKg = stockKg;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "Wurst{" +
                "plu=" + plu +
                ", articleName='" + articleName + '\'' +
                ", stockKg=" + stockKg +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
