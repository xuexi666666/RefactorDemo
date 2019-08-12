package exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rentalstore.Customer;
import rentalstore.Movie;
import rentalstore.Rental;

public class CustomerTest {


    Customer customer;

    @Before
    public void init(){
        customer = new Customer("Jack");
    }

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

    @Test
    public void should_return_correct_statement_given_customer_has_one_rental(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t2.0\n"+
                "Amount owed is 2.0\n"+
                "You earned 1 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",0);
        Rental rental = new Rental(movie,1);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }
}
