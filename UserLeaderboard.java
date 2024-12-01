import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserLeaderboard {
    private List<User> users;
    private JFrame frame;
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;

    public UserLeaderboard() {
        users = new ArrayList<>();
        frame = new JFrame("Leaderboards");

        String[] columnNames = {"Rank", "Username", "Points"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        leaderboardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);

        frame.add(scrollPane);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUser() {
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

        tableModel.setRowCount(0);

        //---set data for leaderboard table---//
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            Object[] row = {i + 1, user.getUsername(), user.getTotalPoints()};
            tableModel.addRow(row);
        }

        frame.setVisible(true);
    }
}
