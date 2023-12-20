import { Link } from 'react-router-dom';
import '../../styles/style.css';

export const Navbar = () => {
    return (
        <nav class="navbar">
            <div class="container">
                <Link to="/" class="logo">TBEYOFlix</Link>
                <ul class="nav-links">
                    <li><span id='search'>Search</span></li>
                    <li><Link to="/">User</Link></li>
                </ul>
            </div>
        </nav>
    );

}

export default Navbar;