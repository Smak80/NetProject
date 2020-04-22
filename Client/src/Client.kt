package ru.smak.networking

import GameData
import ru.smak.MainWindow
import ru.smak.components.Status
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import kotlin.concurrent.thread

class Client(val gameData: GameData) {

    val s: Socket
    val br: BufferedReader
    val pw: PrintWriter
    var stop: Boolean = false

    companion object{
        var port = 5703
        var serverAddress = "localhost"
    }

    init{
        s = Socket(serverAddress, port)
        br = BufferedReader(InputStreamReader(s.getInputStream()))
        pw = PrintWriter(s.getOutputStream())
        thread{
            startConnection()
        }
    }

    private fun startConnection() {
        val v = br.readLine()
        gameData.clickRole = if (v == "true") Status.X else Status.O

    }

}