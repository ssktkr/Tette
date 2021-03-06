package com.example.tette

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Frag01:Fragment(), View.OnTouchListener {
    private lateinit var cImageView:CustomImageView
    private var preDx:Int=0
    private var preDy:Int=0
    private lateinit var textView: TextView

    companion object{
        private const val TAG = "Frag01"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.frag01_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.text_view)
        cImageView= view.findViewById(R.id.plan_icon)
        cImageView.setOnTouchListener(this)

        val button: Button = view.findViewById(R.id.button)
        val listener = View.OnClickListener {
            Log.d(Frag01.TAG, "success the process")
            val intent: Intent = Intent(activity, PlanSetting::class.java)
            startActivity(intent)
        }
        button.setOnClickListener(listener)


    }


    override fun onTouch(v: View, event: MotionEvent): Boolean {
        val newDx:Int = event.rawX.toInt()
        val newDy:Int = event.rawY.toInt()
        Log.d("newxandy","newDx=$newDx, newDy=$newDy")


        when(event.action){
            MotionEvent.ACTION_MOVE->{
                v.performClick()
                val dx:Int = cImageView.left+(newDx-preDx)
                val dy:Int = cImageView.top+(newDy-preDy)
                val imgW:Int= dx + cImageView.width
                val imgH:Int= dy + cImageView.height


                cImageView.layout(dx,dy,imgW,imgH)

                val str:String= "dx=$dx\ndy=$dy"
                textView.text = str
                Log.d("onTouch", "ACTION_MOVE: dx=$dx, dy=$dy")

            }
            MotionEvent.ACTION_DOWN->{

            }
            MotionEvent.ACTION_UP->{

            }
            else->{

            }

        }
        preDx = newDx
        preDy = newDy
        Log.d("preDxy","preDx=$preDx, preDy=$preDy")
        return true
    }

}