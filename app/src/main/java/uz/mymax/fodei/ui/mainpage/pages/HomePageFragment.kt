package uz.mymax.fodei.ui.mainpage.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentHomePageBinding
import uz.mymax.fodei.ui.mainpage.adapters.ArivableFoodAdapter
import uz.mymax.fodei.ui.mainpage.adapters.BannersAdapter
import uz.mymax.fodei.ui.mainpage.adapters.RestaurantBookAdapter
import uz.mymax.fodei.ui.mainpage.data.ArivableFoodViewModel
import uz.mymax.fodei.ui.mainpage.data.ItemsViewModel
import uz.mymax.fodei.ui.mainpage.data.ListService
import uz.mymax.fodei.ui.mainpage.data.RestaurantsViewModel

class HomePageFragment : Fragment() {
    private lateinit var listService: ListService
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listService = ListService()
        binding.banners.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.foodList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.restaurantList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val banners = ArrayList<ItemsViewModel>()
        val food = ArrayList<ArivableFoodViewModel>()
        listService.addData()

        for (i in 1..20) {
            banners.add(ItemsViewModel(R.drawable.flash_offer))
        }
        for (i in 1..20) {
            food.add(
                ArivableFoodViewModel(
                    R.drawable.osh, "Chicken Biryani $i", "Ambrosia Hotel &\n" +
                            "Restaurant $i"
                )
            )
        }


        val bannersAdapter = BannersAdapter(banners)
        val arivableFoodAdapter = ArivableFoodAdapter(food)
        val restaurantsAdapter = RestaurantBookAdapter(listService.getRestaurantsList())

        binding.banners.adapter = bannersAdapter
        binding.foodList.adapter = arivableFoodAdapter
        binding.restaurantList.adapter = restaurantsAdapter

        binding.tvLocation.setOnClickListener {
            findNavController().navigate(R.id.mapsFragment)
        }

    }
}