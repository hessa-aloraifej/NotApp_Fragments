package com.example.notapp_fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Update_Fragment : Fragment() {
    private val vm by lazy{ ViewModelProvider(this).get(MyVM::class.java)}
    var id=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_update_, container, false)
        val etUpdat=view.findViewById<EditText>(R.id.updated)
        var updateBtn=view.findViewById<Button>(R.id.button2)


        id=arguments?.getString("id").toString()
        updateBtn.setOnClickListener {

           print(id)
            vm.edit(id,etUpdat.text.toString())
            etUpdat.text.clear()
            view?.let{Navigation.findNavController(it).navigate(R.id.action_update_Fragment_to_home_Fragment)}
        }

        return view
    }

}