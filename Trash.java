public class Trash {
    protected String trashType;
    protected String trashName;
    protected double trashWeight;
    
    public Trash(String trashType, String trashName, double trashWeight){
        this.trashType = trashType;
        this.trashName = trashName;
        this.trashWeight = trashWeight;
    }

    public double getTrashWeight(){
        return trashWeight;
    }

    public String getTrashType(){
        return trashType;
    }

    public String getTrashName() {
        return trashName;
    }

    //---this method will be overridden in the trash type subclasses---//
    public int calculatePoints(){
        return 0;
    }
}
