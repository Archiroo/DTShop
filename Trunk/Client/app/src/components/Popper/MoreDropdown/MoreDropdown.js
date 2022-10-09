import Tippy from "@tippyjs/react/headless";
import PageItem from "./PageItem";
import classNames from "classnames/bind";

import { Wrapper as PopperWrapper } from '~/components/Popper'
import styles from './Page.module.scss';

const defaultFn = () => { }

const cx = classNames.bind(styles);

function MoreDropdown({ children, pages = [], hideOnClick = false, onChange = defaultFn, }) {

    const renderPages = () => {
        return pages.map((page, index) => {
            return <PageItem data={page} key={index} onClick={onChange(page)} />
        })
    }

    const renderMore = (attrs) => (
        <div className={cx('menu-list')} tabIndex="-1" {...attrs} >
            <PopperWrapper className={cx('menu-popper')}>
                <div className={cx('menu-body')}>{renderPages()}</div>
            </PopperWrapper>
        </div>
    )

    return (
        <Tippy
            interactive
            delay={[0, 200]}
            offset={[160, 8]}
            hideOnClick={hideOnClick}
            placement='bottom-end'
            render={renderMore}
        >
            {children}
        </Tippy>
    );
}

export default MoreDropdown;