import React from 'react'
import axios from 'axios';
import University from './University';

class Universities extends React.Component {

    state = {
        universities: [],
        faculties: []
    }

    componentDidMount(){
        axios.get('http://localhost:8080/universities')
            .then(response => {
                this.setState({universities: response.data}); 
            });
    }

    render() {
        const universitiesList = this.state.universities.map((university) =>
            <University key={ university.universityId } id={ university.universityId } name={ university.name } city={ university.city } />
        );

        return <div> { universitiesList } </div>;
    }
  }

  export default Universities