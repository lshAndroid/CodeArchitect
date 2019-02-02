package lsh.com.codearchitect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    Button btnCotlin,btnMvp,btnHook,btnNdk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Timber.tag("宿主：MainActivity");

        setContentView(R.layout.activity_main);
        btnCotlin=findViewById(R.id.module_cotlin_bt);
        btnMvp=findViewById(R.id.module_mvp_bt);
        btnHook=findViewById(R.id.module_hook_bt);
        btnNdk=findViewById(R.id.module_ndk_bt);
        btnCotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("打印日志：Activity cotlin");
//                startActivity(new Intent(MainActivity.this,CotlinActivity.class));//普通跳转activity，组件化代码切换模式报错，强迫症患者可以选择下面方式
                String activityName="lsh.com.module_cotlin.CotlinActivity";
                reflectIntent(activityName);
            }
        });
        btnMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.i("打印日志：Activity MvpActivity");
//                startActivity(new Intent(MainActivity.this,MvpActivity.class));  //普通跳转activity，组件化代码切换模式报错，强迫症患者可以选择下面方式
                String activityName="lsh.com.module_mvp.MvpActivity";
                reflectIntent(activityName);
            }
        });
        btnNdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.i("打印日志：Activity NdkActivity");
//                startActivity(new Intent(MainActivity.this,NdkActivity.class));  //普通跳转activity，组件化代码切换模式报错，强迫症患者可以选择下面方式
                String activityName="lsh.com.ailinapp.NdkActivity";
                reflectIntent(activityName);
            }
        });
        btnHook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,HookActivity.class));  //方案一：普通跳转activity，组件化代码切换模式报错，强迫症患者可以选择下面方式
                String activityName="lsh.com.module_hook.HookActivity";  //方案二
                reflectIntent(activityName);
                //方案三：通过阿里巴巴开源的库ARouter实现跳转，为什么没放进来，复杂化代码，并且个人观点其规格要求多升级改动成本大
            }
        });


    }
    private void reflectIntent(String activityName){ //反射机制进行activity跳转，强迫症犯了，切换module/lib,不出红线
        try {
            Class clazz = Class.forName(activityName);
            Intent intent=new Intent(MainActivity.this,clazz);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
