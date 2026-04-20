package thigk2.huynhtanphat.baithigk2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cau3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cau3Fragment extends Fragment {
    LandScapeAdapter adapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandScape;
    public Cau3Fragment() {
        // Required empty public constructor
    }
    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau3, container, false);
        recyclerViewDatas = getDataForRecyclerview();
        //4
        recyclerViewLandScape = view.findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(view.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);
//        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewLandScape.setLayoutManager(layoutLinearHorizonal);
//        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(view.getContext(), 2);
//        recyclerViewLandScape.setLayoutManager(layoutGrid);
        //6
        adapter = new LandScapeAdapter(view.getContext(), recyclerViewDatas);
        recyclerViewLandScape.setAdapter(adapter);
        return view;
    }
    ArrayList<LandScape> getDataForRecyclerview(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        dsDuLieu.add(new LandScape("hungdao", "Trần Hưng đạo", "21/09/2005"));
        dsDuLieu.add(new LandScape("tutrong", "Lý Tự trọng", "09/09/2005"));
        dsDuLieu.add(new LandScape("phanboichau", "Phan Bội Châu", "04/12/2024"));
        dsDuLieu.add(new LandScape("phanchutrinh", "Phan Chu Trinh", "11/07/2025"));
        dsDuLieu.add(new LandScape("nguyenchanh", "Nguyễn Chánh", "09/04/2026"));
        return dsDuLieu;

    }
}