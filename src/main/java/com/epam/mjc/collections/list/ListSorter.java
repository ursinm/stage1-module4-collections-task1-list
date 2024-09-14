import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {
        Collections.sort(sourceList, new ListComparator());
    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        // Преобразуем строки в целые числа
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        
        // Вычисляем значения функции 5x^2 + 3
        int funcA = 5 * numA * numA + 3;
        int funcB = 5 * numB * numB + 3;
        
        // Сравниваем значения функции
        if (funcA != funcB) {
            return Integer.compare(funcA, funcB);
        }
        
        // Если значения функции равны, сравниваем сами числа
        return Integer.compare(numA, numB);
    }
}
