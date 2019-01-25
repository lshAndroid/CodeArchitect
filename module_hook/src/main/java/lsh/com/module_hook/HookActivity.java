package lsh.com.module_hook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HookActivity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook);

        mButton = findViewById(R.id.btn_test);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"我是正常的",Toast.LENGTH_LONG).show();
            }
        });

        //hook OnClickListener,在执行点击之前干了一些自己的坏事
        HookUtils.hookOnclick(this,mButton);//注意：hook是替换原有，也就是放在后面
    }
}
