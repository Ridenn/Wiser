package br.com.wiser.views;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.wiser.R;

/**
 * Created by Jefferson on 23/01/2017.
 */
public abstract class AbstractFragment extends Fragment implements IView {

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(getContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    public void showSnackBar(final View view, final String mensagem) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public void showSnackBarImage(View view, String mensagem, Bitmap imagem) {
        Snackbar snackBar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackBar.getView();

        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        View snackView = LayoutInflater.from(getContext()).inflate(R.layout.snackbar_imagem, null);
        ImageView imageView = (ImageView) snackView.findViewById(R.id.image);
        imageView.setImageBitmap(imagem);
        TextView textViewTop = (TextView) snackView.findViewById(R.id.text);
        textViewTop.setText(mensagem);
        textViewTop.setTextColor(Color.WHITE);

        layout.addView(snackView, 0);
        snackBar.show();
    }
}