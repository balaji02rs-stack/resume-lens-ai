import axios from "axios";

const api = axios.create({
  baseURL: "https://resume-lens-backend-bxb8.onrender.com",
  headers: {
    "Content-Type": "application/json",
  },
});

export default api;