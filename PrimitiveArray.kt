@file:Suppress("NOTHING_TO_INLINE", "OVERRIDE_BY_INLINE", "unused")

import kotlin.random.Random

sealed interface PrimitiveArray<T : Comparable<T>> : List<T> {

    val actualData: Any

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    operator fun set(index: Int, value: T)

    fun copyOf(): PrimitiveArray<T>

    fun copyOf(newSize: Int): PrimitiveArray<T>

    fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveArray<T>

    fun fill(element: T, fromIndex: Int = 0, toIndex: Int = size)

    operator fun plus(element: T): PrimitiveArray<T>

    operator fun plus(elements: Collection<T>): PrimitiveArray<T>

    operator fun plus(elements: PrimitiveArray<out T>): PrimitiveArray<T>
    
    fun asList(): List<T>

    fun sort()

    fun sort(fromIndex: Int = 0, toIndex: Int = size)

    fun newArray(size: Int): PrimitiveArray<T>
    
    fun toTypedArray(): Array<T>

}

@JvmInline
value class PrimitiveByteArray(override val actualData: ByteArray) : PrimitiveArray<Byte> {
    override inline fun get(index: Int): Byte = actualData[index]
    override inline fun set(index: Int, value: Byte): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Byte> = actualData.iterator()
    override inline fun copyOf(): PrimitiveByteArray = PrimitiveByteArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveByteArray = PrimitiveByteArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveByteArray = PrimitiveByteArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Byte, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Byte): PrimitiveByteArray = PrimitiveByteArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Byte>): PrimitiveByteArray = PrimitiveByteArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Byte>): PrimitiveByteArray = PrimitiveByteArray(actualData.plus(elements.data))
    override inline fun asList(): List<Byte> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveByteArray = PrimitiveByteArray(ByteArray(size))
    override inline fun toTypedArray(): Array<Byte> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Byte): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Byte>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Byte): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Byte): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Byte> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Byte> = object : ListIterator<Byte> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Byte = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Byte = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Byte> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveByteArrayOf(vararg data: Byte): PrimitiveByteArray = byteArrayOf(*data).asPrimitiveArray()

inline fun ByteArray.asPrimitiveArray() = PrimitiveByteArray(this)

val PrimitiveArray<out Byte>.data: ByteArray
    get() = actualData as ByteArray

@JvmInline
value class PrimitiveCharArray(override val actualData: CharArray) : PrimitiveArray<Char> {
    override inline fun get(index: Int): Char = actualData[index]
    override inline fun set(index: Int, value: Char): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Char> = actualData.iterator()
    override inline fun copyOf(): PrimitiveCharArray = PrimitiveCharArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveCharArray = PrimitiveCharArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveCharArray = PrimitiveCharArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Char, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Char): PrimitiveCharArray = PrimitiveCharArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Char>): PrimitiveCharArray = PrimitiveCharArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Char>): PrimitiveCharArray = PrimitiveCharArray(actualData.plus(elements.data))
    override inline fun asList(): List<Char> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveCharArray = PrimitiveCharArray(CharArray(size))
    override inline fun toTypedArray(): Array<Char> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Char): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Char>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Char): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Char): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Char> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Char> = object : ListIterator<Char> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Char = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Char = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Char> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveCharArrayOf(vararg data: Char): PrimitiveCharArray = charArrayOf(*data).asPrimitiveArray()

inline fun CharArray.asPrimitiveArray() = PrimitiveCharArray(this)

val PrimitiveArray<out Char>.data: CharArray
    get() = actualData as CharArray

@JvmInline
value class PrimitiveShortArray(override val actualData: ShortArray) : PrimitiveArray<Short> {
    override inline fun get(index: Int): Short = actualData[index]
    override inline fun set(index: Int, value: Short): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Short> = actualData.iterator()
    override inline fun copyOf(): PrimitiveShortArray = PrimitiveShortArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveShortArray = PrimitiveShortArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveShortArray = PrimitiveShortArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Short, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Short): PrimitiveShortArray = PrimitiveShortArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Short>): PrimitiveShortArray = PrimitiveShortArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Short>): PrimitiveShortArray = PrimitiveShortArray(actualData.plus(elements.data))
    override inline fun asList(): List<Short> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveShortArray = PrimitiveShortArray(ShortArray(size))
    override inline fun toTypedArray(): Array<Short> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Short): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Short>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Short): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Short): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Short> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Short> = object : ListIterator<Short> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Short = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Short = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Short> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveShortArrayOf(vararg data: Short): PrimitiveShortArray = shortArrayOf(*data).asPrimitiveArray()

