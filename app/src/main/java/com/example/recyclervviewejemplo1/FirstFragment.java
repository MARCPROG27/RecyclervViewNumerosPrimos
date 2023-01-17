package com.example.recyclervviewejemplo1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclervviewejemplo1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    // CREAMOS UN LIST QUE ME REPRESENTARA LOS DATOS

    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // PARA PROBAR QUE HAY DATOS
        //  Log.d("Listado",setData().toString());

        // INSTANCIAR EL ADAPTER Y LE PASAMOS LOS DATOS CON EL METODO PALABRAS
        WordAdapter adapter = new WordAdapter(setData());
        // LE PASAMOS EL ADAPTER AL RECYCLER VIEW
        binding.recyclerView.setAdapter(adapter);
        // le indicamos al RV COMO MOSTRAR LOS ELEMENTOS . PODRIA SER GRIDLAYOUT. STAGGEREDALAYOUT
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Integer f;
                Integer contador, cadena;
                contador = 0;

                //SE OBTIENE Nº POSICION ACTUAL DEL LISTADO
                cadena = dataList.size();

                // SE SUMA POSICION ACTUAL DEL LISTADO CON NUMERO PARA QUE RESULTADO SEA IGUAL A 501

                f = cadena + 251;


                // ETAPA 2 :DESDE 501 A INFINITO, SE OBTIENEN NUMEROS PRIMOS CON CICLO DO WHILE
                //HACIENDO CLIC EN BOTON.

                do {
                    dataList.add("NUMERO IMPAR " + f.toString());
                    f += 2;

                    contador += 1;

                } while (contador < 10);


                binding.recyclerView.getAdapter().notifyItemInserted(dataList.size());

                binding.recyclerView.smoothScrollToPosition(dataList.size());

            }


        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //METODO PARA GENERAR  NUMEROS PRIMOS DESDE 1 A 499 ETAPA1

    private List<String> setData() {
        Integer h;
        for (int i = 0; i < 500; i++) {
            h = i % 2;    //AQUI OBTENEMOS EL RESTO DE LA DIVISION
            // SI ES 0 ES PAR SI ES 1 IMPAR
            if (h == 1) {

                dataList.add("NUMERO IMPAR :" + i);
            }


        }
        return dataList;
    }


}