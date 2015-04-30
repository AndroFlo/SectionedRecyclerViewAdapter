package com.sectionedrecyclerviewadapterom.github.androflo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.androflo.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import com.github.androflo.sectionedrecyclerviewadapter.Sectionizer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by faudigue on 30/04/2015.
 */
public class ActivityExample extends Activity implements Sectionizer {

    RecyclerView recyclerView ;
    List<AnimalObject> list ;
    SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_example);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewActivityExample);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        list = new ArrayList<>();
        list.add(new AnimalObject("Cat","Mammals"));
        list.add(new AnimalObject("Lion","Mammals"));
        list.add(new AnimalObject("Dog","Mammals"));
        list.add(new AnimalObject("Monkey","Mammals"));
        list.add(new AnimalObject("Puma","Mammals"));

        list.add(new AnimalObject("Albatross","Birds"));
        list.add(new AnimalObject("Pigeon","Birds"));

        list.add(new AnimalObject("Crabs","Aquatic Animals"));
        list.add(new AnimalObject("Sharks","Aquatic Animals"));

        MyAdapter myAdapter = new MyAdapter();


        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter(getApplicationContext(),
                R.layout.layout_list_section, R.id.textViewItemSection, myAdapter, this);
        sectionedRecyclerViewAdapter.setSections(list);

        recyclerView.setAdapter(sectionedRecyclerViewAdapter);

    }


    @Override
    public String getSectionTitle(Object object) {
        return ((AnimalObject)object).type;
    }


    //--------------- ViewHolder-----------------------
    private static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title ;
        ViewHolderClickListener clickListener ;

        public MyViewHolder(View itemView,ViewHolderClickListener clickListener ) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textViewItemList);
            this.clickListener = clickListener ;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (clickListener != null)
                clickListener.onClick(v);

        }

        public interface ViewHolderClickListener{
            public void onClick(View v);
        }
    }

    //-------------------Adapter----------------------------
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements MyViewHolder.ViewHolderClickListener {

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.layout_list_item, parent, false);

            return new MyViewHolder(itemView,this);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            AnimalObject animalObject = list.get(position);

            holder.title.setText(animalObject.name);

        }

        @Override
        public void onClick(View v) {

            Toast.makeText(getApplicationContext(), list.get(sectionedRecyclerViewAdapter.getIndexForPosition(recyclerView.getChildPosition(v))).name,Toast.LENGTH_SHORT).show();

        }
    }
}
