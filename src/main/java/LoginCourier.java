public class LoginCourier {

    private String login;
    private String password;


    public LoginCourier(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginCourier(){
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
