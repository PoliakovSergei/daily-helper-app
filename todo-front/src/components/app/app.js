import React from 'react';
import Content from "./content";
import Menu from "./menu";
import Header from "./header";

const App = () => {
    return (
        <div>
            <Header />
            <Menu />
            <Content />
        </div>
    )
}

export default App;