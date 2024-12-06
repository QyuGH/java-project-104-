import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TrashSegregationGUI {
    public JFrame frame = new JFrame("Trash Segregation App");
    public JPanel mainPanel = new JPanel(new GridLayout(6, 1, 20, 20));
    public JPanel usernamePanel, trashTypePanel, trashNamePanel, trashWeightPanel;
    public JButton addTrashBtn = new JButton("Add Trash");
    public JButton leaderboardBtn = new JButton("Leaderboard");
    public JButton guideBtn = new JButton("Show Trash Guide");
    public UserLeaderboard leaderboard = new UserLeaderboard();
    public User user;
    public Trash trash;
    
    public TrashSegregationGUI(){
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //---app name panel---//
        JPanel appNamePanel = new JPanel();
        appNamePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel appName = new JLabel("Trash Segregation App");
        appName.setFont(new Font("Arial", Font.BOLD, 28));
        appNamePanel.add(appName);
        //---END---//

        //---username panel---//
        usernamePanel = new JPanel();
        this.setPanelLayout(usernamePanel);
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        //---END---//

        //---trash type panel---//
        trashTypePanel = new JPanel();
        this.setPanelLayout(trashTypePanel);
        JLabel trashTypeLabel = new JLabel("Trash Type: ");
        String[] trashType = {"Biodegradable", "Non-Biodegradable", "Recyclable"};
        JComboBox<String> trashTypeOptions = new JComboBox<>(trashType);
        trashTypePanel.add(trashTypeLabel);
        trashTypePanel.add(trashTypeOptions);
        //---END---//
        
        //---trash name panel---//
        trashNamePanel = new JPanel();
        this.setPanelLayout(trashNamePanel);
        JLabel trashNameLabel = new JLabel("Trash Name: ");
        JTextField trashNameField = new JTextField();
        trashNamePanel.add(trashNameLabel);
        trashNamePanel.add(trashNameField);
        //---END---//

        //---trash weight panel---//
        trashWeightPanel = new JPanel();
        this.setPanelLayout(trashWeightPanel);
        JLabel trashWeightLabel = new JLabel("Trash Weight (kg): ");
        JTextField trashWeightField = new JTextField();
        trashWeightPanel.add(trashWeightLabel);
        trashWeightPanel.add(trashWeightField);
        //---END---//

        //---panel for buttons---//
        JPanel btnPanel = new JPanel(new GridLayout(3,1, 20, 20));
        btnPanel.setBorder(new EmptyBorder(10, 50, 50, 50));
        btnPanel.add(addTrashBtn);
        btnPanel.add(leaderboardBtn);
        btnPanel.add(guideBtn);
        //---END---//

        //---adding for frame output---//
        mainPanel.add(appNamePanel);
        mainPanel.add(usernamePanel);
        mainPanel.add(trashTypePanel);
        mainPanel.add(trashNamePanel);
        mainPanel.add(trashWeightPanel);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        //---END---//

        //---add trash button functionality---//
        addTrashBtn.addActionListener(e -> {
            if (!usernameField.getText().isEmpty() && !trashNameField.getText().isEmpty() && !trashWeightField.getText().isEmpty()) {
                String trashOption = (String) trashTypeOptions.getSelectedItem();
                String trashName = trashNameField.getText();
                
                try {
                    double weight = Double.parseDouble(trashWeightField.getText());
                    user = new User(usernameField.getText());
        
                    if (user == null) {
                        user = new User(usernameField.getText());
                    }
        
                    switch (trashOption) {
                        case "Biodegradable":
                            trash = new Biodegradable(trashName, weight);
                            break;
                        case "Recyclable":
                            trash = new Recyclable(trashName, weight);
                            break;
                        case "Non-Biodegradable":
                            trash = new NonBiodegradable(trashName, weight);
                            break;
                    }
        
                    user.addContribution(trash);
                    trashNameField.setText("");
                    trashWeightField.setText("");
                    leaderboard.addUser(user);
                    JOptionPane.showMessageDialog(frame, "Trash added successfully!", "Successful Addition", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for the weight.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in empty fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        

        leaderboardBtn.addActionListener(e -> {
            leaderboard.displayUser();
        });

        guideBtn.addActionListener(e -> {
            new TrashGuide();
        });

        frame.setVisible(true);
    }

    public void setPanelLayout(JPanel panel){
        panel.setLayout(new GridLayout(1,2));
        panel.setBorder(new EmptyBorder(10,20,10,20));
    }

    public static void main(String[] args) {
        new TrashSegregationGUI();
    }
}
