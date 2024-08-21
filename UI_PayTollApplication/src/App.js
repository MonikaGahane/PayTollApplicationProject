import './App.css';
import Home from './components/Home/Home';
import Login from './components/Login/Login';
import { useState } from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';
import Signup from './components/Signup/Signup';



function App() {
  const [title, updateTitle] = useState(null);
  const [errorMessage, updateErrorMessage] = useState(null);
  return (
    <Router>
    <div className="App">
      <img src='toll-booth-background.jpg'></img>
      
      Toll Application Management!
      
         <div className="container d-flex align-items-center flex-column">
          <Switch>
            <Route path="/" exact={true}>
              <Login showError={updateErrorMessage} updateTitle={updateTitle}/>
            </Route>
            <Route path="/login">
              <Login showError={updateErrorMessage} updateTitle={updateTitle}/>
            </Route>
            <Route path="/register">
              <Signup showError={updateErrorMessage} updateTitle={updateTitle}/>
            </Route>
            <Route path="/home">
              <Home showError={updateErrorMessage} updateTitle={updateTitle}/>
            </Route>
          </Switch>
        </div>
    </div>
    </Router>
  );
}

export default App;
