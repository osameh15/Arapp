package ir.arapp.arappofficial.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.makeramen.roundedimageview.RoundedImageView;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.Objects;

import ir.arapp.arappofficial.Activities.DetailActivity;
import ir.arapp.arappofficial.Activities.ServiceActivity;
import ir.arapp.arappofficial.AppService.DrawerLocker;
import ir.arapp.arappofficial.R;

public class CategoryFragment extends Fragment implements View.OnClickListener
{
    //Variables
    private RoundedImageView restaurant;
    private RoundedImageView fastFood;
    private RoundedImageView cafe;
    private RoundedImageView hotel;
    private RoundedImageView restRoom;
    private RoundedImageView shopCenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        //Hooks
        restaurant = view.findViewById(R.id.restaurant_category);
        fastFood = view.findViewById(R.id.fastFood_category);
        cafe = view.findViewById(R.id.cafe_category);
        hotel = view.findViewById(R.id.hotel_category);
        restRoom = view.findViewById(R.id.restRoom_category);
        shopCenter = view.findViewById(R.id.shopCenter_category);

        //Drawer layout
        ((DrawerLocker) Objects.requireNonNull(getActivity())).setDrawerLocked(true);

        //OnClick
        restaurant.setOnClickListener(this);
        fastFood.setOnClickListener(this);
        cafe.setOnClickListener(this);
        hotel.setOnClickListener(this);
        restRoom.setOnClickListener(this);
        shopCenter.setOnClickListener(this);

        return  view;
    }

    //To hide toolbar
    @Override
    public void onResume()
    {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).hide();
    }

    //Destroy fragment
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ((DrawerLocker) Objects.requireNonNull(getActivity())).setDrawerLocked(false);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).show();
    }

    @Override
    public void onClick(View view)
    {
        Intent categoryIntent = new Intent(getActivity(), ServiceActivity.class);
        switch (view.getId())
        {
            case R.id.restaurant_category:
                categoryIntent.putExtra("name", "رستوران");
                startActivity(categoryIntent);
                break;
            case R.id.fastFood_category:
                categoryIntent.putExtra("name", "فست فود");
                startActivity(categoryIntent);
                break;
            case R.id.cafe_category:
                categoryIntent.putExtra("name", "کافه");
                startActivity(categoryIntent);
                break;
            case R.id.hotel_category:
                categoryIntent.putExtra("name", "هتل");
                startActivity(categoryIntent);
                break;
            case R.id.restRoom_category:
                categoryIntent.putExtra("name", "مسافرخانه");
                startActivity(categoryIntent);
                break;
            case R.id.shopCenter_category:
                categoryIntent.putExtra("name", "مراکز خرید");
                startActivity(categoryIntent);
                break;
            default:
                break;
        }
    }
}

/*
Transformation transformation = new RoundedTransformationBuilder()
          .borderColor(Color.BLACK)
          .borderWidthDp(3)
          .cornerRadiusDp(30)
          .oval(false)
          .build();

Picasso.with(context)
    .load(url)
    .fit()
    .transform(transformation)
    .into(imageView);
 */
