package com.example.pu20210419

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() ,GestureDetector.OnGestureListener,View.OnTouchListener{

    lateinit var gDetector: GestureDetector
    var PictureNo:Int = 0
    var TotalPictures:Int = 4

    fun ShowPicture(){
        when (PictureNo){
            0 -> img.setImageResource(R.drawable.pu0)
            1 -> img.setImageResource(R.drawable.pu1)
            2 -> img.setImageResource(R.drawable.pu2)
            3 -> img.setImageResource(R.drawable.pu3)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv.text = "作者: ianYang"
        gDetector = GestureDetector(this, this)
        img.setOnTouchListener(this)

        var res:Int = -1
        var countDrawables:Int = -1
        while (res != 0) {
            countDrawables++;
            res = getResources().getIdentifier("pu" + (countDrawables),
                "drawable", getPackageName());
        }
        TotalPictures = countDrawables


    }
    /*override fun onTouchEvent(event: MotionEvent?): Boolean {
      /*  if (txv.text == "靜宜之美"){
            txv.text = "螢幕觸控"
        }
        else{
            txv.text = "靜宜之美"
        }
        txv.text ="X軸座標:"+ event?.x.toString()+"\n"+"y軸座標:"+event?.y.toString()*/
        gDetector.onTouchEvent(event)

        return true
    }*/

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        PictureNo = 0
        ShowPicture()

        return true

    }

    override fun onDown(e: MotionEvent?): Boolean {

        return true
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.getX() < e2.getX()){  //向右快滑
            PictureNo++
            if (PictureNo == TotalPictures) {PictureNo = 0}
        }
        else{     //向左快滑
            PictureNo--;
            if (PictureNo < 0) {PictureNo = TotalPictures - 1 }
        }
        ShowPicture()

        return true

    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

        return true

    }

    override fun onLongPress(e: MotionEvent?) {
        PictureNo = TotalPictures - 1
        ShowPicture()

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)

        return true

    }

}