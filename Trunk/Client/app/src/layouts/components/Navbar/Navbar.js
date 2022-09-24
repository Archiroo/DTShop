import classNames from "classnames/bind";
import styles from './Navbar.module.scss';
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { } from '@fortawesome/free-regular-svg-icons';
const cx = classNames.bind(styles)

function Navbar() {
    return (
        <nav >
            <ul className={cx('navbar')}>
                <li className={cx('navbar-item')}>
                    <Link to='/' className={cx('navbar-link')}>
                        Home
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/drink-menu' className={cx('navbar-link')}>
                        Menu
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/collection' className={cx('navbar-link')}>
                        Collection
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/about-us' className={cx('navbar-link')}>
                        About Us
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/blog' className={cx('navbar-link')}>
                        Blog
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/cart' className={cx('navbar-link', {
                        'cart': true
                    })}>
                        <FontAwesomeIcon icon={faCartShopping} />
                    </Link>
                </li>
                <li className={cx('navbar-item')}>
                    <Link to='/vouchers' className={cx('navbar-link', {
                        'gift-vouchers': true
                    })}>
                        BUY GIFT VOUCHERS
                    </Link>
                </li>
            </ul>
        </nav>
    );
}

export default Navbar;