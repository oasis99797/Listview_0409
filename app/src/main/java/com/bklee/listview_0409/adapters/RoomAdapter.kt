package com.bklee.listview_0409.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bklee.listview_0409.datas.Room
import com.bklee.listview_0409.R

class RoomAdapter(context:Context, resId:Int, list:ArrayList<Room>) : ArrayAdapter<Room>(context, resId, list)  {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

        return row

    }

}