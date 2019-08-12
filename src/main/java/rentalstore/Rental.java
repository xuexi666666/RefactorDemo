package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getAmount() {
        return movie.getPriceStrategy().getAmount(dayRented);
    }

    public int getFrequentRenterPoints() {
        boolean is_new_release_movie = getMovie().getPriceCode() == Movie.NEW_RELEASE;
        boolean day_more_than_1 = dayRented > 1;
        return is_new_release_movie&&day_more_than_1?2:1;
    }
}
