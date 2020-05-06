import ru.smak.components.Status

class GameData private constructor(){

    companion object {
        private val gd = GameData()
        fun getInstance() = gd
    }

    var clickRole: Status = Status.NONE

    var clickable: Boolean = false

    var lastSetPos: Pair<Int, Int> = Pair(-1, -1)

    private val onGotPosition = mutableListOf<(Int, Int)->Unit>()

    fun addGotPositionListener(l: (Int, Int)->Unit){
        onGotPosition.add(l)
    }

    fun removeGotPositionListener(l: (Int, Int)->Unit){
        onGotPosition.remove(l)
    }

    var lastGotPos: Pair<Int, Int> = Pair(-1, -1)
    set(value) {
        field = value
        onGotPosition.forEach { it.invoke(field.first, field.second) }
    }

}