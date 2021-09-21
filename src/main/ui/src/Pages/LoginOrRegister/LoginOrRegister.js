import React, { useState } from 'react';
import axios from 'axios';
import Navbar from '../../Components/Navbar';
import Jumbotron from '../../Components/Jumbotron';
import Footer from '../../Components/Footer';

const LoginOrRegister = () => {
  const [loginState, setLoginState] = useState({
    users: [],
    isSignedIn: false
  });

  loginState.handleInputChange = event => {
    setLoginState({ ...loginState, [event.target.name]: event.target.value });
  };

  loginState.handleLogin = event => {
    event.preventDefault();
    axios.defaults.headers.put['Content-Type'] = 'applicaion/json;charset=utf-8';
    axios.defaults.headers.put['Access-Control-Allow-Origin'] = '*';
    axios.put('http://localhost:8080/user/login', {
      username: loginState.username,
      password: loginState.password
    })
      .then(({ data }) => {
        console.log(data);
        if (data) {
          window.localStorage.setItem('user', data);
          window.location = '/createTicket';
        } else {
          window.alert('An error occurred during login. Please try again.');
          window.location = '/';
        }
      })
      .catch(err => console.error(err));
  };

  if (window.localStorage.getItem('user')) {
    axios.get('localhost:8080/user/login', {
      username: loginState.username
    })
      .then(({ data }) => {
        console.log(data);
        window.location = '/createTicket';
      })
      .catch(err => console.error(err));
  }

  const [registerState, setRegisterState] = useState({
    users: '',
    handleRegister: '',
    handleInputChange: ''
  });

  registerState.handleInputChange = event => {
    setRegisterState({ ...registerState, [event.target.name]: event.target.value });
    console.log(registerState);
  };

  registerState.handleRegister = event => {
    event.preventDefault();
    axios.post('http://localhost:8080/user', {
      username: registerState.username,
      password: registerState.password
    })
      .then(({ data }) => {
        if (data) {
          console.log(data);
          window.localStorage.setItem('user', data);
          window.location = '/createTicket';
        } else {
          window.alert('An error occurred during registration. Please try again.');
          window.location = '/';
        }
      })
      .catch(err => console.error(err));
  };

  return (
    <>
      <Navbar />
      <Jumbotron />
      <form id='loginForm'>
        <div className='row'>
          <h3 id='alertDiv'>To begin, log in or register below!</h3>
          <div className='col-sm-3 offset-md-3'>
            <label htmlFor='registerName' className='form-label'>Register here</label>
            <input
              className='form-control'
              type='text'
              aria-label='Register Input'
              id='registerName'
              name='registerName'
              placeholder='Username'
              onChange={event => loginState.handleInputChange(event)}
            />
            <br />
            <input
              className='form-control'
              type='password'
              aria-label='Register Password'
              id='registerPassword'
              name='registerPassword'
              placeholder='Password'
              onChange={event => loginState.handleInputChange(event)}
            />
            <br />
            <button
              type='button'
              className='btn btn-primary'
              onClick={event => registerState.handleRegister(event)}
            >
              Register
            </button>
          </div>
          <div className='col-sm-3'>
            <label htmlFor='loginName' className='form-label'>Log in here</label>
            <input
              className='form-control'
              type='text'
              aria-label='Login Name'
              id='loginName'
              name='loginName'
              placeholder='Username'
              onChange={event => loginState.handleInputChange(event)}
            />
            <br />
            <input
              className='form-control'
              type='password'
              aria-label='Login Password'
              id='loginPassword'
              name='loginPassword'
              placeholder='Password'
              onChange={event => loginState.handleInputChange(event)}
            />
            <br />
            <button
              type='button'
              className='btn btn-info'
              onClick={event => loginState.handleLogin(event)}
            >
              Log In
            </button>
          </div>
        </div>
      </form>
      <Footer />
    </>
  );
};

export default LoginOrRegister;
