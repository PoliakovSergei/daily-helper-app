import React, {useState} from 'react';
import Menu from "./menu";

const Sidebar = () => {

    const [isMinimized, setMinimized] = useState(true);

    const getClassList = () => {
        const classList = ["sidebar"];
        if (isMinimized) {
            classList.push("sidebar_minimized");
        }
        return classList.join(" ")
    }

    const applyMinimizedButton = () => {
        setMinimized(!isMinimized);
    }

    return (<div className={getClassList()}>
        <Menu/>
        <div className="sidebar__control-btns">
            <button className="sidebar__minimize-btn" onClick={applyMinimizedButton}>Minimize</button>
        </div>
    </div>)
}

export default Sidebar;