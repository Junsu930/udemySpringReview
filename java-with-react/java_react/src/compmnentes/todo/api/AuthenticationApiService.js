import { apiClient } from './ApiClient';

export const executeBasicAuthenticationService = (token) => {
  return apiClient.get(`/basicauth`, {
    headers: {
      Authorization: token,
    },
  });
};

export const executeJWTAuthenticationService = (username, password) => {
  return apiClient.post(`/authenticate`, { username, password });
};
