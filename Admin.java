

public class Admin extends User{

    private boolean isAdmin = true;//anagnorizei oti einai admin
    //rythmizei to onoma kai to thlefwno tou admin
    public Admin(String name, String phone) {
        super(name, phone);
    }
    //epistrefei oti to antikeimeno einai admin
    public boolean isAdmin() {
        return isAdmin;
    }

}
