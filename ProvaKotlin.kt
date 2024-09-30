Main activity:
package com.verdejar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val plantList = mutableListOf<Plant>()
    private val plantAdapter = PlantAdapter(plantList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        recyclerViewPlants.layoutManager = LinearLayoutManager(this)
        recyclerViewPlants.adapter = plantAdapter

        btnAddPlant.setOnClickListener {
            val name = etPlantName.text.toString()
            val date = etPlantDate.text.toString()
            val careLevel = spinnerCareLevel.selectedItem.toString()

            plantList.add(Plant(name, date, careLevel))
            plantAdapter.notifyDataSetChanged()

            tvTotalPlants.text = "Total de plantas: ${plantList.size}"
        }
    }
}

/////

Plant.kt:

package com.example.verdejar

data class Plant(val name: String, val date: String, val careLevel: String)

/////

PlantAdapter.kt:

package com.example.verdejar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.plant_item.view.*

class PlantAdapter(private val plantList: List<Plant>) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    class PlantViewHolder(val view: android.view.View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        holder.view.tvPlantName.text = plant.name
        holder.view.tvPlantDate.text = plant.date
        holder.view.tvCareLevel.text = plant.careLevel
    }

    override fun getItemCount() = plantList.size
}

/////

activity_main.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tvTotalPlants"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Total de plantas: 0"
        android:textSize="18sp" />

    <EditText
        android:id="@+id/etPlantName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nome da planta" />

    <EditText
        android:id="@+id/etPlantDate"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Data de plantio" />

    <Spinner
        android:id="@+id/spinnerCareLevel"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:entries="@array/care_levels" />

    <Button
        android:id="@+id/btnAddPlant"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Adicionar Planta" />

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerViewPlants"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />
</LinearLayout>

/////

Planta_item.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="8dp">

    <TextView
        android:id="@+id/tvPlantName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nome da Planta" />

    <TextView
        android:id="@+id/tvPlantDate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Data de Plantio" />

    <TextView
        android:id="@+id/tvCareLevel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nível de Cuidado" />
</LinearLayout>
