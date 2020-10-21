package a3.icecream.a3tutku385;

import java.util.ArrayList;

public class Utills {
    ArrayList<IceCream> iceCreams=new ArrayList<>();
    public ArrayList<IceCream> getIceCreams(){
        this.iceCreams.add(new IceCream("Brazilian Lightning",
                "Dairy-free vanilla ice cream mixed with acai, " +
                        "bananas, and a drizzle of strawberry syrup",3.15,8));
        this.iceCreams.add(new IceCream("Cherry Explosion","Cherry ice cream" +
                " with real chunks of chocolate and dried cheries",4.6,0));
        this.iceCreams.add(new IceCream("Chocolate Chip Cookie Dough","Classic" +
                "chocolate ice cream with hefty pieces of shortbread cookie dough",5,12));
        return iceCreams;
    }
}
