import ru.smak.components.Status

class GameData private constructor(){

    companion object {
        private val gd = GameData()
        fun getInstance() = gd
    }
    var clickRole: Status = Status.NONE
        set(value) {
            field = value
            onSetRole.forEach { it.invoke() }
        }
    var clickable: Boolean = false

    var lastSetPos: Pair<Int, Int> = Pair(-1, -1)
        set(value) {
            field = value
            //onSetPosition()
        }

    private val onSetRole = mutableListOf<() -> Unit>()
    fun addOnSetRoleListener(l: () -> Unit) {
        onSetRole.add(l)
    }

    fun removeOnSetRoleListener(l: () -> Unit) {
        onSetRole.remove(l)
    }
}