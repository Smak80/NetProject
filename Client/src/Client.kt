package ru.smak.networking

import java.io.PrintWriter
import java.net.Socket

class Client {
    private val s: Socket
    init{
        s = Socket("localhost", 5703)
        start()
    }

    private fun start() {
        val pw = PrintWriter(s.getOutputStream())
        pw.println("Привет!!!")
        pw.flush()
        s.close()
    }


}