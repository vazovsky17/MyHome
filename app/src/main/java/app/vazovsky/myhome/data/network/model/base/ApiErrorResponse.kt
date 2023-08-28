package app.vazovsky.myhome.data.network.model.base

import kotlinx.serialization.SerialName

/** Данные об ошибке запроса */
data class ApiErrorResponse(
    /** Ошибка */
    @SerialName("error") val error: Data?,
) {
    data class Data(
        /** Код ошибки */
        @SerialName("code") val code: String?,

        /** Сообщение об ошибке */
        @SerialName("message") val message: String?,
    )
}