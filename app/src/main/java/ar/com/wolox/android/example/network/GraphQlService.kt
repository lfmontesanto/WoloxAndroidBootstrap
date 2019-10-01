package ar.com.wolox.android.example.network

import ar.com.wolox.android.example.BaseConfiguration
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.wolox.queries.GetOrdersQuery
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class GraphQlService {
    private val apolloClient = ApolloClient.builder()
            .serverUrl(BaseConfiguration.GRAPHQL_BASE_URL)
            .okHttpClient(
                    OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build()
            )
            .build()

    fun getOrders(page: Int, limit: Int): ApolloCall<GetOrdersQuery.Data> {
        return apolloClient.query(
                GetOrdersQuery
                        .builder()
                        .page(page)
                        .limit(limit)
                        .build())
    }
}
