package trip.thefork.data.entity.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import java.io.BufferedReader
import java.io.InputStreamReader

@RunWith(BlockJUnit4ClassRunner::class)
class RestaurantInfoJsonTest {
    @Test
    fun `test json load`() {
        val inputStream = javaClass.classLoader?.getResourceAsStream("restaurantData.json")

        val input = BufferedReader(InputStreamReader(inputStream))
        val dataJsonEntity: RestaurantInfoJson? = input.readLine()?.let {
            Json { ignoreUnknownKeys = true }.decodeFromString(it)
        }
        dataJsonEntity?.data
    }

}