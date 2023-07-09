package GenericEqualTo;


public class Main {

    public static <T> boolean isEqualTo( T obj1, T obj2 ) {
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        System.out.println( isEqualTo( new Object(), new Object() ));
        Object sameObject = new Object();
        System.out.println( isEqualTo( sameObject, sameObject));
    }
}
