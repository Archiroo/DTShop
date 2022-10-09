import classNames from "classnames/bind";
import styles from './Navbar.module.scss';
import { } from '@fortawesome/free-regular-svg-icons';
import { faAngleDown } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


import Button from "../../../components/Button/Button";
import MoreDropdown from "../../../components/Popper/MoreDropdown/MoreDropdown";
const cx = classNames.bind(styles)

const PAGE_ITEMS = [
    {
        name: 'Vouchers',
        to: '/vouchers'
    },
    {
        name: 'Collection',
        to: '/collection'
    },
    {
        name: 'Contact',
        to: '/contact'
    },
    {
        name: 'Blog',
        to: '/blog'
    },
]

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
                <MoreDropdown pages={PAGE_ITEMS}>
                    <li className={cx('nav-text__item')}>

                        <button className={cx('nav-text__no-link')} >
                            More
                            <FontAwesomeIcon className={cx('arrow')} icon={faAngleDown} />
                        </button>
                    </li>
                </MoreDropdown>

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