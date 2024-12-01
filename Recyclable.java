public class Recyclable extends Trash{
    public Recyclable(String trashName, double trashWeight){
        super("Recyclable", trashName, trashWeight);
    }

    public int calculatePoints(){
        return (int) (trashWeight * 10);
    }
}
