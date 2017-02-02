package br.com.wiser.models.login;

import br.com.wiser.models.usuario.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jefferson on 22/01/2017.
 */
public interface ILoginService {
    @POST("usuario/updateOrCreate")
    Call<Usuario> salvar(@Body Login login);
}
