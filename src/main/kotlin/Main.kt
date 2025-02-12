package com.zivue

import service.BlackJackService
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    try {
        if (args.isEmpty()) {
            BlackJackService()
            return
        }
        if (args.size == 1) {
            BlackJackService(args[0])
            return
        }

        throw IllegalArgumentException("Too many arguments")
    } catch (e: Exception) {
        println("Error: ${e.message}")
        exitProcess(1)
    }
}