package REQUESTS;

public class Requests extends RequestDonationList{

    //prepei na vroume mesw ths RDL tin id toy entity pu zhthse o Bene , kai meta na pame mesw Organa na vroume kai na sygkrinoume posothtes



    @Override
    public void add(RequestDonation rd) {
        int rdID = rd.getID();
        double rdQu = rd.getQuantity();

        try {

          for (RequestDonation rdEntity : getRdEntities()) {

              if (rdID == rdEntity.getID())

                  if (rdQu <= rdEntity.getQuantity()) {
                      super.add(rd);
                      break;
                  } else
                      throw new RuntimeException("This quantity is not currently available, we deeply apologize.");


          }
      }catch (RuntimeException e){
          System.err.println(e);
      }

    }


    @Override
    public void modify(int id, int quantity) {
        super.modify(id, quantity);
    }
}
