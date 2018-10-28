import React from 'react';
import './Teacher.css';

class Teacher extends React.Component {
    render() {
        let result;

        if(this.props.teacherPage) {
            result = <div className="TeacherPage">
                        <div className="row d-flex justify-content-center">
                            <div className="Profile col-10 col-lg-3 mx-2 my-4">
                                <h1 className="text-center">{this.props.name}</h1>
                                <h1 className="text-center">{this.props.surname}</h1>
                                <div className="Rates text-center">
                                    <div>
                                        Attractivness: 7.6
                                    </div>
                                    <div>
                                        Classes: 7.6
                                    </div>
                                    <div>
                                        Competency: 7.6
                                    </div>
                                    <div>
                                       Difficulty: 7.6
                                    </div>
                                    <div>
                                        Friendship: 7.6
                                    </div>
                                    <div>
                                        System: 7.6
                                    </div>
                                </div>
                            </div>
                            <div className="Rate col-10 col-lg-8 mx-2 my-4 text-center">
                                <h1>Add vote</h1>
                                <form className="row my-lg-4">
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    Attractiveness
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    Classes
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    Competency
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    Difficulty
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    Friendship
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>
                                    <label className="col-12 col-md-4 d-flex justify-content-between">
                                    System
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                    </select>
                                    </label>

                                    <div className="col-12">
                                        <div className="row d-flex justify-content-center">
                                            <p className="AddComment col-12 my-1 my-md-4">Add comment</p>
                                            <input className="form-control col-10 col-lg-8 my-1 my-md-4" type="textarea"/>
                                            <input className="btn col-10 col-lg-6 my-1 my-md-4 justify-content-center" type="submit" value="Submit" />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div className="row d-flex justify-content-center">
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                            <div className="Comment col-12 col-lg-10 my-4 d-flex align-items-center justify-content-center">Some comment blalblalblalblla</div>
                        </div>

                     </div>
        } else {
            result = <div className="Teacher col-12 col-md-4 col-lg-3 mx-4 my-4 d-flex text-center justify-content-center"
                      onClick={() => this.props.receiveData(this.props.id)}
                      style={{cursor:'pointer'}}>
                         <div className="teacherName align-self-center">
                           <p>{this.props.name}</p>
                           <p>{this.props.surname}</p>
                         </div>
                     </div>
        }

      return result;
    }
    }

export default Teacher;