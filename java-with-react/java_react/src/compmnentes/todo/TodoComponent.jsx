import { useNavigate, useParams } from 'react-router-dom';
import {
  createTodoApi,
  retrieveTodoApi,
  updateTodoApi,
} from './api/TodoApiService';
import { useAuth } from './security/AuthContext';
import { useEffect, useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import moment from 'moment';

function TodoComponent() {
  const { id } = useParams();
  const [description, setDescription] = useState('');
  const [targetDate, setTargetDate] = useState('');
  const authContext = useAuth();
  const username = authContext.username;

  const navigate = useNavigate();
  useEffect(() => retrieveTodos(), [id]);

  function retrieveTodos() {
    if (id !== -1) {
      retrieveTodoApi(username, id)
        .then((response) => {
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
        })
        .catch((error) => console.log(error));
    }
  }

  function onSubmit(value) {
    const todo = {
      id: id,
      username: username,
      description: value.description,
      targetDate: value.targetDate,
      done: false,
    };

    if (id === '-1') {
      createTodoApi(username, todo)
        .then((response) => {
          navigate('/todos');
        })
        .catch((error) => console.log(error));
    } else {
      updateTodoApi(username, id, todo).then((response) => {
        console.log(response);
        navigate('/todos');
      });
    }
  }

  function validate(values) {
    let error = {
      // description: 'Enter a valid description',
      // targetDate: 'Enter a valid target date',
    };
    if (values.description.length < 5) {
      error.description = 'Enter at least 5 characters';
    }

    if (
      values.targetDate == null ||
      values.targetDate === '' ||
      !moment(values.targetDate).isValid()
    ) {
      error.targetDate = 'Enter a target Date';
    }

    return error;
  }

  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <Formik
        initialValues={{ description, targetDate }}
        enableReinitialize={true}
        onSubmit={onSubmit}
        validate={validate}
        validateOnBlur={false}
        validateOnChange={false}
      >
        {(props) => (
          <Form>
            <ErrorMessage
              name="description"
              component="div"
              className="alert alert-warning"
            />

            <ErrorMessage
              name="targetDate"
              component="div"
              className="alert alert-warning"
            />

            <fieldset className="form-group">
              <label> Description </label>
              <Field type="text" className="form-control" name="description" />
            </fieldset>
            <fieldset className="form-group">
              <label> Target Date </label>
              <Field type="date" className="form-control" name="targetDate" />
            </fieldset>
            <div>
              <button className="btn btn-success m-5" type="submit">
                저장
              </button>
            </div>
          </Form>
        )}
      </Formik>
    </div>
  );
}

export default TodoComponent;
