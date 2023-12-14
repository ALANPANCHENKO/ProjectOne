public class Senior {
    private final int userId;

    public Senior(int userId) {
        this.userId = userId;
    }

    public void type(String message) {
        System.out.println("user_" + userId + ": " + message);
    }

    public void mergeRequest(String message) {
        if (message.contains("I want a merge")) {
            System.out.println("user_" + userId + ": You are such a jnr! Are you afraid of the Team Lead?");
        }
    }
}