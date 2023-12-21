import loginstyle from './login.module.css';
import { FaUser } from "react-icons/fa";
import { FaLock } from "react-icons/fa";
import { Link } from 'react-router-dom';

export const Login = () => {
    return (
    
    <div className={loginstyle.backgroundContainer}>
        <div className={loginstyle.wrapper}>
            <form action="">
                <h1>Login</h1>
                <div className={loginstyle.inputBox}>
                    <input type="text" placeholder='Usuario' required />
                    <FaUser className={loginstyle.icon}/>
                </div>
                <div className={loginstyle.inputBox}>
                    <input type="password" placeholder='Senha' required />
                    <FaLock className={loginstyle.icon}/>
                </div>
                <div className={loginstyle.rememberForgot}>
                    <label><input type="checkbox" />Lembre de mim</label>
                    <a href="#">Esqueceu senha?</a>
                </div>
                <button type="submit">Login</button>
                <div className={loginstyle.registerLink}>
                    <p>Não possui uma conta? <Link to='/register'> <a>Registre-se</a> </Link> </p>
                </div>
            </form>
        </div>
    </div>
    );

}

export default Login;