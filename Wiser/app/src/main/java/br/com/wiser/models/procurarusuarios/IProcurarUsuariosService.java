package br.com.wiser.models.procurarusuarios;

import java.util.LinkedList;
import java.util.Map;

import br.com.wiser.models.usuario.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Jefferson on 23/01/2017.
 */
public interface IProcurarUsuariosService {
    @GET("usuario/procurarUsuarios")
    Call<LinkedList<Usuario>> procurarUsuarios(@QueryMap Map<String, String> parametros);
}
