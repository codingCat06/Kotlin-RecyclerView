package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ListitemBinding

// ListitemBinding 은 layout 에 List Item 으로 설계한 xml의 이름
// item_data 는 data class로 정의한 것

class CustomAdapter: RecyclerView.Adapter<Holder>(){
    var itemlist = mutableListOf<item_data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val binding = ListitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int){
        val item = itemlist[position]
        holder.setData(item)
    }

    override fun getItemCount(): Int{
        return itemlist.size
    }
    fun replaceList(newList: MutableList<item_data>) {
        itemlist = newList.toMutableList()
        notifyDataSetChanged()
    }
}

class Holder(val binding: ListitemBinding): RecyclerView.ViewHolder(binding.root){
    fun setData(item: item_data){
        // item_data ( 데이터 클래스 ) 형식과 listitem 화면의 binding 을 대응시킴.
        binding.name.text = item.name
        binding.timestep.text = item.timestep
        binding.title.text = item.title
    }
}
