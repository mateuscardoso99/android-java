package com.example.produtocrud;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    private List<Produto> produtos;
    private Activity activity;

    public ProdutoAdapter(Activity activity, List<Produto> produtos) {
        this.activity = activity;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return produtos.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item, parent, false);
        TextView descricao = v.findViewById(R.id.txtNomeExibir);
        TextView preco = v.findViewById(R.id.txtPrecoExibir);
        TextView qtd = v.findViewById(R.id.txtQtdExibir);

        Produto prod = produtos.get(position);

        descricao.setText(prod.getDescricao());
        preco.setText(String.valueOf(prod.getPreco()));
        qtd.setText(String.valueOf(prod.getQtd()));

        return v;
    }
}
