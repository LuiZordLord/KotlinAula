Escopo 1:
Será feito um app para ser usado em marte, o app será focado principalmente em ajudar as pessoas a encontrar as passagens mais baratas para marte, mais importante passagens que aceitam Pets,
será um app com uma tela para login com e-mail e senha, uma tela principal a qual a principal função será escolhe a passagem que o cliente deseja,
logo após selecionar irá para uma tela de finalização qual finalizará o pedido de sua passagem para Marte. 

Escopo Refinado:
O aplicativo foi projetado para oferecer uma experiência intuitiva e prática, composta por telas que permitem ao usuário criar uma nova conta,
acessar sua conta existente e selecionar as passagens de maneira rápida e eficiente. Desenvolvido especialmente para aqueles que sonham em viajar para Marte,
o app também oferece a opção de levar o seu pet para essa aventura interplanetária, garantindo uma jornada única e repleta de comodidade para todos os membros da família.

/////

package Atividadeb2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

              val btnDetails: Button = findViewById(R.id.btnDetails)
        btnDetails.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("DETAIL_KEY", "Detalhes sobre Marte...")
            }
            startActivity(intent)
        }

        val btnActivities: Button = findViewById(R.id.btnActivities)
        btnActivities.setOnClickListener {
            startActivity(Intent(this, ActivitiesActivity::class.java))
        }
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <!-- Botão para detalhes sobre Marte -->
    <Button
        android:id="@+id/btnDetails"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Detalhes sobre Marte" />

    <!-- Botão para atividades em Marte -->
    <Button
        android:id="@+id/btnActivities"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Atividades em Marte" />
</LinearLayout>

/////

  package Atividadeb2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val detailText: String? = intent.getStringExtra("DETAIL_KEY")

        val textView: TextView = findViewById(R.id.textViewDetail)
        textView.text = detailText ?: "Nenhum detalhe disponível"

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <!-- Exibe os detalhes passados pela MainActivity -->
    <TextView
        android:id="@+id/textViewDetail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Detalhes sobre Marte" />

    <!-- Botão para voltar à tela anterior -->
    <Button
        android:id="@+id/btnBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Voltar" />
</LinearLayout>

/////

package Atividadeb2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <!-- Texto simples sobre as atividades -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Atividades em Marte" />
</LinearLayout>
