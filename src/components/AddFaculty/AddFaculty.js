import React from 'react'
import axios from 'axios';
import './AddFaculty.css';

class AddFaculty extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            universities: [],
            faculties: [],
            university: 1,
            faculty: 1
        };
    
        this.handleChangeName = this.handleChangeName.bind(this);
        this.handleChangeUniversity = this.handleChangeUniversity.bind(this);
        this.handleAdd = this.handleAdd.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
      }

      handleChangeName = event => {
        this.setState({name: event.target.value});
      }
      handleChangeUniversity = event => {
        this.setState({university: event.target.value});
      }
      handleChangeFaculty = event => {
        this.setState({faculty: event.target.value});
      }
    
      handleAdd = event => {
        event.preventDefault();
        axios.post(`http://localhost:8080/faculties/add`, {
            "facultyId": 0,
            "name": this.state.name,
            "university": {
              "city": "string",
              "name": "string",
              "universityId": this.state.university
            }
          })
        .then(res => {
         // console.log(res);
        })
        this.setState({name: '', university: 1})
      }
      handleDelete = event => {
        event.preventDefault();
        axios.delete(`http://localhost:8080/faculties/delete/${ this.state.faculty }`)
        .then(res => {
          console.log(res);
        })
        this.setState({faculty: 1});
         window.location.reload();
      }

      componentDidMount(){
        axios.get('http://localhost:8080/universities')
            .then(response => {
                this.setState({universities: response.data}); 
            });
        axios.get('http://localhost:8080/faculties')
            .then(response => {
                this.setState({faculties: response.data}); 
            });
    }

    render() {
        const universitiesList = this.state.universities.map((university) =>
            <option key={ university.universityId } value={ university.universityId }> { university.name }, { university.city } </option>
    );
        const facultiesList = this.state.faculties.map((faculty) =>
            <option key={ faculty.facultyId } value={ faculty.facultyId }> { faculty.name }, { faculty.university.name } </option>
);
      return (
          <div className="EditFaculty">
            <form className="AddFaculty" onSubmit={this.handleSubmit}>
              <input className="AddInput" type="text" placeholder="Name.." value={this.state.name} onChange={this.handleChangeName} />
              <select className="DeleteInput" onChange={this.handleChangeUniversity}>
              { universitiesList }
              </select>
              <input className="Button" type="submit" value="Add" />
            </form>
            <form className="DeleteFaculty" onSubmit={this.handleDelete}>
                <select className="DeleteInput" onChange={this.handleChangeFaculty}>
                        { facultiesList }
                </select>
                <input className="Button" type="submit" value="Delete" />
            </form>
           </div>
      )
    }
  }

  export default AddFaculty