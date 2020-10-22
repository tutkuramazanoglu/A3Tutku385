package a3.icecream.a3tutku385;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Utills {
    ArrayList<IceCream> iceCreams=new ArrayList<>();
    int index=0;
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
    public ArrayList<IceCream> updateInventory(ArrayList<IceCream> updatedList,int remaining,int position) {
        ArrayList<IceCream> updatedICeCreamList = new ArrayList<>();
        Log.d("cuur","currenn "+updatedList);
        Log.d("cuur","currenn "+remaining);
        for (IceCream currentIceCream : updatedList) {
            Log.d("cuur","currenn "+currentIceCream);
            if (index == position) {
                currentIceCream.setQuantity(remaining);
                Log.d("cuur","currenndsczxdcxs" +currentIceCream.getQuantity());
            }
            index += 1;
        }
        return updatedICeCreamList;
    }

}
