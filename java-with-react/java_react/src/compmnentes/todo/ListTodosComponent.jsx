import { useEffect, useState } from 'react';
import {
  deleteTodoApi,
  retrieveTodosForUsername,
  updateTodoApi,
} from './api/TodoApiService';
import { useAuth } from './security/AuthContext';
import { useNavigate } from 'react-router-dom';

export default function ListTodosComponent() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay(),
  );
  const authContext = useAuth();
  const username = authContext.username;
  const navigate = useNavigate();
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  useEffect(() => refreshTodos, []);

  function refreshTodos() {
    retrieveTodosForUsername(username)
      .then((response) => {
        console.log(response);
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }

  function updateTodo(id) {
    navigate(`/todo/${id}`);
  }

  function deleteTodo(id) {
    deleteTodoApi(username, id)
      .then((response) => {
        setMessage(`Delete of todo with ${id} successful`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }

  function addNewTodo(id) {
    navigate(`/todo/-1`);
  }

  return (
    <div className="container">
      <h1>Things You want to do!</h1>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Is Done?</th>
              <th>Target Date</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toString()}</td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(todo.id)}
                  >
                    수정
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    삭제
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="btn btn-success m-5" onClick={addNewTodo}>
        Add new Todo
      </div>
    </div>
  );
}
