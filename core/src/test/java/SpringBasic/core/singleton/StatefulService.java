package SpringBasic.core.singleton;

public class StatefulService {

    private int price; // 상태 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = "+name+" price = " + price);
        // 여기가 문제임 this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
