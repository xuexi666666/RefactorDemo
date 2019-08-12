package rentalstore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private PriceStrategy priceStrategy;
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return priceStrategy.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case Movie.REGULAR:
                this.priceStrategy = new RegularStrategy(priceCode);
                break;
            case Movie.CHILDRENS:
                this.priceStrategy = new ChildrensStrategy(priceCode);
                break;
            case Movie.NEW_RELEASE:
                this.priceStrategy = new NewReleaseStrategy(priceCode);
                break;
            default:
                throw new IllegalArgumentException("no supported priceCode");
        }
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public String getTitle() {
        return title;
    }
}
