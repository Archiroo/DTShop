import classNames from "classnames/bind";
import styles from './Home.module.scss'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCartShopping } from '@fortawesome/free-solid-svg-icons';

import Button from '~/components/Button'
import images from "~/assets/images";
const cx = classNames.bind(styles)

function Home() {
    return (
        <div className={cx('wrapper')}>
            <div className={cx('container')}>

                {/* Banner */}
                <div className={cx('overview')}>

                </div>

                {/* Menu-categories */}
                <div className={cx('menu-categories')}>
                    menu-categories
                </div>

                {/* About us */}
                <div className={cx('about-us')}>
                    about-us
                </div>

                {/* Menu-products */}
                <div className={cx('menu-products')}>
                    menu-products
                </div>

                {/* Order */}
                <div className={cx('orders')}>
                    orders
                </div>

                {/* feedback */}
                <div className={cx('feedback')}>
                    feedback
                </div>

                {/* articles */}
                <div className={cx('articles')}>
                    articles
                </div>

                {/* booking */}
                <div className={cx('booking')}>
                    booking
                </div>

                {/* socials */}
                <div className={cx('socials')}>
                    socials
                </div>

                {/* footer */}
                <div className={cx('footer')}>
                    footer
                </div>
            </div>
        </div>
    )
}

export default Home;