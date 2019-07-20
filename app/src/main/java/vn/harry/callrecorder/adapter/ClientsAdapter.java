package vn.harry.callrecorder.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.harry.callrecorder.R;
import vn.harry.callrecorder.response.ClientList.ResponseObjectItem;

/**
 * Created by Harry_Hai on 2/16/2018.
 */

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ViewHolder> {

    private String TAG = "ClientsAdapter";
    private List<ResponseObjectItem> clientList;
    private Context context;

    public ClientsAdapter(Context context, List<ResponseObjectItem> clientList) {
        this.context = context;
        this.clientList = clientList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_clients, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtKycName.setText(clientList.get(position).getKycaccountname());
        holder.txtKycCode.setText(clientList.get(position).getKycode());

    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    /**
     * The type View holder.
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtKycName, txtKycCode;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        ViewHolder(View itemView) {
            super(itemView);

            txtKycName = itemView.findViewById(R.id.txtKycName);
            txtKycCode = itemView.findViewById(R.id.txtKycCode);
        }
    }
}