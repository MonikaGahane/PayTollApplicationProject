import React, { useState } from "react";
import './Trip.css'
import axios from "axios";

function Trip(props) {
    const [status, setStatus] = useState('')
    const [formData, setFormData] = useState({
        vehicleNumb: '',
        payMode: '',
        boothID: ''
    });
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };
    const addTrip = async (e) => {
        e.preventDefault();
        const payload = {
            "vehicleNo": formData.vehicleNumb,
            "payMode": formData.payMode,
            "boothID": formData.boothID
        }

        const headers = {
            'Content-Type': 'application/json'
        };

        try {
            const response = await axios.post('http://localhost:8080/trip/add', payload,{headers});

            if(response.status === 200) {
                setStatus(`Amount paid is: ${response.data.fareAmount} and trip id : ${response.data.tripID}`)
            }
            console.log('Response:', response.data);
        } catch (error) {
            console.error('Error:', error);
            setStatus(`server issues: ${error}`)
        }

    }

    return (
        <div>
        <div className="trip-form">
            <h2 className="trip-h2">Add Trip</h2>
            <form onSubmit={addTrip}>
                <div className="form-group">
                    <label className="trip-label">Vehicle Number : </label>
                    <input
                        type="text"
                        id="vehicleNumb"
                        name="vehicleNumb"
                        value={formData.vehicleNumb}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label className="trip-label"> Payment Mode : </label>
                    <select name="payMode" 
                        onChange={handleChange}>
                        <option value="ONLINE">ONLINE</option>
                        <option value="CASH">CASH</option>
                    </select>
                </div>
                <div className="form-group">
                    <label className="trip-label">Booth ID : </label>
                    <input
                        type="text"
                        id="boothID"
                        name="boothID"
                        value={formData.boothID}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="Submit">Add Trip</button>
                
            </form>
            <br></br>
            <label className="trip-label">${status}</label>
        </div>
        <div></div>
        </div>
    )
}

export default Trip;