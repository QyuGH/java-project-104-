public class NonBiodegradable extends Trash{
    public NonBiodegradable(String trashName, double trashWeight){
        super("Non-Biodegradable", trashName, trashWeight);
    }

    @Override
    public int calculatePoints(){
        return (int) (trashWeight * 2);
    }
}
