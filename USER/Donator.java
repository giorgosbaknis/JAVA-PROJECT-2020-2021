package USER;

import ENTITY.Service;
import REQUESTS.Offers;
import REQUESTS.RequestDonation;
//klash pou anaparista ton dorhth
public class Donator extends User{

    private Offers offerList = new Offers();//lista twn eidwn pou epithymei na prosferei o donator

    public Offers getOfferList() {
        return offerList;
    }//epistrefei thn lista offerList
    //constructor of Donator
    //times gia name kai phone
    public Donator(String name, String phone) {
        super(name, phone);
    }
    public void add(RequestDonation rd){offerList.add(rd);}//prosthetei 1 antikeimeno rd sthn lista offerList
    public void modify(RequestDonation rd){offerList.modify(rd);}//tropopoiei 1 antikeimeno
    public void remove(RequestDonation rd){offerList.remove(rd);}//
    public void monitor(){offerList.monitor();}
    public void commit(){offerList.commit();}
    public void reset(){offerList.reset();}


}
