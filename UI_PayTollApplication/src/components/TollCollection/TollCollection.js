import React, { useState } from "react";
import './TollCollection.css'
import axios from "axios";

function TollCollection(props) {
    const[amount,setAmount] = useState('')
    const [formData, setFormData] = useState({
        fromDate: '',
        toDate: ''

    });
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };
    const getCollection = async (e) => {
        e.preventDefault();
        const payload = {
            "fromDate": formData.fromDate,
            "toDate": formData.toDate
        }

        const apiUrl = `http://localhost:8080/tollbooth/collection`;
            try {
                const response = await axios.get(apiUrl, {
                    params : {
                       
                        'fromDate': formData.fromDate,
                        'toDate': formData.toDate
                    }
                },{
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                
                if(response.status == 200)
                    setAmount(response.data);
                

            } catch (error) {
                console.log(`failed. Error: ${error.message}`);
            }
    }

    return (
      <div> 
            <div className="collection-form">
                
                <h2 className="collection-h2"><u>Get Collection</u></h2>

                <form onSubmit={getCollection}>
                   <label className="collection-label"><u>From Date : </u></label>
                        <input
                            type="date"
                            id="fromDate"
                            name="fromDate"
                            value={formData.fromDate}
                            onChange={handleChange}
                            required

                        />
                         <label className="collection-label"><u>To Date : </u></label>
                        <input
                            type="date"
                            id="toDate"
                            name="toDate"
                            value={formData.toDate}
                            onChange={handleChange}
                            required

                        />
                        <p></p>
                   
                    <button type="Submit" name="collection">Submit</button>
                </form>
                
                
            </div>
            <div>
            <label className="collection-label"><u>Amount : {amount}</u></label>
            </div>
        </div>
          
    )
}

export default TollCollection;