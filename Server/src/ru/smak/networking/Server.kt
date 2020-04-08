package ru.smak.networking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket

class Server {
    private val ss: ServerSocket
    init{
        ss = ServerSocket(5703)
        start()
    }

    private fun start() {
        val s = ss.accept()
        val br = BufferedReader(
            InputStreamReader(s.getInputStream())
        )
        println(br.readLine())
        s.close()
    }
}