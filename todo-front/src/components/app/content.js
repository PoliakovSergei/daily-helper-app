import React from 'react';
import {Redirect, Route, Switch} from "react-router-dom";
import HomePage from "../pages/home-page";
import TasksPage from "../pages/tasks-page";

const Content = () => {
    return (
        <Switch>
            <Route exact path='/' component={HomePage}/>
            <Route path='/tasks' component={TasksPage}/>
            <Redirect to="/" />
        </Switch>
    );
};

export default Content;
