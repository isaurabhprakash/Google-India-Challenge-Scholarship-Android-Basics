/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view)
    {
        quantity = quantity + 1;
        display(quantity);
        displayPriceValue("Rs " +quantity*5);
    }
    public void decrement(View view)
    {
        quantity = quantity - 1;
        display(quantity);
        displayPriceValue("Rs "+quantity*5);

    }
    /**
     * This method is called when the order button is clicked.
     */
      public void submitOrder(View view) {
          String message="Thanks! You have to pay Rs "+quantity*5;
          TextView p=(TextView)findViewById(R.id.price_text_view);
          p.setText("");
          TextView v=(TextView)findViewById(R.id.price);
          v.setTextSize(20);
          v.setText(message);
      }
    /**

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
     private void displayPriceValue(String message) {
          TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
          TextView price=(TextView) findViewById(R.id.price);
          price.setTextSize(30);
          price.setText("Price : ");
          priceTextView.setText(message);
      }
}