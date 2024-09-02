package br.unisanta.View

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.Adapter.TarefasAdapter
import br.unisanta.Dao.TarefasDao
import br.unisanta.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity(R.layout.activity_main2) {
    val dao = TarefasDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("Lista", dao.obterLista().toString())

        val fabVolta = findViewById<FloatingActionButton>(R.id.fabVolta)
        val rvTarefas = findViewById<RecyclerView>(R.id.rc_tarefas)

        val tarefas = dao.obterLista()

        rvTarefas.layoutManager = LinearLayoutManager(this)
        rvTarefas.adapter = TarefasAdapter(tarefas)

        fabVolta.setOnClickListener {
            finish()
        }
    }
}
