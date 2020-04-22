package ru.smak.components

import GameData
import java.awt.Graphics
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JPanel

class GameField(val gameData: GameData) : JPanel(){

    val cells: Array<GameCell>

    init{
        GameCell.fieldHeight = height
        GameCell.fieldWidth = width
        gameData.addOnSetRoleListener {
            GameCell.clickRole = gameData.clickRole
        }
        layout = null
        cells = Array(GameCell.ROW_COUNT * GameCell.COL_COUNT)
                               {
                                   GameCell(
                                       it / GameCell.COL_COUNT,
                                       it % GameCell.COL_COUNT
                                   )
                               }
        cells.forEach { add(it) }

        addComponentListener(object : ComponentAdapter(){
            override fun componentShown(e: ComponentEvent?) {
                super.componentShown(e)
                GameCell.fieldHeight = height
                GameCell.fieldWidth = width
                cells.forEach { it.updateBounds() }
            }

            override fun componentResized(e: ComponentEvent?) {
                GameCell.fieldHeight = height
                GameCell.fieldWidth = width
                cells.forEach { it.updateBounds() }
            }
        })
        //GameCell.clickRole = Status.X//////////
        //GameCell.clickable = true//////////////
    }

}