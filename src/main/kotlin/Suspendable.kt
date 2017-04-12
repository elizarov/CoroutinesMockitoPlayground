import kotlinx.coroutines.experimental.runBlocking

interface Suspendable {
    suspend fun suspendFunction(x: Int): Int
}

class CallsSuspendable(val suspendable: Suspendable) {
    fun callSuspendable(x: Int) = runBlocking {
        suspendable.suspendFunction(x)
    }
}