import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFilmes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lista de filmes fictícia
        val filmes = listOf(
            Filme("O Poderoso Chefão", "Drama", 1972),
            Filme("Interestelar", "Ficção Científica", 2014),
            Filme("O Senhor dos Anéis", "Fantasia", 2001),
            Filme("A Origem", "Ação", 2010),
            Filme("Matrix", "Ficção Científica", 1999)
        )

        // Configurando o Adapter diretamente na MainActivity
        recyclerView.adapter = FilmeAdapter(filmes)
    }

    // Classe de dados para os filmes
    data class Filme(val titulo: String, val genero: String, val anoLancamento: Int)

    // Adapter para exibir os filmes
    class FilmeAdapter(private val filmes: List<Filme>) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
            return FilmeViewHolder(view)
        }

        override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
            val filme = filmes[position]
            holder.bind(filme)
        }

        override fun getItemCount(): Int = filmes.size

        // ViewHolder interno para vincular os dados
        class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val titulo: TextView = itemView.findViewById(android.R.id.text1)
            private val generoAno: TextView = itemView.findViewById(android.R.id.text2)

            fun bind(filme: Filme) {
                titulo.text = filme.titulo
                generoAno.text = "${filme.genero} - ${filme.anoLancamento}"
            }
        }
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- RecyclerView para exibir a lista de filmes -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerViewFilmes"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="LinearLayoutManager" />
</androidx.constraintlayout.widget.ConstraintLayout>
