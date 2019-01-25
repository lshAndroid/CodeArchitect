package lsh.com.module_cotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cotlin.*

class CotlinActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotlin)
        btn_tv.setOnClickListener {
            Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show();
        }


    }






}
