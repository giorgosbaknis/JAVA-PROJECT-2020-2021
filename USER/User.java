package USER;

abstract class User {
    //klash anaparastashs xrhsth
    private String name = "";//onoma user
    private String phone = "";//thlephono user

    //constructor pou orizei to name kai to phone
    public User(String name,String phone ) {
        this.name = name;
        this.phone = phone;
    }
    //epistrefei to name
    public String getName() {
        return name;
    }
    //epistrefei to phone
    public String getPhone() {
        return phone;
    }


}
