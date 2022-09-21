package Model;

public class UsersDTO {

    // Data.
    private int userId;
    private int userAge;
    private String userName;
    private String userPassword;
    private String userTel;
    private String userAddress;

    // Getter Methods.
    public int getUserId() { return userId; }
    public int getUserAge() { return userAge; }
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserTel() {
        return userTel;
    }
    public String getUserAddress() { return userAddress; }


    // Setter Methods.
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }


    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

}
