package m.vk.k027_dragswiperecyclerview.touch

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CustomItemTouchHelperCallback(var listener: CustomItemHelperListener): ItemTouchHelper.Callback() {
    //มีไว้กำหนดทิศทางที่จะให้ Swipe หรือ Drag
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN //Drag & Drop ด้วยการลากขึ้นและลง
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END//wipe To Dismiss ให้ปัดซ้ายหรือขวา
        /*หรือถ้าอยากให้ Swipe To Dismiss เท่านั้น ก็ให้ Flag ของ Drag & Drop มีค่าเป็น 0
        แล้วกำหนด isLongPressDragEnabled เป็น False ซะ*/
        return makeMovementFlags(dragFlags,swipeFlags)
    }

    //ทำงานเมื่อผู้ใช้ Drag & Drop ซึ่งจะรู้ได้ว่าผู้ใช้ลาก Item ไหนไปไว้ที่ตำแหน่งไหน
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        if (viewHolder.itemViewType != target.itemViewType){
            return false
        }
        if (viewHolder != null && target != null){
            //เวลา Drag & Drop ก็ให้เรียกผ่าน CustomItemTouchHelperListener เพื่อบอก Adapter ให้อัพเดท Item ของตัวเองใหม่
            return listener.onItemMove(viewHolder.adapterPosition,target.adapterPosition)
        }
        return false
    }

    //ทำงานเมื่อผู้ใช้ Swipe To Dismiss ซึ่งสามารถกำหนดได้ว่าจะให้ Item นั้นๆทำงานอะไร
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        viewHolder.let {
            //เวลา Swipe To Dismiss ก็ให้เรียกผ่าน CustomItemTouchHelperListener เพื่อบอก Adapter ให้อัพเดท Item ของตัวเองใหม่
            listener.onItemDismiss(viewHolder.adapterPosition)
        }
    }

    // Swipe To Dismiss ได้หรือไม่
    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    // กดค้างเพื่อ Drag & Drop ได้หรือไม่
    override fun isLongPressDragEnabled(): Boolean {
        return true
    }
}