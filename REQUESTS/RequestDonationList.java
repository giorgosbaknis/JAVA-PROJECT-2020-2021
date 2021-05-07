package REQUESTS;

import java.util.ArrayList;

public class RequestDonationList {
    private ArrayList<RequestDonation> rdEntities = new ArrayList<>();

    public RequestDonation get(int id) {

                for (int i = 0; i < rdEntities.size(); i++) { //den yparxei exception?
                    if (rdEntities.get(i).getID() == id) {
                        return rdEntities.get(i);
                    }
                }
                System.err.println("Entity with that ID doesnt exist");
                return null;
    }
    public void add(RequestDonation rd) {

        int found = 0;
        for(int i=0;i<rdEntities.size();i++){  //edw oti hdh yparxei exception
            if(rd.compareTo(rdEntities.get(i)) == 0){
                rdEntities.get(i).setQuantity(rdEntities.get(i).getQuantity()+rd.getQuantity()); //when the 2 entities the same we add up their overall quantity
                found++;
                break;
            }
        }
            //Xreiazomai entityList apo to Organization kai class gia xeirismo "den yparxei" exception
       if(found == 0) {
           for (int i = 0; i < rdEntities.size(); i++) {
               if (rdEntities.get(i).getID() ==  Organization.getEntitylist().getId()) {
                   found += 2;
                   break;
               }
               else throw new RuntimeException("Entity doesnt exist in the Organization"); //ekfwnhsh???
           }
       }


        if(found == 2)
        rdEntities.add(rd);
    }

    public void remove(RequestDonation rd) {

        for (int i = 0; i < rdEntities.size(); i++) {
            if (rd.compareTo(rdEntities.get(i)) == 0) {
                rdEntities.remove(i);                        //den yparxei exception?
            }
        }
    }

    public void modify(int id,int quantity) {

        for (int i = 0; i < rdEntities.size(); i++) {
            if (rdEntities.get(i).getID() == id) {
                rdEntities.get(i).setQuantity(quantity);  //arnitikh posothta exception
            }
        }
        System.err.println("Entity with that ID doesnt exist");

    }

    public void monitor(){
        System.out.println(rdEntities);
    }

    public void reset(){
        rdEntities.removeAll(rdEntities);
    }


}