import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

export default function LoginComponent() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [showErrorMessage, setShowErrorMessage] = useState(false);

  const navigate = useNavigate();
  const authContext = useAuth();

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };
  const handleSubmit = async () => {
    if (await authContext.login(username, password)) {
      navigate(`/welcome/${username}`);
    } else {
      navigate('/login');
      setShowErrorMessage(true);
    }
  };

  return (
    <div className="Login">
      <h1>Login Page!</h1>
      {showErrorMessage && (
        <div>Login Failed. Please Try another Id or Password</div>
      )}

      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            login
          </button>
          {showErrorMessage && <div>Login Falied</div>}
        </div>
      </div>
    </div>
  );
}
