import java.util.ArrayList;
import java.util.List;

public class UserLeaderboard {
    private List<User> users;

    public UserLeaderboard() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUser(){
        //---code to sort user based on points---///
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getTotalPoints() < users.get(j).getTotalPoints()) {
                    User temp = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, temp);
                }
            }
        }

        System.out.println("--- LEADERBOARD ---");
        System.out.println();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Top " + (i+1));
            System.out.println("Username: " + users.get(i).getUsername());
            System.out.println("Points: " + users.get(i).getTotalPoints());  
            System.out.println();
        }
    }
}
