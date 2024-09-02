package br.unisanta.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.Model.Tarefas
import br.unisanta.R

class TarefasAdapter(private val tarefas: List<Tarefas>) : RecyclerView.Adapter<TarefasAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitulo = itemView.findViewById<TextView>(R.id.txtTitulo)
        val txtDescricao = itemView.findViewById<TextView>(R.id.txtDescricao)
        val txtStatus = itemView.findViewById<TextView>(R.id.txtStatus)
        val btnStatus = itemView.findViewById<Button>(R.id.btnStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]

        holder.txtTitulo.text = tarefa.titulo
        holder.txtDescricao.text = tarefa.descricao
        holder.txtStatus.text = tarefa.status

        updateStatusIcon(holder.txtStatus, tarefa.status)
        holder.btnStatus.visibility = if (tarefa.status == "Concluída") View.GONE else View.VISIBLE

        holder.btnStatus.setOnClickListener {
            tarefa.status = "Concluída"
            holder.txtStatus.text = tarefa.status
            holder.btnStatus.visibility = View.GONE

            updateStatusIcon(holder.txtStatus, tarefa.status)

            Log.i("Lista", "Tarefa '${tarefa.titulo}' status alterado para '${tarefa.status}'")
        }
    }


    private fun updateStatusIcon(textView: TextView, status: String) {
        if (status == "Concluída") {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.baseline_done_24, 0)
        }
    }
}
