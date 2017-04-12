import kotlinx.coroutines.experimental.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test
import org.mockito.Mockito.*

class SuspendableTest {
    @Test
    fun testMockedSuspendable() = runBlocking<Unit> {
        val mockSuspendable: Suspendable = mock(Suspendable::class.java)
        val callsSuspendable = CallsSuspendable(mockSuspendable)

        `when`(mockSuspendable.suspendFunction(1)).thenReturn(2)
        `when`(mockSuspendable.suspendFunction(2)).thenReturn(4)
        `when`(mockSuspendable.suspendFunction(intThat { it >= 3 })).thenReturn(8)

        assertThat(callsSuspendable.callSuspendable(1), IsEqual(2))
        assertThat(callsSuspendable.callSuspendable(2), IsEqual(4))
        assertThat(callsSuspendable.callSuspendable(3), IsEqual(8))

        verify(mockSuspendable).suspendFunction(1)
        verify(mockSuspendable).suspendFunction(2)
        verify(mockSuspendable).suspendFunction(3)
    }
}