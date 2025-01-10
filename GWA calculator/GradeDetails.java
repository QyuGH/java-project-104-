import java.util.ArrayList;

public class GradeDetails {
    private ArrayList<String> subjectName;
    private ArrayList<Double> grades;
    private ArrayList<Integer> unit;
    
    public GradeDetails(){
        this.subjectName = new ArrayList<>();
        this.grades  = new ArrayList<>();
        this.unit = new ArrayList<>();
    }

    public void addsubjectName(String subjectName){
        this.subjectName.add(subjectName);
    }

    public void addGrades(double grades){
        this.grades.add(grades);
    }

    public void addUnit(int unit){
        this.unit.add(unit);
    }

    public ArrayList<String> getSubjectNames(){
        return subjectName;
    }

    public ArrayList<Double> getGrades(){
        return grades;
    }

    public ArrayList<Integer> getUnit(){
        return unit;
    }

    public double computeTotal(){
        double total = 0;
        int totalUnit = 0;
        for (int i = 0; i < grades.size(); i++){
            total += grades.get(i) * unit.get(i);
            totalUnit += unit.get(i);
        }

        double gwa = total / totalUnit;

        return gwa;
    }
}
