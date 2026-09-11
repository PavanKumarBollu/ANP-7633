package Methods;

public class Login {

    private String userName;
    private String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    // structures 
    // access returnType methodName(parameters)
    // {
    // method body (behavior of this method)
    // }

    public String checkLogin() {
//        if (userName == "Pavan" && password == "1234") {
//            return "Success";
//        } else {
//            return "Fail";
//        }
        
        
        
        return userName == "Rohit" && password == "45" ? "Success":"Fail";
    }
}
