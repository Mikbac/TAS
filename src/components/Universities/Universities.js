import React from 'react';
import axios from 'axios';
import University from './University';

class Universities extends React.Component {

    state = {
        universities: [],
        showFaculties: false,
        uniClicked: undefined
    }

    componentDidMount(){
        axios.get('https://api.myjson.com/bins/echb8')
            .then(response => {
                const universities = response.data;

                this.setState({universities: response.data});
                
            });
    }

    receiveData = (uniClicked) => {
        this.setState({showFaculties: true});
        this.setState({uniClicked: uniClicked});

        this.props.passData(uniClicked);
    }

    render() {

        const universities = this.state.universities.map(university => {
            return (
                    <University 
                    id={university.universityId} 
                    name={university.name} 
                    city={university.city}
                    receiveData={this.receiveData}/>
            )
        });

      return (
          <div className="Universities row justify-content-center">
            {universities}
          </div>
      )
    }
  }

  export default Universities;