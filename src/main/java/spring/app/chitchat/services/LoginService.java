package spring.app.chitchat.services;

public class LoginService {
    public void loginUser(String username, String password) {
        //check that username exists in database
        try {
            //hash password and match with username
        }
        //username does not exist
        catch(Exception e) {

            System.out.println(e);
        }

    }
}
