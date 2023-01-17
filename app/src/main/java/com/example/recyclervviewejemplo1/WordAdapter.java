package com.example.recyclervviewejemplo1;

import android.database.StaleDataException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclervviewejemplo1.databinding.WordItemListBinding;

import java.util.List;

//3 EXTIENDO LA CLASE WORDADAPTER PARA IMPLEMENTAR RECYCLERVIEW.ADAPTER QUE CONTIENE LA CLASE INTERNA WORVIEWHOLDER
// 4 IMPLEMENTO METODOS
public class WordAdapter extends  RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    //1 AÑADIR LA REPRESENTACIÓN DE LOS DATOS
    private List<String> mWordlist;

    // METODO QUE RECIBE UNA LISTA DE NUMEROS PRIMOS PARA ENVIARLE LOS DATOS DESDE EL FRAGMENTO
    public WordAdapter(List<String> mWordlist) {
        this.mWordlist = mWordlist;
    }

    ///  ESTOS METODOS SE ENCARGAR UNO DE INICIALIZAR , EL OTRO COMUNICAR ADAPTER CON LA VISTA, TERCERO CONTAR EL TOTAL DE ELEMENTOS


    // ESTE METODO INICIALIZA LAS VISTAS

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }

    //7  RECIBE LOS DATOS ENVIADOS DESDE EL METODO QUE GENERA LOS DATOS Y LOS SETEA AL TEXVIEW

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String element = mWordlist.get(position);
        holder.textView.setText(element);

    }

    // RETORNA EL TAMAÑO DE LOS ELEMENTOS
    @Override
    public int getItemCount() {
        return mWordlist.size();
    }


    // 2. CREAR CLASE INTERNA QUE REPRESENTA LA VISTA WORD_ITEM_LIST.XML
    // INICIALIZAMO TEXVIEW QUE ES DENTRO DEL XML  Y LLAMAMOS MBINDING QUE ES DE LA CLASE XML QUE CONTIENE TEXVIEW
    public class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;


        }
    }

}
