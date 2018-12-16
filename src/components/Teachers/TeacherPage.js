import React from 'react'
import axios from 'axios';
import './TeacherPage.css';
import ReactStars from 'react-stars'
import teacherImg from '../../assets/teacher.png'

class TeacherPage extends React.Component {

    constructor(props) {
        super(props);
    this.state = {
        teacher: [],
        comments: [],
        attractiveness: 0,
        classes: 0,
        competency: 0,
        difficulty: 0,
        friendship: 0,
        system: 0,

        attractivenessVote: 0,
        classesVote: 0,
        competencyVote: 0,
        difficultyVote: 0,
        friendshipVote: 0,
        systemVote: 0,
        commentAdd: ""
    };

    this.handleChangeAttractiveness = this.handleChangeAttractiveness.bind(this);
    this.handleChangeClasses = this.handleChangeClasses.bind(this);
    this.handleChangeCompetency = this.handleChangeCompetency.bind(this);
    this.handleChangeDifficulty = this.handleChangeDifficulty.bind(this);
    this.handleChangeFriendship = this.handleChangeFriendship.bind(this);
    this.handleChangeSystem = this.handleChangeSystem.bind(this);
    this.handleChangeComment = this.handleChangeComment.bind(this);
  }

    handleChangeAttractiveness = newRating => {
        this.setState({attractivenessVote: newRating});
      }
    handleChangeClasses = newRating => {
        this.setState({classesVote: newRating});
      }
    handleChangeCompetency = newRating => {
        this.setState({competencyVote: newRating});
      }
    handleChangeDifficulty = newRating => {
        this.setState({difficultyVote: newRating});
      }
    handleChangeFriendship = newRating => {
        this.setState({friendshipVote: newRating});
      }
    handleChangeSystem = newRating => {
        this.setState({systemVote: newRating});
      }
    handleChangeComment = event => {
        this.setState({commentAdd: event.target.value});
      }

      handleSubmit = event => {
        event.preventDefault();
        if(/\S/.test(this.state.commentAdd)){
        axios.post(`http://localhost:8080/votes/add`, {
            "attractiveness": this.state.attractivenessVote,
            "classes": this.state.classesVote,
            "comment": this.state.commentAdd,
            "competency": this.state.competencyVote,
            "difficulty": this.state.difficultyVote,
            "friendship": this.state.friendshipVote,
            "system": this.state.systemVote,
            "teacher": {
              "faculty": {
                "facultyId": 0,
                "name": "string",
                "university": {
                  "city": "string",
                  "name": "string",
                  "universityId": 0
                }
              },
              "name": "string",
              "surname": "string",
              "teacherId": this.props.match.params.id
            },
            "voteId": 0
          })
        .then(res => {
         // console.log(res);
        })
    } else {
        alert("Comment incorrect!")
    }
        this.setState({ 
            attractivenessVote: 0,
            classesVote: 0,
            competencyVote: 0,
            difficultyVote: 0,
            friendshipVote: 0,
            systemVote: 0,
            commentAdd: ""})
        
            window.location.reload();
      }

    componentDidMount(){
        axios.get(`http://localhost:8080/teachers/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({teacher: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/commentsList/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({comments: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/attractivenessAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({attractiveness: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/classesAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({classes: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/competencyAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({competency: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/difficultyAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({difficulty: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/friendshipAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({friendship: response.data}); 
            });
        axios.get(`http://localhost:8080/votes/statistics/systemAverage/${ this.props.match.params.id }`)
            .then(response => {
                this.setState({system: response.data}); 
            });
    }

    render() {

        const commentsList = this.state.comments.map((comment, index) => 
            <li className="Comment" key={ index }> { comment } </li>
        )

        return (
                <div className="TeacherPage">
                    <form className="Vote" onSubmit={this.handleSubmit}>
                        <div className="VoteOption">
                            <p>Attractiveness</p>
                            <ReactStars
                                value={this.state.attractivenessVote}
                                count={10}
                                onChange={this.handleChangeAttractiveness}
                                size={30}
                                half={ false }
                                color2={'#ffd700'} />
                        </div>
                        <div className="VoteOption">
                        <p>Classes</p>
                        <ReactStars
                            value={this.state.classesVote}
                            count={10}
                            onChange={this.handleChangeClasses}
                            size={30}
                            half={ false }
                            color2={'#ffd700'} />
                        </div>
                        <div className="VoteOption">
                        <p>Competency</p>
                        <ReactStars
                            value={this.state.competencyVote}
                            count={10}
                            onChange={this.handleChangeCompetency}
                            size={30}
                            half={ false }
                            color2={'#ffd700'} />
                         </div>
                         <div className="VoteOption">
                        <p>Difficulty</p>
                        <ReactStars
                            value={this.state.difficultyVote}
                            count={10}
                            onChange={this.handleChangeDifficulty}
                            size={30}
                            half={ false }
                            color2={'#ffd700'} />
                         </div>
                         <div className="VoteOption">
                        <p>Friendship</p>
                        <ReactStars
                            value={this.state.friendshipVote}
                            count={10}
                            onChange={this.handleChangeFriendship}
                            size={30}
                            half={ false }
                            color2={'#ffd700'} />
                         </div>
                        <div className="VoteOption">
                        <p>System</p>
                        <ReactStars
                            value={this.state.systemVote}
                            count={10}
                            onChange={this.handleChangeSystem}
                            size={30}
                            half={ false }
                            color2={'#ffd700'} />
                        </div>
                        <input className="InputComment" type="text" placeholder="Comment.." value={this.state.commentAdd} onChange={this.handleChangeComment} />
                        <input className="Submit" type="submit" value="Add vote" />
                    </form>
                    <div className="Profile">
                        <div className="TeacherTitle">
                            <div>
                               <p> { this.state.teacher.name } </p>
                               <p> { this.state.teacher.surname } </p>
                            </div>
                            <div className="TeacherImg"><img src={ teacherImg } alt=""/></div>
                        </div>
                        <div>
                            <p>Attractiveness: { Math.round(this.state.attractiveness * 10) / 10 }</p>
                            <p>Classes: { Math.round(this.state.classes * 10) / 10 }</p>
                            <p>Competency: { Math.round(this.state.competency * 10) / 10 }</p>
                            <p>Difficulty: { Math.round(this.state.difficulty * 10) / 10 }</p>
                            <p>Friendship: { Math.round(this.state.friendship * 10) / 10 }</p>
                            <p>System: { Math.round(this.state.system * 10) / 10 }</p>
                        </div>
                    </div>
                    <ul className="Comments">
                        { commentsList }
                    </ul>
               </div>
               )
        }
  }

  export default TeacherPage