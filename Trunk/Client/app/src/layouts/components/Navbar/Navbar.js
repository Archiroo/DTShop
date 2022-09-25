import classNames from "classnames/bind";
import styles from './Navbar.module.scss';
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { } from '@fortawesome/free-regular-svg-icons';
import Button from "../../../components/Button/Button";
const cx = classNames.bind(styles)

function Navbar() {
    return (
        <nav >
            <ul className={cx('navbar')}>
                <li className={cx('navbar-item')}>
                    <Button to='/' className={cx('navbar-link', {
                        'text': true
                    })}>
                        Home
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button to='/drink-menu' className={cx('navbar-link', {
                        'text': true
                    })}>
                        Menu
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button to='/collection' className={cx('navbar-link', {
                        'text': true
                    })}>
                        Collection
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button to='/about-us' className={cx('navbar-link', {
                        'text': true
                    })}>
                        About Us
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button to='/blog' className={cx('navbar-link', {
                        'text': true
                    })}>
                        Blog
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button to='/cart' className={cx('navbar-link', {
                        'cart': true
                    })}>
                        <FontAwesomeIcon icon={faCartShopping} />
                    </Button>
                </li>
                <li className={cx('navbar-item')}>
                    <Button rounded outline to='/vouchers' className={cx('navbar-link', {
                        'gift-vouchers': true
                    })} >
                        BUY GIFT VOUCHERS
                    </Button>
                </li>
            </ul>
        </nav>
    );
}

export default Navbar;