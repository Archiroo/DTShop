import config from '~/config';

import Home from '~/pages/Home';
import Product from '~/pages/Product';
import DrinkMenu from '~/pages/DrinkMenu';
import AboutUs from '~/pages/AboutUs';
import Blog from '~/pages/Blog';
import Collection from '~/pages/Collection';

// Publics routes
const publicRoutes = [
    {
        path: config.routes.home,
        component: Home,
        // layout: null  (không có layout)
    },
    {
        path: config.routes.product,
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
];

// private routes
const privateRoutes = [];

export { publicRoutes, privateRoutes };