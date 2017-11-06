package com.example.dongato.navigationdrawer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by dongato on 11/6/17.
 */

public class MultiplicacionFragment extends Fragment{

    TextView resultado;
    EditText num_uno;
    EditText num_dos;
    Button calcular;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiplicacion,container,false);

        resultado = (TextView) view.findViewById(R.id.fm_resultado);
        num_uno = (EditText) view.findViewById(R.id.fm_num_uno);
        num_dos = (EditText) view.findViewById(R.id.fm_num_dos);
        calcular = (Button) view.findViewById(R.id.fm_calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(num_uno.getText().toString());
                int y = Integer.parseInt(num_dos.getText().toString());

                resultado.setText(String.valueOf(x*y));

            }
        });

        return view;
    }
}
