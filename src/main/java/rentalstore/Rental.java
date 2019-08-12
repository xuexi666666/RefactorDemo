package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;
    private double amount;
    private int frequentRenterPoints;

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
        return getThisAmount(this);
    }

    public int getFrequentRenterPoints() {
        boolean is_new_release_movie = getMovie().getPriceCode() == Movie.NEW_RELEASE;
        boolean day_more_than_1 = getDayRented() > 1;
        return is_new_release_movie&&day_more_than_1?2:1;
    }

    private double getThisAmount(Rental each) {
        int selectMovie = each.getMovie().getPriceCode();
        return selectMovie==Movie.REGULAR?
                getRegularAmount(each):
                (selectMovie==Movie.NEW_RELEASE?getNewReleAseAmount(each):getChildrensAmount(each));
    }

    private double getChildrensAmount(Rental each) {
        boolean day_more_than_3 = each.getDayRented() > 3;
        return day_more_than_3?(each.getDayRented() - 3) * 1.5+1.5:1.5;
    }

    private double getNewReleAseAmount(Rental each) {
        return each.getDayRented()* 3;
    }

    private double getRegularAmount(Rental each) {
        boolean day_more_than_2 = each.getDayRented() > 2;
        return day_more_than_2?(each.getDayRented() - 2) * 1.5+2:2;
    }
}
