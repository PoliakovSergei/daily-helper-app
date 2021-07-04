import React from 'react';
import {Link} from "react-router-dom";

const MenuTab = ({ link, name }) => (
    <Link className="menu__menu-tab" to={link}>{name}</Link>
);

export default MenuTab;