package trip.thefork.data.services

import io.ktor.client.features.*

sealed interface Failure {
    object NetworkConnection : Failure
    class HttpErrorInternalServerError(val serverResponseException: ServerResponseException) :
        Failure

    class HttpErrorBadRequest(val exception: ClientRequestException) : Failure
    class HttpErrorUnauthorized(val clientRequestException: ClientRequestException) :
        Failure

    class HttpErrorForbidden(val clientRequestException: ClientRequestException) :
        Failure

    class HttpErrorNotFound(val clientRequestException: ClientRequestException) :
        Failure

    class HttpError(val clientRequestException: ClientRequestException) :
        Failure

    class GenericError(val exception: Exception) : Failure
    class RedirectError(val redirectResponseException: RedirectResponseException) :
        Failure

}
