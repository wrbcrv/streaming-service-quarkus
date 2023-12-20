import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './components/Home/index.jsx';
import Login from './components/Login/login.jsx';
import Navbar from './components/Navbar/navbar.jsx';

import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './styles/style.css';



ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
    <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />,
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
)
