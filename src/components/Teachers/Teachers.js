import React from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom'
import Teacher from './Teacher';

class Teachers extends React.Component {

    state = {
        teachers: []
    }

    componentDidMount(){
        axios.get(`http://localhost:8080/teachers/statistics/teachersList/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({teachers: response.data}); 
            });
    }

    render() {
        const teachersList = this.state.teachers.map((teacher) =>
             <Link key={ teacher.teacherId } to={`/teacher/${teacher.teacherId}`}> <Teacher key={ teacher.teacherId } id={ teacher.teacherId } name={ teacher.name } surname={ teacher.surname }> </Teacher> </Link>
        );

        return <div className="TeachersList"> { teachersList } </div>;
    }
  }

  export default Teachers