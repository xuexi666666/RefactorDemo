package exercise;

import org.junit.Assert;
import org.junit.Test;
import rentalstore.Customer;

public class CustomerTest {

    Customer customer = new Customer("Jack");
    @Test
    public void should_return_correct_statement_given_customer_has_no_rental(){
        //given
        String printForm = "Rental Record for Jack\n"+
                        "Amount owed is 0.0\n"+
                        "You earned 0 frequent renter points";
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }
}
