package uz.mymax.fodei.ui.mainpage.data

import uz.mymax.fodei.R

class ListService {
    companion object {
        var restaurants = ArrayList<RestaurantsViewModel>()
        var restaurantsBooked = ArrayList<RestaurantsViewModel>()
    }

    fun getRestaurantsList() = restaurants
    fun getBookedRestaurantsList() = restaurantsBooked

    fun addRestaurant(data:RestaurantsViewModel){
        restaurants.add(data)
    }

    fun addBookedRestaurant(data:RestaurantsViewModel){
        restaurantsBooked.add(data)
    }

    fun addData(){
        for (i in 1..20) {
            restaurants.add(RestaurantsViewModel(
                R.drawable.restaurant, "Chicken Biryani $i", "Ambrosia Hotel &\n" +
                        "Restaurant $i"))
        }

    }
}