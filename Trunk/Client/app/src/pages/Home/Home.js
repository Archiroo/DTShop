import classNames from "classnames/bind";
import styles from './Home.module.scss'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleRight, faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';

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
                    <div className={cx('delivery-unit')}>
                        <h2 className={cx('delivery-title')}>
                            Order from your favorite app today!
                        </h2>
                        <ul className={cx('delivery-list')}>
                            <li className={cx('delivery-item')}>
                                <a href="">
                                    <img src={images.ubereats} alt="Delivery Unit" />
                                </a>
                            </li>
                            <li className={cx('delivery-item')}>
                                <a href="">
                                    <img src={images.doordash} alt="Delivery Unit" />
                                </a>
                            </li>
                            <li className={cx('delivery-item')}>
                                <a href="">
                                    <img src={images.postmates} alt="Delivery Unit" />
                                </a>
                            </li>
                            <li className={cx('delivery-item')}>
                                <a href="">
                                    <img src={images.rappi} alt="Delivery Unit" />
                                </a>
                            </li>
                            <li className={cx('delivery-item')}>
                                <a href="">
                                    <img src={images.grubhub} alt="Delivery Unit" />
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div className={cx('line-footer-overview')}></div>
                </div>

                {/* Menu-categories */}
                <div className={cx('menu-categories')}>
                    <h1 className={cx('menu-categories__title')}>
                        Browse our menu
                    </h1>
                    <ul className={cx('menu-categories__list')}>
                        <li className={cx('menu-categories__item')}>
                            <Link>
                                <img src={images.breakfast} className={cx('categories-item__img')} alt="Categories" />
                                <h3 className={cx('categories-item__title')}>Breakfast</h3>
                                <p className={cx('categories-item__desc')}>
                                    Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam.
                                </p>
                                <span className={cx('explore-menu')}>
                                    Explore menu
                                    <FontAwesomeIcon className={cx('explore-menu__icon')} icon={faAngleRight} />
                                </span>
                            </Link>
                        </li>
                        <li className={cx('menu-categories__item')}>
                            <Link>
                                <img src={images.maindishes} className={cx('categories-item__img')} alt="Categories" />
                                <h3 className={cx('categories-item__title')}>Breakfast</h3>
                                <p className={cx('categories-item__desc')}>
                                    Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam.
                                </p>
                                <span className={cx('explore-menu')}>
                                    Explore menu
                                    <FontAwesomeIcon className={cx('explore-menu__icon')} icon={faAngleRight} />
                                </span>
                            </Link>
                        </li>
                        <li className={cx('menu-categories__item')}>
                            <Link>
                                <img src={images.drinks} className={cx('categories-item__img')} alt="Categories" />
                                <h3 className={cx('categories-item__title')}>Breakfast</h3>
                                <p className={cx('categories-item__desc')}>
                                    Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam.
                                </p>
                                <span className={cx('explore-menu')}>
                                    Explore menu
                                    <FontAwesomeIcon className={cx('explore-menu__icon')} icon={faAngleRight} />
                                </span>
                            </Link>
                        </li>
                        <li className={cx('menu-categories__item')}>
                            <Link>
                                <img src={images.desserts} className={cx('categories-item__img')} alt="Categories" />
                                <h3 className={cx('categories-item__title')}>Breakfast</h3>
                                <p className={cx('categories-item__desc')}>
                                    Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam.
                                </p>
                                <span className={cx('explore-menu')}>
                                    Explore menu
                                    <FontAwesomeIcon className={cx('explore-menu__icon')} icon={faAngleRight} />
                                </span>
                            </Link>
                        </li>
                    </ul>
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
        </div >
    )
}

export default Home;