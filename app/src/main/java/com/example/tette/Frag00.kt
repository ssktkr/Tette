package com.example.tette

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tette.PlanSetting
import org.w3c.dom.Text
import java.util.*


class Frag00:Fragment(),View.OnTouchListener{


    private lateinit var cImageView:CustomImageView
    private var preDx:Int=0
    private var preDy:Int=0
    private lateinit var textView:TextView
    private lateinit var imageView: ImageView


    companion object{
        private const val TAG = "Frag00"
    }

    private val cnt:Int = 0
    private var planName:String? = null
    private var planTime:String? = null
    fun newInstance(planName:String,planTime:String):Frag00{
        val fragmentAM = Frag00()

        val args: Bundle = Bundle()
        args.putString("PlanName",planName)
        args.putString("PlanTime",planTime)
        Log.d("Plan","$planName,$planTime")
        fragmentAM.arguments = args




        return fragmentAM
    }







    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)




        val view = inflater.inflate(R.layout.frag00_layout,container,false)



        return view
    }


      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)

          getTime()
          textView = view.findViewById(R.id.text_view)
          cImageView = view.findViewById(R.id.plan_icon)
          cImageView.setOnTouchListener(this)

          val button: Button = view.findViewById(R.id.button)
          val listener = View.OnClickListener {
              Log.d(Frag00.TAG, "success the process")
              val fragmentManager = fragmentManager
              if (fragmentManager != null){
                  val fragmentTransaction = fragmentManager.beginTransaction()
                  fragmentTransaction.addToBackStack(null)
                  fragmentTransaction.replace(R.id.container,PlanSetting().newInstance(cnt))
                  fragmentTransaction.commit()


              }
          }
          button.setOnClickListener(listener)



      }







    //move image


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

                  if((dx<140 && dx>100)&&(dy<720 && dy>660) ){
                      cImageView.layout(126,708,(126+cImageView.width),(708+cImageView.height))
                  }else {
                      cImageView.layout(dx, dy, imgW, imgH)
                  }
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




    private fun getTime(){
        val date: Calendar = Calendar.getInstance()
        var am_pm: String? = null
        when(date.get(Calendar.AM_PM)){
            0 -> am_pm = "午前"
            1 -> am_pm = "午後"
        }
        val hour: Int= date.get(Calendar.HOUR_OF_DAY)
        val min: Int = date.get(Calendar.MINUTE)

        val text2:TextView? = view?.findViewById(R.id.now_time)
        text2?.text = "$am_pm $hour:$min"


    }

     }


  /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
                .setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?){
                activity?.startActivity(Intent(context,PlanSetting::class.java))
            }
        })*/



