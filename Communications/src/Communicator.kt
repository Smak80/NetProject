package ru.smak.networking

import java.io.*

class Communicator(
    val inputStream: InputStream,
    val outputStream: OutputStream
) {

    val br: BufferedReader
    val pw: PrintWriter

    init{
        br = BufferedReader(InputStreamReader(inputStream))
        pw = PrintWriter(outputStream)
    }

    fun getData(): String{
        val s = br.readLine()
        return s
    }

    fun <T> putData(s: T){
        pw.println(s)
        pw.flush()
    }
}