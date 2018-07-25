package com.example.akerke.technodom_survey.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akerke.technodom_survey.R;
import com.example.akerke.technodom_survey.db.model.ClientModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClientData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ClientModel> clientModels = new ArrayList<>();
    private ClientData.OnDeleteListener onDeleteListener;
    private Context context;

    public ClientData(Context context, List<ClientModel> dataModels) {
        this.context = context;
        this.clientModels = dataModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client_data, parent, false);
        return new ClientData.NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ClientData.NewsViewHolder viewHolder = (ClientData.NewsViewHolder) holder;
        viewHolder.name.setText(clientModels.get(position).getName());
        viewHolder.number.setText(clientModels.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return clientModels.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        public TextView name;
        @BindView(R.id.number)
        public TextView number;
        @BindView(R.id.delete)
        public TextView delete;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(clientModels.get(getAdapterPosition()));
                clientModels.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });
        }
    }

    public void setOnDeleteListener(ClientData.OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public interface OnDeleteListener {
        void onDelete(ClientModel clientModel);
    }
}
