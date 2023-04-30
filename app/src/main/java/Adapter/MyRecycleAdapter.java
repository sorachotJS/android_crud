package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidcrud.R;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.Holder>{
    private String[] mDataSet;
    public MyRecycleAdapter(String[] dataSet){
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
        return mDataSet.length;
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
            txtId.setText(mDataSet[position]);
            txtName.setText("index = "+position);
            txtposition.setText("CEO");
        }
    }
}
