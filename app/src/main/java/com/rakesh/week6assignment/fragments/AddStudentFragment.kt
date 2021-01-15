package com.rakesh.SoftUser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.rakesh.softuser.`object`.Student
import com.rakesh.softuser.model.student
import com.rakesh.week6assignment.R


class AddStudentFragment : Fragment() {
    private lateinit var etFullName:EditText
    var lstStudent=ArrayList<student>()
    private lateinit var rdoGroup:RadioGroup
    private lateinit var etAge:EditText
    private lateinit var rdoMale:RadioButton
    private lateinit var rdoFemale:RadioButton
    private lateinit var rdoOthers:RadioButton
    private lateinit var etAddress:EditText
    var gender= ""
    private lateinit var btnSend:Button
    private var param1: String? = null
    private var param2: String? = null




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_add_student, container, false)
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etFullName=view.findViewById(R.id.etFullName)
        etAge=view.findViewById(R.id.etAge)
        rdoGroup=view.findViewById(R.id.rdoGroup)
        rdoMale=view.findViewById(R.id.rdoMale)
        rdoFemale=view.findViewById(R.id.rdoFemale)
        rdoOthers=view.findViewById(R.id.rdoOther)
        etAddress=view.findViewById(R.id.etAddress)
        btnSend=view.findViewById(R.id.btnSave)
        genderSelected()

        btnSend.setOnClickListener {
            if(isValid()){
                Student.lstStudent.add(student(
                        studentName =etFullName.text.toString(),
                        studentAge = etAge.text.toString(),
                        studentGender = gender,
                        studentAddress =etAddress.text.toString()
                ))
                clear()
            }
        }
    }

    private fun clear(){
        etFullName.setText("")
        etAge.setText("")
        etAddress.setText("")
        rdoMale.isChecked=false
        rdoFemale.isChecked=false
        rdoOthers.isChecked=false
        //  etImageLink.setText("")
    }

    private fun genderSelected(){
        rdoGroup.setOnCheckedChangeListener{ _, checkedID ->
            when(checkedID){
                R.id.rdoMale->{
                    gender=rdoMale.text.toString()
                }

                R.id.rdoFemale->{
                    gender=rdoFemale.text.toString()
                }

                R.id.rdoOther->{
                    gender=rdoOthers.text.toString()
                }
            }
        }
    }


    private fun isValid():Boolean{
        when{
            etFullName.text.isEmpty() -> {
                etFullName.error="Name cannot be Empty"
                etFullName.requestFocus()
                return false
            }
            etAge.text.isEmpty() -> {
                etAge.error="Age cannot be Empty"
                etAge.requestFocus()
                return false
            }
            !rdoMale.isChecked && !rdoFemale.isChecked && !rdoOthers.isChecked -> {
                Toast.makeText(context,"Please Select a Gender", Toast.LENGTH_SHORT).show()
                rdoGroup.requestFocus()
                return false
            }
            etAddress.text.isEmpty() -> {
                etAddress.error="Address cannot be Empty"
                etAddress.requestFocus()
                return false
            }

        }
        return true
    }
}