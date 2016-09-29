package br.com.testes.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lista = (TextView)  findViewById(R.id.lista);
        ContentResolver cr =  getContentResolver();

        String[] colunas = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        String order = ContactsContract.Contacts.DISPLAY_NAME;
        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,colunas,null,null, order);
        startManagingCursor(c);

        String itens ="";

        if(c.moveToNext()){
            do {
                  String nome = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                  String fone = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                 itens +=nome+" "+fone+ "\n";

            }while (c.moveToNext());
        }
        Log.i("", itens);
       lista.setText(itens);


    }
}
