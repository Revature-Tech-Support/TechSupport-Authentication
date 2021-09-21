import React, { useState } from 'react';
import './App.css';
import { Route, Redirect, Switch, BrowserRouter as Router } from 'react-router-dom';
// import Home from './Pages/Home';
import LoginOrRegister from './Pages/LoginOrRegister';
import Ticket from './Pages/Ticket';
import Chat from './Pages/Chat';
import Queue from './Pages/Queue';
import History from './Pages/History';
// import PrivateRoute from './Components/PrivateRoute/PrivateRoute';

const App = () => {
  const [user] = useState(window.localStorage.getItem('username'));

  return (
    <>
      <Router>
        <Switch>
          <Redirect exact from='/' to='/login' />
          <Route path='/login' component={LoginOrRegister} />
          <Route path='/chat' component={() => <Chat user={user} />} />
          <Route path='/createTicket' component={Ticket} />
          <Route path='/queue' component={Queue} />
          <Route path='/history' component={History} />
        </Switch>
      </Router>
    </>
    // user == null ? (
    // <>
    //   <Router>
    //     <Switch>
    //       <Redirect exact from='/' to='/login' />
    //       </Switch>
    //     </Router>
    //   </>
    //   ) : (
    //   <>
    //     <Router>
    //       <Switch>
    //         <Route exactpath='/' component={Home} />
    //         <Route path='/login' component={LoginOrRegister} />
    //         <PrivateRoute path='/chat' component={Chat} />
    //         <PrivateRoute path='/createTicket' component={Ticket} />
    //       </Switch>
    //     </Router>
    //   </>
    // )
  );
};

export default App;
