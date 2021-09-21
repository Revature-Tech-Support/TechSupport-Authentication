import React, { useRef, useState } from 'react';
import Navbar from '../../Components/Navbar';
import Jumbotron from '../../Components/Jumbotron';
import Footer from '../../Components/Footer';
import axios from 'axios';

const Ticket = () => {
  // states
  const [subject, setSubject] = useState('');
  const [issue, setIssue] = useState('');
  const [ticket, setTicket] = useState([]);

  const fileUpload = useRef();

  const handleSubjectChange = event => {
    setSubject(event.target.value);
  };

  const handleIssueChange = event => {
    setIssue(event.target.value);
  };

  const submitTicket = event => {
    event.preventDefault();
    console.log(subject);
    console.log(issue);
    if (issue !== '') {
      axios.post('/tickets', {
        subject,
        issue
        // files: fileUpload
      })
        .then(({ data }) => {
          if (data) {
            console.log(data);
            window.alert(`Your ticket with ID: ${ticket.id} has been submitted!`);
            setSubject('');
            setIssue('');
          } else {
            window.alert('Please enter in details about your issue.');
          }
        })
        .catch(err => console.error(err));
    }
  };

  return (
    <>
      <Navbar />
      <Jumbotron />
      <h2>Create a Ticket</h2>
      <div className='container ticketContainer'>
        <form>
          <div className='row justify-content-center'>
            <label htmlFor='subject' className='form-label'>Subject</label>
            <div className='col-3 p-3'>
              <input
                type='text'
                className='form-control'
                input={subject}
                onChange={event => handleSubjectChange(event)}
              />
            </div>
          </div>
          <div className='mb-3'>
            <label htmlFor='textArea' className='form-label'>Issue</label>
            <textarea
              className='form-control'
              id='textArea'
              rows='3'
              placeholder='Please enter in details about your issue.'
              input={issue}
              onChange={event => handleIssueChange(event)}
              required
            >
              {}
            </textarea>
          </div>
          <div className='mb-3'>
            <label htmlFor='formFileMultiple' className='form-label'>Upload file(s) here</label>
            <input
              className='form-control'
              ref={fileUpload}
              type='file'
              multiple
            />
          </div>
          <button
            type='submit'
            className='btn btn-primary'
            onClick={event => submitTicket(event)}
          >
            Submit
          </button>
        </form>
      </div>
      <Footer />
    </>
  );
};

export default Ticket;
