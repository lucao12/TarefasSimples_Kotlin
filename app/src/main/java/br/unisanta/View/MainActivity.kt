package br.unisanta.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.Dao.TarefasDao
import br.unisanta.Model.Tarefas
import br.unisanta.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val dao = TarefasDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastra = findViewById<Button>(R.id.btnCadastra)
        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        btnCadastra.setOnClickListener {
            val tarefa = Tarefas(edtTitulo.text.toString(), edtDescricao.text.toString(), "Para fazer")
            dao.cadastraTarefa(tarefa)
            Toast.makeText(this, "Tarefa inserida com sucesso", Toast.LENGTH_SHORT).show()
            edtTitulo.text.clear()
            edtDescricao.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
