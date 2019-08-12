package rentalstore;

public abstract class PriceStrategy {
    public abstract int getPriceCode();
    public abstract double getAmount(int dayRented);
}
