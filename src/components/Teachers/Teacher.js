import React from 'react'
import './Teacher.css'
import teacherImg from '../../assets/teacher.png'

function Teacher(props) {
    return (
    <div className="Teacher">
          <br/>
          <br/>
          <div className="TeacherName"> { props.name } </div>
          <div className="TeacherSurname"> { props.surname } </div>
          <br/>
          <div className="TeacherImg"><img src={ teacherImg } alt=""/></div>
    </div>
    )
  }

  export default Teacher