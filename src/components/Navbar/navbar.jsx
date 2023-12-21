import { Link } from 'react-router-dom';
import logo from '../../assets/logo.png'
import search from  '../../assets/search-icon.png';
import loginIcon from '../../assets/login-button.png';
import '../../styles/style.css';

export const Navbar = () => {
    return (
        <div className="navbar">
            <Link to='/'> <img src={logo} alt='' className='logo'/> </Link>
            <div className="search-box">
                <input type="text" placeholder='Buscar' />
                <img src={search} alt="" className='search-icon'/>
            </div>
            <Link to='/login'> <img src={loginIcon} alt="" className='login-button' /> </Link>
        </div>
    );

}

export default Navbar;