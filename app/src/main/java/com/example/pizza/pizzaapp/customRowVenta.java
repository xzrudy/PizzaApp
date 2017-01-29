package com.example.pizza.pizzaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customRowVenta extends ArrayAdapter<VentaRow> {

    private LayoutInflater layoutInf;
    private ArrayList<VentaRow> ventaRow;
    private int viewResourceId;

    public customRowVenta(Context _context, int _ViewResourceId, ArrayList<VentaRow> _ventaRow) {
        super(_context, _ViewResourceId, _ventaRow);
        this.ventaRow = _ventaRow;
        layoutInf = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewResourceId = _ViewResourceId;
    }

    public View getView (int _position, View _convertView, ViewGroup _parents) {
        _convertView = layoutInf.inflate(viewResourceId, null);

        VentaRow _ventaRow = ventaRow.get(_position);

        if (_ventaRow != null) {

            TextView idVenta = (TextView) _convertView.findViewById(R.id.textView1);
            TextView idUSer = (TextView) _convertView.findViewById(R.id.textView2);
            TextView ingredientes = (TextView) _convertView.findViewById(R.id.textView3);
            TextView size = (TextView) _convertView.findViewById(R.id.textView4);
            TextView cantidad = (TextView) _convertView.findViewById(R.id.textView5);
            TextView direccion = (TextView) _convertView.findViewById(R.id.textView6);
            TextView tipoPago = (TextView) _convertView.findViewById(R.id.textView7);
            TextView total = (TextView) _convertView.findViewById(R.id.textView8);
            TextView fechaVenta = (TextView) _convertView.findViewById(R.id.textView9);

            if (idVenta != null) {
                idVenta.setText(_ventaRow.getIdVenta());
            }

            if (idUSer != null) {
                idUSer.setText(_ventaRow.getIdUSer());
            }

            if (ingredientes != null) {
                ingredientes.setText(_ventaRow.getIngredientes());
            }

            if (size != null) {
                size.setText(_ventaRow.getSize());
            }

            if (cantidad != null) {
                cantidad.setText(_ventaRow.getCantidad());
            }

            if (direccion != null) {
                direccion.setText(_ventaRow.getDireccion());
            }

            if (tipoPago != null) {
                tipoPago.setText(_ventaRow.getTipoPago());
            }

            if (total != null) {
                total.setText(_ventaRow.getTotal());
            }

            if (fechaVenta != null) {
                fechaVenta.setText(_ventaRow.getFechaVenta());
            }

        }

        return _convertView;

    }


}
