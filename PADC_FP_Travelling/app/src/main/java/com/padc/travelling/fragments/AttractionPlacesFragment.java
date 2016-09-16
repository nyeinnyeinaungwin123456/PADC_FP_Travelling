package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.AttractionPlacesAdapter;
import com.padc.travelling.data.vos.AttractionPlacesVO;
import com.padc.travelling.view.AttractionPlacesViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionPlacesFragment extends Fragment {

    private List<AttractionPlacesVO> attractionPlacesVOList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AttractionPlacesAdapter attractionPlacesAdapter;
    private AttractionPlacesViewHolder.ControllerAttractionPlaces mControllerAttracionPlaces;

    //static factory method
    public static AttractionPlacesFragment newInstance(){
        AttractionPlacesFragment fragment =  new AttractionPlacesFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerAttracionPlaces = (AttractionPlacesViewHolder.ControllerAttractionPlaces)context;
    }

    public AttractionPlacesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractionplaces, container, false);

        prepareAttractionPlacesData();

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        attractionPlacesAdapter = new AttractionPlacesAdapter(attractionPlacesVOList, mControllerAttracionPlaces);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(attractionPlacesAdapter);

        return view;
    }

    public void prepareAttractionPlacesData(){

        AttractionPlacesVO attractionPlacesVO;

        for(int i=0; i<20; i++) {
            attractionPlacesVO = new AttractionPlacesVO(R.drawable.yangon_shwedagonpagoda, "ရန္ကုန္",
                    "ကမာၻေပၚရွိ အျမင့္ဆံုး ဘုရားေစတီမွာ ၃၂၆-ေပရွိေသာ ေရႊတိဂံု ေစတီေတာ္ ပင္ျဖစ္ၿပီး ရန္ကုန္ၿမိဳ႕ရွိ သိဂၤုတၱရ ကုန္းေတာ္ေပၚတြင္ တည္ရွိသည္။ ေလးဆူ ဓာတ္ပံု ေရႊတိဂံု ဟုလည္း ေခၚတြင္သည္။ ေစတီအစ ေရႊတိဂံုက ဟုဆိုၾက သည္။",
                    R.drawable.yangon_shwedagonpagoda, "ေရႊတိဂံုဘုရား", "ကမာၻေပၚရွိ အျမင့္ဆံုး ဘုရားေစတီမွာ ၃၂၆-ေပရွိေသာ ေရႊတိဂံု ေစတီေတာ္ ပင္ျဖစ္ၿပီး ရန္ကုန္ၿမိဳ႕ရွိ သိဂၤုတၱရ ကုန္းေတာ္ေပၚတြင္ တည္ရွိသည္။ ေလးဆူ ဓာတ္ပံု ေရႊတိဂံု ဟုလည္း ေခၚတြင္သည္။ ေစတီအစ ေရႊတိဂံုက ဟုဆိုၾက သည္။",
                    R.drawable.dala, "ဒလ", "ကမာၻေပၚရွိ အျမင့္ဆံုး ဘုရားေစတီမွာ ၃၂၆-ေပရွိေသာ ေရႊတိဂံု ေစတီေတာ္ ပင္ျဖစ္ၿပီး ရန္ကုန္ၿမိဳ႕ရွိ သိဂၤုတၱရ ကုန္းေတာ္ေပၚတြင္ တည္ရွိသည္။ ေလးဆူ ဓာတ္ပံု ေရႊတိဂံု ဟုလည္း ေခၚတြင္သည္။ ေစတီအစ ေရႊတိဂံုက ဟုဆိုၾက သည္။");
            attractionPlacesVOList.add(attractionPlacesVO);
        }
    }
}
