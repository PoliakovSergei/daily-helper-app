import React, {useState} from 'react';
import { connect } from "react-redux";
import { addTask } from "../../redux/reducer/tasks";

const AddTaskForm = ({ addTask }) => {
    const [name, setName] = useState('');
    const [text, setText] = useState('');

    const onNameChange = e => setName(e.target.value);
    const onTextChange = e => setText(e.target.value);

    const onAddTaskClicked = () => {
        if (name && text) {
            addTask(name, text);
            setName('');
            setText('');
        }
    }

    const canSave = Boolean(name) && Boolean(text);

    return (
        <div className="task-add-form">
            <div className="task-add-form__header">Add task</div>
            <div className="task-add-form__task_name">
                <div className="task-add-form__task_name_col1">Название таски</div>
                <input
                    className="task-add-form__task_name_col2"
                    type="text"
                    id='taskName'
                    name='taskName'
                    value={name}
                    onChange={onNameChange}
                />
            </div>
            <div className="task-add-form__task_desc">
                <div className="task-add-form__task_desc_col1">Описание таски</div>
                <textarea
                    className="task-add-form__task_desc_col2"
                    id='taskText'
                    name='taskText'
                    value={text}
                    onChange={onTextChange}
                />
            </div>
            <div className="task-add-form__button">
                <button
                    type='button'
                    onClick={onAddTaskClicked}
                    disabled={!canSave}
                >
                    Add
                </button>
            </div>
        </div>
    );
};

const mapDispatchToProps = (dispatch) => {
    return {
        addTask: (name, text) => dispatch(addTask(name, text))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(AddTaskForm);