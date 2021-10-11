package com.secondwarranty.app.Dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.drjacky.imagepicker.ImagePicker;
import com.google.android.material.navigation.NavigationView;
import com.secondwarranty.app.Adapter.HomeApplianceAdapter;
import com.secondwarranty.app.Adapter.IndustryApplianceAdapter;
import com.secondwarranty.app.Adapter.SliderAdapter;
import com.secondwarranty.app.BottomNavigation.BookingActivity;
import com.secondwarranty.app.BottomNavigation.ProfileActivity;
import com.secondwarranty.app.LoginAndSignUp.LoginActivity;
import com.secondwarranty.app.R;
import com.secondwarranty.app.ResponseModel.DashboardProfileImage.Result;
import com.secondwarranty.app.ResponseModel.HomePageProducts.BannerDatum;
import com.secondwarranty.app.ResponseModel.HomePageProducts.Subcategorydatum;
import com.secondwarranty.app.ResponseModel.SideNavDetails.Userdetails;
import com.secondwarranty.app.ViewModel.DataViewModel;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String APP_NAME = "Second Warranty";
    SliderView sliderView;
    RecyclerView.Adapter adapter;
    RecyclerView homeApplianceRecycler, industryApplianceRecycler;
    SmoothBottomBar bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;
    Button logout;
    CircleImageView circular_img;
    DataViewModel dataViewModel;
    String profile = "";
    TextView name_txt,txt_mobile_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViwes();
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);


        circular_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(DashboardActivity.this)
                        .crop()
                        .cropOval()
                        .maxResultSize(1080, 1080)
                        .start(0);
            }
        });

        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            switch (i) {

                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), BookingActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent2);
                    break;
            }

            return true;
        });


        homeAppliance();
        industryAppliance();
        navigationdrawer();
        side_nav_details();
//        updateProfilePic();

    }

//    private void updateProfilePic() {
//
//        dataViewModel.getCustomerDetail(getApplicationContext())
//                .observe(this, new Observer<Result>() {
//                    @Override
//                    public void onChanged(com.secondwarranty.app.ResponseModel.SideNavDetails.Result result) {
//
//                        if (result != null) {
//
//                        }
//
//
//                    }
//                });
//    }

    private void side_nav_details() {

        dataViewModel.getCustomerDetail(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.SideNavDetails.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.SideNavDetails.Result result) {

                        if (result != null) {

                            Userdetails userdetails = result.getUserdetails();
                            name_txt.setText(userdetails.getUsersName());
                            txt_mobile_no.setText(String.valueOf(userdetails.getUsersMobile()));

                        }
                    }
                });
    }

    private void initViwes() {
        sliderView = findViewById(R.id.slider_image);
        homeApplianceRecycler = findViewById(R.id.recycler_home_applicanes);
        industryApplianceRecycler = findViewById(R.id.recycler_industry_appliances);
        drawerLayout = findViewById(R.id.drawer_layout);
        imageView = findViewById(R.id.menu);
        navigationView = findViewById(R.id.navigation_view);
        logout = findViewById(R.id.logout_btn);
        circular_img = findViewById(R.id.circular_img);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        View navHeaderView=navigationView.getHeaderView(0);
        name_txt=  navHeaderView.findViewById(R.id.name_txt);
        txt_mobile_no=navHeaderView.findViewById(R.id.txt_mobile_no);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            Uri uri = data.getData();
            profile = String.valueOf(uri);
            circular_img.setImageURI(uri);


        }
    }

    private void navigationdrawer() {

        //navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.partner);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_SHORT).show();
                }
                else {
                    drawerLayout.openDrawer(GravityCompat.START);
                    Toast.makeText(getApplicationContext(), "Open", Toast.LENGTH_SHORT).show();



            }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share_second_warranty:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Second Warranty\nThe perfect online solution for installment and repair of your electronic appliances";
                String shareSubject = "abc ";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.rate_second_warranty:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_NAME)));
                break;


            case R.id.about_second_warranty:
                Intent intent1 = new Intent(getApplicationContext(), About_Us.class);
                startActivity(intent1);
                break;

            case R.id.help_centre:
                Intent intent2 = new Intent(getApplicationContext(), HelpCentreActivity.class);
                startActivity(intent2);
                break;

            case R.id.schedule_second_warranty:
                Intent intent3 = new Intent(getApplicationContext(), FanActivity.class);
                startActivity(intent3);
                break;

            case R.id.setting_second_warranty:
                Intent intent4 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent4);
                break;


        }
        return true;
    }


    private void industryAppliance() {

        dataViewModel.getHomeDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.HomePageProducts.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.HomePageProducts.Result result) {

                        if (result != null) {
                            industryApplianceRecycler.setHasFixedSize(true);
                            industryApplianceRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                            List<Subcategorydatum> subcategorydata = result.getCategorydata().get(1).getSubcategorydata();
                            Log.e("HomePageResponse", "Response: " + subcategorydata.size());
                            adapter = new IndustryApplianceAdapter(subcategorydata, getApplicationContext());
                            industryApplianceRecycler.setAdapter(adapter);
                        }
                    }
                });
    }

    private void homeAppliance() {

        dataViewModel.getHomeDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.HomePageProducts.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.HomePageProducts.Result result) {

                        if (result != null) {
                            List<BannerDatum> bannerDatum = result.getBannerData();
                            SliderAdapter sliderAdapter = new SliderAdapter(bannerDatum, getApplicationContext());
                            sliderView.setSliderAdapter(sliderAdapter);
                            sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                            sliderView.setScrollTimeInSec(3);
                            sliderView.setAutoCycle(true);
                            sliderView.startAutoCycle();
                        }

                        homeApplianceRecycler.setHasFixedSize(true);
                        homeApplianceRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                        List<Subcategorydatum> categorydata = result.getCategorydata().get(0).getSubcategorydata();
                        Log.e("HomePageResponse", "Response: " + categorydata.size());
                        adapter = new HomeApplianceAdapter(categorydata, getApplicationContext());
                        homeApplianceRecycler.setAdapter(adapter);
                    }
                });
    }


    public void logout_button(View view) {
        logout_successful();
    }


    //  Logout Api
    private void logout_successful() {

        dataViewModel.getLogoutDetails(getApplicationContext())
                .observe(this, new Observer<com.secondwarranty.app.ResponseModel.Logout.Result>() {
                    @Override
                    public void onChanged(com.secondwarranty.app.ResponseModel.Logout.Result result) {

                        if (result != null) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                            builder.setTitle("Second Warranty");
                            builder.setMessage("Are you sure you want to exit ?");
                            builder.setCancelable(false);
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent1);
                                    finish();

                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            builder.create().show();
                        }
                    }
                });
    }




}

