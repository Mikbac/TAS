import React from 'react';
import axios from 'axios';
import Teacher from './Teacher';
class Teachers extends React.Component {

    state = {
        teachers: [],
        showTeacher: false,
        teacherClicked: undefined
    }

    componentDidMount(){
        axios.get('https://api.myjson.com/bins/c1sgk')
            .then(response => {
                const teachers = response.data;
                this.setState({teachers: response.data});
            });
    }

    receiveData = (teacherClicked) => {
        this.setState({showTeacher: true});
        this.setState({teacherClicked: teacherClicked});

        this.props.passData(teacherClicked);
    }



    render() {

        const teachers = this.state.teachers.map(teacher =>{
            if(this.props.facId === teacher.faculty.facultyId){
                return (
                    <Teacher
                    id={teacher.teacherId} 
                    name={teacher.name} 
                    surname={teacher.surname} 
                    facID={teacher.faculty.facultyId}
                    receiveData={this.receiveData}/>
                )
            }
        });
    
      return (
        <div className="Teachers row justify-content-center">
            {teachers}
        </div>
      )
    }
  }

  export default Teachers;