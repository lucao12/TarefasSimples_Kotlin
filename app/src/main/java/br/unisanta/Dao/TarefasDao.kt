package br.unisanta.Dao

import br.unisanta.Model.Tarefas

class TarefasDao {

    companion object {
        private val tarefas = mutableListOf<Tarefas>()
    }

    fun cadastraTarefa(tarefa: Tarefas) {
        Companion.tarefas.add(tarefa)
    }

    fun obterLista(): List<Tarefas> {
        return Companion.tarefas
    }
}
