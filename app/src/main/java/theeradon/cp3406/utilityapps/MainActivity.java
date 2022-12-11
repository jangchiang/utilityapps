package theeradon.cp3406.utilityapps;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public static final String MSG = "KEY";
    private TextView result;
    private EditText h1;
    private EditText w1;
    private Button charts;
    ArrayAdapter<String> adapterItems;
    AutoCompleteTextView autoCompleteTextView;
    String[] Gender = {"MALE","FEMALE","OTHERS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView2);
        adapterItems = new ArrayAdapter<>(this,R.layout.dropdownmenu,Gender);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String item = adapterView.getItemAtPosition(i).toString();

            }
        });
        charts = findViewById(R.id.setting);


        button = findViewById(R.id.Calculate);
        result  = findViewById(R.id.result);
        h1 = findViewById(R.id.Height);
        w1 = findViewById(R.id.weight);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();
                Double val =  Double.parseDouble(h1.getText().toString());
                Double val1 = Double.parseDouble(w1.getText().toString());
                Double BMI = Double.parseDouble(String.format("%.3f",(double) val1 / (val*val)));
                if(BMI<18.5){

                    Toast.makeText(MainActivity.this,"Underweight!!", LENGTH_SHORT).show();
                }
                else if(BMI<25){
                    Toast.makeText(MainActivity.this,"Normal weight!!", LENGTH_SHORT).show();
                }

                else if(BMI <30){
                    Toast.makeText(MainActivity.this,"Overweight!!", LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this,"Obesity!!", LENGTH_SHORT).show();

                }


                result.setText("BMI "+BMI);



            }
        });

    }

    public void Explore(View view){

        Intent intent = new Intent(this,setting.class);
        String Message = "GENDER "+autoCompleteTextView.getText().toString() +" "+"WEIGHT "+w1.getText().toString()+" "
                +"HEIGHT "+ h1.getText().toString();
        intent.putExtra(MSG,Message);
        startActivity(intent);


    }

}