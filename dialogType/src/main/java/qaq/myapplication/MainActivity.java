package qaq.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import qaq.myapplication.demo.clickOne;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private clickOne one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_sample = findViewById(R.id.bt_sample1);
        Button bt_item =  findViewById(R.id.bt_sample2);
        Button bt_item2 =  findViewById(R.id.bt_sample3);
        Button bt_item3=  findViewById(R.id.bt_sample4);
        Button bt_item4 =  findViewById(R.id.bt_sample5);
        Button bt_item5 =  findViewById(R.id.bt_sample6);
        Button bt_item6 =  findViewById(R.id.bt_sample7);
        Button bt_item7 =  findViewById(R.id.bt_sample8);

        one = new clickOne(MainActivity.this);
        inte(bt_sample);
        inte(bt_item);
        inte(bt_item2);
        inte(bt_item3);
        inte(bt_item4);
        inte(bt_item5);
        inte(bt_item6);
        inte(bt_item7);
    }

    private void inte(Button bt_sample) {
        bt_sample.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_sample1:
                //加载对话框
                one.setDialog(1);
                break;
            case R.id.bt_sample2:
                one.setDialog(2);
                break;
            case R.id.bt_sample3:
                one.setDialog(3);
                break;
            case R.id.bt_sample4:
                one.setDialog(4);
                break;
            case R.id.bt_sample5:
                one.setDialog(5);
                break;
            case R.id.bt_sample6:
                one.setDialog(6);
                break;
            case R.id.bt_sample7:
                one.setDialog(7);
                break;
            case R.id.bt_sample8:
                one.setDialog(8);
                break;
        }

    }
}
