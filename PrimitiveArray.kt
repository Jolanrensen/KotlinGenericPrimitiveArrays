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

    @Suppress("UNCHECKED_CAST")
    companion object {
        @Deprecated("CAUTION! The only supported types are: Byte, Char, Short, Int, Long, Float, Double, and Boolean. They cannot be mixed.")
        inline operator fun <reified T : Comparable<T>> invoke(size: Int): PrimitiveArray<T> =
            when (T::class) {
                Byte::class -> PrimitiveByteArray(size)
                Char::class -> PrimitiveCharArray(size)
                Short::class -> PrimitiveShortArray(size)
                Int::class -> PrimitiveIntArray(size)
                Long::class -> PrimitiveLongArray(size)
                Float::class -> PrimitiveFloatArray(size)
                Double::class -> PrimitiveDoubleArray(size)
                Boolean::class -> PrimitiveBooleanArray(size)
                else -> throw IllegalArgumentException("The type ${T::class} is not supported, only Byte, Char, Short, Int, Long, Float, Double, and Boolean are supported.")
            } as PrimitiveArray<T>

        @Deprecated("CAUTION! The only supported types are: Byte, Char, Short, Int, Long, Float, Double, and Boolean. They cannot be mixed.")
        inline operator fun <reified T : Comparable<T>> invoke(
            size: Int,
            noinline init: (index: Int) -> T,
        ): PrimitiveArray<T> =
            when (T::class) {
                Byte::class -> PrimitiveByteArray(size, init as (Int) -> Byte)
                Char::class -> PrimitiveCharArray(size, init as (Int) -> Char)
                Short::class -> PrimitiveShortArray(size, init as (Int) -> Short)
                Int::class -> PrimitiveIntArray(size, init as (Int) -> Int)
                Long::class -> PrimitiveLongArray(size, init as (Int) -> Long)
                Float::class -> PrimitiveFloatArray(size, init as (Int) -> Float)
                Double::class -> PrimitiveDoubleArray(size, init as (Int) -> Double)
                Boolean::class -> PrimitiveBooleanArray(size, init as (Int) -> Boolean)
                else -> throw IllegalArgumentException("The type ${T::class} is not supported, only Byte, Char, Short, Int, Long, Float, Double, and Boolean are supported.")
            } as PrimitiveArray<T>
    }
}

@Suppress("UNCHECKED_CAST")
@Deprecated("CAUTION! The only supported types are: Byte, Char, Short, Int, Long, Float, Double, and Boolean. They cannot be mixed.")
inline fun <reified T : Comparable<T>> primitiveArrayOf(vararg values: T): PrimitiveArray<T> =
    when (T::class) {
        Byte::class -> (values as Array<Byte>).toByteArray().asPrimitiveArray()
        Char::class -> (values as Array<Char>).toCharArray().asPrimitiveArray()
        Short::class -> (values as Array<Short>).toShortArray().asPrimitiveArray()
        Int::class -> (values as Array<Int>).toIntArray().asPrimitiveArray()
        Long::class -> (values as Array<Long>).toLongArray().asPrimitiveArray()
        Float::class -> (values as Array<Float>).toFloatArray().asPrimitiveArray()
        Double::class -> (values as Array<Double>).toDoubleArray().asPrimitiveArray()
        Boolean::class -> (values as Array<Boolean>).toBooleanArray().asPrimitiveArray()
        else -> throw IllegalArgumentException("The type ${T::class} is not supported, only Byte, Char, Short, Int, Long, Float, Double, and Boolean are supported.")
    } as PrimitiveArray<T>

@JvmInline
value class PrimitiveByteArray(override val actualData: ByteArray) : PrimitiveArray<Byte> {
    constructor(size: Int) : this(ByteArray(size))
    constructor(size: Int, init: (index: Int) -> Byte) : this(ByteArray(size, init))

    override inline fun get(index: Int): Byte = actualData[index]
    override inline fun set(index: Int, value: Byte): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Byte> = actualData.iterator()
    override inline fun copyOf(): PrimitiveByteArray = PrimitiveByteArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveByteArray = PrimitiveByteArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveByteArray =
        PrimitiveByteArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Byte, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Byte): PrimitiveByteArray = PrimitiveByteArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Byte>): PrimitiveByteArray =
        PrimitiveByteArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Byte>): PrimitiveByteArray =
        PrimitiveByteArray(actualData.plus(elements.data))

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

inline fun primitiveByteArrayOf(vararg values: Byte): PrimitiveByteArray = byteArrayOf(*values).asPrimitiveArray()

inline fun ByteArray.asPrimitiveArray() = PrimitiveByteArray(this)

