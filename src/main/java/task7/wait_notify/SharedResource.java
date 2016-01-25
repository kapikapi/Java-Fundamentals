package task7.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elizaveta Kapitonova on 24.01.16.
 */
public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
