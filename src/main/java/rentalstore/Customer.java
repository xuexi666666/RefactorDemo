package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder(String.format("Rental Record for %s\n",getName()));
        for (Rental each : this.rentals) {
            result.append(String.format("\t%s\t%.1f\n",each.getMovie().getTitle(),each.getAmount()));
        }
        result.append(String.format("Amount owed is %.1f\n" ,getTotalAmount()));
        result.append(String.format("You earned %d frequent renter points",getTotalRenterPoints()));
        return result.toString();
    }

    private double getTotalAmount() {
        return rentals.stream().mapToDouble(Rental::getAmount).sum();
    }

    private int getTotalRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }



}
