package rentalstore;

public class HtmlStatement extends Statement {
    public String getFooter(Customer customer) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("<P>You owe<EM>%s</EM><P>\n" ,String.valueOf(customer.getTotalAmount())));
        result.append(String.format("On this rental you earned <EM>%s</EM> frequent renter points<P>",String.valueOf(customer.getTotalRenterPoints())));
        return result.toString();
    }

    public String getEachLine(Rental each) {
        return String.format("%s: %s<BR>\n",each.getMovie().getTitle(),String.valueOf(each.getAmount()));
    }

    public StringBuilder getHeader(Customer customer) {
        return new StringBuilder(String.format("<H1>Rentals for <EM>%s</EM></H1><P>\n",customer.getName()));
    }
}
