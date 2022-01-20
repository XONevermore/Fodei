package uz.mymax.fodei.ui.mainpage.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FoodItemBinding
import uz.mymax.fodei.databinding.RestaurantItemBinding
import uz.mymax.fodei.ui.mainpage.data.ListService
import uz.mymax.fodei.ui.mainpage.data.Restaurants

class RestaurantBookAdapter(private val mList: List<Restaurants>) :
    RecyclerView.Adapter<RestaurantBookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurantsViewModel = mList[position]

        holder.bind(restaurantsViewModel)

    }

    override fun getItemCount(): Int = mList.size

    class ViewHolder(val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var listService = ListService()

        init {
            binding.btnBook.setOnClickListener {
                Log.d("onclick", "=>>>>>>>>>>>>>> onclick ishlepti")
                listService.addBookedRestaurant(
                    Restaurants(
                        R.drawable.restaurant,
                        binding.tvRestaurantHeader.text.toString(),
                        binding.tvRestaurantAddress.text.toString()
                    )
                )
            }
        }

        fun bind(restaurant: Restaurants){
            binding.ivRestaurant.setImageResource(restaurant.image)
            binding.tvRestaurantHeader.text = restaurant.header
            binding.tvRestaurantAddress.text = restaurant.address
        }
    }
}