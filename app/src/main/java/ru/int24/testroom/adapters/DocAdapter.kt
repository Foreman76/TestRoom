package ru.int24.testroom.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.int24.testroom.R
import ru.int24.testroom.models.OneCDocument

class DocAdapter: RecyclerView.Adapter<DocAdapter.MyViewHolder>() {

    private val docList: ArrayList<OneCDocument> = ArrayList<OneCDocument>()

    fun setData(data: ArrayList<OneCDocument>){
        docList.clear()
        docList.addAll(data)
        notifyDataSetChanged()
    }

    fun updateData(){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocAdapter.MyViewHolder {
        return MyViewHolder(itemV = LayoutInflater.from(parent.context).inflate(R.layout.item_rc, parent, false))
    }

    override fun getItemCount(): Int {
       return docList.size
    }

    class MyViewHolder(itemV: View):RecyclerView.ViewHolder(itemV){

        private var idDoc: TextView = itemV.findViewById(R.id.idDoc)
        private var docDate: TextView = itemV.findViewById(R.id.docDate)
        private var docNumber: TextView = itemV.findViewById(R.id.docNumber)

        fun bind(item: OneCDocument?){
            idDoc.text = item?.idDoc
            docDate.text = item?.dateDoc
            docNumber.text = item?.numberDoc
        }


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = docList[position]
        holder.bind(item)
    }
}