package rentalstore;

public abstract class Statement {
    public String statement(Customer customer){
        StringBuilder result = getHeader(customer);
        for (Rental rental:customer.getRentals()) {
            result.append(getEachLine(rental));
        }
        result.append(getFooter(customer));
        return result.toString();
    }

    protected abstract String getFooter(Customer customer);

    protected abstract String getEachLine(Rental Rental);

    protected abstract StringBuilder getHeader(Customer customer);
}
