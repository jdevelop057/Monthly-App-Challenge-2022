package com.jdevelop.myapplication.ui.view.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jdevelop.myapplication.R
import com.jdevelop.myapplication.databinding.ActivityMainBinding
import com.jdevelop.myapplication.model.player.Player
import com.jdevelop.myapplication.ui.component.board.BoardComponent
import com.jdevelop.myapplication.util.Utils.COLS
import com.jdevelop.myapplication.util.Utils.Possibilities
import com.jdevelop.myapplication.util.Utils.ROWS

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var parentComponentBoard: BoardComponent
    private var mFinished: Boolean = false
    private var mDraw: Boolean = false
    private var mCellValue = 0
    private var yellowWins = 0
    private var redWins = 0
    private val mGrid = Array(ROWS) {
        IntArray(
            COLS
        )
    }
    private val mFree = IntArray(COLS)
    private var mPlayerTurn: Int = Player.PLAYER1
    private var p = 0
    private var q = 0

    private var WIN_X = 0
    private var WIN_Y = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_play_settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.replay_game -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.replay_game))
                builder.setPositiveButton("Restart") { dialog, which ->
                    mPlayerTurn = Player.PLAYER1
                    initialize()
                    parentComponentBoard.resetBoard()
                    parentComponentBoard.startPlayer(mPlayerTurn)
                }
                builder.setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()

            }
            R.id.restart_game -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.restart_game))
                builder.setPositiveButton("Restart") { dialog, which ->
                    mPlayerTurn = Player.PLAYER1
                    redWins = 0
                    yellowWins = 0
                    initialize()
                    parentComponentBoard.setCounter(redWins, yellowWins)
                    parentComponentBoard.resetBoard()
                    parentComponentBoard.startPlayer(mPlayerTurn)
                }
                builder.setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setup() {
        parentComponentBoard = binding.parentComponentBoard
        initialize()
        parentComponentBoard.startGame(this)
        parentComponentBoard.startPlayer(mPlayerTurn)
    }

    private fun selectColumn(column: Int) {
        if (mFree[column] == 0) {
            return
        }
        placeMove(column, mPlayerTurn)
        parentComponentBoard.dropDisc(mFree[column], column, mPlayerTurn)
        mPlayerTurn = if (mPlayerTurn == Player.PLAYER1) Player.PLAYER2 else Player.PLAYER1
        parentComponentBoard.startPlayer(mPlayerTurn)
        val mResult = checkWin()
        if (mResult !== Possibilities.NOTHING) {
            when (mResult) {
                Possibilities.PLAYER1_WINS -> {
                    parentComponentBoard.setWinner(Player.PLAYER1)
                    redWins++
                    showDialog(mResult)
                }
                Possibilities.PLAYER2_WINS -> {
                    parentComponentBoard.setWinner(Player.PLAYER2)
                    yellowWins++
                    showDialog(mResult)
                }
                Possibilities.DRAW -> {
                    showDialog(mResult)
                }
            }
            mFinished = true
//            parentComponentBoard.startPlayer(mPlayerTurn)
        }
    }

    fun placeMove(column: Int, player: Int) {
        if (mFree[column] > 0) {
            mGrid[mFree[column] - 1][column] = player
            mFree[column]--
        }
    }

    private fun horizontalCheck(): Boolean {
        // horizontalCheck
        for (i in 0 until ROWS) {
            for (j in 0 until COLS - 3) {
                mCellValue = mGrid[i][j]
                if (mCellValue == 0) mDraw = false
                if (mCellValue != 0 && mGrid[i][j + 1] == mCellValue && mGrid[i][j + 2] == mCellValue && mGrid[i][j + 3] == mCellValue
                ) {
                    p = i
                    q = j
                    WIN_X = 1
                    WIN_Y = 0
                    return true
                }
            }
        }
        return false
    }

    private fun verticalCheck(): Boolean {
        // verticalCheck
        for (j in 0 until COLS) {
            for (i in 0 until ROWS - 3) {
                mCellValue = mGrid[i][j]
                if (mCellValue == 0) mDraw = false
                if (mCellValue != 0 && mGrid[i + 1][j] == mCellValue && mGrid[i + 2][j] == mCellValue && mGrid[i + 3][j] == mCellValue
                ) {
                    p = i
                    q = j
                    WIN_X = 0
                    WIN_Y = 1
                    return true
                }
            }
        }
        return false
    }

    private fun ascendingDiagonalCheck(): Boolean {
        // ascendingDiagonalCheck
        for (i in 3 until ROWS) {
            for (j in 0 until COLS - 3) {
                mCellValue = mGrid[i][j]
                if (mCellValue == 0) mDraw = false
                if (mCellValue != 0 && mGrid[i - 1][j + 1] == mCellValue && mGrid[i - 2][j + 2] == mCellValue && mGrid[i - 3][j + 3] == mCellValue
                ) {
                    p = i
                    q = j
                    WIN_X = 1
                    WIN_Y = -1
                    return true
                }
            }
        }
        return false
    }

    private fun descendingDiagonalCheck(): Boolean {
        for (i in 3 until ROWS) {
            for (j in 3 until COLS) {
                mCellValue = mGrid[i][j]
                if (mCellValue == 0) mDraw = false
                if (mCellValue != 0 && mGrid[i - 1][j - 1] == mCellValue && mGrid[i - 2][j - 2] == mCellValue && mGrid[i - 3][j - 3] == mCellValue
                ) {
                    p = i
                    q = j
                    WIN_X = -1
                    WIN_Y = -1
                    return true
                }
            }
        }
        return false
    }

    fun checkWin(): Possibilities {
        mDraw = true
        mCellValue = 0
        if (horizontalCheck() || verticalCheck() ||
            ascendingDiagonalCheck() || descendingDiagonalCheck()
        ) {
            return if (mCellValue == 1)
                Possibilities.PLAYER1_WINS
            else
                Possibilities.PLAYER2_WINS
        }
        if (mDraw)
            return Possibilities.DRAW
        return Possibilities.NOTHING
    }

    private fun initialize() {
        mFinished = false
        for (j in 0 until COLS) {
            for (i in 0 until ROWS) {
                mGrid[i][j] = 0
            }
            mFree[j] = ROWS
        }

    }

    private fun showDialog(possibilities: Possibilities) {
        var color = ""
        when (possibilities) {
            Possibilities.PLAYER1_WINS -> {
                color = getString(R.string.red)
                runWinDialog(color)
            }
            Possibilities.PLAYER2_WINS -> {
                color = getString(R.string.yellow)
                runWinDialog(color)
            }
            Possibilities.DRAW -> {
                draw()
            }
        }
    }

    private fun runWinDialog(color: String) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("El color $color ha ganado")
        builder.setPositiveButton("New Game") { dialog, which ->
            Log.e("DEBUG", yellowWins.toString())
            Log.e("DEBUG", redWins.toString())
            initialize()
            parentComponentBoard.setCounter(redWins, yellowWins)
            parentComponentBoard.resetBoard()
            parentComponentBoard.startPlayer(mPlayerTurn)
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun draw() {
        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
        mPlayerTurn = Player.PLAYER1
        initialize()
        parentComponentBoard.resetBoard()
        parentComponentBoard.startPlayer(mPlayerTurn)
    }

    override fun onClick(view: View) {
        if (mFinished) return
        val col: Int = parentComponentBoard.colAtX(view.x)
        Log.e("DEBUG", "col: $col")
        selectColumn(col)
    }


}