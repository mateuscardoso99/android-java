package com.example.produtocrud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListarProdutosActivity extends AppCompatActivity {

    private ListView listView;
    private ProdutoDAO dao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listView = findViewById(R.id.lista_produtos);

        dao = new ProdutoDAO(this);
        produtos = dao.select();
        produtosFiltrados.addAll(produtos);
        //ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtosFiltrados);
        ProdutoAdapter adaptador = new ProdutoAdapter(this, produtosFiltrados);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s){
                procuraProduto(s);
                return false;
            }
        });

        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }

    public void procuraProduto(String nome){
        produtosFiltrados.clear();
        for(Produto p : produtos){
            if(p.getDescricao().toLowerCase().contains(nome.toLowerCase())){
                produtosFiltrados.add(p);
            }
        }
        listView.invalidateViews();
    }

    public void cadastrar(MenuItem item){
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void update(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Produto prodUpdate = produtosFiltrados.get(menuInfo.position);

        Intent inter = new Intent(this, CadastroProdutoActivity.class);
        inter.putExtra("produto", prodUpdate);
        startActivity(inter);
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Produto prodExcluir = produtosFiltrados.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atenção").setMessage("Excluir o produto?")
                .setNegativeButton("NÃO", null).setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        produtosFiltrados.remove(prodExcluir);
                        produtos.remove(prodExcluir);
                        dao.excluir(prodExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    @Override
    public void onResume(){
        super.onResume();
        produtos = dao.select();
        produtosFiltrados.clear();
        produtosFiltrados.addAll(produtos);
        listView.invalidateViews();
    }
}
