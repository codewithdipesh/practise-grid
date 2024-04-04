package com.example.practisegrid.Model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic (
   @StringRes val title:Int,
    val number:Int,
   @DrawableRes val image: Int

){

}