public class Middle {
    private final int userId;

    public Middle(int userId) {
        this.userId = userId;
    }

    public void type(String message) {
        System.out.println("user_" + userId + ": " + message);
    }

    public void mergeRequest() {
        System.out.println("user_" + userId + ": I want a merge. Will somebody review it for me?");
    }

    public void codeReview(String message) {
        if (message.contains("Team Lead") || message.contains("TL")) {
            System.out.println("user_" + userId + ": AAAAaaa! No! No TL code review, please!");
        }
    }
}