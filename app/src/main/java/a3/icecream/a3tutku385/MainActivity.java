package a3.icecream.a3tutku385;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Utills utils=new Utills();
    ArrayList<String> iceCreamFlavours = new ArrayList<>();
    private ArrayList<IceCream> iceCreamList;
    EditText editText;
    Spinner spIceCreamFlavours;
    String itemSelected;
    TextView textAmount;
    TextView textDescription;
    TextView textPricePerScoop;
    int inventory;
    int a;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAmount=findViewById(R.id.tvAmount);
        textDescription=findViewById(R.id.tvDescription);
        textPricePerScoop=findViewById(R.id.tvPricePerScoop);
        editText=findViewById(R.id.editTextNumber);
        Intent intent=getIntent();
        a=intent.getIntExtra("position",-1);
        inventory=intent.getIntExtra("remainingScoop",-1);
        Log.d("pos","positin: "+a);

        this.iceCreamList=utils.getIceCreams();
        getSelectedItem();
//        if(a==-1){
//            getSelectedItem();
//        }
//        else{
//            getSelectedItem(a);
//        }


    }
    public void placeOrder(View view){
        if(checkAmount(view)==true){
            Intent intent=new Intent(this,MainActivity2.class);
            String numScoop=editText.getText().toString(); //get the number of request to scoop
            String flavour=spIceCreamFlavours.getSelectedItem().toString(); //get the flavours
            String perPrice= textPricePerScoop.getText().toString(); //get to price per of scoop
            String amount=textAmount.getText().toString(); //get to number of remaining scoop
            int selectedPosition=spIceCreamFlavours.getSelectedItemPosition();

            intent.putExtra("flavour",flavour);
            intent.putExtra("scoop",numScoop);
            intent.putExtra("scoopPrice",perPrice);
            intent.putExtra("remaining",amount);
            intent.putExtra("position",selectedPosition);
            startActivity(intent);
        }
        else{
            Toast toast=Toast.makeText(this,"Please check number of scoop",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void getSelectedItem(){
        for (IceCream c: this.iceCreamList) {
            iceCreamFlavours.add(c.getFlavour());
        }
        spIceCreamFlavours =  findViewById(R.id.spinner);
        ArrayAdapter<String> flavoursAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                iceCreamFlavours);
        spIceCreamFlavours.setAdapter(flavoursAdapter);
        spIceCreamFlavours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelected =(String) spIceCreamFlavours.getSelectedItem();
                String description=iceCreamList.get(i).getDescription();
                int quantity=iceCreamList.get(i).getQuantity();
                double scoopOfPrice=iceCreamList.get(i).getPrice();
                textDescription.setText(String.format("%s",description));
                textAmount.setText(String.format("%d",quantity));
                textPricePerScoop.setText(String.format("%.2f",scoopOfPrice));
                if(a==-1 || a!=i){

                textAmount.setText(String.format("%d",quantity));
                }
                else{
                    textAmount.setText(String.format("%d",inventory));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public boolean checkAmount(View view){
        String reamingScoop=textAmount.getText().toString(); //get to number of remaining scoop
        Log.d("remain",reamingScoop);
        String numScoop=editText.getText().toString(); //get the number of request to scoop

        Log.d("numb",numScoop);
    if(TextUtils.isEmpty(numScoop)){
            Toast toast=Toast.makeText(this,"You did not select any number of Scoop. Please select your number of scoop.",Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        else{
            int remaining=Integer.parseInt(reamingScoop);
            int number=Integer.parseInt(numScoop);
            if(remaining<number || (int)number==0){ //check empty
                Toast toast=Toast.makeText(this,"It left "+reamingScoop+". Please enter again.",Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        }
        return true;
    }
}