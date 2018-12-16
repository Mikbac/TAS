import React from 'react'
import { Switch, Route } from 'react-router-dom'
import Universities from './Universities/Universities'
import AddUniversity from './AddUniversity/AddUniversity'
import AddFaculty from './AddFaculty/AddFaculty'
import AddTeacher from './AddTeacher/AddTeacher'
import Teachers from './Teachers/Teachers'
import TeacherPage from './Teachers/TeacherPage'

const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={Universities}/>
      <Route path='/add-university' component={AddUniversity}/>
      <Route path='/add-faculty' component={AddFaculty}/>
      <Route path='/add-teacher' component={AddTeacher}/>
      <Route path='/teachers/:id' component={ Teachers }/>
      <Route path='/teacher/:id' component={ TeacherPage }/>
    </Switch>
  </main>
)

export default Main