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
                            <Button text small outline rounded className={cx('only-text')}>
                                Buy now!
                            </Button>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    )
}

export default Home;