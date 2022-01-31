package com.jdevelop.myapplication.util

/**
 * Created by Jdevelop057 on 22/01/2022.
 */
object Utils {

    val ROWS = 6
    val COLS = 7

    enum class Possibilities(val value: Int) {
        DRAW(1),
        PLAYER1_WINS(2),
        PLAYER2_WINS(3),
        NOTHING(4)
    }

}