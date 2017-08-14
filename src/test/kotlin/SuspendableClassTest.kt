import kotlinx.coroutines.experimental.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test
import org.mockito.Mockito.*

class SuspendableClassTest {
    @Test
    fun testMock() = runBlocking<Unit> {
        val mockClass = mock(SuspendableClass::class.java)
        `when`(mockClass.fetch()).thenReturn(10)
        assertThat(mockClass.fetch(), IsEqual(10))
        verify(mockClass).fetch()
    }
}