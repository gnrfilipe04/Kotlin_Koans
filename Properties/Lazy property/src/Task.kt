class LazyProperty(val initializer: () -> Int) {
    private var _lazyValue: Int? = null
    val lazy: Int
        get() {

            if (_lazyValue == null) {

                _lazyValue = initializer()
            }

            return _lazyValue!!
        }
}
