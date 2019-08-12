package rentalstore;

public class TextStatement extends Statement {
    public String getFooter(Customer customer) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Amount owed is %.1f\n" ,customer.getTotalAmount()));
        result.append(String.format("You earned %d frequent renter points",customer.getTotalRenterPoints()));
        return result.toString();
    }

    public String getEachLine(Rental each) {
        return String.format("\t%s\t%.1f\n",each.getMovie().getTitle(),each.getAmount());
    }

    public StringBuilder getHeader(Customer customer) {
        return new StringBuilder(String.format("Rental Record for %s\n",customer.getName()));
    }
}
