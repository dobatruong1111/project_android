package com.example.pjctppm.trangchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pjctppm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Objects;

public class TrangChu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    NavigationView navigationView;

    ListView listView;
    menu_adapter adapter;
    ArrayList<item_navigation_view> list;

    // dialog
    Button add,cancel;
    TextInputEditText name_work;
    CheckBox check_person,check_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        AX();
        ActionMenu();
        actionToolBar();

        // set title
        //toolbar.setTitle("Trang Chủ");
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Trang Chủ");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        // xet tieu de tab
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_person_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_group_24);

    }


    private void ActionMenu(){
        list = new ArrayList<>();
        list.add(new item_navigation_view("Thêm Tài Khoản",R.drawable.ic_baseline_person_add_24));
        list.add(new item_navigation_view("Trang Chủ",R.drawable.ic_baseline_home_work_24));
        list.add(new item_navigation_view("Thẻ Của Tôi",R.drawable.ic_baseline_credit_card_24));
        list.add(new item_navigation_view("Cài Đặt",R.drawable.ic_baseline_settings_applications_24));
        list.add(new item_navigation_view("Đăng Xuất",R.drawable.ic_baseline_arrow_forward_ios_24));

        adapter = new menu_adapter(this,R.layout.item_navigation_view,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (position==4) {
                    Logout();
                } else if (position==3) {
                    onBackPressed();
                    startActivity(new Intent(TrangChu.this,CaiDat.class));
                }
            }
        });
    }

    private void Logout(){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setIcon(R.drawable.ic_baseline_arrow_forward_ios_24);
        alertDialog.setMessage("Bạn có muốn đăng xuất không ? ");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show(); // hiển thị dialog
    }

    private void actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_open_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_right,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_thongbao:
                startActivity(new Intent(TrangChu.this,ThongBao.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void AX(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        listView = (ListView) findViewById(R.id.list);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
    }
}