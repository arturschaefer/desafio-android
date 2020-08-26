package com.schaefer.user.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

//References:
// https://github.com/android/architecture-components-samples/blob/88747993139224a4bb6dbe985adf652d557de621/GithubBrowserSample/app/src/main/java/com/android/example/github/repository/NetworkBoundResource.kt
// https://stackoverflow.com/questions/58486364/networkboundresource-with-kotlin-coroutines
@ExperimentalCoroutinesApi
inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { Unit },
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow<Resource<ResultType>> {
    emit(Resource.Loading(null))
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            onFetchFailed(throwable)
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}