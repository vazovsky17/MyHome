package app.vazovsky.myhome.data.network

import app.vazovsky.myhome.data.network.model.response.CamerasResponse
import app.vazovsky.myhome.data.network.model.response.DoorsResponse
import app.vazovsky.myhome.di.ApiClient
import io.ktor.client.HttpClient
import javax.inject.Inject

private const val BASE_URL = "http://cars.cprogroup.ru/api/rubetek/"

/**
 *
 * http://cars.cprogroup.ru/api/rubetek/cameras/ - Метод получение камер
 * http://cars.cprogroup.ru/api/rubetek/doors/ - Метод получение дверей
 *
 */
class MyHomeApiService @Inject constructor(
    @ApiClient client: HttpClient,
) : BaseApiService(client, BASE_URL) {

    suspend fun getCameras(): CamerasResponse = get("cameras")

    suspend fun getDoors(): DoorsResponse = get("doors")
}