package com.example.guestreservation.DI

import com.example.guestreservation.Rest.MockRestGateway
import com.example.guestreservation.Rest.RestGateway
import com.example.guestreservation.Services.MyTestService
import com.example.guestreservation.Services.MyTestServiceImpl
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

object AppModule {
    private val restGateway = getMockRestGateway()
    private const val baseUrl = "http://stubData.com"

    val appModule = module { single<MyTestService> { MyTestServiceImpl(restGateway) }}

    private fun getMockRestGateway(): MockRestGateway {
        val behavior = NetworkBehavior.create()
        val retrofit = Retrofit.Builder().baseUrl("http://stubData.com").build()
        val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(behavior).build()
        val delegate = mockRetrofit.create<RestGateway>(RestGateway::class.java)
        return MockRestGateway(delegate)
    }
}