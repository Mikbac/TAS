import React from 'react'
import axios from 'axios';
import './AddTeacher.css';

class AddFaculty extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            faculties: [],
            faculty: 1,
            teachers: [],
            teacher: 1
        };
    
        this.handleChangeName = this.handleChangeName.bind(this);
        this.handleChangeFaculty = this.handleChangeFaculty.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
      }

      handleChangeName = event => {
        this.setState({name: event.target.value});
      }
      handleChangeSurname = event => {
        this.setState({surname: event.target.value});
      }
      handleChangeFaculty = event => {
        this.setState({faculty: event.target.value});
      }
      handleChangeTeacher = event => {
        this.setState({teacher: event.target.value});
      }
    
      handleSubmit = event => {
        event.preventDefault();
        if(/\S/.test(this.state.name) && /\S/.test(this.state.surname)){
        axios.post(`http://localhost:8080/teachers/add`, {
            "faculty": {
              "facultyId": this.state.faculty,
              "name": "string",
              "university": {
                "city": "string",
                "name": "string",
                "universityId": 0
              }
            },
            "name": this.state.name,
            "surname": this.state.surname,
            "teacherId": 0
          })
        .then(res => {
         // console.log(res);
        })
    } else {
        alert('Name or surname incorrect!');
    }
        this.setState({name: '', surname: '', faculty: 0})
      }

      handleDelete = event => {
        event.preventDefault();
        axios.delete(`http://localhost:8080/teachers/delete/${ this.state.teacher }`)
        .then(res => {
          console.log(res);
        })
        this.setState({teacher: 1});
         window.location.reload();
      }

      componentDidMount(){
        axios.get('http://localhost:8080/faculties')
            .then(response => {
                this.setState({faculties: response.data}); 
            });
        axios.get('http://localhost:8080/teachers')
            .then(response => {
                this.setState({teachers: response.data}); 
            });
    }

    render() {
        const facultiesList = this.state.faculties.map((faculty) =>
            <option key={ faculty.facultyId } value={ faculty.facultyId }> { faculty.name }, { faculty.university.name } </option>
        );
        const teachersList = this.state.teachers.map((teacher) =>
            <option key={ teacher.teacherId } value={ teacher.teacherId }> { teacher.name } { teacher.surname } </option>
    );
      return (
        <div className="EditTeacher">
          <form className="AddTeacher" onSubmit={this.handleSubmit}>
            <input className="AddInput" type="text" placeholder="Name.." value={this.state.name} onChange={this.handleChangeName} />
            <input className="AddInput" type="text" placeholder="Surname.." value={this.state.surname} onChange={this.handleChangeSurname} />
          <select className="DeleteInput" onChange={this.handleChangeFaculty} value={ this.state.faculty }>
            { facultiesList }
          </select>
          <input className="Button" type="submit" value="Submit" />
        </form>
        <form className="DeleteTeacher" onSubmit={this.handleDelete}>
                  <select className="DeleteInput" onChange={this.handleChangeTeacher}>
                          { teachersList }
                  </select>
                  <input className="Button" type="submit" value="Delete" />
      </form>
     </div>
      )
    }
  }

  export default AddFaculty