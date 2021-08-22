package com.naufalfachrian.awesomeapp.utils.parcels

import android.os.Parcel
import android.os.Parcelable
import com.naufalfachrian.pexels_api.entities.PexelsPhoto

class PexelsPhotoParcel(

    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val photographerUrlString: String,
    val photographerId: Int,
    val avgColorHexString: String,

    val sourceOriginal: String,
    val sourceLarge2x: String,
    val sourceLarge: String,
    val sourceMedium: String,
    val sourceSmall: String,
    val sourcePortrait: String,
    val sourceLandscape: String,
    val sourceTiny: String

) : Parcelable {

    constructor(photo: PexelsPhoto): this(
        photo.id,
        photo.width,
        photo.height,
        photo.url,
        photo.photographer,
        photo.photographerUrlString,
        photo.photographerId,
        photo.avgColorHexString,
        photo.source.original,
        photo.source.large2x,
        photo.source.large,
        photo.source.medium,
        photo.source.small,
        photo.source.portrait,
        photo.source.landscape,
        photo.source.tiny
    ) {}

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString()  ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(width)
        parcel.writeInt(height)
        parcel.writeString(url)
        parcel.writeString(photographer)
        parcel.writeString(photographerUrlString)
        parcel.writeInt(photographerId)
        parcel.writeString(avgColorHexString)
        parcel.writeString(sourceOriginal)
        parcel.writeString(sourceLarge2x)
        parcel.writeString(sourceLarge)
        parcel.writeString(sourceMedium)
        parcel.writeString(sourceSmall)
        parcel.writeString(sourcePortrait)
        parcel.writeString(sourceLandscape)
        parcel.writeString(sourceTiny)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun unParcel(): PexelsPhoto {
        return PexelsPhoto(
            id,
            width,
            height,
            url,
            photographer,
            photographerUrlString,
            photographerId,
            avgColorHexString,
            PexelsPhoto.Source(
                sourceOriginal,
                sourceLarge2x,
                sourceLarge,
                sourceMedium,
                sourceSmall,
                sourcePortrait,
                sourceLandscape,
                sourceTiny
            )
        )
    }

    companion object CREATOR : Parcelable.Creator<PexelsPhotoParcel> {
        override fun createFromParcel(parcel: Parcel): PexelsPhotoParcel {
            return PexelsPhotoParcel(parcel)
        }

        override fun newArray(size: Int): Array<PexelsPhotoParcel?> {
            return arrayOfNulls(size)
        }
    }

}