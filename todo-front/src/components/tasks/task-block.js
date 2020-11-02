import React from 'react';

const TaskBlock = ({
    task: {
        id,
        taskName: name,
        taskDescription: text,
        endDate: date,
    }
}) => {
    return (
        <div className="task">
            <div>{name}</div>
            <div>{text}</div>
            <div>{id}</div>
            {date !== null && date !== undefined ? <div>{date}</div> : null}
        </div>
    )
};

export default TaskBlock;