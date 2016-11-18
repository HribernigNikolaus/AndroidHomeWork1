package com.example.nad.hw1;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;

    private EditText editText2;


    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editTextSideA);
        editText2 = (EditText) findViewById(R.id.editTextSideC);

        resultView = (TextView) findViewById(R.id.textViewResult);
    }

    public void calcSurface(View view) {

        String sideAString = editText1.getText().toString();
        String sideCString = editText2.getText().toString();

        double num1 = 0;
        double num2 = 0;

        try {
            num1=Double.parseDouble(sideAString);
            num2=Double.parseDouble(sideCString);
            double result;
            if (num1 < num2) {
                result  = 2 * Math.PI * num1 * (num1 + ((num2 * num2) / (Math.sqrt((num2 * num2)-(num1 * num1)))) * asinh((Math.sqrt((num2 * num2)-(num1 * num1))) / num2));
            }

            else {
                result  = 2 * Math.PI * num1 * (num1 + ((num2 * num2) / (Math.sqrt((num1 * num1) - (num2 * num2)))) * asinh((Math.sqrt((num1 * num1) - (num2 * num2))) / num2));
            }

            resultView.setText("Surface = "+result);
        } catch (NumberFormatException e) {

            resultView.setText("WRONG INPUT!!");
            e.printStackTrace();
        }
    }


    private static double asinh(double x)
    {
        return Math.log(x + Math.sqrt(x*x + 1.0));
    }




    public void showAbout(View view) {
        Intent intent = new Intent(this, DisplayAboutActivity.class);
        String message = resultView.getText().toString();
        System.out.println("I'm here");
        intent.putExtra("result",message);
        startActivity(intent);
    }
}