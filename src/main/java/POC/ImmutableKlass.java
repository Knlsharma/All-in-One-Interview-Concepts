package POC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Kunal Sharma at 09/05/22 2:45 PM
 */

final class ImmutableKlass {
    private int id;
    private final  List<String> list;

    public ImmutableKlass(int id, List<String> list) {
        this.id = id;
//        this.list = Collections.unmodifiableList(new ArrayList<>(list));
        this.list = new ArrayList<>(list); // both work same
    }

    public int getId() {
        return id;
    }

    public List<String> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ImmutableKlass.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("list=" + list)
                .toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("raj");
        ImmutableKlass klass = new ImmutableKlass(1, list);
        System.out.println(klass.toString());
        list.add("kunal");
        System.out.println(klass.toString());


    }
}
