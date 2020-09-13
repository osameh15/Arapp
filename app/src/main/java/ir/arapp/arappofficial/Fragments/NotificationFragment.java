package ir.arapp.arappofficial.Fragments;

import android.content.Context;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muddzdev.styleabletoast.StyleableToast;

import java.util.ArrayList;
import java.util.Objects;

import ir.arapp.arappofficial.Adapter.NotificationAdapter;
import ir.arapp.arappofficial.AppService.DrawerLocker;
import ir.arapp.arappofficial.Data.NotificationItem;
import ir.arapp.arappofficial.R;

public class NotificationFragment extends Fragment
{
    //Variables
    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        //Hooks
        recyclerView = view.findViewById(R.id.notificationRecyclerView);

        //RecyclerView
        //Layout manager for RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);
        //set Adapter
        notificationAdapter = new NotificationAdapter(getActivity().getApplicationContext());
        notificationAdapter.setData(getDataNotification());
        recyclerView.setAdapter(notificationAdapter);

        //Drawer layout
        ((DrawerLocker) Objects.requireNonNull(getActivity())).setDrawerLocked(true);

        return view;
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

    //check internet connection ...
    private boolean checkConnection()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) Objects.requireNonNull(getActivity()).getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (null != networkInfo)
        {
            return true;
        }
        else
        {
            StyleableToast.makeText(getActivity().getApplicationContext(), "عدم اتصال به اینترنت!", Toast.LENGTH_LONG, R.style.toastTheme).show();
            return false;
        }
    }

    //get notification Data
    private ArrayList<NotificationItem> getDataNotification()
    {
        ArrayList<NotificationItem> notificationItem = new ArrayList<>();
        notificationItem.add(new NotificationItem(R.drawable.arapp_news,"آراپ","به برنامه آراپ خوش آمدید","از اینکه آراپ را انتخاب کردید سپاسگزاریم. تمامی دوستان اینجا تمام توان خود را به کار خواهند گرفت تا بهترین ها را برای شما ایجاد کنند. به پاس قدردانی شما، گروه پشتیبانی آراپ به صورت 24 ساعته در خدمت رسانی به شما آماده است"));
        notificationItem.add(new NotificationItem(R.drawable.notification,"تخفیف ویژه!","50% تخفیف فقط تا پایان جمعه","تولیدی بهترین شامپو در ایران تا پایان روز جمعه سرویس های خود را با 50% تخفیف عرضه می کند. همین الآن اقدام کنید"));
        return notificationItem;
    }
}