inline fun ShortArray.asPrimitiveArray() = PrimitiveShortArray(this)

val PrimitiveArray<out Short>.data: ShortArray
    get() = actualData as ShortArray

@JvmInline
value class PrimitiveIntArray(override val actualData: IntArray) : PrimitiveArray<Int> {
    override inline fun get(index: Int): Int = actualData[index]
    override inline fun set(index: Int, value: Int): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Int> = actualData.iterator()
    override inline fun copyOf(): PrimitiveIntArray = PrimitiveIntArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveIntArray = PrimitiveIntArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveIntArray = PrimitiveIntArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Int, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Int): PrimitiveIntArray = PrimitiveIntArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Int>): PrimitiveIntArray = PrimitiveIntArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Int>): PrimitiveIntArray = PrimitiveIntArray(actualData.plus(elements.data))
    override inline fun asList(): List<Int> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveIntArray = PrimitiveIntArray(IntArray(size))
    override inline fun toTypedArray(): Array<Int> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Int): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Int>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Int): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Int): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Int> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Int> = object : ListIterator<Int> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Int = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Int = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Int> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveIntArrayOf(vararg data: Int): PrimitiveIntArray = intArrayOf(*data).asPrimitiveArray()

inline fun IntArray.asPrimitiveArray() = PrimitiveIntArray(this)

val PrimitiveArray<out Int>.data: IntArray
    get() = actualData as IntArray

@JvmInline
value class PrimitiveLongArray(override val actualData: LongArray) : PrimitiveArray<Long> {
    override inline fun get(index: Int): Long = actualData[index]
    override inline fun set(index: Int, value: Long): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Long> = actualData.iterator()
    override inline fun copyOf(): PrimitiveLongArray = PrimitiveLongArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveLongArray = PrimitiveLongArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveLongArray = PrimitiveLongArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Long, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Long): PrimitiveLongArray = PrimitiveLongArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Long>): PrimitiveLongArray = PrimitiveLongArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Long>): PrimitiveLongArray = PrimitiveLongArray(actualData.plus(elements.data))
    override inline fun asList(): List<Long> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveLongArray = PrimitiveLongArray(LongArray(size))
    override inline fun toTypedArray(): Array<Long> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Long): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Long>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Long): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Long): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Long> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Long> = object : ListIterator<Long> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Long = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Long = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Long> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveLongArrayOf(vararg data: Long): PrimitiveLongArray = longArrayOf(*data).asPrimitiveArray()

inline fun LongArray.asPrimitiveArray() = PrimitiveLongArray(this)

val PrimitiveArray<out Long>.data: LongArray
    get() = actualData as LongArray

@JvmInline
value class PrimitiveFloatArray(override val actualData: FloatArray) : PrimitiveArray<Float> {
    override inline fun get(index: Int): Float = actualData[index]
    override inline fun set(index: Int, value: Float): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Float> = actualData.iterator()
    override inline fun copyOf(): PrimitiveFloatArray = PrimitiveFloatArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveFloatArray = PrimitiveFloatArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveFloatArray = PrimitiveFloatArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Float, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Float): PrimitiveFloatArray = PrimitiveFloatArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Float>): PrimitiveFloatArray = PrimitiveFloatArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Float>): PrimitiveFloatArray = PrimitiveFloatArray(actualData.plus(elements.data))
    override inline fun asList(): List<Float> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveFloatArray = PrimitiveFloatArray(FloatArray(size))
    override inline fun toTypedArray(): Array<Float> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Float): Boolean = actualData.any { it == element }
    override inline fun containsAll(elements: Collection<Float>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Float): Int = actualData.indexOfFirst { it == element }
    override inline fun lastIndexOf(element: Float): Int = actualData.indexOfLast { it == element }
    override inline fun listIterator(): ListIterator<Float> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Float> = object : ListIterator<Float> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Float = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Float = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Float> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveFloatArrayOf(vararg data: Float): PrimitiveFloatArray = floatArrayOf(*data).asPrimitiveArray()

inline fun FloatArray.asPrimitiveArray() = PrimitiveFloatArray(this)

val PrimitiveArray<out Float>.data: FloatArray
    get() = actualData as FloatArray

