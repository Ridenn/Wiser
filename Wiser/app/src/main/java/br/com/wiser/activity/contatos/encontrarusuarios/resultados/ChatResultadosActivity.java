package br.com.wiser.activity.contatos.encontrarusuarios.resultados;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.LinkedList;

import br.com.wiser.R;
import br.com.wiser.business.app.usuario.Usuario;
import br.com.wiser.dialogs.DialogPerfilUsuario;

/**
 * Created by Jefferson on 31/03/2016.
 */
public class ChatResultadosActivity extends Activity {

    private GridView grdResultado = null;
    private ChatResultadosAdapter objCustomGridAdapter = null;
    private LinkedList<Usuario> listaUsuarios = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contatos_encontrar_usuarios_resultados);

        final DialogPerfilUsuario perfil = new DialogPerfilUsuario();

        getActionBar().setDisplayHomeAsUpEnabled(true);

        listaUsuarios = new LinkedList<Usuario>((ArrayList<Usuario>) getIntent().getBundleExtra("listaUsuarios").get("listaUsuarios"));
        grdResultado = (GridView) findViewById(R.id.grdResultado);

        carregar();

        grdResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                perfil.show(ChatResultadosActivity.this, listaUsuarios.get(position));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private void carregar(){
        objCustomGridAdapter = new ChatResultadosAdapter(this, R.layout.contatos_encontrar_pessoas_resultados_grid, listaUsuarios);
        grdResultado.setAdapter(objCustomGridAdapter);
    }
}