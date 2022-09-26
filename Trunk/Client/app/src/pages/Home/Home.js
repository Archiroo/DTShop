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
                    <div className={cx('bg-overview')}>
                        <div className={cx('bg-ov-left')}></div>
                        <div className={cx('bg-ov-right')}></div>
                    </div>
                    <div className={cx('inner')}>
                        <div className={cx('ov-content')}>
                            <h1 className={cx('title')}>
                                The best place to eat <span className={cx('title-highlight')}>burgers in LA</span>.
                            </h1>
                            <span className={cx('sub-title')}>
                                Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam vitae velit bibendum elementum eget non vivamus volutpat odio cras vestibulum purus aliquam.
                            </span>

                            <div className={cx('ov-button')}>
                                <Button className={cx('ov-reservateBtn')} rounded primary>Reservate</Button>
                                <Button className={cx('ov-orderBtn')} rounded outline>Order online</Button>
                            </div>
                        </div>
                        <img className={cx('ov-img')} src={images.overviewImg} alt="AG - Restaurant" />
                    </div>
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