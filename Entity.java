
abstract public class Entity {
   private String name = "";
   private String description = "";
   private int id = 0;
    public Entity(String name,String description,int id){
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEntityInfo(){
        return "Name: " + name + "\nDescription: " + description + "\nId: " + id;
    }

    abstract public String getDetails();

    @Override
    public String toString(){
        return getEntityInfo() + getDetails();
    }

    public int getId() {
        return id;
    }
}
