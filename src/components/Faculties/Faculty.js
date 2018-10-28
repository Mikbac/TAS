import React from 'react';
import './Faculty.css';

class Faculty extends React.Component {
   
    render(){
   return (
        <div className="Faculty col-12 col-md-4 col-lg-3 mx-4 my-4 d-flex text-center justify-content-center"
        onClick={() => this.props.receiveData(this.props.id)}
        style={{cursor:'pointer'}}>
            <p className=" facName align-self-center">{this.props.name}</p>
        </div>
    )
}
}

export default Faculty;