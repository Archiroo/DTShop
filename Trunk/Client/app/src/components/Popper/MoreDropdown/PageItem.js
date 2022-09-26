import classNames from "classnames/bind";

import Button from "~/components/Button";
import styles from './Page.module.scss';

const cx = classNames.bind(styles)

function PageItem({ data, onClick }) {
    console.log(data);

    const classes = cx('menu-item', {
        separate: data.separate
    });

    return (
        <div>
            <Button
                className={classes}
                leftIcon={data.icon}
                to={data.to}
                onClick={onClick}
            >
                {data.name}
            </Button>
        </div>
    );
}

export default PageItem;