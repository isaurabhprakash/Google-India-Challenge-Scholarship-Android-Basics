package com.example.android.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity= 2, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }
    public void displayQuantity(int number)
    {
        TextView quantityView = (TextView) findViewById(R.id.quantity_text_view);
        quantityView.setText("" + number);
    }
    public void decrement(View v)
    {
        if(quantity==1){
            Toast.makeText(this, "Number of coffees can't be less than 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }
    public void increment(View v)
    {
        if(quantity==100){
            Toast.makeText(this, "Number of coffees can't be more than 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }
    public void submitOrder(View v){
        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checked_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checked_box);
        boolean hasChocolate = chocolate.isChecked();
        calculatePrice(hasWhippedCream,hasChocolate);
        String message = createOrderSummary(name, hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    public void calculatePrice(boolean hasWhippedCream,boolean hasChocolate){
        if(hasWhippedCream && hasChocolate)
        {
            price = (5+1+2)*quantity;
        }
        else if(hasWhippedCream){
            price = (5+1)*quantity;
        }
        else if(hasChocolate){
            price = (5+2)*quantity;
        }
        else
            price = 5*quantity;
    }
    public String createOrderSummary(String name, boolean hasWhippedCream, boolean hasChocolate){
        String message = "Name: "+name+"\nAdd whipped cream?"+hasWhippedCream+"\nAdd chocolate?"+hasChocolate+"\nQuantity: "+ quantity+"\nTotal: Rs "+price+"\nThank You!";
        return message;
    }
}
