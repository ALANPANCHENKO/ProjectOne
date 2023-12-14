public class User {
    private final int userId;

    public String getUserName() {
        return "user_" + userId;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public void type(String message) {
        System.out.println("user_" + userId + ": " + message);
    }
}








