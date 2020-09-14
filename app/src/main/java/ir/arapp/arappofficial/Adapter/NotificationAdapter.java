package ir.arapp.arappofficial.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import ir.arapp.arappofficial.Data.NotificationItem;
import ir.arapp.arappofficial.R;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationAdapterHolder>
{
    //Variables
    private Context mContext;
    private ArrayList<NotificationItem> notificationItems;

    //Constructor
    public NotificationAdapter(Context mContext)
    {
        this.mContext = mContext;
    }

    //Set data in notification
    public void setData(ArrayList<NotificationItem> data)
    {
        this.notificationItems = data;
        notifyDataSetChanged();
    }

    //Holder for adapter
    @NonNull
    @Override
    public NotificationAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_message_listview, parent, false);
        return new NotificationAdapterHolder(view);
    }

    //inflate content view
    @Override
    public void onBindViewHolder(@NonNull NotificationAdapterHolder holder, int position)
    {
        NotificationItem notificationItem = notificationItems.get(position);
        if (notificationItem == null)
        {
            return;
        }
        holder.messageImageContent.setImageResource(notificationItem.getImage());
        holder.messageTitle.setText(notificationItem.getTitle());
        holder.messageSubtitle.setText(notificationItem.getSubtitle());
        holder.messageSubtitleContent.setText(notificationItem.getSubtitle());
        holder.messageTextContent.setText(notificationItem.getText());
        holder.foldingCell.setOnClickListener(v -> holder.foldingCell.toggle(false));
    }

    //Get item count
    @Override
    public int getItemCount()
    {
        if (notificationItems == null)
        {
            return 0;
        }
        else
        {
            return notificationItems.size();
        }
    }

    //Notification adapter holder
    static class NotificationAdapterHolder extends RecyclerView.ViewHolder
    {
        private FoldingCell foldingCell;
        private RoundedImageView messageImage;
        private RoundedImageView messageImageContent;
        private TextView messageTitle;
        private TextView messageSubtitle;
        private TextView messageTextContent;
        private TextView messageSubtitleContent;

        NotificationAdapterHolder(@NonNull View itemView)
        {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.foldingCell);
            messageImage = itemView.findViewById(R.id.messageImage);
            messageImageContent = itemView.findViewById(R.id.messageImageContent);
            messageTitle = itemView.findViewById(R.id.messageTitle);
            messageSubtitle = itemView.findViewById(R.id.messageSubtitle);
            messageTextContent = itemView.findViewById(R.id.messageTextContent);
            messageSubtitleContent = itemView.findViewById(R.id.messageSubtitleContent);
        }
    }
}
