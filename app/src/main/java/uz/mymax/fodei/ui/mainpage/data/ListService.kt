package uz.mymax.fodei.ui.mainpage.data

import uz.mymax.fodei.R

class ListService {
    companion object {
        var restaurants = ArrayList<Restaurants>()
        var restaurantsBooked = ArrayList<Restaurants>()
    }

    fun getRestaurantsList() = restaurants
    fun getBookedRestaurantsList() = restaurantsBooked

    fun addRestaurant(data:Restaurants){
        restaurants.add(data)
    }

    fun addBookedRestaurant(data:Restaurants){
        restaurantsBooked.add(data)
    }

    fun addData(){
        for (i in 1..20) {
            restaurants.add(Restaurants(
                R.drawable.restaurant, "Chicken Biryani $i", "Ambrosia Hotel &\n" +
                        "Restaurant $i"))
        }

    }
}