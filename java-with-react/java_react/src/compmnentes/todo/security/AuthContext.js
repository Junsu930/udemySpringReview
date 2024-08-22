import { createContext, useContext, useState } from 'react';
import {
  executeBasicAuthenticationService,
  executeJWTAuthenticationService,
} from '../api/AuthenticationApiService';
import { apiClient } from '../api/ApiClient';

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const [token, setToken] = useState(null);

  // function login(username, password) {
  //   if (username === 'junsu930' && password === 'junsu930') {
  //     setIsAuthenticated(true);
  //     setUsername(username);
  //     return true;
  //   } else {
  //     setIsAuthenticated(false);
  //     setUsername(null);
  //     return false;
  //   }
  // }
  async function login(username, password) {
    try {
      const response = await executeJWTAuthenticationService(
        username,
        password,
      );

      console.log(response.status);

      if (response.status == 200) {
        const jwtToken = 'Bearer ' + response.data.token;
        setIsAuthenticated(true);
        setUsername(username);
        setToken(jwtToken);
        apiClient.interceptors.request.use((config) => {
          console.log('intercepting and adding a token');
          config.headers.Authorization = jwtToken;
          return config;
        });
        return true;
      } else {
        logout();
        return false;
      }
    } catch (error) {
      logout();
      return false;
    }

    // async function login(username, password) {
    //   const baToken = 'Basic ' + window.btoa(username + ':' + password);

    //   try {
    //     const response = await executeBasicAuthenticationService(baToken);

    //     console.log(response.status);

    //     if (response.status == 200) {
    //       setIsAuthenticated(true);
    //       setUsername(username);
    //       setToken(baToken);
    //       apiClient.interceptors.request.use((config) => {
    //         console.log('intercepting and adding a token');
    //         config.headers.Authorization = baToken;
    //         return config;
    //       });
    //       return true;
    //     } else {
    //       logout();
    //       return false;
    //     }
    //   } catch (error) {
    //     logout();
    //     return false;
    //   }

    // if (username === 'junsu930' && password === 'junsu930') {
    //   setIsAuthenticated(true);
    //   setUsername(username);
    //   return true;
    // } else {
    //   setIsAuthenticated(false);
    //   setUsername(null);
    //   return false;
    // }
  }

  function logout() {
    setIsAuthenticated(false);
    setToken(null);
    setUsername(null);
  }

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, login, logout, username, token }}
    >
      {children}
    </AuthContext.Provider>
  );
}
