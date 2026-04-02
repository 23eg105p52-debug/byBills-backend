import React, { useState, useEffect } from "react";
import axios from "axios";

function BillManager() {

  const [bills, setBills] = useState([]);
  const [billName, setBillName] = useState("");
  const [amount, setAmount] = useState("");
  const [dueDate, setDueDate] = useState("");

  useEffect(() => {
    fetchBills();
  }, []);

  const fetchBills = () => {
    axios.get("http://localhost:8080/api/bills")
      .then(res => setBills(res.data));
  };

  const addBill = () => {
    axios.post("http://localhost:8080/api/bills", {
      billName,
      amount,
      dueDate
    }).then(() => {
      fetchBills();
    });
  };

  const deleteBill = (id) => {
    axios.delete(`http://localhost:8080/api/bills/${id}`)
      .then(() => fetchBills());
  };

  return (
    <div>

      <h2>Upcoming Bills</h2>

      <input
        placeholder="Bill Name"
        onChange={(e)=>setBillName(e.target.value)}
      />

      <input
        placeholder="Amount"
        type="number"
        onChange={(e)=>setAmount(e.target.value)}
      />

      <input
        type="date"
        onChange={(e)=>setDueDate(e.target.value)}
      />

      <button onClick={addBill}>Add Bill</button>

      <ul>
        {bills.map(bill => (
          <li key={bill.id}>
            {bill.billName} - ₹{bill.amount} - {bill.dueDate}
            <button onClick={()=>deleteBill(bill.id)}>Delete</button>
          </li>
        ))}
      </ul>

    </div>
  );
}

export default BillManager;