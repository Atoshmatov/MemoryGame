package uz.gita.memoryGame.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.memoryGame.R
import uz.gita.memoryGame.data.comman.enumclas.LevelEnum
import uz.gita.memoryGame.data.comman.model.LevelData
import uz.gita.memoryGame.databinding.LevelItemBinding

class LevelAdapter : ListAdapter<LevelData, LevelAdapter.ViewHolder>(LevelDataDiffUtils) {
    private var onclickItemListener: ((LevelEnum) -> Unit)? = null

    object LevelDataDiffUtils : DiffUtil.ItemCallback<LevelData>() {
        override fun areItemsTheSame(oldItem: LevelData, newItem: LevelData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: LevelData, newItem: LevelData): Boolean =
            oldItem == newItem
    }

    inner class ViewHolder(private val binding: LevelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onclickItemListener?.invoke(getItem(absoluteAdapterPosition).level)
            }

        }

        fun bind(): LevelData = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                levelCount.text = count
                Glide
                    .with(levelImage)
                    .load(getItem(absoluteAdapterPosition).image)
                    .into(levelImage)
                levelImage.animate().setDuration(0).alpha(0f)
                    .withEndAction {
                        levelImage.animate().setDuration(600).alpha(1f).start()
                    }.start()
                levelCount.animate().setDuration(0).alpha(0f)
                    .withEndAction {
                        levelCount.animate().setDuration(600).alpha(1f).start()
                    }.start()


            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LevelItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.level_item, parent, false
            )
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnclickItemListener(block: (LevelEnum) -> Unit) {
        onclickItemListener = block
    }
}