package com.android.adept_0822

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageGridViewAdapter : BaseAdapter() {
    //BaseAdapter은 추상클래스이다 그래서 추상메서드를 모두 상속받아야한다. (getCount,getItem,getItemId,getView)
    override fun getCount(): Int {
        //데이터의 갯수
        return character.size
    }

    override fun getItem(position: Int): Any {
        //데이터의 위치 (position = index 번째)
        return character[position]
    }

    override fun getItemId(position: Int): Long {
        //ID가 int범위를 넘어설 수 있으므로 Long타입을 사용한다.
        return position.toLong()
        // return position : 항목의 위치자체를 id로 반환한
        // return character[position].id : 항목자체를 id로 반환
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //지정된 위치의 항목에 대한 뷰를 반환
        val imageView: ImageView
        if (convertView == null) {
            //convertView : 재활용 가능한 뷰
            imageView = ImageView(parent!!.context)
            //새로운 이미지뷰를 생성한다.
            imageView.layoutParams = AbsListView.LayoutParams(200, 200)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        }
        //이미지뷰가 생성되고 초기화된다.
        else {
            imageView = convertView as ImageView
            //이전에 생성한 뷰를 재활용해야 할 때, 기존의 뷰(convertView)를 사용
        }
        imageView.setImageResource(character.get(position))
        //character(배열변수 명)의 현재위치(position)에 있는 이미지를 imageView에 보여준다.
        return imageView
    }

    private val character = arrayOf<Int>(
        R.drawable.character1,
        R.drawable.character2,
        R.drawable.character3,
        R.drawable.character4,
        R.drawable.character5,
        R.drawable.character6,
        R.drawable.character7,
        R.drawable.character8,
        R.drawable.character9,
        R.drawable.character10,
        R.drawable.character11,
        R.drawable.character12
    )

}