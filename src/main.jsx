import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './components/Home/index.jsx';
import Login from './components/Login/login.jsx';
import Navbar from './components/Navbar/navbar.jsx';
import NavbarLogin from './components/NavbarLogin/navbarLogin.jsx';
import Register from './components/Register/register.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './styles/style.css';



const App = () => {
  return (
    <React.StrictMode>
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <>
                <Navbar />
                <Home />
              </>
            }
          />
          <Route path="/login" element={
          <>
          <NavbarLogin />
          <Login /> 
          </>
          }
          />
          <Route path="/register" element={
          <>
          <Navbar />
          <Register /> 
          </>
          }
          />
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
};

ReactDOM.createRoot(document.getElementById('root')).render(<App />);