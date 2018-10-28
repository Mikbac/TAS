import React from 'react';
import './University.css';

class University extends React.Component {
   
    render(){
   return (
        <div 
        className="University col-12 col-md-4 col-lg-3 mx-4 my-4 d-flex text-center justify-content-center"
        onClick={() => this.props.receiveData(this.props.id)} 
        style={{cursor:'pointer'}}>
            <div className="align-self-center">
                <p className="uniName">{this.props.name}</p>
                <p className="">{this.props.city}</p>
            </div>
        </div>
    )
}
}

export default University;