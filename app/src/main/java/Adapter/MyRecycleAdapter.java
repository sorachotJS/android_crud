package Adapter;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidcrud.Models.UserModel;
import com.example.androidcrud.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.Holder>{
//    private String[] mDataSet;
    List<UserModel.Datum> mDataSet;
    public MyRecycleAdapter(List<UserModel.Datum> dataSet){
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member,parent,false);
        //send layout to method holder
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView txtId;
        TextView txtName;
        TextView txtposition;
        public Holder(View itemview) {
            super(itemview);
            //Binding id from xml to java
            txtId = itemview.findViewById(R.id.textMemberId);
            txtName = itemview.findViewById(R.id.textMemberName);
            txtposition = itemview.findViewById(R.id.textMemberPosition);
        }

        public void setItem(int position){
            txtId.setText(mDataSet.get(position).first_name);
            txtName.setText(mDataSet.get(position).last_name);
            txtposition.setText(mDataSet.get(position).email);

        }
    }
}