val PrimitiveArray<out Byte>.data: ByteArray
    get() = actualData as ByteArray

@JvmInline
value class PrimitiveCharArray(override val actualData: CharArray) : PrimitiveArray<Char> {
    constructor(size: Int) : this(CharArray(size))
    constructor(size: Int, init: (index: Int) -> Char) : this(CharArray(size, init))

    override inline fun get(index: Int): Char = actualData[index]
    override inline fun set(index: Int, value: Char): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Char> = actualData.iterator()
    override inline fun copyOf(): PrimitiveCharArray = PrimitiveCharArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveCharArray = PrimitiveCharArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveCharArray =
        PrimitiveCharArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Char, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Char): PrimitiveCharArray = PrimitiveCharArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Char>): PrimitiveCharArray =
        PrimitiveCharArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Char>): PrimitiveCharArray =
        PrimitiveCharArray(actualData.plus(elements.data))

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

inline fun primitiveCharArrayOf(vararg values: Char): PrimitiveCharArray = charArrayOf(*values).asPrimitiveArray()

inline fun CharArray.asPrimitiveArray() = PrimitiveCharArray(this)

val PrimitiveArray<out Char>.data: CharArray
    get() = actualData as CharArray

@JvmInline
value class PrimitiveShortArray(override val actualData: ShortArray) : PrimitiveArray<Short> {
    constructor(size: Int) : this(ShortArray(size))
    constructor(size: Int, init: (index: Int) -> Short) : this(ShortArray(size, init))

    override inline fun get(index: Int): Short = actualData[index]
    override inline fun set(index: Int, value: Short): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Short> = actualData.iterator()
    override inline fun copyOf(): PrimitiveShortArray = PrimitiveShortArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveShortArray = PrimitiveShortArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveShortArray =
        PrimitiveShortArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Short, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Short): PrimitiveShortArray =
        PrimitiveShortArray(actualData.plus(element))

    override inline operator fun plus(elements: Collection<Short>): PrimitiveShortArray =
        PrimitiveShortArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Short>): PrimitiveShortArray =
        PrimitiveShortArray(actualData.plus(elements.data))

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

inline fun primitiveShortArrayOf(vararg values: Short): PrimitiveShortArray = shortArrayOf(*values).asPrimitiveArray()

inline fun ShortArray.asPrimitiveArray() = PrimitiveShortArray(this)

val PrimitiveArray<out Short>.data: ShortArray
    get() = actualData as ShortArray

@JvmInline
value class PrimitiveIntArray(override val actualData: IntArray) : PrimitiveArray<Int> {
    constructor(size: Int) : this(IntArray(size))
    constructor(size: Int, init: (index: Int) -> Int) : this(IntArray(size, init))

    override inline fun get(index: Int): Int = actualData[index]
    override inline fun set(index: Int, value: Int): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Int> = actualData.iterator()
    override inline fun copyOf(): PrimitiveIntArray = PrimitiveIntArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveIntArray = PrimitiveIntArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveIntArray =
        PrimitiveIntArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Int, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Int): PrimitiveIntArray = PrimitiveIntArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Int>): PrimitiveIntArray =
        PrimitiveIntArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Int>): PrimitiveIntArray =
        PrimitiveIntArray(actualData.plus(elements.data))

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

inline fun primitiveIntArrayOf(vararg values: Int): PrimitiveIntArray = intArrayOf(*values).asPrimitiveArray()

inline fun IntArray.asPrimitiveArray() = PrimitiveIntArray(this)

val PrimitiveArray<out Int>.data: IntArray
    get() = actualData as IntArray

@JvmInline
value class PrimitiveLongArray(override val actualData: LongArray) : PrimitiveArray<Long> {
    constructor(size: Int) : this(LongArray(size))
    constructor(size: Int, init: (index: Int) -> Long) : this(LongArray(size, init))

    override inline fun get(index: Int): Long = actualData[index]
    override inline fun set(index: Int, value: Long): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Long> = actualData.iterator()
    override inline fun copyOf(): PrimitiveLongArray = PrimitiveLongArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveLongArray = PrimitiveLongArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveLongArray =
        PrimitiveLongArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Long, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Long): PrimitiveLongArray = PrimitiveLongArray(actualData.plus(element))
    override inline operator fun plus(elements: Collection<Long>): PrimitiveLongArray =
        PrimitiveLongArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Long>): PrimitiveLongArray =
        PrimitiveLongArray(actualData.plus(elements.data))

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

inline fun primitiveLongArrayOf(vararg values: Long): PrimitiveLongArray = longArrayOf(*values).asPrimitiveArray()

