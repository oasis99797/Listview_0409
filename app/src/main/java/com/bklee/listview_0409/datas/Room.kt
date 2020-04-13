package com.bklee.listview_0409.datas

class Room(price:Int, address:String, floor:Int, desc:String) {
    var price = price
    var address = address
    var floor = floor // 1~ 층수. 0층 : 반지하, -2.. 지하2층
    var desc = desc
}