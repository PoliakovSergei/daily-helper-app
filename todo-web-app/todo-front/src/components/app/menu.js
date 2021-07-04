import React from 'react';
import MenuTab from "./menu-tab";

const Menu = () => {
    return (
        <nav className="menu">
            <MenuTab link="/" name="Home" />
            <MenuTab link="/tasks" name="Tasks" />
        </nav>
    );
};

export default Menu;