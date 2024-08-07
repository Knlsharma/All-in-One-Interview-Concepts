package Java_Concept.generics;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class PairPrint<K, V> {
    private K key;
    private V value;

    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public PairPrint() {

    }

    public static void main(String[] args) {
        PairPrint<String, Integer> pairPrint = new PairPrint<>();
        pairPrint.put("kunal",1);




    }
}
