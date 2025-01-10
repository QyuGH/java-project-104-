import java.awt.*;
import javax.swing.*;

public class AppGUI extends JFrame{
    private GradeDetails details = new GradeDetails();
    private GradeDetailsGUI gradeDetails = new GradeDetailsGUI(details);

    public AppGUI(){
        setLayout(new GridLayout(3, 1, 10, 10));
        setTitle("GWA Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel midPanel = new JPanel();
        JPanel botPanel = new JPanel();

        //--- TOP PANEL COMPONENTS ---//
        JTextField nameField = new JTextField();
        JTextField gradeField = new JTextField();
        JTextField unitField = new JTextField();
        topPanel.add(new JLabel("Subject Name: ", SwingConstants.CENTER));
        topPanel.add(nameField);
        topPanel.add(new JLabel("Subject Grade: ", SwingConstants.CENTER));
        topPanel.add(gradeField);
        topPanel.add(new JLabel("Subject Unit: ", SwingConstants.CENTER));
        topPanel.add(unitField);
        //--- END ---//

        //--- MID PANEL COMPONENTS ---//
        JButton addBtn = new JButton("Add Subject");
        JButton showSubBtn = new JButton("Show Subjects");
        JButton solveBtn = new JButton("Calculate GWA");
        midPanel.add(addBtn);
        midPanel.add(showSubBtn);
        midPanel.add(solveBtn);
        //--- END ---//

        //--- BOT PANEL COMPONENTS ---//
        JTextField gwaField = new JTextField();
        gwaField.setPreferredSize(new Dimension(100, 30));
        gwaField.setEditable(false);
        botPanel.add(new JLabel("GWA:"));
        botPanel.add(gwaField);
        //--- END ---//

        addBtn.addActionListener(e -> {
            String subjectNameText = nameField.getText().trim().toUpperCase();
            String gradeText = gradeField.getText().trim();
            String unitText = unitField.getText().trim();

            if (subjectNameText.isEmpty() || gradeText.isEmpty() || unitText.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "All fields must be filled.", 
                    "Input Error", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                double grade = Double.parseDouble(gradeText);
                int unit = Integer.parseInt(unitText);    

                addSubject(subjectNameText, grade, unit);
                nameField.setText("");
                gradeField.setText("");
                unitField.setText("");

            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, 
                    "Invalid Input", 
                    "Input Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        showSubBtn.addActionListener(e -> {
            gradeDetails.populateTable();
        });

        solveBtn.addActionListener(e -> {
           double gwa = details.computeTotal();
           gwaField.setText(String.format("%.2f", gwa));
        });

        add(topPanel);
        add(midPanel);
        add(botPanel);
        setVisible(true);
    }

    public void addSubject(String subjectName, double grade, int unit){
        details.addsubjectName(subjectName);
        details.addGrades(grade);
        details.addUnit(unit);
    }

    public static void main(String[] args) {
        new AppGUI();
    }
}