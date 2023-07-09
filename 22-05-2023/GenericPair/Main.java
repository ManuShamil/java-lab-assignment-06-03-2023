package GenericPair;


class Pair<F, S> {
    F firstElement;
    S secondElement;

    Pair(F firstElement, S secondElement ) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public F getFirstElement() {
        return firstElement;
    }

    public S getSecondElement() {
        return secondElement;
    }

    public void setFirstElement(F first) {
        this.firstElement = first;
    }

    public void setSecondElement(S second) {
        this.secondElement = second;
    }

    @Override
    public String toString() {
        return "<" + firstElement + ", " + secondElement + ">";
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> myPair = new Pair<>(1, "Manu Shamil");
        System.out.println( myPair );
    }
}
