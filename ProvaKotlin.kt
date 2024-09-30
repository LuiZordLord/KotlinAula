package br.unipar.exemploadapter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeTarefas = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edTarefa = findViewById<EditText>(R.id.edAgua)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas)


        //Criando uma ponto usando o layout do android

        /*adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)*/

        val adapter = TarefaAdapter(this, listaDeTarefas)


        //Vinculando o meu adaptar com a minha view
        listViewTarefas.adapter = adapter

        btnCadastrar.setOnClickListener {

            val descricaoTarefa = edTarefa.text.toString()
            val dataAtual = SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(Date())

            if(descricaoTarefa.isNotEmpty()){

                val novaTarefa = Tarefa(descricaoTarefa, dataAtual, false)

                listaDeTarefas.add(novaTarefa)
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Tarefa: ${descricaoTarefa}", Toast.LENGTH_LONG).show()

                edTarefa.text.clear()

            }


        }

        listViewTarefas.setOnItemLongClickListener{ _,_, position,_ ->
            val removeTarefa = listaDeTarefas.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Tarefa removida", Toast.LENGTH_LONG).show()
            true
        }

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
        android:layout_width="409dp"
        android:layout_height="729dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nome da Planta:"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edAgua"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Planta"
            android:inputType="text" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Data de Plantio:"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edAgua"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Data"
            android:inputType="text" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Nível de Cuidado"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edAgua"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Baixo, Médio, Alto"
            android:inputType="text" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Quantidade de Água"
            android:textSize="18sp"
            android:textStyle="bold" />

        <EditText
            android:id="@+id/edAgua"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="Água"
            android:inputType="text" />

        <Button
            android:id="@+id/btnCadastrar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50sp"
            android:layout_marginTop="10sp"
            android:layout_marginRight="50sp"
            android:layout_marginBottom="10sp"
            android:text="Cadastrar" />

        <ListView
            android:id="@+id/listViewTarefas"
            android:layout_width="match_parent"
            android:layout_height="255dp" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
