package com.app.aprendaingls.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.app.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonCao;
    private ImageButton buttonGato;
    private ImageButton buttonLeao;
    private ImageButton buttonOvelha;
    private ImageButton buttonVaca;
    private ImageButton buttonMacaco;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /* No fragment é diferente, pois não conseguimos acessar os componetes da view
        diretamente como no Activitvy_Main por isso usamovs  o objeto "view"*/

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao    = view.findViewById(R.id.imageCao);
        buttonGato   = view.findViewById(R.id.imageGato);
        buttonLeao    = view.findViewById(R.id.imageLeao);
        buttonMacaco = view.findViewById(R.id.imageMacaco);
        buttonOvelha = view.findViewById(R.id.imageOvelha);
        buttonVaca   = view.findViewById(R.id.imageVaca);

        //Aplicar eventos de click
        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
            break;
            case R.id.imageGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.imageLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.imageMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.imageOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.imageVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                   mp.release();
                }
            });
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
