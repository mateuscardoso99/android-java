package com.example.produtocrud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Produto p){
        ContentValues values = new ContentValues();
        values.put("descricao", p.getDescricao());
        values.put("preco", p.getPreco());
        values.put("qtd", p.getQtd());
        return banco.insert("produto", null, values);
    }

    public List<Produto> select(){
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produto", new String[]{"id","descricao","preco","qtd"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setDescricao(cursor.getString(1));
            p.setPreco(cursor.getDouble(2));
            p.setQtd(cursor.getInt(3));
            produtos.add(p);
        }
        return produtos;
    }

    public void update(Produto p){
        ContentValues values = new ContentValues();
        values.put("descricao", p.getDescricao());
        values.put("preco", p.getPreco());
        values.put("qtd", p.getQtd());
        banco.update("produto", values, "id = ?", new String[]{String.valueOf(p.getId())});
    }

    public void excluir(Produto p){
        banco.delete("produto", "id = ?", new String[]{String.valueOf(p.getId())});
    }
}
