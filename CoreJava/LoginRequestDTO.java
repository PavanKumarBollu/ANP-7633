
public class LoginRequestDTO {

    String userName = "";
    String password = "";

    public LoginRequestDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static void main(String[] args) {
        LoginRequestDTO user1 = new LoginRequestDTO("Pavan", "12345");
        System.out.println(user1.userName);//Pavan
        System.out.println(user1.password);//12345

        LoginRequestDTO user2 = new LoginRequestDTO("Rohit", "45");
        System.out.println(user2.userName);// rohit
        System.out.println(user2.password); // 45
    }

}
