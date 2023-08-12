//package com.example.myapplication;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//public class NairobiFragment extends Fragment {
//
//    public NairobiFragment() {
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.list_view, container, false);
//
//        ArrayList<Data> arrayList = new ArrayList<>();
//        ArrayList.add(new Data(getResources().getString(R.string.nairobi_place_1), getResources().getString(R.string.nairobi_detail_1),R.drawable.nairobi_national_park_6));
//        ArrayList.add(new Data(getResources().getString(R.string.nairobi_place_2), getResources().getString(R.string.nairobi_detail_2),R.drawable.nairobi_national_park_6));
//        ArrayList.add(new Data(getResources().getString(R.string.nairobi_place_3), getResources().getString(R.string.nairobi_detail_3),R.drawable.nairobi_national_park_6));
//        ArrayList.add(new Data(getResources().getString(R.string.nairobi_place_4), getResources().getString(R.string.nairobi_detail_4),R.drawable.nairobi_national_park_6));
//
//        DataAdapter dataAdapter = new DataAdapter(getActivity(), arrayList);
//
//        ListView listView = rootView.findViewById(R.id.listViewId);
//
//        listView.setAdapter(dataAdapter);
//
//        return rootView;
//    }
//
//}
