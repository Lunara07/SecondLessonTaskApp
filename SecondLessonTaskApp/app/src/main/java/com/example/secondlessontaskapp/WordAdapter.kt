package com.example.secondlessontaskapp
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_word.view.*
import com.example.secondlessontaskapp.R
import com.example.secondlessontaskapp.Word

class WordAdapter (
    private val textClickListener: (position: Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>()
    {
        private val words = mutableListOf<Word>()

        override fun getItemCount(): Int = words.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return UserViewHolder(inflater, parent)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as UserViewHolder).bind(words[position], textClickListener)
        }

        fun addItems(list: List<Word>) {
            words.clear()
            words.addAll(list)
            notifyDataSetChanged()
        }

        fun addItem(user: Word) {
            words.add(user)
            notifyDataSetChanged()
        }

        fun removeItem(position: Int) {
            if (words.size > position) {
                words.removeAt(position)
                notifyDataSetChanged()
            }
        }

        private class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.item_word, parent, false)) {
            private val userContainer = itemView.wordContainer
            private val nameTextView = itemView.wordTextView

            fun bind(word: Word, textClickListener: (position: Int) -> Unit) {
                nameTextView.text = word.word
                userContainer.setOnClickListener { textClickListener(adapterPosition) }
            }
        }
    }

