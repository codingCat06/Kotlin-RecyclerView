# Kotlin-RecyclerView ( List )
#  
#  
## 구성 요소
### 1. Adapter
#### 1) 설명
##### RecyclerView(화면)과 Data를 대응시키는 역할.
#  
#### 2) 코드
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
#  
#  
### 2. Holder
#### 1) 설명 
##### Item의 데이터를 저장하고 이벤트를 처리하는 역할.
#  
#### 2) 코드 ( 이벤트 구문은 아직 넣지 않음 )
    class Holder(val binding: ListitemBinding): RecyclerView.ViewHolder(binding.root){
        fun setData(item: item_data){
            // item_data ( 데이터 클래스 ) 형식과 listitem 화면의 binding 을 대응시킴.
            binding.name.text = item.name
            binding.timestep.text = item.timestep
            binding.title.text = item.title
        }
    }
    
