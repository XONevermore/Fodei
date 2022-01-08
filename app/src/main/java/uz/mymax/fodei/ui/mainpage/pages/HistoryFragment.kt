package uz.mymax.fodei.ui.mainpage.pages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentHistoryBinding
import uz.mymax.fodei.ui.mainpage.adapters.RestaurantBookAdapter
import uz.mymax.fodei.ui.mainpage.data.BookedRestaurants
import uz.mymax.fodei.ui.mainpage.data.ListService
import uz.mymax.fodei.ui.mainpage.data.RestaurantsViewModel

class HistoryFragment : Fragment() {
    private lateinit var listService: ListService
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var restaurantBookAdapter: RestaurantBookAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listService = ListService()
        Log.d("sp", listService.getBookedRestaurantsList().size.toString())

        restaurantBookAdapter = RestaurantBookAdapter(listService.getBookedRestaurantsList());
        binding.rvBookHistory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvBookHistory.adapter = restaurantBookAdapter

    }

    override fun onResume() {
        super.onResume()
        Log.d("resume", "resumed")
        restaurantBookAdapter = RestaurantBookAdapter(listService.getBookedRestaurantsList());
        binding.rvBookHistory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvBookHistory.adapter = restaurantBookAdapter
    }
}