@JvmInline
value class PrimitiveDoubleArray(override val actualData: DoubleArray) : PrimitiveArray<Double> {
    override inline fun get(index: Int): Double = actualData[index]
    override inline fun set(index: Int, value: Double): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Double> = actualData.iterator()
    override inline fun copyOf(): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Double, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Double): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Double>): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Double>): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.plus(elements.data))
    override inline fun asList(): List<Double> = actualData.asList()
    override inline fun sort(): Unit = actualData.sort()
    override fun sort(fromIndex: Int, toIndex: Int): Unit = actualData.sort(fromIndex, toIndex)
    override inline fun newArray(size: Int): PrimitiveDoubleArray = PrimitiveDoubleArray(DoubleArray(size))
    override inline fun toTypedArray(): Array<Double> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Double): Boolean = actualData.any { it == element }
    override inline fun containsAll(elements: Collection<Double>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Double): Int = actualData.indexOfFirst { it == element }
    override inline fun lastIndexOf(element: Double): Int = actualData.indexOfLast { it == element }
    override inline fun listIterator(): ListIterator<Double> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Double> = object : ListIterator<Double> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Double = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Double = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Double> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveDoubleArrayOf(vararg data: Double): PrimitiveDoubleArray = doubleArrayOf(*data).asPrimitiveArray()

inline fun DoubleArray.asPrimitiveArray() = PrimitiveDoubleArray(this)

val PrimitiveArray<out Double>.data: DoubleArray
    get() = actualData as DoubleArray

@JvmInline
value class PrimitiveBooleanArray(override val actualData: BooleanArray) : PrimitiveArray<Boolean> {
    override inline fun get(index: Int): Boolean = actualData[index]
    override inline fun set(index: Int, value: Boolean): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Boolean> = actualData.iterator()
    override inline fun copyOf(): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.copyOfRange(fromIndex, toIndex))
    override fun fill(element: Boolean, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Boolean): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Boolean>): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.plus(elements))
    override inline operator fun plus(elements: PrimitiveArray<out Boolean>): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.plus(elements.data))
    override inline fun asList(): List<Boolean> = actualData.asList()
    override inline fun sort(): Unit = throw UnsupportedOperationException("Boolean Arrays do not support sorting.")
    override fun sort(fromIndex: Int, toIndex: Int): Unit = throw UnsupportedOperationException("Boolean Arrays do not support sorting.")
    override inline fun newArray(size: Int): PrimitiveBooleanArray = PrimitiveBooleanArray(BooleanArray(size))
    override inline fun toTypedArray(): Array<Boolean> = actualData.toTypedArray()
    override inline fun isEmpty(): Boolean = actualData.isEmpty()
    override inline fun contains(element: Boolean): Boolean = actualData.contains(element)
    override inline fun containsAll(elements: Collection<Boolean>): Boolean = elements.all { contains(it) }
    override inline fun indexOf(element: Boolean): Int = actualData.indexOf(element)
    override inline fun lastIndexOf(element: Boolean): Int = actualData.lastIndexOf(element)
    override inline fun listIterator(): ListIterator<Boolean> = listIterator(0)
    override inline fun listIterator(index: Int): ListIterator<Boolean> = object : ListIterator<Boolean> {
        var i = index
        override fun hasNext(): Boolean = i >= actualData.size
        override fun hasPrevious(): Boolean = i > 0
        override fun next(): Boolean = actualData[i++]
        override fun nextIndex(): Int = i
        override fun previous(): Boolean = actualData[--i]
        override fun previousIndex(): Int = i - 1
    }
    override inline fun subList(fromIndex: Int, toIndex: Int): List<Boolean> = actualData.slice(fromIndex until toIndex)
}

inline fun primitiveBooleanArrayOf(vararg data: Boolean): PrimitiveBooleanArray = booleanArrayOf(*data).asPrimitiveArray()

inline fun BooleanArray.asPrimitiveArray() = PrimitiveBooleanArray(this)

val PrimitiveArray<out Boolean>.data: BooleanArray
    get() = actualData as BooleanArray


inline operator fun <T : Comparable<T>> PrimitiveArray<out T>.component1(): T {
    return get(0)
}


inline operator fun <T : Comparable<T>> PrimitiveArray<out T>.component2(): T {
    return get(1)
}


inline operator fun <T : Comparable<T>> PrimitiveArray<out T>.component3(): T {
    return get(2)
}


inline operator fun <T : Comparable<T>> PrimitiveArray<out T>.component4(): T {
    return get(3)
}


inline operator fun <T : Comparable<T>> PrimitiveArray<out T>.component5(): T {
    return get(4)
}

/**
 * Returns `true` if [element] is found in the array.
 */
