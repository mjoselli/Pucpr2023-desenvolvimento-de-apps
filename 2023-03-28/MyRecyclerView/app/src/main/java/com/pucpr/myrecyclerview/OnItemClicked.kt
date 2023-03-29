package com.pucpr.myrecyclerview

import android.view.View

interface OnItemClicked {
    fun onItemClicked(view: View,position:Int)
    fun onItemLongClicked(view: View,position:Int)
}