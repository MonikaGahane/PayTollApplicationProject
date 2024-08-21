
import React, {  useState } from "react";
import { withRouter } from "react-router-dom";
import './Login.css'
import axios from "axios";




function Login(props) {
    
    const [formData , setFormData] = useState({
        email : "",
        password : ""
    })
    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmitClick = async (e) => {
        e.preventDefault();
        const payload={
            "email": formData.email,
            "password": btoa(formData.password)
        }

        // if(payload.userId === 'abcd' && payload.password === 'password') {
        //     redirectToHome('/home');
        // }

        const headers = {
          'Content-Type': 'application/json'
      };
    
        try {
          const response = await axios.post('http://localhost:8080/auth/login', payload,{headers});
          localStorage.setItem("isAdmin",response.data.admin);
          localStorage.setItem("userName",response.data.userName);
          localStorage.setItem("email",response.data.email);
          localStorage.setItem("userId",response.data.userId);
          console.log('Response:', response.data);
          redirectToHome('/home');
          } catch (error) {
            console.error('Error:', error);
          }

    }
    const redirectToHome = () => {
        props.updateTitle('Home');
        props.history.push('/home'); 
    }

    const redirectToRegister = () => {
        props.updateTitle('Register');
        props.history.push('/register'); 
    }
    return (
        <div className="Login-form">
        <h2>Login</h2>
        <form onSubmit={handleSubmitClick}>
        <div className="form-group">
                    <label htmlFor="email">Email : </label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                        title="Please enter a valid email address."
                    />
                </div>
  
          <div className="form-group">
            <label>Password : </label>
            <input
              type="password"
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
              minLength="6"
              title="Password should be at least 6 characters long."
            />
          </div>
  
          {/* <div className="form-group">
            <div>
              <input
                type="radio"
                id="user"
                name="role"
                value="user"
                checked={formData.role === 'user'}
                onChange={handleChange}
              />
              <label>User</label>
  
              <input
                type="radio"
                id="admin"
                name="role"
                value="admin"
                checked={formData.role === 'admin'}
                onChange={handleChange}
              />
              <label>Admin</label>
            </div>
          </div> */}
  
          <button type="submit">Login</button>
        </form>
        <p></p>
        <button type="register" onClick={redirectToRegister}>Register</button>
      </div>
    );
}

export default withRouter(Login);