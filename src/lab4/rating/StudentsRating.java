package lab4.rating;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public class StudentsRating {
    private HashMap<String, Integer> ratingTable;
    private StudentsRatingConverter ratingConverter;

    public void setRatingConverter(@NotNull StudentsRatingConverter ratingConverter) {
        this.ratingConverter = ratingConverter;
    }

    public StudentsRating(@NotNull HashMap<String, Integer> ratingTable){
        this.ratingTable = ratingTable;
    }

    public void setRatingTable(@NotNull HashMap<String, Integer> ratingTable){
        this.ratingTable = ratingTable;
    }

    public HashMap getConvertedRating(){
        if (ratingTable == null){
            return null;
        }

        return ratingConverter.covertRatingTable(ratingTable);
    }
}
