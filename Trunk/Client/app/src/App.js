import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { Fragment } from 'react';

import { DefaultLayout } from "./layouts";
import { publicRoutes } from '~/routes'
import Home from '~/pages/Home';
import Product from '~/pages/Product';
import DrinkMenu from '~/pages/DrinkMenu';
import AboutUs from './pages/AboutUs';
import Blog from './pages/Blog';
import Collection from './pages/Collection';


function App() {
  return (
    <Router>
      <div>
        <Routes>
          {publicRoutes.map((route, index) => {
            const Page = route.component;

            let Layout = DefaultLayout
            if (route.layout) {
              Layout = route.layout
            }
            else if (route.layout === null) {
              Layout = Fragment
            }

            return (
              <Route
                key={index}
                path={route.path}
                element={
                  <Layout>
                    <Page />
                  </Layout>}
              />
            )
          })}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