@Suppress("UNCHECKED_CAST")
operator fun <T : Comparable<T>> PrimitiveArray<out T>.contains(element: T): Boolean {
    return (this as PrimitiveArray<T>).indexOf(element) >= 0
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.elementAtOrElse(index: Int, defaultValue: (Int) -> T): T {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.elementAtOrNull(index: Int): T? {
    return this.getOrNull(index)
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.find(predicate: (T) -> Boolean): T? {
    return firstOrNull(predicate)
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.findLast(predicate: (T) -> Boolean): T? {
    return lastOrNull(predicate)
}

fun <T : Comparable<T>> PrimitiveArray<out T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.first(predicate: (T) -> Boolean): T {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

inline fun <T : Comparable<T>, R : Any> PrimitiveArray<out T>.firstNotNullOf(transform: (T) -> R?): R {
    return firstNotNullOfOrNull(transform)
        ?: throw NoSuchElementException("No element of the array was transformed to a non-null value.")
}

inline fun <T : Comparable<T>, R : Any> PrimitiveArray<out T>.firstNotNullOfOrNull(transform: (T) -> R?): R? {
    for (element in this) {
        val result = transform(element)
        if (result != null) {
            return result
        }
    }
    return null
}

fun <T : Comparable<T>> PrimitiveArray<out T>.firstOrNull(): T? {
    return if (isEmpty()) null else this[0]
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.firstOrNull(predicate: (T) -> Boolean): T? {
    for (element in this) if (predicate(element)) return element
    return null
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.getOrElse(index: Int, defaultValue: (Int) -> T): T {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}

fun <T : Comparable<T>> PrimitiveArray<out T>.getOrNull(index: Int): T? {
    return if (index >= 0 && index <= lastIndex) get(index) else null
}

fun <T : Comparable<T>> PrimitiveArray<out T>.indexOf(element: T): Int {
    for (index in indices) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.indexOfFirst(predicate: (T) -> Boolean): Int {
    for (index in indices) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.indexOfLast(predicate: (T) -> Boolean): Int {
    for (index in indices.reversed()) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

fun <T : Comparable<T>> PrimitiveArray<out T>.last(): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.last(predicate: (T) -> Boolean): T {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

fun <T : Comparable<T>> PrimitiveArray<out T>.lastIndexOf(element: T): Int {
    for (index in indices.reversed()) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}

fun <T : Comparable<T>> PrimitiveArray<out T>.lastOrNull(): T? {
    return if (isEmpty()) null else this[size - 1]
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.lastOrNull(predicate: (T) -> Boolean): T? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.random(): T {
    return random(Random)
}


fun <T : Comparable<T>> PrimitiveArray<out T>.random(random: Random): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return get(random.nextInt(size))
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.randomOrNull(): T? {
    return randomOrNull(Random)
}


fun <T : Comparable<T>> PrimitiveArray<out T>.randomOrNull(random: Random): T? {
    if (isEmpty())
        return null
    return get(random.nextInt(size))
}

fun <T : Comparable<T>> PrimitiveArray<out T>.single(): T {
    return when (size) {
        0 -> throw NoSuchElementException("Array is empty.")
        1 -> this[0]
        else -> throw IllegalArgumentException("Array has more than one element.")
    }
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.single(predicate: (T) -> Boolean): T {
    var single: T? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as T
}

fun <T : Comparable<T>> PrimitiveArray<out T>.singleOrNull(): T? {
    return if (size == 1) this[0] else null
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.singleOrNull(predicate: (T) -> Boolean): T? {
    var single: T? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

fun <T : Comparable<T>> PrimitiveArray<out T>.drop(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((size - n).coerceAtLeast(0))
}

fun <T : Comparable<T>> PrimitiveArray<out T>.dropLast(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.dropLastWhile(predicate: (T) -> Boolean): List<T> {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return take(index + 1)
        }
    }
    return emptyList()
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.dropWhile(predicate: (T) -> Boolean): List<T> {
    var yielding = false
    val list = ArrayList<T>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.filterIndexed(predicate: (index: Int, T) -> Boolean): List<T> {
    return filterIndexedTo(ArrayList<T>(), predicate)
}

inline fun <T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterIndexedTo(
    destination: C,
    predicate: (index: Int, T) -> Boolean,
): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.filterNot(predicate: (T) -> Boolean): List<T> {
    return filterNotTo(ArrayList<T>(), predicate)
}

inline fun <T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterNotTo(
    destination: C,
    predicate: (T) -> Boolean,
): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

inline fun <T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterTo(
    destination: C,
    predicate: (T) -> Boolean,
): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}


fun <T : Comparable<T>> PrimitiveArray<out T>.slice(indices: IntRange): List<T> {
    if (indices.isEmpty()) return listOf()
    return copyOfRange(indices.start, indices.endInclusive + 1).asList()
}

fun <T> Iterable<T>.collectionSizeOrDefault(default: Int): Int =
    if (this is Collection<*>) this.size else default

fun <T : Comparable<T>> PrimitiveArray<out T>.slice(indices: Iterable<Int>): List<T> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<T>(size)
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

fun <T : Comparable<T>> PrimitiveArray<out T>.take(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<T>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

fun <T : Comparable<T>> PrimitiveArray<out T>.takeLast(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = size
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<T>(n)
    for (index in size - n until size)
        list.add(this[index])
    return list
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.takeLastWhile(predicate: (T) -> Boolean): List<T> {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return drop(index + 1)
        }
    }
    return toList()
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.takeWhile(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        if (!predicate(item))
            break
        list.add(item)
    }
    return list
}

fun <T : Comparable<T>> PrimitiveArray<out T>.reversed(): List<T> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

//fun <T : Comparable<T>> PrimitiveArray<out T>.sortedArrayWith(comparator: Comparator<in T>): PrimitiveArray<out T> {
//    if (isEmpty()) return this
//    return this.copyOf().apply { sortWith(comparator) }
//}

inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortedBy(crossinline selector: (T) -> R?): List<T> {
    return sortedWith(compareBy(selector))
}

inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortedByDescending(crossinline selector: (T) -> R?): List<T> {
    return sortedWith(compareByDescending(selector))
}

fun <T : Comparable<T>> PrimitiveArray<out T>.sortedDescending(): List<T> {
    return sortedWith(reverseOrder())
}

fun <T : Comparable<T>> PrimitiveArray<out T>.sortedWith(comparator: Comparator<in T>): List<T> {
    return toTypedArray().apply { sortWith(comparator) }.asList()
}

val <T : Comparable<T>> PrimitiveArray<out T>.indices: IntRange
    get() = IntRange(0, lastIndex)


inline fun <T : Comparable<T>> PrimitiveArray<out T>.isEmpty(): Boolean {
    return size == 0
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.isNotEmpty(): Boolean {
    return !isEmpty()
}

val <T : Comparable<T>> PrimitiveArray<out T>.lastIndex: Int
    get() = size - 1

fun <T : Comparable<T>> PrimitiveArray<out T>.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

inline fun <T : Comparable<T>, K, V> PrimitiveArray<out T>.associate(transform: (T) -> Pair<K, V>): Map<K, V> {
    return associateTo(LinkedHashMap<K, V>(), transform)
}

inline fun <T : Comparable<T>, K> PrimitiveArray<out T>.associateBy(keySelector: (T) -> K): Map<K, T> {
    return associateByTo(LinkedHashMap<K, T>(), keySelector)
}

inline fun <T : Comparable<T>, K, V> PrimitiveArray<out T>.associateBy(
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): Map<K, V> {
    return associateByTo(LinkedHashMap<K, V>(), keySelector, valueTransform)
}

inline fun <T : Comparable<T>, K, M : MutableMap<in K, in T>> PrimitiveArray<out T>.associateByTo(
    destination: M,
    keySelector: (T) -> K,
): M {
    for (element in this) {
        destination.put(keySelector(element), element)
    }
    return destination
}

inline fun <T : Comparable<T>, K, V, M : MutableMap<in K, in V>> PrimitiveArray<out T>.associateByTo(
    destination: M,
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): M {
    for (element in this) {
        destination.put(keySelector(element), valueTransform(element))
    }
    return destination
}

inline fun <T : Comparable<T>, K, V, M : MutableMap<in K, in V>> PrimitiveArray<out T>.associateTo(
    destination: M,
    transform: (T) -> Pair<K, V>,
): M {
    for (element in this) {
        destination += transform(element)
    }
    return destination
}

fun <T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.toCollection(destination: C): C {
    for (item in this) {
        destination.add(item)
    }
    return destination
}

fun <T : Comparable<T>> PrimitiveArray<out T>.toHashSet(): HashSet<T> {
    return toCollection(HashSet<T>(mapCapacity(size)))
}

fun <T : Comparable<T>> PrimitiveArray<out T>.toList(): List<T> {
    return when (size) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> this.toMutableList()
    }
}


fun <T : Comparable<T>> PrimitiveArray<out T>.toMutableList(): MutableList<T> {
    return ArrayList(this)
}

private const val INT_MAX_POWER_OF_TWO: Int = 1 shl (Int.SIZE_BITS - 2)

internal fun mapCapacity(expectedSize: Int): Int = when {
    // We are not coercing the value to a valid one and not throwing an exception. It is up to the caller to
    // properly handle negative values.
    expectedSize < 0 -> expectedSize
    expectedSize < 3 -> expectedSize + 1
    expectedSize < INT_MAX_POWER_OF_TWO -> ((expectedSize / 0.75F) + 1.0F).toInt()
    // any large value
    else -> Int.MAX_VALUE
}

fun <T : Comparable<T>> PrimitiveArray<out T>.toSet(): Set<T> {
    return when (size) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet<T>(mapCapacity(size)))
    }
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapSequence")
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.flatMap(transform: (T) -> Sequence<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.flatMapIndexed(transform: (index: Int, T) -> Iterable<R>): List<R> {
    return flatMapIndexedTo(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedSequence")
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.flatMapIndexed(transform: (index: Int, T) -> Sequence<R>): List<R> {
    return flatMapIndexedTo(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapIndexedTo(
    destination: C,
    transform: (index: Int, T) -> Iterable<R>,
): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedSequenceTo")
inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapIndexedTo(
    destination: C,
    transform: (index: Int, T) -> Sequence<R>,
): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapTo(
    destination: C,
    transform: (T) -> Iterable<R>,
): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapSequenceTo")
inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapTo(
    destination: C,
    transform: (T) -> Sequence<R>,
): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

inline fun <T : Comparable<T>, K> PrimitiveArray<out T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
    return (this as PrimitiveArray<T>).groupByTo(LinkedHashMap<K, MutableList<T>>(), keySelector)
}

inline fun <T : Comparable<T>, K, V> PrimitiveArray<out T>.groupBy(
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): Map<K, List<V>> {
    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
}

inline fun <T : Comparable<T>, K, M : MutableMap<in K, MutableList<T>>> PrimitiveArray<out T>.groupByTo(
    destination: M,
    keySelector: (T) -> K,
): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<T>() }
        list.add(element)
    }
    return destination
}

inline fun <T : Comparable<T>, K, V, M : MutableMap<in K, MutableList<V>>> PrimitiveArray<out T>.groupByTo(
    destination: M,
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

inline fun <T : Comparable<T>, K> PrimitiveArray<out T>.groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K> {
    return object : Grouping<T, K> {
        override fun sourceIterator(): Iterator<T> = this@groupingBy.iterator()
        override fun keyOf(element: T): K = keySelector(element)
    }
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.map(transform: (T) -> R): List<R> {
    return mapTo(ArrayList<R>(size), transform)
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.mapIndexed(transform: (index: Int, T) -> R): List<R> {
    return mapIndexedTo(ArrayList<R>(size), transform)
}

inline fun <T : Comparable<T>, R : Any> PrimitiveArray<out T>.mapIndexedNotNull(transform: (index: Int, T) -> R?): List<R> {
    return mapIndexedNotNullTo(ArrayList<R>(), transform)
}

inline fun <T : Comparable<T>, R : Any, C : MutableCollection<in R>> PrimitiveArray<out T>.mapIndexedNotNullTo(
    destination: C,
    transform: (index: Int, T) -> R?,
): C {
    forEachIndexed { index, element -> transform(index, element)?.let { destination.add(it) } }
    return destination
}

inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.mapIndexedTo(
    destination: C,
    transform: (index: Int, T) -> R,
): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}

inline fun <T : Comparable<T>, R : Any> PrimitiveArray<out T>.mapNotNull(transform: (T) -> R?): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}

inline fun <T : Comparable<T>, R : Any, C : MutableCollection<in R>> PrimitiveArray<out T>.mapNotNullTo(
    destination: C,
    transform: (T) -> R?,
): C {
    forEach { element -> transform(element)?.let { destination.add(it) } }
    return destination
}

inline fun <T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.mapTo(
    destination: C,
    transform: (T) -> R,
): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}


internal class IndexingIterator<out T>(private val iterator: Iterator<T>) : Iterator<IndexedValue<T>> {
    private var index = 0
    final override fun hasNext(): Boolean = iterator.hasNext()
    final override fun next(): IndexedValue<T> = IndexedValue(index++, iterator.next())
}

internal class IndexingIterable<out T>(private val iteratorFactory: () -> Iterator<T>) : Iterable<IndexedValue<T>> {
    override fun iterator(): Iterator<IndexedValue<T>> = IndexingIterator(iteratorFactory())
}

fun <T : Comparable<T>> PrimitiveArray<out T>.withIndex(): Iterable<IndexedValue<T>> {
    return IndexingIterable { iterator() }
}

fun <T : Comparable<T>> PrimitiveArray<out T>.distinct(): List<T> {
    return this.toMutableSet().toList()
}

inline fun <T : Comparable<T>, K> PrimitiveArray<out T>.distinctBy(selector: (T) -> K): List<T> {
    val set = HashSet<K>()
    val list = ArrayList<T>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

infix fun <T : Comparable<T>> PrimitiveArray<out T>.intersect(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = this.toMutableSet() as MutableSet<T>
    set.retainAll(other)
    return set
}

infix fun <T : Comparable<T>> PrimitiveArray<out T>.subtract(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = this.toMutableSet() as MutableSet<T>
    set.removeAll(other)
    return set
}

fun <T : Comparable<T>> PrimitiveArray<out T>.toMutableSet(): MutableSet<T> {
    return toCollection(LinkedHashSet<T>(mapCapacity(size)))
}

infix fun <T : Comparable<T>> PrimitiveArray<out T>.union(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = this.toMutableSet() as MutableSet<T>
    set.addAll(other)
    return set
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.all(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

fun <T : Comparable<T>> PrimitiveArray<out T>.any(): Boolean {
    return !isEmpty()
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.any(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.count(): Int {
    return size
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.count(predicate: (T) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.fold(initial: R, operation: (acc: R, T) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.foldIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R,
): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.foldRight(initial: R, operation: (T, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.foldRightIndexed(
    initial: R,
    operation: (index: Int, T, acc: R) -> R,
): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.forEachIndexed(action: (index: Int, T) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxByOrNull(selector: (T) -> R): T? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxOf(selector: (T) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v) {
            maxValue = v
        }
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.maxOf(selector: (T) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}


@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.maxOf(selector: (T) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v) {
            maxValue = v
        }
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.maxOfWith(comparator: Comparator<in R>, selector: (T) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0) {
            maxValue = v
        }
    }
    return maxValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.maxOfWithOrNull(
    comparator: Comparator<in R>,
    selector: (T) -> R,
): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0) {
            maxValue = v
        }
    }
    return maxValue
}

fun <T : Comparable<T>> PrimitiveArray<out T>.maxOrNull(): T? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

fun <T : Comparable<T>> PrimitiveArray<out T>.maxWithOrNull(comparator: Comparator<in T>): T? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.minOf(selector: (T) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.minOf(selector: (T) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

fun <T : Comparable<T>> PrimitiveArray<out T>.minWithOrNull(comparator: Comparator<in T>): T? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minByOrNull(selector: (T) -> R): T? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minOf(selector: (T) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v) {
            minValue = v
        }
    }
    return minValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v) {
            minValue = v
        }
    }
    return minValue
}


@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.minOfWith(comparator: Comparator<in R>, selector: (T) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0) {
            minValue = v
        }
    }
    return minValue
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.minOfWithOrNull(
    comparator: Comparator<in R>,
    selector: (T) -> R,
): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0) {
            minValue = v
        }
    }
    return minValue
}

fun <T : Comparable<T>> PrimitiveArray<out T>.minOrNull(): T? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

fun <T : Comparable<T>> PrimitiveArray<out T>.none(): Boolean {
    return isEmpty()
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.none(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.onEach(action: (T) -> Unit): PrimitiveArray<out T> {
    return apply { for (element in this) action(element) }
}


inline fun <T : Comparable<T>> PrimitiveArray<out T>.onEachIndexed(action: (index: Int, T) -> Unit): PrimitiveArray<out T> {
    return apply { forEachIndexed(action) }
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduce(operation: (acc: S, T) -> S): S {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceIndexed(operation: (index: Int, acc: S, T) -> S): S {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(index, accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceIndexedOrNull(operation: (index: Int, acc: S, T) -> S): S? {
    if (isEmpty())
        return null
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(index, accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceOrNull(operation: (acc: S, T) -> S): S? {
    if (isEmpty())
        return null
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceRight(operation: (T, acc: S) -> S): S {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceRightIndexed(operation: (index: Int, T, acc: S) -> S): S {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceRightIndexedOrNull(operation: (index: Int, T, acc: S) -> S): S? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.reduceRightOrNull(operation: (T, acc: S) -> S): S? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.runningFold(initial: R, operation: (acc: R, T) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(size + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.runningFoldIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R,
): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(size + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.runningReduce(operation: (acc: S, T) -> S): List<S> {
    if (isEmpty()) return emptyList()
    var accumulator: S = this[0]
    val result = ArrayList<S>(size).apply { add(accumulator) }
    for (index in 1 until size) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

inline fun <S : Comparable<T>, T : S> PrimitiveArray<out T>.runningReduceIndexed(operation: (index: Int, acc: S, T) -> S): List<S> {
    if (isEmpty()) return emptyList()
    var accumulator: S = this[0]
    val result = ArrayList<S>(size).apply { add(accumulator) }
    for (index in 1 until size) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.scan(initial: R, operation: (acc: R, T) -> R): List<R> {
    return runningFold(initial, operation)
}

inline fun <T : Comparable<T>, R> PrimitiveArray<out T>.scanIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R,
): List<R> {
    return runningFoldIndexed(initial, operation)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun <T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun <T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun <T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
inline fun <T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
inline fun <T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

inline fun <T : Comparable<T>> PrimitiveArray<out T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
    val first = ArrayList<T>()
    val second = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

public infix fun <T : Comparable<T>, R> PrimitiveArray<out T>.zip(other: Array<out R>): List<Pair<T, R>> {
    return zip(other) { t1, t2 -> t1 to t2 }
}

public inline fun <T : Comparable<T>, R, V> PrimitiveArray<out T>.zip(
    other: Array<out R>,
    transform: (a: T, b: R) -> V,
): List<V> {
    val size = minOf(size, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

public infix fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.zip(other: PrimitiveArray<out R>): List<Pair<T, R>> {
    return zip(other) { t1, t2 -> t1 to t2 }
}

public inline fun <T : Comparable<T>, R : Comparable<R>, V> PrimitiveArray<out T>.zip(
    other: PrimitiveArray<out R>,
    transform: (a: T, b: R) -> V,
): List<V> {
    val size = minOf(size, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

public infix fun <T : Comparable<T>, R> PrimitiveArray<out T>.zip(other: Iterable<R>): List<Pair<T, R>> {
    return zip(other) { t1, t2 -> t1 to t2 }
}

public inline fun <T : Comparable<T>, R, V> PrimitiveArray<out T>.zip(
    other: Iterable<R>,
    transform: (a: T, b: R) -> V,
): List<V> {
    val arraySize = size
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

internal fun <T> Appendable.appendElement(element: T, transform: ((T) -> CharSequence)?) {
    when {
        transform != null -> append(transform(element))
        element is CharSequence? -> append(element)
        element is Char -> append(element)
        else -> append(element.toString())
    }
}

public fun <T : Comparable<T>, A : Appendable> PrimitiveArray<out T>.joinTo(
    buffer: A,
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null,
): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit) {
            buffer.appendElement(element, transform)
        } else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}


fun <T : Comparable<T>> PrimitiveArray<out T>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null,
): String {
    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
}

fun <T : Comparable<T>> PrimitiveArray<out T>.asIterable(): Iterable<T> {
    if (isEmpty()) return emptyList()
    return Iterable { this.iterator() }
}

fun <T : Comparable<T>> PrimitiveArray<out T>.asSequence(): Sequence<T> {
    if (isEmpty()) return emptySequence()
    return Sequence { this.iterator() }
}

fun <T : Comparable<T>> PrimitiveArray<T>.sliceArray(indices: Collection<Int>): PrimitiveArray<T> {
    val result = newArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices) {
        result[targetIndex++] = this[sourceIndex]
    }
    return result
}

fun <T : Comparable<T>> PrimitiveArray<T>.sliceArray(indices: IntRange): PrimitiveArray<T> {
    if (indices.isEmpty()) return copyOfRange(0, 0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

fun <T : Comparable<T>> PrimitiveArray<T>.reverse(): Unit {
    val midPoint = (size / 2) - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

internal fun checkRangeIndexes(fromIndex: Int, toIndex: Int, size: Int) {
    if (fromIndex < 0 || toIndex > size) {
        throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
    }
    if (fromIndex > toIndex) {
        throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
    }
}

@SinceKotlin("1.4")
fun <T : Comparable<T>> PrimitiveArray<T>.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

fun <T : Comparable<T>> PrimitiveArray<T>.reversedArray(): PrimitiveArray<T> {
    if (isEmpty()) return this
    val result = newArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

@SinceKotlin("1.4")
fun <T : Comparable<T>> PrimitiveArray<T>.shuffle(): Unit {
    shuffle(Random)
}

@SinceKotlin("1.4")
fun <T : Comparable<T>> PrimitiveArray<T>.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

//inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortBy(crossinline selector: (T) -> R?): Unit {
//    if (size > 1) sortWith(compareBy(selector))
//}
//
//inline fun <T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortByDescending(crossinline selector: (T) -> R?): Unit {
//    if (size > 1) sortWith(compareByDescending(selector))
//}

fun <T : Comparable<T>> PrimitiveArray<out T>.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

fun <T : Comparable<T>> PrimitiveArray<out T>.sorted(): List<T> {
    return sortedArray().asList()
}

fun <T : Comparable<T>> PrimitiveArray<T>.sortedArray(): PrimitiveArray<T> {
    if (isEmpty()) return this
    return this.copyOf().apply { sort() }
}

