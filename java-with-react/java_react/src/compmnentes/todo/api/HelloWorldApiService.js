import axios from 'axios';
import { apiClient } from './ApiClient';

export const retrieveHelloWorld = () => {
  return apiClient.get('/hello-world-bean');
};

export const retrieveHelloWorldPathVariable = (username, token) => {
  return apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
      Authorization: token,
    },
  });
};
