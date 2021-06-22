import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { v4 as uuid } from 'uuid'
import AddTaskForm from "../tasks/add-task-form";
import TaskBlock from "../tasks/task-block";
import { fetchTasks } from "../../redux/reducer/tasks";

const TasksPage = ({
    fetchTasks,
    tasks,
    tasksStatus
}) => {

    useEffect(() => {
        if (tasksStatus === 'idle') {
            fetchTasks();
        }
    }, [tasksStatus])

    return (
        <div className="page page__tasks">
            <div style={{gridColumn: 4}}>
                <AddTaskForm />
            </div>
            <div style={{gridColumn: 2}}>
                {
                    (tasks !== null && tasks.length !== 0) ?
                        tasks.slice().reverse().map(task => (
                            <TaskBlock key={uuid()} task={task} />
                        )) : null
                }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        tasks: state.tasks.list,
        tasksStatus: state.tasks.status,
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchTasks: () => dispatch(fetchTasks())
    }
}
export default connect(
    mapStateToProps,
    mapDispatchToProps
)(TasksPage);