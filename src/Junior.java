public class Junior {
    private final int userId;

    public  Junior(int userId) {
        this.userId = userId;
    }


    public void type(String message) {
        System.out.println("user_" + userId + ": " + message);
    }

    public void mergeRequest() {
        System.out.println("user_" + userId + ": I want a merge. Will somebody review it for me?");
    }
}