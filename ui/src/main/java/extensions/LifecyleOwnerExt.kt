package extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <L> LifecycleOwner.observe(
    liveData: LiveData<L>,
    crossinline call: (L) -> Unit
) {
    liveData.observe(this, Observer {
        call.invoke(it)
    })
}