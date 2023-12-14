import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Object> users = ChatSimulation.readInputFile("users.txt");
            ChatSimulation.chatSimulation(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
