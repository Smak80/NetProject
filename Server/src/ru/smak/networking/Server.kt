package ru.smak.networking

import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread

class Server private constructor(){

    private val ss: ServerSocket
    private var stop = false

    inner class ConnectedClient(val skt: Socket, val id: Int){

        var Stop: Boolean = false
        private val br =
            java.io.BufferedReader(InputStreamReader(skt.getInputStream()))
        private val pw =
            java.io.PrintWriter(skt.getOutputStream())

        init{
            thread {
                startConnection()
            }
        }

        private fun startConnection() {
            sendStatus(id%2==0)
//            while (!Stop){
//
//            }
        }

        private fun sendStatus(status: Boolean) {
            pw.println(status)
            pw.flush()
        }
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
            val id =
                if (connectedClient.isEmpty()) 0 else connectedClient.last().id+1
            connectedClient.add(ConnectedClient(s, id))
        }
    }
}