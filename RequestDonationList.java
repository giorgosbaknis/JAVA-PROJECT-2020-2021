

import java.util.ArrayList;

public class RequestDonationList {
    private ArrayList<RequestDonation> rdEntities = new ArrayList<>();

    public ArrayList<RequestDonation> getRdEntities() {
        return rdEntities;
    }


    public RequestDonation get(int id) {

        try {
            for (RequestDonation rdEntity : rdEntities) { // kanoume diaperash   ta rdEntites tis listas apo tin opoia thn kaloyme
                if (rdEntity.getID() == id) {
                    return rdEntity; //an yparxei entity me to id poy dwsame san orisma to epistrefei
                }
            }
            throw new EntityNotExistingException("Entity with that ID doesnt exist"); //petaei exception oti dn yparxei

        }catch(EntityNotExistingException e){
            System.err.println(e);
            return null; //kanoyme return null an exei petaksei exception epeidh to xrhsimopoioyme gia ena elegxo sthn Request
        }
    }
    public void add(RequestDonation rd) {
        try {


            int found = 0;
            for (RequestDonation rdEntity : rdEntities) { //An to entity yparxei hdh sta Entities toy Beneficiary/donator mas
                if (rd.compareTo(rdEntity) == 0) {
                    rdEntity.setQuantity(rdEntity.getQuantity() + rd.getQuantity()); //when the 2 entities the same we add up their overall quantity
                    found++;
                    break;
                }
            }

            if (found == 0) { //an dn trexei to parapanw if eksetazoyme an diakinei ayto to entity o Organization
                {

                    for (int j = 0; j < Organization.getEntityList().size(); j++) {

                        if (rd.getID() == Organization.getEntityList().get(j).getId() ) {
                           // System.out.println("vrikame to "+);
                            break;
                        } else if(j==Organization.getEntityList().size()-1) throw new EntityNotExistingException("Entity doesnt exist in the Organization"); //ekfwnhsh???
                    } //An to vrike se olh thn for sto teleytaio treksimo ths for petaei Exception
                }
                rdEntities.add(rd); //alliws kanei add kanonika
            }


        }catch (EntityNotExistingException e){
            System.err.println(e);
        }
    }

    public void remove(RequestDonation rd) {

        for (int i = 0; i < rdEntities.size(); i++) {
            if (rd.compareTo(rdEntities.get(i)) == 0) { //tsekarei an yparxoyn entities me to idio id wste na to bgalei apo thn antistoixh lista
                rdEntities.remove(i);
                break;

            }
        }
    }

    public void modify(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQuan = rd.getQuantity();
        boolean found = false;

        try {
            for (RequestDonation rdEntity : rdEntities) {
                if (rdEntity.getID() == rdID) { //tsekarei an yparxei to zhtoymeno entity
                    rdEntity.setQuantity(rdQuan); // kai an to vrei tropopoiei thn posothta toy se ayth p edwse o xrhsths
                    found = true;
                    break;
                }
            }
            if (!found) throw new EntityNotExistingException("Entity with that same ID doesnt exist"); //an dn yparxei petaei exception
        }catch (EntityNotExistingException e){
            System.err.println(e);
        }

    }

    public void monitor(){
        for ( int i=0;i<rdEntities.size();i++)
        System.out.println((i+1)+". "+ rdEntities.get(i).getEntity().getName() + "("+ rdEntities.get(i).getQuantity()+")"); //Typwnei ola ta onoma kai posotites entity sthn lista poy doylevoyme
    }

    public void reset(){
        rdEntities.removeAll(rdEntities);
    } //afairei ola ta Entities apo thn zhtoumenh lista


}