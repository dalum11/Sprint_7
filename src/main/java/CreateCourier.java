public class CreateCourier {

    private String login;
    private String password;
    private String firstName;

    public CreateCourier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public CreateCourier(){}

    public CreateCourier(String login, String firstName) {
        this.login = login;
        this.firstName = firstName;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public String firstName() {
        return firstName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
