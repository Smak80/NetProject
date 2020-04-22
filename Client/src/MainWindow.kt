package ru.smak

import ru.smak.components.GameField
import java.awt.Color
import java.awt.Dimension
import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.WindowConstants

class MainWindow : JFrame(){
    val field: GameField
    val btnStart: JButton
    init{
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 500)
        field = GameField()
        field.background = Color.WHITE
        btnStart = JButton()
        btnStart.text = "Старт"
        btnStart.addActionListener {

        }
        val gl = GroupLayout(contentPane)
        layout = gl
        gl.setHorizontalGroup(
            gl.createSequentialGroup()
                .addGap(8)
                .addGroup(
                    gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(field, 400, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addComponent(btnStart, 150, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(8)
        )
        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addGap(8)
                .addComponent(field, 400, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(8)
                .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(8)
        )
        pack()
    }
}