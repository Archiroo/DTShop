import classNames from 'classnames/bind';
import { Link } from 'react-router-dom'

import images from '~/assets/images'
import styles from './Header.module.scss'
import Navbar from '../Navbar';

const cx = classNames.bind(styles)
function Header() {

    return (
        <div className={cx('wrapper')}>
            <div className={cx('inner')}>
                <Link className={cx('logo-link')} to="/">
                    <img className={cx('logo')} src={images.logoHeader.default} alt="Logo" />
                    <p className={cx('logo-name')}>
                        AG - Restaurant
                    </p>
                </Link>
                <Navbar />
            </div>
        </div>
    );
}

export default Header;