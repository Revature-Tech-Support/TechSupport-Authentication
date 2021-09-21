import React from 'react';
import Navbar from '../../Components/Navbar';
import Footer from '../../Components/Footer';

const Queue = ({ ticketId }) => {
  // const [userId, setUserId] = useState(window.localStorage.getItem('userId'));

  const startChat = event => {
    if (window.confirm('This will open a chat with the corresponding client. Proceed?')) {
      window.location = '/chat';
    }
  };

  return (
    <>
      <Navbar />
      <div className='jumbotron'>
        <h1 className='display-4'>Welcome to back to work!</h1>
        <p className='lead'><b>Remember the golden question:</b> Have you tried turning it off and on again?</p>
        <p className='lead'>{}</p>
        <hr className='my-4' />
      </div>
      <div className='container'>
        <button
          className='btn btn-success'
          onClick={event => startChat(event)}
        >Start chat with next client
        </button>
      </div>
      <Footer />
    </>
  );
};

export default Queue;
