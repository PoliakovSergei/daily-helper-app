import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import { addTask } from "../../redux/reducer/tasks";

const AddTaskForm = () => {
    const [name, setName] = useState('');
    const [text, setText] = useState('');

    const dispatch = useDispatch();

    const onNameChange = e => setName(e.target.value);
    const onTextChange = e => setText(e.target.value);

    const onAddTaskClicked = () => {
        if (name && text) {
            dispatch(addTask(name, text))

            setName('');
            setText('');
        }
    }

    const canSave = Boolean(name) && Boolean(text);

    return (
        <div className="task-add-form">
            <h3>Add task</h3>
            <div className="task-add-form__description">
                <div className="task-add-form__description_col1">Название таски</div>
                <div className="task-add-form__description_col2">Описание таски</div>
            </div>
            <div className="task-add-form__input">
                <input
                    type="text"
                    id='taskName'
                    name='taskName'
                    value={name}
                    onChange={onNameChange}
                />
                <input
                    type="text"
                    id='taskText'
                    name='taskText'
                    value={text}
                    onChange={onTextChange}
                />
                <button
                    type='button'
                    onClick={onAddTaskClicked}
                    disabled={!canSave}
                >
                    Save
                </button>
            </div>
        </div>
    );
};

export default AddTaskForm;