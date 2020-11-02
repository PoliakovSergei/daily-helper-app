import {configureStore, getDefaultMiddleware} from '@reduxjs/toolkit';
import tasksReducer from "./reducer/tasks";
import logger from "redux-logger";

export default configureStore({
    reducer:  {
        tasks: tasksReducer,
    },
    middleware: [logger, ...getDefaultMiddleware()]
})