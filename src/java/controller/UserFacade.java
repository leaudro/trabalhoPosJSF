package controller;

public class UserFacade {

    private String username;
    private String password;
    private String errorMessage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String login() {
        if (username != null && username.equalsIgnoreCase("professor")) {
            return "goToMain";
        } else {
            setUsername("");
            setPassword("");
            setErrorMessage("Login ou senha inválidos");
            return "refresh";
        }
    }
}
