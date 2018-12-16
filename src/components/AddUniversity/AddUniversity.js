import React from 'react'
import axios from 'axios';
import './AddUniversity.css';

class AddUniversity extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            city: '',
            universities: [],
            university: 1 
        };
    
        this.handleChangeName = this.handleChangeName.bind(this);
        this.handleChangeCity = this.handleChangeCity.bind(this);
        this.handleAdd = this.handleAdd.bind(this);
        this.handleChangeUniversity = this.handleChangeUniversity.bind(this);
      }

      handleChangeName = event => {
        this.setState({name: event.target.value});
      }
      handleChangeCity = event => {
        this.setState({city: event.target.value});
      }
      handleChangeUniversity = event => {
        this.setState({university: event.target.value});
      }
    
      handleAdd = event => {
        event.preventDefault();
        axios.post(`http://localhost:8080/universities/add`, {
            "city": this.state.city,
            "name": this.state.name,
            "universityId": 0
          })
        .then(res => {
          console.log(res);
        })
        this.setState({name: "", city: ""})
      }

      handleDelete = event => {
        event.preventDefault();
        axios.delete(`http://localhost:8080/universities/delete/${ this.state.university }`)
        .then(res => {
          console.log(res);
        })
        this.setState({university: 0});
        window.location.reload();
      }

      componentDidMount(){
        axios.get('http://localhost:8080/universities')
            .then(response => {
                this.setState({universities: response.data}); 
            });
    }

    render() {
        const universitiesList = this.state.universities.map((university) =>
        <option key={ university.universityId } value={ university.universityId }> { university.name }, { university.city } </option>
        );
      return (
          <div className="EditUniversity">
            <form className="AddUniversity" onSubmit={this.handleAdd}>
                <input className="AddInput" type="text" placeholder="Name.." value={this.state.name} onChange={this.handleChangeName} />
                <input className="AddInput" type="text" placeholder="Surname.." value={this.state.city} onChange={this.handleChangeCity} />
                <input className="Button" type="submit" value="Add" />
            </form>

            <form className="DeleteUniversity" onSubmit={this.handleDelete}>
                <select className="DeleteInput" onChange={this.handleChangeUniversity}>
                    { universitiesList }
                </select>
                <input className="Button" type="submit" value="Delete" />
            </form>
      </div>
      )
    }
  }

  export default AddUniversity