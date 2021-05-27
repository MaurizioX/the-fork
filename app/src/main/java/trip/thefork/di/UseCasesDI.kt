package trip.thefork.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import trip.thefork.data.entity.RestaurantEntity
import trip.thefork.data.services.RestaurantService
import trip.thefork.domain.elements.RestaurantElement
import trip.thefork.domain.usecase.GetRestaurantUseCase

@InstallIn(ViewModelComponent::class)
@Module
class UseCasesDI {
    @Provides
    fun providesGetRestaurantUseCase(
        restaurantService: RestaurantService,

    ) = GetRestaurantUseCase(restaurantService, RestaurantMapper)

    @Provides
    fun providesRestaurantId(): String = "14163"
}

object RestaurantMapper:(RestaurantEntity) -> RestaurantElement{
    override fun invoke(entity: RestaurantEntity): RestaurantElement = RestaurantElement(entity.name,entity.diaporamaList)
}