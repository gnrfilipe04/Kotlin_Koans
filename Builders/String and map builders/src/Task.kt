import java.util.HashMap

fun <K, V> buildMutableMap(builderAction: HashMap<K, V>.() -> Unit): MutableMap<K, V> {
    val map = HashMap<K, V>()
    map.builderAction()
    return map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
