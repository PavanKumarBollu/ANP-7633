
record Encapsulation(String accountName, int accountNo, int upiPIN, double balance) {

}

public class EncapsulationTest {

    public static void main(String[] args) {
        Encapsulation user1 = new Encapsulation("SBI", 12345, 1230, 1200000);
        // System.out.println(user1.getName());
        System.out.println(user1.accountName());
        System.out.println(user1.accountNo());

        // user1.setName("Union");
        // user1.accountName = "Union";
        // System.out.println(user1.getName());
        // System.out.println(user1.accountNo);
        // System.out.println(user1.upiPIN);
    }
}
