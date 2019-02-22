package lab4.rating;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;


public class StudentsPassesRatingConverter implements StudentsRatingConverter {
    @Override
    public HashMap covertRatingTable(@NotNull HashMap<String, Integer> ratingTable) {
        HashMap studentPassesTable = new HashMap<String, Boolean>();
        for(Map.Entry<String, Integer> pair: ratingTable.entrySet()){
            studentPassesTable.put(pair, pair.getValue() >= 60);
        }
        return studentPassesTable;
    }
}
