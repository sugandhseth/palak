package com.example.learn;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class coursedetails extends Fragment {
    String[] courseNames =
            {"Djanjo", "Mobile App", " Learn Php", "C language","Java","Java Script","Html","Python"};
    int vid =R.raw.msband;
    public coursedetails() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int value = getArguments().getInt("course");
        if (value==0){
            vid=R.raw.django1;
        }
        else if(value==7)
        {
            vid=R.raw.python1;
        }
        View myFragmentView =inflater.inflate(R.layout.fragment_coursedetails, container, false);
        Toast.makeText(getActivity(),"course details "+value+"", Toast.LENGTH_LONG).show();
        VideoView videoView=(VideoView) myFragmentView.findViewById(R.id.videoView2);
        MediaController mediaController=new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        String path="android.resource://"+ getActivity().getPackageName() +"/"+vid;
      //  Toast.makeText(get,path,Toast.LENGTH_LONG).show();
        Log.d("videopath",path);
        Uri uri= Uri.parse(path);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
       return myFragmentView;

    }
}
