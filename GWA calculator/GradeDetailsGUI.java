import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GradeDetailsGUI extends JFrame{
    private GradeDetails gradeDetails = new GradeDetails();
    private JTable table;
    private DefaultTableModel tableModel;

    public GradeDetailsGUI(GradeDetails gradeDetails){
        this.gradeDetails = gradeDetails;
        setSize(400, 500);
        setTitle("Grades Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        String[] columns = {"Subject", "Grade", "Unit"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        populateTable();

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        setVisible(true);
    }

    public void populateTable() {
        
        tableModel.setRowCount(0);

        List<String> subjectNames = gradeDetails.getSubjectNames();
        List<Double> grades = gradeDetails.getGrades();
        List<Integer> units = gradeDetails.getUnit();

        for (int i = 0; i < subjectNames.size(); i++) {
            Object[] row = {
                subjectNames.get(i),
                grades.get(i),
                units.get(i)
            };
            tableModel.addRow(row);
        }
    }
}
