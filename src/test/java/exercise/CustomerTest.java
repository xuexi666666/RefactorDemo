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

    @Test
    public void should_return_correct_statement_given_customer_has_one_rental_dayrented_more_than_2(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t3.5\n"+
                "Amount owed is 3.5\n"+
                "You earned 1 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",0);
        Rental rental = new Rental(movie,3);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_one_new_release_rental(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t3.0\n"+
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",1);
        Rental rental = new Rental(movie,1);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_one_new_release_rental_dayrented_more_than_1(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t6.0\n"+
                "Amount owed is 6.0\n"+
                "You earned 2 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",1);
        Rental rental = new Rental(movie,2);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_one_childrens_rental(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t1.5\n"+
                "Amount owed is 1.5\n"+
                "You earned 1 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",2);
        Rental rental = new Rental(movie,2);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }
}
