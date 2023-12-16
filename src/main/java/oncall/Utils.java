package oncall;

import java.util.List;

public class Utils {
    public static void switchList(List<String> list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size()) {
            throw new IllegalArgumentException("유효하지 않은 인덱스입니다.");
        }
        String temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
