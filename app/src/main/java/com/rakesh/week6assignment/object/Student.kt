package com.rakesh.softuser.`object`

import com.rakesh.softuser.model.student

object Student {
    var lstStudent= arrayListOf<student>()
    fun addStudent(){
        lstStudent= arrayListOf();
        lstStudent.add(
            student(
            studentName ="Rakesh Singh",studentAge = "24",studentGender = "Male",
            studentAddress ="DurbarMarg"
        )
        )

        lstStudent.add(student(
            studentName ="Mukesh Singh",studentAge = "22",studentGender = "Male",
            studentAddress ="Koteswor"
        ))
    }
}