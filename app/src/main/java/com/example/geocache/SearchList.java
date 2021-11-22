package com.example.geocache;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class SearchList extends Fragment {

    private ArrayAdapter<String> arrayAdapter;
    private String[] names;
    private ListView lView;
    private SearchView sView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment =  inflater.inflate(R.layout.fragment_search_list, container, false);


        lView = (ListView) fragment.findViewById(R.id.search_list);
        sView = (SearchView) getActivity().findViewById(R.id.main_search);
        names = getResources().getStringArray(R.array.cahce_locations);



        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, names);
        lView.setAdapter(arrayAdapter);

        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sView.setIconified(true);
            }
        });
        return fragment;
    }
}