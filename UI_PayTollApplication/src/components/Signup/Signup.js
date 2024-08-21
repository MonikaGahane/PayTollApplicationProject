import React, { useState } from 'react';
import { useHistory } from "react-router-dom";
import axios from 'axios';
import './Signup.css'


function Signup(props) {
    let history = useHistory();
    const [formData, setFormData] = useState({
        userName: '',
        email: '',
        password: '',
        phoneNo:''
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const registerUser = async (e) => {
        e.preventDefault();
        
        const dataToSend = { formData };
        formData.password = btoa(formData.password);
        
        const url = process.env.REACT_APP_PAYTOLL_APP_URL;

        const headers = {
            'Content-Type': 'application/json'
        };

        try {
            //const response = await axios.post('http://localhost:8080/auth/register', formData,{headers});
            const response = await axios.post('http://localhost:8080/auth/register', formData,{headers});

            console.log('Response:', response.data);
        } catch (error) {
            console.error('Error:', error);
        }

        // useEffect(() => {
        //     axios.post('${PAYTOLL_APP_URL}/auth/register')
        //         .then(response => {
        //             setData(response.data);
        //             setLoading(false);
        //         })
        //         .catch(error => console.error('Error fetching data: ', error));
        // }, []); 
       regirectToLogin();
    };

    const regirectToLogin = () => {
        props.updateTitle('Login');
        history.push('/login'); 
    }

    return (
        <div className="signup-form">
            <h2>Sign Up</h2>
            <form onSubmit={registerUser}>
                <div className="form-group">
                    <label htmlFor="userName">Username : </label>
                    <input
                        type="text"
                        id="userName"
                        name="userName"
                        value={formData.userName}
                        onChange={handleChange}
                        required
                        minLength="4"
                        title="Username should be at least 4 characters long."
                    />
                </div>

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
                    <label htmlFor="password">Password:</label>
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
                <div className="form-group">
                    <label htmlFor="phoneNo">Phone:</label>
                    <input
                        type="phoneNo"
                        id="phoneNo"
                        name="phoneNo"
                        value={formData.phoneNo}
                        onChange={handleChange}
                        required
                        title="Phone number is required"
                    />
                </div>

                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}

export default Signup;