package tanat.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

/*    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;*/

    EditText editText1, editText2;
    Button buttonPlus, buttonMinus, buttonMax, buttonMin, buttonResult;
    TextView textViewRusult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMax = (Button) findViewById(R.id.buttonMax);
        buttonMin = (Button) findViewById(R.id.buttonMin);
        buttonResult = (Button) findViewById(R.id.buttonResult);

        textViewRusult = (TextView) findViewById(R.id.textViewResult);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMax.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonResult.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");*/
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_reset:
                editText1.setText("");
                editText2.setText("");
                textViewRusult.setText("");
                break;
            case R.id.action_quit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0, num2 = 0, result = 0;

        if (TextUtils.isEmpty(editText1.getText().toString())
                || TextUtils.isEmpty(editText2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(editText1.getText().toString());
        num2 = Float.parseFloat(editText2.getText().toString());

        switch (v.getId()){
            case R.id.buttonPlus:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.buttonMinus:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.buttonMax:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.buttonMin:
                oper = "/";
                result = num1 / num2;
                break;
                default:
                    break;
        }

        textViewRusult.setText(num1 + oper + num2 + "=" + result);

    }
}