inline fun LongArray.asPrimitiveArray() = PrimitiveLongArray(this)

val PrimitiveArray<out Long>.data: LongArray
    get() = actualData as LongArray

@JvmInline
value class PrimitiveFloatArray(override val actualData: FloatArray) : PrimitiveArray<Float> {
    constructor(size: Int) : this(FloatArray(size))
    constructor(size: Int, init: (index: Int) -> Float) : this(FloatArray(size, init))

    override inline fun get(index: Int): Float = actualData[index]
    override inline fun set(index: Int, value: Float): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Float> = actualData.iterator()
    override inline fun copyOf(): PrimitiveFloatArray = PrimitiveFloatArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveFloatArray = PrimitiveFloatArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveFloatArray =
        PrimitiveFloatArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Float, fromIndex: Int, toIndex: Int): Unit = actualData.fill(element, fromIndex, toIndex)
    override inline operator fun plus(element: Float): PrimitiveFloatArray =
        PrimitiveFloatArray(actualData.plus(element))

    override inline operator fun plus(elements: Collection<Float>): PrimitiveFloatArray =
        PrimitiveFloatArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Float>): PrimitiveFloatArray =
        PrimitiveFloatArray(actualData.plus(elements.data))

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

inline fun primitiveFloatArrayOf(vararg values: Float): PrimitiveFloatArray = floatArrayOf(*values).asPrimitiveArray()

inline fun FloatArray.asPrimitiveArray() = PrimitiveFloatArray(this)

val PrimitiveArray<out Float>.data: FloatArray
    get() = actualData as FloatArray

@JvmInline
value class PrimitiveDoubleArray(override val actualData: DoubleArray) : PrimitiveArray<Double> {
    constructor(size: Int) : this(DoubleArray(size))
    constructor(size: Int, init: (index: Int) -> Double) : this(DoubleArray(size, init))

    override inline fun get(index: Int): Double = actualData[index]
    override inline fun set(index: Int, value: Double): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Double> = actualData.iterator()
    override inline fun copyOf(): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveDoubleArray = PrimitiveDoubleArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveDoubleArray =
        PrimitiveDoubleArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Double, fromIndex: Int, toIndex: Int): Unit =
        actualData.fill(element, fromIndex, toIndex)

    override inline operator fun plus(element: Double): PrimitiveDoubleArray =
        PrimitiveDoubleArray(actualData.plus(element))

    override inline operator fun plus(elements: Collection<Double>): PrimitiveDoubleArray =
        PrimitiveDoubleArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Double>): PrimitiveDoubleArray =
        PrimitiveDoubleArray(actualData.plus(elements.data))

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

inline fun primitiveDoubleArrayOf(vararg values: Double): PrimitiveDoubleArray =
    doubleArrayOf(*values).asPrimitiveArray()

inline fun DoubleArray.asPrimitiveArray() = PrimitiveDoubleArray(this)

val PrimitiveArray<out Double>.data: DoubleArray
    get() = actualData as DoubleArray

@JvmInline
value class PrimitiveBooleanArray(override val actualData: BooleanArray) : PrimitiveArray<Boolean> {
    constructor(size: Int) : this(BooleanArray(size))
    constructor(size: Int, init: (index: Int) -> Boolean) : this(BooleanArray(size, init))

    override inline fun get(index: Int): Boolean = actualData[index]
    override inline fun set(index: Int, value: Boolean): Unit = actualData.set(index, value)
    override inline val size: Int get() = actualData.size
    override inline fun iterator(): Iterator<Boolean> = actualData.iterator()
    override inline fun copyOf(): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.copyOf())
    override inline fun copyOf(newSize: Int): PrimitiveBooleanArray = PrimitiveBooleanArray(actualData.copyOf(newSize))
    override inline fun copyOfRange(fromIndex: Int, toIndex: Int): PrimitiveBooleanArray =
        PrimitiveBooleanArray(actualData.copyOfRange(fromIndex, toIndex))

    override fun fill(element: Boolean, fromIndex: Int, toIndex: Int): Unit =
        actualData.fill(element, fromIndex, toIndex)

    override inline operator fun plus(element: Boolean): PrimitiveBooleanArray =
        PrimitiveBooleanArray(actualData.plus(element))

    override inline operator fun plus(elements: Collection<Boolean>): PrimitiveBooleanArray =
        PrimitiveBooleanArray(actualData.plus(elements))

    override inline operator fun plus(elements: PrimitiveArray<out Boolean>): PrimitiveBooleanArray =
        PrimitiveBooleanArray(actualData.plus(elements.data))

    override inline fun asList(): List<Boolean> = actualData.asList()
    override inline fun sort(): Unit = throw UnsupportedOperationException("Boolean Arrays do not support sorting.")
    override fun sort(fromIndex: Int, toIndex: Int): Unit =
        throw UnsupportedOperationException("Boolean Arrays do not support sorting.")

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

