public class TeamLead {
    private final int userId;

    public TeamLead(int userId) {
        this.userId = userId;
    }

    public void type(String message) {
        System.out.println("user_" + userId + ": " + message);
    }

    public void nonFallenProd() {
        System.out.println("user_" + userId + ": I have a non-fallen prod");
    }

    public void codeReview(String message, String userName) {
        if (message.contains("I want a merge. Will somebody review it for me?")) {
            System.out.println("user_" + userId + ": Of course, baby. Be ready to suffer " + userName + "!");
        }
    }
}
