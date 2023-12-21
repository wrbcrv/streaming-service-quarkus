import React from 'react';
import { FaUser } from "react-icons/fa";
import { FaLock } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import registerStyle from './register.module.css';
import { Link } from 'react-router-dom';

export default function Register() {
  return (
    <div className={registerStyle.backgroundContainer}>
        <div className={registerStyle.wrapper}>
            <form action="">
                <h1>Cadastro</h1>
                <div className={registerStyle.inputBox}>
                    <input type="text" placeholder='Usuario' required />
                    <FaUser className={registerStyle.icon}/>
                </div>
                <div className={registerStyle.inputBox}>
                    <input type="password" placeholder='Senha' required />
                    <FaLock className={registerStyle.icon}/>
                </div>
                <div className={registerStyle.inputBox}>
                    <input type="password" placeholder='Confirmar Senha' required />
                    <FaLock className={registerStyle.icon}/>
                </div>
                <div className={registerStyle.inputBox}>
                    <input type="email" placeholder='Email' required/>
                    <MdEmail className={registerStyle.icon}/>
                </div>
                <button type="submit">Realizar Cadastro</button>
                <div className={registerStyle.loginLink}>
                    <p>Já possui uma conta? <Link to='/login'> <a> Faça login </a> </Link></p>
                </div>
            </form>
        </div>

    </div>
  )
}