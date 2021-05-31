
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
    public void remove(RequestDonation rd){offerList.remove(rd);}//afairei ena antikeimeno rd apo to offerList
    public void monitor(){offerList.monitor();}//emfanizei plhrofories gia thn offerList
    public void commit(){offerList.commit();}//metaferei ta dedomena sta requestDonation
    public void reset(){offerList.reset();}//kanei reset thn offerList

}
