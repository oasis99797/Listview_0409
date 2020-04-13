package com.bklee.listview_0409.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bklee.listview_0409.datas.Room
import com.bklee.listview_0409.R

class RoomAdapter(context: Context, resId:Int, list: ArrayList<Room>) : ArrayAdapter<Room>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

//        row변수를 활용해서 각줄에 맞는 데이터 가공.

//        XML에 있는 뷰들을 변수로 담기. findViewById
        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descTxt = row.findViewById<TextView>(R.id.descTxt)

//        근거 데이터 변수 추출. => 각 위치에 맞는 데이터를 mList에서 가져오기
        val data = mList.get(position)

//        가격이 1만 이상 ? "?억 ?" 식, 그 이하 "?"
        if (data.price >= 10000) {
            priceTxt.text = "${data.price / 10000}억 ${String.format("%,d", data.price % 10000)}"
        }
        else {
            priceTxt.text = String.format("%,d", data.price)
        }


//        주소와 층수 => "주소, 층수(상황마다다른값)"

        var floorStr = ""

        if (data.floor == 0) {
            floorStr = "반지하"
        }
        else if (data.floor > 0) {
            floorStr = "${data.floor}층"
        }
        else {
            floorStr = "지하 ${-data.floor}층"
        }

        addressAndFloorTxt.text = "${data.address}, ${floorStr}"

//        설명은 그냥 있는 그대로 대입
        descTxt.text = data.desc

        return row

    }


}