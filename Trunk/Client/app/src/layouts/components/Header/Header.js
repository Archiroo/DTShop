import classNames from 'classnames/bind';
import { Outlet, Link } from 'react-router-dom'

import { publicRoutes } from '~/routes'
import images from '~/assets/images'
import styles from './Header.module.scss'
import Navbar from '../Navbar';
const cx = classNames.bind(styles)

function Header() {
    return (
        <div className={cx('wrapper')}>
            <div className={cx('inner')}>
                <img className={cx('logo')} src={images.logo} alt="Logo" />
                <Navbar />
            </div>
        </div>
    );
}

export default Header;