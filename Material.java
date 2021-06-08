
public class Material extends Entity{

    private double level1;
    private double level2;
    private double level3;

    public Material(String name,String description,int id,double level1, double level2, double level3){
        super(name,description,id);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }

    @Override
    public String getDetails(){
        return "\nObject is Material" + "\nLevel1: "+ level1  + "\nLevel2: " + level2 + "\nLevel3: " + level3;
    }

    public double getLevel1() {
        return level1;
    }

    public double getLevel2() {
        return level2;
    }

    public double getLevel3() {
        return level3;
    }

}
