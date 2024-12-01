import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private int totalPoints;
    private List<Trash> contributions;

    public User(String username){
        this.username = username;
        this.totalPoints = totalPoints;
        this.contributions = new ArrayList<>();
    }

    public void addContribution(Trash trash) {
        contributions.add(trash);
        totalPoints += trash.calculatePoints();
    }

    public String getUsername(){
        return username;
    }

    public int getTotalPoints(){
        return totalPoints;
    }

    public List<Trash> getContributions() {
        return contributions;
    }
}
