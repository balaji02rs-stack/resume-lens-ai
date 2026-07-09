import api from "../api/axios";

export const login = async (credentials) => {
  const response = await api.post("/api/auth/login", credentials);
  return response.data;
};

export const register = async (user) => {
  const response = await api.post("/api/auth/register", user);
  return response.data;
};