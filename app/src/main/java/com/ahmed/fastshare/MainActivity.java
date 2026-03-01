package com.ahmed.fastshare;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // تعريف عناصر الواجهة التي صممناها
    Button btnDiscover, btnSend, btnReceive;
    ListView listViewPeers;
    TextView tvStatus;

    // تعريف أدوات الواي فاي المباشر
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ربط هذا الكود بملف التصميم

        // ربط المتغيرات بالأزرار الموجودة في الشاشة
        btnDiscover = findViewById(R.id.btnDiscover);
        btnSend = findViewById(R.id.btnSend);
        btnReceive = findViewById(R.id.btnReceive);
        listViewPeers = findViewById(R.id.listViewPeers);
        tvStatus = findViewById(R.id.tvStatus);

        // تجهيز مدير الواي فاي
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);

        // برمجة زر "البحث عن أجهزة"
        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvStatus.setText("الحالة: جاري البحث عن أجهزة...");
                Toast.makeText(MainActivity.this, "بدأ البحث", Toast.LENGTH_SHORT).show();
                // هنا سيتم إضافة كود البحث الفعلي في الخطوات القادمة
            }
        });

        // برمجة زر "إرسال"
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "اختر الملف للإرسال", Toast.LENGTH_SHORT).show();
            }
        });

        // برمجة زر "استقبال"
        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "في انتظار استقبال الملفات...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
