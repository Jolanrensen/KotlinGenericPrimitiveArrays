import org.junit.Test
import kotlin.random.Random
import kotlin.time.measureTime

class TestPrimitiveArrays {

    @Test
    fun `Test speed doubles`() = repeat(50) {
        val base = DoubleArray(10_000_000) { Random.nextDouble() }
        val primitiveArray = base.asPrimitiveArray()
        val objectArray = base.toTypedArray()

        val primitiveTime = measureTime {
            primitiveArray.reverse()
        }
        val objectTime = measureTime {
            objectArray.reverse()
        }
        println("""
            primitive: $primitiveTime
            object: $objectTime
            
        """.trimIndent())

        assert(primitiveTime <= objectTime)
    }
}
