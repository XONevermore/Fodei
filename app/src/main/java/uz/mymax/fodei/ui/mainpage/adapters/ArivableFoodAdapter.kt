package uz.mymax.fodei.ui.mainpage.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.R
import uz.mymax.fodei.ui.mainpage.data.ArivableFoodViewModel

class ArivableFoodAdapter(private val mList: List<ArivableFoodViewModel>) : RecyclerView.Adapter<ArivableFoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ArivableFoodViewModel = mList[position]

        holder.imageView.setImageResource(ArivableFoodViewModel.image)
        holder.tvHeader.text = ArivableFoodViewModel.header
        holder.tvAddress.text = ArivableFoodViewModel.address
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.ivFood)
        val tvHeader: TextView = view.findViewById(R.id.tvFoodHeader)
        val tvAddress: TextView = view.findViewById(R.id.tvFoodAddress)
    }
}