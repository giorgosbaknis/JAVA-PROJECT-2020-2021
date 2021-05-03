package ENTITY;

public class Main {

    public static void main(String[] args){
        //Test Service
        Service se = new Service("NurserySupport", "nosokoma", 5);
        System.out.println(se.toString());

        //Test Material
        Material mat = new Material("milk", "gala",2,1,2,3);
        System.out.println(mat.toString());

    }
}
