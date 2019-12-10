import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.*;

public class Game {
    Map createdFields = new HashMap<String, Field>();

    public Game() {
        Player player1 = new Player("Spieler 1", Sign.cross);
        Player player2 = new Player("Spieler 2", Sign.circle);
        generateFields();
    }

    public final Map<Character, List> generateFields(){
        Map cols = new HashMap<Character, List>();
        for(char alphabet = 'a'; alphabet <='c'; alphabet++ ) {
            cols.put(alphabet,generateRows(alphabet));
        }
        return cols;
    }

    public final List<Field> generateRows(char col){
        List rows = new ArrayList<Field>();
        for (int j = 0; j <= 2; j++) {
            String fieldName = String.valueOf(col) + j;
            Field field = new Field(fieldName);
            rows.add(field);
            createdFields.put(fieldName, field);
            createdFields.put(field.id, field);
        }
        return rows;
    }

    public final void checkField(String id) {
        Field field = new Field(id);
        Object test = createdFields.get(id);
        field.setOccupied(true);
    }

    public final char setSign(char sign) {
        return sign;
    }


}