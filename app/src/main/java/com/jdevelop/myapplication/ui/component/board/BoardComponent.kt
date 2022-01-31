package com.jdevelop.myapplication.ui.component.board

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.jdevelop.myapplication.R
import com.jdevelop.myapplication.model.player.Player
import com.jdevelop.myapplication.ui.view.main.MainActivity
import com.jdevelop.myapplication.util.Utils.COLS
import com.jdevelop.myapplication.util.Utils.ROWS


/**
 * Created by Jdevelop057 on 22/01/2022.
 */

class BoardComponent : RelativeLayout {

    private lateinit var mCells: Array<Array<ImageView?>>
    private lateinit var mBoardView: LinearLayout
    private lateinit var mListener: MainActivity
    private lateinit var relativeLayoutComponent: RelativeLayout
    private lateinit var imageViewRedDisc: ImageView
    private lateinit var imageViewYellowDisc: ImageView

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(context)
    }

    constructor(context: Context, attributeSet: AttributeSet?, i: Int) : super(
        context,
        attributeSet,
        i
    ) {
        init(context)
    }

    fun startGame(mainActivityListener: MainActivity) {
        this.mListener =
            mainActivityListener // MainActivity Acts like a listener beacuse is extended of View.OnClickListener
        buildCells()
        relativeLayoutComponent.setOnClickListener(mListener)
    }


    private fun buildCells() {
        mCells = Array(ROWS) {
            arrayOfNulls(
                COLS
            )
        }
        for (r in 0 until ROWS) {
            val row = (mBoardView as ViewGroup).getChildAt(r) as ViewGroup
            row.clipChildren = false
            for (c in 0 until COLS) {
                val imageView = row.getChildAt(c) as ImageView
                imageView.setImageResource(android.R.color.transparent)
                imageView.setOnClickListener(mListener)
                mCells[r][c] = imageView
            }
        }
    }

    fun colAtX(x: Float): Int {
        val colWidth: Float? = mCells[0][0]?.width?.toFloat()
        val col = x.toInt() / colWidth?.toInt()!!
        if (col < 0) return 0
        return if (col > 6) 6 else col
    }

    private fun init(context: Context) {
        inflate(context, R.layout.board_component, this)
        mBoardView = findViewById(R.id.game_board)
        relativeLayoutComponent = findViewById(R.id.relativeLayoutComponent)
        imageViewRedDisc = findViewById(R.id.imageViewRedDisc)
        imageViewYellowDisc = findViewById(R.id.imageViewYellowDisc)


    }

/*    private fun resetImages() {
        imageViewYellowDisc.setImageResource(R.drawable.yellow_disc)
        imageViewRedDisc.setImageResource(R.drawable.red_disc)
    }*/

    fun dropDisc(row: Int, col: Int, playerTurn: Int) {
        val cell = mCells[row][col]!!
        val move = -(cell.height * row + cell.height + 15).toFloat()
        cell.y = move
        cell.setImageResource(
            if (playerTurn == Player.PLAYER1) R.drawable.red_disc else R.drawable.yellow_disc
        )
        cell.animate().translationY(0f).setInterpolator(BounceInterpolator()).start()
    }

    fun startPlayer(player: Int) {
        if (player == Player.PLAYER1) {
            imageViewRedDisc.setImageResource(R.drawable.red_focused)
            imageViewYellowDisc.setImageResource(R.drawable.yellow_disc)
        } else {
            imageViewYellowDisc.setImageResource(R.drawable.yellow_focused)
            imageViewRedDisc.setImageResource(R.drawable.red_disc)
        }
    }

    fun setWinner(player: Int) {
        if (player == Player.PLAYER1) {
            imageViewRedDisc.setImageResource(R.drawable.red_winner)
            imageViewYellowDisc.setImageResource(R.drawable.yellow_disc)
        } else {
            imageViewYellowDisc.setImageResource(R.drawable.yellow_winner)
            imageViewRedDisc.setImageResource(R.drawable.red_disc)
        }
    }

    fun resetBoard() {
        for (cell in mCells) {
            for (imageView in cell) {
                imageView?.setImageResource(android.R.color.transparent)
            }
        }
        startGame(mListener)
    }

    fun setCounter(redWins: Int, yellowWins: Int) {
        val redCounter = findViewById<TextView>(R.id.textViewCounterRed)
        val yellowCounter = findViewById<TextView>(R.id.textViewCounterYellow)
        redCounter.text = redWins.toString()
        yellowCounter.text = yellowWins.toString()

    }

}
