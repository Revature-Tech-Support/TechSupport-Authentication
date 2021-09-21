import React, { useState } from 'react';

const Navbar = () => {
  const [user] = useState('agent');

  const [setRedirect] = useState(false);

  const signOut = () => {
    window.localStorage.removeItem('user');
    window.localStorage.clear();
    window.location = './login';
    setRedirect(true);
  };

  if (user == null) {
    return (
      <>
        <nav className='navbar navbar-expand-lg navbar-light bg-secondary'>
          <div className='container-fluid'>
            <a className='navbar-brand' href='http://revature.com'>{}</a>
            <div className='navbar-nav'>
              <a className='nav-link' href='/'>Home</a>
              <a className='nav-link' href='/login'>Login/Register</a>
            </div>
          </div>
        </nav>
      </>
    );
  } else if (user === 'agent') {
    return (
      <>
        <nav className='navbar navbar-expand-lg navbar-light bg-secondary'>
          <div className='container-fluid'>
            <a className='navbar-brand' href='http://revature.com'>Revature</a>
            <div className='navbar-nav'>
              <a className='nav-link' href='/login' onClick={event => signOut(event)}>Sign Out</a>
              <a className='nav-link' href='/chat'>Chat</a>
              <a className='nav-link' href='/queue'>Queue</a>
            </div>
          </div>
        </nav>
      </>
    );
  } else {
    return (
      <>
        <nav className='navbar navbar-expand-lg navbar-light bg-secondary'>
          <div className='container-fluid'>
            <a className='navbar-brand' href='http://revature.com'>Revature</a>
            <div className='navbar-nav'>
              <a className='nav-link' href='/login' onClick={event => signOut(event)}>Sign Out</a>
              <a className='nav-link' href='/createTicket'>Create Ticket</a>
            </div>
          </div>
        </nav>
      </>
    );
  }
};

export default Navbar;
