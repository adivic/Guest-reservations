package com.example.guestreservation.DI

import com.example.guestreservation.Rest.MockRestGateway
import com.example.guestreservation.Rest.RestGateway
import com.example.guestreservation.Rest.RetrofitClient
import com.example.guestreservation.Services.GuestService
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

object AppModule {
    private val restGateway = getMockRestGateway()
    private const val baseUrl = "https://caca.mockit.io/api"

    val appModule = module { single<GuestService> { RetrofitClient.retrofit.create(GuestService::class.java) }}

    private fun getMockRestGateway(): MockRestGateway {
        val behavior = NetworkBehavior.create()
        val retrofit = Retrofit.Builder().baseUrl("http://stubData.com").build()
        val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(behavior).build()
        val delegate = mockRetrofit.create<RestGateway>(RestGateway::class.java)
        return MockRestGateway(delegate)
    }
}