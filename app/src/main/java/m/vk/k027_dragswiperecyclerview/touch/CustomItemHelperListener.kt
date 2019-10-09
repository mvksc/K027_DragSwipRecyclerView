package m.vk.k027_dragswiperecyclerview.touch

interface CustomItemHelperListener {
    /*เมื่อมีการ Drag & Drop หรือ Swipe To Dismiss เดิมทีจะต้องไปสั่ง Adapter อีกทีว่ามีการย้าย Item หรือ Item ถูกลบออก
    เพื่อให้โค้ดไม่ปนกับ Adapter จนเกินไป ควรสร้าง Interface
    เพื่อเป็นตัวกลางให้ CustomItemTouchHelperCallback ไปสั่ง Adapter อีกที*/
    fun onItemMove(fromPosition: Int,toPosition: Int): Boolean
    fun onItemDismiss(position: Int)
}