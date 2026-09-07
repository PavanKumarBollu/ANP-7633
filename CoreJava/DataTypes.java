
public class DataTypes {

    public static void main(String[] args) {
        //declare integer and floating point variables

        // byte stockCount = 128;
        // short stockCount = 128802348;
        int stockCount = 128802348;
        System.out.println("Stock Count: " + stockCount);

        stockCount = 12;
        System.out.println("Updated Stock Count: " + stockCount);
        // float itemPrice = 12.99F;
        double itemPrice = 12.99;
        System.out.println("Item Price: " + itemPrice);

        // char currenySymbol = '$';
        char currenySymbol = '@';
        System.out.println("Currency Symbol: " + currenySymbol);

        // boolean isAvailable = true;
        boolean isAvailable = false;
        System.out.println("Is Available: " + isAvailable);

        final int productId = 5;
        System.out.println("Product ID: " + productId);
        // productId = 10; // This will cause a compilation error since productId is final
    }
}
