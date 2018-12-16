import React from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom'
import './University.css'
import university from '../../assets/university.png'

class University extends React.Component {

    state = {
        faculties: []
    }

    componentDidMount(){
        axios.get(`http://localhost:8080/faculties/statistics/facultiesList/${ this.props.id }`)
            .then(response => {
                this.setState({faculties: response.data}); 
            });
    }

    render() {
        const facultiesList = this.state.faculties.map((faculty) =>
        <li key={ faculty.facultyId } id={ faculty.facultyId } name={ faculty.name }> <Link to={`/teachers/${faculty.facultyId}`}>  { faculty.name } </Link> </li>
    );
        return (
            
          <div className="University">
            <div>
            <div className="UniversityName"> { this.props.name } </div>
            <div className="UniversityCity"> { this.props.city } </div>
            <div className="UniversityImg"><img src={ university } alt=""/></div>
            </div>
            <ul className="FacultiesList">
                { facultiesList }
            </ul>
          </div>
        )
    }
  }

  export default University