import classNames from "classnames/bind";
import styles from './Home.module.scss'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleRight, faCartShopping, faEnvelope, faLocationPin, faPhone } from '@fortawesome/free-solid-svg-icons';
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
                                <Button className={cx('btn-scale')} rounded primary>Reservate</Button>
                                <Button className={cx('btn-scale')} rounded outline>Order online</Button>
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
                    <div className={cx('menu-categories__btn')}>
                        <Button className={cx('btn-scale')} rounded primary>Reservate</Button>
                        <Button className={cx('btn-scale')} rounded outline>Order online</Button>
                    </div>
                </div>

                {/* About us */}
                <div className={cx('about-us')}>
                    <div className={cx('about-us__bg')}>
                    </div>
                    <div className={cx('about-inner')}>
                        <div className={cx('about-us__img')}>
                            <img className={cx('about-img')} src={images.aboutusImg} alt="About Us" />
                            <div className={cx('about-img__contact')}>
                                <h3 className={cx('about-contact__title')}>Come and visit us</h3>
                                <div className={cx('about-contact__addr')}>
                                    <FontAwesomeIcon icon={faLocationPin} />
                                    <p className={cx('about-addr')}>
                                        175, Tay Son, Dong Da, Ha Noi.
                                    </p>
                                </div>
                                <a href="tel:0399859634" className={cx('about-contact__phone')}>
                                    <FontAwesomeIcon icon={faPhone} />
                                    <p className={cx('about-phone')}>0399 859 634</p>
                                </a>
                                <a href="mailto:tannv.3201@gmail.com" className={cx('about-contact__mail')}>
                                    <FontAwesomeIcon icon={faEnvelope} />
                                    <p className={cx('about-mail')}>tannv.3201@gmail.com</p>
                                </a>
                            </div>
                        </div>
                        <div className={cx('about-us__content')}>
                            <h2 className={cx('about-content__title')}>About us</h2>
                            <p className={cx('about-content__desc')}>
                                Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam vitae velit bibendum elementum eget non vivamus volutpat odio cras vestibulum purus aliquam.
                                <br /><br />
                                Lorem ipsum dolor sit amet consectetur adipiscing elit enim bibendum sed et aliquet aliquet risus tempor semper odio egestas id pulvinar consectetur elit tortor non hac pellentesque lacus donec accumsan quisque ultricies adipiscing mauris tortor cras est eu accumsan mauris.
                            </p>
                            <div className={cx('about-content__btn')}>
                                <Button className={cx('btn-scale')} rounded primary>About</Button>
                                <Button className={cx('btn-scale')} rounded outline>Join our team</Button>
                            </div>
                        </div>
                    </div>

                </div>

                {/* Menu-products */}
                <div className={cx('menu-products')}>
                    <h2 className={cx('menu-prod__title')}>Browse our menu</h2>
                    <p className={cx('menu-prod__subtitle')}>
                        Lorem ipsum dolor sit amet consectetur adipiscing elit ugue quam diam vitae velit bibendum elementum.
                    </p>
                    <ul className={cx('menu-prod__list')}>
                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.classicburger} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 10.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Classic Burger</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.chocolatemilkshake} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 6.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Chocolate Milkshake</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.classicfries} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 5.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Classic Fries</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.pancakes} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 8.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Pancakes</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.icecream} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 10.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Classic Burger</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.chickenburger} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 6.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Chocolate Milkshake</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.eggtoast} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 5.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Classic Fries</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>

                        <li className={cx('menu-prod__item')}>
                            <a href="#" className={cx('menu-prod__item-link')}>
                                <div className={cx('prod-img__wrapper')}>
                                    <img className={cx('menu-prod__item-img')} src={images.regularsoda} alt="Classic Burger" />
                                </div>
                                <span className={cx('menu-prod__item-price')}>
                                    $ 8.99 USD
                                </span>
                                <div className={cx('prod-item_desc')}>
                                    <p className={cx('menu-prod__item-name')}>Pancakes</p>
                                    <p className={cx('menu-prod__item-desc')}>
                                        Lorem ipsum dolor sit amet dolor consectetur adipiscing elit
                                    </p>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <div className={cx('menu-prod__btn')}>
                        <Button className={cx('btn-scale')} rounded primary>Order online</Button>
                        <Button className={cx('btn-scale')} rounded outline>Book a table</Button>
                    </div>
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