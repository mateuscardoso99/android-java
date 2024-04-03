package com.example.produtocrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText descricao;
    private EditText preco;
    private EditText qtd;
    private Button btnsalvar;
    private Button btnlist;
    private ProdutoDAO dao;
    private Produto produto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        descricao = findViewById(R.id.txtDescr);
        preco = findViewById(R.id.txtPreco);
        qtd = findViewById(R.id.txtQtd);
        dao = new ProdutoDAO(this);

        Intent it = getIntent();
            if (it.hasExtra("produto")){
                produto = (Produto) it.getSerializableExtra("produto");
                descricao.setText(produto.getDescricao().toString());
                preco.setText(String.valueOf(produto.getPreco()));
                qtd.setText(String.valueOf(produto.getQtd()));
            }

        btnsalvar = findViewById(R.id.btnSalvar);
        btnlist = findViewById(R.id.btnListar);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    salvar();
                    descricao.setText("");
                    preco.setText("");
                    qtd.setText("");
                }catch (NumberFormatException e){
                    Toast.makeText(CadastroProdutoActivity.this, "preencha os campos", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListarProdutosActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void salvar(){

        if(produto == null) {
            produto = new Produto();
            produto.setDescricao(descricao.getText().toString());
            produto.setPreco(Double.parseDouble(preco.getText().toString()));
            produto.setQtd(Integer.parseInt(qtd.getText().toString()));
            long id = dao.inserir(produto);
            Toast.makeText(this, "Produto Inserido com o ID: " + id, Toast.LENGTH_SHORT).show();
        }else{
            produto.setDescricao(descricao.getText().toString());
            produto.setPreco(Double.parseDouble(preco.getText().toString()));
            produto.setQtd(Integer.parseInt(qtd.getText().toString()));
            dao.update(produto);
            Toast.makeText(this, "Produto Atualizado", Toast.LENGTH_SHORT).show();
        }
    }

}