inline fun primitiveBooleanArrayOf(vararg values: Boolean): PrimitiveBooleanArray =
    booleanArrayOf(*values).asPrimitiveArray()

inline fun BooleanArray.asPrimitiveArray() = PrimitiveBooleanArray(this)

val PrimitiveArray<out Boolean>.data: BooleanArray
    get() = actualData as BooleanArray


inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.component1(): T {
    return get(0)
}


inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.component2(): T {
    return get(1)
}


inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.component3(): T {
    return get(2)
}


inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.component4(): T {
    return get(3)
}


inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.component5(): T {
    return get(4)
}

/**
 * Returns `true` if [element] is found in the array.
 */
@Suppress("UNCHECKED_CAST")
inline operator fun <reified T : Comparable<T>> PrimitiveArray<out T>.contains(element: T): Boolean {
    return (this as PrimitiveArray<T>).indexOf(element) >= 0
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.elementAtOrElse(index: Int, defaultValue: (Int) -> T): T {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.elementAtOrNull(index: Int): T? {
    return getOrNull<T>(index)
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.find(predicate: (T) -> Boolean): T? {
    return firstOrNull<T>(predicate)
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.findLast(predicate: (T) -> Boolean): T? {
    return lastOrNull<T>(predicate)
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.first(predicate: (T) -> Boolean): T {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

inline fun <reified T : Comparable<T>, R : Any> PrimitiveArray<out T>.firstNotNullOf(transform: (T) -> R?): R {
    return firstNotNullOfOrNull<T, R>(transform)
        ?: throw NoSuchElementException("No element of the array was transformed to a non-null value.")
}

inline fun <reified T : Comparable<T>, R : Any> PrimitiveArray<out T>.firstNotNullOfOrNull(transform: (T) -> R?): R? {
    for (element in this) {
        val result = transform(element)
        if (result != null) {
            return result
        }
    }
    return null
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.firstOrNull(): T? {
    return if (isEmpty()) null else this[0]
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.firstOrNull(predicate: (T) -> Boolean): T? {
    for (element in this) if (predicate(element)) return element
    return null
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.getOrElse(index: Int, defaultValue: (Int) -> T): T {
    return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.getOrNull(index: Int): T? {
    return if (index >= 0 && index <= lastIndex) get(index) else null
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.indexOf(element: T): Int {
    for (index in indices) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.indexOfFirst(predicate: (T) -> Boolean): Int {
    for (index in indices) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.indexOfLast(predicate: (T) -> Boolean): Int {
    for (index in indices.reversed()) {
        if (predicate(this[index])) {
            return index
        }
    }
    return -1
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.last(): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.last(predicate: (T) -> Boolean): T {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.lastIndexOf(element: T): Int {
    for (index in indices.reversed()) {
        if (element == this[index]) {
            return index
        }
    }
    return -1
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.lastOrNull(): T? {
    return if (isEmpty()) null else this[size - 1]
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.lastOrNull(predicate: (T) -> Boolean): T? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.random(): T {
    return random<T>(Random)
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.random(random: Random): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return get(random.nextInt(size))
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.randomOrNull(): T? {
    return randomOrNull<T>(Random)
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.randomOrNull(random: Random): T? {
    if (isEmpty())
        return null
    return get(random.nextInt(size))
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.single(): T {
    return when (size) {
        0 -> throw NoSuchElementException("Array is empty.")
        1 -> this[0]
        else -> throw IllegalArgumentException("Array has more than one element.")
    }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.single(predicate: (T) -> Boolean): T {
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.singleOrNull(): T? {
    return if (size == 1) this[0] else null
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.singleOrNull(predicate: (T) -> Boolean): T? {
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.drop(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast<T>((size - n).coerceAtLeast(0))
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.dropLast(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take<T>((size - n).coerceAtLeast(0))
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.dropLastWhile(predicate: (T) -> Boolean): List<T> {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return take<T>(index + 1)
        }
    }
    return emptyList()
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.dropWhile(predicate: (T) -> Boolean): List<T> {
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo<T, ArrayList<T>>(ArrayList(), predicate)
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.filterIndexed(predicate: (index: Int, T) -> Boolean): List<T> {
    return filterIndexedTo<T, ArrayList<T>>(ArrayList(), predicate)
}

inline fun <reified T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterIndexedTo(
    destination: C,
    predicate: (index: Int, T) -> Boolean,
): C {
    forEachIndexed<T> { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.filterNot(predicate: (T) -> Boolean): List<T> {
    return filterNotTo<T, ArrayList<T>>(ArrayList(), predicate)
}

inline fun <reified T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterNotTo(
    destination: C,
    predicate: (T) -> Boolean,
): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

inline fun <reified T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.filterTo(
    destination: C,
    predicate: (T) -> Boolean,
): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.slice(indices: IntRange): List<T> {
    if (indices.isEmpty()) return listOf()
    return copyOfRange(indices.start, indices.endInclusive + 1).asList()
}

inline fun <T> Iterable<T>.collectionSizeOrDefault(default: Int): Int =
    if (this is Collection<*>) this.size else default

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.slice(indices: Iterable<Int>): List<T> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<T>(size)
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.take(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList<T>()
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.takeLast(n: Int): List<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = size
    if (n >= size) return toList<T>()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<T>(n)
    for (index in size - n until size)
        list.add(this[index])
    return list
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.takeLastWhile(predicate: (T) -> Boolean): List<T> {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return drop<T>(index + 1)
        }
    }
    return toList<T>()
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.takeWhile(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        if (!predicate(item))
            break
        list.add(item)
    }
    return list
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.reversed(): List<T> {
    if (isEmpty()) return emptyList()
    val list = toMutableList<T>()
    list.reverse()
    return list
}

//fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortedArrayWith(comparator: Comparator<in T>): PrimitiveArray<out T> {
//    if (isEmpty()) return this
//    return this.copyOf().apply { sortWith(comparator) }
//}

inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortedBy(crossinline selector: (T) -> R?): List<T> {
    return sortedWith<T>(compareBy(selector))
}

inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortedByDescending(crossinline selector: (T) -> R?): List<T> {
    return sortedWith<T>(compareByDescending(selector))
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortedDescending(): List<T> {
    return sortedWith<T>(reverseOrder<T>())
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortedWith(comparator: Comparator<in T>): List<T> {
    return toTypedArray().apply { sortWith(comparator) }.asList()
}

inline val PrimitiveArray<*>.indices: IntRange
    get() = IntRange(0, lastIndex)


inline fun PrimitiveArray<*>.isNotEmpty(): Boolean {
    return !isEmpty()
}

inline val PrimitiveArray<*>.lastIndex: Int
    get() = size - 1

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    (this as PrimitiveArray<T>).reverse<T>(fromIndex, toIndex)
}

inline fun <reified T : Comparable<T>, K, V> PrimitiveArray<out T>.associate(transform: (T) -> Pair<K, V>): Map<K, V> {
    return associateTo<T, K, V, LinkedHashMap<K, V>>(LinkedHashMap(), transform)
}

inline fun <reified T : Comparable<T>, K> PrimitiveArray<out T>.associateBy(keySelector: (T) -> K): Map<K, T> {
    return associateByTo<T, K, LinkedHashMap<K, T>>(LinkedHashMap(), keySelector)
}

inline fun <reified T : Comparable<T>, K, V> PrimitiveArray<out T>.associateBy(
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): Map<K, V> {
    return associateByTo<T, K, V, LinkedHashMap<K, V>>(LinkedHashMap(), keySelector, valueTransform)
}

inline fun <reified T : Comparable<T>, K, M : MutableMap<in K, in T>> PrimitiveArray<out T>.associateByTo(
    destination: M,
    keySelector: (T) -> K,
): M {
    for (element in this) {
        destination.put(keySelector(element), element)
    }
    return destination
}

inline fun <reified T : Comparable<T>, K, V, M : MutableMap<in K, in V>> PrimitiveArray<out T>.associateByTo(
    destination: M,
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): M {
    for (element in this) {
        destination.put(keySelector(element), valueTransform(element))
    }
    return destination
}

inline fun <reified T : Comparable<T>, K, V, M : MutableMap<in K, in V>> PrimitiveArray<out T>.associateTo(
    destination: M,
    transform: (T) -> Pair<K, V>,
): M {
    for (element in this) {
        destination += transform(element)
    }
    return destination
}

inline fun <reified T : Comparable<T>, C : MutableCollection<in T>> PrimitiveArray<out T>.toCollection(destination: C): C {
    for (item in this) {
        destination.add(item)
    }
    return destination
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.toHashSet(): HashSet<T> {
    return toCollection<T, HashSet<T>>(HashSet(mapCapacity(size)))
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.toList(): List<T> {
    return when (size) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList<T>()
    }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.toMutableList(): MutableList<T> {
    return ArrayList<T>(this)
}

private const val INT_MAX_POWER_OF_TWO: Int = 1 shl (Int.SIZE_BITS - 2)

fun mapCapacity(expectedSize: Int): Int = when {
    // We are not coercing the value to a valid one and not throwing an exception. It is up to the caller to
    // properly handle negative values.
    expectedSize < 0 -> expectedSize
    expectedSize < 3 -> expectedSize + 1
    expectedSize < INT_MAX_POWER_OF_TWO -> ((expectedSize / 0.75F) + 1.0F).toInt()
    // any large value
    else -> Int.MAX_VALUE
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.toSet(): Set<T> {
    return when (size) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection<T, LinkedHashSet<T>>(LinkedHashSet(mapCapacity(size)))
    }
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
    return flatMapTo<T, R, ArrayList<R>>(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapSequence")
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.flatMap(transform: (T) -> Sequence<R>): List<R> {
    return flatMapTo<T, R, ArrayList<R>>(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.flatMapIndexed(transform: (index: Int, T) -> Iterable<R>): List<R> {
    return flatMapIndexedTo<T, R, ArrayList<R>>(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedSequence")
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.flatMapIndexed(transform: (index: Int, T) -> Sequence<R>): List<R> {
    return flatMapIndexedTo<T, R, ArrayList<R>>(ArrayList<R>(), transform)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapIndexedTo(
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
inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapIndexedTo(
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

inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapTo(
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
inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.flatMapTo(
    destination: C,
    transform: (T) -> Sequence<R>,
): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Comparable<T>, K> PrimitiveArray<out T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
    return (this as PrimitiveArray<T>).groupByTo(LinkedHashMap(), keySelector)
}

inline fun <reified T : Comparable<T>, K, V> PrimitiveArray<out T>.groupBy(
    keySelector: (T) -> K,
    valueTransform: (T) -> V,
): Map<K, List<V>> {
    return groupByTo<T, K, V, LinkedHashMap<K, MutableList<V>>>(LinkedHashMap(), keySelector, valueTransform)
}

inline fun <reified T : Comparable<T>, K, M : MutableMap<in K, MutableList<T>>> PrimitiveArray<out T>.groupByTo(
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

inline fun <reified T : Comparable<T>, K, V, M : MutableMap<in K, MutableList<V>>> PrimitiveArray<out T>.groupByTo(
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

inline fun <reified T : Comparable<T>, K> PrimitiveArray<out T>.groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K> {
    return object : Grouping<T, K> {
        override fun sourceIterator(): Iterator<T> = this@groupingBy.iterator()
        override fun keyOf(element: T): K = keySelector(element)
    }
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.map(transform: (T) -> R): List<R> {
    return mapTo<T, R, ArrayList<R>>(ArrayList(size), transform)
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.mapIndexed(transform: (index: Int, T) -> R): List<R> {
    return mapIndexedTo<T, R, ArrayList<R>>(ArrayList(size), transform)
}

inline fun <reified T : Comparable<T>, R : Any> PrimitiveArray<out T>.mapIndexedNotNull(transform: (index: Int, T) -> R?): List<R> {
    return mapIndexedNotNullTo<T, R, ArrayList<R>>(ArrayList(), transform)
}

inline fun <reified T : Comparable<T>, R : Any, C : MutableCollection<in R>> PrimitiveArray<out T>.mapIndexedNotNullTo(
    destination: C,
    transform: (index: Int, T) -> R?,
): C {
    forEachIndexed<T> { index, element -> transform(index, element)?.let { destination.add(it) } }
    return destination
}

inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.mapIndexedTo(
    destination: C,
    transform: (index: Int, T) -> R,
): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}

inline fun <reified T : Comparable<T>, R : Any> PrimitiveArray<out T>.mapNotNull(transform: (T) -> R?): List<R> {
    return mapNotNullTo<T, R, ArrayList<R>>(ArrayList(), transform)
}

inline fun <reified T : Comparable<T>, R : Any, C : MutableCollection<in R>> PrimitiveArray<out T>.mapNotNullTo(
    destination: C,
    transform: (T) -> R?,
): C {
    forEach { element -> transform(element)?.let { destination.add(it) } }
    return destination
}

inline fun <reified T : Comparable<T>, R, C : MutableCollection<in R>> PrimitiveArray<out T>.mapTo(
    destination: C,
    transform: (T) -> R,
): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}


class IndexingIterator<out T>(private val iterator: Iterator<T>) : Iterator<IndexedValue<T>> {
    private var index = 0
    final override fun hasNext(): Boolean = iterator.hasNext()
    final override fun next(): IndexedValue<T> = IndexedValue(index++, iterator.next())
}

class IndexingIterable<out T>(private val iteratorFactory: () -> Iterator<T>) : Iterable<IndexedValue<T>> {
    override fun iterator(): Iterator<IndexedValue<T>> = IndexingIterator(iteratorFactory())
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.withIndex(): Iterable<IndexedValue<T>> {
    return IndexingIterable { iterator() }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.distinct(): List<T> {
    return toMutableSet<T>().toList()
}

inline fun <reified T : Comparable<T>, K> PrimitiveArray<out T>.distinctBy(selector: (T) -> K): List<T> {
    val set = HashSet<K>()
    val list = ArrayList<T>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

inline infix fun <reified T : Comparable<T>> PrimitiveArray<out T>.intersect(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = toMutableSet<T>()
    set.retainAll(other)
    return set
}

inline infix fun <reified T : Comparable<T>> PrimitiveArray<out T>.subtract(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = toMutableSet<T>()
    set.removeAll(other)
    return set
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.toMutableSet(): MutableSet<T> {
    return toCollection<T, LinkedHashSet<T>>(LinkedHashSet(mapCapacity(size)))
}

inline infix fun <reified T : Comparable<T>> PrimitiveArray<out T>.union(other: Iterable<T>): Set<T> {
    val set: MutableSet<T> = toMutableSet<T>()
    set.addAll(other)
    return set
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.all(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.any(): Boolean {
    return !isEmpty()
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.any(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.count(): Int {
    return size
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.count(predicate: (T) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.fold(initial: R, operation: (acc: R, T) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.foldIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R,
): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.foldRight(initial: R, operation: (T, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.foldRightIndexed(
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.forEachIndexed(action: (index: Int, T) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxByOrNull(selector: (T) -> R): T? {
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
inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxOf(selector: (T) -> R): R {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxOf(selector: (T) -> Double): Double {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxOf(selector: (T) -> Float): Float {
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
inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> R): R? {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> Double): Double? {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxOfOrNull(selector: (T) -> Float): Float? {
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
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.maxOfWith(
    comparator: Comparator<in R>,
    selector: (T) -> R,
): R {
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
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.maxOfWithOrNull(
    comparator: Comparator<in R>,
    selector: (T) -> R,
): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0] as T)
    for (i in 1..lastIndex) {
        val v = selector(this[i] as T)
        if (comparator.compare(maxValue, v) < 0) {
            maxValue = v
        }
    }
    return maxValue
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxOrNull(): T? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.maxWithOrNull(comparator: Comparator<in T>): T? {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minOf(selector: (T) -> Double): Double {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minOf(selector: (T) -> Float): Float {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> Double): Double? {
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
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minWithOrNull(comparator: Comparator<in T>): T? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minByOrNull(selector: (T) -> R): T? {
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

inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minOf(selector: (T) -> R): R {
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
inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.minOfOrNull(selector: (T) -> R): R? {
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
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.minOfWith(
    comparator: Comparator<in R>,
    selector: (T) -> R,
): R {
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
inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.minOfWithOrNull(
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

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.minOrNull(): T? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.none(): Boolean {
    return isEmpty()
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.none(predicate: (T) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.onEach(action: (T) -> Unit): PrimitiveArray<out T> {
    return apply { for (element in this) action(element) }
}


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.onEachIndexed(action: (index: Int, T) -> Unit): PrimitiveArray<out T> {
    return apply { forEachIndexed<T>(action) }
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduce(operation: (acc: S, T) -> S): S {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceIndexed(operation: (index: Int, acc: S, T) -> S): S {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(index, accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceIndexedOrNull(operation: (index: Int, acc: S, T) -> S): S? {
    if (isEmpty())
        return null
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(index, accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceOrNull(operation: (acc: S, T) -> S): S? {
    if (isEmpty())
        return null
    var accumulator: S = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceRight(operation: (T, acc: S) -> S): S {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceRightIndexed(operation: (index: Int, T, acc: S) -> S): S {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceRightIndexedOrNull(operation: (index: Int, T, acc: S) -> S): S? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.reduceRightOrNull(operation: (T, acc: S) -> S): S? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator: S = get(index--)
    while (index >= 0) {
        accumulator = operation(get(index--), accumulator)
    }
    return accumulator
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.runningFold(
    initial: R,
    operation: (acc: R, T) -> R,
): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(size + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.runningFoldIndexed(
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

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.runningReduce(operation: (acc: S, T) -> S): List<S> {
    if (isEmpty()) return emptyList()
    var accumulator: S = this[0]
    val result = ArrayList<S>(size).apply { add(accumulator) }
    for (index in 1 until size) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

inline fun <S : Comparable<T>, reified T : S> PrimitiveArray<out T>.runningReduceIndexed(operation: (index: Int, acc: S, T) -> S): List<S> {
    if (isEmpty()) return emptyList()
    var accumulator: S = this[0]
    val result = ArrayList<S>(size).apply { add(accumulator) }
    for (index in 1 until size) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.scan(initial: R, operation: (acc: R, T) -> R): List<R> {
    return runningFold<T, R>(initial, operation)
}

inline fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.scanIndexed(
    initial: R,
    operation: (index: Int, acc: R, T) -> R,
): List<R> {
    return runningFoldIndexed<T, R>(initial, operation)
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sumOf(selector: (T) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
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

inline infix fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.zip(other: Array<out R>): List<Pair<T, R>> {
    return zip<T, R, Pair<T, R>>(other) { t1, t2 -> t1 to t2 }
}

inline fun <reified T : Comparable<T>, R, V> PrimitiveArray<out T>.zip(
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

inline infix fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.zip(other: PrimitiveArray<out R>): List<Pair<T, R>> {
    return zip<T, R, Pair<T, R>>(other) { t1, t2 -> t1 to t2 }
}

inline fun <reified T : Comparable<T>, R : Comparable<R>, V> PrimitiveArray<out T>.zip(
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

inline infix fun <reified T : Comparable<T>, R> PrimitiveArray<out T>.zip(other: Iterable<R>): List<Pair<T, R>> {
    return zip<T, R, Pair<T, R>>(other) { t1, t2 -> t1 to t2 }
}

inline fun <reified T : Comparable<T>, R, V> PrimitiveArray<out T>.zip(
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

inline fun <reified T> Appendable.appendElement(element: T, noinline transform: ((T) -> CharSequence)?) {
    when {
        transform != null -> append(transform(element))
        element is CharSequence? -> append(element)
        element is Char -> append(element)
        else -> append(element.toString())
    }
}

inline fun <reified T : Comparable<T>, A : Appendable> PrimitiveArray<out T>.joinTo(
    buffer: A,
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    noinline transform: ((T) -> CharSequence)? = null,
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


inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    noinline transform: ((T) -> CharSequence)? = null,
): String {
    return joinTo<T, StringBuilder>(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.asIterable(): Iterable<T> {
    if (isEmpty()) return emptyList()
    return Iterable { this.iterator() }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.asSequence(): Sequence<T> {
    if (isEmpty()) return emptySequence()
    return Sequence { this.iterator() }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<T>.sliceArray(indices: Collection<Int>): PrimitiveArray<T> {
    val result = newArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices) {
        result[targetIndex++] = this[sourceIndex]
    }
    return result
}

inline fun <reified T : Comparable<T>> PrimitiveArray<T>.sliceArray(indices: IntRange): PrimitiveArray<T> {
    if (indices.isEmpty()) return copyOfRange(0, 0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

inline fun <reified T : Comparable<T>> PrimitiveArray<T>.reverse(): Unit {
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

fun checkRangeIndexes(fromIndex: Int, toIndex: Int, size: Int) {
    if (fromIndex < 0 || toIndex > size) {
        throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
    }
    if (fromIndex > toIndex) {
        throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
    }
}

@SinceKotlin("1.4")
inline fun <reified T : Comparable<T>> PrimitiveArray<T>.reverse(fromIndex: Int, toIndex: Int): Unit {
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

inline fun <reified T : Comparable<T>> PrimitiveArray<T>.reversedArray(): PrimitiveArray<T> {
    if (isEmpty()) return this
    val result = newArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

@SinceKotlin("1.4")
inline fun <reified T : Comparable<T>> PrimitiveArray<T>.shuffle(): Unit {
    shuffle(Random)
}

@SinceKotlin("1.4")
inline fun <reified T : Comparable<T>> PrimitiveArray<T>.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

//inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortBy(crossinline selector: (T) -> R?): Unit {
//    if (size > 1) sortWith(compareBy(selector))
//}
//
//inline fun <reified T : Comparable<T>, R : Comparable<R>> PrimitiveArray<out T>.sortByDescending(crossinline selector: (T) -> R?): Unit {
//    if (size > 1) sortWith(compareByDescending(selector))
//}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortDescending(): Unit {
    if (size > 1) {
        sort()
        (this as PrimitiveArray<T>).reverse<T>()
    }
}

inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sorted(): List<T> {
    return sortedArray<T>().asList()
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Comparable<T>> PrimitiveArray<out T>.sortedArray(): PrimitiveArray<T> {
    return (if (isEmpty()) this else this.copyOf().apply { sort() }) as PrimitiveArray<T>
}

