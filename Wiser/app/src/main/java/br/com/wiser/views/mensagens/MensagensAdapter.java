package br.com.wiser.views.mensagens;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import br.com.wiser.R;
import br.com.wiser.models.mensagens.Mensagem;
import br.com.wiser.utils.Utils;
import br.com.wiser.utils.UtilsDate;

/**
 * Created by Jefferson on 30/05/2016.
 */
public class MensagensAdapter extends RecyclerView.Adapter<MensagensAdapter.ViewHolder> {

    private Context context;
    private List<Mensagem> mensagens = new LinkedList<>();

    private final int USUARIO = 0;
    private final int CONTATO = 1;

    public MensagensAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return (mensagens.get(position).isDestinatario() ? CONTATO : USUARIO);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView;

        if (viewType == USUARIO) {
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.chat_mensagens_baloes_usuario, parent, false);
        }
        else {
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.chat_mensagens_baloes_contato, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mensagem m = mensagens.get(position);
        holder.lblDataHora.setText(UtilsDate.formatDate(m.getData(), UtilsDate.HHMM));
        holder.lblMensagem.setText(Utils.decode(m.getMensagem().trim()));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public void setItems(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View linearlayout;
        public TextView lblDataHora;
        public TextView lblMensagem;

        public ViewHolder(View view) {
            super(view);

            linearlayout = (View) view.findViewById(R.id.linearlayout);
            lblDataHora = (TextView) view.findViewById(R.id.lblDataHora);
            lblMensagem = (TextView) view.findViewById(R.id.lblMensagem);
        }
    }
}
