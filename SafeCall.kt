/**
 * Prevents [NullPointerException] in java
 */
object SafeCall {

    @JvmStatic
    fun <T : Any> get(block: () -> T): T? {
        return try {
            block.invoke()
        } catch (_: NullPointerException) {
            null
        }
    }
    
    @JvmStatic
    fun <T : Any> getOrElse(block: () -> T, default: T): T {
        return try {
            block.invoke()
        } catch (_: NullPointerException) {
            default
        }
    }

    @JvmStatic
    fun call(block: Runnable) {
        try {
            block.run()
        } catch (_: NullPointerException) {
        }
    }
}
