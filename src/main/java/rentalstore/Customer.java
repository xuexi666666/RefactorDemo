package rentalstore;

import java.util.ArrayList;
import java.util.Enumeration;
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
        return new TextStatement().statement(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().statement(this);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public double getTotalAmount() {
        return rentals.stream().mapToDouble(Rental::getAmount).sum();
    }

    public int getTotalRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }



}
