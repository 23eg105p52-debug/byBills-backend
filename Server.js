// server.js
const express = require("express");
const cors = require("cors");
const app = express();

// =========================
// 1️⃣ Middleware
// =========================

// Parse JSON request bodies
app.use(express.json());

// Enable CORS for your frontend
app.use(cors({
  origin: "https://bybills-frontend-4.onrender.com", // <- replace with your frontend URL
  methods: ["GET", "POST", "PUT", "DELETE"],
  credentials: true
}));

// =========================
// 2️⃣ In-memory bills storage
// =========================
let bills = [];
let nextId = 1;

// =========================
// 3️⃣ Routes
// =========================

// Get all bills
app.get("/api/bills", (req, res) => {
  res.json(bills);
});

// Add a new bill
app.post("/api/bills", (req, res) => {
  const { billName, amount, dueDate } = req.body;

  // Validate input
  if (!billName || !amount || !dueDate) {
    return res.status(400).json({ error: "Missing required fields" });
  }

  const newBill = {
    id: nextId++,
    billName,
    amount,
    dueDate
  };

  bills.push(newBill);

  res.status(201).json(newBill);
});

// =========================
// 4️⃣ Start server
// =========================
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`BYBills backend running on port ${PORT}`);
});
