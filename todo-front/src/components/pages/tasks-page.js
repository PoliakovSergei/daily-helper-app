import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { v4 as uuid } from 'uuid'
import AddTaskForm from "../tasks/add-task-form";
import TaskBlock from "../tasks/task-block";
import {fetchTasks, selectAllTasks} from "../../redux/reducer/tasks";

const TasksPage = () => {
    const dispatch = useDispatch();
    const tasks = useSelector(selectAllTasks);
    const tasksStatus = useSelector(state => state.tasks.status);

    useEffect(() => {
        if (tasksStatus === 'idle') {
            dispatch(fetchTasks())
        }
    }, [tasksStatus, dispatch])

    return (
        <div className="page">
            <h1>Страница с задачами</h1>
            <AddTaskForm />
            {
                (tasks !== null && tasks.length !== 0) ?
                    tasks.slice().reverse().map(task => (
                        <TaskBlock key={uuid()} task={task} />
                    ))
                    : null
            }
        </div>
    )
}

export default TasksPage;