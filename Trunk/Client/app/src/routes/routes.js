import config from '~/config';

import Home from '~/pages/Home';
import Product from '~/pages/Product';
import Menu from '~/pages/Menu';
import About from '~/pages/About';
import Blog from '~/pages/Blog';
import Collection from '~/pages/Collection';
import Cart from '../pages/Cart';
import Vouchers from '../pages/Vouchers';
import Delivery from '../pages/Delivery';
import Contact from '../pages/Contact';

// Publics routes
const publicRoutes = [
    {
        path: config.routes.home,
        component: Home,
        // layout: null  (không có layout)
    },
    {
        path: config.routes.products,
        component: Product,
    },
    {
        path: config.routes.menu,
        component: Menu,
    },
    {
        path: config.routes.about,
        component: About,
    },
    {
        path: config.routes.blog,
        component: Blog,
    },
    {
        path: config.routes.collection,
        component: Collection,
    },
    {
        path: config.routes.cart,
        component: Cart,
    },
    {
        path: config.routes.vouchers,
        component: Vouchers,
    },
    {
        path: config.routes.delivery,
        component: Delivery,
    },
    {
        path: config.routes.contact,
        component: Contact,
    },
];

// private routes
const privateRoutes = [];

export { publicRoutes, privateRoutes };