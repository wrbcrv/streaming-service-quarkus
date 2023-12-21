import { Link } from 'react-router-dom';
import logo from '../../assets/logo.png'
import search from  '../../assets/search-icon.png';
import navbarLogin from './navbarLogin.module.css'

export const NavbarLogin = () => {
    return (
        <div className={navbarLogin.navbar}>
            <Link to='/'> <img src={logo} alt='' className={navbarLogin.logo}/> </Link>
            <div className={navbarLogin.searchBox}>
                <input type="text" placeholder='Buscar' />
                <img src={search} alt="" className={navbarLogin.searchIcon}/>
            </div>
        </div>
    );

}

export default NavbarLogin;