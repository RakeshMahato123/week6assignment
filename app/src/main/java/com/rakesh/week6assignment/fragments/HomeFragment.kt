package com.rakesh.SoftUser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.softuser.`object`.Student
import com.rakesh.softuser.adapter.StudentAdapter
import com.rakesh.softuser.model.student
import com.rakesh.week6assignment.R


class HomeFragment : Fragment() {
    private lateinit var lstStudent: ArrayList<student>
    private lateinit var recyclerView:RecyclerView
    private var param1 : String? =null
    private var param2 : String? = null





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.adapter?.notifyDataSetChanged()
        lstStudent= arrayListOf()
        //recyclerView.setHasFixedSize(true)
        val adapter= StudentAdapter(Student.lstStudent,requireContext())
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
    }
}