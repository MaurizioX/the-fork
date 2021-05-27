package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataJson(
    @SerialName("address")
    val address: String,
    @SerialName("avg_rate_evolution")
    val avgRateEvolution: String,
    @SerialName("card_dessert_1")
    val cardDessert1: String,
    @SerialName("card_dessert_2")
    val cardDessert2: String,
    @SerialName("card_dessert_3")
    val cardDessert3: String,
    @SerialName("card_main_1")
    val cardMain1: String,
    @SerialName("card_main_2")
    val cardMain2: String,
    @SerialName("card_main_3")
    val cardMain3: String,
    @SerialName("card_price")
    val cardPrice: Int,
    @SerialName("card_start_1")
    val cardStart1: String,
    @SerialName("card_start_2")
    val cardStart2: String,
    @SerialName("card_start_3")
    val cardStart3: String,
    @SerialName("chef_name")
    val chefName: String?,
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("currency_code")
    val currencyCode: String,
    @SerialName("description")
    val description: String,
    @SerialName("email")
    val email: String,
    @SerialName("gps_lat")
    val gpsLat: Double,
    @SerialName("gps_long")
    val gpsLong: Double,
    @SerialName("has_stock")
    val hasStock: Int,
    @SerialName("highlighted_tag")
    val highlightedTag: List<HighlightedTagJson>,
    @SerialName("hour_open")
    val hourOpen: String,
    @SerialName("id_city")
    val idCity: Int,
    @SerialName("id_city_zipcode")
    val idCityZipcode: Int,
    @SerialName("id_country")
    val idCountry: Int,
    @SerialName("id_restaurant")
    val idRestaurant: Int,
    @SerialName("id_restaurant_tag_speciality")
    val idRestaurantTagSpeciality: Int,
    @SerialName("id_restaurant_tag_speciality_category")
    val idRestaurantTagSpecialityCategory: Int,
    @SerialName("id_sale_type_normal")
    val idSaleTypeNormal: Int,
    @SerialName("insider_description")
    val insiderDescription: String?,
    @SerialName("insider_tips")
    val insiderTips: String?,
    @SerialName("is_amex")
    val isAmex: Boolean,
    @SerialName("is_lf_test_restaurant")
    val isLfTestRestaurant: Int,
    @SerialName("is_opened")
    val isOpened: Int,
    @SerialName("is_phone_displayed")
    val isPhoneDisplayed: Int,
    @SerialName("is_published_affiliate")
    val isPublishedAffiliate: Int,
    @SerialName("is_published_portal")
    val isPublishedPortal: Int,
    @SerialName("locale_code")
    val localeCode: String,
    @SerialName("menu_external_link")
    val menuExternalLink: String?,
    @SerialName("menus")
    val menus: MenusJson,
    @SerialName("michelin_detail")
    val michelinDetail: MichelinDetailJson,
    @SerialName("min_price")
    val minPrice: Int,
    @SerialName("min_price_before")
    val minPriceBefore: Int,
    @SerialName("name")
    val name: String,
    @SerialName("nb_max_group")
    val nbMaxGroup: Int,
    @SerialName("obfuscated_email")
    val obfuscatedEmail: String,
    @SerialName("other_localization_infos")
    val otherLocalizationInfos: String?,
    @SerialName("parking")
    val parking: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("pics_diaporama")
    val picsDiaporama: List<PicsDiaporamaJson>,
    @SerialName("pics_main")
    val picsMain: PicsMainJson,
    @SerialName("portal_url")
    val portalUrl: String,
    @SerialName("price_bottle_of_champagne")
    val priceBottleOfChampagne: Int,
    @SerialName("price_bottle_of_mineral_water")
    val priceBottleOfMineralWater: Int,
    @SerialName("price_bottle_of_wine_max")
    val priceBottleOfWineMax: Int,
    @SerialName("price_bottle_of_wine_min")
    val priceBottleOfWineMin: Int,
    @SerialName("price_card_dessert_1")
    val priceCardDessert1: Int,
    @SerialName("price_card_dessert_2")
    val priceCardDessert2: Double,
    @SerialName("price_card_dessert_3")
    val priceCardDessert3: Double,
    @SerialName("price_card_main_1")
    val priceCardMain1: Double,
    @SerialName("price_card_main_2")
    val priceCardMain2: Double,
    @SerialName("price_card_main_3")
    val priceCardMain3: Double,
    @SerialName("price_card_start_1")
    val priceCardStart1: Double,
    @SerialName("price_card_start_2")
    val priceCardStart2: Double,
    @SerialName("price_card_start_3")
    val priceCardStart3: Double,
    @SerialName("price_glass_of_champagne")
    val priceGlassOfChampagne: Int,
    @SerialName("price_glass_of_wine_max")
    val priceGlassOfWineMax: Int,
    @SerialName("price_glass_of_wine_min")
    val priceGlassOfWineMin: Int,
    @SerialName("price_half_bottle_of_mineral_water")
    val priceHalfBottleOfMineralWater: Int,
    @SerialName("price_of_coffee")
    val priceOfCoffee: Int,
    @SerialName("public_phone")
    val publicPhone: String,
    @SerialName("rate_count")
    val rateCount: Int,
    @SerialName("ratings")
    val ratings: RatingsJson,
    @SerialName("restaurant_tags")
    val restaurantTags: Map<String, RestaurantTagsItemJson>,
    @SerialName("restaurant_uuid")
    val restaurantUuid: String,
    @SerialName("speciality")
    val speciality: String,
    @SerialName("transport")
    val transport: String,
    @SerialName("trip_advisor_avg_rating")
    val tripAdvisorAvgRating: Double,
    @SerialName("trip_advisor_review_count")
    val tripAdvisorReviewCount: Int,
    @SerialName("vacation")
    val vacation: String?,
    @SerialName("web_max_days")
    val webMaxDays: Int,
    @SerialName("yums_detail")
    val yumsDetail: YumsDetailJson,
    @SerialName("zipcode")
    val zipcode: String
)