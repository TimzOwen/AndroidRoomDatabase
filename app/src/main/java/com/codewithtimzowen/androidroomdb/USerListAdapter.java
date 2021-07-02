package com.codewithtimzowen.androidroomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithtimzowen.androidroomdb.database.User;

import org.w3c.dom.ls.LSInput;

import java.util.List;

public class USerListAdapter extends RecyclerView.Adapter<USerListAdapter.myViewHolder> {

    private Context context;
    private List<User> userList;

    public USerListAdapter(Context context){
        this.context = context;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public USerListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);

        return new  myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull USerListAdapter.myViewHolder holder, int position) {

        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);

    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;

        public myViewHolder(View view){
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstNameRow);
            tvLastName = view.findViewById(R.id.tvLastNameRow);
        }
    }
}
