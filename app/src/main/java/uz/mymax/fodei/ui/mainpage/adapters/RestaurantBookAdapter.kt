package uz.mymax.fodei.ui.mainpage.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.R
import uz.mymax.fodei.ui.mainpage.data.ArivableFoodViewModel
import uz.mymax.fodei.ui.mainpage.data.BookedRestaurants
import uz.mymax.fodei.ui.mainpage.data.ListService
import uz.mymax.fodei.ui.mainpage.data.RestaurantsViewModel

class RestaurantBookAdapter(private val mList: List<RestaurantsViewModel>) :
    RecyclerView.Adapter<RestaurantBookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val RestaurantsViewModel = mList[position]

        holder.imageView.setImageResource(RestaurantsViewModel.image)
        holder.tvHeader.text = RestaurantsViewModel.header
        holder.tvAddress.text = RestaurantsViewModel.address

    }

    override fun getItemCount(): Int = mList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var listService = ListService()
        val imageView: ImageView = view.findViewById(R.id.ivRestaurant)
        val tvHeader: TextView = view.findViewById(R.id.tvRestaurantHeader)
        val tvAddress: TextView = view.findViewById(R.id.tvRestaurantAddress)
        val btnBook: Button = view.findViewById(R.id.btnBook)

        init {
            btnBook.setOnClickListener {
                Log.d("onclick", "=>>>>>>>>>>>>>> onclick ishlepti")
                listService.addBookedRestaurant(
                    RestaurantsViewModel(
                        R.drawable.restaurant,
                        tvHeader.text.toString(),
                        tvAddress.text.toString()
                    )
                )
            }
        }
    }
}