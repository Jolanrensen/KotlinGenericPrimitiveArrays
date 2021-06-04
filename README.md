# KotlinGenericPrimitiveArrays
Provides a wrapper around all primitive arrays using a sealed interface and value class as to provide a generic way to work with any type of generic array. All the 1.5.10 standard library functions are included as well.


Documentation is still lacking, as well as an easy-to-import gradle project.


Not sure if it works for multiplatform as well, but I imagine it does, although the benifits might be negligable.


# Goal
Primitive arrays are a lot faster than Object/Any arrays. In Kotlin this is the difference between an `Array<Double>` and a `DoubleArray`. There is however no way currently for a function to request any primitive array. This can also be seen in the Kotlin standard library, where each primitive array has its own `.reverse()` function for example.

This solves that issue. One `.reverse()` function can invert any `PrimitiveArray`.

The interface `PrimitiveArray<T>` is sealed, so only the classes in the file can implement it. These are `PrimitiveByteArray`, `PrimitiveCharArray`, `PrimitiveShortArray`, `PrimitiveIntArray`, `PrimitiveLongArray`, `PrimitiveFloatArray`, `PrimitiveDoubleArray`, and `PrimitiveBooleanArray`, which are all value classes, so at compile time, they are inlined.

I also copied over all 1.5.10 standard library functions regarding arrays to work with `PrimitiveArray`s as well and modified them to work correctly (hopefully). I didn't manage to copy over the docs yet, but this is a proof of concept anyways.

As a bonus, `PrimitiveArray` implements `Collection` as well, so it's automatically an `Iterable` and has more standard library goodies.
