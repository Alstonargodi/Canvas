package com.example.canvas_ml

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.canvas_ml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var canvas : Canvas
    private lateinit var bitmap: Bitmap
    private lateinit var paint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        bitmap = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888)
        binding.imageView.setImageBitmap(bitmap)
        canvas = Canvas(bitmap)
        paint = Paint()

        drawCanvas()
        setContentView(binding.root)
    }

    private fun drawCanvas(){
        val rect = Rect()
        rect.set(
            bitmap.width/2-100,
            bitmap.height/2-100,
            bitmap.width/2+100,
            bitmap.height/2+100
        )
        canvas.apply {
            drawColor(ResourcesCompat.getColor(resources,R.color.white,null))
            paint.setColor(Color.GRAY)
            drawCircle((bitmap.width/2).toFloat(),(bitmap.height/2).toFloat(),200f, paint)
            paint.color = ResourcesCompat.getColor(resources, R.color.white, null)
            drawRect(rect,paint)
        }
    }
}