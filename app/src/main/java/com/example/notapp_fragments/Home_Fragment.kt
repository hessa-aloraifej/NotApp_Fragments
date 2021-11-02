package com.example.notapp_fragments

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class Home_Fragment : Fragment(){



    private val vm by lazy { ViewModelProvider(this).get(MyVM::class.java) }
    lateinit var sharedPreferences: SharedPreferences
    lateinit var rvMain: RecyclerView
    lateinit var rvAdapter: RVAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        //sharedPreferences = requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val view = inflater.inflate(R.layout.fragment_home_, container, false)
        var noteText = view.findViewById<EditText>(R.id.note)
        var addbtn = view.findViewById<Button>(R.id.button)
        rvMain = view.findViewById(R.id.myRV)
        rvAdapter = RVAdapter(this)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(activity)

        vm.getData()
        vm.getNotes().observe(viewLifecycleOwner, { notes ->
            rvAdapter.update(notes)
        })
        addbtn.setOnClickListener {
            vm.addNote(Note("", noteText.text.toString()))

          }

        return view
    }




    fun deleteAlert(idNote: String) {
       // vm.deleteNote(idNote)
        val dialogBuilder = activity?.let { androidx.appcompat.app.AlertDialog.Builder(it) }

        dialogBuilder?.setMessage("Are You Sure To Delete This Note?")
            ?.setPositiveButton("Delete", DialogInterface.OnClickListener { _, _ ->
                vm.deleteNote(idNote)
            })?.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ -> dialog.cancel()
            })
        val alert = dialogBuilder?.create()

        alert?.setTitle("Confirmation")
        alert?.show()


    }


}




