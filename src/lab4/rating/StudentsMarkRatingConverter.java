package lab4.rating;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;


public class StudentsMarkRatingConverter implements StudentsRatingConverter {
    private char getMark(int rating){
        if (rating >= 0 && rating < 60){
            return 'F';
        }
        if (rating >= 60 && rating < 65){
            return 'E';
        }
        if (rating >= 65 && rating < 75){
            return 'D';
        }
        if (rating >= 75 && rating < 85){
            return 'C';
        }
        if (rating >= 85 && rating < 95){
            return 'B';
        }
        else {
            return 'A';
        }
    }

    @Override
    public HashMap covertRatingTable(@NotNull HashMap<String, Integer> ratingTable) {
        HashMap studentMarksTable = new HashMap<String, Character>();
        for(Map.Entry<String, Integer> pair: ratingTable.entrySet()){
            studentMarksTable.put(pair, getMark(pair.getValue()));
        }
        return studentMarksTable;
    }
}
