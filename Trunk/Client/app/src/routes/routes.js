import config from '~/config';

import Home from '~/pages/Home';
import Product from '~/pages/Product';
import DrinkMenu from '~/pages/DrinkMenu';
import AboutUs from '~/pages/AboutUs';
import Blog from '~/pages/Blog';
import Collection from '~/pages/Collection';
import Cart from '../pages/Cart';
import Vouchers from '../pages/Vouchers';

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
        path: config.routes.drinkMenu,
        component: DrinkMenu,
    },
    {
        path: config.routes.aboutUs,
        component: AboutUs,
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
];

// private routes
const privateRoutes = [];

export { publicRoutes, privateRoutes };