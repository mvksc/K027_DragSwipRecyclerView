package m.vk.k027_dragswiperecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import m.vk.k027_dragswiperecyclerview.R
import m.vk.k027_dragswiperecyclerview.model.ModelAndroid
import m.vk.k027_dragswiperecyclerview.touch.CustomItemHelperListener
import java.util.*

class CustomAdapterAndroid(private val dataSet: MutableList<ModelAndroid>): RecyclerView.Adapter<ViewHolderAndroid>() , CustomItemHelperListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAndroid {
        return ViewHolderAndroid(LayoutInflater.from(parent.context).inflate(R.layout.item_android_version,parent,false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderAndroid, position: Int) {
        holder.let {
            val android = dataSet[position]
            val unknown = it.itemView.context.getString(R.string.unknown)
            it.codeName(android.codeName ?: unknown)
            it.version(android.version ?: unknown)
            it.apiLevel(android.apiLevel)
            it.releaseDate(android.releaseDate ?: unknown)
            it.cardBackgroundColor(if (position % 2 == 0) "#4CAF50" else "#CDDC39")
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        /*เมื่อมีการ Drag & Drop จะต้องย้าย Item (ในที่นี้คือ MutableList<ModelAndroid>) ตามที่มีการ Drag & Drop
        ซึ่งจะเอา Collections เข้ามาช่วยเพื่อให้ย้ายตำแหน่งของ Item ได้ง่ายขึ้น
        จากนั้นก็สั่ง notifyItemMoved(...) เพื่อให้ Recycler View แสดง Animation ให้ผู้ใช้เห็น*/
        Collections.swap(dataSet,fromPosition,toPosition)
        notifyItemMoved(fromPosition,toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        /*สำหรับ Swipe To Dismiss ก็จะต้องลบ Item ที่ถูกเลือกออกไป
        แล้วสั่ง notifyItemRemoved(...) เพื่อให้ Recycler View แสดง Animation ให้ผู้ใช้เห็นว่ามีการลบ Item นั้นออกไปจริงๆ*/
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }
}