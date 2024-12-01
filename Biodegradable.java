public class Biodegradable extends Trash {
    public Biodegradable(String trashName, double trashWeight){
        super("Biodegradable", trashName, trashWeight);
    }

    @Override
    public int calculatePoints(){
        return (int) (trashWeight * 5);
    }
}
