package ntu.tanphat.bottomnavigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class WishlistFragment extends Fragment {
    LandScapeAdapter adapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandScape;
    public WishlistFragment() {
        // Required empty public constructor
    }
    public static WishlistFragment newInstance(String param1, String param2) {
        WishlistFragment fragment = new WishlistFragment();
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
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        //3
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
        dsDuLieu.add(new LandScape("ponagar", "Tháp bà Ponagar"));
        dsDuLieu.add(new LandScape("eiffel", "Tháp Eiffel"));
        dsDuLieu.add(new LandScape("van_ly_truong_thanh", "Vạn Lý Trường Thành"));
        dsDuLieu.add(new LandScape("buckingham", "Cung Điện Buckingham"));
        dsDuLieu.add(new LandScape("big_ben", "Tháp đồng hồ Big Ben"));
        return dsDuLieu;
    }
}