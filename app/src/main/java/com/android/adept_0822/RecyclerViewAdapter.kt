package com.android.adept_0822

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView    //얘를 임포트 해야된다.
import com.android.adept_0822.databinding.ItemRecyclerviewBinding


class RecyclerViewAdapter(val character: MutableList<MyItem>) : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
//RecyclerView.Adapter<RecyclerViewAdapter.Holder>(): RecyclerView 위젯과 상호 작용하며 데이터를 화면에 표시하기 위한 어댑터 클래스를 정의
//Holder : 뷰 홀더 역할을 하며, 데이터 항목에 대한 뷰를 보유합니다. 내부 클래스로 정의
//RecyclerView.Adapter 클래스를 상속받을 경우 onCreateViewHolder, onBindViewHolder, getItemCount : 3개는 필수적으로 구현해야하는 메서드
    interface  ItemClick {
        fun onClick(view: View, position: Int)
        //view : 클릭된 항목의 view , position : 클릭된 항목의 position
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): Holder{
        // RecyclerView에 표시할 각 항목의 뷰 홀더를 생성하고 초기화(onCreate)
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        // xml 레이아웃을  뷰 바인딩 객체로 변환합니다.
        // ItemRecyclerviewBinding : 바인딩을 사용하여 생성된 바인딩 클래스,  XML 레이아웃의 뷰들에 접근할 수 있게 해준다.
        return Holder(binding)
        //여기서 반환되는  Holder(binding)은 onBindViewHolder 메서드에서 데이터를 바인딩하고 화면에 표시하는 역할을 한다.
    }

    override  fun onBindViewHolder(holder:Holder, position:Int){
        //onCreateViewHolder 메서드로 생성한 뷰 홀더를 가져와서 그 뷰 홀더에 데이터를 표시한다.
        holder.itemView.setOnClickListener{
            //뷰 홀더의 전체 아이템 뷰에 클릭 리스너를 설정하는 부분
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(character[position].aIcon)
        holder.name.text = character[position].aName
        holder.age.text = character[position].aAge
    }
    override  fun getItemId(position:Int):Long {
        return position.toLong()
    }
    override fun getItemCount(): Int{
        return character.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
       // RecyclerView는 화면에 표시될 아이템의 개수에 따라 뷰 홀더를 생성하고 관리하는데, Holder 클래스는 이 뷰 홀더 역할을 수행한다.
        //val binding: ItemRecyclerviewBinding : RecyclerView의 아이템에 대한 레이아웃과 그 내부에 있는 뷰들에 접근하기 위한 바인딩 객체
        val iconImageView = binding.iconItem1
        val name = binding.recycletext1
        val age = binding.recycletext2
    }
}