package GenericFurniture;

class Material {
    public static float PRICE = 0f;

    public static float getPrice() {
        return PRICE;
    }
}

class Wood extends Material {
    public static float PRICE = 500f;


    public static float getPrice() {
        return Wood.PRICE;
    }
}

class Steel extends Material {
    public static float PRICE = 1000f;

    public static float getPrice() {
        return Steel.PRICE;
    }
}
+






















class Furniture<T extends Material>
{
    public float getPrice() {
        return T.getPrice();
    }
}

public class Main {
    public static void main(String[] args) {
        Furniture<Wood> woodFurniture = new Furniture<>();  
        System.out.println( woodFurniture.getPrice() );
    }
}
