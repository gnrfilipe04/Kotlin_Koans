import java.util.*

fun <T, C : MutableCollection<T>> Iterable<T>.partitionTo(
    destination1: C,
    destination2: C,
    predicate: (T) -> Boolean
): Pair<C, C> {
    for (element in this) {
        if (predicate(element)) {
            destination1.add(element)
        } else {
            destination2.add(element)
        }
    }
    return Pair(destination1, destination2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
