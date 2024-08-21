import React, { useEffect, useState } from "react";
import './Trip.css'
import axios from "axios";

function SearchTrip(props) {
    const [trips, setTrips] = useState([])
    const [status, setStatus] = useState()
    const [formData, setFormData] = useState({
        searchVehicleNumber: '',
        fromDate: '',
        toDate: ''

    });
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };
   

    const searchTrips = async (e) => {
            e.preventDefault();
            const userId = localStorage.userId;
            const apiUrl = `http://localhost:8080/trip/trips`;
            try {
                const response = await axios.get(apiUrl, {
                    params : {
                        'vehicleNumber': formData.searchVehicleNumber,
                        'fromDate': formData.fromDate,
                        'toDate': formData.toDate
                    }
                },{
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                
                if(response.status == 200)
                    setTrips(response.data);
                

            } catch (error) {
                console.log(`failed. Error: ${error.message}`);
            }
        
        }; 
    
    return (
      <div> 
            <div className="search-form">
                
                <h2 className="searchTrip-h2"><u>Search Trips</u></h2>

                <form onSubmit={searchTrips}>
                   
                   
                        <label className="search-label"><u>Vehicle Number :</u> </label>  
                        <input
                            type="text"
                            id="searchVehicleNumber"
                            name="searchVehicleNumber"
                            value={formData.searchVehicleNumber}
                            onChange={handleChange}
                        />
                        
                        
                        <label className="search-label"><u>From Date* : </u></label>
                        <input
                            type="date"
                            id="fromDate"
                            name="fromDate"
                            value={formData.fromDate}
                            onChange={handleChange}
                            required

                        />
                         <label className="search-label"><u>To Date* : </u></label>
                        <input
                            type="date"
                            id="toDate"
                            name="toDate"
                            value={formData.toDate}
                            onChange={handleChange}
                            required

                        />
                        <p></p>
                   
                    <button type="Submit" name="searchButton">Search</button>
                </form>
                
                
            </div>
            {trips && <div>
            <table className="user-table">
                <thead>
                    <tr>
                        <th>Trip ID</th>
                        <th>Vehicle Number</th>
                        <th>Payment mode</th>
                        <th>Fare amount</th>
                    </tr>
                </thead>
                <tbody>
                {trips.map(trip => (
                        <tr>
                            <td>{trip.tripID} </td>
                            <td>{trip.vehicleNo}</td>
                            <td>{trip.payMode}</td>
                            <td>{trip.fareAmount}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            </div>
            }
        </div>
          
    )
}

export default SearchTrip;