package zack.twoactivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.ButtonAnother);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("StartAnotherActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });


        Button button2 = (Button) findViewById(R.id.btnCall);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"缺少打电话权限", Toast.LENGTH_SHORT).show();
                return;
            }
            String phonenumber = "13718367315";
            String encodedPhonenumber = null;
            try {
                encodedPhonenumber = URLEncoder.encode(phonenumber, "UTF-8");
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + encodedPhonenumber)));
        }
    });

        }
}
