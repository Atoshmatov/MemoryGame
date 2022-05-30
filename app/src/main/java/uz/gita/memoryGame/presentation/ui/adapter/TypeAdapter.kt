package uz.gita.memoryGame.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.enumclas.TypeEnum
import uz.gita.memoryGame.data.comman.model.TypeData
import uz.gita.memoryGame.databinding.TypeItemBinding

class TypeAdapter :
    ListAdapter<TypeData, TypeAdapter.ViewHolder>(TypeDataDiffUtils) {
    private var onclickItemListener: ((TypeEnum) -> Unit)? = null

    object TypeDataDiffUtils : DiffUtil.ItemCallback<TypeData>() {
        override fun areItemsTheSame(oldItem: TypeData, newItem: TypeData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TypeData, newItem: TypeData): Boolean =
            oldItem == newItem
    }

    inner class ViewHolder(private val binding: TypeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onclickItemListener?.invoke(getItem(absoluteAdapterPosition).type)
            }
        }

        fun bind(): TypeData = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                Glide
                    .with(typeImage)
                    .load(getItem(absoluteAdapterPosition).image)
                    .into(typeImage)
                typeImage.animate().setDuration(0).alpha(0f)
                    .withEndAction {
                        typeImage.animate().setDuration(600).alpha(1f).start()
                    }.start()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        TypeItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.type_item, parent, false
            )
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnclickItemListener(block: (TypeEnum) -> Unit) {
        onclickItemListener = block
    }
}