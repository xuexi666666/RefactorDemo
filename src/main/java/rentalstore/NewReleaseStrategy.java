package rentalstore;

import java.util.Objects;

public class NewReleaseStrategy extends PriceStrategy {
    private int priceCode;
    public NewReleaseStrategy(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int getPriceCode() {
        return priceCode;
    }

    @Override
    public double getAmount(int dayRented) {
        return dayRented* 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewReleaseStrategy)) return false;
        NewReleaseStrategy that = (NewReleaseStrategy) o;
        return getPriceCode() == that.getPriceCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPriceCode());
    }
}
