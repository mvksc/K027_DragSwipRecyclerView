package m.vk.k027_dragswiperecyclerview.model

import android.os.Parcel
import android.os.Parcelable

data class ModelAndroid(var codeName: String?, var version: String?, var apiLevel: Int, var releaseDate: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codeName)
        parcel.writeString(version)
        parcel.writeInt(apiLevel)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelAndroid> {
        override fun createFromParcel(parcel: Parcel): ModelAndroid {
            return ModelAndroid(parcel)
        }

        override fun newArray(size: Int): Array<ModelAndroid?> {
            return arrayOfNulls(size)
        }
    }
}