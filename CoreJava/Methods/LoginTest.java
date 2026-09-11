package Methods;

public class LoginTest {

    public static void main(String[] args) {
        Login user1 = new Login("Pavan", "1234");
        String result = user1.checkLogin();
        System.out.println(result);
        
        
        Login user2 = new Login("Rohit", "45");
        System.out.println(user2.checkLogin());
      
    }
}
