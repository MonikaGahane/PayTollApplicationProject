import React, {  useState } from "react";

import './Home.css'
import Trip from "../Trip/Trip";
import SearchTrip from "../Trip/SearchTrip";
import Vehicle from "../Vehicle/Vehicle";
import TollCollection from "../TollCollection/TollCollection";
import Wallet from "../Wallet/Wallet";

function Home(props) {
  
    const [activeTab, setActiveTab] = useState('Home');

  const handleTabClick = (tab) => {
    setActiveTab(tab);
    switch(tab) {
        case 'Home' : { console.log(`Selected ${tab}`); return;}
        case 'Trips' : { console.log(`Selected ${tab}`); return;}
        case 'Vehicles' : { console.log(`Selected ${tab}`); return;}
        case 'Collections' : { console.log(`Selected ${tab}`); return;}
    }
    // Perform any additional actions when a tab is selected
    // console.log(`Selected ${tab}`);
  };



    return (
        <div>
            { localStorage.isAdmin ==='Y' && <div>
                <ul className="tab-list">
                    <li className={activeTab === 'Home' ? 'active' : ''} onClick={() => handleTabClick('Home')}>Home</li> 
                    <li className={activeTab === 'Trips' ? 'active' : ''} onClick={() => handleTabClick('Trips')}>Search Trips</li>
                    <li className={activeTab === 'Vehicles' ? 'active' : ''} onClick={() => handleTabClick('Vehicles')}>Add Vehicles</li>
                    <li className={activeTab === 'Collections' ? 'active' : ''} onClick={() => handleTabClick('Collections')}>Toll Collection</li>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    {localStorage.email && <div> Email : {localStorage.email}</div>}
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    {localStorage.userId && <div> User ID : {localStorage.userId}</div>}
                   
                </ul>
                <div className="content">
                    {activeTab === 'Home' && <div><Trip/></div>}
                    {activeTab === 'Trips' && <div><SearchTrip/></div>}
                    {activeTab === 'Vehicles' && <div><Vehicle/></div>}
                    {activeTab === 'Collections' && <div><TollCollection/></div>}
                    

                </div>
                </div>
            } 

            { 
            localStorage.isAdmin ==='N' && <div>
                <ul className="tab-list">
                   
                    <li className={activeTab === 'Wallet' ? 'active' : ''} onClick={() => handleTabClick('Wallet')}>Wallet</li>
                    
                    {/* <li className={activeTab === 'Collections' ? 'active' : ''} onClick={() => handleTabClick('Collections')}>Toll Collection</li> */}
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <p>   Email :   {localStorage.email}</p>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <p> User ID : {localStorage.userId}</p>
                </ul>
                <div className="content">
                   
                    {activeTab === 'Wallet' && <div><Wallet/></div>}
                  
                    {/* {activeTab === 'Collections' && <div><TollCollection/></div>} */}
                    
                </div>
                </div>
            }
                    
                    
        </div>
    )
}

export default Home;