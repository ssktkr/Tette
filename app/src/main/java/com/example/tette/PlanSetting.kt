package com.example.tette

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class PlanSetting: Fragment(){
    private val cnt:Int = 0
    fun newInstance(count:Int):PlanSetting{
        val planSetting=PlanSetting()

        val args:Bundle = Bundle()
        args.putInt("Counter",count)
        planSetting.arguments = args

        return planSetting

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.plan_setting_layout,container,false)
    }


        /*  val vg = findViewById<View>(R.id.planselection) as ViewGroup
            for(i in 0 until 4) {
                layoutInflater.inflate(R.layout.select_plan, vg)

    }
            }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonList = mutableListOf<Button>()

        buttonList.add(view.findViewById(R.id.action_0))
        buttonList.add(view.findViewById(R.id.action_1))
        buttonList.add(view.findViewById(R.id.action_2))
        buttonList.add(view.findViewById(R.id.action_3))
        buttonList.add(view.findViewById(R.id.action_4))
        buttonList.add(view.findViewById(R.id.action_5))

        buttonList.add(view.findViewById(R.id.setTime15))
        buttonList.add(view.findViewById(R.id.setTime30))
        buttonList.add(view.findViewById(R.id.setTime45))
        buttonList.add(view.findViewById(R.id.setTime60))

        val planData = mutableListOf<String>()
        for (button in buttonList) {
            button.setOnClickListener {
                val planName: TextView = view.findViewById(R.id.setting_plan_name)
                val planTime: TextView = view.findViewById(R.id.setting_plan_time)
                var planText: String? = null


                when (button) {
                    view.findViewById<Button>(R.id.action_0) -> {
                        planText = buttonList[0].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.action_1) -> {
                        planText = buttonList[1].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.action_2) -> {
                        planText = buttonList[2].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.action_3) -> {
                        planText = buttonList[3].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.action_4) -> {
                        planText = buttonList[4].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.action_5) -> {
                        planText = buttonList[5].text as String
                        planName.text = planText
                        planData.add(0, planText)
                    }
                    view.findViewById<Button>(R.id.setTime15) -> {
                        planText = buttonList[6].text as String
                        planTime.text = "$planText : "
                        planData.add(1, planText)
                    }
                    view.findViewById<Button>(R.id.setTime30) -> {
                        planText = buttonList[7].text as String
                        planTime.text = "$planText : "
                        planData.add(1, planText)
                    }
                    view.findViewById<Button>(R.id.setTime45) -> {
                        planText = buttonList[8].text as String
                        planTime.text = "$planText : "
                        planData.add(1, planText)
                    }
                    view.findViewById<Button>(R.id.setTime60) -> {
                        planText = buttonList[9].text as String
                        planTime.text = "$planText : "
                        planData.add(1, planText)
                    }
                }


            }
        }


        val button2: Button = view.findViewById(R.id.button_back)
        val vg = view.findViewById<RelativeLayout>(R.id.child_container)
        button2.setOnClickListener {
            layoutInflater.inflate(R.layout.imageview_layout,vg)
            Log.d("changePage", "success the next process")
            val fragmentManager = fragmentManager
            if (fragmentManager != null) {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.replace(R.id.container, Frag00().newInstance(planData[0],planData[1]))


                fragmentTransaction.commit()
            }
        }



    }
}





