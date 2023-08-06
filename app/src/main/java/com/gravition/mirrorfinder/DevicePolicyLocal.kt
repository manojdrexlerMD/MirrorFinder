/*
 * Copyright (c) 2023.
 * Created By Manoj k Narayanan
 */

package com.gravition.mirrorfinder

import android.app.admin.DevicePolicyManager
import android.hardware.display.DeviceProductInfo
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class DevicePolicyLocal  {
    @RequiresApi(Build.VERSION_CODES.S)
    fun some(){
        val prodict = DeviceProductInfo.CONNECTION_TO_SINK_DIRECT
    }



}