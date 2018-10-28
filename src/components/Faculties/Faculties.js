import React from 'react';
import axios from 'axios';
import Faculty from './Faculty';

class Faculties extends React.Component {

    state = {
        faculties: [],
        showTeachers: false,
        facultyClicked: undefined
    }

    componentDidMount(){
        axios.get('https://api.myjson.com/bins/14lpv0')
            .then(response => {
                const faculties = response.data;

                this.setState({faculties: response.data});
                
            });

    }

    receiveData = (facultyClicked) => {
        this.setState({showTeachers: true});
        this.setState({facultyClicked: facultyClicked});

        this.props.passData(facultyClicked);
    }

    render() {

        const faculties = this.state.faculties.map(faculty => {
            if(this.props.uniId === faculty.university.universityId){
                return (
                    <Faculty
                    id={faculty.facultyId} 
                    name={faculty.name} 
                    city={faculty.city} 
                    uniID={faculty.university.universityId}
                    receiveData={this.receiveData}/>
                )
            }
        });

      return (
        <div className="Faculties row justify-content-center">
            {faculties}
        </div>
      )
    }
  }

  export default Faculties;