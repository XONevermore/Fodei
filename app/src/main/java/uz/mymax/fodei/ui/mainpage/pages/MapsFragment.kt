package uz.mymax.fodei.ui.mainpage.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentMapsBinding

class MapsFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private var mapFragment: SupportMapFragment? = null
    private lateinit var binding : FragmentMapsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(inflater)
        mapFragment = parentFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}