package a3.icecream.a3tutku385;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView textScoopNumb;
    TextView textFlavour;
    TextView textScopePrice;
    TextView textTotalPrice;
    String amount;
    String scoopPrice;
    String getFlavour;
    String numScoop;
    int position;
    ArrayList<IceCream> iceCreamList;
    Utills utils=new Utills();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        textTotalPrice=findViewById(R.id.tvTotalPrice);
        numScoop=intent.getStringExtra("scoop");
        getFlavour=intent.getStringExtra("flavour");
        scoopPrice=intent.getStringExtra("scoopPrice");
        amount=intent.getStringExtra("remaining");
        position=intent.getIntExtra("position",-1);

        textScoopNumb=findViewById(R.id.tvScoop);
        textScoopNumb.setText("Numb of Scoops: "+numScoop);
        textFlavour=findViewById(R.id.tvFlavour);
        textFlavour.setText("Flavour: "+getFlavour);
        textScopePrice=findViewById(R.id.tvPrice);
        textScopePrice.setText("Price per Scoop: "+scoopPrice);
        totalPrice();

    }
    public void orderAgain(View view){
        Intent i=new Intent(this,MainActivity.class);

        //this.iceCreamList=this.utils.getIceCreams(updatedList());
        int inventory=inventory();
        //Log.d("left","it left"+a);
        i.putExtra("position",position);
        i.putExtra("remainingScoop",inventory);
        Log.d("pos","positin: "+position);
        startActivity(i);
    }
//    public int inventory(){
//        this.iceCreamList=this.utils.getIceCreams();
//        int totalScoop=Integer.parseInt(amount);
//        int requestScoop=Integer.parseInt(numScoop);
//        int remainingScoop=totalScoop-requestScoop;
//        iceCreamList.get(position).setQuantity(remainingScoop);
//        int remaining=iceCreamList.get(this.position).getQuantity();
//        Log.d("left","it left"+iceCreamList.get(position).getQuantity());
//        Log.d("left","it left"+remaining);
//        return  remaining;
//
//    }
    public int inventory(){
        int totalScoop=Integer.parseInt(amount);
        int requestScoop=Integer.parseInt(numScoop);
        int remainingScoop=totalScoop-requestScoop;
        return remainingScoop;

    }
    public void totalPrice()
    {
        int totalScoop=Integer.parseInt(numScoop);
        double scoopOfPrice=Double.parseDouble(scoopPrice);
        double totalPrice=totalScoop*scoopOfPrice;
        textTotalPrice.setText("Total:$ "+String.format("%.2f",totalPrice));
    }
}