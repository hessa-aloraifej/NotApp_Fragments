package com.example.notapp_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(private val activity: Home_Fragment):  RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){

    private var notes = emptyList<Note>()

    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var myNote = notes[position]

        holder.itemView.apply {
            textView.text = myNote.note
        //   editbtn.setOnClickListener(object :View.OnClickListener {
            //               override fun onClick(v: View?) {
            //                   val activity=v!!.context as AppCompatActivity
            //                   val updateFragment=Update_Fragment()
            //
            //                   activity.supportFragmentManager.beginTransaction().replace(R.id.mainn,updateFragment).addToBackStack(null).commit()
            //
            //               }
            //
            //
            //            //                var id = myNote.id
            //            //                activity.editAlert(id, myNote.note)
            //            //
            //                       })
   editbtn.setOnClickListener {

     val bundle= Bundle()
       bundle.putString("id",myNote.id)
       val fragment=Update_Fragment()
        fragment.arguments = bundle
      //val bundle= bundleOf("id" to myNote.id)

       activity.findNavController().navigate(R.id.action_home_Fragment_to_update_Fragment,bundle)

}

            delbtn.setOnClickListener {
                var noteID = myNote.id
              activity.deleteAlert(noteID)
            }
        }
    }

    override fun getItemCount() = notes.size

    fun update(notes: List<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

}