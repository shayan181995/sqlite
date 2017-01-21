package com.example.shayan.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView output;
    EditText input;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.output);
        input = (EditText) findViewById(R.id.input);
        Button btnadd = (Button) findViewById(R.id.btnadd);
        Button btndel = (Button) findViewById(R.id.btndel);

        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();

    }
    public void printDatabase(){
        String dbstring = dbHandler.DatabaseToString();
        output.setText(dbstring);
    }
    public void add(View view){
        Products products = new Products(input.getText().toString());
        dbHandler.addProduct(products);

        printDatabase();
    }
    public void del(View view){
        dbHandler.delProduct(input.getText().toString());
        printDatabase();
    }
}
