

public class RequestDonation implements Comparable<RequestDonation> { //Comparable anti gia Comparator
    private Entity entity;
    private double quantity;
    //interface comparator!!!!!!!!


    public Entity getEntity() {
        return entity;
    }

    public RequestDonation(Entity entity, double quantity) {
        this.entity = entity;
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getID(){
        return this.entity.getId();
    }

    @Override
    public  int compareTo(RequestDonation o1) {

        return this.entity.getId()-o1.entity.getId(); //Epistrefei 0 an ta dyo Entity exoyn to idio ID

    }

    @Override
    public String toString(){
        return "Entity: " + entity +
                " Quantity: " + quantity;
    }
}
