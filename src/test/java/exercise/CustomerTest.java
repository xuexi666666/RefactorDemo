package exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rentalstore.Customer;
import rentalstore.Movie;
import rentalstore.RegularStrategy;
import rentalstore.Rental;

import static org.junit.Assert.assertEquals;

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
        Rental rental = new Rental(movie,3);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_one_childrens_rental_dayrented_more_than_3(){
        //given
        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t3.0\n"+
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        Movie movie = new Movie("卧虎藏龙",2);
        Rental rental = new Rental(movie,4);
        customer.addRental(rental);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_two_rental(){
        //given

        String printForm = "Rental Record for Jack\n"+"\t卧虎藏龙\t3.0\n"+"\t变形金刚\t12.0\n"+
                "Amount owed is 15.0\n"+
                "You earned 3 frequent renter points";
        Movie movie1 = new Movie("卧虎藏龙",2);
        Rental rental1 = new Rental(movie1,4);
        Movie movie2 = new Movie("变形金刚",1);
        Rental rental2 = new Rental(movie2,4);
        customer.addRental(rental1);
        customer.addRental(rental2);
        //when
        String result = customer.statement();
        //
        Assert.assertEquals(printForm,result);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("卧虎藏龙", 2);
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jack</EM></H1><P>\n" +
                "卧虎藏龙: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_regularstrategy_given_movie_regular_code() {
        //given
        Movie movie= new Movie("卧虎藏龙", 0);
        RegularStrategy regularStrategy = new RegularStrategy(0);
        //when
        movie.setPriceCode(0);
        RegularStrategy res = (RegularStrategy) movie.getPriceStrategy();
        //then
        Assert.assertEquals(res,regularStrategy);
    }
}
