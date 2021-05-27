package trip.thefork.data.entity.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagListItemJson(
    @SerialName("alternative_name_hp")
    val alternativeNameHp: String?,
    @SerialName("alternative_name_rp")
    val alternativeNameRp: String?,
    @SerialName("alternative_name_srp")
    val alternativeNameSrp: String?,
    @SerialName("alternative_names")
    val alternativeNames: String?,
    @SerialName("banner_web")
    val bannerWeb: String,
    @SerialName("display_order")
    val displayOrder: String?,
    @SerialName("id_city_indexable")
    val idCityIndexable: String?,
    @SerialName("id_country_restriction")
    val idCountryRestriction: String?,
    @SerialName("id_restaurant_tag")
    val idRestaurantTag: Int,
    @SerialName("id_restaurant_tag_category")
    val idRestaurantTagCategory: Int,
    @SerialName("id_restaurant_tag_level_1")
    val idRestaurantTagLevel1: String?,
    @SerialName("id_restaurant_tag_level_2")
    val idRestaurantTagLevel2: String?,
    @SerialName("id_restaurant_tag_substitute")
    val idRestaurantTagSubstitute: String?,
    @SerialName("indexable")
    val indexable: Int,
    @SerialName("is_deleted")
    val isDeleted: Int,
    @SerialName("is_displayed_search")
    val isDisplayedSearch: Boolean,
    @SerialName("is_published_portal")
    val isPublishedPortal: Boolean,
    @SerialName("marketing_banner")
    val marketingBanner: String,
    @SerialName("marketing_description")
    val marketingDescription: String?,
    @SerialName("marketing_title")
    val marketingTitle: String?,
    @SerialName("pic_large")
    val picLarge: String,
    @SerialName("pic_mobile")
    val picMobile: String,
    @SerialName("pic_small")
    val picSmall: String,
    @SerialName("search_volume")
    val searchVolume: String?,
    @SerialName("seo_desc")
    val seoDesc: String?,
    @SerialName("seo_h1")
    val seoH1: String?,
    @SerialName("seo_title")
    val seoTitle: String?,
    @SerialName("slug_indexable")
    val slugIndexable: String,
    @SerialName("slug_list")
    val slugList: List<String>,
    @SerialName("tag_description")
    val tagDescription: String,
    @SerialName("tag_name")
    val tagName: String,
    @SerialName("title")
    val title: String?
)