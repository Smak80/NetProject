import ru.smak.components.Status

class GameData private constructor(){

    companion object {
        private val gd = GameData()
        fun getInstance() = gd
    }

    var clickRole: Status = Status.NONE

    var clickable: Boolean = false

    var lastSetPos: Pair<Int, Int> = Pair(-1, -1)

}