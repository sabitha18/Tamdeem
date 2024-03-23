package com.voxel.tamdeem.help


import com.voxel.tamdeem.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSeekBar

class CustomSeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatSeekBar(context, attrs, defStyleAttr) {

    private val bluePaint: Paint = Paint()
    private val blackPaint: Paint = Paint()

    init {
        bluePaint.color = Color.parseColor("#254CA0")
        bluePaint.strokeWidth = resources.displayMetrics.density * 7 // Convert dp to pixels
        blackPaint.color = Color.BLACK
        blackPaint.strokeWidth = resources.displayMetrics.density * 7 // Convert dp to pixels
        setBackgroundResource(R.drawable.seekbar_background) // Set the background here
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateProgressDrawableBounds()
    }

    private fun updateProgressDrawableBounds() {
        val progressDrawable = progressDrawable
        if (progressDrawable != null) {
            val progressBarRect = Rect(0, 0, width, height)
            progressDrawable.bounds = progressBarRect
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val backgroundDrawable = background
        val progressWidth = if (backgroundDrawable != null) {
            val backgroundBounds = backgroundDrawable.bounds
            (progress / max.toFloat()) * backgroundBounds.width()
        } else {
            (progress / max.toFloat()) * width
        }
        val progressHeight = height.toFloat()

        val lineSpacing = resources.displayMetrics.density * 7 // Adjust the spacing between slashes
        val cornerRadius = resources.displayMetrics.density * 7 // Adjust the corner radius

        // Draw the progress
        val paint = bluePaint
        val startX = 0f // StartX for the progress
        val endX = progressWidth.coerceAtMost(width.toFloat()) // EndX for the progress
        val rect = RectF(startX, 0f, endX, progressHeight)
        canvas?.drawRoundRect(rect, cornerRadius, cornerRadius, paint)

        // Draw the slashes within the progress
        var lineStartX = startX // Set the startX for the first slash
        var lineEndX: Float
        var isBlue = true

        while (lineStartX < progressWidth) {
            val paint = if (isBlue) bluePaint else blackPaint
            lineEndX = lineStartX + lineSpacing
            if (lineEndX < progressWidth) {
                canvas?.drawLine(lineEndX, 0f, lineEndX, progressHeight, paint)
            }

            // Update lineStartX for the next slash
            lineStartX = lineEndX
            isBlue = !isBlue
        }
    }






}




