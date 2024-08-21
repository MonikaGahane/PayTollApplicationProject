import React, { useState } from "react";
import axios from "axios";
import './Wallet.css'

function Wallet(props) {
    const wallet_balance = 0;
    const [formData, setFormData] = useState({
        amount: ''
        
    });
    const [status, setStatus] = useState('')
    const [retriveBalanceStatus, setRetriveBalanceStatus] = useState('')
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };
    const rechargeWallet = async (e) => {
        e.preventDefault();
        const userId = localStorage.userId;
        const apiUrl = `http://localhost:8080/wallet/recharge/${userId}`;
        const balance_amount = formData.amount;
        try {
            const response = await axios.put(apiUrl, {balance_amount}, {
                params: {
                    balance_amount: parseFloat(balance_amount)
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if(response.status == 200 && response.data.walletID != null)
                setStatus(`Balance Updated successfully! Updated Balance is : ${response.data.balanceAmount}`);
        } catch (error) {
            setStatus(`Updating failed. Error: ${error.message}`);
        }
    }
    const retriveWallet = async (e) => {
        e.preventDefault();
        const userId = localStorage.userId;
        const apiUrl = `http://localhost:8080/wallet/retrieveBalance/${userId}`;
        try {
            const response = await axios.get(apiUrl, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if(response.status == 200 && response.data.walletID != null)
                setRetriveBalanceStatus(`Balance is : ${response.data.balanceAmount}`);
        } catch (error) {
            setRetriveBalanceStatus(`failed. Error: ${error.message}`);
        }
    }

    return (
      <div> 
            <div className="wallet-form">
                <h2 className="wallet-h2"><u>Recharge Wallet</u></h2>
                <form onSubmit={rechargeWallet}>
                   <label className="wallet-label"><u>Amount : </u></label>
                        <input
                            type="number"
                            id="amount"
                            name="amount"
                            value={formData.amount}
                            onChange={handleChange}
                            required

                        />
                    <button type="Submit" name="amount">Recharge</button>
                </form>
                <label className="wallet-label">{status}</label>
            </div>
          
            
            <div className="wallet-form">
                <h2 className="wallet-h2"><u>Retrive Wallet Balance</u></h2>
                <form onSubmit={retriveWallet}>
                   <label className="wallet-label"><u>Amount : </u></label>
                    <button type="Submit" name="amount">Balance</button>
                    <label className="wallet-label"><u>Amount Balance: </u> {wallet_balance}</label> 
                </form>
                <label className="wallet-label">{retriveBalanceStatus}</label>
            </div>
            
            
        </div>
          
    )
}

export default Wallet;