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
                <div className={cx('banner')}>
                    <img className={cx('banner-img')} src={images.banner} alt="DTShop" />
                    <div className={cx('content')}>
                        <img className={cx('icon-banner')} src={images.iconBanner} alt="Coffee" />
                        <h1 className={cx('slogan')}>
                            Start your day with a black Coffee
                        </h1>
                        <p className={cx('sub-slogan')}>
                            Coffee here is passion and lifestyle...
                        </p>
                        <div className={cx('action')}>
                            <Button outline rounded className={cx('download-app')}>
                                DOWNLOAD APP
                            </Button>
                            <Button text outline rounded className={cx('only-text')}>
                                BUY NOW!
                            </Button>
                        </div>
                    </div>
                </div>


                {/* About us */}
                <div className={cx('about-us')}>
                    <div className={cx('bg-large-text')}>ABOUT</div>
                    <div className={cx('content-wrapper')}>
                        <div className={cx('img')}>
                            <img className={cx('img-aboutUs')} src={images.imgAboutUs} alt="About Us" />
                        </div>
                        <div className={cx('content-aboutUs')}>
                            <span className={cx('tagName-aboutUs')}>
                                ABOUT US
                            </span>
                            <h2 className={cx('title')}>
                                Premium drinks from esteemed bartender Archiro & Gentle.
                            </h2>
                            <span className={cx('sub-title')}>
                                Bartender Spirits Award Winner 2022 &  Vietnam Cocktail Festival's Bar Awards
                            </span>
                            <p className={cx('description')}>
                                The company was established in 2022 with two members, Archiro and Gentle. Up to now, the DTShop brand has received a lot of love from coffee lovers in Vietnam and around the world. Referring to DTShop is enthusiasm, seniority and always learning.
                            </p>
                            <div className={cx('bartender')}>
                                <div className={cx('bart-info')}>
                                    <img className={cx('bart-sign')} src={images.arcSign} alt='Archiro' />
                                    <span className={cx('bart-name')}>Archiro</span>
                                </div>
                                <div className={cx('bart-info')}>
                                    <img className={cx('bart-sign')} src={images.gentSign} alt='Gentle' />
                                    <span className={cx('bart-name')}>Gentle</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Home;