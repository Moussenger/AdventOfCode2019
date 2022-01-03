package edu.mou.adventofcode.tools

fun <T> List<List<T>>.zip(): List<List<T>> {
    return zip(transform = { it })
}

inline fun <T, V> List<List<T>>.zip(transform: (List<T>) -> V): List<V> {
    val minSize = minOfOrNull(List<T>::size) ?: return emptyList()
    val list = ArrayList<V>(minSize)

    val iterators = map { it.iterator() }

    for (i in 0 until minSize) {
        list.add(transform(iterators.map { it.next() }))
    }

    return list
}