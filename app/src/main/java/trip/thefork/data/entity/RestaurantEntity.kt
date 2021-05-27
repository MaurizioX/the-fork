package trip.thefork.data.entity

import android.location.Location

data class RestaurantEntity(val name:String, val location:GpsLoc, val avg:String, val diaporamaList:List<String> )

class GpsLoc(val lat:Double,val lon:Double)
