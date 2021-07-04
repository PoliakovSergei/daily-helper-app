import React from 'react'
import ReactDOM from 'react-dom'
import App from "./components/app/app";
import {BrowserRouter} from "react-router-dom";
import store from './redux/store';
import {Provider} from "react-redux";

import "./styles/index.scss";

ReactDOM.render((
    <Provider store={store}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </Provider>
    ), document.getElementById('app')
);