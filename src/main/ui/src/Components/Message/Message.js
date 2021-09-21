const Message = ({ message }) => {
  return (
    <div className='col'>
      <li className={message.username === window.localStorage.getItem('username') ? 'sender' : 'receiver'}>
        <div className='msg'>
          {/* <p>{data.sender.username}</p> */}
          {/* <div className='msgText'> {data.data.text}</div> */}
          <p>{message.message}</p>
        </div>
      </li>
    </div>
  );
};

export default Message;
