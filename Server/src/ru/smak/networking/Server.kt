package ru.smak.networking

import java.net.ServerSocket
import java.net.Socket

class Server private constructor(){

    private val ss: ServerSocket
    private var stop = false

    inner class ConnectedClient(val skt: Socket){

    }

    companion object {
        private val PORT = 5703
        private val connectedClient = mutableListOf<ConnectedClient>()
        private val srv: Server = Server()
        fun getInstance(): Server {
            return srv
        }
    }

    init{
        ss = ServerSocket(PORT)
        while (!stop) {
            acceptClient()
        }
    }

    private fun acceptClient() {
        println("Start new waiting")
        val s = ss.accept()
        if (s!=null) {
            connectedClient
        }
    }
}