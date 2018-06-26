import java.io.Serializable;

public class Movie implements Serializable {
    private Integer mRating;
    private String mTitle;


    public Movie(Integer rating, String title){
        setRating(rating);
        setTitle(title);
    }
    public Integer getRating() {
        return mRating;
    }

    public void setRating(Integer rating) {
        mRating = rating;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
