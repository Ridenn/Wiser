package br.com.wiser.business.chat.conversas;

import android.content.Context;

import java.util.LinkedList;

import br.com.wiser.business.app.servidor.Servidor;
import br.com.wiser.business.app.usuario.Usuario;
import br.com.wiser.business.chat.mensagem.Mensagem;

public class ConversasDAO extends Conversas {

    public boolean carregarGeral(Context context, LinkedList<ConversasDAO> conversas) {
        return new Servidor().new Chat(context).carregarGeral(conversas);
    }

    public boolean enviarMensagem(Context context, Mensagem mensagem) {
        return new Servidor().new Chat(context).enviarMensagem(this, getDestinatario().getUserID(), mensagem);
    }

    public void atualizarLidas(Context context) {
        new Servidor().new Chat(context).atualizarLidas(this);
    }
}