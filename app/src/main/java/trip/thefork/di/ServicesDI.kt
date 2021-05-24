package trip.thefork.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import trip.thefork.data.services.InfraRestaurantService
import trip.thefork.data.services.RestaurantService
import trip.thefork.data.services.api.RestaurantApi
import trip.thefork.data.services.infra.NetworkHandler
import trip.thefork.data.services.infra.ktorHttpClient
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ServicesDI {
    @Provides
    @Singleton
    fun providesRestaurantService(
        networkHandler: NetworkHandler,
        restaurantApi: RestaurantApi
    ): RestaurantService = InfraRestaurantService(networkHandler, restaurantApi)

    @Provides
    fun providesRestaurantApi(): RestaurantApi = RestaurantApi(ktorHttpClient)
}