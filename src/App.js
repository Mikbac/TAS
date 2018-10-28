import React, { Component } from 'react';
import './App.css';
import axios from 'axios';
import Universities from './components/Universities/Universities';
import Faculties from './components/Faculties/Faculties';
import Teachers from './components/Teachers/Teachers';
import Teacher from './components/Teachers/Teacher';
import Header from './components/Header/Header';

class App extends Component {

  state ={
    showFaculties: false,
    uniClicked: undefined,

    showTeachers: false,
    facultyClicked: undefined,

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

  receiveData = uniClicked => {
    this.setState({showFaculties: true});
    this.setState({uniClicked: uniClicked});
  }
  receiveData1 = facultyClicked => {
    this.setState({showTeachers: true});
    this.setState({showFaculties: false});
    this.setState({facultyClicked: facultyClicked});
  }
  receiveData2 = teacherClicked => {
    this.setState({showTeacher: true});
    this.setState({showTeachers: false});
    this.setState({teacherClicked: teacherClicked});
  }

  render() {
    let result;

    if(!this.state.showFaculties){
      result = <Universities 
                passData={ this.receiveData }/>
    }
    if(this.state.showFaculties && !this.state.showTeachers){
      result = <Faculties 
                uniId={ this.state.uniClicked } 
                passData={ this.receiveData1 }/>
    }
    if(this.state.showTeachers){
      result = <Teachers 
                facId={ this.state.facultyClicked }
                passData={ this.receiveData2 }/>
    }
    if(this.state.showTeacher && !this.state.showTeachers){
      const teachers = this.state.teachers.map(teacher =>{
        if(this.state.teacherClicked === teacher.teacherId){
            result =
                <Teacher
                teacherPage={ true }
                id={teacher.teacherId} 
                name={teacher.name} 
                surname={teacher.surname}/>
            
        }
      });
    }
    return (
      <div className="App container-fluid">
        <Header/>
        <div className="container">
        {result}
        </div>
      </div>
    );
  }
}

export default App;
