import React, { useState } from "react";
import './Vehicle.css'
import axios from "axios";

function Vehicle(props) {
    const [status, setStatus] = useState('')
    const [formData, setFormData] = useState({
        vehicleNum: '',
        userId: '',
        vehicleType:''
    });
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };
    const assignVehicle = async (e) => {
        e.preventDefault();
        const payload = {
            "vehicleNumber": formData.vehicleNum,
            "userID": formData.userId,
            "vehicleType":formData.vehicleType
        }

        const headers = {
            'Content-Type': 'application/json'
        };

        try {
            const response = await axios.post('http://localhost:8080/vehicle/add', payload,{headers});
            if(response.status == 200) 
               setStatus("Vehicle assigned successfully!");
        } catch (error) {
            console.error('Error:', error);
        }

    }

    return (
        <div>
        <div className="vehicle-form">
            <h2 className="vehicle-h2"><u>Assign vehicle For a User</u></h2>
            <form onSubmit={assignVehicle}>
                <div className="form-group">
                    <label className="vehicle-label">Vehicle Number : </label>
                    <input
                        type="text"
                        id="vehicleNum"
                        name="vehicleNum"
                        value={formData.vehicleNum}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label className="vehicle-label"> User ID : </label>
                    <input
                        type="text"
                        id="userId"
                        name="userId"
                        value={formData.userId}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label className="vehicle-label" htmlFor="vehicleType"> Vehicle Type : </label>
                    <select name="vehicleType" id= "vehicleType" 
                        onChange={handleChange}>
                        <option value = "CAR" default>CAR</option>
                        <option value = "TRUCK">TRUCK</option>
                        <option value = "BUS">BUS</option>
                        <option value = "HEAVY_VEHICLE">HEAVY VEHICLE</option>
                    </select>
                
                </div>
                <button type="Submit">Assign Vehicle</button>
            </form>
            <label className="vehicle-label"> {status} </label>
        </div>
        <div></div>
        </div>
    )
}

export default Vehicle;