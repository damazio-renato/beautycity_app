package br.facens.helpcity.adapters.recyclerviews;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.facens.helpcity.R;
import br.facens.helpcity.models.Request;

public class AdapterRequest extends RecyclerView.Adapter<AdapterRequest.ViewHolder> {

    private Context context;
    private ArrayList<Request> requests;

    public AdapterRequest(Context context, ArrayList<Request> requests) {
        this.context = context;
        this.requests = requests;
    }

    @NonNull
    @Override
    public AdapterRequest.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_item, parent, false);
        return new AdapterRequest.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRequest.ViewHolder holder, int position) {
        Request request =requests.get(position);
        holder.ttvCategory.setText(request.getCategoria());
        holder.ttvDescription.setText(request.getDescricao());
        holder.ttvDateTime.setText(request.getData());
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ttvCategory;
        TextView ttvDateTime;
        TextView ttvDescription;
        ImageView imgPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ttvCategory = itemView.findViewById(R.id.ttvCategory);
            ttvDateTime = itemView.findViewById(R.id.ttvDateTime);
            ttvDescription = itemView.findViewById(R.id.ttvDescription);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
        }
    }
}
