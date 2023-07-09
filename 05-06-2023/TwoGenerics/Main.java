package TwoGenerics;

class GenericClass<K,V> {
    private K key;
    private V value;

    public GenericClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    
    public K getKey() { return key; }
    public V getValue() { return value; }

    public String toString() {
        return "Key: " + key + ", Value: " + value;
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<String, Double> twoGenerics = new GenericClass<>("OpenAI", 3.14);
        System.out.println(twoGenerics);
    }
}