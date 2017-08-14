
class SuspendableClass {
    suspend fun fetch(): Int {
        fetchConcrete()
        return 2
    }

    suspend fun fetchConcrete() = 1
}
