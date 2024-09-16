package br.unipar.atividadeadapters01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtResultadoNome = findViewById<EditText>(R.id.txtResultadoNome)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtResultadoArea = findViewById<EditText>(R.id.txtResultadoArea)
        val btnZerar = findViewById<Button>(R.id.btnZerar)
        val txtResultadoAlunos = findViewById<TextView>(R.id.txtResultadoAlunos)

    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/txtNome"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nome Aluno:" />

        <EditText
            android:id="@+id/txtResultadoNome"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text" />

        <TextView
            android:id="@+id/txtArea"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Área de Escolha:" />

        <EditText
            android:id="@+id/txtResultadoArea"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="text" />

        <ListView
            android:layout_width="wrap_content"
            android:layout_height="365dp">

        </ListView>

    </LinearLayout>

    <Button
        android:id="@+id/btnInserir"
        android:layout_width="122dp"
        android:layout_height="47dp"
        android:text="Inserir"
        tools:layout_editor_absoluteX="211dp"
        tools:layout_editor_absoluteY="87dp" />

    <TextView
        android:id="@+id/txtResultadoAlunos"
        android:layout_width="289dp"
        android:layout_height="60dp"
        tools:layout_editor_absoluteX="61dp"
        tools:layout_editor_absoluteY="566dp" />

    <Button
        android:id="@+id/btnZerar"
        android:layout_width="237dp"
        android:layout_height="54dp"
        android:text="zerar"
        tools:layout_editor_absoluteX="88dp"
        tools:layout_editor_absoluteY="656dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
