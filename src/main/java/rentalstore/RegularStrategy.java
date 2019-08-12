package rentalstore;

import java.util.Objects;

public class RegularStrategy extends PriceStrategy {
    private int priceCode;
    public RegularStrategy(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int getPriceCode() {
        return priceCode;
    }
    @Override
    public double getAmount(int dayRented) {
        boolean day_more_than_2 = dayRented > 2;
        return day_more_than_2?(dayRented - 2) * 1.5+2:2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegularStrategy)) return false;
        RegularStrategy that = (RegularStrategy) o;
        return getPriceCode() == that.getPriceCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPriceCode());
    }
}
