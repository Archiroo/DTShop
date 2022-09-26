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
        <nav className={cx('navbar')}>
            <ul className={cx('nav-text')}>
                <li className={cx('nav-text__item')}>
                    <Button className={cx('nav-text__link')} to='/'>
                        Home
                    </Button>
                </li>
                <li className={cx('nav-text__item')}>
                    <Button className={cx('nav-text__link')} to='/about'>
                        About
                    </Button>
                </li>
                <li className={cx('nav-text__item')}>
                    <Button className={cx('nav-text__link')} to='/menu'>
                        Menu
                    </Button>
                </li>
                <li className={cx('nav-text__item')}>
                    <Button className={cx('nav-text__link')} to='/delivery'>
                        Delivery
                    </Button>
                </li>
                <li className={cx('nav-text__item')}>
                    <Button className={cx('nav-text__link')} to='#'>
                        More
                    </Button>
                </li>
            </ul>
            <ul className={cx('nav-button')}>
                <Button className={cx('nav-button__link')} to='/' rounded outline>
                    Order online
                </Button>
                <Button className={cx('nav-button__link')} to='/' rounded primary>
                    Reservate
                </Button>
            </ul>
        </nav>
    );
}

export default Navbar;