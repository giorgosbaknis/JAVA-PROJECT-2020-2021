package REQUESTS;

import java.util.ArrayList;

public class RequestDonationList {
    private ArrayList<RequestDonation> rdEntities = new ArrayList<>();

    public ArrayList<RequestDonation> getRdEntities() {
        return rdEntities;
    }

    public RequestDonation get(int id) {

        try {
            for (RequestDonation rdEntity : rdEntities) { //den yparxei exception?
                if (rdEntity.getID() == id) {
                    return rdEntity;
                }
            }
            throw new RuntimeException("Entity with that ID doesnt exist");

    }catch(RuntimeException e){
        System.err.println(e);
        return null;
    }
}
    public void add(RequestDonation rd) {
        try {


            int found = 0;
            for (RequestDonation rdEntity : rdEntities) {  //edw oti hdh yparxei exception
                if (rd.compareTo(rdEntity) == 0) {
                    rdEntity.setQuantity(rdEntity.getQuantity() + rd.getQuantity()); //when the 2 entities the same we add up their overall quantity
                    found++;
                    break;
                }
            }
            //Xreiazomai entityList apo to Organization kai class gia xeirismo "den yparxei" exception
            if (found == 0) {
                for (int i = 0; i < rdEntities.size(); i++) {
                    for (int j = 0; j < Organization.getEntitylist().size(); j++) {
                        if (rdEntities.get(i).getID() == Organization.getEntitylist().get(j).getId()) {
                            break;
                        } else if(i==rdEntities.size()-1) throw new RuntimeException("Entity doesnt exist in the Organization"); //ekfwnhsh???
                    }
                }
            }

            if (found == 0)
                rdEntities.add(rd);
        }catch (RuntimeException e){
            System.err.println(e);
        }
    }

    public void remove(RequestDonation rd) {

        for (int i = 0; i < rdEntities.size(); i++) {
            if (rd.compareTo(rdEntities.get(i)) == 0) {
                rdEntities.remove(i);
                break;
                //den yparxei exception?
            }
        }
    }

    public void modify(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQuan = rd.getQuantity();
        boolean found = false;

        try {
            for (RequestDonation rdEntity : rdEntities) {
                if (rdEntity.getID() == rdID) {
                    rdEntity.setQuantity(rdQuan);
                    found = true;
                    break;                            //arnitikh posothta exception
                }
            }
            if (!found) throw new RuntimeException("Entity with that ID doesnt exist");
        }catch (RuntimeException e){
            System.err.println(e);
        }

    }

    public void monitor(){
        System.out.println(rdEntities);
    }

    public void reset(){
        rdEntities.removeAll(rdEntities);
    }


}