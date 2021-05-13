package USER;

import REQUESTS.Offers;
import REQUESTS.RequestDonation;

public class Donator extends User{

    private Offers offerList;

    public Donator(String name, String phone) {
        super(name, phone);
    }
    public void add(RequestDonation rd){
        offerList.add(rd);
    }
    public void modify(RequestDonation rd){
        offerList.modify(rd);
    }
    public void remove(RequestDonation rd){
        offerList.remove(rd);
    }
    public void monitor(){
        offerList.monitor();
    }
    public void commit(){
        offerList.commit();
    }
    public void reset(){
        offerList.reset();
    }


}
