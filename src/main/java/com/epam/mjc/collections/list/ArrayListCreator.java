import java.util.ArrayList;
import java.util.List;

public class ArrayListCreator {
    public ArrayList<String> createArrayList(List<String> sourceList) {
        ArrayList<String> resultList = new ArrayList<>();
        
        // Итерируем по списку начиная с 0, но индексами, кратными 3
        for (int i = 2; i < sourceList.size(); i += 3) {
            String word = sourceList.get(i);
            resultList.add(word);
            resultList.add(word); // Добавляем слово дважды
        }
        
        return resultList;
    }
}
