package rentalstore;

import java.util.Objects;

public class ChildrensStrategy extends PriceStrategy {

    private int priceCode;
    public ChildrensStrategy(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public int getPriceCode() {
        return priceCode;
    }

    @Override
    public double getAmount(int dayRented) {
        boolean day_more_than_3 = dayRented > 3;
        return day_more_than_3?(dayRented - 3) * 1.5+1.5:1.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildrensStrategy)) return false;
        ChildrensStrategy that = (ChildrensStrategy) o;
        return getPriceCode() == that.getPriceCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPriceCode());
    }
}
