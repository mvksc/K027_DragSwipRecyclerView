package m.vk.k027_dragswiperecyclerview.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_android_version.view.*
import m.vk.k027_dragswiperecyclerview.R

class ViewHolderAndroid(itemView: View): RecyclerView.ViewHolder(itemView){
    fun codeName(codeName: String){
        itemView.tvCodeName.text = codeName
    }
    fun version(version: String){
        itemView.tvVersion.text = itemView.resources.getString(R.string.android_version,version)
    }
    fun apiLevel(apiLevel: Int){
        itemView.tvApiLevel.text = itemView.resources.getString(R.string.api_level,apiLevel)
    }
    fun releaseDate(data: String){
        itemView.tvReleaseDate.text = itemView.resources.getString(R.string.release_date,data)
    }
    fun cardBackgroundColor(color: String){
        itemView.cvItemAndroid.setCardBackgroundColor(Color.parseColor(color))
    }
}