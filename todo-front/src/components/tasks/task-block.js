import React, { useState } from 'react';

const TaskBlock = ({
    task: {
        id,
        taskName: name,
        taskDescription: text,
        endDate: date,
    }
}) => {

    const [isOpen, setIsOpen] = useState(false);

    const changeIsOpen = () => {
        setIsOpen(!isOpen);
    }

    return (
        <div className="task-block" onClick={changeIsOpen}>
            <div className="task-block__header">
                <div>{name}</div>
                {date !== null && date !== undefined ? <div>{date}</div> : null}
            </div>
            <div className={`task-block__content ${isOpen? "" : "task-block__content_minimized"}`}>
                <div>{text}</div>
                <div>{id}</div>
            </div>
        </div>
    )
};

export default TaskBlock;