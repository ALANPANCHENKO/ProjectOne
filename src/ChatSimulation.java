import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatSimulation {

    public static List<Object> readInputFile(String filePath) throws IOException {
        List<Object> users = new ArrayList<>();
        int userIdCounter = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String userName = parts[0];
                String role = parts[1];

                switch (role) {
                    case "User":
                        users.add(new User(userIdCounter++));
                        break;
                    case "Junior":
                        users.add(new Junior(userIdCounter++));
                        break;
                    case "Middle":
                        users.add(new Middle(userIdCounter++));
                        break;
                    case "Senior":
                        users.add(new Senior(userIdCounter++));
                        break;
                    case "TeamLead":
                        users.add(new TeamLead(userIdCounter++));
                        break;
                }
            }
        }

        return users;
    }


    public static void chatSimulation(List<Object> users) {
        for (Object user : users) {
            try {
                if (user instanceof User && ((User) user).getUserName().equals("user_4")) {
                    // Первым делом пользователь_4 выполняет свой запрос
                    ((User) user).type("You are such a jnr! Are you afraid of the Team Lead?");
                } else if (user instanceof User) {
                    ((User) user).type("Hey");
                } else if (user instanceof Junior) {
                    ((Junior) user).type("Hey");
                    ((Junior) user).mergeRequest();
                } else if (user instanceof Middle) {
                    ((Middle) user).type("Hey");
                    ((Middle) user).mergeRequest();
                    ((Middle) user).codeReview("I want a merge. Will somebody review it for me?");
                } else if (user instanceof Senior) {
                    ((Senior) user).type("Hey");
                    String mergeRequestMessage = "I want a merge";
                    ((Senior) user).mergeRequest(mergeRequestMessage);
                    if (mergeRequestMessage.equals("I want a merge")) {
                        User user3 = findUserByName(users, "user_3");
                        if (user3 != null) {
                            user3.type("AAAAaaa! No! No TL code review, please!");
                        }
                    }
                } else if (user instanceof TeamLead) {
                    ((TeamLead) user).type("Hey");
                    ((TeamLead) user).nonFallenProd();
                    ((TeamLead) user).codeReview("I want a merge. Will somebody review it for me?", "Junior");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





    private static User findUserByName(List<Object> users, String userName) {
        for (Object user : users) {
            if (user instanceof User && ((User) user).getUserName().equals(userName)) {
                return (User) user;
            }
        }
        return null;
    }
}


