package m.vk.k027_dragswiperecyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import m.vk.k027_dragswiperecyclerview.R
import m.vk.k027_dragswiperecyclerview.adapter.CustomAdapterAndroid
import m.vk.k027_dragswiperecyclerview.data.VersionAndroid
import m.vk.k027_dragswiperecyclerview.model.ModelAndroid
import m.vk.k027_dragswiperecyclerview.touch.CustomItemTouchHelperCallback

class MainActivity : AppCompatActivity() {
    lateinit var dataSet: MutableList<ModelAndroid>
    lateinit var customAdapterAndroid: CustomAdapterAndroid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set data to adapter
        dataSet = VersionAndroid.createVersionAndroid()
        customAdapterAndroid = CustomAdapterAndroid(dataSet)
        rvAndroidVersion.layoutManager = LinearLayoutManager(this)
        rvAndroidVersion.adapter = customAdapterAndroid

        //set callback touch helper
        val callback = CustomItemTouchHelperCallback(customAdapterAndroid)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvAndroidVersion)//กำหนด RecyclerView ให้ ItemTouchHelper
    }
}
