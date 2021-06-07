package trip.thefork.ui.features.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import trip.thefork.databinding.ImageItemBinding

class ImageAdapter(private val list: List<String>) : RecyclerView.Adapter<ImageVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH = ImageVH(
        ImageItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        Picasso.with(holder.itemView.context).load(list[position]).into(holder.binding.image)
    }

    override fun getItemCount(): Int = list.size


}

class ImageVH(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)
