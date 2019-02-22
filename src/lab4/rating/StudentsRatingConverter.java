package lab4.rating;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public interface StudentsRatingConverter {
    HashMap covertRatingTable(@NotNull HashMap<String, Integer> ratingTable);
}
