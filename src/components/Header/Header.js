import React from 'react'
import './Header.css'
import { Link } from 'react-router-dom'
import logo from '../../assets/logo.png'

// The Header creates links that can be used to navigate
// between routes.
const Header = () => (
  <header>
    <nav>
      <ul className="Menu">
        <li><Link to='/'><img className="Logo" src={ logo } alt=""/></Link></li>
        <ul className="MenuRight">
          <li><Link to='/add-university'>university</Link></li>
          <li><Link to='/add-faculty'>faculty</Link></li>
          <li><Link to='/add-teacher'>teacher</Link></li>
        </ul>
      </ul>
    </nav>
  </header>
)

export default Header
