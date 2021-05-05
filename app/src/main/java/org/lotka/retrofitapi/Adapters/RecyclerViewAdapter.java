package org.lotka.retrofitapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.lotka.retrofitapi.Module.StandardJsonModule;
import org.lotka.retrofitapi.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewholderClass> {

    List<StandardJsonModule> mList ;
    Context mcontext;
    public final String photoPreURL = "https://s1.cdin.ir/dir/json/json_examples/photos/";
    public RecyclerViewAdapter(List<StandardJsonModule> moduleList , Context mcontext){
        mList= moduleList ;
        this.mcontext=mcontext ;

    }

    @NonNull
    @Override
    public ViewholderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cus ,parent ,false);
        ViewholderClass viewholderClass= new ViewholderClass(v);
        return viewholderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderClass holder, int position) {
        holder.textView.setText(mList.get(position).getName());
        Glide.with(mcontext).load(photoPreURL+mList.get(position).getPhoto())
                .circleCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewholderClass extends RecyclerView.ViewHolder{
        TextView textView ;
        ImageView imageView ;
        public ViewholderClass(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
