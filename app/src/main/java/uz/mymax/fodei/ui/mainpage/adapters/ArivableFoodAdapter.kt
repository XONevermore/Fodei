package uz.mymax.fodei.ui.mainpage.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.databinding.FoodItemBinding
import uz.mymax.fodei.ui.mainpage.data.ArivableFood

class ArivableFoodAdapter(private val mList: List<ArivableFood>) : RecyclerView.Adapter<ArivableFoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val arivableFood = mList[position]

        holder.bind(arivableFood)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(arivableFood: ArivableFood){
            binding.ivFood.setImageResource(arivableFood.image)
            binding.tvFoodHeader.text = arivableFood.header
            binding.tvFoodAddress.text = arivableFood.address
        }
    }
}