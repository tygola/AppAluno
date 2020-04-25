package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bd = openOrCreateDatabase("dbalunos", MODE_PRIVATE, null);

            bd.execSQL("CREATE TABLE IF NOT EXISTS tbalunos (nome VARCHAR,email VARCHAR,telefone VARCHAR)");

            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Tygola','tygola@gmail.com','50937085')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Tigas','tigas@gmail.com','50937852')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Tyler','tyler@gmail.com','50935585')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Timber','timber@hotmail.com','50938885')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Oliver','oliver@gmail.com','50787085')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Salah','Salah@gmail.com','55937085')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Lavi','lavi@hotmail..com','509370555')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Carlos','carlos@hotmail.com','45937085')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('Lamar','lamar@gmail.com','48937085')");
            bd.execSQL("INSERT INTO tbalunos(nome,email,telefone)VALUES('James','james@hotmail.com','45737055')");

            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbalunos", null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

