package uz.mymax.fodei.ui.mainpage.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.BannerBinding
import uz.mymax.fodei.databinding.FoodItemBinding
import uz.mymax.fodei.ui.mainpage.data.Items

class BannersAdapter(private val mList: List<Items>) : RecyclerView.Adapter<BannersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BannerBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: BannerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(items: Items){
            binding.ivBanner.setImageResource(items.image)
        }
    }
}